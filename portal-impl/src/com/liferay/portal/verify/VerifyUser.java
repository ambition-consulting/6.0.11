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

package com.liferay.portal.verify;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ContactConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class VerifyUser extends VerifyProcess {

	protected void doVerify() throws Exception {
		List<User> users = UserLocalServiceUtil.getNoContacts();

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Processing " + users.size() + " users with no contacts");
		}

		Date now = new Date();

		for (User user : users) {
			if (_log.isDebugEnabled()) {
				_log.debug("Creating contact for user " + user.getUserId());
			}

			long contactId = CounterLocalServiceUtil.increment();

			Contact contact = ContactLocalServiceUtil.createContact(contactId);

			Company company = CompanyLocalServiceUtil.getCompanyById(
				user.getCompanyId());

			contact.setCompanyId(user.getCompanyId());
			contact.setUserId(user.getUserId());
			contact.setUserName(StringPool.BLANK);
			contact.setCreateDate(now);
			contact.setModifiedDate(now);
			contact.setAccountId(company.getAccountId());
			contact.setParentContactId(
				ContactConstants.DEFAULT_PARENT_CONTACT_ID);
			contact.setFirstName(user.getFirstName());
			contact.setMiddleName(user.getMiddleName());
			contact.setLastName(user.getLastName());
			contact.setPrefixId(0);
			contact.setSuffixId(0);
			contact.setJobTitle(user.getJobTitle());

			ContactLocalServiceUtil.updateContact(contact);

			user.setContactId(contactId);

			UserLocalServiceUtil.updateUser(user);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Contacts verified for users");
		}

		users = UserLocalServiceUtil.getNoGroups();

		if (_log.isDebugEnabled()) {
			_log.debug("Processing " + users.size() + " users with no groups");
		}

		for (User user : users) {
			if (_log.isDebugEnabled()) {
				_log.debug("Creating group for user " + user.getUserId());
			}

			GroupLocalServiceUtil.addGroup(
				user.getUserId(), User.class.getName(), user.getUserId(), null,
				null, 0, StringPool.SLASH + user.getScreenName(), true, null);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Groups verified for users");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VerifyUser.class);

}