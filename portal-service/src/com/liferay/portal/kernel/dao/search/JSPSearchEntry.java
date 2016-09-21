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

import com.liferay.portal.kernel.servlet.PipingServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public class JSPSearchEntry extends SearchEntry {

	public JSPSearchEntry(String align, String valign, String path) {
		this(align, valign, DEFAULT_COLSPAN, path, null, null, null);
	}

	public JSPSearchEntry(
		String align, String valign, int colspan, String path) {

		this(align, valign, colspan, path, null, null, null);
	}

	public JSPSearchEntry(
		String align, String valign, int colspan, String path,
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		super(align, valign, colspan);

		_path = path;
		_servletContext = servletContext;
		_request = request;
		_response = response;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public void print(PageContext pageContext) throws Exception {
		if (_servletContext != null) {
			RequestDispatcher requestDispatcher =
				_servletContext.getRequestDispatcher(_path);

			requestDispatcher.include(
				_request, new PipingServletResponse(pageContext));
		}
		else {
			pageContext.include(_path);
		}
	}

	public Object clone() {
		return new JSPSearchEntry(
			getAlign(), getValign(), getColspan(), getPath(), _servletContext,
			_request, _response);
	}

	private String _path;
	private ServletContext _servletContext;
	private HttpServletRequest _request;
	private HttpServletResponse _response;

}