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

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.util.Encryptor;
import com.liferay.util.PwdGenerator;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Amos Fong
 */
public class SessionAuthToken implements AuthToken {

	public void check(HttpServletRequest request) throws PrincipalException {
		if (isIgnoreAction(request) || isIgnorePortlet(request)) {
			return;
		}

		String requestAuthenticationToken = ParamUtil.getString(
			request, "p_auth");

		String sessionAuthenticationToken = getSessionAuthenticationToken(
			request, _PORTAL);

		String propertiesAuthenticatonTokenSharedSecret = Encryptor.digest(
			PropsValues.AUTH_TOKEN_SHARED_SECRET);

		String requestAuthenticatonTokenSharedSecret = ParamUtil.getString(
			request, "p_auth_secret");

		if (!requestAuthenticationToken.equals(sessionAuthenticationToken) &&
			!requestAuthenticatonTokenSharedSecret.equals(
				propertiesAuthenticatonTokenSharedSecret)) {

			throw new PrincipalException("Invalid authentication token");
		}
	}

	public String getToken(HttpServletRequest request) {
		return getSessionAuthenticationToken(request, _PORTAL);
	}

	public String getToken(
		HttpServletRequest request, long plid, String portletId) {

		return getSessionAuthenticationToken(
			request, PortletPermissionUtil.getPrimaryKey(plid, portletId));
	}

	protected String getSessionAuthenticationToken(
		HttpServletRequest request, String key) {

		Map<String, String> sessionAuthenticationTokensMap =
			getSessionAuthenticationTokensMap(request);

		String sessionAuthenticationToken = sessionAuthenticationTokensMap.get(
			key);

		if (Validator.isNull(sessionAuthenticationToken)) {
			sessionAuthenticationToken = PwdGenerator.getPassword();

			sessionAuthenticationTokensMap.put(key, sessionAuthenticationToken);
		}

		return sessionAuthenticationToken;
	}

	protected Map<String, String> getSessionAuthenticationTokensMap(
		HttpServletRequest request) {

		HttpSession session = request.getSession();

		Map<String, String> sessionAuthenticationTokensMap =
			(Map<String, String>)session.getAttribute(
				WebKeys.AUTHENTICATION_TOKEN);

		if (sessionAuthenticationTokensMap == null) {
			sessionAuthenticationTokensMap =
				new ConcurrentHashMap<String, String>();

			session.setAttribute(
				WebKeys.AUTHENTICATION_TOKEN, sessionAuthenticationTokensMap);
		}

		return sessionAuthenticationTokensMap;
	}

	protected boolean isIgnoreAction(HttpServletRequest request) {
		String ppid = ParamUtil.getString(request, "p_p_id");

		String portletNamespace = PortalUtil.getPortletNamespace(ppid);

		String strutsAction = ParamUtil.getString(
			request, portletNamespace + "struts_action");

		return isIgnoreAction(strutsAction);
	}

	protected boolean isIgnoreAction(String strutsAction) {
		Set<String> authTokenIgnoreActions =
			PortalUtil.getAuthTokenIgnoreActions();

		return authTokenIgnoreActions.contains(strutsAction);
	}

	protected boolean isIgnorePortlet(HttpServletRequest request) {
		String ppid = ParamUtil.getString(request, "p_p_id");

		return isIgnorePortlet(ppid);
	}

	protected boolean isIgnorePortlet(String portletId) {
		String rootPortletId = PortletConstants.getRootPortletId(portletId);

		Set<String> authTokenIgnorePortlets =
			PortalUtil.getAuthTokenIgnorePortlets();

		return authTokenIgnorePortlets.contains(rootPortletId);
	}

	private static final String _PORTAL = "PORTAL";

}