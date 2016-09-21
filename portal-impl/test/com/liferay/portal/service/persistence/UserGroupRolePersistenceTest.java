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

import com.liferay.portal.NoSuchUserGroupRoleException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupRolePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (UserGroupRolePersistence)PortalBeanLocatorUtil.locate(UserGroupRolePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		UserGroupRolePK pk = new UserGroupRolePK(nextLong(), nextLong(),
				nextLong());

		UserGroupRole userGroupRole = _persistence.create(pk);

		assertNotNull(userGroupRole);

		assertEquals(userGroupRole.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		UserGroupRole newUserGroupRole = addUserGroupRole();

		_persistence.remove(newUserGroupRole);

		UserGroupRole existingUserGroupRole = _persistence.fetchByPrimaryKey(newUserGroupRole.getPrimaryKey());

		assertNull(existingUserGroupRole);
	}

	public void testUpdateNew() throws Exception {
		addUserGroupRole();
	}

	public void testUpdateExisting() throws Exception {
		UserGroupRolePK pk = new UserGroupRolePK(nextLong(), nextLong(),
				nextLong());

		UserGroupRole newUserGroupRole = _persistence.create(pk);

		_persistence.update(newUserGroupRole, false);

		UserGroupRole existingUserGroupRole = _persistence.findByPrimaryKey(newUserGroupRole.getPrimaryKey());

		assertEquals(existingUserGroupRole.getUserId(),
			newUserGroupRole.getUserId());
		assertEquals(existingUserGroupRole.getGroupId(),
			newUserGroupRole.getGroupId());
		assertEquals(existingUserGroupRole.getRoleId(),
			newUserGroupRole.getRoleId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		UserGroupRole newUserGroupRole = addUserGroupRole();

		UserGroupRole existingUserGroupRole = _persistence.findByPrimaryKey(newUserGroupRole.getPrimaryKey());

		assertEquals(existingUserGroupRole, newUserGroupRole);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		UserGroupRolePK pk = new UserGroupRolePK(nextLong(), nextLong(),
				nextLong());

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchUserGroupRoleException");
		}
		catch (NoSuchUserGroupRoleException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserGroupRole newUserGroupRole = addUserGroupRole();

		UserGroupRole existingUserGroupRole = _persistence.fetchByPrimaryKey(newUserGroupRole.getPrimaryKey());

		assertEquals(existingUserGroupRole, newUserGroupRole);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		UserGroupRolePK pk = new UserGroupRolePK(nextLong(), nextLong(),
				nextLong());

		UserGroupRole missingUserGroupRole = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingUserGroupRole);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserGroupRole newUserGroupRole = addUserGroupRole();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserGroupRole.class,
				UserGroupRole.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.userId",
				newUserGroupRole.getUserId()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.groupId",
				newUserGroupRole.getGroupId()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.roleId",
				newUserGroupRole.getRoleId()));

		List<UserGroupRole> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		UserGroupRole existingUserGroupRole = result.get(0);

		assertEquals(existingUserGroupRole, newUserGroupRole);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserGroupRole.class,
				UserGroupRole.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.userId", nextLong()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.groupId", nextLong()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("id.roleId", nextLong()));

		List<UserGroupRole> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected UserGroupRole addUserGroupRole() throws Exception {
		UserGroupRolePK pk = new UserGroupRolePK(nextLong(), nextLong(),
				nextLong());

		UserGroupRole userGroupRole = _persistence.create(pk);

		_persistence.update(userGroupRole, false);

		return userGroupRole;
	}

	private UserGroupRolePersistence _persistence;
}