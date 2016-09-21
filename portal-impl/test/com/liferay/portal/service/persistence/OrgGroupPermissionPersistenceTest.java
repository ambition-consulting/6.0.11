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

import com.liferay.portal.NoSuchOrgGroupPermissionException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.OrgGroupPermission;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class OrgGroupPermissionPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (OrgGroupPermissionPersistence)PortalBeanLocatorUtil.locate(OrgGroupPermissionPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		OrgGroupPermissionPK pk = new OrgGroupPermissionPK(nextLong(),
				nextLong(), nextLong());

		OrgGroupPermission orgGroupPermission = _persistence.create(pk);

		assertNotNull(orgGroupPermission);

		assertEquals(orgGroupPermission.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		OrgGroupPermission newOrgGroupPermission = addOrgGroupPermission();

		_persistence.remove(newOrgGroupPermission);

		OrgGroupPermission existingOrgGroupPermission = _persistence.fetchByPrimaryKey(newOrgGroupPermission.getPrimaryKey());

		assertNull(existingOrgGroupPermission);
	}

	public void testUpdateNew() throws Exception {
		addOrgGroupPermission();
	}

	public void testUpdateExisting() throws Exception {
		OrgGroupPermissionPK pk = new OrgGroupPermissionPK(nextLong(),
				nextLong(), nextLong());

		OrgGroupPermission newOrgGroupPermission = _persistence.create(pk);

		_persistence.update(newOrgGroupPermission, false);

		OrgGroupPermission existingOrgGroupPermission = _persistence.findByPrimaryKey(newOrgGroupPermission.getPrimaryKey());

		assertEquals(existingOrgGroupPermission.getOrganizationId(),
			newOrgGroupPermission.getOrganizationId());
		assertEquals(existingOrgGroupPermission.getGroupId(),
			newOrgGroupPermission.getGroupId());
		assertEquals(existingOrgGroupPermission.getPermissionId(),
			newOrgGroupPermission.getPermissionId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		OrgGroupPermission newOrgGroupPermission = addOrgGroupPermission();

		OrgGroupPermission existingOrgGroupPermission = _persistence.findByPrimaryKey(newOrgGroupPermission.getPrimaryKey());

		assertEquals(existingOrgGroupPermission, newOrgGroupPermission);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		OrgGroupPermissionPK pk = new OrgGroupPermissionPK(nextLong(),
				nextLong(), nextLong());

		try {
			_persistence.findByPrimaryKey(pk);

			fail(
				"Missing entity did not throw NoSuchOrgGroupPermissionException");
		}
		catch (NoSuchOrgGroupPermissionException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		OrgGroupPermission newOrgGroupPermission = addOrgGroupPermission();

		OrgGroupPermission existingOrgGroupPermission = _persistence.fetchByPrimaryKey(newOrgGroupPermission.getPrimaryKey());

		assertEquals(existingOrgGroupPermission, newOrgGroupPermission);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		OrgGroupPermissionPK pk = new OrgGroupPermissionPK(nextLong(),
				nextLong(), nextLong());

		OrgGroupPermission missingOrgGroupPermission = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingOrgGroupPermission);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		OrgGroupPermission newOrgGroupPermission = addOrgGroupPermission();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OrgGroupPermission.class,
				OrgGroupPermission.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.organizationId",
				newOrgGroupPermission.getOrganizationId()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.groupId",
				newOrgGroupPermission.getGroupId()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.permissionId",
				newOrgGroupPermission.getPermissionId()));

		List<OrgGroupPermission> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		OrgGroupPermission existingOrgGroupPermission = result.get(0);

		assertEquals(existingOrgGroupPermission, newOrgGroupPermission);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OrgGroupPermission.class,
				OrgGroupPermission.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.organizationId",
				nextLong()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.groupId", nextLong()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.permissionId",
				nextLong()));

		List<OrgGroupPermission> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected OrgGroupPermission addOrgGroupPermission()
		throws Exception {
		OrgGroupPermissionPK pk = new OrgGroupPermissionPK(nextLong(),
				nextLong(), nextLong());

		OrgGroupPermission orgGroupPermission = _persistence.create(pk);

		_persistence.update(orgGroupPermission, false);

		return orgGroupPermission;
	}

	private OrgGroupPermissionPersistence _persistence;
}