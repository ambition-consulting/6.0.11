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

package com.liferay.portal.security.ldap;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.auth.AuthSettingsUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.io.Serializable;

import java.util.Map;
import java.util.Properties;

import javax.naming.Binding;
import javax.naming.CompositeName;
import javax.naming.Name;
import javax.naming.directory.Attributes;
import javax.naming.directory.ModificationItem;
import javax.naming.ldap.LdapContext;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 * @author Marcellus Tavares
 */
public class PortalLDAPExporterImpl implements PortalLDAPExporter {

	public void exportToLDAP(
			Contact contact, Map<String, Serializable> contactExpandoAttributes)
		throws Exception {

		long companyId = contact.getCompanyId();

		if (!AuthSettingsUtil.isLDAPAuthEnabled(companyId) ||
			!LDAPSettingsUtil.isExportEnabled(companyId)) {

			return;
		}

		User user = UserLocalServiceUtil.getUserByContactId(
			contact.getContactId());

		long ldapServerId = PortalLDAPUtil.getLdapServerId(
			companyId, user.getScreenName());

		LdapContext ldapContext = PortalLDAPUtil.getContext(
			ldapServerId, companyId);

		try {
			if (ldapContext == null) {
				return;
			}

			Properties contactMappings = LDAPSettingsUtil.getContactMappings(
				ldapServerId, companyId);
			Properties contactExpandoMappings =
				LDAPSettingsUtil.getContactExpandoMappings(
					ldapServerId, companyId);

			Binding binding = PortalLDAPUtil.getUser(
				ldapServerId, contact.getCompanyId(), user.getScreenName());

			if (binding == null) {
				Properties userMappings = LDAPSettingsUtil.getUserMappings(
					ldapServerId, companyId);

				binding = addUser(
					ldapServerId, ldapContext, user, userMappings);
			}

			Name name = new CompositeName();

			name.add(
				PortalLDAPUtil.getNameInNamespace(
					ldapServerId, companyId, binding));

			Modifications modifications =
				_portalToLDAPConverter.getLDAPContactModifications(
					contact, contactExpandoAttributes,
					contactMappings, contactExpandoMappings);

			if (modifications == null) {
				return;
			}

			ModificationItem[] modificationItems = modifications.getItems();

			ldapContext.modifyAttributes(name, modificationItems);
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			if (ldapContext != null) {
				ldapContext.close();
			}
		}
	}

	public void exportToLDAP(
			User user, Map<String, Serializable> userExpandoAttributes)
		throws Exception {

		long companyId = user.getCompanyId();

		if (!AuthSettingsUtil.isLDAPAuthEnabled(companyId) ||
			!LDAPSettingsUtil.isExportEnabled(companyId)) {

			return;
		}

		long ldapServerId = PortalLDAPUtil.getLdapServerId(
			companyId, user.getScreenName());

		LdapContext ldapContext = PortalLDAPUtil.getContext(
			ldapServerId, companyId);

		try {
			if (ldapContext == null) {
				return;
			}

			Properties userMappings = LDAPSettingsUtil.getUserMappings(
				ldapServerId, companyId);
			Properties userExpandoMappings =
				LDAPSettingsUtil.getUserExpandoMappings(
					ldapServerId, companyId);

			Binding binding = PortalLDAPUtil.getUser(
				ldapServerId, user.getCompanyId(), user.getScreenName());

			if (binding == null) {
				binding = addUser(
					ldapServerId, ldapContext, user, userMappings);
			}

			Name name = new CompositeName();

			name.add(
				PortalLDAPUtil.getNameInNamespace(
					ldapServerId, companyId, binding));

			Modifications modifications =
				_portalToLDAPConverter.getLDAPUserModifications(
					user, userExpandoAttributes, userMappings,
					userExpandoMappings);

			if (modifications == null) {
				return;
			}

			ModificationItem[] modificationItems = modifications.getItems();

			ldapContext.modifyAttributes(name, modificationItems);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			if (ldapContext != null) {
				ldapContext.close();
			}
		}
	}

	public void exportToLDAP(long userId, long userGroupId) throws Exception {
		User user = UserLocalServiceUtil.getUser(userId);

		long companyId = user.getCompanyId();

		if (!AuthSettingsUtil.isLDAPAuthEnabled(companyId) ||
			!LDAPSettingsUtil.isExportEnabled(companyId) ||
			!LDAPSettingsUtil.isExportGroupEnabled(companyId)) {

			return;
		}

		long ldapServerId = PortalLDAPUtil.getLdapServerId(
			companyId, user.getScreenName());

		LdapContext ldapContext = PortalLDAPUtil.getContext(
			ldapServerId, companyId);

		try {
			if (ldapContext == null) {
				return;
			}

			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(
				userGroupId);

			Properties groupMappings = LDAPSettingsUtil.getGroupMappings(
				ldapServerId, companyId);

			Properties userMappings = LDAPSettingsUtil.getUserMappings(
				ldapServerId, companyId);

			Binding binding = PortalLDAPUtil.getGroup(
				ldapServerId, companyId, userGroup.getName());

			if (binding == null) {
				addGroup(
					ldapServerId, ldapContext, userGroup, user, groupMappings,
					userMappings);

				return;
			}

			Name name = new CompositeName();

			name.add(
				PortalLDAPUtil.getNameInNamespace(
					ldapServerId, companyId, binding));

			Modifications modifications =
				_portalToLDAPConverter.getLDAPGroupModifications(
					ldapServerId, userGroup, user, groupMappings, userMappings);

			ModificationItem[] modificationItems = modifications.getItems();

			ldapContext.modifyAttributes(name, modificationItems);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			if (ldapContext != null) {
				ldapContext.close();
			}
		}
	}

	public void setPortalToLDAPConverter(
		PortalToLDAPConverter portalToLDAPConverter) {

		_portalToLDAPConverter = portalToLDAPConverter;
	}

	protected Binding addGroup(
			long ldapServerId, LdapContext ldapContext, UserGroup userGroup,
			User user, Properties groupMappings, Properties userMappings)
		throws Exception {

		Name name = new CompositeName();

		name.add(
			_portalToLDAPConverter.getGroupDNName(
				ldapServerId, userGroup, groupMappings));

		Attributes attributes = _portalToLDAPConverter.getLDAPGroupAttributes(
			ldapServerId, userGroup, user, groupMappings, userMappings);

		ldapContext.bind(name, new PortalLDAPContext(attributes));

		Binding binding = PortalLDAPUtil.getGroup(
			ldapServerId, userGroup.getCompanyId(), userGroup.getName());

		return binding;
	}

	protected Binding addUser(
			long ldapServerId, LdapContext ldapContext, User user,
			Properties userMappings)
		throws Exception {

		Name name = new CompositeName();

		name.add(
			_portalToLDAPConverter.getUserDNName(
				ldapServerId, user, userMappings));

		Attributes attributes = _portalToLDAPConverter.getLDAPUserAttributes(
			ldapServerId, user, userMappings);

		ldapContext.bind(name, new PortalLDAPContext(attributes));

		Binding binding = PortalLDAPUtil.getUser(
			ldapServerId, user.getCompanyId(), user.getScreenName());

		return binding;
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortalLDAPExporterImpl.class);

	private PortalToLDAPConverter _portalToLDAPConverter;

}