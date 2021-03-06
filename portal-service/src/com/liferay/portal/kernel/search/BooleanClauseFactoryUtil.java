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
 * @author Bruno Farache
 */
public class BooleanClauseFactoryUtil {

	public static BooleanClause create(
		String field, String value, String occur) {

		return getBooleanClauseFactory().create(field, value, occur);
	}

	public static BooleanClauseFactory getBooleanClauseFactory() {
		return _booleanClauseFactory;
	}

	public void setBooleanClauseFactory(
		BooleanClauseFactory booleanClauseFactory) {

		_booleanClauseFactory = booleanClauseFactory;
	}

	private static BooleanClauseFactory _booleanClauseFactory;

}