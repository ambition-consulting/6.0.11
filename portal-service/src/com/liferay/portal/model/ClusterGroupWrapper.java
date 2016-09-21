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
 * This class is a wrapper for {@link ClusterGroup}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ClusterGroup
 * @generated
 */
public class ClusterGroupWrapper implements ClusterGroup {
	public ClusterGroupWrapper(ClusterGroup clusterGroup) {
		_clusterGroup = clusterGroup;
	}

	/**
	* Gets the primary key of this cluster group.
	*
	* @return the primary key of this cluster group
	*/
	public long getPrimaryKey() {
		return _clusterGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cluster group
	*
	* @param pk the primary key of this cluster group
	*/
	public void setPrimaryKey(long pk) {
		_clusterGroup.setPrimaryKey(pk);
	}

	/**
	* Gets the cluster group id of this cluster group.
	*
	* @return the cluster group id of this cluster group
	*/
	public long getClusterGroupId() {
		return _clusterGroup.getClusterGroupId();
	}

	/**
	* Sets the cluster group id of this cluster group.
	*
	* @param clusterGroupId the cluster group id of this cluster group
	*/
	public void setClusterGroupId(long clusterGroupId) {
		_clusterGroup.setClusterGroupId(clusterGroupId);
	}

	/**
	* Gets the name of this cluster group.
	*
	* @return the name of this cluster group
	*/
	public java.lang.String getName() {
		return _clusterGroup.getName();
	}

	/**
	* Sets the name of this cluster group.
	*
	* @param name the name of this cluster group
	*/
	public void setName(java.lang.String name) {
		_clusterGroup.setName(name);
	}

	/**
	* Gets the cluster node ids of this cluster group.
	*
	* @return the cluster node ids of this cluster group
	*/
	public java.lang.String getClusterNodeIds() {
		return _clusterGroup.getClusterNodeIds();
	}

	/**
	* Sets the cluster node ids of this cluster group.
	*
	* @param clusterNodeIds the cluster node ids of this cluster group
	*/
	public void setClusterNodeIds(java.lang.String clusterNodeIds) {
		_clusterGroup.setClusterNodeIds(clusterNodeIds);
	}

	/**
	* Gets the whole cluster of this cluster group.
	*
	* @return the whole cluster of this cluster group
	*/
	public boolean getWholeCluster() {
		return _clusterGroup.getWholeCluster();
	}

	/**
	* Determines if this cluster group is whole cluster.
	*
	* @return <code>true</code> if this cluster group is whole cluster; <code>false</code> otherwise
	*/
	public boolean isWholeCluster() {
		return _clusterGroup.isWholeCluster();
	}

	/**
	* Sets whether this cluster group is whole cluster.
	*
	* @param wholeCluster the whole cluster of this cluster group
	*/
	public void setWholeCluster(boolean wholeCluster) {
		_clusterGroup.setWholeCluster(wholeCluster);
	}

	public boolean isNew() {
		return _clusterGroup.isNew();
	}

	public void setNew(boolean n) {
		_clusterGroup.setNew(n);
	}

	public boolean isCachedModel() {
		return _clusterGroup.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_clusterGroup.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _clusterGroup.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_clusterGroup.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _clusterGroup.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clusterGroup.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clusterGroup.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ClusterGroupWrapper((ClusterGroup)_clusterGroup.clone());
	}

	public int compareTo(com.liferay.portal.model.ClusterGroup clusterGroup) {
		return _clusterGroup.compareTo(clusterGroup);
	}

	public int hashCode() {
		return _clusterGroup.hashCode();
	}

	public com.liferay.portal.model.ClusterGroup toEscapedModel() {
		return new ClusterGroupWrapper(_clusterGroup.toEscapedModel());
	}

	public java.lang.String toString() {
		return _clusterGroup.toString();
	}

	public java.lang.String toXmlString() {
		return _clusterGroup.toXmlString();
	}

	public java.lang.String[] getClusterNodeIdsArray() {
		return _clusterGroup.getClusterNodeIdsArray();
	}

	public ClusterGroup getWrappedClusterGroup() {
		return _clusterGroup;
	}

	private ClusterGroup _clusterGroup;
}