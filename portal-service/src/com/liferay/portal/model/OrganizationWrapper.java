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
 * This class is a wrapper for {@link Organization}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Organization
 * @generated
 */
public class OrganizationWrapper implements Organization {
	public OrganizationWrapper(Organization organization) {
		_organization = organization;
	}

	/**
	* Gets the primary key of this organization.
	*
	* @return the primary key of this organization
	*/
	public long getPrimaryKey() {
		return _organization.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organization
	*
	* @param pk the primary key of this organization
	*/
	public void setPrimaryKey(long pk) {
		_organization.setPrimaryKey(pk);
	}

	/**
	* Gets the organization id of this organization.
	*
	* @return the organization id of this organization
	*/
	public long getOrganizationId() {
		return _organization.getOrganizationId();
	}

	/**
	* Sets the organization id of this organization.
	*
	* @param organizationId the organization id of this organization
	*/
	public void setOrganizationId(long organizationId) {
		_organization.setOrganizationId(organizationId);
	}

	/**
	* Gets the company id of this organization.
	*
	* @return the company id of this organization
	*/
	public long getCompanyId() {
		return _organization.getCompanyId();
	}

	/**
	* Sets the company id of this organization.
	*
	* @param companyId the company id of this organization
	*/
	public void setCompanyId(long companyId) {
		_organization.setCompanyId(companyId);
	}

	/**
	* Gets the parent organization id of this organization.
	*
	* @return the parent organization id of this organization
	*/
	public long getParentOrganizationId() {
		return _organization.getParentOrganizationId();
	}

	/**
	* Sets the parent organization id of this organization.
	*
	* @param parentOrganizationId the parent organization id of this organization
	*/
	public void setParentOrganizationId(long parentOrganizationId) {
		_organization.setParentOrganizationId(parentOrganizationId);
	}

	/**
	* Gets the left organization id of this organization.
	*
	* @return the left organization id of this organization
	*/
	public long getLeftOrganizationId() {
		return _organization.getLeftOrganizationId();
	}

	/**
	* Sets the left organization id of this organization.
	*
	* @param leftOrganizationId the left organization id of this organization
	*/
	public void setLeftOrganizationId(long leftOrganizationId) {
		_organization.setLeftOrganizationId(leftOrganizationId);
	}

	/**
	* Gets the right organization id of this organization.
	*
	* @return the right organization id of this organization
	*/
	public long getRightOrganizationId() {
		return _organization.getRightOrganizationId();
	}

	/**
	* Sets the right organization id of this organization.
	*
	* @param rightOrganizationId the right organization id of this organization
	*/
	public void setRightOrganizationId(long rightOrganizationId) {
		_organization.setRightOrganizationId(rightOrganizationId);
	}

	/**
	* Gets the name of this organization.
	*
	* @return the name of this organization
	*/
	public java.lang.String getName() {
		return _organization.getName();
	}

	/**
	* Sets the name of this organization.
	*
	* @param name the name of this organization
	*/
	public void setName(java.lang.String name) {
		_organization.setName(name);
	}

	/**
	* Gets the type of this organization.
	*
	* @return the type of this organization
	*/
	public java.lang.String getType() {
		return _organization.getType();
	}

	/**
	* Sets the type of this organization.
	*
	* @param type the type of this organization
	*/
	public void setType(java.lang.String type) {
		_organization.setType(type);
	}

	/**
	* Gets the recursable of this organization.
	*
	* @return the recursable of this organization
	*/
	public boolean getRecursable() {
		return _organization.getRecursable();
	}

	/**
	* Determines if this organization is recursable.
	*
	* @return <code>true</code> if this organization is recursable; <code>false</code> otherwise
	*/
	public boolean isRecursable() {
		return _organization.isRecursable();
	}

	/**
	* Sets whether this organization is recursable.
	*
	* @param recursable the recursable of this organization
	*/
	public void setRecursable(boolean recursable) {
		_organization.setRecursable(recursable);
	}

	/**
	* Gets the region id of this organization.
	*
	* @return the region id of this organization
	*/
	public long getRegionId() {
		return _organization.getRegionId();
	}

	/**
	* Sets the region id of this organization.
	*
	* @param regionId the region id of this organization
	*/
	public void setRegionId(long regionId) {
		_organization.setRegionId(regionId);
	}

	/**
	* Gets the country id of this organization.
	*
	* @return the country id of this organization
	*/
	public long getCountryId() {
		return _organization.getCountryId();
	}

	/**
	* Sets the country id of this organization.
	*
	* @param countryId the country id of this organization
	*/
	public void setCountryId(long countryId) {
		_organization.setCountryId(countryId);
	}

	/**
	* Gets the status id of this organization.
	*
	* @return the status id of this organization
	*/
	public int getStatusId() {
		return _organization.getStatusId();
	}

	/**
	* Sets the status id of this organization.
	*
	* @param statusId the status id of this organization
	*/
	public void setStatusId(int statusId) {
		_organization.setStatusId(statusId);
	}

	/**
	* Gets the comments of this organization.
	*
	* @return the comments of this organization
	*/
	public java.lang.String getComments() {
		return _organization.getComments();
	}

	/**
	* Sets the comments of this organization.
	*
	* @param comments the comments of this organization
	*/
	public void setComments(java.lang.String comments) {
		_organization.setComments(comments);
	}

	public boolean isNew() {
		return _organization.isNew();
	}

	public void setNew(boolean n) {
		_organization.setNew(n);
	}

	public boolean isCachedModel() {
		return _organization.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_organization.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _organization.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_organization.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _organization.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organization.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organization.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new OrganizationWrapper((Organization)_organization.clone());
	}

	public int compareTo(com.liferay.portal.model.Organization organization) {
		return _organization.compareTo(organization);
	}

	public int hashCode() {
		return _organization.hashCode();
	}

	public com.liferay.portal.model.Organization toEscapedModel() {
		return new OrganizationWrapper(_organization.toEscapedModel());
	}

	public java.lang.String toString() {
		return _organization.toString();
	}

	public java.lang.String toXmlString() {
		return _organization.toXmlString();
	}

	public java.util.List<com.liferay.portal.model.Organization> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organization.getAncestors();
	}

