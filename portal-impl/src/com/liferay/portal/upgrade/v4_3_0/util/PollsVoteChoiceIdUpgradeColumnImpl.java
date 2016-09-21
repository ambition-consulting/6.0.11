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

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsVoteChoiceIdUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public PollsVoteChoiceIdUpgradeColumnImpl(
		UpgradeColumn questionIdColumn, ValueMapper pollsChoiceIdMapper) {

		super("choiceId", new Integer(Types.VARCHAR));

		_questionIdColumn = questionIdColumn;
		_pollsChoiceIdMapper = pollsChoiceIdMapper;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Long oldQuestionId = (Long)_questionIdColumn.getOldValue();

		String oldChoiceIdValue =
			"{questionId=" + oldQuestionId + ", choiceId=" + oldValue + "}";

		return _pollsChoiceIdMapper.getNewValue(oldChoiceIdValue);
	}

	private UpgradeColumn _questionIdColumn;
	private ValueMapper _pollsChoiceIdMapper;

}