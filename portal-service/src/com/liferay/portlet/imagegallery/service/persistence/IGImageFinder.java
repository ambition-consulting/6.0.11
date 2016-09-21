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

package com.liferay.portlet.imagegallery.service.persistence;

/**
 * @author Brian Wing Shun Chan
 */
public interface IGImageFinder {
	public com.liferay.portlet.imagegallery.model.IGImage fetchByAnyImageId(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.imagegallery.model.IGImage findByAnyImageId(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.imagegallery.NoSuchImageException;

	public java.util.List<com.liferay.portlet.imagegallery.model.IGImage> findByNoAssets()
		throws com.liferay.portal.kernel.exception.SystemException;
}