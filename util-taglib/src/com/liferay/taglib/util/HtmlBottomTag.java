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

package com.liferay.taglib.util;

import com.liferay.portal.kernel.servlet.taglib.BaseBodyTagSupport;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.BodyTag;

/**
 * @author Brian Wing Shun Chan
 */
public class HtmlBottomTag extends BaseBodyTagSupport implements BodyTag {

	public int doStartTag() {
		return EVAL_BODY_BUFFERED;
	}

	public int doEndTag() {
		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		StringBundler sb = (StringBundler)request.getAttribute(
			WebKeys.PAGE_BOTTOM);

		if (sb == null) {
			sb = new StringBundler();

			request.setAttribute(WebKeys.PAGE_BOTTOM, sb);
		}

		sb.append(getBodyContentAsStringBundler());

		return EVAL_PAGE;
	}

}