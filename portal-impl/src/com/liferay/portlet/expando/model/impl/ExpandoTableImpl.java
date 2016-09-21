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

package com.liferay.portlet.expando.model.impl;

import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpandoTableImpl
	extends ExpandoTableModelImpl implements ExpandoTable {

	public ExpandoTableImpl() {
	}

	public boolean isDefaultTable() {
		if (getName().equals(ExpandoTableConstants.DEFAULT_TABLE_NAME)) {
			return true;
		}
		else {
			return false;
		}
	}

}