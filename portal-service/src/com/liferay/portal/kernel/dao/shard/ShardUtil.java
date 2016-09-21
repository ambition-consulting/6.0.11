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

package com.liferay.portal.kernel.dao.shard;

import javax.sql.DataSource;

/**
 * @author Alexander Chow
 */
public class ShardUtil {

	public static String getCurrentShardName() {
		if (_shard != null) {
			return _shard.getCurrentShardName();
		}

		return null;
	}

	public static DataSource getDataSource() {
		if (_shard != null) {
			return _shard.getDataSource();
		}

		return null;
	}

	public static boolean isEnabled() {
		if (_shard != null) {
			return _shard.isEnabled();
		}

		return false;
	}

	public static String popCompanyService() {
		String value = null;

		if (_shard != null) {
			value = _shard.popCompanyService();
		}

		return value;
	}

	public static void pushCompanyService(long companyId) {
		if (_shard != null) {
			_shard.pushCompanyService(companyId);
		}
	}

	public static void pushCompanyService(String shardName) {
		if (_shard != null) {
			_shard.pushCompanyService(shardName);
		}
	}

	public void setShard(Shard shard) {
		_shard = shard;
	}

	private static Shard _shard;

}