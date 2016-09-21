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

import com.liferay.portal.NoSuchPasswordPolicyException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PasswordPolicyPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (PasswordPolicyPersistence)PortalBeanLocatorUtil.locate(PasswordPolicyPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		PasswordPolicy passwordPolicy = _persistence.create(pk);

		assertNotNull(passwordPolicy);

		assertEquals(passwordPolicy.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		PasswordPolicy newPasswordPolicy = addPasswordPolicy();

		_persistence.remove(newPasswordPolicy);

		PasswordPolicy existingPasswordPolicy = _persistence.fetchByPrimaryKey(newPasswordPolicy.getPrimaryKey());

		assertNull(existingPasswordPolicy);
	}

	public void testUpdateNew() throws Exception {
		addPasswordPolicy();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		PasswordPolicy newPasswordPolicy = _persistence.create(pk);

		newPasswordPolicy.setCompanyId(nextLong());
		newPasswordPolicy.setUserId(nextLong());
		newPasswordPolicy.setUserName(randomString());
		newPasswordPolicy.setCreateDate(nextDate());
		newPasswordPolicy.setModifiedDate(nextDate());
		newPasswordPolicy.setDefaultPolicy(randomBoolean());
		newPasswordPolicy.setName(randomString());
		newPasswordPolicy.setDescription(randomString());
		newPasswordPolicy.setChangeable(randomBoolean());
		newPasswordPolicy.setChangeRequired(randomBoolean());
		newPasswordPolicy.setMinAge(nextLong());
		newPasswordPolicy.setCheckSyntax(randomBoolean());
		newPasswordPolicy.setAllowDictionaryWords(randomBoolean());
		newPasswordPolicy.setMinAlphanumeric(nextInt());
		newPasswordPolicy.setMinLength(nextInt());
		newPasswordPolicy.setMinLowerCase(nextInt());
		newPasswordPolicy.setMinNumbers(nextInt());
		newPasswordPolicy.setMinSymbols(nextInt());
		newPasswordPolicy.setMinUpperCase(nextInt());
		newPasswordPolicy.setHistory(randomBoolean());
		newPasswordPolicy.setHistoryCount(nextInt());
		newPasswordPolicy.setExpireable(randomBoolean());
		newPasswordPolicy.setMaxAge(nextLong());
		newPasswordPolicy.setWarningTime(nextLong());
		newPasswordPolicy.setGraceLimit(nextInt());
		newPasswordPolicy.setLockout(randomBoolean());
		newPasswordPolicy.setMaxFailure(nextInt());
		newPasswordPolicy.setLockoutDuration(nextLong());
		newPasswordPolicy.setRequireUnlock(randomBoolean());
		newPasswordPolicy.setResetFailureCount(nextLong());
		newPasswordPolicy.setResetTicketMaxAge(nextLong());

		_persistence.update(newPasswordPolicy, false);

		PasswordPolicy existingPasswordPolicy = _persistence.findByPrimaryKey(newPasswordPolicy.getPrimaryKey());

		assertEquals(existingPasswordPolicy.getPasswordPolicyId(),
			newPasswordPolicy.getPasswordPolicyId());
		assertEquals(existingPasswordPolicy.getCompanyId(),
			newPasswordPolicy.getCompanyId());
		assertEquals(existingPasswordPolicy.getUserId(),
			newPasswordPolicy.getUserId());
		assertEquals(existingPasswordPolicy.getUserName(),
			newPasswordPolicy.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingPasswordPolicy.getCreateDate()),
			Time.getShortTimestamp(newPasswordPolicy.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingPasswordPolicy.getModifiedDate()),
			Time.getShortTimestamp(newPasswordPolicy.getModifiedDate()));
		assertEquals(existingPasswordPolicy.getDefaultPolicy(),
			newPasswordPolicy.getDefaultPolicy());
		assertEquals(existingPasswordPolicy.getName(),
			newPasswordPolicy.getName());
		assertEquals(existingPasswordPolicy.getDescription(),
			newPasswordPolicy.getDescription());
		assertEquals(existingPasswordPolicy.getChangeable(),
			newPasswordPolicy.getChangeable());
		assertEquals(existingPasswordPolicy.getChangeRequired(),
			newPasswordPolicy.getChangeRequired());
		assertEquals(existingPasswordPolicy.getMinAge(),
			newPasswordPolicy.getMinAge());
		assertEquals(existingPasswordPolicy.getCheckSyntax(),
			newPasswordPolicy.getCheckSyntax());
		assertEquals(existingPasswordPolicy.getAllowDictionaryWords(),
			newPasswordPolicy.getAllowDictionaryWords());
		assertEquals(existingPasswordPolicy.getMinAlphanumeric(),
			newPasswordPolicy.getMinAlphanumeric());
		assertEquals(existingPasswordPolicy.getMinLength(),
			newPasswordPolicy.getMinLength());
		assertEquals(existingPasswordPolicy.getMinLowerCase(),
			newPasswordPolicy.getMinLowerCase());
		assertEquals(existingPasswordPolicy.getMinNumbers(),
			newPasswordPolicy.getMinNumbers());
		assertEquals(existingPasswordPolicy.getMinSymbols(),
			newPasswordPolicy.getMinSymbols());
		assertEquals(existingPasswordPolicy.getMinUpperCase(),
			newPasswordPolicy.getMinUpperCase());
		assertEquals(existingPasswordPolicy.getHistory(),
			newPasswordPolicy.getHistory());
		assertEquals(existingPasswordPolicy.getHistoryCount(),
			newPasswordPolicy.getHistoryCount());
		assertEquals(existingPasswordPolicy.getExpireable(),
			newPasswordPolicy.getExpireable());
		assertEquals(existingPasswordPolicy.getMaxAge(),
			newPasswordPolicy.getMaxAge());
		assertEquals(existingPasswordPolicy.getWarningTime(),
			newPasswordPolicy.getWarningTime());
		assertEquals(existingPasswordPolicy.getGraceLimit(),
			newPasswordPolicy.getGraceLimit());
		assertEquals(existingPasswordPolicy.getLockout(),
			newPasswordPolicy.getLockout());
		assertEquals(existingPasswordPolicy.getMaxFailure(),
			newPasswordPolicy.getMaxFailure());
		assertEquals(existingPasswordPolicy.getLockoutDuration(),
			newPasswordPolicy.getLockoutDuration());
		assertEquals(existingPasswordPolicy.getRequireUnlock(),
			newPasswordPolicy.getRequireUnlock());
		assertEquals(existingPasswordPolicy.getResetFailureCount(),
			newPasswordPolicy.getResetFailureCount());
		assertEquals(existingPasswordPolicy.getResetTicketMaxAge(),
			newPasswordPolicy.getResetTicketMaxAge());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		PasswordPolicy newPasswordPolicy = addPasswordPolicy();

		PasswordPolicy existingPasswordPolicy = _persistence.findByPrimaryKey(newPasswordPolicy.getPrimaryKey());

		assertEquals(existingPasswordPolicy, newPasswordPolicy);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchPasswordPolicyException");
		}
		catch (NoSuchPasswordPolicyException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		PasswordPolicy newPasswordPolicy = addPasswordPolicy();

		PasswordPolicy existingPasswordPolicy = _persistence.fetchByPrimaryKey(newPasswordPolicy.getPrimaryKey());

		assertEquals(existingPasswordPolicy, newPasswordPolicy);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		PasswordPolicy missingPasswordPolicy = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingPasswordPolicy);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PasswordPolicy newPasswordPolicy = addPasswordPolicy();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PasswordPolicy.class,
				PasswordPolicy.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("passwordPolicyId",
				newPasswordPolicy.getPasswordPolicyId()));

		List<PasswordPolicy> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		PasswordPolicy existingPasswordPolicy = result.get(0);

		assertEquals(existingPasswordPolicy, newPasswordPolicy);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PasswordPolicy.class,
				PasswordPolicy.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("passwordPolicyId",
				nextLong()));

		List<PasswordPolicy> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected PasswordPolicy addPasswordPolicy() throws Exception {
		long pk = nextLong();

		PasswordPolicy passwordPolicy = _persistence.create(pk);

		passwordPolicy.setCompanyId(nextLong());
		passwordPolicy.setUserId(nextLong());
		passwordPolicy.setUserName(randomString());
		passwordPolicy.setCreateDate(nextDate());
		passwordPolicy.setModifiedDate(nextDate());
		passwordPolicy.setDefaultPolicy(randomBoolean());
		passwordPolicy.setName(randomString());
		passwordPolicy.setDescription(randomString());
		passwordPolicy.setChangeable(randomBoolean());
		passwordPolicy.setChangeRequired(randomBoolean());
		passwordPolicy.setMinAge(nextLong());
		passwordPolicy.setCheckSyntax(randomBoolean());
		passwordPolicy.setAllowDictionaryWords(randomBoolean());
		passwordPolicy.setMinAlphanumeric(nextInt());
		passwordPolicy.setMinLength(nextInt());
		passwordPolicy.setMinLowerCase(nextInt());
		passwordPolicy.setMinNumbers(nextInt());
		passwordPolicy.setMinSymbols(nextInt());
		passwordPolicy.setMinUpperCase(nextInt());
		passwordPolicy.setHistory(randomBoolean());
		passwordPolicy.setHistoryCount(nextInt());
		passwordPolicy.setExpireable(randomBoolean());
		passwordPolicy.setMaxAge(nextLong());
		passwordPolicy.setWarningTime(nextLong());
		passwordPolicy.setGraceLimit(nextInt());
		passwordPolicy.setLockout(randomBoolean());
		passwordPolicy.setMaxFailure(nextInt());
		passwordPolicy.setLockoutDuration(nextLong());
		passwordPolicy.setRequireUnlock(randomBoolean());
		passwordPolicy.setResetFailureCount(nextLong());
		passwordPolicy.setResetTicketMaxAge(nextLong());

		_persistence.update(passwordPolicy, false);

		return passwordPolicy;
	}

	private PasswordPolicyPersistence _persistence;
}