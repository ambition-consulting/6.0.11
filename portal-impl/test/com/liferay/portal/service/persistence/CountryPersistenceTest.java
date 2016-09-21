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

import com.liferay.portal.NoSuchCountryException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class CountryPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (CountryPersistence)PortalBeanLocatorUtil.locate(CountryPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Country country = _persistence.create(pk);

		assertNotNull(country);

		assertEquals(country.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Country newCountry = addCountry();

		_persistence.remove(newCountry);

		Country existingCountry = _persistence.fetchByPrimaryKey(newCountry.getPrimaryKey());

		assertNull(existingCountry);
	}

	public void testUpdateNew() throws Exception {
		addCountry();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Country newCountry = _persistence.create(pk);

		newCountry.setName(randomString());
		newCountry.setA2(randomString());
		newCountry.setA3(randomString());
		newCountry.setNumber(randomString());
		newCountry.setIdd(randomString());
		newCountry.setActive(randomBoolean());

		_persistence.update(newCountry, false);

		Country existingCountry = _persistence.findByPrimaryKey(newCountry.getPrimaryKey());

		assertEquals(existingCountry.getCountryId(), newCountry.getCountryId());
		assertEquals(existingCountry.getName(), newCountry.getName());
		assertEquals(existingCountry.getA2(), newCountry.getA2());
		assertEquals(existingCountry.getA3(), newCountry.getA3());
		assertEquals(existingCountry.getNumber(), newCountry.getNumber());
		assertEquals(existingCountry.getIdd(), newCountry.getIdd());
		assertEquals(existingCountry.getActive(), newCountry.getActive());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Country newCountry = addCountry();

		Country existingCountry = _persistence.findByPrimaryKey(newCountry.getPrimaryKey());

		assertEquals(existingCountry, newCountry);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchCountryException");
		}
		catch (NoSuchCountryException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Country newCountry = addCountry();

		Country existingCountry = _persistence.fetchByPrimaryKey(newCountry.getPrimaryKey());

		assertEquals(existingCountry, newCountry);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Country missingCountry = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingCountry);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Country newCountry = addCountry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Country.class,
				Country.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("countryId",
				newCountry.getCountryId()));

		List<Country> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Country existingCountry = result.get(0);

		assertEquals(existingCountry, newCountry);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Country.class,
				Country.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("countryId", nextLong()));

		List<Country> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Country addCountry() throws Exception {
		long pk = nextLong();

		Country country = _persistence.create(pk);

		country.setName(randomString());
		country.setA2(randomString());
		country.setA3(randomString());
		country.setNumber(randomString());
		country.setIdd(randomString());
		country.setActive(randomBoolean());

		_persistence.update(country, false);

		return country;
	}

	private CountryPersistence _persistence;
}