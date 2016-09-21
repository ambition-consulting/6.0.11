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

import com.liferay.portlet.asset.model.AssetEntry;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class AssetEntryJSONSerializer {
	public static JSONObject toJSONObject(AssetEntry model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("entryId", model.getEntryId());
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
		jsonObject.put("classNameId", model.getClassNameId());
		jsonObject.put("classPK", model.getClassPK());
		jsonObject.put("classUuid", model.getClassUuid());
		jsonObject.put("visible", model.getVisible());

		Date startDate = model.getStartDate();

		String startDateJSON = StringPool.BLANK;

		if (startDate != null) {
			startDateJSON = String.valueOf(startDate.getTime());
		}

		jsonObject.put("startDate", startDateJSON);

		Date endDate = model.getEndDate();

		String endDateJSON = StringPool.BLANK;

		if (endDate != null) {
			endDateJSON = String.valueOf(endDate.getTime());
		}

		jsonObject.put("endDate", endDateJSON);

		Date publishDate = model.getPublishDate();

		String publishDateJSON = StringPool.BLANK;

		if (publishDate != null) {
			publishDateJSON = String.valueOf(publishDate.getTime());
		}

		jsonObject.put("publishDate", publishDateJSON);

		Date expirationDate = model.getExpirationDate();

		String expirationDateJSON = StringPool.BLANK;

		if (expirationDate != null) {
			expirationDateJSON = String.valueOf(expirationDate.getTime());
		}

		jsonObject.put("expirationDate", expirationDateJSON);
		jsonObject.put("mimeType", model.getMimeType());
		jsonObject.put("title", model.getTitle());
		jsonObject.put("description", model.getDescription());
		jsonObject.put("summary", model.getSummary());
		jsonObject.put("url", model.getUrl());
		jsonObject.put("height", model.getHeight());
		jsonObject.put("width", model.getWidth());
		jsonObject.put("priority", model.getPriority());
		jsonObject.put("viewCount", model.getViewCount());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.asset.model.AssetEntry[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetEntry model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.asset.model.AssetEntry[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetEntry[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.asset.model.AssetEntry> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetEntry model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}