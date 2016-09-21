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

package com.liferay.portal.kernel.servlet;

import javax.servlet.ServletContext;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class ServletVersionDetector {

	public static boolean is2_5() {
		return _2_5;
	}

	static {
		try {
			ServletContext.class.getMethod("getContextPath");

			_2_5 = true;
		}
		catch (Exception e) {
		}
	}

	private static boolean _2_5;

}