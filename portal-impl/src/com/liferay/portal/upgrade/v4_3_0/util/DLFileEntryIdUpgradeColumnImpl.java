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

package com.liferay.portal.upgrade.v4_3_0.util;

import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.upgrade.util.ValueMapperFactoryUtil;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileEntryIdUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public DLFileEntryIdUpgradeColumnImpl(
		UpgradeColumn companyIdColumn, UpgradeColumn folderIdColumn,
		UpgradeColumn nameColumn) {

		super("fileEntryId", false);

		_companyIdColumn = companyIdColumn;
		_folderIdColumn = folderIdColumn;
		_nameColumn = nameColumn;
		_dlFileEntryIdMapper = ValueMapperFactoryUtil.getValueMapper();
		_movedFolderIds = new HashSet<Long>();
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Object newValue = super.getNewValue(oldValue);

		String oldCompanyId = (String)_companyIdColumn.getOldValue();
		Long oldFolderId = (Long)_folderIdColumn.getOldValue();

		Long newCompanyId = (Long)_companyIdColumn.getNewValue();
		Long newFolderId = (Long)_folderIdColumn.getNewValue();

		String name = (String)_nameColumn.getOldValue();

		String oldPageIdValue =
			"{folderId=" + oldFolderId + ", name=" + name + "}";

		_dlFileEntryIdMapper.mapValue(oldPageIdValue, newValue);

		if (!_movedFolderIds.contains(oldFolderId)) {
			try {
				DLLocalServiceUtil.move(
					"/" + oldCompanyId + "/documentlibrary/" + oldFolderId,
					"/" + newCompanyId + "/documentlibrary/" + newFolderId);
			}
			catch (Exception e) {
				_log.error(e.getMessage());
			}

			_movedFolderIds.add(oldFolderId);
		}

		return newValue;
	}

	public ValueMapper getValueMapper() {
		return _dlFileEntryIdMapper;
	}

	private static Log _log = LogFactoryUtil.getLog(
		DLFileEntryIdUpgradeColumnImpl.class);

	private UpgradeColumn _companyIdColumn;
	private UpgradeColumn _folderIdColumn;
	private UpgradeColumn _nameColumn;
	private ValueMapper _dlFileEntryIdMapper;
	private Set<Long> _movedFolderIds;

}