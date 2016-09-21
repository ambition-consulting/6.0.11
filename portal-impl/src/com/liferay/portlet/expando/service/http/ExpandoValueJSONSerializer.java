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

package com.liferay.portlet.expando.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.liferay.portlet.expando.model.ExpandoValue;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ExpandoValueJSONSerializer {
	public static JSONObject toJSONObject(ExpandoValue model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("valueId", model.getValueId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("tableId", model.getTableId());
		jsonObject.put("columnId", model.getColumnId());
		jsonObject.put("rowId", model.getRowId());
		jsonObject.put("classNameId", model.getClassNameId());
		jsonObject.put("classPK", model.getClassPK());
		jsonObject.put("data", model.getData());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.expando.model.ExpandoValue[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ExpandoValue model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.expando.model.ExpandoValue[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ExpandoValue[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.expando.model.ExpandoValue> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ExpandoValue model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}