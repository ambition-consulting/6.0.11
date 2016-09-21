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

import com.liferay.portal.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourcePermissionPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ResourcePermissionPersistence)PortalBeanLocatorUtil.locate(ResourcePermissionPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ResourcePermission resourcePermission = _persistence.create(pk);

		assertNotNull(resourcePermission);

		assertEquals(resourcePermission.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ResourcePermission newResourcePermission = addResourcePermission();

		_persistence.remove(newResourcePermission);

		ResourcePermission existingResourcePermission = _persistence.fetchByPrimaryKey(newResourcePermission.getPrimaryKey());

		assertNull(existingResourcePermission);
	}

	public void testUpdateNew() throws Exception {
		addResourcePermission();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ResourcePermission newResourcePermission = _persistence.create(pk);

		newResourcePermission.setCompanyId(nextLong());
		newResourcePermission.setName(randomString());
		newResourcePermission.setScope(nextInt());
		newResourcePermission.setPrimKey(randomString());
		newResourcePermission.setRoleId(nextLong());
		newResourcePermission.setActionIds(nextLong());

		_persistence.update(newResourcePermission, false);

		ResourcePermission existingResourcePermission = _persistence.findByPrimaryKey(newResourcePermission.getPrimaryKey());

		assertEquals(existingResourcePermission.getResourcePermissionId(),
			newResourcePermission.getResourcePermissionId());
		assertEquals(existingResourcePermission.getCompanyId(),
			newResourcePermission.getCompanyId());
		assertEquals(existingResourcePermission.getName(),
			newResourcePermission.getName());
		assertEquals(existingResourcePermission.getScope(),
			newResourcePermission.getScope());
		assertEquals(existingResourcePermission.getPrimKey(),
			newResourcePermission.getPrimKey());
		assertEquals(existingResourcePermission.getRoleId(),
			newResourcePermission.getRoleId());
		assertEquals(existingResourcePermission.getActionIds(),
			newResourcePermission.getActionIds());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ResourcePermission newResourcePermission = addResourcePermission();

		ResourcePermission existingResourcePermission = _persistence.findByPrimaryKey(newResourcePermission.getPrimaryKey());

		assertEquals(existingResourcePermission, newResourcePermission);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail(
				"Missing entity did not throw NoSuchResourcePermissionException");
		}
		catch (NoSuchResourcePermissionException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ResourcePermission newResourcePermission = addResourcePermission();

		ResourcePermission existingResourcePermission = _persistence.fetchByPrimaryKey(newResourcePermission.getPrimaryKey());

		assertEquals(existingResourcePermission, newResourcePermission);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ResourcePermission missingResourcePermission = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingResourcePermission);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ResourcePermission newResourcePermission = addResourcePermission();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ResourcePermission.class,
				ResourcePermission.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourcePermissionId",
				newResourcePermission.getResourcePermissionId()));

		List<ResourcePermission> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ResourcePermission existingResourcePermission = result.get(0);

		assertEquals(existingResourcePermission, newResourcePermission);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ResourcePermission.class,
				ResourcePermission.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourcePermissionId",
				nextLong()));

		List<ResourcePermission> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ResourcePermission addResourcePermission()
		throws Exception {
		long pk = nextLong();

		ResourcePermission resourcePermission = _persistence.create(pk);

		resourcePermission.setCompanyId(nextLong());
		resourcePermission.setName(randomString());
		resourcePermission.setScope(nextInt());
		resourcePermission.setPrimKey(randomString());
		resourcePermission.setRoleId(nextLong());
		resourcePermission.setActionIds(nextLong());

		_persistence.update(resourcePermission, false);

		return resourcePermission;
	}

	private ResourcePermissionPersistence _persistence;
}