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

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.taglib.util.ParamAndPropertyAncestorTagImpl;

import java.util.Collections;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class CustomAttributesAvailableTag
	extends ParamAndPropertyAncestorTagImpl {

	public int doStartTag() {
		try {
			long companyId = _companyId;

			if (companyId == 0) {
				companyId = CompanyThreadLocal.getCompanyId();
			}

			ExpandoBridge expandoBridge =
				ExpandoBridgeFactoryUtil.getExpandoBridge(
					companyId, _className);

			List<String> attributeNames = Collections.list(
				expandoBridge.getAttributeNames());

			if (attributeNames.isEmpty()) {
				return SKIP_BODY;
			}
			else {
				return EVAL_BODY_INCLUDE;
			}
		}
		finally {
			if (!ServerDetector.isResin()) {
				_className = null;
				_companyId = 0;
			}
		}
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private String _className;
	private long _companyId;

}