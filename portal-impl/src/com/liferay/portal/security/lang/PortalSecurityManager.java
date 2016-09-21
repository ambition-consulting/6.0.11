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

package com.liferay.portal.security.lang;

import java.security.Permission;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalSecurityManager extends SecurityManager {

	public void checkPermission(Permission permission) {
		if (permission.getName().equals(_PERMISSION_EXIT_VM)) {
			Thread.dumpStack();
		}
	}

	public void checkPermission(Permission permission, Object context) {
	}

	private static final String _PERMISSION_EXIT_VM = "exitVM";

}