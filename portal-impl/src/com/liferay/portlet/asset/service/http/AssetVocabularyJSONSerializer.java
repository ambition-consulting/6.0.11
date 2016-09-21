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

package com.liferay.portlet.asset.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.asset.model.AssetVocabulary;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class AssetVocabularyJSONSerializer {
	public static JSONObject toJSONObject(AssetVocabulary model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("uuid", model.getUuid());
		jsonObject.put("vocabularyId", model.getVocabularyId());
		jsonObject.put("groupId", model.getGroupId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("userId", model.getUserId());
		jsonObject.put("userName", model.getUserName());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObject.put("createDate", createDateJSON);

		Date modifiedDate = model.getModifiedDate();

		String modifiedDateJSON = StringPool.BLANK;

		if (modifiedDate != null) {
			modifiedDateJSON = String.valueOf(modifiedDate.getTime());
		}

		jsonObject.put("modifiedDate", modifiedDateJSON);
		jsonObject.put("name", model.getName());
		jsonObject.put("title", model.getTitle());
		jsonObject.put("description", model.getDescription());
		jsonObject.put("settings", model.getSettings());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.asset.model.AssetVocabulary[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetVocabulary model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.asset.model.AssetVocabulary[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetVocabulary[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.asset.model.AssetVocabulary> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetVocabulary model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}