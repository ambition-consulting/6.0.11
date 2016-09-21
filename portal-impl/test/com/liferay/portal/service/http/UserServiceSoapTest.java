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

package com.liferay.portal.service.http;

import com.liferay.client.soap.portal.model.UserSoap;
import com.liferay.client.soap.portal.service.ServiceContext;
import com.liferay.client.soap.portal.service.http.UserServiceSoap;
import com.liferay.client.soap.portal.service.http.UserServiceSoapServiceLocator;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.TestPropsValues;

import java.util.Calendar;

/**
 * @author Brian Wing Shun Chan
 */
public class UserServiceSoapTest extends BaseServiceSoapTestCase {

	public void testAddUser() throws Exception {
		addUser();
	}

	public void testDeleteUser() throws Exception {
		UserSoap user = addUser();

		getUserServiceSoap().deleteUser(user.getUserId());
	}

	public void testGetUser() throws Exception {
		UserSoap user = addUser();

		getUserServiceSoap().getUserByEmailAddress(
			TestPropsValues.COMPANY_ID, user.getEmailAddress());
	}

	protected UserSoap addUser() throws Exception {
		boolean autoPassword = true;
		String password1 = null;
		String password2 = null;
		boolean autoScreenName = true;
		String screenName = StringPool.BLANK;
		String emailAddress =
			"UserServiceSoapTest." + nextLong() + "@liferay.com";
		long facebookId = 0;
		String openId = StringPool.BLANK;
		String locale = LocaleUtil.getDefault().toString();
		String firstName = "UserServiceSoapTest";
		String middleName = StringPool.BLANK;
		String lastName = "UserServiceSoapTest";
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true;
		int birthdayMonth = Calendar.JANUARY;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = null;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendMail = false;
		ServiceContext serviceContext = new ServiceContext();

		return getUserServiceSoap().addUser(
			TestPropsValues.COMPANY_ID, autoPassword,
			password1, password2, autoScreenName, screenName, emailAddress,
			facebookId, openId, locale, firstName, middleName, lastName,
			prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
			jobTitle, groupIds, organizationIds, roleIds, userGroupIds,
			sendMail, serviceContext);
	}

	protected UserServiceSoap getUserServiceSoap() throws Exception {
		UserServiceSoapServiceLocator locator =
			new UserServiceSoapServiceLocator();

		UserServiceSoap service = locator.getPortal_UserService(
			getURL("Portal_UserService"));

		return service;
	}

}