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

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.thoughtworks.selenium.CommandProcessor;
import com.thoughtworks.selenium.DefaultSelenium;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayDefaultSelenium
	extends DefaultSelenium implements LiferaySelenium {

	public LiferayDefaultSelenium(CommandProcessor processor) {
		super(processor);
	}

	public LiferayDefaultSelenium(
		String serverHost, int serverPort, String browserStartCommand,
		String browserURL) {

		super(serverHost, serverPort, browserStartCommand, browserURL);
	}

	public String getCurrentDay() {
		return commandProcessor.getString(
			"getCurrentDay", new String[0]);
	}

	public String getCurrentMonth() {
		return commandProcessor.getString(
			"getCurrentMonth", new String[0]);
	}

	public String getCurrentYear() {
		return commandProcessor.getString(
			"getCurrentYear", new String[0]);
	}

	public String getFirstNumber(String locator) {
		return commandProcessor.getString(
			"getFirstNumber", new String[] {locator,});
	}

	public String getFirstNumberIncrement(String locator) {
		return commandProcessor.getString(
			"getFirstNumberIncrement", new String[] {locator,});
	}

	public boolean isPartialText(String locator, String value) {
		return commandProcessor.getBoolean(
			"isPartialText", new String[] {locator, value,});
	}

	public void saveScreenShotAndSource() throws Exception {
		String screenShotName = null;

		if (TestPropsValues.SAVE_SCREENSHOT) {
			screenShotName = getScreenshotFileName();

			captureEntirePageScreenshot(
				_OUTPUT_SCREENSHOTS_DIR + screenShotName + ".jpg", "");
		}

		if (TestPropsValues.SAVE_SOURCE) {
			String content = getHtmlSource();

			screenShotName = getScreenshotFileName();

			FileUtil.write(
				_OUTPUT_SCREENSHOTS_DIR + screenShotName + ".html", content);
		}
	}

	public void setTimeout(String timeout) {
		super.setTimeout(timeout);

		_timeout = timeout;
	}

	public void waitForPageToLoad(String timeout) {
		super.waitForPageToLoad(_timeout);
	}

	protected String getScreenshotFileName() {
		Thread currentThread = Thread.currentThread();

		StackTraceElement[] stackTraceElements = currentThread.getStackTrace();

		for (int i = 1; i < stackTraceElements.length; i++) {
			StackTraceElement stackTraceElement = stackTraceElements[i];

			String className = stackTraceElement.getClassName();

			if ((className.startsWith("com.liferay.portalweb.plugins") ||
				 className.startsWith("com.liferay.portalweb.portal") ||
				 className.startsWith("com.liferay.portalweb.portlet") ||
				 className.startsWith("com.liferay.portalweb.properties")) &&
				 className.endsWith("Test")) {

				String dirName = className.substring(
					22, className.length());

				dirName = StringUtil.replace(dirName, ".", "/") + "/";

				String fileName = stackTraceElement.getFileName();
				int lineNumber = stackTraceElement.getLineNumber();

				FileUtil.mkdirs(_OUTPUT_SCREENSHOTS_DIR + dirName);

				return dirName + fileName + "-" + lineNumber;
			}
		}

		throw new RuntimeException("Unable to find screenshot file name");
	}

	private static final String _OUTPUT_SCREENSHOTS_DIR =
		TestPropsValues.OUTPUT_DIR + "screenshots/";

	private String _timeout = "30000";

}