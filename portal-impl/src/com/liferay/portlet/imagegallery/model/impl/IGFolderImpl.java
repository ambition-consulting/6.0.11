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

package com.liferay.portlet.imagegallery.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGFolderConstants;
import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class IGFolderImpl extends IGFolderModelImpl implements IGFolder {

	public IGFolderImpl() {
	}

	public List<IGFolder> getAncestors()
		throws PortalException, SystemException {

		List<IGFolder> ancestors = new ArrayList<IGFolder>();

		IGFolder folder = this;

		while (true) {
			if (!folder.isRoot()) {
				folder = folder.getParentFolder();

				ancestors.add(folder);
			}
			else {
				break;
			}
		}

		return ancestors;
	}

	public IGFolder getParentFolder()
		throws PortalException, SystemException {

		if (getParentFolderId() == IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return null;
		}

		return IGFolderLocalServiceUtil.getFolder(getParentFolderId());
	}

	public boolean isRoot() {
		if (getParentFolderId() == IGFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return true;
		}
		else {
			return false;
		}
	}

}