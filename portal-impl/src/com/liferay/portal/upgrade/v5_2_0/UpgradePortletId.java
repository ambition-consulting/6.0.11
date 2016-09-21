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

package com.liferay.portal.upgrade.v5_2_0;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradePortletId
	extends com.liferay.portal.upgrade.v4_3_5.UpgradePortletId {

	protected String[][] getPortletIdsArray() {
		return new String[][] {
			new String[] {
				"109",
				"1_WAR_webformportlet"
			},
			new String[] {
				"google_adsense_portlet_WAR_googleadsenseportlet",
				"1_WAR_googleadsenseportlet"
			},
			new String[] {
				"google_gadget_portlet_WAR_googlegadgetportlet",
				"1_WAR_googlegadgetportlet"
			},
			new String[] {
				"google_maps_portlet_WAR_googlemapsportlet",
				"1_WAR_googlemapsportlet"
			}
		};
	}

}