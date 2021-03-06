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

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Brian Wing Shun Chan
 */
public class CountRowMapper implements RowMapper<Integer> {

	public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return new Integer(rs.getInt(_COUNT_VALUE));
	}

	private static final String _COUNT_VALUE = "COUNT_VALUE";

}