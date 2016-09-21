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

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import org.hibernate.dialect.SQLServerDialect;

/**
 * @author Steven Cao
 */
public class SQLServer2008Dialect extends SQLServerDialect {

	public String getLimitString(String sql, int offset, int limit) {
		String lowerCaseSql = sql.toLowerCase();

		int lastOrderByPos = lowerCaseSql.lastIndexOf("order by");

		if ((lastOrderByPos < 0) || (offset == 0) ||
			StringUtil.endsWith(sql, StringPool.CLOSE_PARENTHESIS)) {

			return super.getLimitString(sql, 0, limit);
		}
		else {
			int fromPos = lowerCaseSql.indexOf("from");

			String orderBy = sql.substring(lastOrderByPos, sql.length());

			String selectFrom = sql.substring(0, fromPos);

			String selectFromWhere = sql.substring(fromPos, lastOrderByPos);

			StringBundler sb = new StringBundler(10);

			sb.append("select * from (");
			sb.append(selectFrom);
			sb.append(", _page_row_num = row_number() over(");
			sb.append(orderBy);
			sb.append(")");
			sb.append(selectFromWhere);
			sb.append(" ) temp where _page_row_num between ");
			sb.append(offset + 1);
			sb.append(" and ");
			sb.append(limit);

			return sb.toString();
		}
	}

	public boolean supportsLimitOffset() {
		return _SUPPORTS_LIMIT_OFFSET;
	}

	private static final boolean _SUPPORTS_LIMIT_OFFSET = true;

}