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

package com.liferay.portal.events;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.upgrade.UpgradeProcessUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.verify.VerifyException;
import com.liferay.portal.verify.VerifyProcessUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class StartupHelper {

	public void setDropIndexes(boolean dropIndexes) {
		_dropIndexes = dropIndexes;
	}

	public void updateIndexes() {
		try {
			DB db = DBFactoryUtil.getDB();

			Thread currentThread = Thread.currentThread();

			ClassLoader classLoader = currentThread.getContextClassLoader();

			String tablesSQL = StringUtil.read(
				classLoader,
				"com/liferay/portal/tools/sql/dependencies/portal-tables.sql");

			String indexesSQL = StringUtil.read(
				classLoader,
				"com/liferay/portal/tools/sql/dependencies/indexes.sql");

			String indexesProperties = StringUtil.read(
				classLoader,
				"com/liferay/portal/tools/sql/dependencies/indexes.properties");

			db.updateIndexes(
				tablesSQL, indexesSQL, indexesProperties, _dropIndexes);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public void upgradeProcess(int buildNumber) throws UpgradeException {
		String[] upgradeProcessClassNames = PropsUtil.getArray(
			PropsKeys.UPGRADE_PROCESSES);

		_upgraded = UpgradeProcessUtil.upgradeProcess(
			buildNumber, upgradeProcessClassNames,
			PortalClassLoaderUtil.getClassLoader());
	}

	public void verifyProcess(boolean verified) throws VerifyException {
		_verified = VerifyProcessUtil.verifyProcess(_upgraded, verified);
	}

	public boolean isUpgraded() {
		return _upgraded;
	}

	public boolean isVerified() {
		return _verified;
	}

	private static Log _log = LogFactoryUtil.getLog(StartupHelper.class);

	private boolean _dropIndexes;
	private boolean _upgraded;
	private boolean _verified;

}