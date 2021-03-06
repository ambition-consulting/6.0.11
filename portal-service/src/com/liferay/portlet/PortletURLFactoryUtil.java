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

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.LiferayPortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletURLFactoryUtil {

	public static LiferayPortletURL create(
		HttpServletRequest request, String portletName, long plid,
		String lifecycle) {

		return getPortletURLFactory().create(
			request, portletName, plid, lifecycle);
	}

	public static PortletURLFactory getPortletURLFactory() {
		return _portletURLFactory;
	}

	public void setPortletURLFactory(PortletURLFactory portletURLFactory) {
		_portletURLFactory = portletURLFactory;
	}

	private static PortletURLFactory _portletURLFactory;

}