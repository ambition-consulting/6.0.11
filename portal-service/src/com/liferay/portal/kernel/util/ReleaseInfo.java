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

import java.text.DateFormat;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class ReleaseInfo {

	static String name = "Liferay Portal Enterprise Edition";

	static String version = "6.0.11";

	static String versionDisplayName = "6.0 EE SP1";

	static String codeName = "Bunyan";

	static String build = "6011";

	static int buildNumber = Integer.parseInt(build);

	static String date = "January 13, 2011";

	static String releaseInfoPrefix = System.getProperty(
		"liferay.release.info.prefix" , StringPool.BLANK);

	static String releaseInfoSuffix = System.getProperty(
		"liferay.release.info.suffix" , StringPool.BLANK);

	static String releaseInfo =
		releaseInfoPrefix + name + " " + versionDisplayName + " (" + codeName +
			" / Build " + build + " / " + date + ")" + releaseInfoSuffix;

	static String serverInfo = name + " / " + version;

	public static int RELEASE_4_2_0_BUILD_NUMBER = 3500;

	public static int RELEASE_4_2_1_BUILD_NUMBER = 3501;

	public static int RELEASE_4_2_2_BUILD_NUMBER = 3502;

	public static int RELEASE_4_3_0_BUILD_NUMBER = 4300;

	public static int RELEASE_4_3_1_BUILD_NUMBER = 4301;

	public static int RELEASE_4_3_2_BUILD_NUMBER = 4302;

	public static int RELEASE_4_3_3_BUILD_NUMBER = 4303;

	public static int RELEASE_4_3_4_BUILD_NUMBER = 4304;

	public static int RELEASE_4_3_5_BUILD_NUMBER = 4305;

	public static int RELEASE_4_3_6_BUILD_NUMBER = 4306;

	public static int RELEASE_4_4_0_BUILD_NUMBER = 4400;

	public static int RELEASE_5_0_0_BUILD_NUMBER = 5000;

	public static int RELEASE_5_0_1_BUILD_NUMBER = 5001;

	public static int RELEASE_5_1_0_BUILD_NUMBER = 5100;

	public static int RELEASE_5_1_1_BUILD_NUMBER = 5101;

	public static int RELEASE_5_1_2_BUILD_NUMBER = 5102;

	public static int RELEASE_5_2_0_BUILD_NUMBER = 5200;

	public static int RELEASE_5_2_1_BUILD_NUMBER = 5201;

	public static int RELEASE_5_2_2_BUILD_NUMBER = 5202;

	public static int RELEASE_5_2_3_BUILD_NUMBER = 5203;

	public static int RELEASE_6_0_0_BUILD_NUMBER = 6000;

	public static int RELEASE_6_0_1_BUILD_NUMBER = 6001;

	public static int RELEASE_6_0_2_BUILD_NUMBER = 6002;

	public static int RELEASE_6_0_3_BUILD_NUMBER = 6003;

	public static int RELEASE_6_0_4_BUILD_NUMBER = 6004;

	public static int RELEASE_6_0_5_BUILD_NUMBER = 6005;

	public static int RELEASE_6_0_6_BUILD_NUMBER = 6006;

	public static int RELEASE_6_0_10_BUILD_NUMBER = 6010;

	public static int RELEASE_6_0_11_BUILD_NUMBER = 6011;

	public static final String getVersion() {
		return version;
	}

	public static final String getCodeName() {
		return codeName;
	}

	public static final int getBuildNumber() {
		return buildNumber;
	}

	public static final Date getBuildDate() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);

		return GetterUtil.getDate(date, df);
	}

	public static final String getReleaseInfo() {
		return releaseInfo;
	}

	public static final String getServerInfo() {
		return serverInfo;
	}

}