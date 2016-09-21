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

package com.liferay.util.xml;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Namespace;
import com.liferay.portal.kernel.xml.QName;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class DocUtil {

	public static Element add(Element element, String name, boolean text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(Element element, String name, double text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(Element element, String name, float text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(Element element, String name, int text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(Element element, String name, long text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace) {

		QName qName = SAXReaderUtil.createQName(name, namespace);

		return element.addElement(qName);
	}

	public static Element add(
		Element element, String name, Namespace namespace, boolean text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, double text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, float text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, int text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, long text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, Object text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, short text) {

		return add(element, name, namespace, String.valueOf(text));
	}

	public static Element add(
		Element element, String name, Namespace namespace, String text) {

		QName qName = SAXReaderUtil.createQName(name, namespace);

		Element childElement = element.addElement(qName);

		childElement.addText(GetterUtil.getString(text));

		return childElement;
	}

	public static Element add(Element element, String name, Object text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(Element element, String name, short text) {
		return add(element, name, String.valueOf(text));
	}

	public static Element add(Element element, String name, String text) {
		Element childElement = element.addElement(name);

		childElement.addText(GetterUtil.getString(text));

		return childElement;
	}

}