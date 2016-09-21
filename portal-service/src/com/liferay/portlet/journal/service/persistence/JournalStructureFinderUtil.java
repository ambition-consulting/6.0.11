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
public class JournalStructureFinderUtil {
	public static int countByKeywords(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeywords(companyId, groupId, keywords);
	}

	public static int countByC_G_S_N_D(long companyId, long groupId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_S_N_D(companyId, groupId, structureId, name,
			description, andOperator);
	}

	public static int countByC_G_S_N_D(long companyId, long groupId,
		java.lang.String[] structureIds, java.lang.String[] names,
		java.lang.String[] descriptions, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_S_N_D(companyId, groupId, structureIds, names,
			descriptions, andOperator);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> findByKeywords(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeywords(companyId, groupId, keywords, start, end, obc);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> findByC_G_S_N_D(
		long companyId, long groupId, java.lang.String structureId,
		java.lang.String name, java.lang.String description,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_S_N_D(companyId, groupId, structureId, name,
			description, andOperator, start, end, obc);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> findByC_G_S_N_D(
		long companyId, long groupId, java.lang.String[] structureIds,
		java.lang.String[] names, java.lang.String[] descriptions,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_S_N_D(companyId, groupId, structureIds, names,
			descriptions, andOperator, start, end, obc);
	}

	public static JournalStructureFinder getFinder() {
		if (_finder == null) {
			_finder = (JournalStructureFinder)PortalBeanLocatorUtil.locate(JournalStructureFinder.class.getName());

			ReferenceRegistry.registerReference(JournalStructureFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(JournalStructureFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(JournalStructureFinderUtil.class,
			"_finder");
	}

	private static JournalStructureFinder _finder;
}