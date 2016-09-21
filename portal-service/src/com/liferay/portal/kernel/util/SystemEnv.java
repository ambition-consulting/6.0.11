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

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public class SystemEnv {

	public static Properties getProperties() {
		Properties props = new Properties();

		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = null;

			String osName = System.getProperty("os.name").toLowerCase();

			if (osName.indexOf("windows ") > -1) {
				if (osName.indexOf("windows 9") > -1) {
					process = runtime.exec("command.com /c set");
				}
				else {
					process = runtime.exec("cmd.exe /c set");
				}
			}
			else {
				process = runtime.exec("env");
			}

			UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				int pos = line.indexOf(CharPool.EQUAL);

				if (pos != -1) {
					String key = line.substring(0, pos);
					String value = line.substring(pos + 1);

					props.setProperty(key, value);
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return props;
	}

	public static void setProperties(Properties props) {
		Properties envProps = getProperties();

		Enumeration<String> enu = (Enumeration<String>)envProps.propertyNames();

		while (enu.hasMoreElements()) {
			String key = enu.nextElement();

			props.setProperty("env." + key, (String)envProps.get(key));
		}
	}

}