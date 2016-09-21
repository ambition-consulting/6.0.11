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

import com.liferay.portal.kernel.util.Time;
import com.liferay.portalweb.portal.util.TestPropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class SeleniumUtil {

	public static LiferaySelenium getSelenium() {
		return _instance._getSelenium();
	}

	public static String getTimestamp() {
		return _instance._getTimestamp();
	}

	public static void startSelenium() {
		_instance._startSelenium();
	}

	public static void stopSelenium() {
		_instance._stopSelenium();
	}

	private SeleniumUtil() {
		_timestamp = Time.getTimestamp();
	}

	private LiferaySelenium _getSelenium() {
		if (_selenium == null) {
			_startSelenium();
		}

		return _selenium;
	}

	private String _getTimestamp() {
		return _timestamp;
	}

	private void _startSelenium() {
		String seleniumHost = TestPropsValues.SELENIUM_HOST;
		int seleniumPort = TestPropsValues.SELENIUM_PORT;
		String browserType = TestPropsValues.BROWSER_TYPE;
		String portalURL = TestPropsValues.PORTAL_URL;

		_selenium = new LiferayDefaultSelenium(
			seleniumHost, seleniumPort, browserType, portalURL);

		_selenium.start();

		_selenium.setContext(this.getClass().getName());
	}

	private void _stopSelenium() {
		if (_selenium != null) {
			_selenium.stop();
		}

		_selenium = null;
	}

	private static SeleniumUtil _instance = new SeleniumUtil();

	private String _timestamp;
	private LiferaySelenium _selenium;

}