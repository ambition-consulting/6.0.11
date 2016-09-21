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

package com.liferay.portal.model;

/**
 * <p>
 * This class is a wrapper for {@link Shard}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Shard
 * @generated
 */
public class ShardWrapper implements Shard {
	public ShardWrapper(Shard shard) {
		_shard = shard;
	}

	/**
	* Gets the primary key of this shard.
	*
	* @return the primary key of this shard
	*/
	public long getPrimaryKey() {
		return _shard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shard
	*
	* @param pk the primary key of this shard
	*/
	public void setPrimaryKey(long pk) {
		_shard.setPrimaryKey(pk);
	}

	/**
	* Gets the shard id of this shard.
	*
	* @return the shard id of this shard
	*/
	public long getShardId() {
		return _shard.getShardId();
	}

	/**
	* Sets the shard id of this shard.
	*
	* @param shardId the shard id of this shard
	*/
	public void setShardId(long shardId) {
		_shard.setShardId(shardId);
	}

	/**
	* Gets the class name of the model instance this shard is polymorphically associated with.
	*
	* @return the class name of the model instance this shard is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _shard.getClassName();
	}

	/**
	* Gets the class name id of this shard.
	*
	* @return the class name id of this shard
	*/
	public long getClassNameId() {
		return _shard.getClassNameId();
	}

	/**
	* Sets the class name id of this shard.
	*
	* @param classNameId the class name id of this shard
	*/
	public void setClassNameId(long classNameId) {
		_shard.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this shard.
	*
	* @return the class p k of this shard
	*/
	public long getClassPK() {
		return _shard.getClassPK();
	}

	/**
	* Sets the class p k of this shard.
	*
	* @param classPK the class p k of this shard
	*/
	public void setClassPK(long classPK) {
		_shard.setClassPK(classPK);
	}

	/**
	* Gets the name of this shard.
	*
	* @return the name of this shard
	*/
	public java.lang.String getName() {
		return _shard.getName();
	}

	/**
	* Sets the name of this shard.
	*
	* @param name the name of this shard
	*/
	public void setName(java.lang.String name) {
		_shard.setName(name);
	}

	public boolean isNew() {
		return _shard.isNew();
	}

	public void setNew(boolean n) {
		_shard.setNew(n);
	}

	public boolean isCachedModel() {
		return _shard.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shard.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shard.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shard.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shard.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shard.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shard.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ShardWrapper((Shard)_shard.clone());
	}

	public int compareTo(com.liferay.portal.model.Shard shard) {
		return _shard.compareTo(shard);
	}

	public int hashCode() {
		return _shard.hashCode();
	}

	public com.liferay.portal.model.Shard toEscapedModel() {
		return new ShardWrapper(_shard.toEscapedModel());
	}

	public java.lang.String toString() {
		return _shard.toString();
	}

	public java.lang.String toXmlString() {
		return _shard.toXmlString();
	}

	public Shard getWrappedShard() {
		return _shard;
	}

	private Shard _shard;
}