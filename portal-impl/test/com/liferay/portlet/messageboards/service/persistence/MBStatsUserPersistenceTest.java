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

package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.messageboards.NoSuchStatsUserException;
import com.liferay.portlet.messageboards.model.MBStatsUser;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBStatsUserPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (MBStatsUserPersistence)PortalBeanLocatorUtil.locate(MBStatsUserPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		MBStatsUser mbStatsUser = _persistence.create(pk);

		assertNotNull(mbStatsUser);

		assertEquals(mbStatsUser.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		MBStatsUser newMBStatsUser = addMBStatsUser();

		_persistence.remove(newMBStatsUser);

		MBStatsUser existingMBStatsUser = _persistence.fetchByPrimaryKey(newMBStatsUser.getPrimaryKey());

		assertNull(existingMBStatsUser);
	}

	public void testUpdateNew() throws Exception {
		addMBStatsUser();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		MBStatsUser newMBStatsUser = _persistence.create(pk);

		newMBStatsUser.setGroupId(nextLong());
		newMBStatsUser.setUserId(nextLong());
		newMBStatsUser.setMessageCount(nextInt());
		newMBStatsUser.setLastPostDate(nextDate());

		_persistence.update(newMBStatsUser, false);

		MBStatsUser existingMBStatsUser = _persistence.findByPrimaryKey(newMBStatsUser.getPrimaryKey());

		assertEquals(existingMBStatsUser.getStatsUserId(),
			newMBStatsUser.getStatsUserId());
		assertEquals(existingMBStatsUser.getGroupId(),
			newMBStatsUser.getGroupId());
		assertEquals(existingMBStatsUser.getUserId(), newMBStatsUser.getUserId());
		assertEquals(existingMBStatsUser.getMessageCount(),
			newMBStatsUser.getMessageCount());
		assertEquals(Time.getShortTimestamp(
				existingMBStatsUser.getLastPostDate()),
			Time.getShortTimestamp(newMBStatsUser.getLastPostDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		MBStatsUser newMBStatsUser = addMBStatsUser();

		MBStatsUser existingMBStatsUser = _persistence.findByPrimaryKey(newMBStatsUser.getPrimaryKey());

		assertEquals(existingMBStatsUser, newMBStatsUser);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchStatsUserException");
		}
		catch (NoSuchStatsUserException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		MBStatsUser newMBStatsUser = addMBStatsUser();

		MBStatsUser existingMBStatsUser = _persistence.fetchByPrimaryKey(newMBStatsUser.getPrimaryKey());

		assertEquals(existingMBStatsUser, newMBStatsUser);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		MBStatsUser missingMBStatsUser = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingMBStatsUser);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		MBStatsUser newMBStatsUser = addMBStatsUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBStatsUser.class,
				MBStatsUser.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("statsUserId",
				newMBStatsUser.getStatsUserId()));

		List<MBStatsUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		MBStatsUser existingMBStatsUser = result.get(0);

		assertEquals(existingMBStatsUser, newMBStatsUser);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBStatsUser.class,
				MBStatsUser.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("statsUserId", nextLong()));

		List<MBStatsUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected MBStatsUser addMBStatsUser() throws Exception {
		long pk = nextLong();

		MBStatsUser mbStatsUser = _persistence.create(pk);

		mbStatsUser.setGroupId(nextLong());
		mbStatsUser.setUserId(nextLong());
		mbStatsUser.setMessageCount(nextInt());
		mbStatsUser.setLastPostDate(nextDate());

		_persistence.update(mbStatsUser, false);

		return mbStatsUser;
	}

	private MBStatsUserPersistence _persistence;
}