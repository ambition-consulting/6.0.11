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

package com.liferay.portalweb.portal.stagingcommunity.assetpublisher;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portal.stagingcommunity.assetpublisher.activatestaging.ActivateStagingTests;
import com.liferay.portalweb.portal.stagingcommunity.assetpublisher.assertcannoteditapentry.AssertCannotEditAPEntryTests;
import com.liferay.portalweb.portal.stagingcommunity.assetpublisher.asserteditapentry.AssertEditAPEntryTests;
import com.liferay.portalweb.portal.stagingcommunity.assetpublisher.deactivatestaging.DeactivateStagingTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetPublisherTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ActivateStagingTests.suite());
		testSuite.addTest(AssertCannotEditAPEntryTests.suite());
		testSuite.addTest(AssertEditAPEntryTests.suite());
		testSuite.addTest(DeactivateStagingTests.suite());

		return testSuite;
	}

}