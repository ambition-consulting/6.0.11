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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.model.PortletPreferencesIds;
import com.liferay.portal.model.Team;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutServiceUtil;
import com.liferay.portal.service.MembershipRequestLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.TeamLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionUtil
	extends com.liferay.portlet.enterpriseadmin.action.ActionUtil {

	public static void copyLookAndFeel(
			Layout targetLayout, Layout sourceLayout)
		throws Exception {

		LayoutServiceUtil.updateLookAndFeel(
			targetLayout.getGroupId(), targetLayout.isPrivateLayout(),
			targetLayout.getLayoutId(),	sourceLayout.getThemeId(),
			sourceLayout.getColorSchemeId(), sourceLayout.getCss(), false);

		LayoutServiceUtil.updateLookAndFeel(
			targetLayout.getGroupId(), targetLayout.isPrivateLayout(),
			targetLayout.getLayoutId(),	sourceLayout.getWapThemeId(),
			sourceLayout.getWapColorSchemeId(),	sourceLayout.getCss(), true);
	}

	public static void copyPreferences(
			HttpServletRequest request, Layout targetLayout,
			Layout sourceLayout)
		throws Exception {

		long companyId = targetLayout.getCompanyId();

		LayoutTypePortlet sourceLayoutTypePortlet =
			(LayoutTypePortlet)sourceLayout.getLayoutType();

		List<String> sourcePortletIds = sourceLayoutTypePortlet.getPortletIds();

		for (String sourcePortletId : sourcePortletIds) {

			// Copy preference

			PortletPreferencesIds portletPreferencesIds =
				PortletPreferencesFactoryUtil.getPortletPreferencesIds(
					request, targetLayout, sourcePortletId);

			PortletPreferencesLocalServiceUtil.getPreferences(
				portletPreferencesIds);

			PortletPreferencesIds sourcePortletPreferencesIds =
				PortletPreferencesFactoryUtil.getPortletPreferencesIds(
					request, sourceLayout, sourcePortletId);

			PortletPreferences sourcePreferences =
				PortletPreferencesLocalServiceUtil.getPreferences(
					sourcePortletPreferencesIds);

			PortletPreferencesLocalServiceUtil.updatePreferences(
				portletPreferencesIds.getOwnerId(),
				portletPreferencesIds.getOwnerType(),
				portletPreferencesIds.getPlid(),
				portletPreferencesIds.getPortletId(), sourcePreferences);

			// Copy portlet setup

			PortletPreferencesLocalServiceUtil.getPreferences(
				companyId, PortletKeys.PREFS_OWNER_ID_DEFAULT,
				PortletKeys.PREFS_OWNER_TYPE_LAYOUT, targetLayout.getPlid(),
				sourcePortletId);

			sourcePreferences =
				PortletPreferencesLocalServiceUtil.getPreferences(
					companyId, PortletKeys.PREFS_OWNER_ID_DEFAULT,
					PortletKeys.PREFS_OWNER_TYPE_LAYOUT, sourceLayout.getPlid(),
					sourcePortletId);

			PortletPreferencesLocalServiceUtil.updatePreferences(
				PortletKeys.PREFS_OWNER_ID_DEFAULT,
				PortletKeys.PREFS_OWNER_TYPE_LAYOUT, targetLayout.getPlid(),
				sourcePortletId, sourcePreferences);
		}
	}

	public static void copyPreferences(
			PortletRequest portletRequest, Layout targetLayout,
			Layout sourceLayout)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		copyPreferences(request, targetLayout, sourceLayout);
	}

	public static Group getGroup(HttpServletRequest request) throws Exception {
		long groupId = ParamUtil.getLong(request, "groupId");

		Group group = null;

		if (groupId > 0) {
			group = GroupLocalServiceUtil.getGroup(groupId);
		}

		request.setAttribute(WebKeys.GROUP, group);

		return group;
	}

	public static Group getGroup(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		return getGroup(request);
	}

	public static void getMembershipRequest(HttpServletRequest request)
		throws Exception {

		long membershipRequestId = ParamUtil.getLong(
			request, "membershipRequestId");

		MembershipRequest membershipRequest = null;

		if (membershipRequestId > 0) {
			membershipRequest =
				MembershipRequestLocalServiceUtil.getMembershipRequest(
					membershipRequestId);
		}

		request.setAttribute(WebKeys.MEMBERSHIP_REQUEST, membershipRequest);
	}

	public static void getMembershipRequest(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		getMembershipRequest(request);
	}

	public static void getTeam(HttpServletRequest request)
		throws Exception {

		long teamId = ParamUtil.getLong(request, "teamId");

		Team team = null;

		if (teamId > 0) {
			team = TeamLocalServiceUtil.getTeam(teamId);
		}

		request.setAttribute(WebKeys.TEAM, team);
	}

	public static void getTeam(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		getTeam(request);
	}

}