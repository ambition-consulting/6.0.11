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

import com.liferay.portal.kernel.util.ServerDetector;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 */
public class SharedSessionServletRequest extends HttpServletRequestWrapper {

	public SharedSessionServletRequest(
		HttpServletRequest request, Map<String, Object> sharedSessionAttributes,
		boolean shared) {

		super(request);

		_sharedSessionAttributes = sharedSessionAttributes;

		_session = getSharedSessionWrapper(request.getSession());
		_shared = shared;
	}

	public HttpSession getSession() {
		if (_shared) {
			return _session;
		}
		else {
			return getSharedSessionWrapper(super.getSession());
		}
	}

	public HttpSession getSession(boolean create) {
		if (_shared) {
			return _session;
		}
		else {
			return getSharedSessionWrapper(super.getSession(create));
		}
	}

	public HttpSession getSharedSession() {
		return _session;
	}

	protected HttpSession getSharedSessionWrapper(HttpSession session) {
		if (ServerDetector.isJetty()) {
			return new JettySharedSessionWrapper(
				session, _sharedSessionAttributes);
		}
		else {
			return new SharedSessionWrapper(session, _sharedSessionAttributes);
		}
	}

	private HttpSession _session;
	private Map<String, Object> _sharedSessionAttributes;
	private boolean _shared;

}