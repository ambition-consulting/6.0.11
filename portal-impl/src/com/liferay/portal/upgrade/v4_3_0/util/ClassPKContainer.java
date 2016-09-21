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

import com.liferay.portal.kernel.upgrade.util.ValueMapper;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassPKContainer {

	public ClassPKContainer(ValueMapper valueMapper, boolean isLong) {
		_valueMapper = valueMapper;
		_isLong = isLong;
	}

	public ValueMapper getValueMapper() {
		return _valueMapper;
	}

	public boolean isLong() {
		return _isLong;
	}

	private ValueMapper _valueMapper;
	private boolean _isLong;

}