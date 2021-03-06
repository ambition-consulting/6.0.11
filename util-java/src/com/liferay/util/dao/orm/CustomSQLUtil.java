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

package com.liferay.util.dao.orm;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 * @author Raymond Augé
 */
public class CustomSQLUtil {

	public static String appendCriteria(String sql, String criteria) {
		return _instance._customSQL.appendCriteria(sql, criteria);
	}

	public static String get(String id) {
		return _instance._customSQL.get(id);
	}

	public static boolean isVendorDB2() {
		return _instance._customSQL.isVendorDB2();
	}

	public static boolean isVendorInformix() {
		return _instance._customSQL.isVendorInformix();
	}

	public static boolean isVendorMySQL() {
		return _instance._customSQL.isVendorMySQL();
	}

	public static boolean isVendorOracle() {
		return _instance._customSQL.isVendorOracle();
	}

	public static boolean isVendorSybase() {
		return _instance._customSQL.isVendorSybase();
	}

	public static String[] keywords(String keywords) {
		return _instance._customSQL.keywords(keywords);
	}

	public static String[] keywords(String keywords, boolean lowerCase) {
		return _instance._customSQL.keywords(keywords, lowerCase);
	}

	public static String[] keywords(String[] keywordsArray) {
		return _instance._customSQL.keywords(keywordsArray);
	}

	public static String[] keywords(String[] keywordsArray, boolean lowerCase) {
		return _instance._customSQL.keywords(
			keywordsArray, lowerCase);
	}

	public static String removeGroupBy(String sql) {
		return _instance._customSQL.removeGroupBy(sql);
	}

	public static String removeOrderBy(String sql) {
		return _instance._customSQL.removeOrderBy(sql);
	}

	public static String replaceAndOperator(String sql, boolean andOperator) {
		return _instance._customSQL.replaceAndOperator(
			sql, andOperator);
	}

	public static String replaceIsNull(String sql) {
		return _instance._customSQL.replaceIsNull(sql);
	}

	public static String replaceKeywords(
		String sql, String field, boolean last, int[] values) {

		return _instance._customSQL.replaceKeywords(sql, field, last, values);
	}

	public static String replaceKeywords(
		String sql, String field, boolean last, long[] values) {

		return _instance._customSQL.replaceKeywords(sql, field, last, values);
	}

	public static String replaceKeywords(
		String sql, String field, String operator, boolean last,
		String[] values) {

		return _instance._customSQL.replaceKeywords(
			sql, field, operator, last, values);
	}

	public static String replaceGroupBy(String sql, String groupBy) {
		return _instance._customSQL.replaceGroupBy(sql, groupBy);
	}

	public static String replaceOrderBy(String sql, OrderByComparator obc) {
		return _instance._customSQL.replaceOrderBy(sql, obc);
	}

	private CustomSQLUtil() {
		try {
			_customSQL = new CustomSQL();
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CustomSQLUtil.class);

	private static CustomSQLUtil _instance = new CustomSQLUtil();

	private CustomSQL _customSQL;

}