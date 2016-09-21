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

package com.liferay.portlet.documentlibrary.service;

/**
 * <p>
 * This class is a wrapper for {@link DLFileVersionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DLFileVersionService
 * @generated
 */
public class DLFileVersionServiceWrapper implements DLFileVersionService {
	public DLFileVersionServiceWrapper(
		DLFileVersionService dlFileVersionService) {
		_dlFileVersionService = dlFileVersionService;
	}

	public com.liferay.portlet.documentlibrary.model.DLFileVersion updateDescription(
		long fileVersionId, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileVersionService.updateDescription(fileVersionId,
			description);
	}

	public DLFileVersionService getWrappedDLFileVersionService() {
		return _dlFileVersionService;
	}

	public void setWrappedDLFileVersionService(
		DLFileVersionService dlFileVersionService) {
		_dlFileVersionService = dlFileVersionService;
	}

	private DLFileVersionService _dlFileVersionService;
}