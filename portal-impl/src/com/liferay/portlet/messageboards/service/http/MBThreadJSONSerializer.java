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

package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.messageboards.model.MBThread;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class MBThreadJSONSerializer {
	public static JSONObject toJSONObject(MBThread model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("threadId", model.getThreadId());
		jsonObject.put("groupId", model.getGroupId());
		jsonObject.put("categoryId", model.getCategoryId());
		jsonObject.put("rootMessageId", model.getRootMessageId());
		jsonObject.put("messageCount", model.getMessageCount());
		jsonObject.put("viewCount", model.getViewCount());
		jsonObject.put("lastPostByUserId", model.getLastPostByUserId());

		Date lastPostDate = model.getLastPostDate();

		String lastPostDateJSON = StringPool.BLANK;

		if (lastPostDate != null) {
			lastPostDateJSON = String.valueOf(lastPostDate.getTime());
		}

		jsonObject.put("lastPostDate", lastPostDateJSON);
		jsonObject.put("priority", model.getPriority());
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
		com.liferay.portlet.messageboards.model.MBThread[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (MBThread model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.messageboards.model.MBThread[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (MBThread[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.messageboards.model.MBThread> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (MBThread model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}