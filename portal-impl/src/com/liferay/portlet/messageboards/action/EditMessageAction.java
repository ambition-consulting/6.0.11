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

package com.liferay.portlet.messageboards.action;

import com.liferay.documentlibrary.FileNameException;
import com.liferay.documentlibrary.FileSizeException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.ActionResponseImpl;
import com.liferay.portlet.asset.AssetTagException;
import com.liferay.portlet.messageboards.LockedThreadException;
import com.liferay.portlet.messageboards.MessageBodyException;
import com.liferay.portlet.messageboards.MessageSubjectException;
import com.liferay.portlet.messageboards.NoSuchMessageException;
import com.liferay.portlet.messageboards.RequiredMessageException;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageFlagLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;
import com.liferay.portlet.messageboards.service.permission.MBMessagePermission;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class EditMessageAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			MBMessage message = null;

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				message = updateMessage(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteMessage(actionRequest);
			}
			else if (cmd.equals(Constants.LOCK)) {
				lockThread(actionRequest);
			}
			else if (cmd.equals(Constants.SUBSCRIBE)) {
				subscribeMessage(actionRequest);
			}
			else if (cmd.equals(Constants.UNLOCK)) {
				unlockThread(actionRequest);
			}
			else if (cmd.equals(Constants.UNSUBSCRIBE)) {
				unsubscribeMessage(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				int workflowAction = ParamUtil.getInteger(
					actionRequest, "workflowAction",
					WorkflowConstants.ACTION_PUBLISH);

				if ((message != null) &&
					(workflowAction == WorkflowConstants.ACTION_SAVE_DRAFT)) {

					redirect = getSaveAndContinueRedirect(
						actionRequest, actionResponse, message);
				}

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchMessageException ||
				e instanceof PrincipalException ||
				e instanceof RequiredMessageException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.message_boards.error");
			}
			else if (e instanceof CaptchaTextException ||
					 e instanceof FileNameException ||
					 e instanceof FileSizeException ||
					 e instanceof LockedThreadException ||
					 e instanceof MessageBodyException ||
					 e instanceof MessageSubjectException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else if (e instanceof AssetTagException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getMessage(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchMessageException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.message_boards.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(
			getForward(renderRequest, "portlet.message_boards.edit_message"));
	}

	protected void deleteMessage(ActionRequest actionRequest) throws Exception {
		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.deleteMessage(messageId);
	}

	protected String getSaveAndContinueRedirect(
		ActionRequest actionRequest, ActionResponse actionResponse,
		MBMessage message) {

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		boolean preview = ParamUtil.getBoolean(actionRequest, "preview");

		PortletURL portletURL =
			((ActionResponseImpl)actionResponse).createRenderURL();

		portletURL.setParameter(
			"struts_action", "/message_boards/edit_message");
		portletURL.setParameter("redirect", redirect);
		portletURL.setParameter(
			"messageId", String.valueOf(message.getMessageId()));
		portletURL.setParameter("preview", String.valueOf(preview));

		return portletURL.toString();
	}

	protected void lockThread(ActionRequest actionRequest) throws Exception {
		long threadId = ParamUtil.getLong(actionRequest, "threadId");

		MBThreadServiceUtil.lockThread(threadId);
	}

	protected void subscribeMessage(ActionRequest actionRequest)
		throws Exception {

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.subscribeMessage(messageId);
	}

	protected void unlockThread(ActionRequest actionRequest) throws Exception {
		long threadId = ParamUtil.getLong(actionRequest, "threadId");

		MBThreadServiceUtil.unlockThread(threadId);
	}

	protected void unsubscribeMessage(ActionRequest actionRequest)
		throws Exception {

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.unsubscribeMessage(messageId);
	}

	protected MBMessage updateMessage(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		long groupId = themeDisplay.getScopeGroupId();
		long categoryId = ParamUtil.getLong(actionRequest, "mbCategoryId");
		long threadId = ParamUtil.getLong(actionRequest, "threadId");
		long parentMessageId = ParamUtil.getLong(
			actionRequest, "parentMessageId");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");
		boolean attachments = ParamUtil.getBoolean(
			actionRequest, "attachments");

		List<ObjectValuePair<String, byte[]>> files =
			new ArrayList<ObjectValuePair<String, byte[]>>();

		if (attachments) {
			UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			for (int i = 1; i <= 5; i++) {
				File file = uploadRequest.getFile("msgFile" + i);
				String fileName = uploadRequest.getFileName("msgFile" + i);
				byte[] bytes = FileUtil.getBytes(file);

				if ((bytes != null) && (bytes.length > 0)) {
					ObjectValuePair<String, byte[]> ovp =
						new ObjectValuePair<String, byte[]>(fileName, bytes);

					files.add(ovp);
				}
			}
		}

		boolean question = ParamUtil.getBoolean(actionRequest, "question");
		boolean anonymous = ParamUtil.getBoolean(actionRequest, "anonymous");
		double priority = ParamUtil.getDouble(actionRequest, "priority");
		boolean allowPingbacks = ParamUtil.getBoolean(
			actionRequest, "allowPingbacks");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MBMessage.class.getName(), actionRequest);

		MBMessage message = null;

		if (messageId <= 0) {
			if (PropsValues.CAPTCHA_CHECK_PORTLET_MESSAGE_BOARDS_EDIT_MESSAGE) {
				CaptchaUtil.check(actionRequest);
			}

			if (threadId <= 0) {

				// Post new thread

				message = MBMessageServiceUtil.addMessage(
					groupId, categoryId, subject, body, files, anonymous,
					priority, allowPingbacks, serviceContext);

				if (question) {
					MBMessageFlagLocalServiceUtil.addQuestionFlag(
						message.getMessageId());
				}
			}
			else {

				// Post reply

				message = MBMessageServiceUtil.addMessage(
					groupId, categoryId, threadId, parentMessageId, subject,
					body, files, anonymous, priority, allowPingbacks,
					serviceContext);
			}
		}
		else {
			List<String> existingFiles = new ArrayList<String>();

			for (int i = 1; i <= 5; i++) {
				String path = ParamUtil.getString(
					actionRequest, "existingPath" + i);

				if (Validator.isNotNull(path)) {
					existingFiles.add(path);
				}
			}

			// Update message

			message = MBMessageServiceUtil.updateMessage(
				messageId, subject, body, files, existingFiles, priority,
				allowPingbacks, serviceContext);

			if (message.isRoot()) {
				if (question) {
					MBMessageFlagLocalServiceUtil.addQuestionFlag(messageId);
				}
				else {
					MBMessageFlagLocalServiceUtil.deleteQuestionAndAnswerFlags(
						message.getThreadId());
				}
			}
		}

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		boolean subscribe = ParamUtil.getBoolean(
			actionRequest, "subscribe");

		if (subscribe &&
			MBMessagePermission.contains(
				permissionChecker, message,	ActionKeys.SUBSCRIBE)) {

			MBMessageServiceUtil.subscribeMessage(message.getMessageId());
		}

		return message;
	}

}