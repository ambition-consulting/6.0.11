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

package com.liferay.portal.upgrade.v4_3_4.util;

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Alexander Chow
 */
public class JournalArticleContentUpgradeColumnImpl
	extends BaseUpgradeColumnImpl {

	public JournalArticleContentUpgradeColumnImpl(
		UpgradeColumn structureIdColumn) {

		super("content");

		_structureIdColumn = structureIdColumn;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String oldContent = (String)oldValue;

		String newContent = oldContent;

		String structureId = (String)_structureIdColumn.getOldValue();

		if (Validator.isNull(structureId)) {
			if (Validator.isNotNull(oldContent) &&
				(oldContent.indexOf("<static-content") == -1)) {

				String defaultLanguageId = LocaleUtil.toLanguageId(
					LocaleUtil.getDefault());

				newContent = LocalizationUtil.updateLocalization(
					StringPool.BLANK, "static-content", oldContent,
					defaultLanguageId, defaultLanguageId, true);
			}
		}

		return newContent;
	}

	private UpgradeColumn _structureIdColumn;

}