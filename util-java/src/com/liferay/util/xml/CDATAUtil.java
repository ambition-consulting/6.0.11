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

package com.liferay.util.xml;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Alexander Chow
 */
public class CDATAUtil {

	public static String wrap(String s) {
		return StringPool.CDATA_OPEN + s + StringPool.CDATA_CLOSE;
	}

	public static String strip(String s) {
		String retVal;

		if (s.startsWith(StringPool.CDATA_OPEN) &&
			s.endsWith(StringPool.CDATA_CLOSE)) {

			retVal = s.substring(
				StringPool.CDATA_OPEN.length(),
				s.length() - StringPool.CDATA_CLOSE.length());
		}
		else {
			retVal = s;
		}

		return retVal;
	}

}