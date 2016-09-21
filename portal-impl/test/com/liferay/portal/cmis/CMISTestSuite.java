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

package com.liferay.portal.cmis;

import com.liferay.portal.util.InitUtil;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Alexander Chow
 */
public class CMISTestSuite extends TestSuite {

	public static Test suite() {
		InitUtil.initWithSpring();

		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(ParserTest.class);
		//testSuite.addTestSuite(CMISTest.class);

		return testSuite;
	}

}