	public com.liferay.portal.model.Organization getParentOrganization()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organization.getParentOrganization();
	}

	public com.liferay.portal.model.Address getAddress() {
		return _organization.getAddress();
	}

	public java.util.List<com.liferay.portal.model.Address> getAddresses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getAddresses();
	}

	public java.lang.String[] getChildrenTypes() {
		return _organization.getChildrenTypes();
	}

	public java.util.List<com.liferay.portal.model.Organization> getDescendants()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getDescendants();
	}

	public com.liferay.portal.model.Group getGroup() {
		return _organization.getGroup();
	}

	public long getLogoId() {
		return _organization.getLogoId();
	}

	public javax.portlet.PortletPreferences getPreferences()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getPreferences();
	}

	public int getPrivateLayoutsPageCount() {
		return _organization.getPrivateLayoutsPageCount();
	}

	public int getPublicLayoutsPageCount() {
		return _organization.getPublicLayoutsPageCount();
	}

	public java.util.Set<java.lang.String> getReminderQueryQuestions(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getReminderQueryQuestions(locale);
	}

	public java.util.Set<java.lang.String> getReminderQueryQuestions(
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getReminderQueryQuestions(languageId);
	}

	public java.util.List<com.liferay.portal.model.Organization> getSuborganizations()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getSuborganizations();
	}

	public int getSuborganizationsSize()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getSuborganizationsSize();
	}

	public int getTypeOrder() {
		return _organization.getTypeOrder();
	}

	public boolean hasPrivateLayouts() {
		return _organization.hasPrivateLayouts();
	}

	public boolean hasPublicLayouts() {
		return _organization.hasPublicLayouts();
	}

	public boolean hasSuborganizations()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.hasSuborganizations();
	}

	public boolean isParentable() {
		return _organization.isParentable();
	}

	public boolean isRoot() {
		return _organization.isRoot();
	}

	public Organization getWrappedOrganization() {
		return _organization;
	}

	private Organization _organization;
}