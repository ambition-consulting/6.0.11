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

import com.liferay.portal.NoSuchUserGroupException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (UserGroupPersistence)PortalBeanLocatorUtil.locate(UserGroupPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		UserGroup userGroup = _persistence.create(pk);

		assertNotNull(userGroup);

		assertEquals(userGroup.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		UserGroup newUserGroup = addUserGroup();

		_persistence.remove(newUserGroup);

		UserGroup existingUserGroup = _persistence.fetchByPrimaryKey(newUserGroup.getPrimaryKey());

		assertNull(existingUserGroup);
	}

	public void testUpdateNew() throws Exception {
		addUserGroup();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		UserGroup newUserGroup = _persistence.create(pk);

		newUserGroup.setCompanyId(nextLong());
		newUserGroup.setParentUserGroupId(nextLong());
		newUserGroup.setName(randomString());
		newUserGroup.setDescription(randomString());

		_persistence.update(newUserGroup, false);

		UserGroup existingUserGroup = _persistence.findByPrimaryKey(newUserGroup.getPrimaryKey());

		assertEquals(existingUserGroup.getUserGroupId(),
			newUserGroup.getUserGroupId());
		assertEquals(existingUserGroup.getCompanyId(),
			newUserGroup.getCompanyId());
		assertEquals(existingUserGroup.getParentUserGroupId(),
			newUserGroup.getParentUserGroupId());
		assertEquals(existingUserGroup.getName(), newUserGroup.getName());
		assertEquals(existingUserGroup.getDescription(),
			newUserGroup.getDescription());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		UserGroup newUserGroup = addUserGroup();

		UserGroup existingUserGroup = _persistence.findByPrimaryKey(newUserGroup.getPrimaryKey());

		assertEquals(existingUserGroup, newUserGroup);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchUserGroupException");
		}
		catch (NoSuchUserGroupException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserGroup newUserGroup = addUserGroup();

		UserGroup existingUserGroup = _persistence.fetchByPrimaryKey(newUserGroup.getPrimaryKey());

		assertEquals(existingUserGroup, newUserGroup);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		UserGroup missingUserGroup = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingUserGroup);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserGroup newUserGroup = addUserGroup();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserGroup.class,
				UserGroup.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userGroupId",
				newUserGroup.getUserGroupId()));

		List<UserGroup> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		UserGroup existingUserGroup = result.get(0);

		assertEquals(existingUserGroup, newUserGroup);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserGroup.class,
				UserGroup.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userGroupId", nextLong()));

		List<UserGroup> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected UserGroup addUserGroup() throws Exception {
		long pk = nextLong();

		UserGroup userGroup = _persistence.create(pk);

		userGroup.setCompanyId(nextLong());
		userGroup.setParentUserGroupId(nextLong());
		userGroup.setName(randomString());
		userGroup.setDescription(randomString());

		_persistence.update(userGroup, false);

		return userGroup;
	}

	private UserGroupPersistence _persistence;
}