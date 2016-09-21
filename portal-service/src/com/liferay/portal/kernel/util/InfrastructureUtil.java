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

package com.liferay.portal.kernel.util;

import javax.mail.Session;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Young
 */
public class InfrastructureUtil {

	public static DataSource getDataSource() {
		return _dataSource;
	}

	public static Object getDynamicDataSourceTargetSource() {
		return _dynamicDataSourceTargetSource;
	}

	public static Session getMailSession() {
		return _mailSession;
	}

	public static Object getShardDataSourceTargetSource() {
		return _shardDataSourceTargetSource;
	}

	public static Object getShardSessionFactoryTargetSource() {
		return _shardSessionFactoryTargetSource;
	}

	public static Object getTransactionManager() {
		return _transactionManager;
	}

	public void setDataSource(DataSource dataSource) {
		_dataSource = dataSource;
	}

	public void setDynamicDataSourceTargetSource(
		Object dynamicDataSourceTargetSource) {

		_dynamicDataSourceTargetSource = dynamicDataSourceTargetSource;
	}

	public void setMailSession(Session mailSession) {
		_mailSession = mailSession;
	}

	public void setShardDataSourceTargetSource(
		Object shardDataSourceTargetSource) {

		_shardDataSourceTargetSource = shardDataSourceTargetSource;
	}

	public void setShardSessionFactoryTargetSource(
		Object shardSessionFactoryTargetSource) {

		_shardSessionFactoryTargetSource = shardSessionFactoryTargetSource;
	}

	public void setTransactionManager(Object transactionManager) {
		_transactionManager = transactionManager;
	}

	private static DataSource _dataSource;
	private static Object _dynamicDataSourceTargetSource;
	private static Session _mailSession;
	private static Object _shardDataSourceTargetSource;
	private static Object _shardSessionFactoryTargetSource;
	private static Object _transactionManager;

}