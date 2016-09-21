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

package com.liferay.portlet.documentlibrary.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.base.DLFileVersionServiceBaseImpl;
import com.liferay.portlet.documentlibrary.service.permission.DLFileEntryPermission;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileVersionServiceImpl extends DLFileVersionServiceBaseImpl {

	public DLFileVersion updateDescription(
			long fileVersionId, String description)
		throws PortalException, SystemException {

		DLFileVersion fileVersion = dlFileVersionPersistence.findByPrimaryKey(
			fileVersionId);

		DLFileEntryPermission.check(
			getPermissionChecker(), fileVersion.getFileEntryId(),
			ActionKeys.UPDATE);

		return dlFileVersionLocalService.updateDescription(
			fileVersionId, description);
	}

}