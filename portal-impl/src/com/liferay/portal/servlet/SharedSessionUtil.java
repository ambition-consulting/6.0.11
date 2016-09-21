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

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletVersionDetector;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.util.PropsValues;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 * @author Shuyang Zhou
 */
public class SharedSessionUtil {

	public static Map<String, Object> getSharedSessionAttributes(
		HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (ServletVersionDetector.is2_5()) {
			Map<String, Object> attributes = new HashMap<String, Object>();

			Enumeration<String> enu = session.getAttributeNames();

			while (enu.hasMoreElements()) {
				String name = enu.nextElement();

				Object value = session.getAttribute(name);

				if (value == null) {
					continue;
				}

				if (ArrayUtil.contains(
						PropsValues.SHARED_SESSION_ATTRIBUTES_EXCLUDES, name)) {

					continue;
				}

				for (String sharedName :
						PropsValues.SHARED_SESSION_ATTRIBUTES) {

					if (!name.startsWith(sharedName)) {
						continue;
					}

					if (_log.isDebugEnabled()) {
						_log.debug("Sharing " + name);
					}

					attributes.put(name, value);

					break;
				}
			}

			return attributes;
		}
		else {
			SharedSessionAttributeCache sharedSessionAttributeCache =
				SharedSessionAttributeCache.getInstance(session);

			Map<String, Object> values =
				sharedSessionAttributeCache.getValues();

			if (_log.isDebugEnabled()) {
				_log.debug("Shared session attributes " + values);
			}

			return values;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SharedSessionUtil.class);

}