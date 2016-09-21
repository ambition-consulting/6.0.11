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

package com.liferay.portlet.pollsdisplay.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.polls.NoSuchQuestionException;
import com.liferay.portlet.polls.service.PollsQuestionServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurationActionImpl extends BaseConfigurationAction {

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (!cmd.equals(Constants.UPDATE)) {
				return;
			}

			long questionId = ParamUtil.getLong(actionRequest, "questionId");

			PollsQuestionServiceUtil.getQuestion(questionId);

			String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");

			PortletPreferences preferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					actionRequest, portletResource);

			preferences.setValue("question-id", String.valueOf(questionId));

			preferences.store();

			SessionMessages.add(
				actionRequest, portletConfig.getPortletName() + ".doConfigure");
		}
		catch (NoSuchQuestionException nsqe) {
			SessionErrors.add(actionRequest, nsqe.getClass().getName());
		}
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/polls_display/configuration.jsp";
	}

}