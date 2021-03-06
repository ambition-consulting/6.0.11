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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.PasswordPolicy;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BasicToolkit {

	public abstract String generate(PasswordPolicy passwordPolicy);

	public void validate(
			String password1, String password2, PasswordPolicy passwordPolicy)
		throws PortalException, SystemException {

		validate(0, password1, password2, passwordPolicy);
	}

	public abstract void validate(
			long userId, String password1, String password2,
			PasswordPolicy passwordPolicy)
		throws PortalException, SystemException;

}