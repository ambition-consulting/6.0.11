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
import com.liferay.portal.kernel.util.ServerDetector;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

/**
 * @author Raymond Augé
 */
public class SearchContainerColumnScoreTag<R> extends SearchContainerColumnTag {

	private static final String DEFAULT_NAME = "score";

	public int doEndTag() {
		try {
			SearchContainerRowTag<R> parentTag =
				(SearchContainerRowTag<R>)findAncestorWithClass(
					this, SearchContainerRowTag.class);

			ResultRow row = parentTag.getRow();

			if (index <= -1) {
				index = row.getEntries().size();
			}

			row.addScore(index, getScore());

			return EVAL_PAGE;
		}
		finally {
			index = -1;

			if (!ServerDetector.isResin()) {
				_name = DEFAULT_NAME;
				_score = 0;
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

			headerNames.add(_name);
		}

		return EVAL_BODY_INCLUDE;
	}

	public float getScore() {
		return _score;
	}

	public void setScore(float score) {
		_score = score;
	}

	private String _name = DEFAULT_NAME;
	private float _score;

}