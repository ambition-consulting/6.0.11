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

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;

/**
 * @author Brian Wing Shun Chan
 */
public class JournalTemplateSmallImageIdUpgradeColumnImpl
	extends BaseUpgradeColumnImpl {

	public JournalTemplateSmallImageIdUpgradeColumnImpl(
		UpgradeColumn companyIdColumn, UpgradeColumn groupIdColumn,
		UpgradeColumn templateIdColumn, ValueMapper imageIdMapper) {

		super("smallImageId");

		_companyIdColumn = companyIdColumn;
		_groupIdColumn = groupIdColumn;
		_templateIdColumn = templateIdColumn;
		_imageIdMapper = imageIdMapper;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String companyId = (String)_companyIdColumn.getOldValue();
		Long groupId = (Long)_groupIdColumn.getOldValue();
		String oldTemplateId = (String)_templateIdColumn.getOldValue();

		String oldImageId =
			companyId + ".journal.template." + groupId + "." + oldTemplateId +
				".small";

		return _imageIdMapper.getNewValue(oldImageId);
	}

	private UpgradeColumn _companyIdColumn;
	private UpgradeColumn _groupIdColumn;
	private UpgradeColumn _templateIdColumn;
	private ValueMapper _imageIdMapper;

}