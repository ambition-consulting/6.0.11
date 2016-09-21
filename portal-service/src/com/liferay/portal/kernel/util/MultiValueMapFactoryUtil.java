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

package com.liferay.portal.kernel.util;

/**
 * @author Brian Wing Shun Chan
 */
public class MultiValueMapFactoryUtil {

	public static MultiValueMap<?, ?> getMultiValueMap(int type) {
		return getMultiValueMapFactory().getMultiValueMap(type);
	}

	public static MultiValueMapFactory getMultiValueMapFactory() {
		return _multiValueMapFactory;
	}

	public void setMultiValueMapFactory(
		MultiValueMapFactory multiValueMapFactory) {

		_multiValueMapFactory = multiValueMapFactory;
	}

	private static MultiValueMapFactory _multiValueMapFactory;

}