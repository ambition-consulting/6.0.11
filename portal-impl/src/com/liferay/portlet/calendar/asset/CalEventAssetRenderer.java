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

package com.liferay.portlet.calendar.asset;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.permission.CalEventPermission;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Juan Fernández
 */
public class CalEventAssetRenderer extends BaseAssetRenderer {

	public CalEventAssetRenderer(CalEvent event){
		_event = event;
	}

	public long getClassPK() {
		return _event.getEventId();
	}

	public String getDiscussionPath() {
		if (PropsValues.CALENDAR_EVENT_COMMENTS_ENABLED) {
			return "edit_event_discussion";
		}
		else {
			return null;
		}
	}

	public long getGroupId() {
		return _event.getGroupId();
	}

	public String getSummary() {
		return _event.getTitle();
	}

	public String getTitle() {
		return _event.getTitle();
	}

	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		PortletURL editPortletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.CALENDAR);

		editPortletURL.setParameter(
			"struts_action", "/calendar/edit_event");
		editPortletURL.setParameter(
			"eventId", String.valueOf(_event.getEventId()));

		return editPortletURL;
	}

	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return themeDisplay.getPathMain() +
			"/calendar/find_event?eventId=" + _event.getEventId();
	}

	public long getUserId() {
		return _event.getUserId();
	}

	public String getUuid() {
		return _event.getUuid();
	}

	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		return CalEventPermission.contains(
			permissionChecker, _event, ActionKeys.UPDATE);
	}

	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		return CalEventPermission.contains(
			permissionChecker, _event, ActionKeys.VIEW);
	}

	public boolean isPrintable() {
		return true;
	}

	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String template)
		throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute(WebKeys.CALENDAR_EVENT, _event);

			return "/html/portlet/calendar/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/date.png";
	}

	private CalEvent _event;

}