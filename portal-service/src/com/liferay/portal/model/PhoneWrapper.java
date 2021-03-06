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
 * This class is a wrapper for {@link Phone}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Phone
 * @generated
 */
public class PhoneWrapper implements Phone {
	public PhoneWrapper(Phone phone) {
		_phone = phone;
	}

	/**
	* Gets the primary key of this phone.
	*
	* @return the primary key of this phone
	*/
	public long getPrimaryKey() {
		return _phone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phone
	*
	* @param pk the primary key of this phone
	*/
	public void setPrimaryKey(long pk) {
		_phone.setPrimaryKey(pk);
	}

	/**
	* Gets the phone id of this phone.
	*
	* @return the phone id of this phone
	*/
	public long getPhoneId() {
		return _phone.getPhoneId();
	}

	/**
	* Sets the phone id of this phone.
	*
	* @param phoneId the phone id of this phone
	*/
	public void setPhoneId(long phoneId) {
		_phone.setPhoneId(phoneId);
	}

	/**
	* Gets the company id of this phone.
	*
	* @return the company id of this phone
	*/
	public long getCompanyId() {
		return _phone.getCompanyId();
	}

	/**
	* Sets the company id of this phone.
	*
	* @param companyId the company id of this phone
	*/
	public void setCompanyId(long companyId) {
		_phone.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this phone.
	*
	* @return the user id of this phone
	*/
	public long getUserId() {
		return _phone.getUserId();
	}

	/**
	* Sets the user id of this phone.
	*
	* @param userId the user id of this phone
	*/
	public void setUserId(long userId) {
		_phone.setUserId(userId);
	}

	/**
	* Gets the user uuid of this phone.
	*
	* @return the user uuid of this phone
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _phone.getUserUuid();
	}

	/**
	* Sets the user uuid of this phone.
	*
	* @param userUuid the user uuid of this phone
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_phone.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this phone.
	*
	* @return the user name of this phone
	*/
	public java.lang.String getUserName() {
		return _phone.getUserName();
	}

	/**
	* Sets the user name of this phone.
	*
	* @param userName the user name of this phone
	*/
	public void setUserName(java.lang.String userName) {
		_phone.setUserName(userName);
	}

	/**
	* Gets the create date of this phone.
	*
	* @return the create date of this phone
	*/
	public java.util.Date getCreateDate() {
		return _phone.getCreateDate();
	}

	/**
	* Sets the create date of this phone.
	*
	* @param createDate the create date of this phone
	*/
	public void setCreateDate(java.util.Date createDate) {
		_phone.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this phone.
	*
	* @return the modified date of this phone
	*/
	public java.util.Date getModifiedDate() {
		return _phone.getModifiedDate();
	}

	/**
	* Sets the modified date of this phone.
	*
	* @param modifiedDate the modified date of this phone
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_phone.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the class name of the model instance this phone is polymorphically associated with.
	*
	* @return the class name of the model instance this phone is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _phone.getClassName();
	}

	/**
	* Gets the class name id of this phone.
	*
	* @return the class name id of this phone
	*/
	public long getClassNameId() {
		return _phone.getClassNameId();
	}

	/**
	* Sets the class name id of this phone.
	*
	* @param classNameId the class name id of this phone
	*/
	public void setClassNameId(long classNameId) {
		_phone.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this phone.
	*
	* @return the class p k of this phone
	*/
	public long getClassPK() {
		return _phone.getClassPK();
	}

	/**
	* Sets the class p k of this phone.
	*
	* @param classPK the class p k of this phone
	*/
	public void setClassPK(long classPK) {
		_phone.setClassPK(classPK);
	}

	/**
	* Gets the number of this phone.
	*
	* @return the number of this phone
	*/
	public java.lang.String getNumber() {
		return _phone.getNumber();
	}

	/**
	* Sets the number of this phone.
	*
	* @param number the number of this phone
	*/
	public void setNumber(java.lang.String number) {
		_phone.setNumber(number);
	}

	/**
	* Gets the extension of this phone.
	*
	* @return the extension of this phone
	*/
	public java.lang.String getExtension() {
		return _phone.getExtension();
	}

	/**
	* Sets the extension of this phone.
	*
	* @param extension the extension of this phone
	*/
	public void setExtension(java.lang.String extension) {
		_phone.setExtension(extension);
	}

	/**
	* Gets the type id of this phone.
	*
	* @return the type id of this phone
	*/
	public int getTypeId() {
		return _phone.getTypeId();
	}

	/**
	* Sets the type id of this phone.
	*
	* @param typeId the type id of this phone
	*/
	public void setTypeId(int typeId) {
		_phone.setTypeId(typeId);
	}

	/**
	* Gets the primary of this phone.
	*
	* @return the primary of this phone
	*/
	public boolean getPrimary() {
		return _phone.getPrimary();
	}

	/**
	* Determines if this phone is primary.
	*
	* @return <code>true</code> if this phone is primary; <code>false</code> otherwise
	*/
	public boolean isPrimary() {
		return _phone.isPrimary();
	}

	/**
	* Sets whether this phone is primary.
	*
	* @param primary the primary of this phone
	*/
	public void setPrimary(boolean primary) {
		_phone.setPrimary(primary);
	}

	public boolean isNew() {
		return _phone.isNew();
	}

	public void setNew(boolean n) {
		_phone.setNew(n);
	}

	public boolean isCachedModel() {
		return _phone.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_phone.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _phone.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_phone.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _phone.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phone.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phone.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new PhoneWrapper((Phone)_phone.clone());
	}

	public int compareTo(com.liferay.portal.model.Phone phone) {
		return _phone.compareTo(phone);
	}

	public int hashCode() {
		return _phone.hashCode();
	}

	public com.liferay.portal.model.Phone toEscapedModel() {
		return new PhoneWrapper(_phone.toEscapedModel());
	}

	public java.lang.String toString() {
		return _phone.toString();
	}

	public java.lang.String toXmlString() {
		return _phone.toXmlString();
	}

	public com.liferay.portal.model.ListType getType()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _phone.getType();
	}

	public Phone getWrappedPhone() {
		return _phone;
	}

	private Phone _phone;
}