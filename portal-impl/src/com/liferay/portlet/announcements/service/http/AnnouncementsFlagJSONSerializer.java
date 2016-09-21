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

package com.liferay.portlet.announcements.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.announcements.model.AnnouncementsFlag;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class AnnouncementsFlagJSONSerializer {
	public static JSONObject toJSONObject(AnnouncementsFlag model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("flagId", model.getFlagId());
		jsonObject.put("userId", model.getUserId());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObject.put("createDate", createDateJSON);
		jsonObject.put("entryId", model.getEntryId());
		jsonObject.put("value", model.getValue());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.announcements.model.AnnouncementsFlag[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AnnouncementsFlag model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.announcements.model.AnnouncementsFlag[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AnnouncementsFlag[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.announcements.model.AnnouncementsFlag> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AnnouncementsFlag model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}