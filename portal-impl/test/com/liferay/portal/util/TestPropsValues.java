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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class TestPropsValues {

	public static final long COMPANY_ID = GetterUtil.getLong(
		TestPropsUtil.get("company.id"));

	public static final String COMPANY_WEB_ID =
		TestPropsUtil.get("company.web.id");

	public static final long LAYOUT_PLID = GetterUtil.getLong(
		TestPropsUtil.get("layout.plid"));

	public static final String PORTAL_URL = TestPropsUtil.get("portal.url");

	public static final long USER_ID = GetterUtil.getLong(
		TestPropsUtil.get("user.id"));

	public static final String USER_PASSWORD =
		TestPropsUtil.get("user.password");

}