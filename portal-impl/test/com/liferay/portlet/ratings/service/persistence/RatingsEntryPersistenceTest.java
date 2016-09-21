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

package com.liferay.portlet.ratings.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.ratings.NoSuchEntryException;
import com.liferay.portlet.ratings.model.RatingsEntry;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class RatingsEntryPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (RatingsEntryPersistence)PortalBeanLocatorUtil.locate(RatingsEntryPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		RatingsEntry ratingsEntry = _persistence.create(pk);

		assertNotNull(ratingsEntry);

		assertEquals(ratingsEntry.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		RatingsEntry newRatingsEntry = addRatingsEntry();

		_persistence.remove(newRatingsEntry);

		RatingsEntry existingRatingsEntry = _persistence.fetchByPrimaryKey(newRatingsEntry.getPrimaryKey());

		assertNull(existingRatingsEntry);
	}

	public void testUpdateNew() throws Exception {
		addRatingsEntry();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		RatingsEntry newRatingsEntry = _persistence.create(pk);

		newRatingsEntry.setCompanyId(nextLong());
		newRatingsEntry.setUserId(nextLong());
		newRatingsEntry.setUserName(randomString());
		newRatingsEntry.setCreateDate(nextDate());
		newRatingsEntry.setModifiedDate(nextDate());
		newRatingsEntry.setClassNameId(nextLong());
		newRatingsEntry.setClassPK(nextLong());
		newRatingsEntry.setScore(nextDouble());

		_persistence.update(newRatingsEntry, false);

		RatingsEntry existingRatingsEntry = _persistence.findByPrimaryKey(newRatingsEntry.getPrimaryKey());

		assertEquals(existingRatingsEntry.getEntryId(),
			newRatingsEntry.getEntryId());
		assertEquals(existingRatingsEntry.getCompanyId(),
			newRatingsEntry.getCompanyId());
		assertEquals(existingRatingsEntry.getUserId(),
			newRatingsEntry.getUserId());
		assertEquals(existingRatingsEntry.getUserName(),
			newRatingsEntry.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingRatingsEntry.getCreateDate()),
			Time.getShortTimestamp(newRatingsEntry.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingRatingsEntry.getModifiedDate()),
			Time.getShortTimestamp(newRatingsEntry.getModifiedDate()));
		assertEquals(existingRatingsEntry.getClassNameId(),
			newRatingsEntry.getClassNameId());
		assertEquals(existingRatingsEntry.getClassPK(),
			newRatingsEntry.getClassPK());
		assertEquals(existingRatingsEntry.getScore(), newRatingsEntry.getScore());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		RatingsEntry newRatingsEntry = addRatingsEntry();

		RatingsEntry existingRatingsEntry = _persistence.findByPrimaryKey(newRatingsEntry.getPrimaryKey());

		assertEquals(existingRatingsEntry, newRatingsEntry);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchEntryException");
		}
		catch (NoSuchEntryException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		RatingsEntry newRatingsEntry = addRatingsEntry();

		RatingsEntry existingRatingsEntry = _persistence.fetchByPrimaryKey(newRatingsEntry.getPrimaryKey());

		assertEquals(existingRatingsEntry, newRatingsEntry);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		RatingsEntry missingRatingsEntry = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingRatingsEntry);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		RatingsEntry newRatingsEntry = addRatingsEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RatingsEntry.class,
				RatingsEntry.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("entryId",
				newRatingsEntry.getEntryId()));

		List<RatingsEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		RatingsEntry existingRatingsEntry = result.get(0);

		assertEquals(existingRatingsEntry, newRatingsEntry);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RatingsEntry.class,
				RatingsEntry.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("entryId", nextLong()));

		List<RatingsEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected RatingsEntry addRatingsEntry() throws Exception {
		long pk = nextLong();

		RatingsEntry ratingsEntry = _persistence.create(pk);

		ratingsEntry.setCompanyId(nextLong());
		ratingsEntry.setUserId(nextLong());
		ratingsEntry.setUserName(randomString());
		ratingsEntry.setCreateDate(nextDate());
		ratingsEntry.setModifiedDate(nextDate());
		ratingsEntry.setClassNameId(nextLong());
		ratingsEntry.setClassPK(nextLong());
		ratingsEntry.setScore(nextDouble());

		_persistence.update(ratingsEntry, false);

		return ratingsEntry;
	}

	private RatingsEntryPersistence _persistence;
}