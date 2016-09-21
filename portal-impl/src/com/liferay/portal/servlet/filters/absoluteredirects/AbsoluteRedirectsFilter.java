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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * This filter is used to ensure that all redirects are absolute. It should not
 * be disabled because it also sets the company id in the request so that
 * subsequent calls in the thread have the company id properly set. This filter
 * should also always be the first filter in the list of filters.
 * </p>
 *
 * @author Minhchau Dang
 */
public class AbsoluteRedirectsFilter extends BasePortalFilter {

	protected boolean isFilterEnabled() {
		return true;
	}

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		request.setCharacterEncoding(StringPool.UTF8);
		//response.setContentType(ContentTypes.TEXT_HTML_UTF8);

		// Make sure all redirects issued by the portal are absolute

		response = new AbsoluteRedirectsResponse(request, response);

		// Company id needs to always be called here so that it's properly set
		// in subsequent calls

		long companyId = PortalInstances.getCompanyId(request);

		if (_log.isDebugEnabled()) {
			_log.debug("Company id " + companyId);
		}

		PortalUtil.getCurrentCompleteURL(request);
		PortalUtil.getCurrentURL(request);

		HttpSession session = request.getSession();

		Boolean httpsInitial = (Boolean)session.getAttribute(
			WebKeys.HTTPS_INITIAL);

		if (httpsInitial == null) {
			httpsInitial = Boolean.valueOf(request.isSecure());

			session.setAttribute(WebKeys.HTTPS_INITIAL, httpsInitial);

			if (_log.isDebugEnabled()) {
				_log.debug("Setting httpsInitial to " + httpsInitial);
			}
		}

		processFilter(
			AbsoluteRedirectsFilter.class, request, response, filterChain);
	}

	private static Log _log = LogFactoryUtil.getLog(
		AbsoluteRedirectsFilter.class);

}