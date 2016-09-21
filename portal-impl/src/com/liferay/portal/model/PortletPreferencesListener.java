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

package com.liferay.portal.model;

import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.servlet.filters.cache.CacheUtil;

/**
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class PortletPreferencesListener
	extends BaseModelListener<PortletPreferences> {

	public void onAfterRemove(PortletPreferences portletPreferences) {
		clearCache(portletPreferences);
	}

	public void onAfterUpdate(PortletPreferences portletPreferences) {
		clearCache(portletPreferences);
	}

	protected void clearCache(PortletPreferences portletPreferences) {
		try {
			Layout layout = LayoutLocalServiceUtil.getLayout(
				portletPreferences.getPlid());

			if (!layout.isPrivateLayout()) {
				CacheUtil.clearCache(layout.getCompanyId());
			}
		}
		catch (Exception e) {
			CacheUtil.clearCache();
		}
	}

}