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

package com.liferay.util.log4j;

import com.liferay.portal.kernel.util.ServerDetector;

import java.net.URL;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Brian Wing Shun Chan
 */
public class Log4JUtil {

	public static void configureLog4J(URL url) {
		if (url == null) {
			return;
		}

		// See LPS-6029 and LPS-8865

		if (!ServerDetector.isJBoss()) {
			DOMConfigurator.configure(url);
		}

		Set<String> currentLoggerNames = new HashSet<String>();

		Enumeration<Logger> enu = LogManager.getCurrentLoggers();

		while (enu.hasMoreElements()) {
			Logger logger = enu.nextElement();

			currentLoggerNames.add(logger.getName());
		}

		try {
			SAXReader reader = new SAXReader();

			Document doc = reader.read(url);

			Element root = doc.getRootElement();

			Iterator<Element> itr = root.elements("category").iterator();

			while (itr.hasNext()) {
				Element category = itr.next();

				String name = category.attributeValue("name");
				String priority =
					category.element("priority").attributeValue("value");

				setLevel(name, priority);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setLevel(String name, String priority) {
		Logger logger = Logger.getLogger(name);

		logger.setLevel(Level.toLevel(priority));

		java.util.logging.Logger jdkLogger = java.util.logging.Logger.getLogger(
			name);

		jdkLogger.setLevel(_getJdkLevel(priority));
	}

	private static java.util.logging.Level _getJdkLevel(String priority) {
		if (priority.equalsIgnoreCase(Level.DEBUG.toString())) {
			return java.util.logging.Level.FINE;
		}
		else if (priority.equalsIgnoreCase(Level.ERROR.toString())) {
			return java.util.logging.Level.SEVERE;
		}
		else if (priority.equalsIgnoreCase(Level.WARN.toString())) {
			return java.util.logging.Level.WARNING;
		}
		else {
			return java.util.logging.Level.INFO;
		}
	}

}