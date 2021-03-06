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
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.FileAvailabilityUtil;
import com.liferay.portal.theme.ThemeDisplay;

import javax.servlet.jsp.JspWriter;

/**
 * @author Scott Lee
 * @author Shuyang Zhou
 */
public class IconHelpTag extends IconTag {

	protected String getPage() {
		if (FileAvailabilityUtil.isAvailable(getServletContext(), _PAGE)) {
			return _PAGE;
		}
		else {
			return null;
		}
	}

	protected int processEndTag() throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)pageContext.getAttribute(
			"themeDisplay");

		JspWriter jspWriter = pageContext.getOut();

		jspWriter.write("<span class=\"taglib-icon-help\"><img alt=\"\" ");
		jspWriter.write("onMouseOver=\"Liferay.Portal.ToolTip.show(this, '");
		jspWriter.write(UnicodeLanguageUtil.get(pageContext, getMessage()));
		jspWriter.write("');\" src=\"");
		jspWriter.write(themeDisplay.getPathThemeImages());
		jspWriter.write("/portlet/help.png\" />");
		jspWriter.write("<span class=\"aui-helper-hidden-accessible\">");
		jspWriter.write(LanguageUtil.get(pageContext, getMessage()));
		jspWriter.write("</span></span>");

		return EVAL_PAGE;
	}

	private static final String _PAGE = "/html/taglib/ui/icon_help/page.jsp";

}