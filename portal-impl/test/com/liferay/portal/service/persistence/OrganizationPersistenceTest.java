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

import com.liferay.portal.NoSuchOrganizationException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (OrganizationPersistence)PortalBeanLocatorUtil.locate(OrganizationPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Organization organization = _persistence.create(pk);

		assertNotNull(organization);

		assertEquals(organization.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Organization newOrganization = addOrganization();

		_persistence.remove(newOrganization);

		Organization existingOrganization = _persistence.fetchByPrimaryKey(newOrganization.getPrimaryKey());

		assertNull(existingOrganization);
	}

	public void testUpdateNew() throws Exception {
		addOrganization();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Organization newOrganization = _persistence.create(pk);

		newOrganization.setCompanyId(nextLong());
		newOrganization.setLeftOrganizationId(nextLong());
		newOrganization.setRightOrganizationId(nextLong());
		newOrganization.setName(randomString());
		newOrganization.setType(randomString());
		newOrganization.setRecursable(randomBoolean());
		newOrganization.setRegionId(nextLong());
		newOrganization.setCountryId(nextLong());
		newOrganization.setStatusId(nextInt());
		newOrganization.setComments(randomString());

		_persistence.update(newOrganization, false);

		Organization existingOrganization = _persistence.findByPrimaryKey(newOrganization.getPrimaryKey());

		assertEquals(existingOrganization.getOrganizationId(),
			newOrganization.getOrganizationId());
		assertEquals(existingOrganization.getCompanyId(),
			newOrganization.getCompanyId());
		assertEquals(existingOrganization.getParentOrganizationId(),
			newOrganization.getParentOrganizationId());
		assertEquals(existingOrganization.getLeftOrganizationId(),
			newOrganization.getLeftOrganizationId());
		assertEquals(existingOrganization.getRightOrganizationId(),
			newOrganization.getRightOrganizationId());
		assertEquals(existingOrganization.getName(), newOrganization.getName());
		assertEquals(existingOrganization.getType(), newOrganization.getType());
		assertEquals(existingOrganization.getRecursable(),
			newOrganization.getRecursable());
		assertEquals(existingOrganization.getRegionId(),
			newOrganization.getRegionId());
		assertEquals(existingOrganization.getCountryId(),
			newOrganization.getCountryId());
		assertEquals(existingOrganization.getStatusId(),
			newOrganization.getStatusId());
		assertEquals(existingOrganization.getComments(),
			newOrganization.getComments());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Organization newOrganization = addOrganization();

		Organization existingOrganization = _persistence.findByPrimaryKey(newOrganization.getPrimaryKey());

		assertEquals(existingOrganization, newOrganization);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchOrganizationException");
		}
		catch (NoSuchOrganizationException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Organization newOrganization = addOrganization();

		Organization existingOrganization = _persistence.fetchByPrimaryKey(newOrganization.getPrimaryKey());

		assertEquals(existingOrganization, newOrganization);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Organization missingOrganization = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingOrganization);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Organization newOrganization = addOrganization();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Organization.class,
				Organization.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("organizationId",
				newOrganization.getOrganizationId()));

		List<Organization> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Organization existingOrganization = result.get(0);

		assertEquals(existingOrganization, newOrganization);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Organization.class,
				Organization.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("organizationId", nextLong()));

		List<Organization> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Organization addOrganization() throws Exception {
		long pk = nextLong();

		Organization organization = _persistence.create(pk);

		organization.setCompanyId(nextLong());
		organization.setLeftOrganizationId(nextLong());
		organization.setRightOrganizationId(nextLong());
		organization.setName(randomString());
		organization.setType(randomString());
		organization.setRecursable(randomBoolean());
		organization.setRegionId(nextLong());
		organization.setCountryId(nextLong());
		organization.setStatusId(nextInt());
		organization.setComments(randomString());

		_persistence.update(organization, false);

		return organization;
	}

	private OrganizationPersistence _persistence;
}