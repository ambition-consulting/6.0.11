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

package com.liferay.portal.upgrade.v4_4_0.util;

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Set;

/**
 * @author Alexander Chow
 */
public class DLFileEntryTitleColumnImpl extends BaseUpgradeColumnImpl {

	public DLFileEntryTitleColumnImpl(
		UpgradeColumn groupIdColumn, UpgradeColumn folderIdColumn,
		UpgradeColumn nameColumn, Set<String> distinctTitles) {

		super("title", null);

		_groupIdColumn = groupIdColumn;
		_folderIdColumn = folderIdColumn;
		_nameColumn = nameColumn;
		_distinctTitles = distinctTitles;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String newTitle = (String)oldValue;

		String name = (String)_nameColumn.getOldValue();
		String extension = FileUtil.getExtension(name);

		newTitle = _stripExtension(name, newTitle);

		while (_distinctTitles.contains(_getKey(newTitle, extension))) {
			_counter++;

			newTitle = newTitle.concat(StringPool.SPACE).concat(
				String.valueOf(_counter));
		}

		_distinctTitles.add(_getKey(newTitle, extension));

		return newTitle;
	}

	private String _getKey(String title, String extension) {
		StringBundler sb = new StringBundler();

		sb.append(_groupIdColumn.getOldValue());
		sb.append(StringPool.UNDERLINE);
		sb.append(_folderIdColumn.getOldValue());
		sb.append(StringPool.UNDERLINE);
		sb.append(title);

		if (Validator.isNotNull(extension)) {
			sb.append(StringPool.PERIOD);
			sb.append(extension);
		}

		return sb.toString();
	}

	private String _stripExtension(String name, String title) {
		String extension = FileUtil.getExtension(name);

		if (Validator.isNull(extension)) {
			return title;
		}

		int pos = title.toLowerCase().lastIndexOf(
			StringPool.PERIOD + extension);

		if (pos > 0) {
			title = title.substring(0, pos);
		}

		return title;
	}

	private UpgradeColumn _groupIdColumn;
	private UpgradeColumn _folderIdColumn;
	private UpgradeColumn _nameColumn;
	private int _counter = 0;
	private Set<String> _distinctTitles;

}