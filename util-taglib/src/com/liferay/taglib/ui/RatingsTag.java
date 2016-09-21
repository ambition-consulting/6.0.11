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

import com.liferay.portlet.ratings.model.RatingsEntry;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class RatingsTag extends IncludeTag {

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setNumberOfStars(int numberOfStars) {
		_numberOfStars = numberOfStars;
	}

	public void setRatingsEntry(RatingsEntry ratingsEntry) {
		_ratingsEntry = ratingsEntry;

		_setRatingsEntry = true;
	}

	public void setRatingsStats(RatingsStats ratingsStats) {
		_ratingsStats = ratingsStats;

		_setRatingsStats = true;
	}

	public void setType(String type) {
		_type = type;
	}

	public void setUrl(String url) {
		_url = url;
	}

	protected void cleanUp() {
		_className = null;
		_classPK = 0;
		_numberOfStars = 5;
		_ratingsEntry = null;
		_ratingsStats = null;
		_setRatingsEntry = false;
		_setRatingsStats = false;
		_type = "stars";
		_url = null;
	}

	protected String getPage() {
		return _PAGE;
	}

	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("liferay-ui:ratings:className", _className);
		request.setAttribute(
			"liferay-ui:ratings:classPK", String.valueOf(_classPK));
		request.setAttribute(
			"liferay-ui:ratings:numberOfStars", String.valueOf(_numberOfStars));
		request.setAttribute("liferay-ui:ratings:ratingsEntry", _ratingsEntry);
		request.setAttribute("liferay-ui:ratings:ratingsStats", _ratingsStats);
		request.setAttribute(
			"liferay-ui:ratings:setRatingsEntry",
			String.valueOf(_setRatingsEntry));
		request.setAttribute(
			"liferay-ui:ratings:setRatingsStats",
			String.valueOf(_setRatingsStats));
		request.setAttribute("liferay-ui:ratings:type", _type);
		request.setAttribute("liferay-ui:ratings:url", _url);
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _PAGE = "/html/taglib/ui/ratings/page.jsp";

	private String _className;
	private long _classPK;
	private int _numberOfStars = 5;
	private RatingsEntry _ratingsEntry;
	private RatingsStats _ratingsStats;
	private boolean _setRatingsEntry;
	private boolean _setRatingsStats;
	private String _type = "stars";
	private String _url;

}