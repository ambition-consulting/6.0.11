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

/**
 * @author Julio Camarero
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 */
public class LegendTag extends IncludeTag {

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("aui:legend:cssClass", _cssClass);
		request.setAttribute(
			"aui:legend:dynamicAttributes", getDynamicAttributes());
		request.setAttribute("aui:legend:label", _label);
	}

	protected void cleanUp() {
		_cssClass = null;
		_label = null;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public void setLabel(String label) {
		_label = label;
	}

	protected String getPage() {
		return _PAGE;
	}

	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _PAGE = "/html/taglib/aui/legend/page.jsp";

	private String _cssClass;
	private String _label;

}