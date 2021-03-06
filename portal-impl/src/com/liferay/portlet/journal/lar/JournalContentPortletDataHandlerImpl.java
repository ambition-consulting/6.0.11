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

package com.liferay.portlet.journal.lar;

import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.PortletDataHandlerControl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.documentlibrary.lar.DLPortletDataHandlerImpl;
import com.liferay.portlet.imagegallery.lar.IGPortletDataHandlerImpl;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;

/**
 * <p>
 * Provides the Journal Content portlet export and import functionality, which
 * is to clone the article, structure, and template referenced in the Journal
 * Content portlet if the article is associated with the layout's group. Upon
 * import, a new instance of the corresponding article, structure, and template
 * will be created or updated. The author of the newly created objects are
 * determined by the JournalCreationStrategy class defined in
 * <i>portal.properties</i>.
 * </p>
 *
 * <p>
 * This <code>PortletDataHandler</code> differs from from
 * <code>JournalPortletDataHandlerImpl</code> in that it only exports articles
 * referenced in Journal Content portlets. Articles not displayed in Journal
 * Content portlets will not be exported unless
 * <code>JournalPortletDataHandlerImpl</code> is activated.
 * </p>
 *
 * @author Joel Kozikowski
 * @author Raymond Augé
 * @author Bruno Farache
 * @see	   com.liferay.portal.kernel.lar.PortletDataHandler
 * @see	   com.liferay.portlet.journal.lar.JournalCreationStrategy
 * @see	   com.liferay.portlet.journal.lar.JournalPortletDataHandlerImpl
 */
