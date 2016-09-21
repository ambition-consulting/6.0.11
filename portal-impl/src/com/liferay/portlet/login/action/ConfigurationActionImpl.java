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

package com.liferay.portlet.login.action;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class ConfigurationActionImpl extends BaseConfigurationAction {

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		String tabs1 = ParamUtil.getString(actionRequest, "tabs1");

		if (tabs1.equals("general")) {
			updateGeneral(actionRequest, preferences);
		}
		else if (tabs1.equals("email-notifications")) {
			updateEmailNotifications(actionRequest, preferences);
		}

		SessionMessages.add(
			actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/login/configuration.jsp";
	}

	protected void updateEmailNotifications(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		String tabs2 = ParamUtil.getString(actionRequest, "tabs2");

		if (tabs2.equals("password-changed-notification") ||
			tabs2.equals("password-reset-notification")) {

			String languageId = LanguageUtil.getLanguageId(actionRequest);

			String emailParam = "emailPasswordSent";

			if (tabs2.equals("password-reset-notification")) {
				emailParam = "emailPasswordReset";
			}

			String emailSubject = ParamUtil.getString(
				actionRequest, emailParam + "Subject_" + languageId);
			String emailBody = ParamUtil.getString(
				actionRequest, emailParam + "Body_" + languageId);

			preferences.setValue(
				emailParam + "Subject_" + languageId, emailSubject);
			preferences.setValue(emailParam + "Body_" + languageId, emailBody);

			preferences.store();
		}
		else {
			String emailFromName = ParamUtil.getString(
				actionRequest, "emailFromName");
			String emailFromAddress = ParamUtil.getString(
				actionRequest, "emailFromAddress");

			preferences.setValue("emailFromName", emailFromName);

			if (Validator.isNotNull(emailFromAddress) &&
				!Validator.isEmailAddress(emailFromAddress)) {

				SessionErrors.add(actionRequest, "emailFromAddress");
			}
			else {
				preferences.setValue("emailFromName", emailFromName);
				preferences.setValue("emailFromAddress", emailFromAddress);

				preferences.store();
			}
		}
	}

	protected void updateGeneral(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		String authType = ParamUtil.getString(actionRequest, "authType");

		preferences.setValue("authType", authType);

		preferences.store();
	}

}