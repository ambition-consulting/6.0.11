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

package com.liferay.portal.cmis;

import com.liferay.portal.cmis.model.CMISConstants;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.FileImpl;

import java.io.FileInputStream;

import java.util.List;

import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Service;
import org.apache.abdera.model.Workspace;

/**
 * @author Alexander Chow
 */
public class CMISTest extends BaseCMISTestCase {

	public void testCRUD() throws Exception {
		String rootChildrenUrl = null;

		for (Workspace workspace : getService().getWorkspaces()) {
			rootChildrenUrl = CMISUtil.getCollectionUrl(
				workspace, getConstants().COLLECTION_ROOT);

			assertNotNull(rootChildrenUrl);

			Entry folder = CMISUtil.getEntry(
				rootChildrenUrl, _LIFERAY_TEST,
				_cmisConstants.BASE_TYPE_FOLDER);

			if (folder != null) {
				CMISUtil.delete(folder);
			}
		}

		FileInputStream fis = new FileInputStream(_TEST_FILE);

		Entry folderEntry = CMISUtil.createFolder(
			rootChildrenUrl, _LIFERAY_TEST);

		Entry fileEntry = CMISUtil.createDocument(folderEntry, "test.txt", fis);

		assertNotNull(fileEntry);

		String repositoryFileContent = StringUtil.read(
			CMISUtil.getInputStream(fileEntry));

		String originalFileContent = _fileUtil.read(_TEST_FILE);

		assertEquals(originalFileContent, repositoryFileContent);

		List<String> fileNames = CMISUtil.getFolders(folderEntry);

		assertEquals(1, fileNames.size());

		assertEquals("test.txt", fileNames.get(0));

		CMISUtil.delete(fileEntry);
		CMISUtil.delete(folderEntry);
	}

	protected CMISConstants getConstants() {
		return _cmisConstants;
	}

	protected Service getService() throws Exception {
		return CMISUtil.getService();
	}

	private static final String _LIFERAY_TEST = "Liferay Test";

	private static final String _TEST_FILE =
		"portal-impl/test/com/liferay/portal/cmis/dependencies/test.txt";

	private static CMISConstants _cmisConstants = CMISConstants.getInstance();
	private static FileImpl _fileUtil = FileImpl.getInstance();

}