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

import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class InputPermissionsParamsTag extends TagSupport {

	public static String doTag(
			String modelName, PageContext pageContext)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _doEndTagMethodKey, modelName, pageContext);

		if (returnObj != null) {
			return returnObj.toString();
		}
		else {
			return StringPool.BLANK;
		}
	}

	public int doEndTag() throws JspException {
		try {
			doTag(_modelName, pageContext);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}

	public void setModelName(String modelName) {
		_modelName = modelName;
	}

	private static final String _TAG_CLASS =
		"com.liferay.portal.servlet.taglib.ui.InputPermissionsParamsTagUtil";

	private static MethodKey _doEndTagMethodKey = new MethodKey(
		_TAG_CLASS, "doEndTag", String.class, PageContext.class);

	private String _modelName;

}