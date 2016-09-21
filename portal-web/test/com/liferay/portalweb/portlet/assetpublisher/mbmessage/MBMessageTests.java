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

package com.liferay.portalweb.portlet.assetpublisher.mbmessage;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewcountmbmessage.ViewCountMBMessageTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewmbmessageabstracts.ViewMBMessageAbstractsTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewmbmessagedynamicassettypembmessage.ViewMBMessageDynamicAssetTypeMBMessageTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewmbmessagefullcontent.ViewMBMessageFullContentTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewmbmessagetable.ViewMBMessageTableTests;
import com.liferay.portalweb.portlet.assetpublisher.mbmessage.viewmbmessagetitlelist.ViewMBMessageTitleListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBMessageTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewCountMBMessageTests.suite());
		testSuite.addTest(ViewMBMessageAbstractsTests.suite());
		testSuite.addTest(ViewMBMessageDynamicAssetTypeMBMessageTests.suite());
		testSuite.addTest(ViewMBMessageFullContentTests.suite());
		testSuite.addTest(ViewMBMessageTableTests.suite());
		testSuite.addTest(ViewMBMessageTitleListTests.suite());

		return testSuite;
	}

}