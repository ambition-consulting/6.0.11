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
 * This class is a wrapper for {@link SCFrameworkVersionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SCFrameworkVersionService
 * @generated
 */
public class SCFrameworkVersionServiceWrapper
	implements SCFrameworkVersionService {
	public SCFrameworkVersionServiceWrapper(
		SCFrameworkVersionService scFrameworkVersionService) {
		_scFrameworkVersionService = scFrameworkVersionService;
	}

	public com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion addFrameworkVersion(
		java.lang.String name, java.lang.String url, boolean active,
		int priority, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scFrameworkVersionService.addFrameworkVersion(name, url,
			active, priority, serviceContext);
	}

	public void deleteFrameworkVersion(long frameworkVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_scFrameworkVersionService.deleteFrameworkVersion(frameworkVersionId);
	}

	public com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion getFrameworkVersion(
		long frameworkVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scFrameworkVersionService.getFrameworkVersion(frameworkVersionId);
	}

	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion> getFrameworkVersions(
		long groupId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scFrameworkVersionService.getFrameworkVersions(groupId, active);
	}

	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion> getFrameworkVersions(
		long groupId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scFrameworkVersionService.getFrameworkVersions(groupId, active,
			start, end);
	}

	public com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion updateFrameworkVersion(
		long frameworkVersionId, java.lang.String name, java.lang.String url,
		boolean active, int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scFrameworkVersionService.updateFrameworkVersion(frameworkVersionId,
			name, url, active, priority);
	}

	public SCFrameworkVersionService getWrappedSCFrameworkVersionService() {
		return _scFrameworkVersionService;
	}

	public void setWrappedSCFrameworkVersionService(
		SCFrameworkVersionService scFrameworkVersionService) {
		_scFrameworkVersionService = scFrameworkVersionService;
	}

	private SCFrameworkVersionService _scFrameworkVersionService;
}