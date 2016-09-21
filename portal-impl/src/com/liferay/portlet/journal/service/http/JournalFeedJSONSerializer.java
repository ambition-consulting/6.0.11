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

package com.liferay.portlet.journal.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.journal.model.JournalFeed;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class JournalFeedJSONSerializer {
	public static JSONObject toJSONObject(JournalFeed model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("uuid", model.getUuid());
		jsonObject.put("id", model.getId());
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
		jsonObject.put("feedId", model.getFeedId());
		jsonObject.put("name", model.getName());
		jsonObject.put("description", model.getDescription());
		jsonObject.put("type", model.getType());
		jsonObject.put("structureId", model.getStructureId());
		jsonObject.put("templateId", model.getTemplateId());
		jsonObject.put("rendererTemplateId", model.getRendererTemplateId());
		jsonObject.put("delta", model.getDelta());
		jsonObject.put("orderByCol", model.getOrderByCol());
		jsonObject.put("orderByType", model.getOrderByType());
		jsonObject.put("targetLayoutFriendlyUrl",
			model.getTargetLayoutFriendlyUrl());
		jsonObject.put("targetPortletId", model.getTargetPortletId());
		jsonObject.put("contentField", model.getContentField());
		jsonObject.put("feedType", model.getFeedType());
		jsonObject.put("feedVersion", model.getFeedVersion());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.journal.model.JournalFeed[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (JournalFeed model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.journal.model.JournalFeed[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (JournalFeed[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.journal.model.JournalFeed> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (JournalFeed model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}