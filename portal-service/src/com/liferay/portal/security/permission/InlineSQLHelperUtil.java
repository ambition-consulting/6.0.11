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

package com.liferay.portal.security.permission;

/**
 * @author Raymond Augé
 */
public class InlineSQLHelperUtil {

	public static InlineSQLHelper getInlineSQLHelper() {
		return _inlineSQLPermission;
	}

	public static boolean isEnabled() {
		return getInlineSQLHelper().isEnabled();
	}

	public static boolean isEnabled(long groupId) {
		return getInlineSQLHelper().isEnabled(groupId);
	}

	public static boolean isEnabled(long[] groupIds) {
		return getInlineSQLHelper().isEnabled(groupIds);
	}

	public static String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField) {

		return getInlineSQLHelper().replacePermissionCheck(
			sql, className, classPKField, userIdField);
	}

	public static String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long groupId) {

		return getInlineSQLHelper().replacePermissionCheck(
			sql, className, classPKField, userIdField, groupId);
	}

	public static String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long groupId, String bridgeJoin) {

		return getInlineSQLHelper().replacePermissionCheck(
			sql, className, classPKField, userIdField, groupId, bridgeJoin);
	}

	public static String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long[] groupIds) {

		return getInlineSQLHelper().replacePermissionCheck(
			sql, className, classPKField, userIdField, groupIds);
	}

	public static String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long[] groupIds, String bridgeJoin) {

		return getInlineSQLHelper().replacePermissionCheck(
			sql, className, classPKField, userIdField, groupIds, bridgeJoin);
	}

	public static String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		String bridgeJoin) {

		return getInlineSQLHelper().replacePermissionCheck(
			sql, className, classPKField, userIdField, bridgeJoin);
	}

	public void setInlineSQLHelper(InlineSQLHelper inlineSQLPermission) {
		_inlineSQLPermission = inlineSQLPermission;
	}

	private static InlineSQLHelper _inlineSQLPermission;

}