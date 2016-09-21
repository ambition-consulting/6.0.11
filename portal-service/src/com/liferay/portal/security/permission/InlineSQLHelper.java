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
public interface InlineSQLHelper {

	public boolean isEnabled();

	public boolean isEnabled(long groupId);

	public boolean isEnabled(long[] groupIds);

	public String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField);

	public String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long groupId);

	public String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long groupId, String bridgeJoin);

	public String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long[] groupIds);

	public String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		long[] groupIds, String bridgeJoin);

	public String replacePermissionCheck(
		String sql, String className, String classPKField, String userIdField,
		String bridgeJoin);

}