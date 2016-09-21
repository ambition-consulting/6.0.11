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
import com.liferay.portal.model.Company;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class CompanyJSONSerializer {
	public static JSONObject toJSONObject(Company model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("accountId", model.getAccountId());
		jsonObject.put("webId", model.getWebId());
		jsonObject.put("key", model.getKey());
		jsonObject.put("virtualHost", model.getVirtualHost());
		jsonObject.put("mx", model.getMx());
		jsonObject.put("homeURL", model.getHomeURL());
		jsonObject.put("logoId", model.getLogoId());
		jsonObject.put("system", model.getSystem());
		jsonObject.put("maxUsers", model.getMaxUsers());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Company[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Company model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Company[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Company[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Company> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Company model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}