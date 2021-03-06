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

package com.liferay.portal.convert.util;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.upgrade.util.Table;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Chow
 */
public class ResourcePermissionView extends Table {

	public static String getActionId(String[] values) {
		return values[4];
	}

	public static long getCompanyId(String[] values) {
		return Long.parseLong(values[0]);
	}

	public static String getPrimaryKey(String[] values) {
		return values[2];
	}

	public static long getRoleId(String[] values) {
		return Long.parseLong(values[3]);
	}

	public static int getScope(String[] values) {
		return Integer.parseInt(values[1]);
	}

	public ResourcePermissionView(String name) {
		super("ResourcePermissionView");

		List<Object[]> columns = new ArrayList<Object[]>();

		columns.add(new Object[] {"companyId", Types.BIGINT});
		columns.add(new Object[] {"scope", Types.INTEGER});
		columns.add(new Object[] {"primKey", Types.VARCHAR});
		columns.add(new Object[] {"roleId", Types.BIGINT});
		columns.add(new Object[] {"actionId", Types.VARCHAR});

		setColumns(columns.toArray(new Object[0][]));

		_name = name;
	}

	public String getSelectSQL() throws Exception {
		StringBundler sb = new StringBundler(4);

		sb.append(_SELECT_SQL);
		sb.append(StringPool.APOSTROPHE);
		sb.append(_name);
		sb.append(StringPool.APOSTROPHE);

		return sb.toString();
	}

	private String _name = StringPool.BLANK;

	private static final String _SELECT_SQL =
		"SELECT Permission_.companyId, ResourceCode.scope, " +
		"Resource_.primKey, Roles_Permissions.roleId, Permission_.actionId " +
		"FROM Roles_Permissions, Permission_, Resource_, ResourceCode WHERE " +
		"Permission_.permissionId = Roles_Permissions.permissionId AND " +
		"Permission_.resourceId = Resource_.resourceId AND " +
		"Resource_.codeId = ResourceCode.codeId AND ResourceCode.name = ";

}