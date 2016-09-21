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

package com.liferay.portal.service.http;

import com.liferay.portal.util.BaseTestCase;
import com.liferay.portal.util.TestPropsValues;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseServiceSoapTestCase extends BaseTestCase {

	protected URL getURL(String serviceName) throws MalformedURLException {
		return getURL(serviceName, true);
	}

	protected URL getURL(String serviceName, boolean authenticated)
		throws MalformedURLException {

		String url = TestPropsValues.PORTAL_URL;

		if (authenticated) {
			long userId = TestPropsValues.USER_ID;
			String password = TestPropsValues.USER_PASSWORD;

			int pos = url.indexOf("://");

			String protocol = url.substring(0, pos + 3);
			String host = url.substring(pos + 3, url.length());

			url =
				protocol + userId + ":" + password + "@" + host +
					"/tunnel-web/secure/axis/" + serviceName;
		}
		else {
			url += "/tunnel-web/axis/" + serviceName;
		}

		return new URL(url);
	}

}