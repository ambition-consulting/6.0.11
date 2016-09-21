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

package com.liferay.portal.theme;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class RequestVars {

	public RequestVars(
		HttpServletRequest request, ThemeDisplay themeDisplay,
		long ancestorPlid, long ancestorLayoutId) {

		_request = request;
		_themeDisplay = themeDisplay;
		_ancestorPlid = ancestorPlid;
		_ancestorLayoutId = ancestorLayoutId;
	}

	public HttpServletRequest getRequest() {
		return _request;
	}

	public ThemeDisplay getThemeDisplay() {
		return _themeDisplay;
	}

	public long getAncestorPlid() {
		return _ancestorPlid;
	}

	public long getAncestorLayoutId() {
		return _ancestorLayoutId;
	}

	private HttpServletRequest _request;
	private ThemeDisplay _themeDisplay;
	private long _ancestorPlid;
	private long _ancestorLayoutId;

}