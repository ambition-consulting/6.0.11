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
public interface JSONFactory {

	public JSONArray createJSONArray();

	public JSONArray createJSONArray(String json) throws JSONException;

	public JSONObject createJSONObject();

	public JSONObject createJSONObject(String json) throws JSONException;

	public Object deserialize(JSONObject jsonObj);

	public Object deserialize(String json);

	public Object looseDeserialize(String json);

	public String looseSerialize(Object object);

	public String looseSerialize(
		Object object, JSONTransformer jsonTransformer, Class<?> clazz);

	public String serialize(Object object);

}