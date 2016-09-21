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

import com.liferay.portal.service.ServiceTestUtil;

import java.io.File;

import junit.extensions.TestSetup;

import junit.framework.Test;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;

/**
 * @author Raymond Augé
 * @author Brian Wing Shun Chan
 */
public class MainServletTestSetup extends TestSetup {

	public MainServletTestSetup(Test test) {
		super(test);
	}

	public void setUp() throws Exception {
		ServiceTestUtil.initServices();
		ServiceTestUtil.initPermissions();

		MockServletContext mockServletContext = new MockServletContext(
			getResourceBasePath(), new FileSystemResourceLoader());

		MockServletConfig mockServletConfig = new MockServletConfig(
			mockServletContext);

		_mainServlet = new MainServlet();

		_mainServlet.init(mockServletConfig);
	}

	public void tearDown() throws Exception {
		_mainServlet.destroy();

		ServiceTestUtil.destroyServices();
	}

	protected String getResourceBasePath() {
		File file = new File("portal-web");

		return file.getAbsolutePath();
	}

	private MainServlet _mainServlet;

}