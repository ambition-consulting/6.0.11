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

import com.liferay.portal.NoSuchAccountException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.Account;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AccountPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (AccountPersistence)PortalBeanLocatorUtil.locate(AccountPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Account account = _persistence.create(pk);

		assertNotNull(account);

		assertEquals(account.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Account newAccount = addAccount();

		_persistence.remove(newAccount);

		Account existingAccount = _persistence.fetchByPrimaryKey(newAccount.getPrimaryKey());

		assertNull(existingAccount);
	}

	public void testUpdateNew() throws Exception {
		addAccount();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Account newAccount = _persistence.create(pk);

		newAccount.setCompanyId(nextLong());
		newAccount.setUserId(nextLong());
		newAccount.setUserName(randomString());
		newAccount.setCreateDate(nextDate());
		newAccount.setModifiedDate(nextDate());
		newAccount.setParentAccountId(nextLong());
		newAccount.setName(randomString());
		newAccount.setLegalName(randomString());
		newAccount.setLegalId(randomString());
		newAccount.setLegalType(randomString());
		newAccount.setSicCode(randomString());
		newAccount.setTickerSymbol(randomString());
		newAccount.setIndustry(randomString());
		newAccount.setType(randomString());
		newAccount.setSize(randomString());

		_persistence.update(newAccount, false);

		Account existingAccount = _persistence.findByPrimaryKey(newAccount.getPrimaryKey());

		assertEquals(existingAccount.getAccountId(), newAccount.getAccountId());
		assertEquals(existingAccount.getCompanyId(), newAccount.getCompanyId());
		assertEquals(existingAccount.getUserId(), newAccount.getUserId());
		assertEquals(existingAccount.getUserName(), newAccount.getUserName());
		assertEquals(Time.getShortTimestamp(existingAccount.getCreateDate()),
			Time.getShortTimestamp(newAccount.getCreateDate()));
		assertEquals(Time.getShortTimestamp(existingAccount.getModifiedDate()),
			Time.getShortTimestamp(newAccount.getModifiedDate()));
		assertEquals(existingAccount.getParentAccountId(),
			newAccount.getParentAccountId());
		assertEquals(existingAccount.getName(), newAccount.getName());
		assertEquals(existingAccount.getLegalName(), newAccount.getLegalName());
		assertEquals(existingAccount.getLegalId(), newAccount.getLegalId());
		assertEquals(existingAccount.getLegalType(), newAccount.getLegalType());
		assertEquals(existingAccount.getSicCode(), newAccount.getSicCode());
		assertEquals(existingAccount.getTickerSymbol(),
			newAccount.getTickerSymbol());
		assertEquals(existingAccount.getIndustry(), newAccount.getIndustry());
		assertEquals(existingAccount.getType(), newAccount.getType());
		assertEquals(existingAccount.getSize(), newAccount.getSize());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Account newAccount = addAccount();

		Account existingAccount = _persistence.findByPrimaryKey(newAccount.getPrimaryKey());

		assertEquals(existingAccount, newAccount);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchAccountException");
		}
		catch (NoSuchAccountException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Account newAccount = addAccount();

		Account existingAccount = _persistence.fetchByPrimaryKey(newAccount.getPrimaryKey());

		assertEquals(existingAccount, newAccount);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Account missingAccount = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingAccount);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Account newAccount = addAccount();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Account.class,
				Account.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("accountId",
				newAccount.getAccountId()));

		List<Account> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Account existingAccount = result.get(0);

		assertEquals(existingAccount, newAccount);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Account.class,
				Account.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("accountId", nextLong()));

		List<Account> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Account addAccount() throws Exception {
		long pk = nextLong();

		Account account = _persistence.create(pk);

		account.setCompanyId(nextLong());
		account.setUserId(nextLong());
		account.setUserName(randomString());
		account.setCreateDate(nextDate());
		account.setModifiedDate(nextDate());
		account.setParentAccountId(nextLong());
		account.setName(randomString());
		account.setLegalName(randomString());
		account.setLegalId(randomString());
		account.setLegalType(randomString());
		account.setSicCode(randomString());
		account.setTickerSymbol(randomString());
		account.setIndustry(randomString());
		account.setType(randomString());
		account.setSize(randomString());

		_persistence.update(account, false);

		return account;
	}

	private AccountPersistence _persistence;
}