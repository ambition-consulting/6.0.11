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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;

/**
 * @author Brian Wing Shun Chan
 */
public class Portlet_EndControlPanelTest extends BaseTestCase {
	public void testPortlet_EndControlPanel() throws Exception {
		selenium.open("/web/guest/home/");
	}
}