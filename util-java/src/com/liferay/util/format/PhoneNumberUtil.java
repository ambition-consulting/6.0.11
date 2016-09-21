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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.util.SystemProperties;

/**
 * @author Brian Wing Shun Chan
 */
public class PhoneNumberUtil {

	public static String format(String phoneNumber) {
		return _format.format(phoneNumber);
	}

	public static String strip(String phoneNumber) {
		return _format.strip(phoneNumber);
	}

	private static String _formatClass = GetterUtil.getString(
		SystemProperties.get(PhoneNumberFormat.class.getName()),
		USAPhoneNumberFormat.class.getName());

	private static PhoneNumberFormat _format =
		(PhoneNumberFormat)InstancePool.get(_formatClass);

}