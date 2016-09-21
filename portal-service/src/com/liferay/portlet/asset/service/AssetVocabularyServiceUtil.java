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

package com.liferay.portlet.asset.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the asset vocabulary remote service. This utility wraps {@link com.liferay.portlet.asset.service.impl.AssetVocabularyServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetVocabularyService
 * @see com.liferay.portlet.asset.service.base.AssetVocabularyServiceBaseImpl
 * @see com.liferay.portlet.asset.service.impl.AssetVocabularyServiceImpl
 * @generated
 */
public class AssetVocabularyServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.asset.service.impl.AssetVocabularyServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* @deprecated
	*/
	public static com.liferay.portlet.asset.model.AssetVocabulary addVocabulary(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVocabulary(titleMap, descriptionMap, settings,
			serviceContext);
	}

	public static com.liferay.portlet.asset.model.AssetVocabulary addVocabulary(
		java.lang.String title,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVocabulary(title, titleMap, descriptionMap, settings,
			serviceContext);
	}

	public static void deleteVocabulary(long vocabularyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVocabulary(vocabularyId);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getCompanyVocabularies(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyVocabularies(companyId);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupsVocabularies(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupsVocabularies(groupIds);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetVocabulary> getGroupVocabularies(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupVocabularies(groupId);
	}

	public static com.liferay.portlet.asset.model.AssetVocabulary getVocabulary(
		long vocabularyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVocabulary(vocabularyId);
	}

	/**
	* @deprecated
	*/
	public static com.liferay.portlet.asset.model.AssetVocabulary updateVocabulary(
		long vocabularyId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVocabulary(vocabularyId, titleMap, descriptionMap,
			settings, serviceContext);
	}

	public static com.liferay.portlet.asset.model.AssetVocabulary updateVocabulary(
		long vocabularyId, java.lang.String title,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String settings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVocabulary(vocabularyId, title, titleMap,
			descriptionMap, settings, serviceContext);
	}

	public static AssetVocabularyService getService() {
		if (_service == null) {
			_service = (AssetVocabularyService)PortalBeanLocatorUtil.locate(AssetVocabularyService.class.getName());

			ReferenceRegistry.registerReference(AssetVocabularyServiceUtil.class,
				"_service");
			MethodCache.remove(AssetVocabularyService.class);
		}

		return _service;
	}

	public void setService(AssetVocabularyService service) {
		MethodCache.remove(AssetVocabularyService.class);

		_service = service;

		ReferenceRegistry.registerReference(AssetVocabularyServiceUtil.class,
			"_service");
		MethodCache.remove(AssetVocabularyService.class);
	}

	private static AssetVocabularyService _service;
}