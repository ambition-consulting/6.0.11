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

package com.liferay.portalweb.portlet.messageboards;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.messageboards.category.CategoryTests;
import com.liferay.portalweb.portlet.messageboards.lar.LARTests;
import com.liferay.portalweb.portlet.messageboards.message.MessageTests;
import com.liferay.portalweb.portlet.messageboards.portlet.PortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBoardsTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(CategoryTests.suite());
		testSuite.addTest(LARTests.suite());
		testSuite.addTest(MessageTests.suite());
		testSuite.addTest(PortletTests.suite());

		return testSuite;
	}

}