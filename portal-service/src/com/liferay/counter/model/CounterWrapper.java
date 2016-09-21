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

package com.liferay.counter.model;

/**
 * <p>
 * This class is a wrapper for {@link Counter}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Counter
 * @generated
 */
public class CounterWrapper implements Counter {
	public CounterWrapper(Counter counter) {
		_counter = counter;
	}

	/**
	* Gets the primary key of this counter.
	*
	* @return the primary key of this counter
	*/
	public java.lang.String getPrimaryKey() {
		return _counter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this counter
	*
	* @param pk the primary key of this counter
	*/
	public void setPrimaryKey(java.lang.String pk) {
		_counter.setPrimaryKey(pk);
	}

	/**
	* Gets the name of this counter.
	*
	* @return the name of this counter
	*/
	public java.lang.String getName() {
		return _counter.getName();
	}

	/**
	* Sets the name of this counter.
	*
	* @param name the name of this counter
	*/
	public void setName(java.lang.String name) {
		_counter.setName(name);
	}

	/**
	* Gets the current id of this counter.
	*
	* @return the current id of this counter
	*/
	public long getCurrentId() {
		return _counter.getCurrentId();
	}

	/**
	* Sets the current id of this counter.
	*
	* @param currentId the current id of this counter
	*/
	public void setCurrentId(long currentId) {
		_counter.setCurrentId(currentId);
	}

	public boolean isNew() {
		return _counter.isNew();
	}

	public void setNew(boolean n) {
		_counter.setNew(n);
	}

	public boolean isCachedModel() {
		return _counter.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_counter.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _counter.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_counter.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _counter.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _counter.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_counter.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new CounterWrapper((Counter)_counter.clone());
	}

	public int compareTo(com.liferay.counter.model.Counter counter) {
		return _counter.compareTo(counter);
	}

	public int hashCode() {
		return _counter.hashCode();
	}

	public com.liferay.counter.model.Counter toEscapedModel() {
		return new CounterWrapper(_counter.toEscapedModel());
	}

	public java.lang.String toString() {
		return _counter.toString();
	}

	public java.lang.String toXmlString() {
		return _counter.toXmlString();
	}

	public Counter getWrappedCounter() {
		return _counter;
	}

	private Counter _counter;
}