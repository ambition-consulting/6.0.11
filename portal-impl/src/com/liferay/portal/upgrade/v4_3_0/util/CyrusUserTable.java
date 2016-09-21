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

package com.liferay.portal.upgrade.v4_3_0.util;

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class CyrusUserTable {

	public static String TABLE_NAME = "CyrusUser";

	public static Object[][] TABLE_COLUMNS = {
		{"userId", new Integer(Types.BIGINT)},
		{"password_", new Integer(Types.VARCHAR)}
	};

}