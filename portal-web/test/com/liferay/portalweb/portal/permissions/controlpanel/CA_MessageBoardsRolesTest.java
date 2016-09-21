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

package com.liferay.portalweb.portal.permissions.controlpanel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CA_MessageBoardsRolesTest extends BaseTestCase {
	public void testCA_MessageBoardsRoles() throws Exception {
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Message Boards"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.check("_128_rowIds");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboardsBAN_USER']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryADD_FILE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryADD_MESSAGE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryADD_SUBCATEGORY']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryDELETE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryMOVE_THREAD']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryPERMISSIONS']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryREPLY_TO_MESSAGE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategorySUBSCRIBE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryUPDATE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryUPDATE_THREAD_PRIORITY']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBCategoryVIEW']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBMessageDELETE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBMessagePERMISSIONS']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBMessageSUBSCRIBE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBMessageUPDATE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.messageboards.model.MBMessageVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
	}
}