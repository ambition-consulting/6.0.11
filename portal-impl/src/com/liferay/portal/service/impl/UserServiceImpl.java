/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.RequiredUserException;
import com.liferay.portal.ReservedUserEmailAddressException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.Website;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.base.UserServiceBaseImpl;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.OrganizationPermissionUtil;
import com.liferay.portal.service.permission.PasswordPolicyPermissionUtil;
import com.liferay.portal.service.permission.PortalPermissionUtil;
import com.liferay.portal.service.permission.RolePermissionUtil;
import com.liferay.portal.service.permission.TeamPermissionUtil;
import com.liferay.portal.service.permission.UserGroupPermissionUtil;
import com.liferay.portal.service.permission.UserGroupRolePermissionUtil;
import com.liferay.portal.service.permission.UserPermissionUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.announcements.model.AnnouncementsDelivery;
import com.liferay.portlet.enterpriseadmin.util.EnterpriseAdminUtil;

import java.util.List;
import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 * @author Scott Lee
 * @author Jorge Ferrer
 * @author Julio Camarero
 */
public class UserServiceImpl extends UserServiceBaseImpl {

	public void addGroupUsers(long groupId, long[] userIds)
		throws PortalException, SystemException {

		try {
			GroupPermissionUtil.check(
				getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);
		}
		catch (PrincipalException pe) {

			// Allow any user to join open communities

			boolean hasPermission = false;

			if (userIds.length == 0) {
				hasPermission = true;
			}
			else if (userIds.length == 1) {
				User user = getUser();

				if (user.getUserId() == userIds[0]) {
					Group group = groupPersistence.findByPrimaryKey(groupId);

					if (user.getCompanyId() == group.getCompanyId()) {
						int type = group.getType();

						if (type == GroupConstants.TYPE_COMMUNITY_OPEN) {
							hasPermission = true;
						}
					}
				}
			}

			if (!hasPermission) {
				throw new PrincipalException();
			}
		}

		userLocalService.addGroupUsers(groupId, userIds);
	}

	public void addOrganizationUsers(long organizationId, long[] userIds)
		throws PortalException, SystemException {

		OrganizationPermissionUtil.check(
			getPermissionChecker(), organizationId, ActionKeys.ASSIGN_MEMBERS);

		validateOrganizationUsers(userIds);

		userLocalService.addOrganizationUsers(organizationId, userIds);
	}

	public void addPasswordPolicyUsers(long passwordPolicyId, long[] userIds)
		throws PortalException, SystemException {

		PasswordPolicyPermissionUtil.check(
			getPermissionChecker(), passwordPolicyId,
			ActionKeys.ASSIGN_MEMBERS);

		userLocalService.addPasswordPolicyUsers(passwordPolicyId, userIds);
	}

