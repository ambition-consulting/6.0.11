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

package com.liferay.portlet.documentlibrary.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.documentlibrary.NoSuchFileRankException;
import com.liferay.portlet.documentlibrary.model.DLFileRank;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileRankPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (DLFileRankPersistence)PortalBeanLocatorUtil.locate(DLFileRankPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		DLFileRank dlFileRank = _persistence.create(pk);

		assertNotNull(dlFileRank);

		assertEquals(dlFileRank.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		DLFileRank newDLFileRank = addDLFileRank();

		_persistence.remove(newDLFileRank);

		DLFileRank existingDLFileRank = _persistence.fetchByPrimaryKey(newDLFileRank.getPrimaryKey());

		assertNull(existingDLFileRank);
	}

	public void testUpdateNew() throws Exception {
		addDLFileRank();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		DLFileRank newDLFileRank = _persistence.create(pk);

		newDLFileRank.setGroupId(nextLong());
		newDLFileRank.setCompanyId(nextLong());
		newDLFileRank.setUserId(nextLong());
		newDLFileRank.setCreateDate(nextDate());
		newDLFileRank.setFileEntryId(nextLong());

		_persistence.update(newDLFileRank, false);

		DLFileRank existingDLFileRank = _persistence.findByPrimaryKey(newDLFileRank.getPrimaryKey());

		assertEquals(existingDLFileRank.getFileRankId(),
			newDLFileRank.getFileRankId());
		assertEquals(existingDLFileRank.getGroupId(), newDLFileRank.getGroupId());
		assertEquals(existingDLFileRank.getCompanyId(),
			newDLFileRank.getCompanyId());
		assertEquals(existingDLFileRank.getUserId(), newDLFileRank.getUserId());
		assertEquals(Time.getShortTimestamp(existingDLFileRank.getCreateDate()),
			Time.getShortTimestamp(newDLFileRank.getCreateDate()));
		assertEquals(existingDLFileRank.getFileEntryId(),
			newDLFileRank.getFileEntryId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		DLFileRank newDLFileRank = addDLFileRank();

		DLFileRank existingDLFileRank = _persistence.findByPrimaryKey(newDLFileRank.getPrimaryKey());

		assertEquals(existingDLFileRank, newDLFileRank);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchFileRankException");
		}
		catch (NoSuchFileRankException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		DLFileRank newDLFileRank = addDLFileRank();

		DLFileRank existingDLFileRank = _persistence.fetchByPrimaryKey(newDLFileRank.getPrimaryKey());

		assertEquals(existingDLFileRank, newDLFileRank);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		DLFileRank missingDLFileRank = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingDLFileRank);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		DLFileRank newDLFileRank = addDLFileRank();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileRank.class,
				DLFileRank.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileRankId",
				newDLFileRank.getFileRankId()));

		List<DLFileRank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		DLFileRank existingDLFileRank = result.get(0);

		assertEquals(existingDLFileRank, newDLFileRank);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileRank.class,
				DLFileRank.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileRankId", nextLong()));

		List<DLFileRank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected DLFileRank addDLFileRank() throws Exception {
		long pk = nextLong();

		DLFileRank dlFileRank = _persistence.create(pk);

		dlFileRank.setGroupId(nextLong());
		dlFileRank.setCompanyId(nextLong());
		dlFileRank.setUserId(nextLong());
		dlFileRank.setCreateDate(nextDate());
		dlFileRank.setFileEntryId(nextLong());

		_persistence.update(dlFileRank, false);

		return dlFileRank;
	}

	private DLFileRankPersistence _persistence;
}