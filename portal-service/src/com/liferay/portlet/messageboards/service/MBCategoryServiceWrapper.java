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

package com.liferay.portlet.messageboards.service;

/**
 * <p>
 * This class is a wrapper for {@link MBCategoryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBCategoryService
 * @generated
 */
public class MBCategoryServiceWrapper implements MBCategoryService {
	public MBCategoryServiceWrapper(MBCategoryService mbCategoryService) {
		_mbCategoryService = mbCategoryService;
	}

	public com.liferay.portlet.messageboards.model.MBCategory addCategory(
		long parentCategoryId, java.lang.String name,
		java.lang.String description, java.lang.String emailAddress,
		java.lang.String inProtocol, java.lang.String inServerName,
		int inServerPort, boolean inUseSSL, java.lang.String inUserName,
		java.lang.String inPassword, int inReadInterval,
		java.lang.String outEmailAddress, boolean outCustom,
		java.lang.String outServerName, int outServerPort, boolean outUseSSL,
		java.lang.String outUserName, java.lang.String outPassword,
		boolean mailingListActive,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.addCategory(parentCategoryId, name,
			description, emailAddress, inProtocol, inServerName, inServerPort,
			inUseSSL, inUserName, inPassword, inReadInterval, outEmailAddress,
			outCustom, outServerName, outServerPort, outUseSSL, outUserName,
			outPassword, mailingListActive, serviceContext);
	}

	public void deleteCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryService.deleteCategory(groupId, categoryId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getCategories(groupId, parentCategoryId,
			start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
		long groupId, long[] parentCategoryIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getCategories(groupId, parentCategoryIds,
			start, end);
	}

	public int getCategoriesCount(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getCategoriesCount(groupId, parentCategoryId);
	}

	public int getCategoriesCount(long groupId, long[] parentCategoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getCategoriesCount(groupId, parentCategoryIds);
	}

	public com.liferay.portlet.messageboards.model.MBCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getCategory(categoryId);
	}

	public long[] getCategoryIds(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getCategoryIds(groupId, categoryId);
	}

	public java.util.List<java.lang.Long> getSubcategoryIds(
		java.util.List<java.lang.Long> categoryIds, long groupId,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getSubcategoryIds(categoryIds, groupId,
			categoryId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getSubscribedCategories(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getSubscribedCategories(groupId, userId,
			start, end);
	}

	public int getSubscribedCategoriesCount(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.getSubscribedCategoriesCount(groupId, userId);
	}

	public void subscribeCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryService.subscribeCategory(groupId, categoryId);
	}

	public void unsubscribeCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryService.unsubscribeCategory(groupId, categoryId);
	}

	public com.liferay.portlet.messageboards.model.MBCategory updateCategory(
		long categoryId, long parentCategoryId, java.lang.String name,
		java.lang.String description, java.lang.String emailAddress,
		java.lang.String inProtocol, java.lang.String inServerName,
		int inServerPort, boolean inUseSSL, java.lang.String inUserName,
		java.lang.String inPassword, int inReadInterval,
		java.lang.String outEmailAddress, boolean outCustom,
		java.lang.String outServerName, int outServerPort, boolean outUseSSL,
		java.lang.String outUserName, java.lang.String outPassword,
		boolean mailingListActive, boolean mergeWithParentCategory,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryService.updateCategory(categoryId, parentCategoryId,
			name, description, emailAddress, inProtocol, inServerName,
			inServerPort, inUseSSL, inUserName, inPassword, inReadInterval,
			outEmailAddress, outCustom, outServerName, outServerPort,
			outUseSSL, outUserName, outPassword, mailingListActive,
			mergeWithParentCategory, serviceContext);
	}

	public MBCategoryService getWrappedMBCategoryService() {
		return _mbCategoryService;
	}

	public void setWrappedMBCategoryService(MBCategoryService mbCategoryService) {
		_mbCategoryService = mbCategoryService;
	}

	private MBCategoryService _mbCategoryService;
}