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

import org.hibernate.SessionFactory;

import org.springframework.aop.TargetSource;

/**
 * @author Michael Young
 */
public class ShardSessionFactoryTargetSource implements TargetSource {

	public SessionFactory getSessionFactory() {
		return _sessionFactory.get();
	}

	public Object getTarget() throws Exception {
		return getSessionFactory();
	}

	public Class<?> getTargetClass() {
		return _sessionFactories.get(PropsValues.SHARD_DEFAULT_NAME).getClass();
	}

	public boolean isStatic() {
		return false;
	}

	public void releaseTarget(Object target) throws Exception {
	}

	public void setSessionFactory(String shardName) {
		_sessionFactory.set(_sessionFactories.get(shardName));
	}

	public void setSessionFactories(
		Map<String, SessionFactory> sessionFactories) {

		_sessionFactories = sessionFactories;
	}

	private static ThreadLocal<SessionFactory> _sessionFactory =
		new ThreadLocal<SessionFactory>() {

		protected SessionFactory initialValue() {
			return _sessionFactories.get(PropsValues.SHARD_DEFAULT_NAME);
		}

	};

	private static Map<String, SessionFactory> _sessionFactories;

}