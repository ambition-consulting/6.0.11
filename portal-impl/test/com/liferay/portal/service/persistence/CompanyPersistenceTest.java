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

import com.liferay.portal.NoSuchCompanyException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class CompanyPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (CompanyPersistence)PortalBeanLocatorUtil.locate(CompanyPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Company company = _persistence.create(pk);

		assertNotNull(company);

		assertEquals(company.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Company newCompany = addCompany();

		_persistence.remove(newCompany);

		Company existingCompany = _persistence.fetchByPrimaryKey(newCompany.getPrimaryKey());

		assertNull(existingCompany);
	}

	public void testUpdateNew() throws Exception {
		addCompany();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Company newCompany = _persistence.create(pk);

		newCompany.setAccountId(nextLong());
		newCompany.setWebId(randomString());
		newCompany.setKey(randomString());
		newCompany.setVirtualHost(randomString());
		newCompany.setMx(randomString());
		newCompany.setHomeURL(randomString());
		newCompany.setLogoId(nextLong());
		newCompany.setSystem(randomBoolean());
		newCompany.setMaxUsers(nextInt());

		_persistence.update(newCompany, false);

		Company existingCompany = _persistence.findByPrimaryKey(newCompany.getPrimaryKey());

		assertEquals(existingCompany.getCompanyId(), newCompany.getCompanyId());
		assertEquals(existingCompany.getAccountId(), newCompany.getAccountId());
		assertEquals(existingCompany.getWebId(), newCompany.getWebId());
		assertEquals(existingCompany.getKey(), newCompany.getKey());
		assertEquals(existingCompany.getVirtualHost(),
			newCompany.getVirtualHost());
		assertEquals(existingCompany.getMx(), newCompany.getMx());
		assertEquals(existingCompany.getHomeURL(), newCompany.getHomeURL());
		assertEquals(existingCompany.getLogoId(), newCompany.getLogoId());
		assertEquals(existingCompany.getSystem(), newCompany.getSystem());
		assertEquals(existingCompany.getMaxUsers(), newCompany.getMaxUsers());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Company newCompany = addCompany();

		Company existingCompany = _persistence.findByPrimaryKey(newCompany.getPrimaryKey());

		assertEquals(existingCompany, newCompany);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchCompanyException");
		}
		catch (NoSuchCompanyException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Company newCompany = addCompany();

		Company existingCompany = _persistence.fetchByPrimaryKey(newCompany.getPrimaryKey());

		assertEquals(existingCompany, newCompany);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Company missingCompany = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingCompany);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Company newCompany = addCompany();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Company.class,
				Company.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId",
				newCompany.getCompanyId()));

		List<Company> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Company existingCompany = result.get(0);

		assertEquals(existingCompany, newCompany);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Company.class,
				Company.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", nextLong()));

		List<Company> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Company addCompany() throws Exception {
		long pk = nextLong();

		Company company = _persistence.create(pk);

		company.setAccountId(nextLong());
		company.setWebId(randomString());
		company.setKey(randomString());
		company.setVirtualHost(randomString());
		company.setMx(randomString());
		company.setHomeURL(randomString());
		company.setLogoId(nextLong());
		company.setSystem(randomBoolean());
		company.setMaxUsers(nextInt());

		_persistence.update(company, false);

		return company;
	}

	private CompanyPersistence _persistence;
}