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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.LayoutSet;

/**
 * @author David Truong
 */
public class RobotsUtil {

	public static String getDefaultRobots() {
		return getDefaultRobots(null);
	}

	public static String getDefaultRobots(String virtualHost) {
		if (Validator.isNotNull(virtualHost)) {
			return _DEFAULT_ROBOTS_TXT.replace(
				"$HOSTS$", virtualHost);
		}

		return _DEFAULT_ROBOTS_TXT_WITHOUT_SITEMAP;
	}

	public static String getRobots(LayoutSet layoutSet) {
		if (layoutSet != null) {
			return GetterUtil.get(
				layoutSet.getSettingsProperty(
					layoutSet.getPrivateLayout() + "-robots.txt"),
					getDefaultRobots(layoutSet.getVirtualHost()));
		}

		return getDefaultRobots(null);
	}

	private static String _DEFAULT_ROBOTS_TXT =
		"User-Agent: *\nDisallow:\nSitemap: http://$HOSTS$/sitemap.xml";

	private static String _DEFAULT_ROBOTS_TXT_WITHOUT_SITEMAP =
		"User-Agent: *\nDisallow:";

}