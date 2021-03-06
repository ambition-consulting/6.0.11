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

package com.liferay.portlet.wiki.model.impl;

import com.liferay.documentlibrary.NoSuchDirectoryException;
import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class WikiPageImpl extends WikiPageModelImpl implements WikiPage {

	public WikiPageImpl() {
	}

	public String getAttachmentsDir() {
		if (_attachmentDirs == null) {
			_attachmentDirs = "wiki/" + getResourcePrimKey();
		}

		return _attachmentDirs;
	}

	public String[] getAttachmentsFiles()
		throws PortalException, SystemException {

		String[] fileNames = new String[0];

		try {
			fileNames = DLLocalServiceUtil.getFileNames(
				getCompanyId(), CompanyConstants.SYSTEM, getAttachmentsDir());
		}
		catch (NoSuchDirectoryException nsde) {
		}

		return fileNames;
	}

	public List<WikiPage> getChildPages() {
		List<WikiPage> pages = null;

		try {
			pages = WikiPageLocalServiceUtil.getChildren(
				getNodeId(), true, getTitle());
		}
		catch (Exception e) {
			pages = new ArrayList<WikiPage>();

			_log.error(e);
		}

		return pages;
	}

	public WikiNode getNode() {
		WikiNode node = null;

		try {
			node = WikiNodeLocalServiceUtil.getNode(getNodeId());
		}
		catch (Exception e) {
			node = new WikiNodeImpl();

			_log.error(e);
		}

		return node;
	}

	public WikiPage getParentPage() {
		if (Validator.isNull(getParentTitle())) {
			return null;
		}

		WikiPage page = null;

		try {
			page = WikiPageLocalServiceUtil.getPage(
				getNodeId(), getParentTitle());
		}
		catch (Exception e) {
			_log.error(e);
		}

		return page;
	}

	public List<WikiPage> getParentPages() {
		List<WikiPage> parentPages = new ArrayList<WikiPage>();

		WikiPage parentPage = getParentPage();

		if (parentPage != null) {
			parentPages.addAll(parentPage.getParentPages());
			parentPages.add(parentPage);
		}

		return parentPages;
	}

	public WikiPage getRedirectPage() {
		if (Validator.isNull(getRedirectTitle())) {
			return null;
		}

		WikiPage page = null;

		try {
			page = WikiPageLocalServiceUtil.getPage(
				getNodeId(), getRedirectTitle());
		}
		catch (Exception e) {
			_log.error(e);
		}

		return page;
	}

	public void setAttachmentsDir(String attachmentsDir) {
		_attachmentDirs = attachmentsDir;
	}

	private static Log _log = LogFactoryUtil.getLog(WikiPageImpl.class);

	private String _attachmentDirs;

}