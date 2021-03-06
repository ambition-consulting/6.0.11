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

package com.liferay.taglib.security;

import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.Encryptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class DoAsURLTag extends TagSupport {

	public static void doTag(
			long doAsUserId, String var, PageContext pageContext)
		throws Exception {

		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		String doAsURL = company.getHomeURL();

		if (Validator.isNull(doAsURL)) {
			doAsURL = _COMPANY_DEFAULT_HOME_URL;
		}

		doAsURL = themeDisplay.getPathContext() + doAsURL;

		if (doAsUserId <= 0) {
			doAsUserId = company.getDefaultUser().getUserId();
		}

		String encDoAsUserId = Encryptor.encrypt(
			company.getKeyObj(), String.valueOf(doAsUserId));

		doAsURL = HttpUtil.addParameter(
			doAsURL, "doAsUserId", encDoAsUserId);

		if (Validator.isNotNull(var)) {
			pageContext.setAttribute(var, doAsURL);
		}
		else {
			JspWriter jspWriter = pageContext.getOut();

			jspWriter.write(doAsURL);
		}
	}

	public int doEndTag() throws JspException {
		try {
			doTag(_doAsUserId, _var, pageContext);
		}
		catch (Exception e) {
			throw new JspException(e);
		}

		return EVAL_PAGE;
	}

	public void setDoAsUserId(long doAsUserId) {
		_doAsUserId = doAsUserId;
	}

	public void setVar(String var) {
		_var = var;
	}

	private static final String _COMPANY_DEFAULT_HOME_URL =
		PropsUtil.get(PropsKeys.COMPANY_DEFAULT_HOME_URL);

	private long _doAsUserId;
	private String _var;

}