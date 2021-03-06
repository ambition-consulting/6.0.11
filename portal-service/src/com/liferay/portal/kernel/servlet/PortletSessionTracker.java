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

import java.io.Serializable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * <p>
 * See http://issues.liferay.com/browse/LEP-1466.
 * </p>
 *
 * @author Rudy Hilado
 */
public class PortletSessionTracker
	implements HttpSessionListener, HttpSessionBindingListener, Serializable {

	public static void add(HttpSession session) {
		_instance._add(session);
	}

	public static void invalidate(HttpSession session) {
		_instance._invalidate(session.getId());
	}

	public static HttpSessionBindingListener getInstance() {
		return _instance;
	}

	public static void invalidate(String sessionId) {
		_instance._invalidate(sessionId);
	}

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		_invalidate(httpSessionEvent.getSession().getId());
	}

	public void valueBound(HttpSessionBindingEvent event) {
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		invalidate(event.getSession().getId());
	}

	private PortletSessionTracker() {
		_sessions = new HashMap<String, Set<HttpSession>>();

		PortletSessionListenerManager.addListener(this);
	}

	private void _add(HttpSession session) {
		String sessionId = session.getId();

		synchronized (_sessions) {
			Set<HttpSession> portletSessions = _sessions.get(sessionId);

			if (portletSessions == null) {
				portletSessions = new HashSet<HttpSession>();

				_sessions.put(sessionId, portletSessions);
			}

			portletSessions.add(session);
		}
	}

	private void _invalidate(String sessionId) {
		Set<HttpSession> sessionsToInvalidate = null;

		synchronized (_sessions) {
			Set<HttpSession> portletSessions = _sessions.get(sessionId);

			if (portletSessions != null) {
				sessionsToInvalidate = new HashSet<HttpSession>(
					portletSessions);
			}

			_sessions.remove(sessionId);
		}

		if (sessionsToInvalidate != null) {
			Iterator<HttpSession> itr = sessionsToInvalidate.iterator();

			while (itr.hasNext()) {
				HttpSession session = itr.next();

				try {
					session.invalidate();
				}
				catch (Exception e) {
				}
			}
		}
	}

	private static PortletSessionTracker _instance =
		new PortletSessionTracker();

	private transient Map<String, Set<HttpSession>> _sessions;

}