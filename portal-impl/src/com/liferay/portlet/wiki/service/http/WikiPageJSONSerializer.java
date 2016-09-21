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

package com.liferay.portlet.wiki.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.wiki.model.WikiPage;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class WikiPageJSONSerializer {
	public static JSONObject toJSONObject(WikiPage model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("uuid", model.getUuid());
		jsonObject.put("pageId", model.getPageId());
		jsonObject.put("resourcePrimKey", model.getResourcePrimKey());
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
		jsonObject.put("nodeId", model.getNodeId());
		jsonObject.put("title", model.getTitle());
		jsonObject.put("version", model.getVersion());
		jsonObject.put("minorEdit", model.getMinorEdit());
		jsonObject.put("content", model.getContent());
		jsonObject.put("summary", model.getSummary());
		jsonObject.put("format", model.getFormat());
		jsonObject.put("head", model.getHead());
		jsonObject.put("parentTitle", model.getParentTitle());
		jsonObject.put("redirectTitle", model.getRedirectTitle());
		jsonObject.put("status", model.getStatus());
		jsonObject.put("statusByUserId", model.getStatusByUserId());
		jsonObject.put("statusByUserName", model.getStatusByUserName());

		Date statusDate = model.getStatusDate();

		String statusDateJSON = StringPool.BLANK;

		if (statusDate != null) {
			statusDateJSON = String.valueOf(statusDate.getTime());
		}

		jsonObject.put("statusDate", statusDateJSON);

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.wiki.model.WikiPage[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (WikiPage model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.wiki.model.WikiPage[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (WikiPage[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.wiki.model.WikiPage> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (WikiPage model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}