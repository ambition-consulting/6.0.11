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

package com.liferay.util.xml.descriptor;

import com.liferay.util.xml.ElementIdentifier;

import org.dom4j.Document;

/**
 * @author Jorge Ferrer
 */
public class TilesDefsDescriptor extends SimpleXMLDescriptor {

	public boolean canHandleType(String doctype, Document root) {
		if (doctype.indexOf("tiles-config") != -1) {
			return true;
		}
		else {
			return false;
		}
	}

	public String[] getRootChildrenOrder() {
		return _ROOT_CHILDREN_ORDER;
	}

	public ElementIdentifier[] getElementsIdentifiedByAttribute() {
		return _ELEMENTS_IDENTIFIED_BY_ATTR;
	}

	public String[] getUniqueElements() {
		return _UNIQUE_ELEMENTS;
	}

	private static final String[] _ROOT_CHILDREN_ORDER ={
		"definition"
	};

	private static final ElementIdentifier[] _ELEMENTS_IDENTIFIED_BY_ATTR = {
		new ElementIdentifier("definition", "name")
	};

	private static final String[] _UNIQUE_ELEMENTS = {
	};

}