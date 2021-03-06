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
 * This class is a wrapper for {@link Company}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Company
 * @generated
 */
public class CompanyWrapper implements Company {
	public CompanyWrapper(Company company) {
		_company = company;
	}

	/**
	* Gets the primary key of this company.
	*
	* @return the primary key of this company
	*/
	public long getPrimaryKey() {
		return _company.getPrimaryKey();
	}

	/**
	* Sets the primary key of this company
	*
	* @param pk the primary key of this company
	*/
	public void setPrimaryKey(long pk) {
		_company.setPrimaryKey(pk);
	}

	/**
	* Gets the company id of this company.
	*
	* @return the company id of this company
	*/
	public long getCompanyId() {
		return _company.getCompanyId();
	}

	/**
	* Sets the company id of this company.
	*
	* @param companyId the company id of this company
	*/
	public void setCompanyId(long companyId) {
		_company.setCompanyId(companyId);
	}

	/**
	* Gets the account id of this company.
	*
	* @return the account id of this company
	*/
	public long getAccountId() {
		return _company.getAccountId();
	}

	/**
	* Sets the account id of this company.
	*
	* @param accountId the account id of this company
	*/
	public void setAccountId(long accountId) {
		_company.setAccountId(accountId);
	}

	/**
	* Gets the web id of this company.
	*
	* @return the web id of this company
	*/
	public java.lang.String getWebId() {
		return _company.getWebId();
	}

	/**
	* Sets the web id of this company.
	*
	* @param webId the web id of this company
	*/
	public void setWebId(java.lang.String webId) {
		_company.setWebId(webId);
	}

	/**
	* Gets the key of this company.
	*
	* @return the key of this company
	*/
	public java.lang.String getKey() {
		return _company.getKey();
	}

	/**
	* Sets the key of this company.
	*
	* @param key the key of this company
	*/
	public void setKey(java.lang.String key) {
		_company.setKey(key);
	}

	/**
	* Gets the virtual host of this company.
	*
	* @return the virtual host of this company
	*/
	public java.lang.String getVirtualHost() {
		return _company.getVirtualHost();
	}

	/**
	* Sets the virtual host of this company.
	*
	* @param virtualHost the virtual host of this company
	*/
	public void setVirtualHost(java.lang.String virtualHost) {
		_company.setVirtualHost(virtualHost);
	}

	/**
	* Gets the mx of this company.
	*
	* @return the mx of this company
	*/
	public java.lang.String getMx() {
		return _company.getMx();
	}

	/**
	* Sets the mx of this company.
	*
	* @param mx the mx of this company
	*/
	public void setMx(java.lang.String mx) {
		_company.setMx(mx);
	}

	/**
	* Gets the home u r l of this company.
	*
	* @return the home u r l of this company
	*/
	public java.lang.String getHomeURL() {
		return _company.getHomeURL();
	}

	/**
	* Sets the home u r l of this company.
	*
	* @param homeURL the home u r l of this company
	*/
	public void setHomeURL(java.lang.String homeURL) {
		_company.setHomeURL(homeURL);
	}

	/**
	* Gets the logo id of this company.
	*
	* @return the logo id of this company
	*/
	public long getLogoId() {
		return _company.getLogoId();
	}

	/**
	* Sets the logo id of this company.
	*
	* @param logoId the logo id of this company
	*/
	public void setLogoId(long logoId) {
		_company.setLogoId(logoId);
	}

	/**
	* Gets the system of this company.
	*
	* @return the system of this company
	*/
	public boolean getSystem() {
		return _company.getSystem();
	}

	/**
	* Determines if this company is system.
	*
	* @return <code>true</code> if this company is system; <code>false</code> otherwise
	*/
	public boolean isSystem() {
		return _company.isSystem();
	}

	/**
	* Sets whether this company is system.
	*
	* @param system the system of this company
	*/
	public void setSystem(boolean system) {
		_company.setSystem(system);
	}

	/**
	* Gets the max users of this company.
	*
	* @return the max users of this company
	*/
	public int getMaxUsers() {
		return _company.getMaxUsers();
	}

	/**
	* Sets the max users of this company.
	*
	* @param maxUsers the max users of this company
	*/
	public void setMaxUsers(int maxUsers) {
		_company.setMaxUsers(maxUsers);
	}

	public boolean isNew() {
		return _company.isNew();
	}

	public void setNew(boolean n) {
		_company.setNew(n);
	}

	public boolean isCachedModel() {
		return _company.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_company.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _company.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_company.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _company.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _company.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_company.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new CompanyWrapper((Company)_company.clone());
	}

	public int compareTo(com.liferay.portal.model.Company company) {
		return _company.compareTo(company);
	}

	public int hashCode() {
		return _company.hashCode();
	}

	public com.liferay.portal.model.Company toEscapedModel() {
		return new CompanyWrapper(_company.toEscapedModel());
	}

	public java.lang.String toString() {
		return _company.toString();
	}

	public java.lang.String toXmlString() {
		return _company.toXmlString();
	}

	public com.liferay.portal.model.Account getAccount()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getAccount();
	}

	public java.lang.String getAdminName() {
		return _company.getAdminName();
	}

	public java.lang.String getAuthType()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.getAuthType();
	}

	public com.liferay.portal.model.User getDefaultUser()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getDefaultUser();
	}

	public java.lang.String getDefaultWebId() {
		return _company.getDefaultWebId();
	}

	public java.lang.String getEmailAddress() {
		return _company.getEmailAddress();
	}

	public com.liferay.portal.model.Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getGroup();
	}

	public java.security.Key getKeyObj() {
		return _company.getKeyObj();
	}

	public java.util.Locale getLocale()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getLocale();
	}

	public java.lang.String getName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getName();
	}

	public java.lang.String getShardName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getShardName();
	}

	public java.lang.String getShortName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getShortName();
	}

	public java.util.TimeZone getTimeZone()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _company.getTimeZone();
	}

	public boolean hasCompanyMx(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.hasCompanyMx(emailAddress);
	}

	public boolean isAutoLogin()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isAutoLogin();
	}

	public boolean isCommunityLogo()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isCommunityLogo();
	}

	public boolean isSendPassword()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isSendPassword();
	}

	public boolean isSendPasswordResetLink()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isSendPasswordResetLink();
	}

	public boolean isStrangers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isStrangers();
	}

	public boolean isStrangersVerify()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isStrangersVerify();
	}

	public boolean isStrangersWithMx()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _company.isStrangersWithMx();
	}

	public void setKeyObj(java.security.Key keyObj) {
		_company.setKeyObj(keyObj);
	}

	public Company getWrappedCompany() {
		return _company;
	}

	private Company _company;
}