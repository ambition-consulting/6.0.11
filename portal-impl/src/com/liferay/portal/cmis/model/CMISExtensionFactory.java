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

import org.apache.abdera.util.AbstractExtensionFactory;

/**
 * @author Alexander Chow
 */
public class CMISExtensionFactory extends AbstractExtensionFactory {

	public CMISExtensionFactory() {
		super(CMISConstants.getInstance().CMIS_NS);

		_cmisConstants = CMISConstants.getInstance();

		addImpl(_cmisConstants.REPOSITORY_INFO, CMISRepositoryInfo.class);
		addImpl(_cmisConstants.OBJECT, CMISObject.class);
	}

	private CMISConstants _cmisConstants;

}