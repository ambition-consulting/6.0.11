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

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.dao.orm.CacheMode;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.ScrollableResults;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class QueryImpl implements Query {

	public QueryImpl(org.hibernate.Query query) {
		_query = query;
	}

	public int executeUpdate() throws ORMException {
		try {
			return _query.executeUpdate();
		}
		catch (Exception e) {
			throw ExceptionTranslator.translate(e);
		}
	}

	public Iterator<?> iterate() throws ORMException {
		return iterate(true);
	}

	public Iterator<?> iterate(boolean unmodifiable) throws ORMException {
		try {
			return list(unmodifiable).iterator();
		}
		catch (Exception e) {
			throw ExceptionTranslator.translate(e);
		}
	}

	public List<?> list() throws ORMException {
		return list(true);
	}

	public List<?> list(boolean unmodifiable) throws ORMException {
		try {
			List<?> list = _query.list();

			if (unmodifiable) {
				return new UnmodifiableList<Object>(list);
			}
			else {
				return ListUtil.copy(list);
			}
		}
		catch (Exception e) {
			throw ExceptionTranslator.translate(e);
		}
	}

	public ScrollableResults scroll() throws ORMException {
		try {
			return new ScrollableResultsImpl(_query.scroll());
		}
		catch (Exception e) {
			throw ExceptionTranslator.translate(e);
		}
	}

	public Query setBoolean(int pos, boolean value) {
		_query.setBoolean(pos, value);

		return this;
	}

	public Query setCacheable(boolean cacheable) {
		_query.setCacheable(cacheable);

		return this;
	}

	public Query setCacheMode(CacheMode cacheMode) {
		_query.setCacheMode(CacheModeTranslator.translate(cacheMode));

		return this;
	}

	public Query setCacheRegion(String cacheRegion) {
		_query.setCacheRegion(cacheRegion);

		return this;
	}

	public Query setDouble(int pos, double value) {
		_query.setDouble(pos, value);

		return this;
	}

	public Query setFirstResult(int firstResult) {
		_query.setFirstResult(firstResult);

		return this;
	}

	public Query setFloat(int pos, float value) {
		_query.setFloat(pos, value);

		return this;
	}

	public Query setInteger(int pos, int value) {
		_query.setInteger(pos, value);

		return this;
	}

	public Query setLong(int pos, long value) {
		_query.setLong(pos, value);

		return this;
	}

	public Query setMaxResults(int maxResults) {
		_query.setMaxResults(maxResults);

		return this;
	}

	public Query setSerializable(int pos, Serializable value) {
		_query.setSerializable(pos, value);

		return this;
	}

	public Query setShort(int pos, short value) {
		_query.setShort(pos, value);

		return this;
	}

	public Query setString(int pos, String value) {
		_query.setString(pos, value);

		return this;
	}

	public Query setTimestamp(int pos, Timestamp value) {
		_query.setTimestamp(pos, value);

		return this;
	}

	public Object uniqueResult() throws ORMException {
		try {
			return _query.uniqueResult();
		}
		catch (Exception e) {
			throw ExceptionTranslator.translate(e);
		}
	}

	private org.hibernate.Query _query;

}