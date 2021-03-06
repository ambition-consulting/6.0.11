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

package com.liferay.portal.upgrade.v5_1_0;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.upgrade.BaseUpgradePortletPreferences;
import com.liferay.portlet.PortletPreferencesImpl;
import com.liferay.portlet.PortletPreferencesSerializer;

/**
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 */
public class UpgradeSitemap extends BaseUpgradePortletPreferences {

	protected String getUpdatePortletPreferencesWhereClause() {
		return "portletId like '85_%'";
	}

	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferencesImpl preferences =
			PortletPreferencesSerializer.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		long rootPlid = GetterUtil.getLong(
			preferences.getValue("root-plid", StringPool.BLANK));

		if (rootPlid > 0) {
			Object[] layout = getLayout(rootPlid);

			if (layout != null) {
				long layoutId = (Long)layout[3];

				preferences.setValue(
					"root-layout-id", String.valueOf(layoutId));
			}
		}

		preferences.setValue("root-plid", null);

		return PortletPreferencesSerializer.toXML(preferences);
	}

}