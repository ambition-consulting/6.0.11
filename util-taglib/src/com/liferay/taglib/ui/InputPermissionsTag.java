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
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 * @author Wilson S. Man
 */
public class InputPermissionsTag extends IncludeTag {

	public static String doTag(
			String formName, String modelName, PageContext pageContext)
		throws Exception {

		return doTag(_PAGE, formName, modelName, pageContext);
	}

	public static String doTag(
			String page, String formName, String modelName,
			PageContext pageContext)
		throws Exception {

		Object returnObj = PortalClassInvoker.invoke(
			false, _doEndTagMethodKey, page, formName, modelName, pageContext);

		if (returnObj != null) {
			return returnObj.toString();
		}
		else {
			return StringPool.BLANK;
		}
	}

	public int doEndTag() throws JspException {
		try {
			doTag(getPage(), _formName, _modelName, pageContext);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public void setModelName(String modelName) {
		_modelName = modelName;
	}

	protected String getPage() {
		return _PAGE;
	}

	private static final String _TAG_CLASS =
		"com.liferay.portal.servlet.taglib.ui.InputPermissionsTagUtil";

	private static final String _PAGE =
		"/html/taglib/ui/input_permissions/page.jsp";

	private static MethodKey _doEndTagMethodKey = new MethodKey(
		_TAG_CLASS, "doEndTag", String.class, String.class, String.class,
		PageContext.class);

	private String _formName = "fm";
	private String _modelName = null;

}