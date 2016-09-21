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

import java.io.File;

/**
 * @author Brian Wing Shun Chan
 */
public class OSDetector {

	public static boolean isAIX() {
		if (_aix == null) {
			String osName = System.getProperty("os.name");

			if (osName.equalsIgnoreCase("aix")) {
				_aix = Boolean.TRUE;
			}
			else {
				_aix = Boolean.FALSE;
			}
		}

		return _aix.booleanValue();
	}

	public static boolean isUnix() {
		if (_unix == null) {
			if (File.pathSeparator.equals(StringPool.COLON)) {
				_unix = Boolean.TRUE;
			}
			else {
				_unix = Boolean.FALSE;
			}
		}

		return _unix.booleanValue();
	}

	public static boolean isWindows() {
		if (_windows == null) {
			if (File.pathSeparator.equals(StringPool.SEMICOLON)) {
				_windows = Boolean.TRUE;
			}
			else {
				_windows = Boolean.FALSE;
			}
		}

		return _windows.booleanValue();
	}

	private static Boolean _aix;
	private static Boolean _unix;
	private static Boolean _windows;

}