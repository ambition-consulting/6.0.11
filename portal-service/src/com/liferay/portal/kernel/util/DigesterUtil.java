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
 * @author Alexander Chow
 */
public class DigesterUtil {

	public static String digest(String text) {
		return getDigester().digest(text);
	}

	public static String digest(String algorithm, String... text) {
		return getDigester().digest(algorithm, text);
	}

	public static String digestHex(String text) {
		return getDigester().digestHex(text);
	}

	public static String digestHex(String algorithm, String... text) {
		return getDigester().digestHex(algorithm, text);
	}

	public static byte[] digestRaw(String text) {
		return getDigester().digestRaw(text);
	}

	public static byte[] digestRaw(String algorithm, String... text) {
		return getDigester().digestRaw(algorithm, text);
	}

	public static Digester getDigester() {
		return _digester;
	}

	public void setDigester(Digester digester) {
		_digester = digester;
	}

	private static Digester _digester;

}