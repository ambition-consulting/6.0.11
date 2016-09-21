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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.portlet.calendar.service.permission.CalEventPermission;
import com.liferay.portlet.calendar.service.permission.CalendarPermission;

import javax.portlet.PortletURL;

/**
 * @author Juan Fernández
 * @author Raymond Augé
 */
public class CalEventAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = CalEvent.class.getName();

	public static final String TYPE = "event";

	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		CalEvent event = CalEventLocalServiceUtil.getEvent(classPK);

		return new CalEventAssetRenderer(event);
	}

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType() {
		return TYPE;
	}

	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletURL addAssetURL = null;

		if (CalendarPermission.contains(
				themeDisplay.getPermissionChecker(),
				themeDisplay.getScopeGroupId(), ActionKeys.ADD_EVENT)) {

			addAssetURL = liferayPortletResponse.createRenderURL(
				PortletKeys.CALENDAR);

			addAssetURL.setParameter("struts_action", "/calendar/edit_event");
		}

		return addAssetURL;
	}

	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return CalEventPermission.contains(
			permissionChecker, classPK, actionId);
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/date.png";
	}

}