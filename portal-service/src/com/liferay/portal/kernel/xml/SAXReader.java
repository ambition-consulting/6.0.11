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

package com.liferay.portal.kernel.xml;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public interface SAXReader {

	public Attribute createAttribute(
		Element element, QName qName, String value);

	public Attribute createAttribute(
		Element element, String name, String value);

	public Document createDocument();

	public Document createDocument(Element rootElement);

	public Document createDocument(String encoding);

	public Element createElement(QName qName);

	public Element createElement(String name);

	public Entity createEntity(String name, String text);

	public ProcessingInstruction createProcessingInstruction(
		String target, Map<String, String> data);

	public ProcessingInstruction createProcessingInstruction(
		String target, String data);

	public Namespace createNamespace(String uri);

	public Namespace createNamespace(String prefix, String uri);

	public QName createQName(String localName);

	public QName createQName(String localName, Namespace namespace);

	public Text createText(String text);

	public XPath createXPath(String xpathExpression);

	public Document read(File file) throws DocumentException;

	public Document read(File file, boolean validate)
		throws DocumentException;

	public Document read(InputStream is) throws DocumentException;

	public Document read(InputStream is, boolean validate)
		throws DocumentException;

	public Document read(Reader reader) throws DocumentException;

	public Document read(Reader reader, boolean validate)
		throws DocumentException;

	public Document read(String xml) throws DocumentException;

	public Document read(String xml, boolean validate)
		throws DocumentException;

	public Document read(URL url) throws DocumentException;

	public Document read(URL url, boolean validate) throws DocumentException;

	public Document readURL(String url)
		throws DocumentException, MalformedURLException;

	public Document readURL(String url, boolean validate)
		throws DocumentException, MalformedURLException;

	public List<Node> selectNodes(
		String xpathFilterExpression, List<Node> nodes);

	public List<Node> selectNodes(String xpathFilterExpression, Node node);

	public void sort(List<Node> nodes, String xpathExpression);

	public void sort(
		List<Node> nodes, String xpathExpression, boolean distinct);

}