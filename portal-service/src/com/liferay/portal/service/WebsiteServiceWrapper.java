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
 * This class is a wrapper for {@link WebsiteService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WebsiteService
 * @generated
 */
public class WebsiteServiceWrapper implements WebsiteService {
	public WebsiteServiceWrapper(WebsiteService websiteService) {
		_websiteService = websiteService;
	}

	public com.liferay.portal.model.Website addWebsite(
		java.lang.String className, long classPK, java.lang.String url,
		int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _websiteService.addWebsite(className, classPK, url, typeId,
			primary);
	}

	public void deleteWebsite(long websiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_websiteService.deleteWebsite(websiteId);
	}

	public com.liferay.portal.model.Website getWebsite(long websiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _websiteService.getWebsite(websiteId);
	}

	public java.util.List<com.liferay.portal.model.Website> getWebsites(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _websiteService.getWebsites(className, classPK);
	}

	public com.liferay.portal.model.Website updateWebsite(long websiteId,
		java.lang.String url, int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _websiteService.updateWebsite(websiteId, url, typeId, primary);
	}

	public WebsiteService getWrappedWebsiteService() {
		return _websiteService;
	}

	public void setWrappedWebsiteService(WebsiteService websiteService) {
		_websiteService = websiteService;
	}

	private WebsiteService _websiteService;
}