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

import java.io.Serializable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

/**
 * @author Brian Wing Shun Chan
 */
public class BooleanType implements Serializable, UserType {

	public static final boolean DEFAULT_VALUE = false;

	public static final int[] SQL_TYPES = new int[] {Types.BIT};

	public Object assemble(Serializable cached, Object owner) {
		return cached;
	}

	public Object deepCopy(Object obj) {
		return obj;
	}

	public Serializable disassemble(Object value) {
		return (Serializable)value;
	}

	public boolean equals(Object x, Object y) {
		if (x == y) {
			return true;
		}
		else if ((x == null) || (y == null)) {
			return false;
		}
		else {
			return x.equals(y);
		}
	}

	public int hashCode(Object x) {
		return x.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
		throws SQLException {

		Boolean value = StandardBasicTypes.BOOLEAN.nullSafeGet(rs, names[0]);

		if (value == null) {
			return Boolean.valueOf(DEFAULT_VALUE);
		}
		else {
			return value;
		}
	}

	public void nullSafeSet(PreparedStatement ps, Object obj, int index)
		throws SQLException {

		if (obj == null) {
			obj = Boolean.valueOf(DEFAULT_VALUE);
		}

		ps.setBoolean(index, (Boolean)obj);
	}

	public Object replace(Object original, Object target, Object owner) {
		return original;
	}

	public Class<Boolean> returnedClass() {
		return Boolean.class;
	}

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

}