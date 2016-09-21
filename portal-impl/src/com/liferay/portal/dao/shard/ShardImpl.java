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

package com.liferay.portal.dao.shard;

import com.liferay.portal.kernel.dao.shard.Shard;

import javax.sql.DataSource;

/**
 * @author Alexander Chow
 */
public class ShardImpl implements Shard {

	public String getCurrentShardName() {
		return _shardAdvice.getCurrentShardName();
	}

	public DataSource getDataSource() {
		return _shardAdvice.getDataSource();
	}

	public boolean isEnabled() {
		if (_shardAdvice != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public String popCompanyService() {
		String value = null;

		if (_shardAdvice != null) {
			value = _shardAdvice.popCompanyService();
		}

		return value;
	}

	public void pushCompanyService(long companyId) {
		if (_shardAdvice != null) {
			_shardAdvice.pushCompanyService(companyId);
		}
	}

	public void pushCompanyService(String shardName) {
		if (_shardAdvice != null) {
			_shardAdvice.pushCompanyService(shardName);
		}
	}

	public void setShardAdvice(ShardAdvice shardAdvice) {
		_shardAdvice = shardAdvice;
	}

	private static ShardAdvice _shardAdvice;

}