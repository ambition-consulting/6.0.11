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

package com.liferay.portal.servlet.filters.gzip;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class GZipFilter extends BasePortalFilter {

	public static final String SKIP_FILTER =
		GZipFilter.class.getName() + "SKIP_FILTER";

	public GZipFilter() {

		// The compression filter will work on JBoss, Jetty, JOnAS, OC4J, and
		// Tomcat, but may break on other servers

		if (super.isFilterEnabled()) {
			if (ServerDetector.isJBoss() || ServerDetector.isJetty() ||
				ServerDetector.isJOnAS() || ServerDetector.isOC4J() ||
				ServerDetector.isTomcat()) {

				_filterEnabled = true;
			}
			else {
				_filterEnabled = false;
			}
		}
	}

	protected boolean isAlreadyFiltered(HttpServletRequest request) {
		if (request.getAttribute(SKIP_FILTER) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean isCompress(HttpServletRequest request) {
		if (ParamUtil.getBoolean(request, _COMPRESS, true)) {
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean isFilterEnabled() {
		return _filterEnabled;
	}

	protected boolean isInclude(HttpServletRequest request) {
		String uri = (String)request.getAttribute(
			JavaConstants.JAVAX_SERVLET_INCLUDE_REQUEST_URI);

		if (uri == null) {
			return false;
		}
		else {
			return true;
		}
	}

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		if (isCompress(request) && !isInclude(request) &&
			BrowserSnifferUtil.acceptsGzip(request) &&
			!isAlreadyFiltered(request)) {

			if (_log.isDebugEnabled()) {
				String completeURL = HttpUtil.getCompleteURL(request);

				_log.debug("Compressing " + completeURL);
			}

			request.setAttribute(SKIP_FILTER, Boolean.TRUE);

			GZipResponse gZipResponse = new GZipResponse(response);

			processFilter(GZipFilter.class, request, gZipResponse, filterChain);

			gZipResponse.finishResponse();
		}
		else {
			if (_log.isDebugEnabled()) {
				String completeURL = HttpUtil.getCompleteURL(request);

				_log.debug("Not compressing " + completeURL);
			}

			processFilter(
				GZipFilter.class, request, response, filterChain);
		}
	}

	private static final String _COMPRESS = "compress";

	private static Log _log = LogFactoryUtil.getLog(GZipFilter.class);

	private boolean _filterEnabled;

}