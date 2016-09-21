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

package com.liferay.portlet.social.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.social.NoSuchEquityAssetEntryException;
import com.liferay.portlet.social.model.SocialEquityAssetEntry;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialEquityAssetEntryPersistenceTest
	extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SocialEquityAssetEntryPersistence)PortalBeanLocatorUtil.locate(SocialEquityAssetEntryPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SocialEquityAssetEntry socialEquityAssetEntry = _persistence.create(pk);

		assertNotNull(socialEquityAssetEntry);

		assertEquals(socialEquityAssetEntry.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SocialEquityAssetEntry newSocialEquityAssetEntry = addSocialEquityAssetEntry();

		_persistence.remove(newSocialEquityAssetEntry);

		SocialEquityAssetEntry existingSocialEquityAssetEntry = _persistence.fetchByPrimaryKey(newSocialEquityAssetEntry.getPrimaryKey());

		assertNull(existingSocialEquityAssetEntry);
	}

	public void testUpdateNew() throws Exception {
		addSocialEquityAssetEntry();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SocialEquityAssetEntry newSocialEquityAssetEntry = _persistence.create(pk);

		newSocialEquityAssetEntry.setGroupId(nextLong());
		newSocialEquityAssetEntry.setCompanyId(nextLong());
		newSocialEquityAssetEntry.setUserId(nextLong());
		newSocialEquityAssetEntry.setAssetEntryId(nextLong());
		newSocialEquityAssetEntry.setInformationK(nextDouble());
		newSocialEquityAssetEntry.setInformationB(nextDouble());

		_persistence.update(newSocialEquityAssetEntry, false);

		SocialEquityAssetEntry existingSocialEquityAssetEntry = _persistence.findByPrimaryKey(newSocialEquityAssetEntry.getPrimaryKey());

		assertEquals(existingSocialEquityAssetEntry.getEquityAssetEntryId(),
			newSocialEquityAssetEntry.getEquityAssetEntryId());
		assertEquals(existingSocialEquityAssetEntry.getGroupId(),
			newSocialEquityAssetEntry.getGroupId());
		assertEquals(existingSocialEquityAssetEntry.getCompanyId(),
			newSocialEquityAssetEntry.getCompanyId());
		assertEquals(existingSocialEquityAssetEntry.getUserId(),
			newSocialEquityAssetEntry.getUserId());
		assertEquals(existingSocialEquityAssetEntry.getAssetEntryId(),
			newSocialEquityAssetEntry.getAssetEntryId());
		assertEquals(existingSocialEquityAssetEntry.getInformationK(),
			newSocialEquityAssetEntry.getInformationK());
		assertEquals(existingSocialEquityAssetEntry.getInformationB(),
			newSocialEquityAssetEntry.getInformationB());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SocialEquityAssetEntry newSocialEquityAssetEntry = addSocialEquityAssetEntry();

		SocialEquityAssetEntry existingSocialEquityAssetEntry = _persistence.findByPrimaryKey(newSocialEquityAssetEntry.getPrimaryKey());

		assertEquals(existingSocialEquityAssetEntry, newSocialEquityAssetEntry);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchEquityAssetEntryException");
		}
		catch (NoSuchEquityAssetEntryException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SocialEquityAssetEntry newSocialEquityAssetEntry = addSocialEquityAssetEntry();

		SocialEquityAssetEntry existingSocialEquityAssetEntry = _persistence.fetchByPrimaryKey(newSocialEquityAssetEntry.getPrimaryKey());

		assertEquals(existingSocialEquityAssetEntry, newSocialEquityAssetEntry);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SocialEquityAssetEntry missingSocialEquityAssetEntry = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSocialEquityAssetEntry);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SocialEquityAssetEntry newSocialEquityAssetEntry = addSocialEquityAssetEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityAssetEntry.class,
				SocialEquityAssetEntry.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityAssetEntryId",
				newSocialEquityAssetEntry.getEquityAssetEntryId()));

		List<SocialEquityAssetEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SocialEquityAssetEntry existingSocialEquityAssetEntry = result.get(0);

		assertEquals(existingSocialEquityAssetEntry, newSocialEquityAssetEntry);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityAssetEntry.class,
				SocialEquityAssetEntry.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityAssetEntryId",
				nextLong()));

		List<SocialEquityAssetEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SocialEquityAssetEntry addSocialEquityAssetEntry()
		throws Exception {
		long pk = nextLong();

		SocialEquityAssetEntry socialEquityAssetEntry = _persistence.create(pk);

		socialEquityAssetEntry.setGroupId(nextLong());
		socialEquityAssetEntry.setCompanyId(nextLong());
		socialEquityAssetEntry.setUserId(nextLong());
		socialEquityAssetEntry.setAssetEntryId(nextLong());
		socialEquityAssetEntry.setInformationK(nextDouble());
		socialEquityAssetEntry.setInformationB(nextDouble());

		_persistence.update(socialEquityAssetEntry, false);

		return socialEquityAssetEntry;
	}

	private SocialEquityAssetEntryPersistence _persistence;
}