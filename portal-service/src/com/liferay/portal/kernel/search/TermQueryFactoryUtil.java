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

package com.liferay.portal.kernel.search;

/**
 * @author Brian Wing Shun Chan
 */
public class TermQueryFactoryUtil {

	public static TermQuery create(String field, long value) {
		return getTermQueryFactory().create(field, value);
	}

	public static TermQuery create(String field, String value) {
		return getTermQueryFactory().create(field, value);
	}

	public static TermQueryFactory getTermQueryFactory() {
		return _termQueryFactory;
	}

	public void setTermQueryFactory(
		TermQueryFactory termQueryFactory) {

		_termQueryFactory = termQueryFactory;
	}

	private static TermQueryFactory _termQueryFactory;

}