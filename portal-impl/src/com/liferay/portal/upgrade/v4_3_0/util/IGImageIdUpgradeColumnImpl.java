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

/**
 * @author Brian Wing Shun Chan
 */
public class IGImageIdUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public IGImageIdUpgradeColumnImpl(UpgradeColumn companyIdColumn) {
		super("imageId", false);

		_companyIdColumn = companyIdColumn;
		_igImageIdMapper = ValueMapperFactoryUtil.getValueMapper();
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Object newValue = super.getNewValue(oldValue);

		String companyId = (String)_companyIdColumn.getOldValue();
		Long imageId = (Long)oldValue;

		String oldImageIdValue =
			"{companyId=" + companyId + ", imageId=" + imageId + "}";

		_igImageIdMapper.mapValue(oldImageIdValue, newValue);

		return newValue;
	}

	public ValueMapper getValueMapper() {
		return _igImageIdMapper;
	}

	private UpgradeColumn _companyIdColumn;
	private ValueMapper _igImageIdMapper;

}