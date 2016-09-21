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

package com.liferay.portlet.myaccount.action;

import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.pwd.PwdAuthenticator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.RenderRequestImpl;
import com.liferay.util.servlet.DynamicServletRequest;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class EditUserAction
	extends com.liferay.portlet.enterpriseadmin.action.EditUserAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		if (redirectToLogin(actionRequest, actionResponse)) {
			return;
		}

		super.processAction(
			mapping, form, portletConfig, actionRequest, actionResponse);
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		User user = PortalUtil.getUser(renderRequest);

		RenderRequestImpl renderRequestImpl = (RenderRequestImpl)renderRequest;

		DynamicServletRequest dynamicRequest =
			(DynamicServletRequest)renderRequestImpl.getHttpServletRequest();

		dynamicRequest.setParameter(
			"p_u_i_d", String.valueOf(user.getUserId()));

		return super.render(
			mapping, form, portletConfig, renderRequest, renderResponse);
	}

	protected Object[] updateUser(ActionRequest actionRequest)
		throws Exception {

		String newPassword = ParamUtil.getString(actionRequest, "password1");

		if (Validator.isNotNull(newPassword)) {
			String requestPassword = ParamUtil.getString(
				actionRequest, "password0");

			Company company = PortalUtil.getCompany(actionRequest);

			String authType = company.getAuthType();

			User user = PortalUtil.getSelectedUser(actionRequest);

			String login = null;

			if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
				login = user.getEmailAddress();
			}
			if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
				login = String.valueOf(user.getUserId());
			}
			if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
				login = user.getScreenName();
			}

			boolean validPassword = PwdAuthenticator.authenticate(
				login, requestPassword, user.getPassword());

			if (!validPassword) {
				throw new UserPasswordException(
					UserPasswordException.PASSWORD_INVALID);
			}
		}

		return super.updateUser(actionRequest);
	}

}