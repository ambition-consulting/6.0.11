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

package com.liferay.portal.action;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.ActionConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.login.util.LoginUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 * @author Mika Koivisto
 */
public class UpdatePasswordAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Ticket ticket = getTicket(request);

		if (!themeDisplay.isSignedIn() && (ticket == null)) {
			return mapping.findForward(ActionConstants.COMMON_REFERER);
		}

		String cmd = ParamUtil.getString(request, Constants.CMD);

		if (Validator.isNull(cmd)) {
			return mapping.findForward("portal.update_password");
		}

		try {
			updatePassword(request, response, themeDisplay, ticket);

			PortletURL portletURL = new PortletURLImpl(
				request, PortletKeys.LOGIN, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);

			response.sendRedirect(portletURL.toString());

			return null;
		}
		catch (Exception e) {
			if (e instanceof UserPasswordException) {
				SessionErrors.add(request, e.getClass().getName(), e);

				return mapping.findForward("portal.update_password");
			}
			else if (e instanceof NoSuchUserException ||
					 e instanceof PrincipalException) {

				SessionErrors.add(request, e.getClass().getName());

				return mapping.findForward("portal.error");
			}
			else {
				PortalUtil.sendError(e, request, response);

				return null;
			}
		}
	}

	protected Ticket getTicket(HttpServletRequest request) {
		String token = ParamUtil.getString(request, "ticket");

		if (Validator.isNull(token)) {
			return null;
		}

		try {
			Ticket ticket = TicketLocalServiceUtil.getTicket(token);

			if (!ticket.isExpired()) {
				return ticket;
			}
			else {
				TicketLocalServiceUtil.deleteTicket(ticket);
			}
		}
		catch (Exception e) {
		}

		return null;
	}

	protected void updatePassword(
			HttpServletRequest request, HttpServletResponse response,
			ThemeDisplay themeDisplay, Ticket ticket)
		throws Exception {

		AuthTokenUtil.check(request);

		long userId = 0;

		if (ticket != null) {
			userId = ticket.getClassPK();
		}
		else {
			userId = themeDisplay.getUserId();
		}

		String password1 = ParamUtil.getString(request, "password1");
		String password2 = ParamUtil.getString(request, "password2");
		boolean passwordReset = false;

		UserLocalServiceUtil.updatePassword(
			userId, password1, password2, passwordReset);

		if (ticket != null) {
			TicketLocalServiceUtil.deleteTicket(ticket);

			User user = UserLocalServiceUtil.getUser(userId);

			Company company = CompanyLocalServiceUtil.getCompanyById(
				user.getCompanyId());

			String login = null;

			String authType = company.getAuthType();

			if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
				login = user.getEmailAddress();
			}
			else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
				login = user.getScreenName();
			}
			else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
				login = String.valueOf(userId);
			}

			LoginUtil.login(request, response, login, password1, false, null);
		}
		else if (PropsValues.SESSION_STORE_PASSWORD) {
			HttpSession session = request.getSession();

			session.setAttribute(WebKeys.USER_PASSWORD, password1);
		}
	}

}