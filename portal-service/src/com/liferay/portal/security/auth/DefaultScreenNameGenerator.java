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

package com.liferay.portal.security.auth;

import com.liferay.portal.NoSuchGroupException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 * @author Juan Fernández
 */
public class DefaultScreenNameGenerator implements ScreenNameGenerator {

	public String generate(long companyId, long userId, String emailAddress)
		throws Exception {

		String screenName = null;

		if (Validator.isNotNull(emailAddress)) {
			screenName = StringUtil.extractFirst(
				emailAddress, StringPool.AT).toLowerCase();

			screenName = StringUtil.replace(
				screenName,
				new String[] {StringPool.SLASH, StringPool.UNDERLINE},
				new String[] {StringPool.PERIOD, StringPool.PERIOD});

			if (screenName.equals(DefaultScreenNameValidator.CYRUS) ||
				screenName.equals(DefaultScreenNameValidator.POSTFIX)) {

				screenName += StringPool.PERIOD + userId;
			}
		}
		else {
			screenName = String.valueOf(userId);
		}

		String[] reservedScreenNames = PrefsPropsUtil.getStringArray(
			companyId, PropsKeys.ADMIN_RESERVED_SCREEN_NAMES,
			StringPool.NEW_LINE, _ADMIN_RESERVED_SCREEN_NAMES);

		for (String reservedScreenName : reservedScreenNames) {
			if (screenName.equalsIgnoreCase(reservedScreenName)) {
				return getUnusedScreenName(companyId, screenName);
			}
		}

		try {
			UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
		}
		catch (NoSuchUserException nsue) {
			try {
				GroupLocalServiceUtil.getFriendlyURLGroup(
					companyId, StringPool.SLASH + screenName);
			}
			catch (NoSuchGroupException nsge) {
				return screenName;
			}
		}

		return getUnusedScreenName(companyId, screenName);
	}

	protected String getUnusedScreenName(long companyId, String screenName)
		throws PortalException, SystemException {

		for (int i = 1;; i++) {
			String tempScreenName = screenName + StringPool.PERIOD + i;

			try {
				UserLocalServiceUtil.getUserByScreenName(
					companyId, tempScreenName);
			}
			catch (NoSuchUserException nsue) {
				try {
					GroupLocalServiceUtil.getFriendlyURLGroup(
						companyId, StringPool.SLASH + tempScreenName);
				}
				catch (NoSuchGroupException nsge) {
					screenName = tempScreenName;

					break;
				}
			}
		}

		return screenName;
	}

	private static final String[] _ADMIN_RESERVED_SCREEN_NAMES =
		StringUtil.split(
			PropsUtil.get(PropsKeys.ADMIN_RESERVED_SCREEN_NAMES),
			StringPool.NEW_LINE);

}