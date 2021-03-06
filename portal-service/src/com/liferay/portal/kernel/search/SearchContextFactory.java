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

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import java.io.Serializable;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchContextFactory {

	public static SearchContext getInstance(HttpServletRequest request) {
		SearchContext searchContext = new SearchContext();

		// Theme display

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		searchContext.setCompanyId(themeDisplay.getCompanyId());
		searchContext.setGroupIds(new long[] {themeDisplay.getScopeGroupId()});
		searchContext.setUserId(themeDisplay.getUserId());

		// Attributes

		Map<String, Serializable> attributes =
			new HashMap<String, Serializable>();

		Enumeration<String> enu = request.getParameterNames();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();

			String[] values = request.getParameterValues(param);

			if ((values != null) && (values.length > 0)) {
				if (values.length == 1) {
					attributes.put(param, values[0]);
				}
				else {
					attributes.put(param, values);
				}
			}
		}

		searchContext.setAttributes(attributes);

		// Asset

		long[] assetCategoryIds = StringUtil.split(
			ParamUtil.getString(request, "assetCategoryIds"), 0L);

		String[] assetTagNames = StringUtil.split(
			ParamUtil.getString(request, "assetTagNames"));

		searchContext.setAssetCategoryIds(assetCategoryIds);
		searchContext.setAssetTagNames(assetTagNames);

		return searchContext;
	}

}