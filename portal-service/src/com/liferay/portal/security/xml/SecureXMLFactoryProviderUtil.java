/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.security.xml;

import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.XMLReader;

/**
 * @author Tomas Polesovsky
 */
public class SecureXMLFactoryProviderUtil {

	public static SecureXMLFactoryProvider getSecureXMLFactoryProvider() {
		return _secureXMLFactoryProvider;
	}

	public static DocumentBuilderFactory newDocumentBuilderFactory() {
		return getSecureXMLFactoryProvider().newDocumentBuilderFactory();
	}

	/**
	 * @return {@link javax.xml.stream.XMLInputFactory}
	 */
	public static Object newXMLInputFactory() {
		return getSecureXMLFactoryProvider().newXMLInputFactory();
	}

	public static XMLReader newXMLReader() {
		return getSecureXMLFactoryProvider().newXMLReader();
	}

	public void setSecureXMLFactoryProvider(
		SecureXMLFactoryProvider secureXMLFactoryProvider) {

		_secureXMLFactoryProvider = secureXMLFactoryProvider;
	}

	private static SecureXMLFactoryProvider _secureXMLFactoryProvider;

}