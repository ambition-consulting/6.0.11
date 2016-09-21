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

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.util.xml.XMLFormatter;

import java.io.IOException;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentImpl extends BranchImpl implements Document {

	public DocumentImpl(org.dom4j.Document document) {
		super(document);

		_document = document;
	}

	public Document addComment(String comment) {
		_document.addComment(comment);

		return this;
	}

	public Document addDocType(String name, String publicId, String systemId) {
		_document.addDocType(name, publicId, systemId);

		return this;
	}

	public boolean equals(Object obj) {
		org.dom4j.Document document = ((DocumentImpl)obj).getWrappedDocument();

		return _document.equals(document);
	}

	public String formattedString() throws IOException {
		return XMLFormatter.toString(_document);
	}

	public String formattedString(String indent) throws IOException {
		return XMLFormatter.toString(_document, indent);
	}

	public String formattedString(String indent, boolean expandEmptyElements)
		throws IOException {

		return XMLFormatter.toString(_document, indent, expandEmptyElements);
	}

	public Element getRootElement() {
		return new ElementImpl(_document.getRootElement());
	}

	public org.dom4j.Document getWrappedDocument() {
		return _document;
	}

	public String getXMLEncoding() {
		return _document.getXMLEncoding();
	}

	public int hashCode() {
		return _document.hashCode();
	}

	public void setRootElement(Element rootElement) {
		ElementImpl rootElementImpl = (ElementImpl)rootElement;

		_document.setRootElement(rootElementImpl.getWrappedElement());
	}

	public void setXMLEncoding(String encoding) {
		_document.setXMLEncoding(encoding);
	}

	public String toString() {
		return _document.toString();
	}

	private org.dom4j.Document _document;

}