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
public class PollsChoiceIdUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public PollsChoiceIdUpgradeColumnImpl(UpgradeColumn questionIdColumn) {
		super("choiceId", new Integer(Types.VARCHAR), false);

		_questionIdColumn = questionIdColumn;
		_pollsChoiceIdMapper = ValueMapperFactoryUtil.getValueMapper();
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Object newValue = super.getNewValue(oldValue);

		Long oldQuestionId = (Long)_questionIdColumn.getOldValue();

		String oldChoiceIdValue =
			"{questionId=" + oldQuestionId + ", choiceId=" + oldValue + "}";

		_pollsChoiceIdMapper.mapValue(oldChoiceIdValue, newValue);

		return newValue;
	}

	public ValueMapper getValueMapper() {
		return _pollsChoiceIdMapper;
	}

	private UpgradeColumn _questionIdColumn;
	private ValueMapper _pollsChoiceIdMapper;

}