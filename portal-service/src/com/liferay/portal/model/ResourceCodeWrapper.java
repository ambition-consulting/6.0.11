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
 * This class is a wrapper for {@link ResourceCode}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ResourceCode
 * @generated
 */
public class ResourceCodeWrapper implements ResourceCode {
	public ResourceCodeWrapper(ResourceCode resourceCode) {
		_resourceCode = resourceCode;
	}

	/**
	* Gets the primary key of this resource code.
	*
	* @return the primary key of this resource code
	*/
	public long getPrimaryKey() {
		return _resourceCode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this resource code
	*
	* @param pk the primary key of this resource code
	*/
	public void setPrimaryKey(long pk) {
		_resourceCode.setPrimaryKey(pk);
	}

	/**
	* Gets the code id of this resource code.
	*
	* @return the code id of this resource code
	*/
	public long getCodeId() {
		return _resourceCode.getCodeId();
	}

	/**
	* Sets the code id of this resource code.
	*
	* @param codeId the code id of this resource code
	*/
	public void setCodeId(long codeId) {
		_resourceCode.setCodeId(codeId);
	}

	/**
	* Gets the company id of this resource code.
	*
	* @return the company id of this resource code
	*/
	public long getCompanyId() {
		return _resourceCode.getCompanyId();
	}

	/**
	* Sets the company id of this resource code.
	*
	* @param companyId the company id of this resource code
	*/
	public void setCompanyId(long companyId) {
		_resourceCode.setCompanyId(companyId);
	}

	/**
	* Gets the name of this resource code.
	*
	* @return the name of this resource code
	*/
	public java.lang.String getName() {
		return _resourceCode.getName();
	}

	/**
	* Sets the name of this resource code.
	*
	* @param name the name of this resource code
	*/
	public void setName(java.lang.String name) {
		_resourceCode.setName(name);
	}

	/**
	* Gets the scope of this resource code.
	*
	* @return the scope of this resource code
	*/
	public int getScope() {
		return _resourceCode.getScope();
	}

	/**
	* Sets the scope of this resource code.
	*
	* @param scope the scope of this resource code
	*/
	public void setScope(int scope) {
		_resourceCode.setScope(scope);
	}

	public boolean isNew() {
		return _resourceCode.isNew();
	}

	public void setNew(boolean n) {
		_resourceCode.setNew(n);
	}

	public boolean isCachedModel() {
		return _resourceCode.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_resourceCode.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _resourceCode.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_resourceCode.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _resourceCode.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resourceCode.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resourceCode.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ResourceCodeWrapper((ResourceCode)_resourceCode.clone());
	}

	public int compareTo(com.liferay.portal.model.ResourceCode resourceCode) {
		return _resourceCode.compareTo(resourceCode);
	}

	public int hashCode() {
		return _resourceCode.hashCode();
	}

	public com.liferay.portal.model.ResourceCode toEscapedModel() {
		return new ResourceCodeWrapper(_resourceCode.toEscapedModel());
	}

	public java.lang.String toString() {
		return _resourceCode.toString();
	}

	public java.lang.String toXmlString() {
		return _resourceCode.toXmlString();
	}

	public ResourceCode getWrappedResourceCode() {
		return _resourceCode;
	}

	private ResourceCode _resourceCode;
}