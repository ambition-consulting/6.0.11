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
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class PortletTable {

	public static String TABLE_NAME = "Portlet";

	public static Object[][] TABLE_COLUMNS = {
		{"id_", new Integer(Types.BIGINT)},
		{"companyId", new Integer(Types.BIGINT)},
		{"portletId", new Integer(Types.VARCHAR)},
		{"roles", new Integer(Types.VARCHAR)},
		{"active_", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table Portlet (id_ LONG not null primary key,companyId LONG,portletId VARCHAR(200) null,roles STRING null,active_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Portlet";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_80CC9508 on Portlet (companyId)",
		"create index IX_12B5E51D on Portlet (companyId, portletId)"
	};

}