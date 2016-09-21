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
 * This class is a wrapper for {@link ResourceService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ResourceService
 * @generated
 */
public class ResourceServiceWrapper implements ResourceService {
	public ResourceServiceWrapper(ResourceService resourceService) {
		_resourceService = resourceService;
	}

	public com.liferay.portal.model.Resource getResource(long companyId,
		java.lang.String name, int scope, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceService.getResource(companyId, name, scope, primKey);
	}

	public ResourceService getWrappedResourceService() {
		return _resourceService;
	}

	public void setWrappedResourceService(ResourceService resourceService) {
		_resourceService = resourceService;
	}

	private ResourceService _resourceService;
}