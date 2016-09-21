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

import com.liferay.portlet.messageboards.NoSuchCategoryException;
import com.liferay.portlet.messageboards.model.MBCategory;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBCategoryPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (MBCategoryPersistence)PortalBeanLocatorUtil.locate(MBCategoryPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		MBCategory mbCategory = _persistence.create(pk);

		assertNotNull(mbCategory);

		assertEquals(mbCategory.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		MBCategory newMBCategory = addMBCategory();

		_persistence.remove(newMBCategory);

		MBCategory existingMBCategory = _persistence.fetchByPrimaryKey(newMBCategory.getPrimaryKey());

		assertNull(existingMBCategory);
	}

	public void testUpdateNew() throws Exception {
		addMBCategory();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		MBCategory newMBCategory = _persistence.create(pk);

		newMBCategory.setUuid(randomString());
		newMBCategory.setGroupId(nextLong());
		newMBCategory.setCompanyId(nextLong());
		newMBCategory.setUserId(nextLong());
		newMBCategory.setUserName(randomString());
		newMBCategory.setCreateDate(nextDate());
		newMBCategory.setModifiedDate(nextDate());
		newMBCategory.setParentCategoryId(nextLong());
		newMBCategory.setName(randomString());
		newMBCategory.setDescription(randomString());
		newMBCategory.setThreadCount(nextInt());
		newMBCategory.setMessageCount(nextInt());
		newMBCategory.setLastPostDate(nextDate());

		_persistence.update(newMBCategory, false);

		MBCategory existingMBCategory = _persistence.findByPrimaryKey(newMBCategory.getPrimaryKey());

		assertEquals(existingMBCategory.getUuid(), newMBCategory.getUuid());
		assertEquals(existingMBCategory.getCategoryId(),
			newMBCategory.getCategoryId());
		assertEquals(existingMBCategory.getGroupId(), newMBCategory.getGroupId());
		assertEquals(existingMBCategory.getCompanyId(),
			newMBCategory.getCompanyId());
		assertEquals(existingMBCategory.getUserId(), newMBCategory.getUserId());
		assertEquals(existingMBCategory.getUserName(),
			newMBCategory.getUserName());
		assertEquals(Time.getShortTimestamp(existingMBCategory.getCreateDate()),
			Time.getShortTimestamp(newMBCategory.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingMBCategory.getModifiedDate()),
			Time.getShortTimestamp(newMBCategory.getModifiedDate()));
		assertEquals(existingMBCategory.getParentCategoryId(),
			newMBCategory.getParentCategoryId());
		assertEquals(existingMBCategory.getName(), newMBCategory.getName());
		assertEquals(existingMBCategory.getDescription(),
			newMBCategory.getDescription());
		assertEquals(existingMBCategory.getThreadCount(),
			newMBCategory.getThreadCount());
		assertEquals(existingMBCategory.getMessageCount(),
			newMBCategory.getMessageCount());
		assertEquals(Time.getShortTimestamp(
				existingMBCategory.getLastPostDate()),
			Time.getShortTimestamp(newMBCategory.getLastPostDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		MBCategory newMBCategory = addMBCategory();

		MBCategory existingMBCategory = _persistence.findByPrimaryKey(newMBCategory.getPrimaryKey());

		assertEquals(existingMBCategory, newMBCategory);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchCategoryException");
		}
		catch (NoSuchCategoryException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		MBCategory newMBCategory = addMBCategory();

		MBCategory existingMBCategory = _persistence.fetchByPrimaryKey(newMBCategory.getPrimaryKey());

		assertEquals(existingMBCategory, newMBCategory);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		MBCategory missingMBCategory = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingMBCategory);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		MBCategory newMBCategory = addMBCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBCategory.class,
				MBCategory.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("categoryId",
				newMBCategory.getCategoryId()));

		List<MBCategory> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		MBCategory existingMBCategory = result.get(0);

		assertEquals(existingMBCategory, newMBCategory);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBCategory.class,
				MBCategory.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("categoryId", nextLong()));

		List<MBCategory> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected MBCategory addMBCategory() throws Exception {
		long pk = nextLong();

		MBCategory mbCategory = _persistence.create(pk);

		mbCategory.setUuid(randomString());
		mbCategory.setGroupId(nextLong());
		mbCategory.setCompanyId(nextLong());
		mbCategory.setUserId(nextLong());
		mbCategory.setUserName(randomString());
		mbCategory.setCreateDate(nextDate());
		mbCategory.setModifiedDate(nextDate());
		mbCategory.setParentCategoryId(nextLong());
		mbCategory.setName(randomString());
		mbCategory.setDescription(randomString());
		mbCategory.setThreadCount(nextInt());
		mbCategory.setMessageCount(nextInt());
		mbCategory.setLastPostDate(nextDate());

		_persistence.update(mbCategory, false);

		return mbCategory;
	}

	private MBCategoryPersistence _persistence;
}