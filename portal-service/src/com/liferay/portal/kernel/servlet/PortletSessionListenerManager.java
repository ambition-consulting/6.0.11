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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * <p>
 * See http://issues.liferay.com/browse/LEP-2299.
 * </p>
 *
 * @author Olaf Fricke
 * @author Brian Wing Shun Chan
 */
public class PortletSessionListenerManager implements HttpSessionListener {

	public static void addListener(HttpSessionListener listener) {
		_listeners.add(listener);
	}

	public static void removeListener(HttpSessionListener listener) {
		_listeners.remove(listener);
	}

	public void sessionCreated(HttpSessionEvent event) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			Iterator<HttpSessionListener> itr = _listeners.iterator();

			while (itr.hasNext()) {
				HttpSessionListener listener = itr.next();

				ClassLoader listenerClassLoader =
					listener.getClass().getClassLoader();

				currentThread.setContextClassLoader(listenerClassLoader);

				listener.sessionCreated(event);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		Iterator<HttpSessionListener> itr = _listeners.iterator();

		while (itr.hasNext()) {
			HttpSessionListener listener = itr.next();

			listener.sessionDestroyed(event);
		}
	}

	private static List<HttpSessionListener> _listeners =
		new ArrayList<HttpSessionListener>();

}