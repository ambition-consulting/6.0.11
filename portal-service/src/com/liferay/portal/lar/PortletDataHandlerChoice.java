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

package com.liferay.portal.lar;

/**
 * @author	   Raymond Augé
 * @deprecated This class has been repackaged at
 *			   <code>com.liferay.portal.kernel.lar</code>.
 */
public class PortletDataHandlerChoice
	extends com.liferay.portal.kernel.lar.PortletDataHandlerChoice {

	public PortletDataHandlerChoice(String namespace, String controlName) {
		super(namespace, controlName);
	}

	public PortletDataHandlerChoice(
		String namespace, String controlName, int defaultChoice) {

		super(namespace, controlName, defaultChoice);
	}

	public PortletDataHandlerChoice(
		String namespace, String controlName, int defaultChoice,
		String[] choices) {

		super(namespace, controlName, defaultChoice, choices);
	}

}