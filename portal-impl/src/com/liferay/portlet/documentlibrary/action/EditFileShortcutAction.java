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

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.documentlibrary.FileShortcutPermissionException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileShortcutException;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class EditFileShortcutAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateFileShortcut(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteFileShortcut(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchFileShortcutException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.document_library.error");
			}
			else if (e instanceof FileShortcutPermissionException ||
					 e instanceof NoSuchFileEntryException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getFileShortcut(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchFileShortcutException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.document_library.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(getForward(
			renderRequest, "portlet.document_library.edit_file_shortcut"));
	}

	protected void deleteFileShortcut(ActionRequest actionRequest)
		throws Exception {

		long fileShortcutId = ParamUtil.getLong(
			actionRequest, "fileShortcutId");

		DLFileShortcutServiceUtil.deleteFileShortcut(fileShortcutId);
	}

	protected void updateFileShortcut(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long fileShortcutId = ParamUtil.getLong(
			actionRequest, "fileShortcutId");

		long groupId = themeDisplay.getScopeGroupId();
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		long toFileEntryId = ParamUtil.getLong(actionRequest, "toFileEntryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DLFileShortcut.class.getName(), actionRequest);

		if (fileShortcutId <= 0) {

			// Add file shortcut

			DLFileShortcut fileShortcut =
				DLFileShortcutServiceUtil.addFileShortcut(
					groupId, folderId, toFileEntryId, serviceContext);

			AssetPublisherUtil.addAndStoreSelection(
				actionRequest, DLFileShortcut.class.getName(),
				fileShortcut.getFileShortcutId(), -1);
		}
		else {

			// Update file shortcut

			DLFileShortcutServiceUtil.updateFileShortcut(
				fileShortcutId, folderId, toFileEntryId, serviceContext);

			AssetPublisherUtil.addRecentFolderId(
				actionRequest, DLFileShortcut.class.getName(), folderId);
		}
	}

}