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

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileRank;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileRankImpl extends DLFileRankModelImpl implements DLFileRank {

	public DLFileRankImpl() {
	}

	public DLFileEntry getFileEntry() throws PortalException, SystemException {
		return DLFileEntryLocalServiceUtil.getFileEntry(getFileEntryId());
	}

	/**
	 * @deprecated {@link #getFileEntry()}
	 */
	public long getFolderId() throws PortalException, SystemException {
		DLFileEntry fileEntry = getFileEntry();

		return fileEntry.getFolderId();
	}

	/**
	 * @deprecated {@link #getFileEntry()}
	 */
	public String getName() throws PortalException, SystemException {
		DLFileEntry fileEntry = getFileEntry();

		return fileEntry.getName();
	}

}