	public void addRoleUsers(long roleId, long[] userIds)
		throws PortalException, SystemException {

		RolePermissionUtil.check(
			getPermissionChecker(), roleId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.addRoleUsers(roleId, userIds);
	}

	public void addTeamUsers(long teamId, long[] userIds)
		throws PortalException, SystemException {

		TeamPermissionUtil.check(
			getPermissionChecker(), teamId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.addTeamUsers(teamId, userIds);
	}

	public void addUserGroupUsers(long userGroupId, long[] userIds)
		throws PortalException, SystemException {

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.addUserGroupUsers(userGroupId, userIds);
	}

	public User addUser(
			long companyId, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName,
			String emailAddress, long facebookId, String openId, Locale locale,
			String firstName, String middleName, String lastName, int prefixId,
			int suffixId, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds, long[] userGroupIds,
			boolean sendEmail, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Company company = companyPersistence.findByPrimaryKey(companyId);

		long creatorUserId = 0;

		try {
			creatorUserId = getGuestOrUserId();
		}
		catch (PrincipalException pe) {
		}

		if (groupIds != null) {
			checkGroups(CompanyConstants.SYSTEM, groupIds);
		}

		if (organizationIds != null) {
			checkOrganizations(CompanyConstants.SYSTEM, organizationIds);
		}

		if (roleIds != null) {
			checkRoles(CompanyConstants.SYSTEM, roleIds);
		}

		if (userGroupIds != null) {
			checkUserGroupIds(CompanyConstants.SYSTEM, userGroupIds);
		}

		if (((creatorUserId != 0) &&
			 (creatorUserId != getDefaultUserId(companyId))) ||
			(!company.isStrangers())) {

			if (!PortalPermissionUtil.contains(
					getPermissionChecker(), ActionKeys.ADD_USER) &&
				!UserPermissionUtil.contains(
					getPermissionChecker(), 0, organizationIds,
					ActionKeys.ADD_USER)) {

				throw new PrincipalException();
			}
		}

		if ((creatorUserId == 0) ||
			(creatorUserId == getDefaultUserId(companyId))) {

			if (!company.isStrangersWithMx() &&
				company.hasCompanyMx(emailAddress)) {

				throw new ReservedUserEmailAddressException();
			}
		}

		return userLocalService.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
	}

	public User addUser(
			long companyId, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName,
			String emailAddress, long facebookId, String openId, Locale locale,
			String firstName, String middleName, String lastName, int prefixId,
			int suffixId, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds, long[] userGroupIds,
			boolean sendEmail, List<Address> addresses,
			List<EmailAddress> emailAddresses, List<Phone> phones,
			List<Website> websites,
			List<AnnouncementsDelivery> announcementsDelivers,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = addUser(
			companyId, autoPassword, password1, password2, autoScreenName,
			screenName, emailAddress, facebookId, openId, locale, firstName,
			middleName, lastName, prefixId, suffixId, male, birthdayMonth,
			birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
			roleIds, userGroupIds, sendEmail, serviceContext);

		EnterpriseAdminUtil.updateAddresses(
			Contact.class.getName(), user.getContactId(), addresses);

		EnterpriseAdminUtil.updateEmailAddresses(
			Contact.class.getName(), user.getContactId(), emailAddresses);

		EnterpriseAdminUtil.updatePhones(
			Contact.class.getName(), user.getContactId(), phones);

		EnterpriseAdminUtil.updateWebsites(
			Contact.class.getName(), user.getContactId(), websites);

		updateAnnouncementsDeliveries(user.getUserId(), announcementsDelivers);

		return user;
	}

	public void deletePortrait(long userId)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		userLocalService.deletePortrait(userId);
	}

	public void deleteRoleUser(long roleId, long userId)
		throws PortalException, SystemException {

		RolePermissionUtil.check(
			getPermissionChecker(), roleId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.deleteRoleUser(roleId, userId);
	}

	public void deleteUser(long userId)
		throws PortalException, SystemException {

		if (getUserId() == userId) {
			throw new RequiredUserException();
		}

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.DELETE);

		userLocalService.deleteUser(userId);
	}

	public long getDefaultUserId(long companyId)
		throws PortalException, SystemException {

		return userLocalService.getDefaultUserId(companyId);
	}

	public long[] getGroupUserIds(long groupId) throws SystemException {
		return userLocalService.getGroupUserIds(groupId);
	}

	public long[] getOrganizationUserIds(long organizationId)
		throws SystemException {

		return userLocalService.getOrganizationUserIds(organizationId);
	}

	public long[] getRoleUserIds(long roleId) throws SystemException {
		return userLocalService.getRoleUserIds(roleId);
	}

	public User getUserByEmailAddress(long companyId, String emailAddress)
		throws PortalException, SystemException {

		User user = userLocalService.getUserByEmailAddress(
			companyId, emailAddress);

		UserPermissionUtil.check(
			getPermissionChecker(), user.getUserId(), ActionKeys.VIEW);

		return user;
	}

	public User getUserById(long userId)
		throws PortalException, SystemException {

		User user = userLocalService.getUserById(userId);

		UserPermissionUtil.check(
			getPermissionChecker(), user.getUserId(), ActionKeys.VIEW);

		return user;
	}

	public User getUserByScreenName(long companyId, String screenName)
		throws PortalException, SystemException {

		User user = userLocalService.getUserByScreenName(
			companyId, screenName);

		UserPermissionUtil.check(
			getPermissionChecker(), user.getUserId(), ActionKeys.VIEW);

		return user;
	}

	public long getUserIdByEmailAddress(long companyId, String emailAddress)
		throws PortalException, SystemException {

		User user = getUserByEmailAddress(companyId, emailAddress);

		UserPermissionUtil.check(
			getPermissionChecker(), user.getUserId(), ActionKeys.VIEW);

		return user.getUserId();
	}

	public long getUserIdByScreenName(long companyId, String screenName)
		throws PortalException, SystemException {

		User user = getUserByScreenName(companyId, screenName);

		UserPermissionUtil.check(
			getPermissionChecker(), user.getUserId(), ActionKeys.VIEW);

		return user.getUserId();
	}

	public boolean hasGroupUser(long groupId, long userId)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.VIEW);

