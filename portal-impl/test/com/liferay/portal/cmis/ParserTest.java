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

package com.liferay.portal.cmis;

import com.liferay.portal.cmis.model.CMISConstants;
import com.liferay.portal.cmis.model.CMISExtensionFactory;
import com.liferay.portal.cmis.model.CMISObject;

import java.io.FileInputStream;

import org.apache.abdera.Abdera;
import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Service;
import org.apache.abdera.parser.Parser;

/**
 * @author Alexander Chow
 */
public class ParserTest extends BaseCMISTestCase {

	public void setUp() throws Exception {
		_abdera = Abdera.getInstance();

		Factory factory = _abdera.getFactory();

		factory.registerExtension(new CMISExtensionFactory());
	}

	public void testDocument() throws Exception {
		Entry entry = (Entry)getElement("cmis-document.xml");

		assertNotNull(entry);

		CMISObject cmisObject = entry.getFirstChild(_cmisConstants.OBJECT);

		assertNotNull(cmisObject);
		assertNotNull(cmisObject.getObjectId());
		assertEquals(
			_cmisConstants.BASE_TYPE_DOCUMENT, cmisObject.getBaseType());
	}

	public void testFolder() throws Exception {
		Entry entry = (Entry)getElement("cmis-folder.xml");

		assertNotNull(entry);

		CMISObject cmisObject = entry.getFirstChild(_cmisConstants.OBJECT);

		assertNotNull(cmisObject);
		assertNotNull(cmisObject.getObjectId());
		assertEquals(_cmisConstants.BASE_TYPE_FOLDER, cmisObject.getBaseType());
	}

	protected CMISConstants getConstants() {
		return _cmisConstants;
	}

	protected Element getElement(String filename) throws Exception {
		String path =
			"portal-impl/test/com/liferay/portal/cmis/dependencies/" + filename;

		Parser parser = _abdera.getParser();

		return parser.parse(new FileInputStream(path)).getRoot();
	}

	protected Service getService() throws Exception {
		return (Service)getElement("cmis-service.xml");
	}

	private static CMISConstants _cmisConstants = CMISConstants.getInstance();

	private Abdera _abdera;

}