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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.LayoutSet;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class LayoutSetJSONSerializer {
	public static JSONObject toJSONObject(LayoutSet model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("layoutSetId", model.getLayoutSetId());
		jsonObject.put("groupId", model.getGroupId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("privateLayout", model.getPrivateLayout());
		jsonObject.put("logo", model.getLogo());
		jsonObject.put("logoId", model.getLogoId());
		jsonObject.put("themeId", model.getThemeId());
		jsonObject.put("colorSchemeId", model.getColorSchemeId());
		jsonObject.put("wapThemeId", model.getWapThemeId());
		jsonObject.put("wapColorSchemeId", model.getWapColorSchemeId());
		jsonObject.put("css", model.getCss());
		jsonObject.put("pageCount", model.getPageCount());
		jsonObject.put("virtualHost", model.getVirtualHost());
		jsonObject.put("settings", model.getSettings());
		jsonObject.put("layoutSetPrototypeId", model.getLayoutSetPrototypeId());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.LayoutSet[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (LayoutSet model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.LayoutSet[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (LayoutSet[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.LayoutSet> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (LayoutSet model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}