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

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.taglib.util.IncludeTag;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class LanguageTag extends IncludeTag {

	public static final int LIST_ICON = 0;

	public static final int LIST_LONG_TEXT = 1;

	public static final int LIST_SHORT_TEXT = 2;

	public static final int SELECT_BOX = 3;

	public void setDisplayStyle(int displayStyle) {
		_displayStyle = displayStyle;
	}

	public void setFormAction(String formAction) {
		_formAction = formAction;
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public void setLanguageIds(String[] languageIds) {
		_languageIds = languageIds;
	}

	public void setName(String name) {
		_name = name;
	}

	protected void cleanUp() {
		_displayStyle = LIST_ICON;
		_formAction = null;
		_formName =  "fm";
		_languageIds = null;
		_name = "languageId";
	}

	protected String getPage() {
		return _PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"liferay-ui:language:displayStyle", String.valueOf(_displayStyle));
		request.setAttribute("liferay-ui:language:formAction", _formAction);
		request.setAttribute("liferay-ui:language:formName", _formName);

		Locale[] locales = null;

		if ((_languageIds == null) || (_languageIds.length == 0)) {
			locales = LanguageUtil.getAvailableLocales();
		}
		else {
			locales = LocaleUtil.fromLanguageIds(_languageIds);
		}

		request.setAttribute("liferay-ui:language:locales", locales);
		request.setAttribute("liferay-ui:language:name", _name);
	}

	private static final String _PAGE = "/html/taglib/ui/language/page.jsp";

	private int _displayStyle = LIST_ICON;
	private String _formAction;
	private String _formName = "fm";
	private String[] _languageIds;
	private String _name = "languageId";

}