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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.asset.DuplicateVocabularyException;
import com.liferay.portlet.asset.VocabularyNameException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.base.AssetVocabularyLocalServiceBaseImpl;
import com.liferay.portlet.asset.util.AssetUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Alvaro del Castillo
 * @author Eduardo Lundgren
 * @author Jorge Ferrer
 */
public class AssetVocabularyLocalServiceImpl
	extends AssetVocabularyLocalServiceBaseImpl {

	/**
	 * @deprecated
	 */
	public AssetVocabulary addVocabulary(
			long userId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String settings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return addVocabulary(
			userId, StringPool.BLANK, titleMap, descriptionMap, settings,
			serviceContext);
	}

	public AssetVocabulary addVocabulary(
			long userId, String title, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String settings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Vocabulary

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();
		String name = titleMap.get(LocaleUtil.getDefault());

		Date now = new Date();

		validate(groupId, name);

		long vocabularyId = counterLocalService.increment();

		AssetVocabulary vocabulary = assetVocabularyPersistence.create(
			vocabularyId);

		vocabulary.setUuid(serviceContext.getUuid());
		vocabulary.setGroupId(groupId);
		vocabulary.setCompanyId(user.getCompanyId());
		vocabulary.setUserId(user.getUserId());
		vocabulary.setUserName(user.getFullName());
		vocabulary.setCreateDate(now);
		vocabulary.setModifiedDate(now);
		vocabulary.setName(name);

		if (Validator.isNotNull(title)) {
			vocabulary.setTitle(title);
		}
		else {
			vocabulary.setTitleMap(titleMap);
		}

		vocabulary.setDescriptionMap(descriptionMap);
		vocabulary.setSettings(settings);

		assetVocabularyPersistence.update(vocabulary, false);

		// Resources

		if (serviceContext.getAddCommunityPermissions() ||
			serviceContext.getAddGuestPermissions()) {

			addVocabularyResources(
				vocabulary, serviceContext.getAddCommunityPermissions(),
				serviceContext.getAddGuestPermissions());
		}
		else {
			addVocabularyResources(
				vocabulary, serviceContext.getCommunityPermissions(),
				serviceContext.getGuestPermissions());
		}

		return vocabulary;
	}

	public void addVocabularyResources(
			AssetVocabulary vocabulary, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			vocabulary.getCompanyId(), vocabulary.getGroupId(),
			vocabulary.getUserId(), AssetVocabulary.class.getName(),
			vocabulary.getVocabularyId(), false, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addVocabularyResources(
			AssetVocabulary vocabulary, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			vocabulary.getCompanyId(), vocabulary.getGroupId(),
			vocabulary.getUserId(), AssetVocabulary.class.getName(),
			vocabulary.getVocabularyId(), communityPermissions,
			guestPermissions);
	}

	public void deleteVocabulary(AssetVocabulary vocabulary)
		throws PortalException, SystemException {

		// Vocabulary

		assetVocabularyPersistence.remove(vocabulary);

		// Resources

		resourceLocalService.deleteResource(
			vocabulary.getCompanyId(), AssetVocabulary.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, vocabulary.getVocabularyId());

		// Categories

		assetCategoryLocalService.deleteVocabularyCategories(
			vocabulary.getVocabularyId());
	}

	public void deleteVocabulary(long vocabularyId)
		throws PortalException, SystemException {

		AssetVocabulary vocabulary =
			assetVocabularyPersistence.findByPrimaryKey(vocabularyId);

		deleteVocabulary(vocabulary);
	}

	public List<AssetVocabulary> getCompanyVocabularies(long companyId)
		throws SystemException {

		return assetVocabularyPersistence.findByCompanyId(companyId);
	}

	public List<AssetVocabulary> getGroupsVocabularies(long[] groupIds)
		throws PortalException, SystemException {

		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();

		for (long groupId : groupIds) {
			vocabularies.addAll(getGroupVocabularies(groupId));
		}

		return vocabularies;
	}

	public List<AssetVocabulary> getGroupVocabularies(long groupId)
		throws PortalException, SystemException {

		List<AssetVocabulary> vocabularies =
			assetVocabularyPersistence.findByGroupId(groupId);

		if (vocabularies.isEmpty()) {
			Group group = groupLocalService.getGroup(groupId);

			long defaultUserId = userLocalService.getDefaultUserId(
				group.getCompanyId());

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(groupId);

			Map<Locale, String> titleMap = new HashMap<Locale, String>();

			titleMap.put(
				LocaleUtil.getDefault(), PropsValues.ASSET_VOCABULARY_DEFAULT);

			AssetVocabulary vocabulary =
				assetVocabularyLocalService.addVocabulary(
					defaultUserId, StringPool.BLANK, titleMap, null,
					StringPool.BLANK, serviceContext);

			vocabularies = ListUtil.copy(vocabularies);

			vocabularies.add(vocabulary);
		}

		return vocabularies;
	}

	public AssetVocabulary getGroupVocabulary(long groupId, String name)
		throws PortalException, SystemException {

		return assetVocabularyPersistence.findByG_N(groupId, name);
	}

	public AssetVocabulary getVocabulary(long vocabularyId)
		throws PortalException, SystemException {

		return assetVocabularyPersistence.findByPrimaryKey(vocabularyId);
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

		long groupId = serviceContext.getScopeGroupId();
		String name = titleMap.get(LocaleUtil.getDefault());

		AssetVocabulary vocabulary =
			assetVocabularyPersistence.findByPrimaryKey(vocabularyId);

		if (!vocabulary.getName().equals(name)) {
			validate(groupId, name);
		}

		vocabulary.setModifiedDate(new Date());
		vocabulary.setName(name);
		vocabulary.setTitleMap(titleMap);

		if (Validator.isNotNull(title)) {
			vocabulary.setTitle(title);
		}

		vocabulary.setDescriptionMap(descriptionMap);
		vocabulary.setSettings(settings);

		assetVocabularyPersistence.update(vocabulary, false);

		return vocabulary;
	}

	protected boolean hasVocabulary(long groupId, String name)
		throws SystemException {

		if (assetVocabularyPersistence.countByG_N(groupId, name) == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	protected void validate(long groupId, String name)
		throws PortalException, SystemException {

		if (!AssetUtil.isValidWord(name)) {
			throw new VocabularyNameException();
		}

		if (hasVocabulary(groupId, name)) {
			throw new DuplicateVocabularyException(
				"A category vocabulary with the name " + name +
					" already exists");
		}
	}

}