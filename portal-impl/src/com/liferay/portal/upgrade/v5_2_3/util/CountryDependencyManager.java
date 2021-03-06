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

package com.liferay.portal.upgrade.v5_2_3.util;

/**
 * @author Brian Wing Shun Chan
 */
public class CountryDependencyManager extends DependencyManager {

	public void update(
			long oldPrimaryKeyValue, Object[] oldColumnValues,
			Object[] oldExtraColumnValues, long newPrimaryKeyValue,
			Object[] newColumnValues, Object[] newExtraColumnValues)
		throws Exception {

		updateDuplicateData("Address", oldPrimaryKeyValue, newPrimaryKeyValue);
		updateDuplicateData(
			"Organization_", oldPrimaryKeyValue, newPrimaryKeyValue);
		updateDuplicateData("Region", oldPrimaryKeyValue, newPrimaryKeyValue);
	}

}