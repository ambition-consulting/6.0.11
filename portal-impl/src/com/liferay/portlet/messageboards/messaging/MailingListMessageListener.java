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

package com.liferay.portlet.messageboards.messaging;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.Account;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionCheckerUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.messageboards.NoSuchMessageException;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.portlet.messageboards.util.MBMailMessage;
import com.liferay.portlet.messageboards.util.MBUtil;
import com.liferay.portlet.messageboards.util.MailingListThreadLocal;
import com.liferay.util.mail.MailEngine;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;

/**
 * @author Thiago Moreira
 */
public class MailingListMessageListener extends BaseMessageListener {

	protected void doReceive(
			com.liferay.portal.kernel.messaging.Message message)
		throws Exception {

		MailingListRequest mailingListRequest =
			(MailingListRequest)message.getPayload();

		Store store = null;

		Folder folder = null;

		Message[] messages = null;

		try {
			store = getStore(mailingListRequest);

			store.connect();

			folder = getFolder(store);

			messages = folder.getMessages();

			processMessages(mailingListRequest, messages);
		}
		finally {
			if ((folder != null) && folder.isOpen()) {
				try {
					folder.setFlags(
						messages, new Flags(Flags.Flag.DELETED), true);
				}
				catch (Exception e) {
				}

				try {
					folder.close(true);
				}
				catch (Exception e) {
				}
			}

			if ((store != null) && store.isConnected()) {
				try {
					store.close();
				}
				catch (MessagingException e) {
				}
			}
		}
	}

	protected Folder getFolder(Store store) throws Exception {
		Folder defaultFolder = store.getDefaultFolder();

		Folder[] folders = defaultFolder.list();

		if ((folders != null) && (folders.length == 0)) {
			throw new MessagingException("Inbox not found");
		}

		Folder folder = folders[0];

		folder.open(Folder.READ_WRITE);

		return folder;
	}

	protected Store getStore(MailingListRequest mailingListRequest)
		throws Exception {

		String protocol = mailingListRequest.getInProtocol();
		String host = mailingListRequest.getInServerName();
		int port = mailingListRequest.getInServerPort();
		String user = mailingListRequest.getInUserName();
		String password = mailingListRequest.getInPassword();

		Account account = Account.getInstance(protocol, port);

		account.setHost(host);
		account.setPort(port);
		account.setUser(user);
		account.setPassword(password);

		Session session = MailEngine.getSession(account);

		URLName urlName = new URLName(
			protocol, host, port, StringPool.BLANK, user, password);

		Store store = session.getStore(urlName);

		return store;
	}

	protected void processMessage(
			MailingListRequest mailingListRequest, Message mailMessage)
		throws Exception {

		if (MBUtil.hasMailIdHeader(mailMessage)) {
			return;
		}

		String from = null;

		Address[] addresses = mailMessage.getFrom();

		if ((addresses != null) && (addresses.length > 0)) {
			Address address = addresses[0];

			if (address instanceof InternetAddress) {
				from = ((InternetAddress)address).getAddress();
			}
			else {
				from = address.toString();
			}
		}

		long companyId = mailingListRequest.getCompanyId();
		long groupId = mailingListRequest.getGroupId();
		long categoryId = mailingListRequest.getCategoryId();

		if (_log.isDebugEnabled()) {
			_log.debug("Category id " + categoryId);
		}

		boolean anonymous = false;

		User user = UserLocalServiceUtil.getUserById(
			companyId, mailingListRequest.getUserId());

		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, from);
		}
		catch (NoSuchUserException nsue) {
			anonymous = true;
		}

		long parentMessageId = MBUtil.getParentMessageId(mailMessage);

		if (_log.isDebugEnabled()) {
			_log.debug("Parent message id " + parentMessageId);
		}

		MBMessage parentMessage = null;

		try {
			if (parentMessageId > 0) {
				parentMessage = MBMessageLocalServiceUtil.getMessage(
					parentMessageId);
			}
		}
		catch (NoSuchMessageException nsme) {
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Parent message " + parentMessage);
		}

		MBMailMessage collector = new MBMailMessage();

		MBUtil.collectPartContent(mailMessage, collector);

		PermissionCheckerUtil.setThreadValues(user);

		MailingListThreadLocal.setSourceMailingList(true);

		String subject = MBUtil.getSubjectWithoutMessageId(mailMessage);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setLayoutFullURL(
			PortalUtil.getLayoutFullURL(groupId, PortletKeys.MESSAGE_BOARDS));
		serviceContext.setScopeGroupId(groupId);

		if (parentMessage == null) {
			MBMessageServiceUtil.addMessage(
				groupId, categoryId, subject, collector.getBody(),
				collector.getFiles(), anonymous, 0.0, true, serviceContext);
		}
		else {
			MBMessageServiceUtil.addMessage(
				groupId, categoryId, parentMessage.getThreadId(),
				parentMessage.getMessageId(), subject, collector.getBody(),
				collector.getFiles(), anonymous, 0.0, true, serviceContext);
		}
	}

	protected void processMessages(
			MailingListRequest mailingListRequest, Message[] messages)
		throws Exception {

		for (Message message : messages) {
			try {
				processMessage(mailingListRequest, message);
			}
			finally {
				PermissionCheckerUtil.setThreadValues(null);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MailingListMessageListener.class);

}