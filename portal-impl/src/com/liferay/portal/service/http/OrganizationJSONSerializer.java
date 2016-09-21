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
import com.liferay.portal.model.Organization;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class OrganizationJSONSerializer {
	public static JSONObject toJSONObject(Organization model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("organizationId", model.getOrganizationId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("parentOrganizationId", model.getParentOrganizationId());
		jsonObject.put("leftOrganizationId", model.getLeftOrganizationId());
		jsonObject.put("rightOrganizationId", model.getRightOrganizationId());
		jsonObject.put("name", model.getName());
		jsonObject.put("type", model.getType());
		jsonObject.put("recursable", model.getRecursable());
		jsonObject.put("regionId", model.getRegionId());
		jsonObject.put("countryId", model.getCountryId());
		jsonObject.put("statusId", model.getStatusId());
		jsonObject.put("comments", model.getComments());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Organization[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Organization model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Organization[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Organization[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Organization> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Organization model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}