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

package com.liferay.portlet.announcements.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.announcements.NoSuchFlagException;
import com.liferay.portlet.announcements.model.AnnouncementsFlag;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AnnouncementsFlagPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (AnnouncementsFlagPersistence)PortalBeanLocatorUtil.locate(AnnouncementsFlagPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		AnnouncementsFlag announcementsFlag = _persistence.create(pk);

		assertNotNull(announcementsFlag);

		assertEquals(announcementsFlag.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		AnnouncementsFlag newAnnouncementsFlag = addAnnouncementsFlag();

		_persistence.remove(newAnnouncementsFlag);

		AnnouncementsFlag existingAnnouncementsFlag = _persistence.fetchByPrimaryKey(newAnnouncementsFlag.getPrimaryKey());

		assertNull(existingAnnouncementsFlag);
	}

	public void testUpdateNew() throws Exception {
		addAnnouncementsFlag();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		AnnouncementsFlag newAnnouncementsFlag = _persistence.create(pk);

		newAnnouncementsFlag.setUserId(nextLong());
		newAnnouncementsFlag.setCreateDate(nextDate());
		newAnnouncementsFlag.setEntryId(nextLong());
		newAnnouncementsFlag.setValue(nextInt());

		_persistence.update(newAnnouncementsFlag, false);

		AnnouncementsFlag existingAnnouncementsFlag = _persistence.findByPrimaryKey(newAnnouncementsFlag.getPrimaryKey());

		assertEquals(existingAnnouncementsFlag.getFlagId(),
			newAnnouncementsFlag.getFlagId());
		assertEquals(existingAnnouncementsFlag.getUserId(),
			newAnnouncementsFlag.getUserId());
		assertEquals(Time.getShortTimestamp(
				existingAnnouncementsFlag.getCreateDate()),
			Time.getShortTimestamp(newAnnouncementsFlag.getCreateDate()));
		assertEquals(existingAnnouncementsFlag.getEntryId(),
			newAnnouncementsFlag.getEntryId());
		assertEquals(existingAnnouncementsFlag.getValue(),
			newAnnouncementsFlag.getValue());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		AnnouncementsFlag newAnnouncementsFlag = addAnnouncementsFlag();

		AnnouncementsFlag existingAnnouncementsFlag = _persistence.findByPrimaryKey(newAnnouncementsFlag.getPrimaryKey());

		assertEquals(existingAnnouncementsFlag, newAnnouncementsFlag);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchFlagException");
		}
		catch (NoSuchFlagException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnnouncementsFlag newAnnouncementsFlag = addAnnouncementsFlag();

		AnnouncementsFlag existingAnnouncementsFlag = _persistence.fetchByPrimaryKey(newAnnouncementsFlag.getPrimaryKey());

		assertEquals(existingAnnouncementsFlag, newAnnouncementsFlag);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		AnnouncementsFlag missingAnnouncementsFlag = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingAnnouncementsFlag);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnnouncementsFlag newAnnouncementsFlag = addAnnouncementsFlag();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnnouncementsFlag.class,
				AnnouncementsFlag.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("flagId",
				newAnnouncementsFlag.getFlagId()));

		List<AnnouncementsFlag> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		AnnouncementsFlag existingAnnouncementsFlag = result.get(0);

		assertEquals(existingAnnouncementsFlag, newAnnouncementsFlag);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnnouncementsFlag.class,
				AnnouncementsFlag.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("flagId", nextLong()));

		List<AnnouncementsFlag> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected AnnouncementsFlag addAnnouncementsFlag()
		throws Exception {
		long pk = nextLong();

		AnnouncementsFlag announcementsFlag = _persistence.create(pk);

		announcementsFlag.setUserId(nextLong());
		announcementsFlag.setCreateDate(nextDate());
		announcementsFlag.setEntryId(nextLong());
		announcementsFlag.setValue(nextInt());

		_persistence.update(announcementsFlag, false);

		return announcementsFlag;
	}

	private AnnouncementsFlagPersistence _persistence;
}