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

package com.liferay.portalweb.portlet.documentlibrary.folder;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addfolder.AddFolderTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addfoldermultiple.AddFolderMultipleTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addfoldernameduplicate.AddFolderNameDuplicateTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addfoldernamenull.AddFolderNameNullTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addfoldernamespace.AddFolderNameSpaceTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addfoldernamesymbol.AddFolderNameSymbolTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addsubfolder.AddSubfolderTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addsubfoldermultiple.AddSubfolderMultipleTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.addsubfoldernamedocumentname.AddSubfolderNameDocumentNameTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.deletefolder.DeleteFolderTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.deletesubfolder.DeleteSubfolderTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.editfolder.EditFolderTests;
import com.liferay.portalweb.portlet.documentlibrary.folder.editsubfolder.EditSubfolderTests;

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
		testSuite.addTest(AddFolderNameNullTests.suite());
		testSuite.addTest(AddFolderNameSpaceTests.suite());
		testSuite.addTest(AddFolderNameSymbolTests.suite());
		testSuite.addTest(AddSubfolderTests.suite());
		testSuite.addTest(AddSubfolderMultipleTests.suite());
		testSuite.addTest(AddSubfolderNameDocumentNameTests.suite());
		testSuite.addTest(DeleteFolderTests.suite());
		testSuite.addTest(DeleteSubfolderTests.suite());
		testSuite.addTest(EditFolderTests.suite());
		testSuite.addTest(EditSubfolderTests.suite());

		return testSuite;
	}

}