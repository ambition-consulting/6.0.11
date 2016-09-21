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

package com.liferay.portal.kernel.upgrade.util;

/**
 * @author Brian Wing Shun Chan
 */
public class ValueMapperFactoryUtil {

	public static ValueMapper getValueMapper() {
		return getValueMapperFactory().getValueMapper();
	}

	public static ValueMapperFactory getValueMapperFactory() {
		return _valueMapperFactory;
	}

	public void setValueMapperFactory(ValueMapperFactory valueMapperFactory) {
		_valueMapperFactory = valueMapperFactory;
	}

	private static ValueMapperFactory _valueMapperFactory;

}