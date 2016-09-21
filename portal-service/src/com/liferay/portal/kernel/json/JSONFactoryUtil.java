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

package com.liferay.portal.kernel.json;

/**
 * @author Brian Wing Shun Chan
 */
public class JSONFactoryUtil {

	public static JSONArray createJSONArray() {
		return getJSONFactory().createJSONArray();
	}

	public static JSONArray createJSONArray(String json) throws JSONException {
		return getJSONFactory().createJSONArray(json);
	}

	public static JSONObject createJSONObject() {
		return getJSONFactory().createJSONObject();
	}

	public static JSONObject createJSONObject(String json)
		throws JSONException {

		return getJSONFactory().createJSONObject(json);
	}

	public static Object deserialize(JSONObject jsonObj) {
		return getJSONFactory().deserialize(jsonObj);
	}

	public static Object deserialize(String json) {
		return getJSONFactory().deserialize(json);
	}

	public static JSONFactory getJSONFactory() {
		return _jsonFactory;
	}

	public static Object looseDeserialize(String json) {
		return getJSONFactory().looseDeserialize(json);
	}

	public static String looseSerialize(Object object) {
		return getJSONFactory().looseSerialize(object);
	}

	public static String looseSerialize(
		Object object, JSONTransformer jsonTransformer, Class<?> clazz) {

		return getJSONFactory().looseSerialize(object, jsonTransformer, clazz);
	}

	public static String serialize(Object object) {
		return getJSONFactory().serialize(object);
	}

	public void setJSONFactory(JSONFactory jsonFactory) {
		_jsonFactory = jsonFactory;
	}

	private static JSONFactory _jsonFactory;

}