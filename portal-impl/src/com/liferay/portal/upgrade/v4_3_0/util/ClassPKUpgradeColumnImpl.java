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

import com.liferay.portal.kernel.upgrade.util.TempUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.util.GetterUtil;

import java.sql.Types;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassPKUpgradeColumnImpl extends TempUpgradeColumnImpl {

	public ClassPKUpgradeColumnImpl(
		ClassNameIdUpgradeColumnImpl classNameIdColumn,
		Map<Long, ClassPKContainer> classPKContainers) {

		super("classPK", new Integer(Types.VARCHAR));

		_classNameIdColumn = classNameIdColumn;
		_classPKContainers = classPKContainers;
	}

	public Integer getNewColumnType(Integer defaultType) {
		return new Integer(Types.BIGINT);
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Long classNameId = (Long)_classNameIdColumn.getNewValue();

		ClassPKContainer classPKContainer = _classPKContainers.get(classNameId);

		if (classPKContainer != null) {
			ValueMapper valueMapper = classPKContainer.getValueMapper();

			if (classPKContainer.isLong()) {
				return valueMapper.getNewValue(
					new Long(GetterUtil.getLong((String)oldValue)));
			}
			else {
				return valueMapper.getNewValue(oldValue);
			}
		}
		else {
			if (oldValue instanceof String) {
				return new Long(GetterUtil.getLong((String)oldValue));
			}
			else {
				return oldValue;
			}
		}
	}

	private ClassNameIdUpgradeColumnImpl _classNameIdColumn;
	private Map<Long, ClassPKContainer> _classPKContainers;

}