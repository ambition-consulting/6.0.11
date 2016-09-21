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

package com.liferay.portlet.communities.action;

import com.liferay.portal.LARFileException;
import com.liferay.portal.LARTypeException;
import com.liferay.portal.LayoutImportException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.LayoutServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class ImportPagesAction extends EditPagesAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			long groupId = ParamUtil.getLong(uploadRequest, "groupId");
			boolean privateLayout = ParamUtil.getBoolean(
				uploadRequest, "privateLayout");
			File file = uploadRequest.getFile("importFileName");

			if (!file.exists()) {
				throw new LARFileException("Import file does not exist");
			}

			LayoutServiceUtil.importLayouts(
				groupId, privateLayout, actionRequest.getParameterMap(), file);

			addSuccessMessage(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if ((e instanceof LARFileException) ||
				(e instanceof LARTypeException)) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				_log.error(e, e);

				SessionErrors.add(
					actionRequest, LayoutImportException.class.getName());
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ImportPagesAction.class);

}