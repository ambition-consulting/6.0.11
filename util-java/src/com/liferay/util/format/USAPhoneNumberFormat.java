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

package com.liferay.util.format;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class USAPhoneNumberFormat implements PhoneNumberFormat {

	public String format(String phoneNumber) {
		if (phoneNumber == null) {
			return StringPool.BLANK;
		}

		if (phoneNumber.length() > 10) {
			StringBundler sb = new StringBundler(8);

			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(phoneNumber.substring(0, 3));
			sb.append(") ");
			sb.append(phoneNumber.substring(3, 6));
			sb.append(StringPool.DASH);
			sb.append(phoneNumber.substring(6, 10));
			sb.append(" x");
			sb.append(phoneNumber.substring(10));

			return sb.toString();
		}
		else if (phoneNumber.length() == 10) {
			StringBundler sb = new StringBundler(6);

			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(phoneNumber.substring(0, 3));
			sb.append(") ");
			sb.append(phoneNumber.substring(3, 6));
			sb.append(StringPool.DASH);
			sb.append(phoneNumber.substring(6));

			return sb.toString();
		}
		else if (phoneNumber.length() == 7) {
			return phoneNumber.substring(0, 3).concat(StringPool.DASH).concat(
				phoneNumber.substring(3));
		}
		else {
			return phoneNumber;
		}
	}

	public String strip(String phoneNumber) {
		return StringUtil.extractDigits(phoneNumber);
	}

}