public class JournalContentPortletDataHandlerImpl
	extends BasePortletDataHandler {

	public PortletDataHandlerControl[] getExportControls() {
		return new PortletDataHandlerControl[] {
			_selectedArticles, _embeddedAssets, _images, _comments, _ratings,
			_tags
		};
	}

	public PortletDataHandlerControl[] getImportControls() {
		return new PortletDataHandlerControl[] {
			_selectedArticles, _images, _comments, _ratings, _tags
		};
	}

	public boolean isPublishToLiveByDefault() {
		return 	_PUBLISH_TO_LIVE_BY_DEFAULT;
	}

	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		portletPreferences.setValue("group-id", StringPool.BLANK);
		portletPreferences.setValue("article-id", StringPool.BLANK);

		return portletPreferences;
	}

	protected String doExportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		portletDataContext.addPermissions(
			"com.liferay.portlet.journal",
			portletDataContext.getScopeGroupId());

		String articleId = portletPreferences.getValue("article-id", null);

		if (articleId == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No article id found in preferences of portlet " +
						portletId);
			}

			return StringPool.BLANK;
		}

		long articleGroupId = GetterUtil.getLong(
			portletPreferences.getValue("group-id", StringPool.BLANK));

		if (articleGroupId <= 0) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No group id found in preferences of portlet " + portletId);
			}

			return StringPool.BLANK;
		}

		JournalArticle article = null;

		try {
			article = JournalArticleLocalServiceUtil.getLatestArticle(
				articleGroupId, articleId, WorkflowConstants.STATUS_APPROVED);
		}
		catch (NoSuchArticleException nsae) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No approved article found with group id " +
						articleGroupId + " and article id " + articleId);
			}
		}

		if (article == null) {
			return StringPool.BLANK;
		}

		Document document = SAXReaderUtil.createDocument();

		Element rootElement = document.addElement("journal-content-data");

		String path = JournalPortletDataHandlerImpl.getArticlePath(
			portletDataContext, article);

		Element articleElement = rootElement.addElement("article");

		articleElement.addAttribute("path", path);

		Element dlFoldersElement = rootElement.addElement("dl-folders");
		Element dlFilesElement = rootElement.addElement("dl-file-entries");
		Element dlFileRanksElement = rootElement.addElement("dl-file-ranks");
		Element igFoldersElement = rootElement.addElement("ig-folders");
		Element igImagesElement = rootElement.addElement("ig-images");

		JournalPortletDataHandlerImpl.exportArticle(
			portletDataContext, rootElement, rootElement, rootElement,
			dlFoldersElement, dlFilesElement, dlFileRanksElement,
			igFoldersElement, igImagesElement, article, false);

		return document.formattedString();
	}

	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
		throws Exception {

		portletDataContext.importPermissions(
			"com.liferay.portlet.journal",
			portletDataContext.getSourceGroupId(),
			portletDataContext.getScopeGroupId());

		if (Validator.isNull(data)) {
			return null;
		}

		Document document = SAXReaderUtil.read(data);

		Element rootElement = document.getRootElement();

		Element dlFoldersElement = rootElement.element("dl-folders");

		List<Element> dlFolderElements = Collections.EMPTY_LIST;

		if (dlFoldersElement != null) {
			dlFolderElements = dlFoldersElement.elements("folder");
		}

		for (Element folderElement : dlFolderElements) {
			DLPortletDataHandlerImpl.importFolder(
				portletDataContext, folderElement);
		}

		Element dlFileEntriesElement = rootElement.element("dl-file-entries");

		List<Element> dlFileEntryElements = Collections.EMPTY_LIST;

		if (dlFileEntriesElement != null) {
			dlFileEntryElements = dlFileEntriesElement.elements("file-entry");
		}

		for (Element fileEntryElement : dlFileEntryElements) {
			DLPortletDataHandlerImpl.importFileEntry(
				portletDataContext, fileEntryElement);
		}

		Element dlFileRanksElement = rootElement.element("dl-file-ranks");

		List<Element> dlFileRankElements = Collections.EMPTY_LIST;

		if (dlFileRanksElement != null) {
			dlFileRankElements = dlFileRanksElement.elements("file-rank");
		}

		for (Element fileRankElement : dlFileRankElements) {
			DLPortletDataHandlerImpl.importFileRank(
				portletDataContext, fileRankElement);
		}

		Element igFoldersElement = rootElement.element("ig-folders");

		List<Element> igFolderElements = Collections.EMPTY_LIST;

		if (igFoldersElement != null) {
			igFolderElements = igFoldersElement.elements("folder");
		}

		for (Element folderElement : igFolderElements) {
			IGPortletDataHandlerImpl.importFolder(
				portletDataContext, folderElement);
		}

		Element igImagesElement = rootElement.element("ig-images");

		List<Element> igImageElements = Collections.EMPTY_LIST;

		if (igImagesElement != null) {
			igImageElements = igImagesElement.elements("image");
		}

		for (Element imageElement : igImageElements) {
			IGPortletDataHandlerImpl.importImage(
				portletDataContext, imageElement);
		}

		Element structureElement = rootElement.element("structure");

		if (structureElement != null) {
			JournalPortletDataHandlerImpl.importStructure(
				portletDataContext, structureElement);
		}

		Element templateElement = rootElement.element("template");

		if (templateElement != null) {
			JournalPortletDataHandlerImpl.importTemplate(
				portletDataContext, templateElement);
		}

		Element articleElement = rootElement.element("article");

		if (articleElement != null) {
			JournalPortletDataHandlerImpl.importArticle(
				portletDataContext, articleElement);
		}

		String articleId = portletPreferences.getValue("article-id", null);

		if (Validator.isNotNull(articleId)) {
			Map<String, String> articleIds =
				(Map<String, String>)portletDataContext.getNewPrimaryKeysMap(
					JournalArticle.class);

			articleId = MapUtil.getString(articleIds, articleId, articleId);

			portletPreferences.setValue(
				"group-id",
				String.valueOf(portletDataContext.getScopeGroupId()));
			portletPreferences.setValue("article-id", articleId);

			Layout layout = LayoutLocalServiceUtil.getLayout(
				portletDataContext.getPlid());

			JournalContentSearchLocalServiceUtil.updateContentSearch(
				portletDataContext.getScopeGroupId(), layout.isPrivateLayout(),
				layout.getLayoutId(), portletId, articleId, true);
		}

		String templateId = portletPreferences.getValue("template-id", null);

		if (Validator.isNotNull(templateId)) {
			Map<String, String> templateIds =
				(Map<String, String>)portletDataContext.getNewPrimaryKeysMap(
					JournalTemplate.class);

			templateId = MapUtil.getString(templateIds, templateId, templateId);

			portletPreferences.setValue("template-id", templateId);
		}

		return portletPreferences;
	}

	private static final String _NAMESPACE = "journal";

	private static final boolean _PUBLISH_TO_LIVE_BY_DEFAULT = true;

	private static PortletDataHandlerBoolean _comments =
		new PortletDataHandlerBoolean(_NAMESPACE, "comments");

	private static PortletDataHandlerBoolean _embeddedAssets =
		new PortletDataHandlerBoolean(_NAMESPACE, "embedded-assets");

	private static PortletDataHandlerBoolean _images =
		new PortletDataHandlerBoolean(_NAMESPACE, "images");

	private static Log _log = LogFactoryUtil.getLog(
		JournalContentPortletDataHandlerImpl.class);

	private static PortletDataHandlerBoolean _ratings =
		new PortletDataHandlerBoolean(_NAMESPACE, "ratings");

	private static PortletDataHandlerBoolean _selectedArticles =
		new PortletDataHandlerBoolean(
			_NAMESPACE, "selected-web-content", true, true);

	private static PortletDataHandlerBoolean _tags =
		new PortletDataHandlerBoolean(_NAMESPACE, "tags");

}