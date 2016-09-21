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

package com.liferay.portlet.softwarecatalog.service;

/**
 * <p>
 * This class is a wrapper for {@link SCProductEntryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SCProductEntryService
 * @generated
 */
public class SCProductEntryServiceWrapper implements SCProductEntryService {
	public SCProductEntryServiceWrapper(
		SCProductEntryService scProductEntryService) {
		_scProductEntryService = scProductEntryService;
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductEntry addProductEntry(
		java.lang.String name, java.lang.String type, java.lang.String tags,
		java.lang.String shortDescription, java.lang.String longDescription,
		java.lang.String pageURL, java.lang.String author,
		java.lang.String repoGroupId, java.lang.String repoArtifactId,
		long[] licenseIds, java.util.List<byte[]> thumbnails,
		java.util.List<byte[]> fullImages,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductEntryService.addProductEntry(name, type, tags,
			shortDescription, longDescription, pageURL, author, repoGroupId,
			repoArtifactId, licenseIds, thumbnails, fullImages, serviceContext);
	}

	public void deleteProductEntry(long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_scProductEntryService.deleteProductEntry(productEntryId);
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductEntry getProductEntry(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductEntryService.getProductEntry(productEntryId);
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductEntry updateProductEntry(
		long productEntryId, java.lang.String name, java.lang.String type,
		java.lang.String tags, java.lang.String shortDescription,
		java.lang.String longDescription, java.lang.String pageURL,
		java.lang.String author, java.lang.String repoGroupId,
		java.lang.String repoArtifactId, long[] licenseIds,
		java.util.List<byte[]> thumbnails, java.util.List<byte[]> fullImages)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductEntryService.updateProductEntry(productEntryId, name,
			type, tags, shortDescription, longDescription, pageURL, author,
			repoGroupId, repoArtifactId, licenseIds, thumbnails, fullImages);
	}

	public SCProductEntryService getWrappedSCProductEntryService() {
		return _scProductEntryService;
	}

	public void setWrappedSCProductEntryService(
		SCProductEntryService scProductEntryService) {
		_scProductEntryService = scProductEntryService;
	}

	private SCProductEntryService _scProductEntryService;
}