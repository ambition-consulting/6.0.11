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

import com.liferay.portal.NoSuchUserTrackerException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.UserTracker;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UserTrackerPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (UserTrackerPersistence)PortalBeanLocatorUtil.locate(UserTrackerPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		UserTracker userTracker = _persistence.create(pk);

		assertNotNull(userTracker);

		assertEquals(userTracker.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		UserTracker newUserTracker = addUserTracker();

		_persistence.remove(newUserTracker);

		UserTracker existingUserTracker = _persistence.fetchByPrimaryKey(newUserTracker.getPrimaryKey());

		assertNull(existingUserTracker);
	}

	public void testUpdateNew() throws Exception {
		addUserTracker();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		UserTracker newUserTracker = _persistence.create(pk);

		newUserTracker.setCompanyId(nextLong());
		newUserTracker.setUserId(nextLong());
		newUserTracker.setModifiedDate(nextDate());
		newUserTracker.setSessionId(randomString());
		newUserTracker.setRemoteAddr(randomString());
		newUserTracker.setRemoteHost(randomString());
		newUserTracker.setUserAgent(randomString());

		_persistence.update(newUserTracker, false);

		UserTracker existingUserTracker = _persistence.findByPrimaryKey(newUserTracker.getPrimaryKey());

		assertEquals(existingUserTracker.getUserTrackerId(),
			newUserTracker.getUserTrackerId());
		assertEquals(existingUserTracker.getCompanyId(),
			newUserTracker.getCompanyId());
		assertEquals(existingUserTracker.getUserId(), newUserTracker.getUserId());
		assertEquals(Time.getShortTimestamp(
				existingUserTracker.getModifiedDate()),
			Time.getShortTimestamp(newUserTracker.getModifiedDate()));
		assertEquals(existingUserTracker.getSessionId(),
			newUserTracker.getSessionId());
		assertEquals(existingUserTracker.getRemoteAddr(),
			newUserTracker.getRemoteAddr());
		assertEquals(existingUserTracker.getRemoteHost(),
			newUserTracker.getRemoteHost());
		assertEquals(existingUserTracker.getUserAgent(),
			newUserTracker.getUserAgent());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		UserTracker newUserTracker = addUserTracker();

		UserTracker existingUserTracker = _persistence.findByPrimaryKey(newUserTracker.getPrimaryKey());

		assertEquals(existingUserTracker, newUserTracker);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchUserTrackerException");
		}
		catch (NoSuchUserTrackerException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserTracker newUserTracker = addUserTracker();

		UserTracker existingUserTracker = _persistence.fetchByPrimaryKey(newUserTracker.getPrimaryKey());

		assertEquals(existingUserTracker, newUserTracker);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		UserTracker missingUserTracker = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingUserTracker);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserTracker newUserTracker = addUserTracker();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserTracker.class,
				UserTracker.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userTrackerId",
				newUserTracker.getUserTrackerId()));

		List<UserTracker> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		UserTracker existingUserTracker = result.get(0);

		assertEquals(existingUserTracker, newUserTracker);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserTracker.class,
				UserTracker.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userTrackerId", nextLong()));

		List<UserTracker> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected UserTracker addUserTracker() throws Exception {
		long pk = nextLong();

		UserTracker userTracker = _persistence.create(pk);

		userTracker.setCompanyId(nextLong());
		userTracker.setUserId(nextLong());
		userTracker.setModifiedDate(nextDate());
		userTracker.setSessionId(randomString());
		userTracker.setRemoteAddr(randomString());
		userTracker.setRemoteHost(randomString());
		userTracker.setUserAgent(randomString());

		_persistence.update(userTracker, false);

		return userTracker;
	}

	private UserTrackerPersistence _persistence;
}