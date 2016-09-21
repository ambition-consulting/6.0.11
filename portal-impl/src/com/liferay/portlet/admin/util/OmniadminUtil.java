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

package com.liferay.portlet.admin.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class OmniadminUtil {

	public static boolean isOmniadmin(long userId) {
		if (CompanyThreadLocal.getCompanyId() !=
				PortalInstances.getDefaultCompanyId()) {

			return false;
		}

		if (userId <= 0) {
			return false;
		}

		try {
			if (PropsValues.OMNIADMIN_USERS.length > 0) {
				for (int i = 0; i < PropsValues.OMNIADMIN_USERS.length; i++) {
					if (PropsValues.OMNIADMIN_USERS[i] == userId) {
						User user = UserLocalServiceUtil.getUserById(userId);

						if (user.getCompanyId() !=
								PortalInstances.getDefaultCompanyId()) {

							return false;
						}

						return true;
					}
				}

				return false;
			}
			else {
				User user = UserLocalServiceUtil.getUserById(userId);

				if (user.getCompanyId() !=
						PortalInstances.getDefaultCompanyId()) {

					return false;
				}

				return RoleLocalServiceUtil.hasUserRole(
					userId, user.getCompanyId(), RoleConstants.ADMINISTRATOR,
					true);
			}
		}
		catch (Exception e) {
			_log.error(e);

			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OmniadminUtil.class);

}