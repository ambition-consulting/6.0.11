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

import com.liferay.portlet.messageboards.NoSuchBanException;
import com.liferay.portlet.messageboards.model.MBBan;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBBanPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (MBBanPersistence)PortalBeanLocatorUtil.locate(MBBanPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		MBBan mbBan = _persistence.create(pk);

		assertNotNull(mbBan);

		assertEquals(mbBan.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		MBBan newMBBan = addMBBan();

		_persistence.remove(newMBBan);

		MBBan existingMBBan = _persistence.fetchByPrimaryKey(newMBBan.getPrimaryKey());

		assertNull(existingMBBan);
	}

	public void testUpdateNew() throws Exception {
		addMBBan();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		MBBan newMBBan = _persistence.create(pk);

		newMBBan.setGroupId(nextLong());
		newMBBan.setCompanyId(nextLong());
		newMBBan.setUserId(nextLong());
		newMBBan.setUserName(randomString());
		newMBBan.setCreateDate(nextDate());
		newMBBan.setModifiedDate(nextDate());
		newMBBan.setBanUserId(nextLong());

		_persistence.update(newMBBan, false);

		MBBan existingMBBan = _persistence.findByPrimaryKey(newMBBan.getPrimaryKey());

		assertEquals(existingMBBan.getBanId(), newMBBan.getBanId());
		assertEquals(existingMBBan.getGroupId(), newMBBan.getGroupId());
		assertEquals(existingMBBan.getCompanyId(), newMBBan.getCompanyId());
		assertEquals(existingMBBan.getUserId(), newMBBan.getUserId());
		assertEquals(existingMBBan.getUserName(), newMBBan.getUserName());
		assertEquals(Time.getShortTimestamp(existingMBBan.getCreateDate()),
			Time.getShortTimestamp(newMBBan.getCreateDate()));
		assertEquals(Time.getShortTimestamp(existingMBBan.getModifiedDate()),
			Time.getShortTimestamp(newMBBan.getModifiedDate()));
		assertEquals(existingMBBan.getBanUserId(), newMBBan.getBanUserId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		MBBan newMBBan = addMBBan();

		MBBan existingMBBan = _persistence.findByPrimaryKey(newMBBan.getPrimaryKey());

		assertEquals(existingMBBan, newMBBan);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchBanException");
		}
		catch (NoSuchBanException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		MBBan newMBBan = addMBBan();

		MBBan existingMBBan = _persistence.fetchByPrimaryKey(newMBBan.getPrimaryKey());

		assertEquals(existingMBBan, newMBBan);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		MBBan missingMBBan = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingMBBan);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		MBBan newMBBan = addMBBan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBBan.class,
				MBBan.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("banId", newMBBan.getBanId()));

		List<MBBan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		MBBan existingMBBan = result.get(0);

		assertEquals(existingMBBan, newMBBan);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBBan.class,
				MBBan.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("banId", nextLong()));

		List<MBBan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected MBBan addMBBan() throws Exception {
		long pk = nextLong();

		MBBan mbBan = _persistence.create(pk);

		mbBan.setGroupId(nextLong());
		mbBan.setCompanyId(nextLong());
		mbBan.setUserId(nextLong());
		mbBan.setUserName(randomString());
		mbBan.setCreateDate(nextDate());
		mbBan.setModifiedDate(nextDate());
		mbBan.setBanUserId(nextLong());

		_persistence.update(mbBan, false);

		return mbBan;
	}

	private MBBanPersistence _persistence;
}