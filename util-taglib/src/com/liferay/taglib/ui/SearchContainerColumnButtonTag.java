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
import com.liferay.portal.kernel.dao.search.SearchEntry;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

/**
 * @author Raymond Augé
 */
public class SearchContainerColumnButtonTag<R>
	extends SearchContainerColumnTag {

	public int doEndTag() {
		try {
			SearchContainerRowTag<R> parentTag =
				(SearchContainerRowTag<R>)findAncestorWithClass(
					this, SearchContainerRowTag.class);

			ResultRow row = parentTag.getRow();

			if (index <= -1) {
				index = row.getEntries().size();
			}

			row.addButton(
				index, getAlign(), getValign(), getColspan(), getName(),
				(String)getHref());

			return EVAL_PAGE;
		}
		finally {
			index = -1;

			if (!ServerDetector.isResin()) {
				align = SearchEntry.DEFAULT_ALIGN;
				colspan = SearchEntry.DEFAULT_COLSPAN;
				_href = null;
				name = StringPool.BLANK;
				valign = SearchEntry.DEFAULT_VALIGN;
			}
		}
	}

	public int doStartTag() throws JspException {
		SearchContainerRowTag<R> parentRowTag =
			(SearchContainerRowTag<R>)findAncestorWithClass(
				this, SearchContainerRowTag.class);

		if (parentRowTag == null) {
			throw new JspTagException(
				"Requires liferay-ui:search-container-row");
		}

		if (!parentRowTag.isHeaderNamesAssigned()) {
			List<String> headerNames = parentRowTag.getHeaderNames();

			headerNames.add(StringPool.BLANK);
		}

		return EVAL_BODY_INCLUDE;
	}

	public Object getHref() {
		if (Validator.isNotNull(_href) && (_href instanceof PortletURL)) {
			_href = _href.toString();
		}

		return _href;
	}

	public void setHref(Object href) {
		_href = href;
	}

	private Object _href;

}