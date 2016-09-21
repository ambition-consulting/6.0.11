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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Michael C. Han
 */
public class DefaultFullNameGenerator implements FullNameGenerator {

	public String getFullName(
		String firstName, String middleName, String lastName) {

		StringBuilder sb = new StringBuilder();

		sb.append(firstName);
		sb.append(StringPool.SPACE);

		if (Validator.isNull(middleName)) {
			sb.append(lastName);
		}
		else {
			sb.append(middleName);
			sb.append(StringPool.SPACE);
			sb.append(lastName);
		}

		return sb.toString();
	}

	public String[] splitFullName(String fullName) {
		String firstName = StringPool.BLANK;
		String middleName = StringPool.BLANK;
		String lastName = StringPool.BLANK;

		if (Validator.isNotNull(fullName)) {
			String[] name = StringUtil.split(fullName, StringPool.SPACE);

			firstName = name[0];
			middleName = StringPool.BLANK;
			lastName = name[name.length - 1];

			if (name.length > 2) {
				for (int i = 1; i < name.length - 1; i++) {
					if (Validator.isNull(name[i].trim())) {
						continue;
					}

					if (i != 1) {
						middleName += StringPool.SPACE;
					}

					middleName += name[i].trim();
				}
			}
		}
		else {
			firstName = GetterUtil.getString(firstName, lastName);
			lastName = firstName;
		}

		return new String[] {firstName, middleName, lastName};
	}

}