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

import com.liferay.portal.kernel.servlet.HttpSessionWrapper;

import javax.servlet.http.HttpSession;

import org.mortbay.jetty.servlet.AbstractSessionManager;

/**
 * @author Brian Wing Shun Chan
 */
public class JettyHttpSessionWrapper
	extends HttpSessionWrapper implements AbstractSessionManager.SessionIf {

	public JettyHttpSessionWrapper(HttpSession session) {
		super(session);

		_session = session;
	}

	public AbstractSessionManager.Session getSession() {
		HttpSessionWrapper sessionWrapper = (HttpSessionWrapper)_session;

		JettySharedSessionWrapper jettySharedSessionWrapper =
			(JettySharedSessionWrapper)sessionWrapper.getWrappedSession();

		return jettySharedSessionWrapper.getSession();
	}

	private HttpSession _session;

}