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

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public class MappingSqlQueryFactoryUtil {

	public static <T> MappingSqlQuery<T> getMappingSqlQuery(
		DataSource dataSource, String sql, int[] types,
		RowMapper<T> rowMapper) {

		return getMappingSqlQueryFactory().getMappingSqlQuery(
			dataSource, sql, types, rowMapper);
	}

	public static MappingSqlQueryFactory getMappingSqlQueryFactory() {
		return _mappingSqlUpdateFactory;
	}

	public void setMappingSqlQueryFactory(
		MappingSqlQueryFactory mappingSqlUpdateFactory) {

		_mappingSqlUpdateFactory = mappingSqlUpdateFactory;
	}

	private static MappingSqlQueryFactory _mappingSqlUpdateFactory;

}