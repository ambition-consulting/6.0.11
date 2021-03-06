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

package com.liferay.portal.servlet.filters.absoluteredirects;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.CookieKeys;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author Jorge Ferrer
 */
public class AbsoluteRedirectsResponse extends HttpServletResponseWrapper {

	public AbsoluteRedirectsResponse(
		HttpServletRequest request, HttpServletResponse response) {

		super(response);

		_request = request;
	}

	public void sendRedirect(String redirect) throws IOException {
		String portalURL = getPortalURL();

		if (Validator.isNotNull(portalURL) &&
			redirect.startsWith(StringPool.SLASH)) {

			redirect = portalURL + redirect;
		}

		if (!CookieKeys.hasSessionId(_request)) {
			redirect = PortalUtil.getURLWithSessionId(
				redirect, _request.getSession().getId());
		}

		_request.setAttribute(
			AbsoluteRedirectsResponse.class.getName(), redirect);

		super.sendRedirect(redirect);
	}

	protected String getPortalURL() {
		return PortalUtil.getPortalURL(_request);
	}

	private HttpServletRequest _request;

}