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

import com.liferay.portal.model.Account;

/**
 * The persistence interface for the account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPersistenceImpl
 * @see AccountUtil
 * @generated
 */
public interface AccountPersistence extends BasePersistence<Account> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountUtil} to access the account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the account in the entity cache if it is enabled.
	*
	* @param account the account to cache
	*/
	public void cacheResult(com.liferay.portal.model.Account account);

	/**
	* Caches the accounts in the entity cache if it is enabled.
	*
	* @param accounts the accounts to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.Account> accounts);

	/**
	* Creates a new account with the primary key. Does not add the account to the database.
	*
	* @param accountId the primary key for the new account
	* @return the new account
	*/
	public com.liferay.portal.model.Account create(long accountId);

	/**
	* Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param accountId the primary key of the account to remove
	* @return the account that was removed
	* @throws com.liferay.portal.NoSuchAccountException if a account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Account remove(long accountId)
		throws com.liferay.portal.NoSuchAccountException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Account updateImpl(
		com.liferay.portal.model.Account account, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the account with the primary key or throws a {@link com.liferay.portal.NoSuchAccountException} if it could not be found.
	*
	* @param accountId the primary key of the account to find
	* @return the account
	* @throws com.liferay.portal.NoSuchAccountException if a account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Account findByPrimaryKey(long accountId)
		throws com.liferay.portal.NoSuchAccountException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the account with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param accountId the primary key of the account to find
	* @return the account, or <code>null</code> if a account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Account fetchByPrimaryKey(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the accounts.
	*
	* @return the accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Account> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of accounts to return
	* @param end the upper bound of the range of accounts to return (not inclusive)
	* @return the range of accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Account> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of accounts to return
	* @param end the upper bound of the range of accounts to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Account> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the accounts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the accounts.
	*
	* @return the number of accounts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}