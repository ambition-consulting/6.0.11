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

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchPaginatorTag<R> extends SearchFormTag<R> {

	public void setType(String type) {
		_type = type;
	}

	protected void cleanUp() {
		super.cleanUp();

		_type = "regular";
	}

	protected String getPage() {
		return _PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		super.setAttributes(request);

		request.setAttribute("liferay-ui:search:type", _type);
	}

	private static final String _PAGE =
		"/html/taglib/ui/search_paginator/page.jsp";

	private String _type = "regular";

}