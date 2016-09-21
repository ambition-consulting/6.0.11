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

import com.liferay.portal.util.PropsValues;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.aop.TargetSource;

/**
 * @author Michael Young
 */
public class ShardDataSourceTargetSource implements TargetSource {

	public DataSource getDataSource() {
		return _dataSource.get();
	}

	public Object getTarget() throws Exception {
		return getDataSource();
	}

	public Class<DataSource> getTargetClass() {
		return DataSource.class;
	}

	public boolean isStatic() {
		return false;
	}

	public void releaseTarget(Object target) throws Exception {
	}

	public void setDataSource(String shardName) {
		_dataSource.set(_dataSources.get(shardName));
	}

	public void setDataSources(Map<String, DataSource> dataSources) {
		_dataSources = dataSources;
	}

	private static ThreadLocal<DataSource> _dataSource =
		new ThreadLocal<DataSource>() {

		protected DataSource initialValue() {
			return _dataSources.get(PropsValues.SHARD_DEFAULT_NAME);
		}

	};

	private static Map<String, DataSource> _dataSources;

}