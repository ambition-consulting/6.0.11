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

package com.liferay.portlet.softwarecatalog.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.liferay.portlet.softwarecatalog.model.SCLicense;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class SCLicenseJSONSerializer {
	public static JSONObject toJSONObject(SCLicense model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("licenseId", model.getLicenseId());
		jsonObject.put("name", model.getName());
		jsonObject.put("url", model.getUrl());
		jsonObject.put("openSource", model.getOpenSource());
		jsonObject.put("active", model.getActive());
		jsonObject.put("recommended", model.getRecommended());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.softwarecatalog.model.SCLicense[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (SCLicense model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.softwarecatalog.model.SCLicense[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (SCLicense[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.softwarecatalog.model.SCLicense> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (SCLicense model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}