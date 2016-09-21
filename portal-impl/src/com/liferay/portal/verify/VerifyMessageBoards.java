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

package com.liferay.portal.verify;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class VerifyMessageBoards extends VerifyProcess {

	protected void doVerify() throws Exception {
		List<MBCategory> categories =
			MBCategoryLocalServiceUtil.getMBCategories(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Processing " + categories.size() +
					" categories for statistics accuracy");
		}

		for (MBCategory category : categories) {
			int threadCount = MBThreadLocalServiceUtil.getCategoryThreadsCount(
				category.getGroupId(), category.getCategoryId(),
				WorkflowConstants.STATUS_APPROVED);
			int messageCount =
				MBMessageLocalServiceUtil.getCategoryMessagesCount(
					category.getGroupId(), category.getCategoryId(),
					WorkflowConstants.STATUS_APPROVED);

			if ((category.getThreadCount() != threadCount) ||
				(category.getMessageCount() != messageCount)) {

				category.setThreadCount(threadCount);
				category.setMessageCount(messageCount);

				MBCategoryLocalServiceUtil.updateMBCategory(category);
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Statistics verified for categories");
		}

		List<MBThread> threads = MBThreadLocalServiceUtil.getMBThreads(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Processing " + threads.size() +
					" threads for statistics accuracy");
		}

		for (MBThread thread : threads) {
			int messageCount = MBMessageLocalServiceUtil.getThreadMessagesCount(
				thread.getThreadId(), WorkflowConstants.STATUS_APPROVED);

			if (thread.getMessageCount() != messageCount) {
				thread.setMessageCount(messageCount);

				MBThreadLocalServiceUtil.updateMBThread(thread);
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Statistics verified for threads");
		}

		List<MBMessage> messages =
			MBMessageLocalServiceUtil.getNoAssetMessages();

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Processing " + messages.size() + " messages with no asset");
		}

		for (MBMessage message : messages) {
			try {
				MBMessageLocalServiceUtil.updateAsset(
					message.getUserId(), message, null, null);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to update asset for message " +
							message.getMessageId() + ": " + e.getMessage());
				}
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Assets verified for messages");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VerifyMessageBoards.class);

}