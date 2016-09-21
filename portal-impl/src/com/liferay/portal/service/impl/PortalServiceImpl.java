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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.service.base.PortalServiceBaseImpl;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalServiceImpl extends PortalServiceBaseImpl {

	public String getAutoDeployDirectory() throws SystemException {
		return PrefsPropsUtil.getString(
			PropsKeys.AUTO_DEPLOY_DEPLOY_DIR,
			PropsValues.AUTO_DEPLOY_DEPLOY_DIR);
	}

	public int getBuildNumber() {
		return ReleaseInfo.getBuildNumber();
	}

	public void test() {
		long userId = 0;

		try {
			userId = getUserId();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		if (_log.isInfoEnabled()) {
			_log.info("User id " + userId);
		}
	}

	public void testCounterRollback() throws SystemException {
		int counterIncrement = PropsValues.COUNTER_INCREMENT;

		for (int i = 0; i < counterIncrement * 2; i++) {
			counterLocalService.increment();
		}

		throw new SystemException();
	}

	private static Log _log = LogFactoryUtil.getLog(PortalServiceImpl.class);

}