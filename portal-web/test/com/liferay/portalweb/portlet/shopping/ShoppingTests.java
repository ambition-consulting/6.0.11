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

package com.liferay.portalweb.portlet.shopping;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.shopping.archivedsetup.ArchivedSetupTests;
import com.liferay.portalweb.portlet.shopping.category.CategoryTests;
import com.liferay.portalweb.portlet.shopping.coupon.CouponTests;
import com.liferay.portalweb.portlet.shopping.item.ItemTests;
import com.liferay.portalweb.portlet.shopping.order.OrderTests;
import com.liferay.portalweb.portlet.shopping.portlet.PortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ArchivedSetupTests.suite());
		testSuite.addTest(CategoryTests.suite());
		testSuite.addTest(CouponTests.suite());
		testSuite.addTest(ItemTests.suite());
		testSuite.addTest(OrderTests.suite());
		testSuite.addTest(PortletTests.suite());

		return testSuite;
	}

}