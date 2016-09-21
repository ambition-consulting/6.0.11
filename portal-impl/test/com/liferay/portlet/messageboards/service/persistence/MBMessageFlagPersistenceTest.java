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

import com.liferay.portlet.messageboards.NoSuchMessageFlagException;
import com.liferay.portlet.messageboards.model.MBMessageFlag;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBMessageFlagPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (MBMessageFlagPersistence)PortalBeanLocatorUtil.locate(MBMessageFlagPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		MBMessageFlag mbMessageFlag = _persistence.create(pk);

		assertNotNull(mbMessageFlag);

		assertEquals(mbMessageFlag.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		MBMessageFlag newMBMessageFlag = addMBMessageFlag();

		_persistence.remove(newMBMessageFlag);

		MBMessageFlag existingMBMessageFlag = _persistence.fetchByPrimaryKey(newMBMessageFlag.getPrimaryKey());

		assertNull(existingMBMessageFlag);
	}

	public void testUpdateNew() throws Exception {
		addMBMessageFlag();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		MBMessageFlag newMBMessageFlag = _persistence.create(pk);

		newMBMessageFlag.setUserId(nextLong());
		newMBMessageFlag.setModifiedDate(nextDate());
		newMBMessageFlag.setThreadId(nextLong());
		newMBMessageFlag.setMessageId(nextLong());
		newMBMessageFlag.setFlag(nextInt());

		_persistence.update(newMBMessageFlag, false);

		MBMessageFlag existingMBMessageFlag = _persistence.findByPrimaryKey(newMBMessageFlag.getPrimaryKey());

		assertEquals(existingMBMessageFlag.getMessageFlagId(),
			newMBMessageFlag.getMessageFlagId());
		assertEquals(existingMBMessageFlag.getUserId(),
			newMBMessageFlag.getUserId());
		assertEquals(Time.getShortTimestamp(
				existingMBMessageFlag.getModifiedDate()),
			Time.getShortTimestamp(newMBMessageFlag.getModifiedDate()));
		assertEquals(existingMBMessageFlag.getThreadId(),
			newMBMessageFlag.getThreadId());
		assertEquals(existingMBMessageFlag.getMessageId(),
			newMBMessageFlag.getMessageId());
		assertEquals(existingMBMessageFlag.getFlag(), newMBMessageFlag.getFlag());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		MBMessageFlag newMBMessageFlag = addMBMessageFlag();

		MBMessageFlag existingMBMessageFlag = _persistence.findByPrimaryKey(newMBMessageFlag.getPrimaryKey());

		assertEquals(existingMBMessageFlag, newMBMessageFlag);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchMessageFlagException");
		}
		catch (NoSuchMessageFlagException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		MBMessageFlag newMBMessageFlag = addMBMessageFlag();

		MBMessageFlag existingMBMessageFlag = _persistence.fetchByPrimaryKey(newMBMessageFlag.getPrimaryKey());

		assertEquals(existingMBMessageFlag, newMBMessageFlag);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		MBMessageFlag missingMBMessageFlag = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingMBMessageFlag);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		MBMessageFlag newMBMessageFlag = addMBMessageFlag();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessageFlag.class,
				MBMessageFlag.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("messageFlagId",
				newMBMessageFlag.getMessageFlagId()));

		List<MBMessageFlag> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		MBMessageFlag existingMBMessageFlag = result.get(0);

		assertEquals(existingMBMessageFlag, newMBMessageFlag);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessageFlag.class,
				MBMessageFlag.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("messageFlagId", nextLong()));

		List<MBMessageFlag> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected MBMessageFlag addMBMessageFlag() throws Exception {
		long pk = nextLong();

		MBMessageFlag mbMessageFlag = _persistence.create(pk);

		mbMessageFlag.setUserId(nextLong());
		mbMessageFlag.setModifiedDate(nextDate());
		mbMessageFlag.setThreadId(nextLong());
		mbMessageFlag.setMessageId(nextLong());
		mbMessageFlag.setFlag(nextInt());

		_persistence.update(mbMessageFlag, false);

		return mbMessageFlag;
	}

	private MBMessageFlagPersistence _persistence;
}