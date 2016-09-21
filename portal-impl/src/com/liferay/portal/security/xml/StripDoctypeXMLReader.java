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

import java.io.FilterInputStream;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/**
 * @author Tomas Polesovsky
 */
public class StripDoctypeXMLReader implements XMLReader {

	public StripDoctypeXMLReader(XMLReader xmlReader) {
		_xmlReader = xmlReader;
	}

	public ContentHandler getContentHandler() {
		return _xmlReader.getContentHandler();
	}

	public DTDHandler getDTDHandler() {
		return _xmlReader.getDTDHandler();
	}

	public EntityResolver getEntityResolver() {
		return _xmlReader.getEntityResolver();
	}

	public ErrorHandler getErrorHandler() {
		return _xmlReader.getErrorHandler();
	}

	public boolean getFeature(String name)
		throws SAXNotRecognizedException, SAXNotSupportedException {

		return _xmlReader.getFeature(name);
	}

	public Object getProperty(String name)
		throws SAXNotRecognizedException, SAXNotSupportedException {

		return _xmlReader.getProperty(name);
	}

	public void parse(InputSource inputSource)
		throws IOException, SAXException {

		if (_disallowDoctypeDecl) {
			InputStream inputStream = inputSource.getByteStream();

			if (inputStream != null) {
				final StripDoctypeFilter stripDoctypeFilter =
					new StripDoctypeFilter(inputStream);

				inputSource.setByteStream(
					new FilterInputStream(inputStream) {

						@Override
						public int read() throws IOException {
							return stripDoctypeFilter.read();
						}

						@Override
						public int read(byte[] bytes, int offset, int length)
							throws IOException {

							return stripDoctypeFilter.read(
								bytes, offset, length);
						}

					});
			}

			Reader reader = inputSource.getCharacterStream();

			if (reader != null) {
				final StripDoctypeFilter stripDoctypeFilter =
					new StripDoctypeFilter(reader);

				inputSource.setCharacterStream(
					new FilterReader(reader) {

						@Override
						public int read() throws IOException {
							return stripDoctypeFilter.read();
						}

						@Override
						public int read(char[] chars, int offset, int length)
							throws IOException {

							return stripDoctypeFilter.read(
								chars, offset, length);
						}

					});
			}
		}

		_xmlReader.parse(inputSource);
	}

	public void parse(String systemId) throws IOException, SAXException {
		_xmlReader.parse(systemId);
	}

	public void setContentHandler(ContentHandler contentHandler) {
		_xmlReader.setContentHandler(contentHandler);
	}

	public void setDTDHandler(DTDHandler dtdHandler) {
		_xmlReader.setDTDHandler(dtdHandler);
	}

	public void setEntityResolver(EntityResolver entityResolver) {
		_xmlReader.setEntityResolver(entityResolver);
	}

	public void setErrorHandler(ErrorHandler errorHandler) {
		_xmlReader.setErrorHandler(errorHandler);
	}

	public void setFeature(String name, boolean value)
		throws SAXNotRecognizedException, SAXNotSupportedException {

		if (_FEATURES_DISALLOW_DOCTYPE_DECL.equals(name)) {
			_disallowDoctypeDecl = value;
		}

		_xmlReader.setFeature(name, value);
	}

	public void setProperty(String name, Object value)
		throws SAXNotRecognizedException, SAXNotSupportedException {

		_xmlReader.setProperty(name, value);
	}

	private static final String _FEATURES_DISALLOW_DOCTYPE_DECL =
		"http://apache.org/xml/features/disallow-doctype-decl";

	private boolean _disallowDoctypeDecl;
	private final XMLReader _xmlReader;

}