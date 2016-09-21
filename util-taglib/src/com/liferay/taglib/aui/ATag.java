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

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;

import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

/**
 * @author Julio Camarero
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class ATag extends IncludeTag {

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public void setHref(String href) {
		_href = href;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public void setLang(String lang) {
		_lang = lang;
	}

	public void setTarget(String target) {
		_target = target;
	}

	protected void cleanUp() {
		_cssClass = null;
		_href = null;
		_id = null;
		_label = null;
		_lang = null;
		_target = null;
	}

	protected String getEndPage() {
		return _END_PAGE;
	}

	protected String getStartPage() {
		return _START_PAGE;
	}

	protected int processEndTag() throws Exception {
		JspWriter jspWriter = pageContext.getOut();

		if (Validator.isNotNull(_href)) {
			if ((_target != null) &&
				(_target.equals("_blank") || _target.equals("_new"))) {

				jspWriter.write("<span class=\"opens-new-window-accessible\">");
				jspWriter.write(
					LanguageUtil.get(pageContext, "opens-new-window"));
				jspWriter.write("</span>");
			}

			jspWriter.write("</a>");
		}
		else {
			jspWriter.write("</span>");
		}

		return EVAL_PAGE;
	}

	protected int processStartTag() throws Exception {
		JspWriter jspWriter = pageContext.getOut();

		String namespace = _getNamespace();

		if (Validator.isNotNull(_href)) {
			jspWriter.write("<a ");

			if (Validator.isNotNull(_cssClass)) {
				jspWriter.write("class=\"");
				jspWriter.write(_cssClass);
				jspWriter.write("\" ");
			}

			jspWriter.write("href=\"");
			jspWriter.write(HtmlUtil.escape(_href));
			jspWriter.write("\" ");

			if (Validator.isNotNull(_id)) {
				jspWriter.write("id=\"");
				jspWriter.write(namespace);
				jspWriter.write(_id);
				jspWriter.write("\" ");
			}

			if (Validator.isNotNull(_lang)) {
				jspWriter.write("lang=\"");
				jspWriter.write(_lang);
				jspWriter.write("\" ");
			}

			if (Validator.isNotNull(_target)) {
				jspWriter.write("target=\"");
				jspWriter.write(_target);
				jspWriter.write("\" ");
			}

			writeDynamicAttributes(jspWriter);

			jspWriter.write(">");

			if (Validator.isNotNull(_label)) {
				jspWriter.write(LanguageUtil.get(pageContext, _label));
			}
		}
		else {
			jspWriter.write("<span ");

			if (Validator.isNotNull(_cssClass)) {
				jspWriter.write("class=\"");
				jspWriter.write(_cssClass);
				jspWriter.write("\" ");
			}

			if (Validator.isNotNull(_id)) {
				jspWriter.write("id=\"");
				jspWriter.write(namespace);
				jspWriter.write(_id);
				jspWriter.write("\" ");
			}

			if (Validator.isNotNull(_lang)) {
				jspWriter.write("lang=\"");
				jspWriter.write(_lang);
				jspWriter.write("\" ");
			}

			writeDynamicAttributes(jspWriter);

			jspWriter.write(">");
		}

		return EVAL_BODY_INCLUDE;
	}

	private String _getNamespace() {
		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		PortletResponse portletResponse = (PortletResponse)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		String namespace = StringPool.BLANK;

		boolean useNamespace = GetterUtil.getBoolean(
			(String)request.getAttribute("aui:form:useNamespace"), true);

		if ((portletResponse != null) && useNamespace) {
			namespace = portletResponse.getNamespace();
		}

		return namespace;
	}

	private static final String _END_PAGE =
		"/html/taglib/aui/a/end.jsp";

	private static final String _START_PAGE =
		"/html/taglib/aui/a/start.jsp";

	private String _cssClass;
	private String _href;
	private String _id;
	private String _label;
	private String _lang;
	private String _target;

}