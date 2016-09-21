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

import com.liferay.portal.kernel.servlet.taglib.BaseBodyTagSupport;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import com.liferay.util.PwdGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class PanelTag extends IncludeTag {

	public int doStartTag() throws JspException {
		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		if (Validator.isNull(_id)) {
			_id = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
		}

		BaseBodyTagSupport parentTag =
			(BaseBodyTagSupport)findAncestorWithClass(
				this, BaseBodyTagSupport.class);

		String parentId = StringPool.BLANK;

		try {
			PanelFloatingContainerTag panelFloatingContainerTag	=
				(PanelFloatingContainerTag)parentTag;

			parentId = panelFloatingContainerTag.getId();
		}
		catch (ClassCastException cce){
			try {
				PanelContainerTag panelContainerTag	=
					(PanelContainerTag)parentTag;

				parentId = panelContainerTag.getId();
			}
			catch (ClassCastException ccee) {
			}
		}

 		request.setAttribute("liferay-ui:panel:id", _id);
 		request.setAttribute("liferay-ui:panel:parentId", parentId);
 		request.setAttribute("liferay-ui:panel:title", _title);
		request.setAttribute(
			"liferay-ui:panel:collapsible", String.valueOf(_collapsible));
 		request.setAttribute("liferay-ui:panel:defaultState", _defaultState);
 		request.setAttribute(
			"liferay-ui:panel:persistState", String.valueOf(_persistState));
 		request.setAttribute(
			"liferay-ui:panel:extended", String.valueOf(_extended));
 		request.setAttribute("liferay-ui:panel:cssClass", _cssClass);

		super.doStartTag();

		return EVAL_BODY_INCLUDE;
	}

	protected String getStartPage() {
		if (Validator.isNull(_startPage)) {
			return _START_PAGE;
		}
		else {
			return _startPage;
		}
	}

	public void setStartPage(String startPage) {
		_startPage = startPage;
	}

	protected String getEndPage() {
		if (Validator.isNull(_endPage)) {
			return _END_PAGE;
		}
		else {
			return _endPage;
		}
	}

	public void setEndPage(String endPage) {
		_endPage = endPage;
	}

	public void setId(String id) {
		_id = id;
	}

 	public void setTitle(String title) {
		_title = title;
	}

	public void setCollapsible(boolean collapsible) {
		_collapsible = collapsible;
	}

 	public void setDefaultState(String defaultState) {
		_defaultState = defaultState;
	}

	public void setPersistState(boolean persistState) {
		_persistState = persistState;
	}

	public void setExtended(boolean extended) {
		_extended = extended;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	private static final String _START_PAGE = "/html/taglib/ui/panel/start.jsp";

	private static final String _END_PAGE = "/html/taglib/ui/panel/end.jsp";

	private String _startPage;
	private String _endPage;
 	private String _id;
 	private String _title;
	private boolean _collapsible = true;
 	private String _defaultState = "open";
	private boolean _persistState = true;
	private boolean _extended;
 	private String _cssClass = StringPool.BLANK;

}