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

package com.liferay.portlet.wiki.model;

/**
 * <p>
 * This class is a wrapper for {@link WikiNode}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WikiNode
 * @generated
 */
public class WikiNodeWrapper implements WikiNode {
	public WikiNodeWrapper(WikiNode wikiNode) {
		_wikiNode = wikiNode;
	}

	/**
	* Gets the primary key of this wiki node.
	*
	* @return the primary key of this wiki node
	*/
	public long getPrimaryKey() {
		return _wikiNode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this wiki node
	*
	* @param pk the primary key of this wiki node
	*/
	public void setPrimaryKey(long pk) {
		_wikiNode.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this wiki node.
	*
	* @return the uuid of this wiki node
	*/
	public java.lang.String getUuid() {
		return _wikiNode.getUuid();
	}

	/**
	* Sets the uuid of this wiki node.
	*
	* @param uuid the uuid of this wiki node
	*/
	public void setUuid(java.lang.String uuid) {
		_wikiNode.setUuid(uuid);
	}

	/**
	* Gets the node id of this wiki node.
	*
	* @return the node id of this wiki node
	*/
	public long getNodeId() {
		return _wikiNode.getNodeId();
	}

	/**
	* Sets the node id of this wiki node.
	*
	* @param nodeId the node id of this wiki node
	*/
	public void setNodeId(long nodeId) {
		_wikiNode.setNodeId(nodeId);
	}

	/**
	* Gets the group id of this wiki node.
	*
	* @return the group id of this wiki node
	*/
	public long getGroupId() {
		return _wikiNode.getGroupId();
	}

	/**
	* Sets the group id of this wiki node.
	*
	* @param groupId the group id of this wiki node
	*/
	public void setGroupId(long groupId) {
		_wikiNode.setGroupId(groupId);
	}

	/**
	* Gets the company id of this wiki node.
	*
	* @return the company id of this wiki node
	*/
	public long getCompanyId() {
		return _wikiNode.getCompanyId();
	}

	/**
	* Sets the company id of this wiki node.
	*
	* @param companyId the company id of this wiki node
	*/
	public void setCompanyId(long companyId) {
		_wikiNode.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this wiki node.
	*
	* @return the user id of this wiki node
	*/
	public long getUserId() {
		return _wikiNode.getUserId();
	}

	/**
	* Sets the user id of this wiki node.
	*
	* @param userId the user id of this wiki node
	*/
	public void setUserId(long userId) {
		_wikiNode.setUserId(userId);
	}

	/**
	* Gets the user uuid of this wiki node.
	*
	* @return the user uuid of this wiki node
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiNode.getUserUuid();
	}

	/**
	* Sets the user uuid of this wiki node.
	*
	* @param userUuid the user uuid of this wiki node
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_wikiNode.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this wiki node.
	*
	* @return the user name of this wiki node
	*/
	public java.lang.String getUserName() {
		return _wikiNode.getUserName();
	}

	/**
	* Sets the user name of this wiki node.
	*
	* @param userName the user name of this wiki node
	*/
	public void setUserName(java.lang.String userName) {
		_wikiNode.setUserName(userName);
	}

	/**
	* Gets the create date of this wiki node.
	*
	* @return the create date of this wiki node
	*/
	public java.util.Date getCreateDate() {
		return _wikiNode.getCreateDate();
	}

	/**
	* Sets the create date of this wiki node.
	*
	* @param createDate the create date of this wiki node
	*/
	public void setCreateDate(java.util.Date createDate) {
		_wikiNode.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this wiki node.
	*
	* @return the modified date of this wiki node
	*/
	public java.util.Date getModifiedDate() {
		return _wikiNode.getModifiedDate();
	}

	/**
	* Sets the modified date of this wiki node.
	*
	* @param modifiedDate the modified date of this wiki node
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wikiNode.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the name of this wiki node.
	*
	* @return the name of this wiki node
	*/
	public java.lang.String getName() {
		return _wikiNode.getName();
	}

	/**
	* Sets the name of this wiki node.
	*
	* @param name the name of this wiki node
	*/
	public void setName(java.lang.String name) {
		_wikiNode.setName(name);
	}

	/**
	* Gets the description of this wiki node.
	*
	* @return the description of this wiki node
	*/
	public java.lang.String getDescription() {
		return _wikiNode.getDescription();
	}

	/**
	* Sets the description of this wiki node.
	*
	* @param description the description of this wiki node
	*/
	public void setDescription(java.lang.String description) {
		_wikiNode.setDescription(description);
	}

	/**
	* Gets the last post date of this wiki node.
	*
	* @return the last post date of this wiki node
	*/
	public java.util.Date getLastPostDate() {
		return _wikiNode.getLastPostDate();
	}

	/**
	* Sets the last post date of this wiki node.
	*
	* @param lastPostDate the last post date of this wiki node
	*/
	public void setLastPostDate(java.util.Date lastPostDate) {
		_wikiNode.setLastPostDate(lastPostDate);
	}

	public boolean isNew() {
		return _wikiNode.isNew();
	}

	public void setNew(boolean n) {
		_wikiNode.setNew(n);
	}

	public boolean isCachedModel() {
		return _wikiNode.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wikiNode.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wikiNode.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_wikiNode.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wikiNode.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wikiNode.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wikiNode.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new WikiNodeWrapper((WikiNode)_wikiNode.clone());
	}

	public int compareTo(com.liferay.portlet.wiki.model.WikiNode wikiNode) {
		return _wikiNode.compareTo(wikiNode);
	}

	public int hashCode() {
		return _wikiNode.hashCode();
	}

	public com.liferay.portlet.wiki.model.WikiNode toEscapedModel() {
		return new WikiNodeWrapper(_wikiNode.toEscapedModel());
	}

	public java.lang.String toString() {
		return _wikiNode.toString();
	}

	public java.lang.String toXmlString() {
		return _wikiNode.toXmlString();
	}

	public WikiNode getWrappedWikiNode() {
		return _wikiNode;
	}

	private WikiNode _wikiNode;
}