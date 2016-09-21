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

package com.liferay.portal.servlet.filters.sessionid;

import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * http://forum.java.sun.com/thread.jspa?threadID=197150.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class SessionIdFilter extends BasePortalFilter {

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		SessionIdServletRequest sessionIdRequest = new SessionIdServletRequest(
			request, response);

		processFilter(
			SessionIdFilter.class, sessionIdRequest, response, filterChain);
	}

}