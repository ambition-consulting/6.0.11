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

import com.liferay.portlet.documentlibrary.NoSuchFileVersionException;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileVersionPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (DLFileVersionPersistence)PortalBeanLocatorUtil.locate(DLFileVersionPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		DLFileVersion dlFileVersion = _persistence.create(pk);

		assertNotNull(dlFileVersion);

		assertEquals(dlFileVersion.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		_persistence.remove(newDLFileVersion);

		DLFileVersion existingDLFileVersion = _persistence.fetchByPrimaryKey(newDLFileVersion.getPrimaryKey());

		assertNull(existingDLFileVersion);
	}

	public void testUpdateNew() throws Exception {
		addDLFileVersion();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		DLFileVersion newDLFileVersion = _persistence.create(pk);

		newDLFileVersion.setGroupId(nextLong());
		newDLFileVersion.setCompanyId(nextLong());
		newDLFileVersion.setUserId(nextLong());
		newDLFileVersion.setUserName(randomString());
		newDLFileVersion.setCreateDate(nextDate());
		newDLFileVersion.setFileEntryId(nextLong());
		newDLFileVersion.setExtension(randomString());
		newDLFileVersion.setTitle(randomString());
		newDLFileVersion.setDescription(randomString());
		newDLFileVersion.setChangeLog(randomString());
		newDLFileVersion.setExtraSettings(randomString());
		newDLFileVersion.setVersion(randomString());
		newDLFileVersion.setSize(nextLong());
		newDLFileVersion.setStatus(nextInt());
		newDLFileVersion.setStatusByUserId(nextLong());
		newDLFileVersion.setStatusByUserName(randomString());
		newDLFileVersion.setStatusDate(nextDate());

		_persistence.update(newDLFileVersion, false);

		DLFileVersion existingDLFileVersion = _persistence.findByPrimaryKey(newDLFileVersion.getPrimaryKey());

		assertEquals(existingDLFileVersion.getFileVersionId(),
			newDLFileVersion.getFileVersionId());
		assertEquals(existingDLFileVersion.getGroupId(),
			newDLFileVersion.getGroupId());
		assertEquals(existingDLFileVersion.getCompanyId(),
			newDLFileVersion.getCompanyId());
		assertEquals(existingDLFileVersion.getUserId(),
			newDLFileVersion.getUserId());
		assertEquals(existingDLFileVersion.getUserName(),
			newDLFileVersion.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingDLFileVersion.getCreateDate()),
			Time.getShortTimestamp(newDLFileVersion.getCreateDate()));
		assertEquals(existingDLFileVersion.getFileEntryId(),
			newDLFileVersion.getFileEntryId());
		assertEquals(existingDLFileVersion.getExtension(),
			newDLFileVersion.getExtension());
		assertEquals(existingDLFileVersion.getTitle(),
			newDLFileVersion.getTitle());
		assertEquals(existingDLFileVersion.getDescription(),
			newDLFileVersion.getDescription());
		assertEquals(existingDLFileVersion.getChangeLog(),
			newDLFileVersion.getChangeLog());
		assertEquals(existingDLFileVersion.getExtraSettings(),
			newDLFileVersion.getExtraSettings());
		assertEquals(existingDLFileVersion.getVersion(),
			newDLFileVersion.getVersion());
		assertEquals(existingDLFileVersion.getSize(), newDLFileVersion.getSize());
		assertEquals(existingDLFileVersion.getStatus(),
			newDLFileVersion.getStatus());
		assertEquals(existingDLFileVersion.getStatusByUserId(),
			newDLFileVersion.getStatusByUserId());
		assertEquals(existingDLFileVersion.getStatusByUserName(),
			newDLFileVersion.getStatusByUserName());
		assertEquals(Time.getShortTimestamp(
				existingDLFileVersion.getStatusDate()),
			Time.getShortTimestamp(newDLFileVersion.getStatusDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DLFileVersion existingDLFileVersion = _persistence.findByPrimaryKey(newDLFileVersion.getPrimaryKey());

		assertEquals(existingDLFileVersion, newDLFileVersion);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchFileVersionException");
		}
		catch (NoSuchFileVersionException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DLFileVersion existingDLFileVersion = _persistence.fetchByPrimaryKey(newDLFileVersion.getPrimaryKey());

		assertEquals(existingDLFileVersion, newDLFileVersion);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		DLFileVersion missingDLFileVersion = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingDLFileVersion);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileVersion.class,
				DLFileVersion.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileVersionId",
				newDLFileVersion.getFileVersionId()));

		List<DLFileVersion> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		DLFileVersion existingDLFileVersion = result.get(0);

		assertEquals(existingDLFileVersion, newDLFileVersion);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileVersion.class,
				DLFileVersion.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileVersionId", nextLong()));

		List<DLFileVersion> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected DLFileVersion addDLFileVersion() throws Exception {
		long pk = nextLong();

		DLFileVersion dlFileVersion = _persistence.create(pk);

		dlFileVersion.setGroupId(nextLong());
		dlFileVersion.setCompanyId(nextLong());
		dlFileVersion.setUserId(nextLong());
		dlFileVersion.setUserName(randomString());
		dlFileVersion.setCreateDate(nextDate());
		dlFileVersion.setFileEntryId(nextLong());
		dlFileVersion.setExtension(randomString());
		dlFileVersion.setTitle(randomString());
		dlFileVersion.setDescription(randomString());
		dlFileVersion.setChangeLog(randomString());
		dlFileVersion.setExtraSettings(randomString());
		dlFileVersion.setVersion(randomString());
		dlFileVersion.setSize(nextLong());
		dlFileVersion.setStatus(nextInt());
		dlFileVersion.setStatusByUserId(nextLong());
		dlFileVersion.setStatusByUserName(randomString());
		dlFileVersion.setStatusDate(nextDate());

		_persistence.update(dlFileVersion, false);

		return dlFileVersion;
	}

	private DLFileVersionPersistence _persistence;
}