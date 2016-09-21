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

package com.liferay.portal.service;

import com.liferay.portal.NoSuchResourceException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.DoAsUserThread;
import com.liferay.portal.service.BaseServiceTestCase;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.TestPropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceLocalServiceTest extends BaseServiceTestCase {

	public void setUp() throws Exception {
		super.setUp();

		Group group = GroupLocalServiceUtil.getGroup(
			TestPropsValues.COMPANY_ID, GroupConstants.GUEST);

		_layout = LayoutLocalServiceUtil.getLayout(TestPropsValues.LAYOUT_PLID);

		_userIds = UserLocalServiceUtil.getGroupUserIds(group.getGroupId());
	}

	public void testAddResourcesConcurrently() throws Exception {
		int threadCount = 5;

		DoAsUserThread[] threads = new DoAsUserThread[threadCount];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new AddResources(_userIds[i]);
		}

		for (DoAsUserThread thread : threads) {
			thread.start();
		}

		for (DoAsUserThread thread : threads) {
			thread.join();
		}

		int successCount = 0;

		for (DoAsUserThread thread : threads) {
			if (thread.isSuccess()) {
				successCount++;
			}
		}

		assertTrue(
			"Only " + successCount + " out of " + threadCount +
				" threads added resources successfully",
			successCount == threadCount);
	}

	private Layout _layout;
	private long[] _userIds;

	private class AddResources extends DoAsUserThread {

		public AddResources(long userId) {
			super(userId);
		}

		public boolean isSuccess() {
			return true;
		}

		protected void doRun() throws Exception {
			try {
				ResourceLocalServiceUtil.getResource(
					_layout.getCompanyId(), Layout.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(_layout.getPlid()));
			}
			catch (NoSuchResourceException nsre) {
				boolean addCommunityPermission = true;
				boolean addGuestPermission = true;

				if (_layout.isPrivateLayout()) {
					addGuestPermission = false;
				}

				ResourceLocalServiceUtil.addResources(
					_layout.getCompanyId(), _layout.getGroupId(), 0,
					Layout.class.getName(), _layout.getPlid(), false,
					addCommunityPermission, addGuestPermission);
			}
		}

	}

}