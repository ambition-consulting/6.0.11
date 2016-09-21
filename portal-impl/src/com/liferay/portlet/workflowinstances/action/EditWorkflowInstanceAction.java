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

package com.liferay.portlet.workflowinstances.action;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;

import java.io.Serializable;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Marcellus Tavares
 */
public class EditWorkflowInstanceAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteInstance(actionRequest);
			}
			else if (cmd.equals(Constants.SIGNAL)) {
				signalInstance(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException ||
				e instanceof WorkflowException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.workflow_instances.error");
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
			ActionUtil.getWorkflowInstance(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof WorkflowException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.workflow_instances.error");
			}
			else {
				throw e;
			}
		}

		String forward = getForward(
			renderRequest, "portlet.workflow_instances.edit_workflow_instance");

		return mapping.findForward(forward);
	}

	protected void deleteInstance(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long workflowInstanceId = ParamUtil.getLong(
			actionRequest, "workflowInstanceId");

		WorkflowInstance workflowInstance =
			WorkflowInstanceManagerUtil.getWorkflowInstance(
				themeDisplay.getCompanyId(), workflowInstanceId);

		Map<String, Serializable> workflowContext =
			workflowInstance.getWorkflowContext();

		long companyId = GetterUtil.getLong(
			workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
		long groupId = GetterUtil.getLong(
			workflowContext.get(WorkflowConstants.CONTEXT_GROUP_ID));
		String className =  GetterUtil.getString(
			workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME));
		long classPK = GetterUtil.getLong(
			workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		WorkflowHandler workflowHandler =
			WorkflowHandlerRegistryUtil.getWorkflowHandler(className);

		workflowHandler.updateStatus(
				WorkflowConstants.STATUS_DRAFT, workflowContext);

		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLink(
			companyId, groupId, className, classPK);
	}

	protected void signalInstance(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long workflowInstanceId = ParamUtil.getLong(
			actionRequest, "workflowInstanceId");

		String transitionName = ParamUtil.getString(
			actionRequest, "transitionName");

		WorkflowInstanceManagerUtil.signalWorkflowInstance(
			themeDisplay.getCompanyId(), themeDisplay.getUserId(),
			workflowInstanceId, transitionName, null);
	}

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}