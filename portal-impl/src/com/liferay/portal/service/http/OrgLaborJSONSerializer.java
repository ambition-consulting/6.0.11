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
import com.liferay.portal.model.OrgLabor;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class OrgLaborJSONSerializer {
	public static JSONObject toJSONObject(OrgLabor model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("orgLaborId", model.getOrgLaborId());
		jsonObject.put("organizationId", model.getOrganizationId());
		jsonObject.put("typeId", model.getTypeId());
		jsonObject.put("sunOpen", model.getSunOpen());
		jsonObject.put("sunClose", model.getSunClose());
		jsonObject.put("monOpen", model.getMonOpen());
		jsonObject.put("monClose", model.getMonClose());
		jsonObject.put("tueOpen", model.getTueOpen());
		jsonObject.put("tueClose", model.getTueClose());
		jsonObject.put("wedOpen", model.getWedOpen());
		jsonObject.put("wedClose", model.getWedClose());
		jsonObject.put("thuOpen", model.getThuOpen());
		jsonObject.put("thuClose", model.getThuClose());
		jsonObject.put("friOpen", model.getFriOpen());
		jsonObject.put("friClose", model.getFriClose());
		jsonObject.put("satOpen", model.getSatOpen());
		jsonObject.put("satClose", model.getSatClose());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.OrgLabor[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (OrgLabor model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.OrgLabor[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (OrgLabor[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.OrgLabor> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (OrgLabor model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}