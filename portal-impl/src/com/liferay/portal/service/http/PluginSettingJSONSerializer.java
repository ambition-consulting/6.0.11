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
import com.liferay.portal.model.PluginSetting;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class PluginSettingJSONSerializer {
	public static JSONObject toJSONObject(PluginSetting model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("pluginSettingId", model.getPluginSettingId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("pluginId", model.getPluginId());
		jsonObject.put("pluginType", model.getPluginType());
		jsonObject.put("roles", model.getRoles());
		jsonObject.put("active", model.getActive());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.PluginSetting[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PluginSetting model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.PluginSetting[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PluginSetting[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.PluginSetting> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PluginSetting model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}