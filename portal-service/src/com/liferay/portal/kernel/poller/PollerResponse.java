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

package com.liferay.portal.kernel.poller;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class PollerResponse {

	public static final String POLLER_HINT_HIGH_CONNECTIVITY =
		"pollerHintHighConnectivity";

	public PollerResponse(String portletId, String chunkId) {
		_portletId = portletId;
		_chunkId = chunkId;
	}

	public void setParameter(String name, JSONArray value) {
		_parameterMap.put(name, value);
	}

	public void setParameter(String name, JSONObject value) {
		_parameterMap.put(name, value);
	}

	public void setParameter(String name, String value) {
		_parameterMap.put(name, value);
	}

	public JSONObject toJSONObject() {
		JSONObject pollerResponseJSON = JSONFactoryUtil.createJSONObject();

		pollerResponseJSON.put("portletId", _portletId);

		if (Validator.isNotNull(_chunkId)) {
			pollerResponseJSON.put("chunkId", _chunkId);
		}

		JSONObject dataJSON = JSONFactoryUtil.createJSONObject();

		Iterator<Map.Entry<String, Object>> itr =
			_parameterMap.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Object> entry = itr.next();

			String name = entry.getKey();
			Object value = entry.getValue();

			if (value instanceof JSONArray) {
				dataJSON.put(name, (JSONArray)value);
			}
			else if (value instanceof JSONObject) {
				dataJSON.put(name, (JSONObject)value);
			}
			else {
				dataJSON.put(name, String.valueOf(value));
			}
		}

		pollerResponseJSON.put("data", dataJSON);

		return pollerResponseJSON;
	}

	private String _chunkId;
	private Map<String, Object> _parameterMap = new HashMap<String, Object>();
	private String _portletId;

}