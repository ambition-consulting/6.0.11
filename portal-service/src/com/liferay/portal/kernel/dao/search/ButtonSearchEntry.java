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

package com.liferay.portal.kernel.dao.search;

import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public class ButtonSearchEntry extends TextSearchEntry {

	public ButtonSearchEntry(
		String align, String valign, String name, String href) {

		this(align, valign, DEFAULT_COLSPAN, name, href);
	}

	public ButtonSearchEntry(
		String align, String valign, int colspan, String name, String href) {

		super(align, valign, colspan, name, href);
	}

	public void print(PageContext pageContext) throws Exception {
		StringBuilder sb = new StringBuilder();

		sb.append("<input type=\"button\" ");
		sb.append("value=\"");
		sb.append(getName());
		sb.append("\" onClick=\"");
		sb.append(getHref());
		sb.append("\">");

		pageContext.getOut().print(sb.toString());
	}

	public Object clone() {
		return new ButtonSearchEntry(
			getAlign(), getValign(), getColspan(), getName(), getHref());
	}

}