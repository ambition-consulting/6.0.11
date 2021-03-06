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

package com.liferay.portal.security.jaas.ext.jboss;

import com.liferay.portal.kernel.security.jaas.PortalGroup;
import com.liferay.portal.kernel.security.jaas.PortalPrincipal;
import com.liferay.portal.security.jaas.ext.BasicLoginModule;

import java.security.Principal;

import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalLoginModule extends BasicLoginModule {

	public boolean commit() throws LoginException {
		boolean commitValue = super.commit();

		if (commitValue) {
			PortalGroup rolesPortalGroup = new PortalGroup("Roles");

			rolesPortalGroup.addMember(new PortalPrincipal("users"));

			Subject subject = getSubject();

			Set<Principal> principals = subject.getPrincipals();

			principals.add(rolesPortalGroup);

			PortalGroup callerPrincipalGroup = new PortalGroup(
				"CallerPrincipal");

			callerPrincipalGroup.addMember(getPrincipal());

			principals.add(callerPrincipalGroup);
		}

		return commitValue;
	}

}