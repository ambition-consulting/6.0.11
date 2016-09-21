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

package com.liferay.util.servlet;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.Encryptor;
import com.liferay.util.EncryptorException;

import java.security.Key;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Brian Wing Shun Chan
 */
public class EncryptedServletRequest extends HttpServletRequestWrapper {

	public EncryptedServletRequest(HttpServletRequest request, Key key) {
		super(request);

		_params = new HashMap<String, String[]>();
		_key = key;

		Enumeration<String> enu = getParameterNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			String[] values = super.getParameterValues(name);

			for (int i = 0; i < values.length; i++) {
				if (Validator.isNotNull(values[i])) {
					try {
						values[i] = Encryptor.decrypt(_key, values[i]);
					}
					catch (EncryptorException ee) {
						values[i] = StringPool.BLANK;
					}
				}
			}

			_params.put(name, values);
		}
	}

	public String getParameter(String name) {
		String[] values = _params.get(name);

		if ((values != null) && (values.length > 0)) {
			return values[0];
		}
		else {
			return null;
		}
	}

	public Map<String, String[]> getParameterMap() {
		return Collections.unmodifiableMap(_params);
	}

	public String[] getParameterValues(String name) {
		return _params.get(name);
	}

	private Map<String, String[]> _params;
	private Key _key;

}