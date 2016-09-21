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

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public class TextSearchEntry extends SearchEntry {

	public TextSearchEntry(String align, String valign, String name) {
		this(align, valign, DEFAULT_COLSPAN, name, null);
	}

	public TextSearchEntry(
		String align, String valign, int colspan, String name) {

		this(align, valign, colspan, name, null);
	}

	public TextSearchEntry(
		String align, String valign, String name, String href) {

		this(align, valign, DEFAULT_COLSPAN, name, href, null, null);
	}

	public TextSearchEntry(
		String align, String valign, int colspan, String name, String href) {

		this(align, valign, colspan, name, href, null, null);
	}

	public TextSearchEntry(
		String align, String valign, String name, String href, String target,
		String title) {

		this(align, valign, DEFAULT_COLSPAN, name, href, target, title);
	}

	public TextSearchEntry(
		String align, String valign, int colspan, String name, String href,
		String target, String title) {

		super(align, valign, colspan);

		_name = name;
		_href = href;
		_target = target;
		_title = title;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getHref() {
		return _href;
	}

	public void setHref(String href) {
		_href = href;
	}

	public String getTarget() {
		return _target;
	}

	public void setTarget(String target) {
		_target = target;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void print(PageContext pageContext) throws Exception {
		if (_href == null) {
			pageContext.getOut().print(_name);
		}
		else {
			StringBundler sb = new StringBundler();

			sb.append("<a href=\"");
			sb.append(HtmlUtil.escape(_href));
			sb.append("\"");

			if (Validator.isNotNull(_target)) {
				sb.append(" target=\"");
				sb.append(_target);
				sb.append("\"");
			}

			if (Validator.isNotNull(_title)) {
				sb.append(" title=\"");
				sb.append(_title);
				sb.append("\"");
			}

			sb.append(">");
			sb.append(_name);
			sb.append("</a>");

			JspWriter jspWriter = pageContext.getOut();

			jspWriter.print(sb.toString());
		}
	}

	public Object clone() {
		return new TextSearchEntry(
			getAlign(), getValign(), getColspan(), getName(), getHref(),
			getTarget(), getTitle());
	}

	private String _name;
	private String _href;
	private String _target;
	private String _title;

}