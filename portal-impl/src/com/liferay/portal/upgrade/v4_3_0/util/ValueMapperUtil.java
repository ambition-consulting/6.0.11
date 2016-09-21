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

import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.util.SystemProperties;

/**
 * @author Brian Wing Shun Chan
 */
public class ValueMapperUtil {

	public static void persist(ValueMapper valueMapper, String fileName)
		throws Exception {

		String tmpDir = SystemProperties.get(SystemProperties.TMP_DIR);

		tmpDir += "/com/liferay/portal/upgrade/v4_3_0/ValueMapperUtil";

		com.liferay.portal.kernel.upgrade.util.ValueMapperUtil.persist(
			valueMapper, tmpDir, fileName);
	}

}