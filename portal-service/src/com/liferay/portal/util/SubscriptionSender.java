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

package com.liferay.portal.util;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.mail.SMTPAccount;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.io.File;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.InternetAddress;

/**
 * @author Brian Wing Shun Chan
 */
public class SubscriptionSender implements Serializable {

	public void addAttachment(File attachment) {
		if (attachment == null) {
			return;
		}

		if (attachments == null) {
			attachments = new ArrayList<File>();
		}

		attachments.add(attachment);
	}

	public void addPersistedSubscribers(String className, long classPK) {
		ObjectValuePair<String, Long> ovp = new ObjectValuePair<String, Long>(
			className, classPK);

		_persistestedSubscribersOVPs.add(ovp);
	}

	public void addRuntimeSubscribers(String toAddress, String toName) {
		ObjectValuePair<String, String> ovp =
			new ObjectValuePair<String, String>(toAddress, toName);

		_runtimeSubscribersOVPs.add(ovp);
	}

	public void flushNotifications() throws Exception {
		initialize();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if ((_classLoader != null) &&
				(contextClassLoader != _classLoader)) {

				currentThread.setContextClassLoader(_classLoader);
			}

			for (ObjectValuePair<String, Long> ovp :
					_persistestedSubscribersOVPs) {

				String className = ovp.getKey();
				long classPK = ovp.getValue();

				List<Subscription> subscriptions =
					SubscriptionLocalServiceUtil.getSubscriptions(
						companyId, className, classPK);

				for (Subscription subscription : subscriptions) {
					notifySubscriber(subscription);
				}

				if (bulk) {
					Locale locale = LocaleUtil.getDefault();

					InternetAddress to = new InternetAddress(
						replaceContent(replyToAddress, locale),
						replaceContent(replyToAddress, locale));

					sendEmail(to, locale);
				}
			}

			_persistestedSubscribersOVPs.clear();

			for (ObjectValuePair<String, String> ovp :
					_runtimeSubscribersOVPs) {

				String toAddress = ovp.getKey();
				String toName = ovp.getValue();

				InternetAddress to = new InternetAddress(toAddress, toName);

				sendEmail(to, LocaleUtil.getDefault());
			}

			_runtimeSubscribersOVPs.clear();
		}
		finally {
			if ((_classLoader != null) &&
				(contextClassLoader != _classLoader)) {

				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public void flushNotificationsAsync() {
		Thread currentThread = Thread.currentThread();

		_classLoader = currentThread.getContextClassLoader();

		MessageBusUtil.sendMessage(DestinationNames.SUBSCRIPTION_SENDER, this);
	}

	public Object getContextAttribute(String key) {
		return _context.get(key);
	}

	public void initialize() throws PortalException, SystemException {
		if (_initialized) {
			return;
		}

		_initialized = true;

		Company company = CompanyLocalServiceUtil.getCompany(companyId);

		setContextAttribute("[$COMPANY_ID$]", company.getCompanyId());
		setContextAttribute("[$COMPANY_MX$]", company.getMx());
		setContextAttribute("[$COMPANY_NAME$]", company.getName());
		setContextAttribute("[$PORTAL_URL$]", company.getVirtualHost());

		if (groupId > 0) {
			Group group = GroupLocalServiceUtil.getGroup(groupId);

			setContextAttribute(
				"[$COMMUNITY_NAME$]", group.getDescriptiveName());
		}

		if ((userId > 0) && Validator.isNotNull(_contextUserPrefix)) {
			setContextAttribute(
				"[$" + _contextUserPrefix + "_USER_ADDRESS$]",
				PortalUtil.getUserEmailAddress(userId));
			setContextAttribute(
				"[$" + _contextUserPrefix + "_USER_NAME$]",
				PortalUtil.getUserName(userId, StringPool.BLANK));
		}

		_sentUserIds.add(userId);

		mailId = PortalUtil.getMailId(
			company.getMx(), _mailIdPopPortletPrefix, _mailIdIds);
	}

	public String getMailId() {
		return this.mailId;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setBulk(boolean bulk) {
		this.bulk = bulk;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setContextAttribute(String key, Object value) {
		_context.put(key, value);
	}

	public void setContextAttributes(Object... values) {
		for (int i = 0; i < values.length; i += 2) {
			setContextAttribute(String.valueOf(values[i]), values[i + 1]);
		}
	}

	public void setContextUserPrefix(String contextUserPrefix) {
		_contextUserPrefix = contextUserPrefix;
	}

	public void setFrom(String fromAddress, String fromName) {
		this.fromAddress = fromAddress;
		this.fromName = fromName;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public void setHtmlFormat(boolean htmlFormat) {
		this.htmlFormat = htmlFormat;
	}

	public void setInReplyTo(String inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public void setLocalizedBodyMap(Map<Locale, String> localizedBodyMap) {
		this.localizedBodyMap = localizedBodyMap;
	}

	public void setLocalizedSubjectMap(
		Map<Locale, String> localizedSubjectMap) {

		this.localizedSubjectMap = localizedSubjectMap;
	}

	public void setMailId(String popPortletPrefix, Object... ids) {
		_mailIdPopPortletPrefix = popPortletPrefix;
		_mailIdIds = ids;
	}

	public  void setPortletId(String portletId) {
		this.portletId = portletId;
	}

	public void setReplyToAddress(String replyToAddress) {
		this.replyToAddress = replyToAddress;
	}

	public void setSMTPAccount(SMTPAccount smtpAccount) {
		this.smtpAccount = smtpAccount;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	protected void deleteSubscription(Subscription subscription)
		throws Exception {

		SubscriptionLocalServiceUtil.deleteSubscription(
			subscription.getSubscriptionId());
	}

	protected boolean hasPermission(Subscription subscription, User user)
		throws Exception {

		return _PERMISSION;
	}

	protected void notifySubscriber(Subscription subscription)
		throws Exception {

		long subscriptionUserId = subscription.getUserId();

		if (_sentUserIds.contains(subscriptionUserId)) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Do not send a duplicate email to user " +
						subscriptionUserId);
			}

			return;
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Add user " + subscriptionUserId +
						" to the list of users who have received an email");
			}

			_sentUserIds.add(subscriptionUserId);
		}

		User user = null;

		try {
			user = UserLocalServiceUtil.getUserById(subscriptionUserId);
		}
		catch (NoSuchUserException nsue) {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Subscription " + subscription.getSubscriptionId() +
						" is stale and will be deleted");
			}

			deleteSubscription(subscription);

			return;
		}

		if (!user.isActive()) {
			if (_log.isDebugEnabled()) {
				_log.debug("Skip inactive user " + subscriptionUserId);
			}

			return;
		}

		Group group = GroupLocalServiceUtil.getGroup(groupId);

		int type = group.getType();

		if (!GroupLocalServiceUtil.hasUserGroup(subscriptionUserId, groupId) &&
			(type != GroupConstants.TYPE_COMMUNITY_OPEN)) {

			if (_log.isInfoEnabled()) {
				_log.info(
					"Subscription " + subscription.getSubscriptionId() +
						" is stale and will be deleted");
			}

			deleteSubscription(subscription);

			return;
		}

		try {
			if (!hasPermission(subscription, user)) {
				if (_log.isDebugEnabled()) {
					_log.debug("Skip unauthorized user " + subscriptionUserId);
				}

				return;
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			return;
		}

		if (bulk) {
			InternetAddress bulkAddress = new InternetAddress(
				user.getEmailAddress(), user.getFullName());

			if (_bulkAddresses == null) {
				_bulkAddresses = new ArrayList<InternetAddress>();
			}

			_bulkAddresses.add(bulkAddress);
		}
		else {
			try {
				InternetAddress to = new InternetAddress(
					user.getEmailAddress(), user.getFullName());

				sendEmail(to, user.getLocale());
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
	}

	protected void processMailMessage(MailMessage mailMessage, Locale locale)
		throws Exception {

		InternetAddress from = mailMessage.getFrom();
		InternetAddress to = mailMessage.getTo()[0];

		String processedSubject = StringUtil.replace(
			mailMessage.getSubject(),
			new String[] {
				"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]",
				"[$TO_ADDRESS$]",
				"[$TO_NAME$]"
			},
			new String[] {
				from.getAddress(),
				GetterUtil.getString(from.getPersonal(), from.getAddress()),
				to.getAddress(),
				GetterUtil.getString(to.getPersonal(), to.getAddress())
			});

		processedSubject = replaceContent(processedSubject, locale);

		mailMessage.setSubject(processedSubject);

		String processedBody = StringUtil.replace(
			mailMessage.getBody(),
			new String[] {
				"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]",
				"[$TO_ADDRESS$]",
				"[$TO_NAME$]"
			},
			new String[] {
				from.getAddress(),
				GetterUtil.getString(from.getPersonal(), from.getAddress()),
				to.getAddress(),
				GetterUtil.getString(to.getPersonal(), to.getAddress())
			});

		processedBody = replaceContent(processedBody, locale);

		mailMessage.setBody(processedBody);
	}

	protected String replaceContent(String content, Locale locale)
		throws Exception {

		for (Map.Entry<String, Object> entry : _context.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			content = StringUtil.replace(content, key, String.valueOf(value));
		}

		if (Validator.isNotNull(portletId)) {
			String portletName = PortalUtil.getPortletTitle(portletId, locale);

			content = StringUtil.replace(
				content, "[$PORTLET_NAME$]", portletName);
		}

		return content;
	}

	protected void sendEmail(InternetAddress to, Locale locale)
		throws Exception {

		InternetAddress from = new InternetAddress(
			replaceContent(fromAddress, locale),
			replaceContent(fromName, locale));

		String processedSubject = null;

		if (localizedSubjectMap != null) {
			String localizedSubject = localizedSubjectMap.get(locale);

			if (Validator.isNull(localizedSubject)) {
				Locale defaultLocale = LocaleUtil.getDefault();

				processedSubject = localizedSubjectMap.get(defaultLocale);
			}
			else {
				processedSubject = localizedSubject;
			}
		}
		else {
			processedSubject = this.subject;
		}

		String processedBody = null;

		if (localizedBodyMap != null) {
			String localizedBody = localizedBodyMap.get(locale);

			if (Validator.isNull(localizedBody)) {
				Locale defaultLocale = LocaleUtil.getDefault();

				processedBody = localizedBodyMap.get(defaultLocale);
			}
			else {
				processedBody = localizedBody;
			}
		}
		else {
			processedBody = this.body;
		}

		MailMessage mailMessage = new MailMessage(
			from, to, processedSubject, processedBody, htmlFormat);

		if (attachments != null) {
			for (File attachment : attachments) {
				mailMessage.addAttachment(attachment);
			}
		}

		if (bulk && (_bulkAddresses != null)) {
			mailMessage.setBulkAddresses(
				_bulkAddresses.toArray(
					new InternetAddress[_bulkAddresses.size()]));

			_bulkAddresses.clear();
		}

		if (inReplyTo != null) {
			mailMessage.setInReplyTo(inReplyTo);
		}

		mailMessage.setMessageId(mailId);

		if (replyToAddress != null) {
			InternetAddress replyTo = new InternetAddress(
				replaceContent(replyToAddress, locale),
				replaceContent(replyToAddress, locale));

			mailMessage.setReplyTo(new InternetAddress[] {replyTo});
		}

		if (smtpAccount != null) {
			mailMessage.setSMTPAccount(smtpAccount);
		}

		processMailMessage(mailMessage, locale);

		MailServiceUtil.sendEmail(mailMessage);
	}

	protected List<File> attachments;
	protected String body;
	protected boolean bulk;
	protected long companyId;
	protected String fromAddress;
	protected String fromName;
	protected long groupId;
	protected boolean htmlFormat;
	protected String inReplyTo;
	protected Map<Locale, String> localizedBodyMap;
	protected Map<Locale, String> localizedSubjectMap;
	protected String mailId;
	protected String portletId;
	protected String replyToAddress;
	protected SMTPAccount smtpAccount;
	protected String subject;
	protected long userId;

	private static final boolean _PERMISSION = true;

	private static Log _log = LogFactoryUtil.getLog(SubscriptionSender.class);

	private List<InternetAddress> _bulkAddresses;
	private ClassLoader _classLoader;
	private Map<String, Object> _context = new HashMap<String, Object>();
	private String _contextUserPrefix;
	private boolean _initialized;
	private Object[] _mailIdIds;
	private String _mailIdPopPortletPrefix;
	private List<ObjectValuePair<String, Long>> _persistestedSubscribersOVPs =
		new ArrayList<ObjectValuePair<String, Long>>();
	private List<ObjectValuePair<String, String>> _runtimeSubscribersOVPs =
		new ArrayList<ObjectValuePair<String, String>>();
	private Set<Long> _sentUserIds = new HashSet<Long>();

}