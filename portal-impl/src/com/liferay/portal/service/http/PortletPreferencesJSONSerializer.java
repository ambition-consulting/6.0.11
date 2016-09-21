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
import com.liferay.portal.model.PortletPreferences;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class PortletPreferencesJSONSerializer {
	public static JSONObject toJSONObject(PortletPreferences model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("portletPreferencesId", model.getPortletPreferencesId());
		jsonObject.put("ownerId", model.getOwnerId());
		jsonObject.put("ownerType", model.getOwnerType());
		jsonObject.put("plid", model.getPlid());
		jsonObject.put("portletId", model.getPortletId());
		jsonObject.put("preferences", model.getPreferences());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.PortletPreferences[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PortletPreferences model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.PortletPreferences[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PortletPreferences[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.PortletPreferences> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PortletPreferences model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}