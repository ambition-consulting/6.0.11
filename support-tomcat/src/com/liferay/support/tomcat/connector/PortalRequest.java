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

package com.liferay.support.tomcat.connector;

import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.http.Cookie;

import org.apache.catalina.connector.Request;

/**
 * @author Minhchau Dang
 */
public class PortalRequest extends Request {

	protected void configureSessionCookie(Cookie cookie) {
		super.configureSessionCookie(cookie);

		String host = getServerName();

		String domain = _getDomain(host);

		if (domain != null) {
			cookie.setDomain(domain);
		}
	}

	private String _getDomain(String host) {

		// See LEP-4602 and LEP-4645.

		if (host == null) {
			return null;
		}

		int x = host.lastIndexOf(StringPool.PERIOD);

		if (x <= 0) {
			return null;
		}

		int y = host.lastIndexOf(StringPool.PERIOD, x - 1);

		if (y <= 0) {
			return StringPool.PERIOD + host;
		}

		int z = host.lastIndexOf(StringPool.PERIOD, y - 1);

		String domain = null;

		if (z <= 0) {
			domain = host.substring(y);
		}
		else {
			domain = host.substring(z);
		}

		return domain;
	}

}