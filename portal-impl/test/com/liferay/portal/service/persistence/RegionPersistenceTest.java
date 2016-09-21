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

import com.liferay.portal.NoSuchRegionException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class RegionPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (RegionPersistence)PortalBeanLocatorUtil.locate(RegionPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Region region = _persistence.create(pk);

		assertNotNull(region);

		assertEquals(region.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Region newRegion = addRegion();

		_persistence.remove(newRegion);

		Region existingRegion = _persistence.fetchByPrimaryKey(newRegion.getPrimaryKey());

		assertNull(existingRegion);
	}

	public void testUpdateNew() throws Exception {
		addRegion();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Region newRegion = _persistence.create(pk);

		newRegion.setCountryId(nextLong());
		newRegion.setRegionCode(randomString());
		newRegion.setName(randomString());
		newRegion.setActive(randomBoolean());

		_persistence.update(newRegion, false);

		Region existingRegion = _persistence.findByPrimaryKey(newRegion.getPrimaryKey());

		assertEquals(existingRegion.getRegionId(), newRegion.getRegionId());
		assertEquals(existingRegion.getCountryId(), newRegion.getCountryId());
		assertEquals(existingRegion.getRegionCode(), newRegion.getRegionCode());
		assertEquals(existingRegion.getName(), newRegion.getName());
		assertEquals(existingRegion.getActive(), newRegion.getActive());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Region newRegion = addRegion();

		Region existingRegion = _persistence.findByPrimaryKey(newRegion.getPrimaryKey());

		assertEquals(existingRegion, newRegion);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchRegionException");
		}
		catch (NoSuchRegionException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Region newRegion = addRegion();

		Region existingRegion = _persistence.fetchByPrimaryKey(newRegion.getPrimaryKey());

		assertEquals(existingRegion, newRegion);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Region missingRegion = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingRegion);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Region newRegion = addRegion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Region.class,
				Region.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("regionId",
				newRegion.getRegionId()));

		List<Region> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Region existingRegion = result.get(0);

		assertEquals(existingRegion, newRegion);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Region.class,
				Region.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("regionId", nextLong()));

		List<Region> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Region addRegion() throws Exception {
		long pk = nextLong();

		Region region = _persistence.create(pk);

		region.setCountryId(nextLong());
		region.setRegionCode(randomString());
		region.setName(randomString());
		region.setActive(randomBoolean());

		_persistence.update(region, false);

		return region;
	}

	private RegionPersistence _persistence;
}