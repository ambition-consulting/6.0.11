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

package com.liferay.portlet.journal.service;

/**
 * <p>
 * This class is a wrapper for {@link JournalArticleService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       JournalArticleService
 * @generated
 */
public class JournalArticleServiceWrapper implements JournalArticleService {
	public JournalArticleServiceWrapper(
		JournalArticleService journalArticleService) {
		_journalArticleService = journalArticleService;
	}

	public com.liferay.portlet.journal.model.JournalArticle addArticle(
		long groupId, java.lang.String articleId, boolean autoArticleId,
		java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String type,
		java.lang.String structureId, java.lang.String templateId,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire, int reviewDateMonth,
		int reviewDateDay, int reviewDateYear, int reviewDateHour,
		int reviewDateMinute, boolean neverReview, boolean indexable,
		boolean smallImage, java.lang.String smallImageURL,
		java.io.File smallFile, java.util.Map<java.lang.String, byte[]> images,
		java.lang.String articleURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.addArticle(groupId, articleId,
			autoArticleId, title, description, content, type, structureId,
			templateId, displayDateMonth, displayDateDay, displayDateYear,
			displayDateHour, displayDateMinute, expirationDateMonth,
			expirationDateDay, expirationDateYear, expirationDateHour,
			expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
			reviewDateYear, reviewDateHour, reviewDateMinute, neverReview,
			indexable, smallImage, smallImageURL, smallFile, images,
			articleURL, serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalArticle addArticle(
		long groupId, java.lang.String articleId, boolean autoArticleId,
		java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String type,
		java.lang.String structureId, java.lang.String templateId,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire, int reviewDateMonth,
		int reviewDateDay, int reviewDateYear, int reviewDateHour,
		int reviewDateMinute, boolean neverReview, boolean indexable,
		java.lang.String articleURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.addArticle(groupId, articleId,
			autoArticleId, title, description, content, type, structureId,
			templateId, displayDateMonth, displayDateDay, displayDateYear,
			displayDateHour, displayDateMinute, expirationDateMonth,
			expirationDateDay, expirationDateYear, expirationDateHour,
			expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
			reviewDateYear, reviewDateHour, reviewDateMinute, neverReview,
			indexable, articleURL, serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalArticle copyArticle(
		long groupId, java.lang.String oldArticleId,
		java.lang.String newArticleId, boolean autoArticleId, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.copyArticle(groupId, oldArticleId,
			newArticleId, autoArticleId, version);
	}

	public void deleteArticle(long groupId, java.lang.String articleId,
		double version, java.lang.String articleURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_journalArticleService.deleteArticle(groupId, articleId, version,
			articleURL, serviceContext);
	}

	public void deleteArticle(long groupId, java.lang.String articleId,
		java.lang.String articleURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_journalArticleService.deleteArticle(groupId, articleId, articleURL,
			serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalArticle expireArticle(
		long groupId, java.lang.String articleId, double version,
		java.lang.String articleURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.expireArticle(groupId, articleId,
			version, articleURL, serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalArticle getArticle(
		long groupId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.getArticle(groupId, articleId);
	}

	public com.liferay.portlet.journal.model.JournalArticle getArticle(
		long groupId, java.lang.String articleId, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.getArticle(groupId, articleId, version);
	}

	public com.liferay.portlet.journal.model.JournalArticle getArticleByUrlTitle(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.getArticleByUrlTitle(groupId, urlTitle);
	}

	public java.lang.String getArticleContent(long groupId,
		java.lang.String articleId, double version,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.getArticleContent(groupId, articleId,
			version, languageId, themeDisplay);
	}

	public java.lang.String getArticleContent(long groupId,
		java.lang.String articleId, java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.getArticleContent(groupId, articleId,
			languageId, themeDisplay);
	}

	public com.liferay.portlet.journal.model.JournalArticle getLatestArticle(
		long groupId, java.lang.String articleId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.getLatestArticle(groupId, articleId,
			status);
	}

	public void removeArticleLocale(long companyId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_journalArticleService.removeArticleLocale(companyId, languageId);
	}

	public com.liferay.portlet.journal.model.JournalArticle removeArticleLocale(
		long groupId, java.lang.String articleId, double version,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.removeArticleLocale(groupId, articleId,
			version, languageId);
	}

	public com.liferay.portlet.journal.model.JournalArticle updateArticle(
		long groupId, java.lang.String articleId, double version,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.updateArticle(groupId, articleId,
			version, content);
	}

	public com.liferay.portlet.journal.model.JournalArticle updateArticle(
		long groupId, java.lang.String articleId, double version,
		java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String type,
		java.lang.String structureId, java.lang.String templateId,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire, int reviewDateMonth,
		int reviewDateDay, int reviewDateYear, int reviewDateHour,
		int reviewDateMinute, boolean neverReview, boolean indexable,
		boolean smallImage, java.lang.String smallImageURL,
		java.io.File smallFile, java.util.Map<java.lang.String, byte[]> images,
		java.lang.String articleURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.updateArticle(groupId, articleId,
			version, title, description, content, type, structureId,
			templateId, displayDateMonth, displayDateDay, displayDateYear,
			displayDateHour, displayDateMinute, expirationDateMonth,
			expirationDateDay, expirationDateYear, expirationDateHour,
			expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
			reviewDateYear, reviewDateHour, reviewDateMinute, neverReview,
			indexable, smallImage, smallImageURL, smallFile, images,
			articleURL, serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalArticle updateContent(
		long groupId, java.lang.String articleId, double version,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalArticleService.updateContent(groupId, articleId,
			version, content);
	}

	public JournalArticleService getWrappedJournalArticleService() {
		return _journalArticleService;
	}

	public void setWrappedJournalArticleService(
		JournalArticleService journalArticleService) {
		_journalArticleService = journalArticleService;
	}

	private JournalArticleService _journalArticleService;
}