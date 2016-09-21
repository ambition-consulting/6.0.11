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

package com.liferay.portalweb.portlet.shopping.coupon;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.shopping.coupon.addcoupon.AddCouponTests;
import com.liferay.portalweb.portlet.shopping.coupon.addcouponcodenumber.AddCouponCodeNumberTests;
import com.liferay.portalweb.portlet.shopping.coupon.addcouponmultiple.AddCouponMultipleTests;
import com.liferay.portalweb.portlet.shopping.coupon.addcouponnamenull.AddCouponNameNullTests;
import com.liferay.portalweb.portlet.shopping.coupon.addcouponnamespace.AddCouponNameSpaceTests;
import com.liferay.portalweb.portlet.shopping.coupon.deletecoupon.DeleteCouponTests;
import com.liferay.portalweb.portlet.shopping.coupon.editcoupon.EditCouponTests;
import com.liferay.portalweb.portlet.shopping.coupon.searchcoupon.SearchCouponTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CouponTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCouponTests.suite());
		testSuite.addTest(AddCouponCodeNumberTests.suite());
		testSuite.addTest(AddCouponMultipleTests.suite());
		testSuite.addTest(AddCouponNameNullTests.suite());
		testSuite.addTest(AddCouponNameSpaceTests.suite());
		testSuite.addTest(DeleteCouponTests.suite());
		testSuite.addTest(EditCouponTests.suite());
		testSuite.addTest(SearchCouponTests.suite());

		return testSuite;
	}

}