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

package com.liferay.portalweb.portal.stagingcommunity.controlpanel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CC_PortalRolesTest extends BaseTestCase {
	public void testCC_PortalRoles() throws Exception {
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Community administration"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupAPPROVE_PROPOSAL']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupASSIGN_MEMBERS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupASSIGN_REVIEWER']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_ANNOUNCEMENTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_ARCHIVED_SETUPS']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_LAYOUTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_STAGING']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupPUBLISH_STAGING']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.LayoutADD_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.LayoutUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.LayoutVIEW']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.tasks.model.TasksProposalADD_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.tasks.model.TasksProposalDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.tasks.model.TasksProposalUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.tasks.model.TasksProposalVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
	}
}