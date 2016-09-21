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

import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Edward Han
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 * @author Marcellus Tavares
 */
public class PortalLDAPExporterUtil {

	public static void exportToLDAP(
			Contact contact, Map<String, Serializable> contactExpandoAttributes)
		throws Exception {

		_portalLDAPExporter.exportToLDAP(contact, contactExpandoAttributes);
	}

	public static void exportToLDAP(
			User user, Map<String, Serializable> userExpandoAttributes)
		throws Exception {

		_portalLDAPExporter.exportToLDAP(user, userExpandoAttributes);
	}

	public static void exportToLDAP(long userId, long userGroupId)
		throws Exception {

		_portalLDAPExporter.exportToLDAP(userId, userGroupId);
	}

	public void setPortalLDAPExporter(PortalLDAPExporter portalLDAPExporter) {
		_portalLDAPExporter = portalLDAPExporter;
	}

	private static PortalLDAPExporter _portalLDAPExporter;

}