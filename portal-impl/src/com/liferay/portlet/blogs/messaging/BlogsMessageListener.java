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

package com.liferay.portlet.blogs.messaging;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.internet.InternetAddress;

/**
 * @author Thiago Moreira
 */
public class BlogsMessageListener extends BaseMessageListener {

	protected void doReceive(Message message) throws Exception {
		long companyId = message.getLong("companyId");
		long userId = message.getLong("userId");
		long groupId = message.getLong("groupId");
		long entryId = message.getLong("entryId");
		String fromName = message.getString("fromName");
		String fromAddress = message.getString("fromAddress");
		String subject = message.getString("subject");
		String body = message.getString("body");
		String replyToAddress = message.getString("replyToAddress");
		String mailId = message.getString("mailId");
		boolean htmlFormat = message.getBoolean("htmlFormat");

		Set<Long> sent = new HashSet<Long>();

		if (_log.isInfoEnabled()) {
			_log.info(
				"Sending notifications for {mailId=" + mailId + ", entryId=" +
					entryId + "}");
		}

		// Entries

		List<Subscription> subscriptions =
			SubscriptionLocalServiceUtil.getSubscriptions(
				companyId, BlogsEntry.class.getName(), groupId);

		sendEmail(
			userId, groupId, fromName, fromAddress, subject, body,
			subscriptions, sent, replyToAddress, mailId, htmlFormat);

		if (_log.isInfoEnabled()) {
			_log.info("Finished sending notifications");
		}
	}

	protected void sendEmail(
			long userId, long groupId, String fromName, String fromAddress,
			String subject, String body, List<Subscription> subscriptions,
			Set<Long> sent, String replyToAddress, String mailId,
			boolean htmlFormat)
		throws Exception {

		for (Subscription subscription : subscriptions) {
			long subscribedUserId = subscription.getUserId();

			if (sent.contains(subscribedUserId)) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Do not send a duplicate email to user " +
							subscribedUserId);
				}

				continue;
			}
			else {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Add user " + subscribedUserId +
							" to the list of users who have received an email");
				}

				sent.add(subscribedUserId);
			}

			User user = null;

			try {
				user = UserLocalServiceUtil.getUserById(subscribedUserId);
			}
			catch (NoSuchUserException nsue) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Subscription " + subscription.getSubscriptionId() +
							" is stale and will be deleted");
				}

				SubscriptionLocalServiceUtil.deleteSubscription(
					subscription.getSubscriptionId());

				continue;
			}

			if (!user.isActive()) {
				continue;
			}

			if (!GroupLocalServiceUtil.hasUserGroup(
					subscribedUserId, groupId)) {

				if (_log.isInfoEnabled()) {
					_log.info(
						"Subscription " + subscription.getSubscriptionId() +
							" is stale and will be deleted");
				}

				SubscriptionLocalServiceUtil.deleteSubscription(
					subscription.getSubscriptionId());

				continue;
			}

			try {
				InternetAddress from = new InternetAddress(
					fromAddress, fromName);

				InternetAddress to = new InternetAddress(
					user.getEmailAddress(), user.getFullName());

				String curSubject = StringUtil.replace(
					subject,
					new String[] {
						"[$TO_ADDRESS$]",
						"[$TO_NAME$]"
					},
					new String[] {
						user.getFullName(),
						user.getEmailAddress()
					});

				String curBody = StringUtil.replace(
					body,
					new String[] {
						"[$TO_ADDRESS$]",
						"[$TO_NAME$]"
					},
					new String[] {
						user.getFullName(),
						user.getEmailAddress()
					});

				InternetAddress replyTo = new InternetAddress(
					replyToAddress, replyToAddress);

				MailMessage message = new MailMessage(
					from, to, curSubject, curBody, htmlFormat);

				message.setReplyTo(new InternetAddress[] {replyTo});
				message.setMessageId(mailId);

				MailServiceUtil.sendEmail(message);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BlogsMessageListener.class);

}