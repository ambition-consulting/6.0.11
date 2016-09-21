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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link AccountService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AccountService
 * @generated
 */
public class AccountServiceWrapper implements AccountService {
	public AccountServiceWrapper(AccountService accountService) {
		_accountService = accountService;
	}

	public AccountService getWrappedAccountService() {
		return _accountService;
	}

	public void setWrappedAccountService(AccountService accountService) {
		_accountService = accountService;
	}

	private AccountService _accountService;
}