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

import com.liferay.portal.MembershipRequestCommentsException;
import com.liferay.portal.NoSuchGroupException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.liveusers.LiveUsers;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.model.MembershipRequestConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.MembershipRequestServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

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
 */
public class ReplyMembershipRequestAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long membershipRequestId = ParamUtil.getLong(
				actionRequest, "membershipRequestId");

			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			String replyComments = ParamUtil.getString(
				actionRequest, "replyComments");

			MembershipRequest membershipRequest =
				MembershipRequestServiceUtil.getMembershipRequest(
					membershipRequestId);

			MembershipRequestServiceUtil.updateStatus(
				membershipRequestId, replyComments, statusId);

			if (statusId == MembershipRequestConstants.STATUS_APPROVED) {
				LiveUsers.joinGroup(
					themeDisplay.getCompanyId(),
					membershipRequest.getGroupId(),
					new long[] {membershipRequest.getUserId()});
			}

			SessionMessages.add(actionRequest, "membership_reply_sent");

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchGroupException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.communities.error");
			}
			else if (e instanceof MembershipRequestCommentsException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(
					actionRequest,
					"portlet.communities.reply_membership_request");
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
			ActionUtil.getGroup(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchGroupException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.communities.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(getForward(
			renderRequest, "portlet.communities.reply_membership_request"));
	}

}