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
public class ColumnTag extends IncludeTag {

	public void setColumnWidth(int columnWidth) {
		_columnWidth = columnWidth;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public void setFirst(boolean first) {
		_first = first;
	}

	public void setLast(boolean last) {
		_last = last;
	}

	protected void cleanUp() {
		_columnWidth = 0;
		_cssClass = null;
		_first = false;
		_last = false;
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

		jspWriter.write("</div></div>");

		return EVAL_PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"aui:column:columnWidth", String.valueOf(_columnWidth));
		request.setAttribute("aui:column:cssClass", _cssClass);
		request.setAttribute(
			"aui:column:dynamicAttributes", getDynamicAttributes());
		request.setAttribute("aui:column:first", String.valueOf(_first));
		request.setAttribute("aui:column:last", String.valueOf(_last));
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _END_PAGE =
		"/html/taglib/aui/column/end.jsp";

	private static final String _START_PAGE =
		"/html/taglib/aui/column/start.jsp";

	private int _columnWidth;
	private String _cssClass;
	private boolean _first;
	private boolean _last;

}