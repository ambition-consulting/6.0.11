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

package com.liferay.portlet.asset.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.base.AssetVocabularyServiceBaseImpl;
import com.liferay.portlet.asset.service.permission.AssetPermission;
import com.liferay.portlet.asset.service.permission.AssetVocabularyPermission;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Alvaro del Castillo
 * @author Eduardo Lundgren
 * @author Jorge Ferrer
 */
public class AssetVocabularyServiceImpl
	extends AssetVocabularyServiceBaseImpl {

	/**
	 * @deprecated
	 */
	public AssetVocabulary addVocabulary(
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String settings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return addVocabulary(
			StringPool.BLANK, titleMap, descriptionMap, settings,
			serviceContext);
	}

	public AssetVocabulary addVocabulary(
			String title, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String settings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		AssetPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_VOCABULARY);

		return assetVocabularyLocalService.addVocabulary(
			getUserId(), title, titleMap, descriptionMap, settings,
			serviceContext);
	}

	public void deleteVocabulary(long vocabularyId)
		throws PortalException, SystemException {

		AssetVocabularyPermission.check(
			getPermissionChecker(), vocabularyId, ActionKeys.DELETE);

		assetVocabularyLocalService.deleteVocabulary(vocabularyId);
	}

	public List<AssetVocabulary> getCompanyVocabularies(long companyId)
		throws PortalException, SystemException {

		return filterVocabularies(
			assetVocabularyLocalService.getCompanyVocabularies(companyId));
	}

	public List<AssetVocabulary> getGroupsVocabularies(long[] groupIds)
		throws PortalException, SystemException {

		return filterVocabularies(
			assetVocabularyLocalService.getGroupsVocabularies(groupIds));
	}

	public List<AssetVocabulary> getGroupVocabularies(long groupId)
		throws PortalException, SystemException {

		return filterVocabularies(
			assetVocabularyLocalService.getGroupVocabularies(groupId));
	}

	public AssetVocabulary getVocabulary(long vocabularyId)
		throws PortalException, SystemException {

		AssetVocabularyPermission.check(
			getPermissionChecker(), vocabularyId, ActionKeys.VIEW);

		return assetVocabularyLocalService.getVocabulary(vocabularyId);
	}

	/**
	 * @deprecated
	 */
	public AssetVocabulary updateVocabulary(
			long vocabularyId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String settings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return updateVocabulary(
			vocabularyId, StringPool.BLANK, titleMap, descriptionMap, settings,
			serviceContext);
	}

	public AssetVocabulary updateVocabulary(
			long vocabularyId, String title, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String settings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		AssetVocabularyPermission.check(
			getPermissionChecker(), vocabularyId, ActionKeys.UPDATE);

		return assetVocabularyLocalService.updateVocabulary(
			vocabularyId, title, titleMap, descriptionMap, settings,
			serviceContext);
	}

	protected List<AssetVocabulary> filterVocabularies(
			List<AssetVocabulary> vocabularies)
		throws PortalException {

		PermissionChecker permissionChecker = getPermissionChecker();

		vocabularies = ListUtil.copy(vocabularies);

		Iterator<AssetVocabulary> itr = vocabularies.iterator();

		while (itr.hasNext()) {
			AssetVocabulary vocabulary = itr.next();

			if (!AssetVocabularyPermission.contains(
					permissionChecker, vocabulary, ActionKeys.VIEW)) {

				itr.remove();
			}
		}

		return vocabularies;
	}

}