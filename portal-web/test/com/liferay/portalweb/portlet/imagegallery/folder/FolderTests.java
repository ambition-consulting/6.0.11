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

package com.liferay.portalweb.portlet.imagegallery.folder;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addfolder.AddFolderTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addfoldermultiple.AddFolderMultipleTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addfoldernameduplicate.AddFolderNameDuplicateTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addfoldernameinvalid.AddFolderNameInvalidTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addfoldernamenull.AddFolderNameNullTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addsubfolder.AddSubfolderTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addsubfoldermultiple.AddSubfolderMultipleTests;
import com.liferay.portalweb.portlet.imagegallery.folder.addsubfoldernameimagename.AddSubfolderNameImageNameTests;
import com.liferay.portalweb.portlet.imagegallery.folder.deletefolder.DeleteFolderTests;
import com.liferay.portalweb.portlet.imagegallery.folder.deletesubfolder.DeleteSubfolderTests;
import com.liferay.portalweb.portlet.imagegallery.folder.editfolder.EditFolderTests;
import com.liferay.portalweb.portlet.imagegallery.folder.editsubfolder.EditSubfolderTests;
import com.liferay.portalweb.portlet.imagegallery.folder.movesubfoldertofolder.MoveSubfolderToFolderTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class FolderTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddFolderTests.suite());
		testSuite.addTest(AddFolderMultipleTests.suite());
		testSuite.addTest(AddFolderNameDuplicateTests.suite());
		testSuite.addTest(AddFolderNameInvalidTests.suite());
		testSuite.addTest(AddFolderNameNullTests.suite());
		testSuite.addTest(AddSubfolderTests.suite());
		testSuite.addTest(AddSubfolderMultipleTests.suite());
		testSuite.addTest(AddSubfolderNameImageNameTests.suite());
		testSuite.addTest(DeleteFolderTests.suite());
		testSuite.addTest(DeleteSubfolderTests.suite());
		testSuite.addTest(EditFolderTests.suite());
		testSuite.addTest(EditSubfolderTests.suite());
		testSuite.addTest(MoveSubfolderToFolderTests.suite());

		return testSuite;
	}

}