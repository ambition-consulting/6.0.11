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

package com.liferay.portlet.xslcontent.util;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PropsUtil;

import java.io.IOException;

import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Brian Wing Shun Chan
 */
public class XSLContentUtil {

	public static String DEFAULT_XML_URL = "@portlet_context_url@/example.xml";

	public static String DEFAULT_XSL_URL = "@portlet_context_url@/example.xsl";

	public static String replaceUrlTokens(
		ThemeDisplay themeDisplay, String url) {

		return StringUtil.replace(
			url, new String[] {"@portal_url@", "@portlet_context_url@"},
			new String[] {
				themeDisplay.getPortalURL(),
				themeDisplay.getPortalURL() + "/html/portlet/xsl_content"
			});
	}

	public static String transform(URL xmlURL, URL xslURL)
		throws IOException, TransformerException {

		String xml = HttpUtil.URLtoString(xmlURL);
		String xsl = HttpUtil.URLtoString(xslURL);

		StreamSource xmlSource = new StreamSource(new UnsyncStringReader(xml));
		StreamSource xslSource = new StreamSource(new UnsyncStringReader(xsl));

		TransformerFactory transformerFactory =
			TransformerFactory.newInstance();

		try {
			transformerFactory.setFeature(
				XMLConstants.FEATURE_SECURE_PROCESSING,
				_XSL_CONTENT_XSL_SECURE_PROCESSING_ENABLED);
		}
		catch (TransformerConfigurationException tce) {
		}

		Transformer transformer =
			transformerFactory.newTransformer(xslSource);

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		transformer.transform(
			xmlSource, new StreamResult(unsyncByteArrayOutputStream));

		return unsyncByteArrayOutputStream.toString();
	}

	private static final boolean _XSL_CONTENT_XSL_SECURE_PROCESSING_ENABLED =
		GetterUtil.getBoolean(
			PropsUtil.get("xsl.content.xsl.secure.processing.enabled"));

}