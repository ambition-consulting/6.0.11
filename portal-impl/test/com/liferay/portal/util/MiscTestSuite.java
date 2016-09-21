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

package com.liferay.portal.util;

import com.liferay.portal.image.ImageProcessorImplTest;
import com.liferay.portal.servlet.filters.strip.StripFilterTest;
import com.liferay.portal.xmlrpc.XmlRpcParserTest;
import com.liferay.portlet.RouterImplTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MiscTestSuite extends TestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(FileImplExtractTest.class);
		testSuite.addTestSuite(FileMultiValueMapTest.class);
		testSuite.addTestSuite(ImageProcessorImplTest.class);
		testSuite.addTestSuite(MemoryMultiValueMapTest.class);
		testSuite.addTestSuite(RouterImplTest.class);
		testSuite.addTestSuite(StripFilterTest.class);
		testSuite.addTestSuite(XmlRpcParserTest.class);

		return testSuite;
	}

}