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

package com.liferay.portalweb.portlet.messageboards.category;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.messageboards.category.addcategory.AddCategoryTests;
import com.liferay.portalweb.portlet.messageboards.category.addcategorymultiple.AddCategoryMultipleTests;
import com.liferay.portalweb.portlet.messageboards.category.addcategorynamenull.AddCategoryNameNullTests;
import com.liferay.portalweb.portlet.messageboards.category.addsubcategory.AddSubcategoryTests;
import com.liferay.portalweb.portlet.messageboards.category.addsubcategorymultiple.AddSubcategoryMultipleTests;
import com.liferay.portalweb.portlet.messageboards.category.addsubcategorynamenull.AddSubcategoryNameNullTests;
import com.liferay.portalweb.portlet.messageboards.category.deletecategory.DeleteCategoryTests;
import com.liferay.portalweb.portlet.messageboards.category.editcategory.EditCategoryTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoryTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCategoryTests.suite());
		testSuite.addTest(AddCategoryMultipleTests.suite());
		testSuite.addTest(AddCategoryNameNullTests.suite());
		testSuite.addTest(AddSubcategoryTests.suite());
		testSuite.addTest(AddSubcategoryMultipleTests.suite());
		testSuite.addTest(AddSubcategoryNameNullTests.suite());
		testSuite.addTest(DeleteCategoryTests.suite());
		testSuite.addTest(EditCategoryTests.suite());

		return testSuite;
	}

}