		return userLocalService.hasGroupUser(groupId, userId);
	}

	public boolean hasRoleUser(long roleId, long userId)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.VIEW);

		return userLocalService.hasRoleUser(roleId, userId);
	}

	public boolean hasRoleUser(
			long companyId, String name, long userId, boolean inherited)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.VIEW);

		return userLocalService.hasRoleUser(companyId, name, userId, inherited);
	}

	public void setRoleUsers(long roleId, long[] userIds)
		throws PortalException, SystemException {

		RolePermissionUtil.check(
			getPermissionChecker(), roleId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.setRoleUsers(roleId, userIds);
	}

	public void setUserGroupUsers(long userGroupId, long[] userIds)
		throws PortalException, SystemException {

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.setUserGroupUsers(userGroupId, userIds);
	}

	public void unsetGroupUsers(long groupId, long[] userIds)
		throws PortalException, SystemException {

		try {
			GroupPermissionUtil.check(
				getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);
		}
		catch (PrincipalException pe) {

			// Allow any user to leave open and restricted communities

			boolean hasPermission = false;

			if (userIds.length == 0) {
				hasPermission = true;
			}
			else if (userIds.length == 1) {
				User user = getUser();

				if (user.getUserId() == userIds[0]) {
					Group group = groupPersistence.findByPrimaryKey(groupId);

					if (user.getCompanyId() == group.getCompanyId()) {
						int type = group.getType();

						if ((type == GroupConstants.TYPE_COMMUNITY_OPEN) ||
							(type ==
								GroupConstants.TYPE_COMMUNITY_RESTRICTED)) {

							hasPermission = true;
						}
					}
				}
			}

			if (!hasPermission) {
				throw new PrincipalException();
			}
		}

		userLocalService.unsetGroupUsers(groupId, userIds);
	}

	public void unsetOrganizationUsers(long organizationId, long[] userIds)
		throws PortalException, SystemException {

		OrganizationPermissionUtil.check(
			getPermissionChecker(), organizationId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.unsetOrganizationUsers(organizationId, userIds);
	}

	public void unsetPasswordPolicyUsers(long passwordPolicyId, long[] userIds)
		throws PortalException, SystemException {

		PasswordPolicyPermissionUtil.check(
			getPermissionChecker(), passwordPolicyId,
			ActionKeys.ASSIGN_MEMBERS);

		userLocalService.unsetPasswordPolicyUsers(passwordPolicyId, userIds);
	}

	public void unsetRoleUsers(long roleId, long[] userIds)
		throws PortalException, SystemException {

		RolePermissionUtil.check(
			getPermissionChecker(), roleId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.unsetRoleUsers(roleId, userIds);
	}

	public void unsetTeamUsers(long teamId, long[] userIds)
		throws PortalException, SystemException {

		TeamPermissionUtil.check(
			getPermissionChecker(), teamId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.unsetTeamUsers(teamId, userIds);
	}

	public void unsetUserGroupUsers(long userGroupId, long[] userIds)
		throws PortalException, SystemException {

		UserGroupPermissionUtil.check(
			getPermissionChecker(), userGroupId, ActionKeys.ASSIGN_MEMBERS);

		userLocalService.unsetUserGroupUsers(userGroupId, userIds);
	}

	public User updateActive(long userId, boolean active)
		throws PortalException, SystemException {

		if ((getUserId() == userId) && !active) {
			throw new RequiredUserException();
		}

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.DELETE);

		return userLocalService.updateActive(userId, active);
	}

	public User updateAgreedToTermsOfUse(
			long userId, boolean agreedToTermsOfUse)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updateAgreedToTermsOfUse(
			userId, agreedToTermsOfUse);
	}

	public User updateEmailAddress(
			long userId, String password, String emailAddress1,
			String emailAddress2)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updateEmailAddress(
			userId, password, emailAddress1, emailAddress2);
	}

	/**
	 * @deprecated {@link #updateLockoutById(long, boolean)}
	 */
	public User updateLockout(long userId, boolean lockout)
		throws PortalException, SystemException {

		return updateLockoutById(userId, lockout);
	}

	public User updateLockoutById(long userId, boolean lockout)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.DELETE);

		return userLocalService.updateLockoutById(userId, lockout);
	}

	public User updateOpenId(long userId, String openId)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updateOpenId(userId, openId);
	}

	public void updateOrganizations(long userId, long[] organizationIds)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		checkOrganizations(userId, organizationIds);

		userLocalService.updateOrganizations(userId, organizationIds);
	}

	public User updatePassword(
			long userId, String password1, String password2,
			boolean passwordReset)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updatePassword(
			userId, password1, password2, passwordReset);
	}

	public User updatePortrait(long userId, byte[] bytes)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updatePortrait(userId, bytes);
	}

	public User updateReminderQuery(
			long userId, String question, String answer)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updateReminderQuery(userId, question, answer);
	}

	public User updateScreenName(long userId, String screenName)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, ActionKeys.UPDATE);

		return userLocalService.updateScreenName(userId, screenName);
	}

	public User updateUser(
			long userId, String oldPassword, String newPassword1,
			String newPassword2, boolean passwordReset,
			String reminderQueryQuestion, String reminderQueryAnswer,
			String screenName, String emailAddress, long facebookId,
			String openId, String languageId, String timeZoneId,
			String greeting, String comments, String firstName,
			String middleName, String lastName, int prefixId, int suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String smsSn, String aimSn, String facebookSn, String icqSn,
			String jabberSn, String msnSn, String mySpaceSn, String skypeSn,
			String twitterSn, String ymSn, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds,
			List<UserGroupRole> userGroupRoles, long[] userGroupIds,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return updateUser(
			userId, oldPassword, newPassword1, newPassword2, passwordReset,
			reminderQueryQuestion, reminderQueryAnswer, screenName,
			emailAddress, facebookId, openId, languageId, timeZoneId, greeting,
			comments, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn,
			icqSn, jabberSn, msnSn, mySpaceSn, skypeSn, twitterSn, ymSn,
			jobTitle, groupIds, organizationIds, roleIds, userGroupRoles,
			userGroupIds, null, null, null, null, null, serviceContext);
	}

	public User updateUser(
			long userId, String oldPassword, String newPassword1,
			String newPassword2, boolean passwordReset,
			String reminderQueryQuestion, String reminderQueryAnswer,
			String screenName, String emailAddress, long facebookId,
			String openId, String languageId, String timeZoneId,
			String greeting, String comments, String firstName,
			String middleName, String lastName, int prefixId, int suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String smsSn, String aimSn, String facebookSn, String icqSn,
			String jabberSn, String msnSn, String mySpaceSn, String skypeSn,
			String twitterSn, String ymSn, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds,
			List<UserGroupRole> userGroupRoles, long[] userGroupIds,
			List<Address> addresses, List<EmailAddress> emailAddresses,
			List<Phone> phones, List<Website> websites,
			List<AnnouncementsDelivery> announcementsDelivers,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		UserPermissionUtil.check(
			getPermissionChecker(), userId, organizationIds, ActionKeys.UPDATE);

		User user = userPersistence.findByPrimaryKey(userId);

		if (addresses != null) {
			EnterpriseAdminUtil.updateAddresses(
				Contact.class.getName(), user.getContactId(), addresses);
		}

		if (emailAddresses != null) {
			EnterpriseAdminUtil.updateEmailAddresses(
				Contact.class.getName(), user.getContactId(), emailAddresses);
		}

		if (phones != null) {
			EnterpriseAdminUtil.updatePhones(
				Contact.class.getName(), user.getContactId(), phones);
		}

		if (websites != null) {
			EnterpriseAdminUtil.updateWebsites(
				Contact.class.getName(), user.getContactId(), websites);
		}

		if (announcementsDelivers != null) {
			updateAnnouncementsDeliveries(
				user.getUserId(), announcementsDelivers);
		}

		long curUserId = getUserId();

		if (curUserId == userId) {
			screenName = screenName.trim().toLowerCase();

			if (!screenName.equalsIgnoreCase(user.getScreenName())) {
				validateScreenName(user, screenName);
			}

			emailAddress = emailAddress.trim().toLowerCase();

			if (!emailAddress.equalsIgnoreCase(user.getEmailAddress())) {
				validateEmailAddress(user, emailAddress);
			}
		}

		if (groupIds != null) {
			groupIds = checkGroups(userId, groupIds);
		}

		if (organizationIds != null) {
			organizationIds = checkOrganizations(userId, organizationIds);
		}

		if (roleIds != null) {
			roleIds = checkRoles(userId, roleIds);
		}

		if (userGroupRoles != null) {
			userGroupRoles = checkUserGroupRoles(userId, userGroupRoles);
		}

		if (userGroupIds != null) {
			userGroupIds = checkUserGroupIds(userId, userGroupIds);
		}

		return userLocalService.updateUser(
			userId, oldPassword, newPassword1, newPassword2, passwordReset,
			reminderQueryQuestion, reminderQueryAnswer, screenName,
			emailAddress, facebookId, openId, languageId, timeZoneId, greeting,
			comments, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn,
			icqSn, jabberSn, msnSn, mySpaceSn, skypeSn, twitterSn, ymSn,
			jobTitle, groupIds, organizationIds, roleIds, userGroupRoles,
			userGroupIds, serviceContext);
	}

	protected long[] checkGroups(long userId, long[] groupIds)
		throws PortalException, SystemException {

		long[] oldGroupIds = null;

		PermissionChecker permissionChecker = getPermissionChecker();

		if (userId != CompanyConstants.SYSTEM) {

			// Add back any groups that the administrator does not have the
			// rights to remove and check that he has the permission to add
			// a new group

			List<Group> oldGroups = groupLocalService.getUserGroups(userId);

			oldGroupIds = new long[oldGroups.size()];

			for (int i = 0; i < oldGroups.size(); i++) {
				Group group = oldGroups.get(i);

				if (!ArrayUtil.contains(groupIds, group.getGroupId()) &&
					!GroupPermissionUtil.contains(
						permissionChecker, group.getGroupId(),
						ActionKeys.ASSIGN_MEMBERS)) {

					groupIds = ArrayUtil.append(groupIds, group.getGroupId());
				}

				oldGroupIds[i] = group.getGroupId();
			}
		}

		for (long groupId : groupIds) {
			if ((oldGroupIds == null) ||
				!ArrayUtil.contains(oldGroupIds, groupId)) {

				GroupPermissionUtil.check(
					permissionChecker, groupId, ActionKeys.ASSIGN_MEMBERS);
			}
		}

		return groupIds;
	}

	protected long[] checkOrganizations(long userId, long[] organizationIds)
		throws PortalException, SystemException {

		long[] oldOrganizationIds = null;

		PermissionChecker permissionChecker = getPermissionChecker();

		if (userId != CompanyConstants.SYSTEM) {

			// Add back any organizations that the administrator does not have
			// the rights to remove and check that he has the permission to add
			// a new organization

			List<Organization> oldOrganizations =
				organizationLocalService.getUserOrganizations(userId);

			oldOrganizationIds = new long[oldOrganizations.size()];

			for (int i = 0; i < oldOrganizations.size(); i++) {
				Organization organization = oldOrganizations.get(i);

				if (!ArrayUtil.contains(
						organizationIds, organization.getOrganizationId()) &&
					!OrganizationPermissionUtil.contains(
						permissionChecker, organization.getOrganizationId(),
						ActionKeys.ASSIGN_MEMBERS)) {

					organizationIds = ArrayUtil.append(
						organizationIds, organization.getOrganizationId());
				}

				oldOrganizationIds[i] = organization.getOrganizationId();
			}
		}

		for (long organizationId : organizationIds) {
			if ((oldOrganizationIds == null) ||
				!ArrayUtil.contains(oldOrganizationIds, organizationId)) {

				OrganizationPermissionUtil.check(
					permissionChecker, organizationId,
					ActionKeys.ASSIGN_MEMBERS);
			}
		}

		return organizationIds;
	}

	protected long[] checkRoles(long userId, long[] roleIds)
		throws PrincipalException, SystemException {

		long[] oldRoleIds = null;

		PermissionChecker permissionChecker = getPermissionChecker();

		if (userId != CompanyConstants.SYSTEM) {

			// Add back any roles that the administrator does not have the
			// rights to remove and check that he has the permission to add a
			// new role

			List<Role> oldRoles = roleLocalService.getUserRoles(userId);

			oldRoleIds = new long[oldRoles.size()];

			for (int i = 0; i < oldRoles.size(); i++) {
				Role role = oldRoles.get(i);

				if (!ArrayUtil.contains(roleIds, role.getRoleId()) &&
					!RolePermissionUtil.contains(
						permissionChecker, role.getRoleId(),
						ActionKeys.ASSIGN_MEMBERS)) {

					roleIds = ArrayUtil.append(roleIds, role.getRoleId());
				}

				oldRoleIds[i] = role.getRoleId();
			}
		}

		for (long roleId : roleIds) {
			if ((oldRoleIds == null) ||
				!ArrayUtil.contains(oldRoleIds, roleId)) {

				RolePermissionUtil.check(
					permissionChecker, roleId, ActionKeys.ASSIGN_MEMBERS);
			}
		}

		return roleIds;
	}

	protected long[] checkUserGroupIds(long userId, long[] userGroupIds)
		throws PortalException, SystemException {

		long[] oldUserGroupIds = null;

		PermissionChecker permissionChecker = getPermissionChecker();

		if (userId != CompanyConstants.SYSTEM) {

			// Add back any user groups that the administrator does not have the
			// rights to remove and check that he has the permission to add a
			// new user group

			List<UserGroup> oldUserGroups =
				userGroupLocalService.getUserUserGroups(userId);

			oldUserGroupIds = new long[oldUserGroups.size()];

			for (int i = 0; i < oldUserGroups.size(); i++) {
				UserGroup userGroup = oldUserGroups.get(i);

				if (!ArrayUtil.contains(
						userGroupIds, userGroup.getUserGroupId()) &&
					!UserGroupPermissionUtil.contains(
						permissionChecker, userGroup.getUserGroupId(),
						ActionKeys.ASSIGN_MEMBERS)) {

					userGroupIds = ArrayUtil.append(
						userGroupIds, userGroup.getUserGroupId());
				}

				oldUserGroupIds[i] = userGroup.getUserGroupId();
			}
		}

		for (long userGroupId : userGroupIds) {
			if ((oldUserGroupIds == null) ||
				!ArrayUtil.contains(oldUserGroupIds, userGroupId)) {

				UserGroupPermissionUtil.check(
					permissionChecker, userGroupId, ActionKeys.ASSIGN_MEMBERS);
			}
		}

		return userGroupIds;
	}

	protected List<UserGroupRole> checkUserGroupRoles(
			long userId, List<UserGroupRole> userGroupRoles)
		throws PortalException, SystemException {

		List<UserGroupRole> oldUserGroupRoles = null;

		PermissionChecker permissionChecker = getPermissionChecker();

		if (userId != CompanyConstants.SYSTEM) {

			// Add back any user group roles that the administrator does not
			// have the rights to remove and check that he has the permission to
			// add a new user group role

			oldUserGroupRoles = userGroupRoleLocalService.getUserGroupRoles(
				userId);

			for (UserGroupRole oldUserGroupRole : oldUserGroupRoles) {
				if (!userGroupRoles.contains(oldUserGroupRole) &&
					!UserGroupRolePermissionUtil.contains(
						permissionChecker, oldUserGroupRole.getGroupId(),
						oldUserGroupRole.getRoleId())) {

					userGroupRoles.add(oldUserGroupRole);
				}
			}
		}

		for (UserGroupRole userGroupRole : userGroupRoles) {
			if ((oldUserGroupRoles == null) ||
				!oldUserGroupRoles.contains(userGroupRole)) {

				UserGroupRolePermissionUtil.check(
					permissionChecker, userGroupRole.getGroupId(),
					userGroupRole.getRoleId());
			}
		}

		return userGroupRoles;
	}

	protected void updateAnnouncementsDeliveries(
			long userId, List<AnnouncementsDelivery> announcementsDeliveries)
		throws PortalException, SystemException {

		for (AnnouncementsDelivery announcementsDelivery :
				announcementsDeliveries) {

			announcementsDeliveryService.updateDelivery(
				userId, announcementsDelivery.getType(),
				announcementsDelivery.getEmail(),
				announcementsDelivery.getSms(),
				announcementsDelivery.getWebsite());
		}
	}

	protected void validateEmailAddress(User user, String emailAddress)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!EnterpriseAdminUtil.hasUpdateEmailAddress(
				permissionChecker, user)) {

			throw new UserEmailAddressException();
		}

		if (!user.hasCompanyMx() && user.hasCompanyMx(emailAddress)) {
			Company company = companyPersistence.findByPrimaryKey(
				user.getCompanyId());

			if (!company.isStrangersWithMx()) {
				throw new ReservedUserEmailAddressException();
			}
		}
	}

	protected void validateScreenName(User user, String screenName)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!EnterpriseAdminUtil.hasUpdateScreenName(permissionChecker, user)) {
			throw new UserScreenNameException();
		}
	}

	protected void validateOrganizationUsers(long[] userIds)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!PropsValues.ORGANIZATIONS_ASSIGNMENT_STRICT ||
			permissionChecker.isCompanyAdmin()) {

			return;
		}

		List<Organization> organizations =
			organizationLocalService.getUserOrganizations(
				permissionChecker.getUserId());

		for (long userId : userIds) {
			boolean allowed = false;

			for (Organization organization : organizations) {
				boolean manageUsers = OrganizationPermissionUtil.contains(
					permissionChecker, organization, ActionKeys.MANAGE_USERS);
				boolean manageSuborganizations =
					OrganizationPermissionUtil.contains(
						permissionChecker, organization,
						ActionKeys.MANAGE_SUBORGANIZATIONS);

				if (!manageUsers && !manageSuborganizations) {
					continue;
				}

				boolean inherited = false;
				boolean includeSpecifiedOrganization = false;

				if (manageUsers && manageSuborganizations) {
					inherited = true;
					includeSpecifiedOrganization = true;
				}
				else if (!manageUsers && manageSuborganizations) {
					inherited = true;
					includeSpecifiedOrganization = false;
				}

				if (organizationLocalService.hasUserOrganization(
						userId, organization.getOrganizationId(), inherited,
						false, includeSpecifiedOrganization)) {

					allowed = true;

					break;
				}
			}

			if (!allowed) {
				throw new PrincipalException();
			}
		}
	}

}