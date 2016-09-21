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

package com.liferay.portlet.polls;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * @author Sergio González
 */
public class PollsControlPanelEntry extends BaseControlPanelEntry {

	public boolean isVisible(
			Portlet portlet, String category, ThemeDisplay themeDisplay)
		throws Exception {

		Group group = themeDisplay.getScopeGroup();

		if (!group.isCompany()) {
			return super.isVisible(portlet, category, themeDisplay);
		}
		else {
			return false;
		}
	}

	public boolean isVisible(
			PermissionChecker permissionChecker, Portlet portlet)
		throws Exception {

		return false;
	}

}