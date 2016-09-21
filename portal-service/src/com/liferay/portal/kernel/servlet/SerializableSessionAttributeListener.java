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

package com.liferay.portal.kernel.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author Bruno Farache
 */
public class SerializableSessionAttributeListener
	implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		if (!_SESSION_VERIFY_SERIALIZABLE_ATTRIBUTE) {
			return;
		}

		String name = event.getName();
		Object value = event.getValue();

		if (!(value instanceof Serializable)) {
			_log.error(
				value.getClass().getName() +
					" is not serializable and will prevent this session from " +
						"being replicated");

			if (_requiresSerializable == null) {
				HttpSession session = event.getSession();

				ServletContext servletContext = session.getServletContext();

				_requiresSerializable = Boolean.valueOf(
					GetterUtil.getBoolean(
						servletContext.getInitParameter(
							"session-attributes-requires-serializable")));
			}

			if (_requiresSerializable) {
				HttpSession session = event.getSession();

				session.removeAttribute(name);
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		attributeAdded(event);
	}

	private boolean _SESSION_VERIFY_SERIALIZABLE_ATTRIBUTE =
		GetterUtil.getBoolean(
			PropsUtil.get(PropsKeys.SESSION_VERIFY_SERIALIZABLE_ATTRIBUTE),
			true);

	private static Log _log = LogFactoryUtil.getLog(
		SerializableSessionAttributeListener.class);

	private Boolean _requiresSerializable;

}