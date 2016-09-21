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
import com.liferay.portal.cmis.model.CMISRepositoryInfo;

import junit.framework.TestCase;

import org.apache.abdera.model.Service;
import org.apache.abdera.model.Workspace;

/**
 * @author Alexander Chow
 */
public abstract class BaseCMISTestCase extends TestCase {

	public void testService() throws Exception {
		Service service = getService();

		assertNotNull(service);

		for (Workspace workspace : service.getWorkspaces()) {
			assertNotNull(workspace);

			CMISRepositoryInfo cmisRepositoryInfo = workspace.getFirstChild(
				getConstants().REPOSITORY_INFO);

			assertNotNull(cmisRepositoryInfo);
			assertNotNull(cmisRepositoryInfo.getId());
			assertEquals(
				getConstants().VERSION,
				cmisRepositoryInfo.getVersionSupported());

			String rootChildrenUrl = CMISUtil.getCollectionUrl(
				workspace, getConstants().COLLECTION_ROOT);

			assertNotNull(rootChildrenUrl);
		}
	}

	protected abstract CMISConstants getConstants();

	protected abstract Service getService() throws Exception;

}