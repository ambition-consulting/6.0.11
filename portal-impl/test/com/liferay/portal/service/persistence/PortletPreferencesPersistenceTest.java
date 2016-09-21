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

import com.liferay.portal.NoSuchPortletPreferencesException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletPreferencesPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (PortletPreferencesPersistence)PortalBeanLocatorUtil.locate(PortletPreferencesPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		PortletPreferences portletPreferences = _persistence.create(pk);

		assertNotNull(portletPreferences);

		assertEquals(portletPreferences.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		PortletPreferences newPortletPreferences = addPortletPreferences();

		_persistence.remove(newPortletPreferences);

		PortletPreferences existingPortletPreferences = _persistence.fetchByPrimaryKey(newPortletPreferences.getPrimaryKey());

		assertNull(existingPortletPreferences);
	}

	public void testUpdateNew() throws Exception {
		addPortletPreferences();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		PortletPreferences newPortletPreferences = _persistence.create(pk);

		newPortletPreferences.setOwnerId(nextLong());
		newPortletPreferences.setOwnerType(nextInt());
		newPortletPreferences.setPlid(nextLong());
		newPortletPreferences.setPortletId(randomString());
		newPortletPreferences.setPreferences(randomString());

		_persistence.update(newPortletPreferences, false);

		PortletPreferences existingPortletPreferences = _persistence.findByPrimaryKey(newPortletPreferences.getPrimaryKey());

		assertEquals(existingPortletPreferences.getPortletPreferencesId(),
			newPortletPreferences.getPortletPreferencesId());
		assertEquals(existingPortletPreferences.getOwnerId(),
			newPortletPreferences.getOwnerId());
		assertEquals(existingPortletPreferences.getOwnerType(),
			newPortletPreferences.getOwnerType());
		assertEquals(existingPortletPreferences.getPlid(),
			newPortletPreferences.getPlid());
		assertEquals(existingPortletPreferences.getPortletId(),
			newPortletPreferences.getPortletId());
		assertEquals(existingPortletPreferences.getPreferences(),
			newPortletPreferences.getPreferences());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		PortletPreferences newPortletPreferences = addPortletPreferences();

		PortletPreferences existingPortletPreferences = _persistence.findByPrimaryKey(newPortletPreferences.getPrimaryKey());

		assertEquals(existingPortletPreferences, newPortletPreferences);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail(
				"Missing entity did not throw NoSuchPortletPreferencesException");
		}
		catch (NoSuchPortletPreferencesException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		PortletPreferences newPortletPreferences = addPortletPreferences();

		PortletPreferences existingPortletPreferences = _persistence.fetchByPrimaryKey(newPortletPreferences.getPrimaryKey());

		assertEquals(existingPortletPreferences, newPortletPreferences);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		PortletPreferences missingPortletPreferences = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingPortletPreferences);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PortletPreferences newPortletPreferences = addPortletPreferences();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PortletPreferences.class,
				PortletPreferences.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("portletPreferencesId",
				newPortletPreferences.getPortletPreferencesId()));

		List<PortletPreferences> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		PortletPreferences existingPortletPreferences = result.get(0);

		assertEquals(existingPortletPreferences, newPortletPreferences);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PortletPreferences.class,
				PortletPreferences.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("portletPreferencesId",
				nextLong()));

		List<PortletPreferences> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected PortletPreferences addPortletPreferences()
		throws Exception {
		long pk = nextLong();

		PortletPreferences portletPreferences = _persistence.create(pk);

		portletPreferences.setOwnerId(nextLong());
		portletPreferences.setOwnerType(nextInt());
		portletPreferences.setPlid(nextLong());
		portletPreferences.setPortletId(randomString());
		portletPreferences.setPreferences(randomString());

		_persistence.update(portletPreferences, false);

		return portletPreferences;
	}

	private PortletPreferencesPersistence _persistence;
}