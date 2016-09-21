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
public class ScoreSearchEntry extends SearchEntry {

	public ScoreSearchEntry(float score) {
		_score = score;
	}

	public float getScore() {
		return _score;
	}

	public void setScore(float score) {
		_score = score;
	}

	public void print(PageContext pageContext) throws Exception {
		pageContext.include("/html/taglib/ui/search_iterator/score.jsp");
	}

	public Object clone() {
		return new ScoreSearchEntry(getScore());
	}

	private float _score;

}