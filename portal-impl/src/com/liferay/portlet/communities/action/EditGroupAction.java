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

import com.liferay.portal.DuplicateGroupException;
import com.liferay.portal.GroupFriendlyURLException;
import com.liferay.portal.GroupNameException;
import com.liferay.portal.NoSuchGroupException;
import com.liferay.portal.RequiredGroupException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.liveusers.LiveUsers;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.model.MembershipRequestConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.MembershipRequestLocalServiceUtil;
import com.liferay.portal.service.MembershipRequestServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.communities.util.CommunitiesUtil;

import java.util.List;

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
public class EditGroupAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateGroup(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteGroup(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchGroupException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.communities.error");
			}
			else if (e instanceof DuplicateGroupException ||
					 e instanceof GroupFriendlyURLException ||
					 e instanceof GroupNameException ||
					 e instanceof RequiredGroupException) {

				SessionErrors.add(actionRequest, e.getClass().getName(), e);

				if (cmd.equals(Constants.DELETE)) {
					actionResponse.sendRedirect(
						ParamUtil.getString(actionRequest, "redirect"));
				}
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

		return mapping.findForward(
			getForward(renderRequest, "portlet.communities.edit_community"));
	}

	protected void deleteGroup(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		if ((groupId == themeDisplay.getDoAsGroupId()) ||
			(groupId == themeDisplay.getScopeGroupId())) {

			throw new RequiredGroupException(String.valueOf(groupId));
		}

		GroupServiceUtil.deleteGroup(groupId);

		LiveUsers.deleteGroup(themeDisplay.getCompanyId(), groupId);
	}

	protected void updateGroup(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long userId = PortalUtil.getUserId(actionRequest);

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		int type = ParamUtil.getInteger(actionRequest, "type");
		String friendlyURL = ParamUtil.getString(actionRequest, "friendlyURL");
		boolean active = ParamUtil.getBoolean(actionRequest, "active");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Group.class.getName(), actionRequest);

		Group group = null;

		if (groupId <= 0) {

			// Add group

			group = GroupServiceUtil.addGroup(
				name, description, type, friendlyURL, active, serviceContext);

			LiveUsers.joinGroup(
				themeDisplay.getCompanyId(), group.getGroupId(), userId);
		}
		else {

			// Update group

			group = GroupServiceUtil.updateGroup(
				groupId, name, description, type, friendlyURL, active,
				serviceContext);

			if (type == GroupConstants.TYPE_COMMUNITY_OPEN) {
				List<MembershipRequest> membershipRequests =
					MembershipRequestLocalServiceUtil.search(
						groupId, MembershipRequestConstants.STATUS_PENDING,
						QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				for (MembershipRequest membershipRequest : membershipRequests) {
					MembershipRequestServiceUtil.updateStatus(
						membershipRequest.getMembershipRequestId(),
						themeDisplay.translate(
							"your-membership-has-been-approved"),
						MembershipRequestConstants.STATUS_APPROVED);

					LiveUsers.joinGroup(
						themeDisplay.getCompanyId(),
						membershipRequest.getGroupId(),
						new long[] {membershipRequest.getUserId()});
				}
			}
		}

		// Layout set prototypes

		long publicLayoutSetPrototypeId = ParamUtil.getLong(
			actionRequest, "publicLayoutSetPrototypeId");
		long privateLayoutSetPrototypeId = ParamUtil.getLong(
			actionRequest, "privateLayoutSetPrototypeId");

		CommunitiesUtil.applyLayoutSetPrototypes(
			group, publicLayoutSetPrototypeId, privateLayoutSetPrototypeId);
	}

}