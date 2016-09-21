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

import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.util.BaseTestCase;
import com.liferay.portal.util.TestPropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseServiceHttpTestCase extends BaseTestCase {

	protected HttpPrincipal getHttpPrincipal() {
		return getHttpPrincipal(true);
	}

	protected HttpPrincipal getHttpPrincipal(boolean authenticated) {
		HttpPrincipal httpPrincipal = null;

		if (authenticated) {
			httpPrincipal = new HttpPrincipal(
				TestPropsValues.PORTAL_URL,
				String.valueOf(TestPropsValues.USER_ID),
				TestPropsValues.USER_PASSWORD);
		}
		else {
			httpPrincipal = new HttpPrincipal(TestPropsValues.PORTAL_URL);
		}

		return httpPrincipal;
	}

}