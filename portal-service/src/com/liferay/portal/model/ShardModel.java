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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Shard service. Represents a row in the &quot;Shard&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ShardModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ShardImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Shard
 * @see com.liferay.portal.model.impl.ShardImpl
 * @see com.liferay.portal.model.impl.ShardModelImpl
 * @generated
 */
public interface ShardModel extends BaseModel<Shard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a shard model instance should use the {@link Shard} interface instead.
	 */

	/**
	 * Gets the primary key of this shard.
	 *
	 * @return the primary key of this shard
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this shard
	 *
	 * @param pk the primary key of this shard
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the shard id of this shard.
	 *
	 * @return the shard id of this shard
	 */
	public long getShardId();

	/**
	 * Sets the shard id of this shard.
	 *
	 * @param shardId the shard id of this shard
	 */
	public void setShardId(long shardId);

	/**
	 * Gets the class name of the model instance this shard is polymorphically associated with.
	 *
	 * @return the class name of the model instance this shard is polymorphically associated with
	 */
	public String getClassName();

	/**
	 * Gets the class name id of this shard.
	 *
	 * @return the class name id of this shard
	 */
	public long getClassNameId();

	/**
	 * Sets the class name id of this shard.
	 *
	 * @param classNameId the class name id of this shard
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Gets the class p k of this shard.
	 *
	 * @return the class p k of this shard
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this shard.
	 *
	 * @param classPK the class p k of this shard
	 */
	public void setClassPK(long classPK);

	/**
	 * Gets the name of this shard.
	 *
	 * @return the name of this shard
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this shard.
	 *
	 * @param name the name of this shard
	 */
	public void setName(String name);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Shard shard);

	public int hashCode();

	public Shard toEscapedModel();

	public String toString();

	public String toXmlString();
}