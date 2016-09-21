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

package com.liferay.portal.security.pwd;

import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.security.ldap.LDAPSettingsUtil;
import com.liferay.portal.util.PropsUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PwdToolkitUtil {

	public static String generate(PasswordPolicy passwordPolicy) {
		return _instance._generate(passwordPolicy);
	}

	public static void validate(
			long companyId, long userId, String password1, String password2,
			PasswordPolicy passwordPolicy)
		throws PortalException, SystemException {

		if (!password1.equals(password2)) {
			throw new UserPasswordException(
				UserPasswordException.PASSWORDS_DO_NOT_MATCH);
		}

		if (!LDAPSettingsUtil.isPasswordPolicyEnabled(companyId)) {
			_instance._validate(userId, password1, password2, passwordPolicy);
		}
	}

	private PwdToolkitUtil() {
		_toolkit = (BasicToolkit)InstancePool.get(
			PropsUtil.get(PropsKeys.PASSWORDS_TOOLKIT));
	}

	private String _generate(PasswordPolicy passwordPolicy) {
		return _toolkit.generate(passwordPolicy);
	}

	private void _validate(
			long userId, String password1, String password2,
			PasswordPolicy passwordPolicy)
		throws PortalException, SystemException {

		_toolkit.validate(userId, password1, password2, passwordPolicy);
	}

	private static PwdToolkitUtil _instance = new PwdToolkitUtil();

	private BasicToolkit _toolkit;

}