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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchUserTrackerPathException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.UserTrackerPath;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UserTrackerPathPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (UserTrackerPathPersistence)PortalBeanLocatorUtil.locate(UserTrackerPathPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		UserTrackerPath userTrackerPath = _persistence.create(pk);

		assertNotNull(userTrackerPath);

		assertEquals(userTrackerPath.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		UserTrackerPath newUserTrackerPath = addUserTrackerPath();

		_persistence.remove(newUserTrackerPath);

		UserTrackerPath existingUserTrackerPath = _persistence.fetchByPrimaryKey(newUserTrackerPath.getPrimaryKey());

		assertNull(existingUserTrackerPath);
	}

	public void testUpdateNew() throws Exception {
		addUserTrackerPath();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		UserTrackerPath newUserTrackerPath = _persistence.create(pk);

		newUserTrackerPath.setUserTrackerId(nextLong());
		newUserTrackerPath.setPath(randomString());
		newUserTrackerPath.setPathDate(nextDate());

		_persistence.update(newUserTrackerPath, false);

		UserTrackerPath existingUserTrackerPath = _persistence.findByPrimaryKey(newUserTrackerPath.getPrimaryKey());

		assertEquals(existingUserTrackerPath.getUserTrackerPathId(),
			newUserTrackerPath.getUserTrackerPathId());
		assertEquals(existingUserTrackerPath.getUserTrackerId(),
			newUserTrackerPath.getUserTrackerId());
		assertEquals(existingUserTrackerPath.getPath(),
			newUserTrackerPath.getPath());
		assertEquals(Time.getShortTimestamp(
				existingUserTrackerPath.getPathDate()),
			Time.getShortTimestamp(newUserTrackerPath.getPathDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		UserTrackerPath newUserTrackerPath = addUserTrackerPath();

		UserTrackerPath existingUserTrackerPath = _persistence.findByPrimaryKey(newUserTrackerPath.getPrimaryKey());

		assertEquals(existingUserTrackerPath, newUserTrackerPath);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchUserTrackerPathException");
		}
		catch (NoSuchUserTrackerPathException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserTrackerPath newUserTrackerPath = addUserTrackerPath();

		UserTrackerPath existingUserTrackerPath = _persistence.fetchByPrimaryKey(newUserTrackerPath.getPrimaryKey());

		assertEquals(existingUserTrackerPath, newUserTrackerPath);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		UserTrackerPath missingUserTrackerPath = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingUserTrackerPath);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserTrackerPath newUserTrackerPath = addUserTrackerPath();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserTrackerPath.class,
				UserTrackerPath.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userTrackerPathId",
				newUserTrackerPath.getUserTrackerPathId()));

		List<UserTrackerPath> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		UserTrackerPath existingUserTrackerPath = result.get(0);

		assertEquals(existingUserTrackerPath, newUserTrackerPath);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserTrackerPath.class,
				UserTrackerPath.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userTrackerPathId",
				nextLong()));

		List<UserTrackerPath> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected UserTrackerPath addUserTrackerPath() throws Exception {
		long pk = nextLong();

		UserTrackerPath userTrackerPath = _persistence.create(pk);

		userTrackerPath.setUserTrackerId(nextLong());
		userTrackerPath.setPath(randomString());
		userTrackerPath.setPathDate(nextDate());

		_persistence.update(userTrackerPath, false);

		return userTrackerPath;
	}

	private UserTrackerPathPersistence _persistence;
}