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

package com.liferay.portal.cmis.model;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;

/**
 * @author Alexander Chow
 */
public class CMISRepositoryInfo extends ElementWrapper {

	public CMISRepositoryInfo(Element element) {
		super(element);

		_cmisConstants = CMISConstants.getInstance();
	}

	public CMISRepositoryInfo(Factory factory) {
		super(factory, CMISConstants.getInstance().REPOSITORY_INFO);

		_cmisConstants = CMISConstants.getInstance();
	}

	public String getDescription() {
		return getFirstChildText(_cmisConstants.REPOSITORY_DESCRIPTION);
	}

	public String getId() {
		return getFirstChildText(_cmisConstants.REPOSITORY_ID);
	}

	public String getName() {
		return getFirstChildText(_cmisConstants.REPOSITORY_NAME);
	}

	public String getProductName() {
		return getFirstChildText(_cmisConstants.REPOSITORY_PRODUCT_NAME);
	}

	public String getProductVersion() {
		return getFirstChildText(_cmisConstants.REPOSITORY_PRODUCT_VERSION);
	}

	public String getRelatonship() {
		return getFirstChildText(_cmisConstants.REPOSITORY_RELATIONSHIP);
	}

	public String getRootFolderId() {
		return getFirstChildText(_cmisConstants.REPOSITORY_ROOT_FOLDER_ID);
	}

	public Element getSpecificInfo() {
		return getFirstChild(_cmisConstants.REPOSITORY_SPECIFIC_INFO);
	}

	public String getVendorName() {
		return getFirstChildText(_cmisConstants.REPOSITORY_VENDOR_NAME);
	}

	public String getVersionSupported() {
		return getFirstChildText(_cmisConstants.REPOSITORY_VERSION_SUPPORTED);
	}

	protected String getFirstChildText(QName qName) {
		String text = null;

		Element element = getFirstChild(qName);

		if (element != null) {
			text = element.getText();
		}

		return text;
	}

	private CMISConstants _cmisConstants;

}