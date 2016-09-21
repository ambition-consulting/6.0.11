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

package com.liferay.portlet.imagegallery.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the i g image remote service. This utility wraps {@link com.liferay.portlet.imagegallery.service.impl.IGImageServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IGImageService
 * @see com.liferay.portlet.imagegallery.service.base.IGImageServiceBaseImpl
 * @see com.liferay.portlet.imagegallery.service.impl.IGImageServiceImpl
 * @generated
 */
public class IGImageServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.imagegallery.service.impl.IGImageServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.imagegallery.model.IGImage addImage(
		long groupId, long folderId, java.lang.String name,
		java.lang.String description, java.io.File file,
		java.lang.String contentType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addImage(groupId, folderId, name, description, file,
			contentType, serviceContext);
	}

	public static void deleteImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteImage(imageId);
	}

	public static void deleteImageByFolderIdAndNameWithExtension(long groupId,
		long folderId, java.lang.String nameWithExtension)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteImageByFolderIdAndNameWithExtension(groupId, folderId,
			nameWithExtension);
	}

	public static int getFoldersImagesCount(long groupId,
		java.util.List<java.lang.Long> folderIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFoldersImagesCount(groupId, folderIds);
	}

	public static java.util.List<com.liferay.portlet.imagegallery.model.IGImage> getGroupImages(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupImages(groupId, userId, start, end);
	}

	public static int getGroupImagesCount(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupImagesCount(groupId, userId);
	}

	public static com.liferay.portlet.imagegallery.model.IGImage getImage(
		long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getImage(imageId);
	}

	public static com.liferay.portlet.imagegallery.model.IGImage getImageByFolderIdAndNameWithExtension(
		long groupId, long folderId, java.lang.String nameWithExtension)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getImageByFolderIdAndNameWithExtension(groupId, folderId,
			nameWithExtension);
	}

	public static com.liferay.portlet.imagegallery.model.IGImage getImageByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getImageByLargeImageId(largeImageId);
	}

	public static com.liferay.portlet.imagegallery.model.IGImage getImageBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getImageBySmallImageId(smallImageId);
	}

	public static java.util.List<com.liferay.portlet.imagegallery.model.IGImage> getImages(
		long groupId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImages(groupId, folderId);
	}

	public static java.util.List<com.liferay.portlet.imagegallery.model.IGImage> getImages(
		long groupId, long folderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImages(groupId, folderId, start, end);
	}

	public static int getImagesCount(long groupId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImagesCount(groupId, folderId);
	}

	public static com.liferay.portlet.imagegallery.model.IGImage updateImage(
		long imageId, long groupId, long folderId, java.lang.String name,
		java.lang.String description, java.io.File file,
		java.lang.String contentType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateImage(imageId, groupId, folderId, name, description,
			file, contentType, serviceContext);
	}

	public static IGImageService getService() {
		if (_service == null) {
			_service = (IGImageService)PortalBeanLocatorUtil.locate(IGImageService.class.getName());

			ReferenceRegistry.registerReference(IGImageServiceUtil.class,
				"_service");
			MethodCache.remove(IGImageService.class);
		}

		return _service;
	}

	public void setService(IGImageService service) {
		MethodCache.remove(IGImageService.class);

		_service = service;

		ReferenceRegistry.registerReference(IGImageServiceUtil.class, "_service");
		MethodCache.remove(IGImageService.class);
	}

	private static IGImageService _service;
}