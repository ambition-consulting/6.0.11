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
import com.liferay.portal.model.Layout;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class LayoutJSONSerializer {
	public static JSONObject toJSONObject(Layout model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("uuid", model.getUuid());
		jsonObject.put("plid", model.getPlid());
		jsonObject.put("groupId", model.getGroupId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("privateLayout", model.getPrivateLayout());
		jsonObject.put("layoutId", model.getLayoutId());
		jsonObject.put("parentLayoutId", model.getParentLayoutId());
		jsonObject.put("name", model.getName());
		jsonObject.put("title", model.getTitle());
		jsonObject.put("description", model.getDescription());
		jsonObject.put("type", model.getType());
		jsonObject.put("typeSettings", model.getTypeSettings());
		jsonObject.put("hidden", model.getHidden());
		jsonObject.put("friendlyURL", model.getFriendlyURL());
		jsonObject.put("iconImage", model.getIconImage());
		jsonObject.put("iconImageId", model.getIconImageId());
		jsonObject.put("themeId", model.getThemeId());
		jsonObject.put("colorSchemeId", model.getColorSchemeId());
		jsonObject.put("wapThemeId", model.getWapThemeId());
		jsonObject.put("wapColorSchemeId", model.getWapColorSchemeId());
		jsonObject.put("css", model.getCss());
		jsonObject.put("priority", model.getPriority());
		jsonObject.put("layoutPrototypeId", model.getLayoutPrototypeId());
		jsonObject.put("dlFolderId", model.getDlFolderId());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Layout[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Layout model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Layout[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Layout[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Layout> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Layout model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}