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
import com.liferay.portal.model.Permission;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class PermissionJSONSerializer {
	public static JSONObject toJSONObject(Permission model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("permissionId", model.getPermissionId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("actionId", model.getActionId());
		jsonObject.put("resourceId", model.getResourceId());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Permission[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Permission model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Permission[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Permission[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Permission> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Permission model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}