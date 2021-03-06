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

package com.liferay.taglib.portletext;

import com.liferay.portal.kernel.servlet.taglib.FileAvailabilityUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.taglib.ui.IconTag;

/**
 * @author Bruno Farache
 * @author Shuyang Zhou
 */
public class IconRefreshTag extends IconTag {

	protected String getPage() {
		if (FileAvailabilityUtil.isAvailable(getServletContext(), _PAGE)) {
			return _PAGE;
		}

		PortletDisplay portletDisplay =
			(PortletDisplay)pageContext.getAttribute("portletDisplay");

		if (!portletDisplay.isShowRefreshIcon()) {
			return null;
		}

		setCssClass("portlet-refresh portlet-refresh-icon");
		setImage("../portlet/refresh");
		setMessage("refresh");
		setToolTip(false);
		setUrl(portletDisplay.getURLRefresh());

		return super.getPage();
	}

	private static final String _PAGE =
		"/html/taglib/portlet/icon_refresh/page.jsp";

}