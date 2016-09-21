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

package com.liferay.portlet.polls.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.polls.model.PollsVote;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class PollsVoteJSONSerializer {
	public static JSONObject toJSONObject(PollsVote model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("voteId", model.getVoteId());
		jsonObject.put("userId", model.getUserId());
		jsonObject.put("questionId", model.getQuestionId());
		jsonObject.put("choiceId", model.getChoiceId());

		Date voteDate = model.getVoteDate();

		String voteDateJSON = StringPool.BLANK;

		if (voteDate != null) {
			voteDateJSON = String.valueOf(voteDate.getTime());
		}

		jsonObject.put("voteDate", voteDateJSON);

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.polls.model.PollsVote[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PollsVote model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.polls.model.PollsVote[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PollsVote[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.polls.model.PollsVote> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (PollsVote model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}