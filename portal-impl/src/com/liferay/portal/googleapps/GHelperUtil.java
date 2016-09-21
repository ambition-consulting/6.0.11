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

package com.liferay.portal.googleapps;

import com.liferay.portal.kernel.googleapps.GoogleAppsException;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Attribute;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Namespace;
import com.liferay.portal.kernel.xml.QName;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.IOException;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class GHelperUtil {

	public static final String APPS_URL =
		"https://apps-apis.google.com/a/feeds";

	public static Element addAppsProperty(
		Element parentElement, String name, String value) {

		Element element = parentElement.addElement("apps:property");

		element.addAttribute("name", name);
		element.addAttribute("value", value);

		return element;
	}

	public static Element addAtomCategory(Element parentElement, String type) {
		Element element = parentElement.addElement("atom:category");

		element.addAttribute("scheme", "http://schemas.google.com/g/2005#kind");
		element.addAttribute(
			"term", "http://schemas.google.com/apps/2006#" + type);

		return element;
	}

	public static Element addAtomEntry(Document document) {
		Element element = document.addElement("atom:entry");

		element.add(getAppsNamespace());
		element.add(getAtomNamespace());

		return element;
	}

	public static Namespace getAppsNamespace() {
		return SAXReaderUtil.createNamespace(_APPS_PREFIX, _APPS_URI);
	}

	public static QName getAppsQName(String localName) {
		return SAXReaderUtil.createQName(localName, getAppsNamespace());
	}

	public static Namespace getAtomNamespace() {
		return SAXReaderUtil.createNamespace(_ATOM_PREFIX, _ATOM_URI);
	}

	public static QName getAtomQName(String localName) {
		return SAXReaderUtil.createQName(localName, getAtomNamespace());
	}

	public static Document getDocument(
			GAuthenticator gAuthenticator, String url)
		throws GoogleAppsException {

		try {
			Http.Options options = _getOptions(gAuthenticator);

			options.setLocation(url);

			String xml = HttpUtil.URLtoString(options);

			return SAXReaderUtil.read(new UnsyncStringReader(xml));
		}
		catch (DocumentException de) {
			throw new GoogleAppsException(de);
		}
		catch (IOException ioe) {
			throw new GoogleAppsException(ioe);
		}
	}

	public static String getErrorMessage(Document document) {
		Element rootElement = document.getRootElement();

		Element errorElement = rootElement.element("error");

		List<Attribute> attributes = errorElement.attributes();

		StringBundler sb = new StringBundler(attributes.size() * 4 + 1);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		for (int i = 0; i < attributes.size(); i++) {
			Attribute attribute = attributes.get(i);

			sb.append(attribute.getName());
			sb.append(StringPool.EQUAL);
			sb.append(attribute.getValue());

			if ((i + 1) <= attributes.size()) {
				sb.append(StringPool.COMMA_AND_SPACE);
			}
		}

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}

	public static boolean hasError(Document document) {
		Element rootElement = document.getRootElement();

		if (rootElement.element("error") != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void submitAdd(
			GAuthenticator gAuthenticator, String url, Document document)
		throws GoogleAppsException {

		try {
			Http.Options options = _getOptions(gAuthenticator);

			options.setBody(
				document.formattedString(), ContentTypes.APPLICATION_ATOM_XML,
				StringPool.UTF8);
			options.setLocation(url);
			options.setPost(true);

			HttpUtil.URLtoString(options);
		}
		catch (IOException ioe) {
			throw new GoogleAppsException(ioe);
		}
	}

	public static void submitDelete(GAuthenticator gAuthenticator, String url)
		throws GoogleAppsException {

		try {
			Http.Options options = _getOptions(gAuthenticator);

			options.setDelete(true);
			options.setLocation(url);

			HttpUtil.URLtoString(options);
		}
		catch (IOException ioe) {
			throw new GoogleAppsException(ioe);
		}
	}

	public static void submitUpdate(
			GAuthenticator gAuthenticator, String url, Document document)
		throws GoogleAppsException {

		try {
			Http.Options options = _getOptions(gAuthenticator);

			options.setBody(
				document.formattedString(), ContentTypes.APPLICATION_ATOM_XML,
				StringPool.UTF8);
			options.setLocation(url);
			options.setPut(true);

			HttpUtil.URLtoString(options);
		}
		catch (IOException ioe) {
			throw new GoogleAppsException(ioe);
		}
	}

	private static Http.Options _getOptions(GAuthenticator gAuthenticator) {
		Http.Options options = new Http.Options();

		options.addHeader(
			HttpHeaders.AUTHORIZATION,
			"GoogleLogin auth=" + gAuthenticator.getAuthenticationToken());

		return options;
	}

	private static final String _APPS_PREFIX = "apps";

	private static final String _APPS_URI =
		"http://schemas.google.com/apps/2006";

	private static final String _ATOM_PREFIX = "atom";

	private static final String _ATOM_URI = "http://www.w3.org/2005/Atom";

}