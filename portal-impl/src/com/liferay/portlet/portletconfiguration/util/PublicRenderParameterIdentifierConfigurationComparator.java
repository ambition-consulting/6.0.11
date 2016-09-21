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

package com.liferay.portlet.portletconfiguration.util;

import com.liferay.portal.model.PublicRenderParameter;

import java.util.Comparator;

/**
 * @author Alberto Montero
 */
public class PublicRenderParameterIdentifierConfigurationComparator
	implements Comparator<PublicRenderParameterConfiguration> {

	public int compare(
		PublicRenderParameterConfiguration publicRenderParameterConfiguration1,
		PublicRenderParameterConfiguration
			publicRenderParameterConfiguration2) {

		PublicRenderParameter publicRenderParameter1 =
			publicRenderParameterConfiguration1.getPublicRenderParameter();
		PublicRenderParameter publicRenderParameter2 =
			publicRenderParameterConfiguration2.getPublicRenderParameter();

		String identifier1 = publicRenderParameter1.getIdentifier();
		String identifier2 = publicRenderParameter2.getIdentifier();

		return identifier1.compareTo(identifier2);
	}

}