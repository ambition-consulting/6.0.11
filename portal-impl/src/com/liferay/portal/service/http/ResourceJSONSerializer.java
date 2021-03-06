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
import com.liferay.portal.model.Resource;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ResourceJSONSerializer {
	public static JSONObject toJSONObject(Resource model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("resourceId", model.getResourceId());
		jsonObject.put("codeId", model.getCodeId());
		jsonObject.put("primKey", model.getPrimKey());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Resource[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Resource model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Resource[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Resource[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Resource> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Resource model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}