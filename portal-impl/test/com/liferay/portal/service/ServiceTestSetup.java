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

package com.liferay.portal.service;

import com.liferay.portal.service.ServiceTestUtil;

import junit.extensions.TestSetup;

import junit.framework.Test;

/**
 * @author Brian Wing Shun Chan
 */
public class ServiceTestSetup extends TestSetup {

	public ServiceTestSetup(Test test) {
		super(test);
	}

	public void setUp() throws Exception {
		ServiceTestUtil.initServices();
	}

	public void tearDown() throws Exception {
		ServiceTestUtil.destroyServices();
	}

}