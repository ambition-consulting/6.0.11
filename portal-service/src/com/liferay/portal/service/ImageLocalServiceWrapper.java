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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link ImageLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ImageLocalService
 * @generated
 */
public class ImageLocalServiceWrapper implements ImageLocalService {
	public ImageLocalServiceWrapper(ImageLocalService imageLocalService) {
		_imageLocalService = imageLocalService;
	}

	/**
	* Adds the image to the database. Also notifies the appropriate model listeners.
	*
	* @param image the image to add
	* @return the image that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Image addImage(
		com.liferay.portal.model.Image image)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.addImage(image);
	}

	/**
	* Creates a new image with the primary key. Does not add the image to the database.
	*
	* @param imageId the primary key for the new image
	* @return the new image
	*/
	public com.liferay.portal.model.Image createImage(long imageId) {
		return _imageLocalService.createImage(imageId);
	}

	/**
	* Deletes the image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param imageId the primary key of the image to delete
	* @throws PortalException if a image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_imageLocalService.deleteImage(imageId);
	}

	/**
	* Deletes the image from the database. Also notifies the appropriate model listeners.
	*
	* @param image the image to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteImage(com.liferay.portal.model.Image image)
		throws com.liferay.portal.kernel.exception.SystemException {
		_imageLocalService.deleteImage(image);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the image with the primary key.
	*
	* @param imageId the primary key of the image to get
	* @return the image
	* @throws PortalException if a image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Image getImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImage(imageId);
	}

	/**
	* Gets a range of all the images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of images to return
	* @param end the upper bound of the range of images to return (not inclusive)
	* @return the range of images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Image> getImages(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImages(start, end);
	}

	/**
	* Gets the number of images.
	*
	* @return the number of images
	* @throws SystemException if a system exception occurred
	*/
	public int getImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImagesCount();
	}

	/**
	* Updates the image in the database. Also notifies the appropriate model listeners.
	*
	* @param image the image to update
	* @return the image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Image updateImage(
		com.liferay.portal.model.Image image)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.updateImage(image);
	}

	/**
	* Updates the image in the database. Also notifies the appropriate model listeners.
	*
	* @param image the image to update
	* @param merge whether to merge the image with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Image updateImage(
		com.liferay.portal.model.Image image, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.updateImage(image, merge);
	}

	public com.liferay.portal.model.Image getCompanyLogo(long imageId) {
		return _imageLocalService.getCompanyLogo(imageId);
	}

	public com.liferay.portal.model.Image getDefaultCompanyLogo() {
		return _imageLocalService.getDefaultCompanyLogo();
	}

	public com.liferay.portal.model.Image getDefaultOrganizationLogo() {
		return _imageLocalService.getDefaultOrganizationLogo();
	}

	public com.liferay.portal.model.Image getDefaultSpacer() {
		return _imageLocalService.getDefaultSpacer();
	}

	public com.liferay.portal.model.Image getDefaultUserFemalePortrait() {
		return _imageLocalService.getDefaultUserFemalePortrait();
	}

	public com.liferay.portal.model.Image getDefaultUserMalePortrait() {
		return _imageLocalService.getDefaultUserMalePortrait();
	}

	public com.liferay.portal.model.Image getImage(byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImage(bytes);
	}

	public com.liferay.portal.model.Image getImage(java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImage(file);
	}

	public com.liferay.portal.model.Image getImage(java.io.InputStream is)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImage(is);
	}

	public com.liferay.portal.model.Image getImageOrDefault(long imageId) {
		return _imageLocalService.getImageOrDefault(imageId);
	}

	public java.util.List<com.liferay.portal.model.Image> getImages()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImages();
	}

	public java.util.List<com.liferay.portal.model.Image> getImagesBySize(
		int size) throws com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.getImagesBySize(size);
	}

	public boolean isNullOrDefaultSpacer(byte[] bytes) {
		return _imageLocalService.isNullOrDefaultSpacer(bytes);
	}

	public com.liferay.portal.model.Image updateImage(long imageId, byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.updateImage(imageId, bytes);
	}

	public com.liferay.portal.model.Image updateImage(long imageId,
		java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.updateImage(imageId, file);
	}

	public com.liferay.portal.model.Image updateImage(long imageId,
		java.io.InputStream is)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.updateImage(imageId, is);
	}

	public com.liferay.portal.model.Image updateImage(long imageId,
		byte[] bytes, java.lang.String type, int height, int width, int size)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _imageLocalService.updateImage(imageId, bytes, type, height,
			width, size);
	}

	public ImageLocalService getWrappedImageLocalService() {
		return _imageLocalService;
	}

	public void setWrappedImageLocalService(ImageLocalService imageLocalService) {
		_imageLocalService = imageLocalService;
	}

	private ImageLocalService _imageLocalService;
}