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

package com.liferay.taglib.aui;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

/**
 * @author Julio Camarero
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 */
public class OptionTag extends IncludeTag {

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public void setLabel(Object label) {
		_label = String.valueOf(label);
	}

	public void setSelected(boolean selected) {
		_selected = selected;
	}

	public void setStyle(String style) {
		_style = style;
	}

	public void setValue(Object value) {
		_value = String.valueOf(value);
	}

	protected void cleanUp() {
		_cssClass = null;
		_label = null;
		_selected = false;
		_style = null;
		_value = null;
	}

	protected String getEndPage() {
		return _END_PAGE;
	}

	protected String getStartPage() {
		return _START_PAGE;
	}

	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	protected int processEndTag() throws Exception {
		JspWriter jspWriter = pageContext.getOut();

		jspWriter.write("</option>");

		return EVAL_PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		String value = _value;

		if (value == null) {
			value = _label;
		}

		request.setAttribute("aui:option:cssClass", _cssClass);
		request.setAttribute(
			"aui:option:dynamicAttributes", getDynamicAttributes());
		request.setAttribute("aui:option:label", _label);
		request.setAttribute(
			"aui:option:selected", String.valueOf(_selected));
		request.setAttribute("aui:option:style", _style);
		request.setAttribute("aui:option:value", value);
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _END_PAGE = "/html/taglib/aui/option/end.jsp";

	private static final String _START_PAGE =
		"/html/taglib/aui/option/start.jsp";

	private String _cssClass;
	private String _label;
	private boolean _selected;
	private String _style;
	private String _value;

}