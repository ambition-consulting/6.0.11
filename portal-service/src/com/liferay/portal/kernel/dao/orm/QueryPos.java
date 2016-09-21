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

package com.liferay.portal.kernel.dao.orm;

import com.liferay.portal.kernel.util.CalendarUtil;

import java.sql.Timestamp;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class QueryPos {

	public static QueryPos getInstance(Query query) {
		return new QueryPos(query);
	}

	public void add(boolean value) {
		_query.setBoolean(_pos++, value);
	}

	public void add(Boolean value) {
		if (value != null) {
			_query.setBoolean(_pos++, value.booleanValue());
		}
		else {
			_addNull();
		}
	}

	public void add(boolean[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(boolean[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Boolean[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Boolean[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(double value) {
		_query.setDouble(_pos++, value);
	}

	public void add(Double value) {
		if (value != null) {
			_query.setDouble(_pos++, value.doubleValue());
		}
		else {
			_addNull();
		}
	}

	public void add(double[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(double[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Double[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Double[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(float value) {
		_query.setFloat(_pos++, value);
	}

	public void add(Float value) {
		if (value != null) {
			_query.setFloat(_pos++, value.intValue());
		}
		else {
			_addNull();
		}
	}

	public void add(float[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(float[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Float[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Float[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(int value) {
		_query.setInteger(_pos++, value);
	}

	public void add(int[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(int[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Integer value) {
		if (value != null) {
			_query.setInteger(_pos++, value.intValue());
		}
		else {
			_addNull();
		}
	}

	public void add(Integer[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Integer[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(long value) {
		_query.setLong(_pos++, value);
	}

	public void add(Long value) {
		if (value != null) {
			_query.setLong(_pos++, value.longValue());
		}
		else {
			_addNull();
		}
	}

	public void add(long[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(long[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Long[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Long[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Object obj) {
		if (obj == null) {
			_addNull();

			return;
		}

		Class<?> classObj = obj.getClass();

		if (classObj == Boolean.class) {
			add(((Boolean)obj).booleanValue());
		}
		else if (classObj == Date.class) {
			add(CalendarUtil.getTimestamp((Date)obj));
		}
		else if (classObj == Double.class) {
			add(((Double)obj).doubleValue());
		}
		else if (classObj == Float.class) {
			add(((Float)obj).floatValue());
		}
		else if (classObj == Integer.class) {
			add(((Integer)obj).intValue());
		}
		else if (classObj == Long.class) {
			add(((Long)obj).longValue());
		}
		else if (classObj == Short.class) {
			add(((Short)obj).shortValue());
		}
		else if (classObj == String.class) {
			add((String)obj);
		}
		else if (classObj == Timestamp.class) {
			add((Timestamp)obj);
		}
		else {
			throw new RuntimeException("Unsupport type " + classObj.getName());
		}
	}

	public void add(short value) {
		_query.setShort(_pos++, value);
	}

	public void add(Short value) {
		if (value != null) {
			_query.setShort(_pos++, value.shortValue());
		}
		else {
			_addNull();
		}
	}

	public void add(short[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(short[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Short[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Short[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(String value) {
		_query.setString(_pos++, value);
	}

	public void add(String[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(String[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public void add(Timestamp value) {
		_query.setTimestamp(_pos++, value);
	}

	public void add(Timestamp[] values) {
		add(values, _DEFAULT_ARRAY_COUNT);
	}

	public void add(Timestamp[] values, int count) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < count; j++) {
				add(values[i]);
			}
		}
	}

	public int getPos() {
		return _pos;
	}

	private QueryPos(Query query) {
		_query = query;
	}

	private void _addNull() {
		_query.setSerializable(_pos++, null);
	}

	private static final int _DEFAULT_ARRAY_COUNT = 1;

	private int _pos;
	private Query _query;

}