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

package com.liferay.portlet.journal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class JournalArticleFinderUtil {
	public static int countByKeywords(long companyId, long groupId,
		java.lang.String keywords, java.lang.Double version,
		java.lang.String type, java.lang.String structureId,
		java.lang.String templateId, java.util.Date displayDateGT,
		java.util.Date displayDateLT, int status, java.util.Date reviewDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByKeywords(companyId, groupId, keywords, version,
			type, structureId, templateId, displayDateGT, displayDateLT,
			status, reviewDate);
	}

	public static int countByC_G_A_V_T_D_C_T_S_T_D_S_R(long companyId,
		long groupId, java.lang.String articleId, java.lang.Double version,
		java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String type,
		java.lang.String structureId, java.lang.String templateId,
		java.util.Date displayDateGT, java.util.Date displayDateLT, int status,
		java.util.Date reviewDate, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_A_V_T_D_C_T_S_T_D_S_R(companyId, groupId,
			articleId, version, title, description, content, type, structureId,
			templateId, displayDateGT, displayDateLT, status, reviewDate,
			andOperator);
	}

	public static int countByC_G_A_V_T_D_C_T_S_T_D_S_R(long companyId,
		long groupId, java.lang.String articleId, java.lang.Double version,
		java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String type,
		java.lang.String[] structureIds, java.lang.String[] templateIds,
		java.util.Date displayDateGT, java.util.Date displayDateLT, int status,
		java.util.Date reviewDate, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_A_V_T_D_C_T_S_T_D_S_R(companyId, groupId,
			articleId, version, title, description, content, type,
			structureIds, templateIds, displayDateGT, displayDateLT, status,
			reviewDate, andOperator);
	}

	public static int countByC_G_A_V_T_D_C_T_S_T_D_S_R(long companyId,
		long groupId, java.lang.String[] articleIds, java.lang.Double version,
		java.lang.String[] titles, java.lang.String[] descriptions,
		java.lang.String[] contents, java.lang.String type,
		java.lang.String[] structureIds, java.lang.String[] templateIds,
		java.util.Date displayDateGT, java.util.Date displayDateLT, int status,
		java.util.Date reviewDate, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_A_V_T_D_C_T_S_T_D_S_R(companyId, groupId,
			articleIds, version, titles, descriptions, contents, type,
			structureIds, templateIds, displayDateGT, displayDateLT, status,
			reviewDate, andOperator);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> findByExpirationDate(
		int status, java.util.Date expirationDateLT,
		java.util.Date expirationDateGT)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByExpirationDate(status, expirationDateLT,
			expirationDateGT);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> findByKeywords(
		long companyId, long groupId, java.lang.String keywords,
		java.lang.Double version, java.lang.String type,
		java.lang.String structureId, java.lang.String templateId,
		java.util.Date displayDateGT, java.util.Date displayDateLT, int status,
		java.util.Date reviewDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeywords(companyId, groupId, keywords, version, type,
			structureId, templateId, displayDateGT, displayDateLT, status,
			reviewDate, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> findByReviewDate(
		java.util.Date reviewDateLT, java.util.Date reviewDateGT)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByReviewDate(reviewDateLT, reviewDateGT);
	}

	public static com.liferay.portlet.journal.model.JournalArticle findByR_D(
		long resourcePrimKey, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.journal.NoSuchArticleException {
		return getFinder().findByR_D(resourcePrimKey, displayDate);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_S_R(
		long companyId, long groupId, java.lang.String articleId,
		java.lang.Double version, java.lang.String title,
		java.lang.String description, java.lang.String content,
		java.lang.String type, java.lang.String structureId,
		java.lang.String templateId, java.util.Date displayDateGT,
		java.util.Date displayDateLT, int status, java.util.Date reviewDate,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_A_V_T_D_C_T_S_T_D_S_R(companyId, groupId,
			articleId, version, title, description, content, type, structureId,
			templateId, displayDateGT, displayDateLT, status, reviewDate,
			andOperator, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_S_R(
		long companyId, long groupId, java.lang.String articleId,
		java.lang.Double version, java.lang.String title,
		java.lang.String description, java.lang.String content,
		java.lang.String type, java.lang.String[] structureIds,
		java.lang.String[] templateIds, java.util.Date displayDateGT,
		java.util.Date displayDateLT, int status, java.util.Date reviewDate,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_A_V_T_D_C_T_S_T_D_S_R(companyId, groupId,
			articleId, version, title, description, content, type,
			structureIds, templateIds, displayDateGT, displayDateLT, status,
			reviewDate, andOperator, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_S_R(
		long companyId, long groupId, java.lang.String[] articleIds,
		java.lang.Double version, java.lang.String[] titles,
		java.lang.String[] descriptions, java.lang.String[] contents,
		java.lang.String type, java.lang.String[] structureIds,
		java.lang.String[] templateIds, java.util.Date displayDateGT,
		java.util.Date displayDateLT, int status, java.util.Date reviewDate,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_A_V_T_D_C_T_S_T_D_S_R(companyId, groupId,
			articleIds, version, titles, descriptions, contents, type,
			structureIds, templateIds, displayDateGT, displayDateLT, status,
			reviewDate, andOperator, start, end, orderByComparator);
	}

	public static JournalArticleFinder getFinder() {
		if (_finder == null) {
			_finder = (JournalArticleFinder)PortalBeanLocatorUtil.locate(JournalArticleFinder.class.getName());

			ReferenceRegistry.registerReference(JournalArticleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(JournalArticleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(JournalArticleFinderUtil.class,
			"_finder");
	}

	private static JournalArticleFinder _finder;
}