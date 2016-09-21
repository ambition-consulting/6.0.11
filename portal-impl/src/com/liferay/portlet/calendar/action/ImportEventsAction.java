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

package com.liferay.portlet.calendar.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.calendar.ImportEventsException;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventServiceUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Bruno Farache
 * @author Juan Fernández
 */
public class ImportEventsAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				CalEvent.class.getName(), actionRequest);

			File file = uploadRequest.getFile("file");

			validate(file);

			CalEventServiceUtil.importICal4j(
				serviceContext.getScopeGroupId(), file);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (!(e instanceof ImportEventsException)) {
				_log.error(e, e);
			}

			SessionErrors.add(actionRequest, e.getClass().getName());

			setForward(actionRequest, "portlet.calendar.error");
		}
	}

	private void validate(File file) throws ImportEventsException {
		String fileNameExtension = FileUtil.getExtension(file.getName());

		if (!fileNameExtension.equals(CalendarUtil.ICAL_EXTENSION)) {
			throw new ImportEventsException();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExportEventsAction.class);

}