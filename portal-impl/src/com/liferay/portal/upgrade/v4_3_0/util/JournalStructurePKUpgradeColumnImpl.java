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

import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.upgrade.util.ValueMapperFactoryUtil;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class JournalStructurePKUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public JournalStructurePKUpgradeColumnImpl(
		UpgradeColumn companyIdColumn, UpgradeColumn groupIdColumn) {

		super("id_", new Integer(Types.VARCHAR), false);

		_companyIdColumn = companyIdColumn;
		_groupIdColumn = groupIdColumn;
		_journalStructureIdMapper = ValueMapperFactoryUtil.getValueMapper();
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Object newValue = super.getNewValue(oldValue);

		String companyId = (String)_companyIdColumn.getOldValue();
		Long groupId = (Long)_groupIdColumn.getOldValue();
		String structureId = (String)oldValue;

		String oldIdValue =
			"{companyId=" + companyId + ", groupId=" + groupId +
				", structureId=" + structureId + "}";

		_journalStructureIdMapper.mapValue(oldIdValue, newValue);

		return newValue;
	}

	public ValueMapper getValueMapper() {
		return _journalStructureIdMapper;
	}

	private UpgradeColumn _companyIdColumn;
	private UpgradeColumn _groupIdColumn;
	private ValueMapper _journalStructureIdMapper;

}