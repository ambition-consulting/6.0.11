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

package com.liferay.portlet.polls.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.polls.service.PollsVoteServiceUtil;
import com.liferay.portlet.polls.util.PollsUtil;

import javax.portlet.ActionRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewQuestionAction extends EditQuestionAction {

	protected void updateQuestion(ActionRequest actionRequest)
		throws Exception {

		long questionId = ParamUtil.getLong(actionRequest, "questionId");
		long choiceId = ParamUtil.getLong(actionRequest, "choiceId");

		PollsVoteServiceUtil.addVote(
			questionId, choiceId, new ServiceContext());

		PollsUtil.saveVote(actionRequest, questionId);
	}

}