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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.xml.QName;
import com.liferay.portal.model.EventDefinition;
import com.liferay.portal.model.PortletApp;

/**
 * @author Brian Wing Shun Chan
 */
public class EventDefinitionImpl implements EventDefinition {

	public EventDefinitionImpl(
		QName qName, String valueType, PortletApp portletApp) {

		_qName = qName;
		_valueType = valueType;
		_portletApp = portletApp;
	}

	public QName getQName() {
		return _qName;
	}

	public void setQName(QName qName) {
		_qName = qName;
	}

	public String getValueType() {
		return _valueType;
	}

	public void setValueType(String valueType) {
		_valueType = valueType;
	}

	public PortletApp getPortletApp() {
		return _portletApp;
	}

	public void setPortletApp(PortletApp portletApp) {
		_portletApp = portletApp;
	}

	private QName _qName;
	private String _valueType;
	private PortletApp _portletApp;

}