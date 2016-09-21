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

package com.liferay.portalweb.portal;

import com.liferay.portal.util.InitUtil;
import com.liferay.portalweb.portal.util.LiferaySeleneseTestCase;
import com.liferay.portalweb.portal.util.SeleniumUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseTestCase extends LiferaySeleneseTestCase {

	public BaseTestCase() {
		InitUtil.initWithSpring();
	}

	public void setUp() throws Exception {
		selenium = SeleniumUtil.getSelenium();
	}

	public void tearDown() throws Exception {
	}

}