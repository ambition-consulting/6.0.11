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

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchContainerRowParameterTag<R> extends TagSupport {

	public int doStartTag() throws JspException {
		SearchContainerRowTag<R> parentRowTag =
			(SearchContainerRowTag<R>)findAncestorWithClass(
				this, SearchContainerRowTag.class);

		if (parentRowTag == null) {
			throw new JspTagException(
				"Requires liferay-ui:search-container-row");
		}

		ResultRow row = parentRowTag.getRow();

		if (_name.equals("className")) {
			row.setClassName(_name);
		}
		else if (_name.equals("classHoverName")) {
			row.setClassHoverName((String)_value);
		}
		else if (_name.equals("restricted")) {
			row.setRestricted(GetterUtil.getBoolean((String)_value, false));
		}
		else {
			row.setParameter(_name, _value);
		}

		return EVAL_BODY_INCLUDE;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setValue(Object value) {
		_value = value;
	}

	private String _name;
	private Object _value;

}