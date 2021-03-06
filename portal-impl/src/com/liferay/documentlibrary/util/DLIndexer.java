/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.documentlibrary.util;

import com.liferay.documentlibrary.model.FileModel;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeIndexerUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;

import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 * @author Harry Mark
 * @author Bruno Farache
 * @author Raymond Augé
 */
public class DLIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {FileModel.class.getName()};

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public Summary getSummary(
		Document document, String snippet, PortletURL portletURL) {

		return null;
	}

	protected void doDelete(Object obj) throws Exception {
		FileModel fileModel = (FileModel)obj;

		Document document = new DocumentImpl();

		document.addUID(
			fileModel.getPortletId(), fileModel.getRepositoryId(),
			fileModel.getFileName());

		SearchEngineUtil.deleteDocument(
			fileModel.getCompanyId(), document.get(Field.UID));
	}

	protected Document doGetDocument(Object obj) throws Exception {
		FileModel fileModel = (FileModel)obj;

		long companyId = fileModel.getCompanyId();
		String portletId = fileModel.getPortletId();
		long groupId = getParentGroupId(fileModel.getGroupId());
		long scopeGroupId = fileModel.getGroupId();
		long userId = fileModel.getUserId();
		long folderId = DLFileEntryImpl.getFolderId(
			scopeGroupId, fileModel.getRepositoryId());
		long repositoryId = fileModel.getRepositoryId();
		String fileName = fileModel.getFileName();
		long fileEntryId = fileModel.getFileEntryId();
		String properties = fileModel.getProperties();
		Date modifiedDate = fileModel.getModifiedDate();
		long[] assetCategoryIds = fileModel.getAssetCategoryIds();
		String[] assetCategoryNames = fileModel.getAssetCategoryNames();
		String[] assetTagNames = fileModel.getAssetTagNames();

		DLFileEntry fileEntry = null;

		try {
			if (fileEntryId > 0) {
				fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(
					fileEntryId);
			}
			else {
				fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(
					scopeGroupId, folderId, fileName);
			}
		}
		catch (NoSuchFileEntryException nsfe) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Not indexing document " + companyId + " " + portletId +
						" " + scopeGroupId + " " + repositoryId + " " +
							fileName + " " + fileEntryId);
			}

			return null;
		}

		if (userId == 0) {
			userId = fileEntry.getUserId();
		}

		String extension = fileEntry.getExtension();
		String title = fileEntry.getTitle();
		String description = fileEntry.getDescription();

		if (properties == null) {
			properties = fileEntry.getLuceneProperties();
		}

		if (modifiedDate == null) {
			modifiedDate = fileEntry.getModifiedDate();
		}

		if (assetCategoryIds == null) {
			assetCategoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(
				DLFileEntry.class.getName(), fileEntry.getFileEntryId());
		}

		if (assetTagNames == null) {
			assetTagNames = AssetTagLocalServiceUtil.getTagNames(
				DLFileEntry.class.getName(), fileEntry.getFileEntryId());
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Indexing document " + companyId + " " + portletId + " " +
					scopeGroupId + " " + repositoryId + " " + fileName + " " +
						fileEntry.getFileEntryId());
		}

		boolean indexContent = true;

		InputStream is = null;

		try {
			Hook hook = HookFactory.getInstance();

			if (PropsValues.DL_FILE_INDEXING_MAX_SIZE == 0) {
				indexContent = false;
			}
			else if (PropsValues.DL_FILE_INDEXING_MAX_SIZE != -1) {
				long size = hook.getFileSize(companyId, repositoryId, fileName);

				if (size > PropsValues.DL_FILE_INDEXING_MAX_SIZE) {
					indexContent = false;
				}
			}

			if (indexContent) {
				String extensionWithPeriod = StringPool.PERIOD + extension;

				String[] ignoreExtensions = PrefsPropsUtil.getStringArray(
					PropsKeys.DL_FILE_INDEXING_IGNORE_EXTENSIONS,
					StringPool.COMMA);

				if (ArrayUtil.contains(ignoreExtensions, extensionWithPeriod)) {
					indexContent = false;
				}
			}

			if (indexContent) {
				is = hook.getFileAsStream(companyId, repositoryId, fileName);
			}
		}
		catch (Exception e) {
		}

		if (indexContent && (is == null)) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Document " + companyId + " " + portletId + " " +
						scopeGroupId + " " + repositoryId + " " + fileName +
							" " + fileEntry.getFileEntryId() + " does not " +
								"have any content");
			}

			return null;
		}

		Document document = new DocumentImpl();

		document.addUID(portletId, repositoryId, fileName);

		document.addModifiedDate(modifiedDate);

		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.PORTLET_ID, portletId);
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addKeyword(Field.USER_ID, userId);

		document.addText(Field.TITLE, title);

		if (indexContent) {
			try {
				document.addFile(Field.CONTENT, is, fileEntry.getTitle());
			}
			catch (IOException ioe) {
				throw new SearchException(
					"Cannot extract text from file" + companyId + " " +
						portletId +	" " + scopeGroupId + " " + repositoryId +
						" " + fileName);
			}
		}

		document.addText(Field.DESCRIPTION, description);
		document.addText(Field.PROPERTIES, properties);
		document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
		document.addKeyword(Field.ASSET_CATEGORY_NAMES, assetCategoryNames);
		document.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);

		document.addKeyword(Field.FOLDER_ID, folderId);
		document.addKeyword(
			Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());
		document.addKeyword(Field.ENTRY_CLASS_PK, fileEntry.getFileEntryId());

		document.addKeyword("repositoryId", repositoryId);
		document.addKeyword("path", fileName);
		document.addKeyword("extension", extension);

		DLFileVersion fileVersion = fileEntry.getFileVersion();

		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(
			companyId, DLFileEntry.class.getName(),
			fileVersion.getFileVersionId());

		ExpandoBridgeIndexerUtil.addAttributes(document, expandoBridge);

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Document " + companyId + " " + portletId + " " +
					scopeGroupId + " " + repositoryId + " " + fileName + " " +
						fileEntry.getFileEntryId() + " indexed successfully");
		}

		return document;
	}

	protected void doReindex(Object obj) throws Exception {
		FileModel fileModel = (FileModel)obj;

		Document document = getDocument(fileModel);

		if (document != null) {
			SearchEngineUtil.updateDocument(fileModel.getCompanyId(), document);
		}
	}

	protected void doReindex(String className, long classPK) throws Exception {
	}

	protected void doReindex(String[] ids) throws Exception {
		Hook hook = HookFactory.getInstance();

		hook.reindex(ids);
	}

	protected String getPortletId(SearchContext searchContext) {
		return (String)searchContext.getAttribute("portletId");
	}

	private static Log _log = LogFactoryUtil.getLog(DLIndexer.class);

}