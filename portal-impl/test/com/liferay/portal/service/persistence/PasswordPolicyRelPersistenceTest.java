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

import com.liferay.portal.NoSuchPasswordPolicyRelException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.PasswordPolicyRel;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PasswordPolicyRelPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (PasswordPolicyRelPersistence)PortalBeanLocatorUtil.locate(PasswordPolicyRelPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		PasswordPolicyRel passwordPolicyRel = _persistence.create(pk);

		assertNotNull(passwordPolicyRel);

		assertEquals(passwordPolicyRel.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		PasswordPolicyRel newPasswordPolicyRel = addPasswordPolicyRel();

		_persistence.remove(newPasswordPolicyRel);

		PasswordPolicyRel existingPasswordPolicyRel = _persistence.fetchByPrimaryKey(newPasswordPolicyRel.getPrimaryKey());

		assertNull(existingPasswordPolicyRel);
	}

	public void testUpdateNew() throws Exception {
		addPasswordPolicyRel();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		PasswordPolicyRel newPasswordPolicyRel = _persistence.create(pk);

		newPasswordPolicyRel.setPasswordPolicyId(nextLong());
		newPasswordPolicyRel.setClassNameId(nextLong());
		newPasswordPolicyRel.setClassPK(nextLong());

		_persistence.update(newPasswordPolicyRel, false);

		PasswordPolicyRel existingPasswordPolicyRel = _persistence.findByPrimaryKey(newPasswordPolicyRel.getPrimaryKey());

		assertEquals(existingPasswordPolicyRel.getPasswordPolicyRelId(),
			newPasswordPolicyRel.getPasswordPolicyRelId());
		assertEquals(existingPasswordPolicyRel.getPasswordPolicyId(),
			newPasswordPolicyRel.getPasswordPolicyId());
		assertEquals(existingPasswordPolicyRel.getClassNameId(),
			newPasswordPolicyRel.getClassNameId());
		assertEquals(existingPasswordPolicyRel.getClassPK(),
			newPasswordPolicyRel.getClassPK());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		PasswordPolicyRel newPasswordPolicyRel = addPasswordPolicyRel();

		PasswordPolicyRel existingPasswordPolicyRel = _persistence.findByPrimaryKey(newPasswordPolicyRel.getPrimaryKey());

		assertEquals(existingPasswordPolicyRel, newPasswordPolicyRel);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail(
				"Missing entity did not throw NoSuchPasswordPolicyRelException");
		}
		catch (NoSuchPasswordPolicyRelException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		PasswordPolicyRel newPasswordPolicyRel = addPasswordPolicyRel();

		PasswordPolicyRel existingPasswordPolicyRel = _persistence.fetchByPrimaryKey(newPasswordPolicyRel.getPrimaryKey());

		assertEquals(existingPasswordPolicyRel, newPasswordPolicyRel);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		PasswordPolicyRel missingPasswordPolicyRel = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingPasswordPolicyRel);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PasswordPolicyRel newPasswordPolicyRel = addPasswordPolicyRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PasswordPolicyRel.class,
				PasswordPolicyRel.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("passwordPolicyRelId",
				newPasswordPolicyRel.getPasswordPolicyRelId()));

		List<PasswordPolicyRel> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		PasswordPolicyRel existingPasswordPolicyRel = result.get(0);

		assertEquals(existingPasswordPolicyRel, newPasswordPolicyRel);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PasswordPolicyRel.class,
				PasswordPolicyRel.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("passwordPolicyRelId",
				nextLong()));

		List<PasswordPolicyRel> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected PasswordPolicyRel addPasswordPolicyRel()
		throws Exception {
		long pk = nextLong();

		PasswordPolicyRel passwordPolicyRel = _persistence.create(pk);

		passwordPolicyRel.setPasswordPolicyId(nextLong());
		passwordPolicyRel.setClassNameId(nextLong());
		passwordPolicyRel.setClassPK(nextLong());

		_persistence.update(passwordPolicyRel, false);

		return passwordPolicyRel;
	}

	private PasswordPolicyRelPersistence _persistence;
}