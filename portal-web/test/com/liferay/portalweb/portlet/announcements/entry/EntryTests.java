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

package com.liferay.portalweb.portlet.announcements.entry;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.announcements.entry.addentrycontentnull.AddEntryContentNullTests;
import com.liferay.portalweb.portlet.announcements.entry.addentrygeneral.AddEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.entry.addentrypriorityimportant.AddEntryPriorityImportantTests;
import com.liferay.portalweb.portlet.announcements.entry.addentryprioritynormal.AddEntryPriorityNormalTests;
import com.liferay.portalweb.portlet.announcements.entry.assertpriorityorder.AssertPriorityOrderTests;
import com.liferay.portalweb.portlet.announcements.entry.deleteentrygeneral.DeleteEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.entry.editentrygeneral.EditEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.entry.hideentry.HideEntryTests;
import com.liferay.portalweb.portlet.announcements.entry.markasreadentry.MarkAsReadEntryTests;
import com.liferay.portalweb.portlet.announcements.entry.showentry.ShowEntryTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddEntryContentNullTests.suite());
		testSuite.addTest(AddEntryGeneralTests.suite());
		testSuite.addTest(AddEntryPriorityImportantTests.suite());
		testSuite.addTest(AddEntryPriorityNormalTests.suite());
		testSuite.addTest(AssertPriorityOrderTests.suite());
		testSuite.addTest(DeleteEntryGeneralTests.suite());
		testSuite.addTest(EditEntryGeneralTests.suite());
		testSuite.addTest(HideEntryTests.suite());
		testSuite.addTest(MarkAsReadEntryTests.suite());
		testSuite.addTest(ShowEntryTests.suite());

		return testSuite;
	}

}