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

import java.io.Serializable;

/**
 * @author Michael Young
 */
public class Header implements Serializable {

	public static final int INTEGER_TYPE = 1;

	public static final int DATE_TYPE = 2;

	public static final int STRING_TYPE = 3;

	public long getDateValue() {
		return _dateValue;
	}

	public void setDateValue(long dateValue) {
		_dateValue = dateValue;
	}

	public int getIntValue() {
		return _intValue;
	}

	public void setIntValue(int intValue) {
		_intValue = intValue;
	}

	public String getStringValue() {
		return _stringValue;
	}

	public void setStringValue(String stringValue) {
		_stringValue = stringValue;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String toString() {
		if (_type == DATE_TYPE) {
			return String.valueOf(_dateValue);
		}
		else if (_type == INTEGER_TYPE) {
			return String.valueOf(_intValue);
		}
		else {
			return _stringValue;
		}
	}

	private int _intValue;
	private long _dateValue;
	private String _stringValue;
	private int _type;

}