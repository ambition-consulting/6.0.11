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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Image;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ImageJSONSerializer {
	public static JSONObject toJSONObject(Image model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("imageId", model.getImageId());

		Date modifiedDate = model.getModifiedDate();

		String modifiedDateJSON = StringPool.BLANK;

		if (modifiedDate != null) {
			modifiedDateJSON = String.valueOf(modifiedDate.getTime());
		}

		jsonObject.put("modifiedDate", modifiedDateJSON);
		jsonObject.put("text", model.getText());
		jsonObject.put("type", model.getType());
		jsonObject.put("height", model.getHeight());
		jsonObject.put("width", model.getWidth());
		jsonObject.put("size", model.getSize());

		return jsonObject;
	}

	public static JSONArray toJSONArray(com.liferay.portal.model.Image[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Image model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Image[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Image[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Image> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Image model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}