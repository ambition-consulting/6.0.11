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

package com.liferay.portlet;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class Preference implements Cloneable, Serializable {

	public Preference(String name, String value) {
		this(name, new String[] {value});
	}

	public Preference(String name, String value, boolean readOnly) {
		this(name, new String[] {value}, readOnly);
	}

	public Preference(String name, String[] values) {
		this(name, values, false);
	}

	public Preference(String name, String[] values, boolean readOnly) {
		_name = name;
		_values = values;
		_readOnly = readOnly;
	}

	public String getName() {
		return _name;
	}

	public String[] getValues() {
		return _values;
	}

	public void setValues(String[] values) {
		_values = values;
	}

	public boolean getReadOnly() {
		return _readOnly;
	}

	public boolean isReadOnly() {
		return _readOnly;
	}

	public Object clone() {
		return new Preference(_name, _values, _readOnly);
	}

	private String _name;
	private String[] _values;
	private boolean _readOnly;

}