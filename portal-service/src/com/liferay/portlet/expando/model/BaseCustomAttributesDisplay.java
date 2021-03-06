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

package com.liferay.portlet.expando.model;

import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author Jorge Ferrer
 */
public abstract class BaseCustomAttributesDisplay
	implements CustomAttributesDisplay {

	public long getClassNameId() {
		return _classNameId;
	}

	public String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/page.png";
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	private long _classNameId;
	private String _portletId;

}