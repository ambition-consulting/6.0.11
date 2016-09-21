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

package com.liferay.taglib.theme;

import com.liferay.portal.kernel.servlet.PipingServletResponse;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Theme;
import com.liferay.taglib.util.ThemeUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class IncludeTag extends com.liferay.taglib.util.IncludeTag {

	protected void include(String page) throws Exception {
		ServletContext servletContext = getServletContext();
		HttpServletRequest request = getServletRequest();

		Theme theme = (Theme)request.getAttribute(WebKeys.THEME);

		ThemeUtil.insertTilesVariables(request);

		ThemeUtil.include(
			servletContext, request, new PipingServletResponse(pageContext),
			pageContext, page, theme);
	}

}