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
 * This class is a wrapper for {@link WikiPageResource}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WikiPageResource
 * @generated
 */
public class WikiPageResourceWrapper implements WikiPageResource {
	public WikiPageResourceWrapper(WikiPageResource wikiPageResource) {
		_wikiPageResource = wikiPageResource;
	}

	/**
	* Gets the primary key of this wiki page resource.
	*
	* @return the primary key of this wiki page resource
	*/
	public long getPrimaryKey() {
		return _wikiPageResource.getPrimaryKey();
	}

	/**
	* Sets the primary key of this wiki page resource
	*
	* @param pk the primary key of this wiki page resource
	*/
	public void setPrimaryKey(long pk) {
		_wikiPageResource.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this wiki page resource.
	*
	* @return the uuid of this wiki page resource
	*/
	public java.lang.String getUuid() {
		return _wikiPageResource.getUuid();
	}

	/**
	* Sets the uuid of this wiki page resource.
	*
	* @param uuid the uuid of this wiki page resource
	*/
	public void setUuid(java.lang.String uuid) {
		_wikiPageResource.setUuid(uuid);
	}

	/**
	* Gets the resource prim key of this wiki page resource.
	*
	* @return the resource prim key of this wiki page resource
	*/
	public long getResourcePrimKey() {
		return _wikiPageResource.getResourcePrimKey();
	}

	/**
	* Sets the resource prim key of this wiki page resource.
	*
	* @param resourcePrimKey the resource prim key of this wiki page resource
	*/
	public void setResourcePrimKey(long resourcePrimKey) {
		_wikiPageResource.setResourcePrimKey(resourcePrimKey);
	}

	/**
	* Gets the node id of this wiki page resource.
	*
	* @return the node id of this wiki page resource
	*/
	public long getNodeId() {
		return _wikiPageResource.getNodeId();
	}

	/**
	* Sets the node id of this wiki page resource.
	*
	* @param nodeId the node id of this wiki page resource
	*/
	public void setNodeId(long nodeId) {
		_wikiPageResource.setNodeId(nodeId);
	}

	/**
	* Gets the title of this wiki page resource.
	*
	* @return the title of this wiki page resource
	*/
	public java.lang.String getTitle() {
		return _wikiPageResource.getTitle();
	}

	/**
	* Sets the title of this wiki page resource.
	*
	* @param title the title of this wiki page resource
	*/
	public void setTitle(java.lang.String title) {
		_wikiPageResource.setTitle(title);
	}

	public boolean isNew() {
		return _wikiPageResource.isNew();
	}

	public void setNew(boolean n) {
		_wikiPageResource.setNew(n);
	}

	public boolean isCachedModel() {
		return _wikiPageResource.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wikiPageResource.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wikiPageResource.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_wikiPageResource.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wikiPageResource.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wikiPageResource.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wikiPageResource.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new WikiPageResourceWrapper((WikiPageResource)_wikiPageResource.clone());
	}

	public int compareTo(
		com.liferay.portlet.wiki.model.WikiPageResource wikiPageResource) {
		return _wikiPageResource.compareTo(wikiPageResource);
	}

	public int hashCode() {
		return _wikiPageResource.hashCode();
	}

	public com.liferay.portlet.wiki.model.WikiPageResource toEscapedModel() {
		return new WikiPageResourceWrapper(_wikiPageResource.toEscapedModel());
	}

	public java.lang.String toString() {
		return _wikiPageResource.toString();
	}

	public java.lang.String toXmlString() {
		return _wikiPageResource.toXmlString();
	}

	public WikiPageResource getWrappedWikiPageResource() {
		return _wikiPageResource;
	}

	private WikiPageResource _wikiPageResource;
}