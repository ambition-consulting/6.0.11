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

package com.liferay.portalweb.portal.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class TestPropsValues {

	public static final String BROWSER_TYPE = TestPropsUtil.get("browser.type");

	public static final long COMPANY_ID = GetterUtil.getLong(
		TestPropsUtil.get("company.id"));

	public static final String CLUSTER_NODE_1 =
		TestPropsUtil.get("cluster.node1");

	public static final String CLUSTER_NODE_2 =
		TestPropsUtil.get("cluster.node2");

	public static final String OUTPUT_DIR = TestPropsUtil.get("output.dir");

	public static final String PORTAL_URL = TestPropsUtil.get("portal.url");

	public static final boolean SAVE_SCREENSHOT = GetterUtil.getBoolean(
		TestPropsUtil.get("save.screenshot"));

	public static final boolean SAVE_SOURCE = GetterUtil.getBoolean(
		TestPropsUtil.get("save.source"));

	public static final String SELENIUM_HOST =
		TestPropsUtil.get("selenium.host");

	public static final int SELENIUM_PORT = GetterUtil.getInteger(
		TestPropsUtil.get("selenium.port"));

	public static final String[] THEME_IDS = StringUtil.split(
		TestPropsUtil.get("theme.ids"));

	public static final String VM_HOST = TestPropsUtil.get("vm.host");

}