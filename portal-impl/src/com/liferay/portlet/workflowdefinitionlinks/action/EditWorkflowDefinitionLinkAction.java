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

package com.liferay.portlet.workflowdefinitionlinks.action;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Jorge Ferrer
 * @author Bruno Farache
 * @author Juan Fernández
 */
public class EditWorkflowDefinitionLinkAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			updateWorkflowDefinitionLinks(actionRequest);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof WorkflowException) {
				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(
					actionRequest, "portlet.workflow_definition_links.error");
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

		return mapping.findForward(getForward(
			renderRequest, "portlet.workflow_definition_links.view"));
	}

	protected void updateWorkflowDefinitionLink(
			ActionRequest actionRequest, String className, String value)
		throws Exception {

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (Validator.isNull(value)) {
			WorkflowDefinitionLinkLocalServiceUtil.deleteWorkflowDefinitionLink(
				themeDisplay.getCompanyId(), groupId, className);
		}
		else {
			String[] values = StringUtil.split(value, StringPool.AT);

			String workflowDefinitionName = values[0];
			int workflowDefinitionVersion = GetterUtil.getInteger(
				values[1]);

			WorkflowDefinitionLinkLocalServiceUtil.updateWorkflowDefinitionLink(
				themeDisplay.getUserId(), themeDisplay.getCompanyId(),
				groupId, className, workflowDefinitionName,
				workflowDefinitionVersion);
		}
	}

	protected void updateWorkflowDefinitionLinks(ActionRequest actionRequest)
		throws Exception {

		Enumeration<String> enu = actionRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();

			if (!name.startsWith(_PREFIX)) {
				continue;
			}

			String className = name.substring(_PREFIX.length(), name.length());
			String value = ParamUtil.getString(actionRequest, name);

			updateWorkflowDefinitionLink(actionRequest, className, value);
		}
	}

	private static final String _PREFIX = "workflowDefinitionName@";

}