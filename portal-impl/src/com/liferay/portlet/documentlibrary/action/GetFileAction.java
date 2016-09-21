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

package com.liferay.portlet.documentlibrary.action;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.ActionConstants;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.DocumentConversionUtil;
import com.liferay.util.servlet.ServletResponseUtil;

import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 * @author Charles May
 * @author Bruno Farache
 */
public class GetFileAction extends PortletAction {

	public ActionForward strutsExecute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		try {
			long fileEntryId = ParamUtil.getLong(request, "fileEntryId");

			long folderId = ParamUtil.getLong(request, "folderId");
			String name = ParamUtil.getString(request, "name");
			String title = ParamUtil.getString(request, "title");
			String version = ParamUtil.getString(request, "version");

			long fileShortcutId = ParamUtil.getLong(request, "fileShortcutId");

			String uuid = ParamUtil.getString(request, "uuid");

			String targetExtension = ParamUtil.getString(
				request, "targetExtension");

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			long groupId = ParamUtil.getLong(
				request, "groupId", themeDisplay.getScopeGroupId());

			getFile(
				fileEntryId, folderId, name, title, version, fileShortcutId,
				uuid, groupId, targetExtension, themeDisplay, request,
				response);

			return null;
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);

			return null;
		}
	}

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");

			long folderId = ParamUtil.getLong(actionRequest, "folderId");
			String name = ParamUtil.getString(actionRequest, "name");
			String title = ParamUtil.getString(actionRequest, "title");
			String version = ParamUtil.getString(actionRequest, "version");

			long fileShortcutId = ParamUtil.getLong(
				actionRequest, "fileShortcutId");

			String uuid = ParamUtil.getString(actionRequest, "uuid");

			String targetExtension = ParamUtil.getString(
				actionRequest, "targetExtension");

			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long groupId = ParamUtil.getLong(
				actionRequest, "groupId", themeDisplay.getScopeGroupId());

			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				actionRequest);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(
				actionResponse);

			getFile(
				fileEntryId, folderId, name, title, version, fileShortcutId,
				uuid, groupId, targetExtension, themeDisplay, request,
				response);

			setForward(actionRequest, ActionConstants.COMMON_NULL);
		}
		catch (NoSuchFileEntryException nsfee) {
			PortalUtil.sendError(
				HttpServletResponse.SC_NOT_FOUND, nsfee, actionRequest,
				actionResponse);
		}
		catch (Exception e) {
			PortalUtil.sendError(e, actionRequest, actionResponse);
		}
	}

	protected void getFile(
			long fileEntryId, long folderId, String name, String title,
			String version, long fileShortcutId, String uuid, long groupId,
			String targetExtension, ThemeDisplay themeDisplay,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		if (name.startsWith("DLFE-")) {
			name = name.substring("DLFE-".length());
		}

		name = FileUtil.stripExtension(name);

		DLFileEntry fileEntry = null;

		if (Validator.isNotNull(uuid) && (groupId > 0)) {
			try {
				fileEntry = DLFileEntryServiceUtil.getFileEntryByUuidAndGroupId(
					uuid, groupId);

				folderId = fileEntry.getFolderId();
				name = fileEntry.getName();
			}
			catch (Exception e) {
			}
		}

		if (fileEntryId > 0) {
			fileEntry = DLFileEntryServiceUtil.getFileEntry(fileEntryId);
		}
		else if (fileShortcutId <= 0) {
			if (Validator.isNotNull(name)) {
				fileEntry = DLFileEntryServiceUtil.getFileEntry(
					groupId, folderId, name);

				title = fileEntry.getTitle();
			}
			else if (Validator.isNotNull(title)) {
				fileEntry = DLFileEntryServiceUtil.getFileEntryByTitle(
					groupId, folderId, title);

				name = fileEntry.getName();
			}
		}
		else {
			DLFileShortcut fileShortcut =
				DLFileShortcutServiceUtil.getFileShortcut(fileShortcutId);

			fileEntryId = fileShortcut.getToFileEntryId();

			fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
		}

		if (Validator.isNull(version)) {
			if (Validator.isNotNull(fileEntry.getVersion())) {
				version = fileEntry.getVersion();
			}
			else {
				throw new NoSuchFileEntryException();
			}
		}

		InputStream is = DLFileEntryLocalServiceUtil.getFileAsStream(
			themeDisplay.getCompanyId(), themeDisplay.getUserId(), groupId,
			folderId, name, version);

		boolean converted = false;

		String fileName = fileEntry.getTitle();

		if (Validator.isNotNull(targetExtension)) {
			String id = DocumentConversionUtil.getTempFileId(
				fileEntry.getFileEntryId(), version);

			String sourceExtension = FileUtil.getExtension(fileName);

			InputStream convertedIS = DocumentConversionUtil.convert(
				id, is, sourceExtension, targetExtension);

			if ((convertedIS != null) && (convertedIS != is)) {
				fileName = FileUtil.stripExtension(
					fileEntry.getTitle()).concat(StringPool.PERIOD).concat(
						targetExtension);

				is = convertedIS;

				converted = true;
			}
		}

		int contentLength = 0;

		if (!converted) {
			if (DLUtil.compareVersions(version, fileEntry.getVersion()) >= 0) {
				contentLength = (int)fileEntry.getSize();
			}
			else {
				DLFileVersion fileVersion = fileEntry.getFileVersion(version);

				contentLength = (int)fileVersion.getSize();
			}
		}

		String contentType = MimeTypesUtil.getContentType(fileName);

		ServletResponseUtil.sendFile(
			request, response, fileName, is, contentLength, contentType);
	}

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}