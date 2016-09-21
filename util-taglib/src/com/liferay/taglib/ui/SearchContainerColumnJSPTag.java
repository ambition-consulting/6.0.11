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
import com.liferay.portal.kernel.servlet.PipingServletResponse;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StringPool;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

/**
 * @author Raymond Augé
 */
public class SearchContainerColumnJSPTag<R> extends SearchContainerColumnTag {

	public int doEndTag() {
		try {
			SearchContainerRowTag<R> parentTag =
				(SearchContainerRowTag<R>)findAncestorWithClass(
					this, SearchContainerRowTag.class);

			ResultRow row = parentTag.getRow();

			if (index <= -1) {
				index = row.getEntries().size();
			}

			row.addJSP(
				index, getAlign(), getValign(), getColspan(), getPath(),
				pageContext.getServletContext(), getServletRequest(),
				new PipingServletResponse(pageContext));

			return EVAL_PAGE;
		}
		finally {
			index = -1;

			if (!ServerDetector.isResin()) {
				align = SearchEntry.DEFAULT_ALIGN;
				colspan = SearchEntry.DEFAULT_COLSPAN;
				name = StringPool.BLANK;
				_path = null;
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

			headerNames.add(name);
		}

		return EVAL_BODY_INCLUDE;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	private String _path;

}