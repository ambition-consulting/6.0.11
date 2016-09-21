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

package com.liferay.portalweb.portlet.documentlibrary.document;

import com.liferay.portalweb.portal.BaseTests;
import com.liferay.portalweb.portlet.documentlibrary.document.addfolderdocument.AddFolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.addfolderdocumentdocumentnull.AddFolderDocumentDocumentNullTests;
import com.liferay.portalweb.portlet.documentlibrary.document.addfolderdocumentmultiple.AddFolderDocumentMultipleTests;
import com.liferay.portalweb.portlet.documentlibrary.document.addfolderdocumenttitleduplicate.AddFolderDocumentTitleDuplicateTests;
import com.liferay.portalweb.portlet.documentlibrary.document.addfolderdocumenttitlenull.AddFolderDocumentTitleNullTests;
import com.liferay.portalweb.portlet.documentlibrary.document.addsubfolderdocument.AddSubfolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.deletefolderdocument.DeleteFolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.editfolderdocument.EditFolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.lockfolderdocument.LockFolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.searchfolderdocument.SearchFolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.unlockfolderdocument.UnlockFolderDocumentTests;
import com.liferay.portalweb.portlet.documentlibrary.document.viewfolderdocumentmydocuments.ViewFolderDocumentMyDocumentsTests;
import com.liferay.portalweb.portlet.documentlibrary.document.viewfolderdocumentrecentdocuments.ViewFolderDocumentRecentDocumentsTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddFolderDocumentTests.suite());
		testSuite.addTest(AddFolderDocumentDocumentNullTests.suite());
		testSuite.addTest(AddFolderDocumentMultipleTests.suite());
		testSuite.addTest(AddFolderDocumentTitleDuplicateTests.suite());
		testSuite.addTest(AddFolderDocumentTitleNullTests.suite());
		testSuite.addTest(AddSubfolderDocumentTests.suite());
		//testSuite.addTest(CompareFolderDocumentVersionTests.suite());
		testSuite.addTest(DeleteFolderDocumentTests.suite());
		testSuite.addTest(EditFolderDocumentTests.suite());
		testSuite.addTest(LockFolderDocumentTests.suite());
		//testSuite.addTest(MoveFolderDocumentDuplicateToFolderTests.suite());
		//testSuite.addTest(MoveFolderDocumentToFolderTests.suite());
		testSuite.addTest(SearchFolderDocumentTests.suite());
		testSuite.addTest(UnlockFolderDocumentTests.suite());
		testSuite.addTest(ViewFolderDocumentMyDocumentsTests.suite());
		testSuite.addTest(ViewFolderDocumentRecentDocumentsTests.suite());

		return testSuite;
	}

}