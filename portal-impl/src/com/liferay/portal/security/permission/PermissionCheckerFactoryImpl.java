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

package com.liferay.portal.security.permission;

import com.liferay.portal.model.User;
import com.liferay.portal.util.PropsValues;

/**
 * @author Charles May
 * @author Brian Wing Shun Chan
 */
public class PermissionCheckerFactoryImpl implements PermissionCheckerFactory {

	public PermissionChecker create(User user, boolean checkGuest)
		throws Exception {

		PermissionChecker permissionChecker = (PermissionChecker)Class.forName(
			PropsValues.PERMISSIONS_CHECKER).newInstance();

		permissionChecker.init(user, checkGuest);

		return permissionChecker;
	}

}