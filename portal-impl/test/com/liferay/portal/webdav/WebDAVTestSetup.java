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

package com.liferay.portal.webdav;

import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.webdav.methods.Method;

import javax.servlet.http.HttpServletResponse;

import junit.extensions.TestSetup;

import junit.framework.Test;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Alexander Chow
 */
public class WebDAVTestSetup extends TestSetup {

	public WebDAVTestSetup(Test test) {
		super(test);
	}

	public void setUp() {
		ServiceTestUtil.initServices();
		ServiceTestUtil.initPermissions();

		Logger logger = Logger.getLogger(WebDAVServlet.class);

		logger.setLevel(Level.toLevel(Level.INFO_INT));

		Tuple tuple = _baseWebDAVTestCase.service(Method.MKCOL, "", null, null);

		int statusCode = BaseWebDAVTestCase.getStatusCode(tuple);

		if (statusCode == HttpServletResponse.SC_METHOD_NOT_ALLOWED) {
			_baseWebDAVTestCase.service(Method.DELETE, "", null, null);

			tuple = _baseWebDAVTestCase.service(Method.MKCOL, "", null, null);

			statusCode = BaseWebDAVTestCase.getStatusCode(tuple);

			assertEquals(HttpServletResponse.SC_CREATED, statusCode);
		}
	}

	public void tearDown() {
		_baseWebDAVTestCase.service(Method.DELETE, "", null, null);

		ServiceTestUtil.destroyServices();
	}

	private BaseWebDAVTestCase _baseWebDAVTestCase = new BaseWebDAVTestCase();

}