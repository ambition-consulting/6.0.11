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

/**
 * <p>
 * This class is a wrapper for {@link IGImageService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       IGImageService
 * @generated
 */
public class IGImageServiceWrapper implements IGImageService {
	public IGImageServiceWrapper(IGImageService igImageService) {
		_igImageService = igImageService;
	}

	public com.liferay.portlet.imagegallery.model.IGImage addImage(
		long groupId, long folderId, java.lang.String name,
		java.lang.String description, java.io.File file,
		java.lang.String contentType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.addImage(groupId, folderId, name, description,
			file, contentType, serviceContext);
	}

	public void deleteImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_igImageService.deleteImage(imageId);
	}

	public void deleteImageByFolderIdAndNameWithExtension(long groupId,
		long folderId, java.lang.String nameWithExtension)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_igImageService.deleteImageByFolderIdAndNameWithExtension(groupId,
			folderId, nameWithExtension);
	}

	public int getFoldersImagesCount(long groupId,
		java.util.List<java.lang.Long> folderIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getFoldersImagesCount(groupId, folderIds);
	}

	public java.util.List<com.liferay.portlet.imagegallery.model.IGImage> getGroupImages(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getGroupImages(groupId, userId, start, end);
	}

	public int getGroupImagesCount(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getGroupImagesCount(groupId, userId);
	}

	public com.liferay.portlet.imagegallery.model.IGImage getImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImage(imageId);
	}

	public com.liferay.portlet.imagegallery.model.IGImage getImageByFolderIdAndNameWithExtension(
		long groupId, long folderId, java.lang.String nameWithExtension)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImageByFolderIdAndNameWithExtension(groupId,
			folderId, nameWithExtension);
	}

	public com.liferay.portlet.imagegallery.model.IGImage getImageByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImageByLargeImageId(largeImageId);
	}

	public com.liferay.portlet.imagegallery.model.IGImage getImageBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImageBySmallImageId(smallImageId);
	}

	public java.util.List<com.liferay.portlet.imagegallery.model.IGImage> getImages(
		long groupId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImages(groupId, folderId);
	}

	public java.util.List<com.liferay.portlet.imagegallery.model.IGImage> getImages(
		long groupId, long folderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImages(groupId, folderId, start, end);
	}

	public int getImagesCount(long groupId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.getImagesCount(groupId, folderId);
	}

	public com.liferay.portlet.imagegallery.model.IGImage updateImage(
		long imageId, long groupId, long folderId, java.lang.String name,
		java.lang.String description, java.io.File file,
		java.lang.String contentType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _igImageService.updateImage(imageId, groupId, folderId, name,
			description, file, contentType, serviceContext);
	}

	public IGImageService getWrappedIGImageService() {
		return _igImageService;
	}

	public void setWrappedIGImageService(IGImageService igImageService) {
		_igImageService = igImageService;
	}

	private IGImageService _igImageService;
}