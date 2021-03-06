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
 * This class is a wrapper for {@link PasswordPolicyRel}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PasswordPolicyRel
 * @generated
 */
public class PasswordPolicyRelWrapper implements PasswordPolicyRel {
	public PasswordPolicyRelWrapper(PasswordPolicyRel passwordPolicyRel) {
		_passwordPolicyRel = passwordPolicyRel;
	}

	/**
	* Gets the primary key of this password policy rel.
	*
	* @return the primary key of this password policy rel
	*/
	public long getPrimaryKey() {
		return _passwordPolicyRel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this password policy rel
	*
	* @param pk the primary key of this password policy rel
	*/
	public void setPrimaryKey(long pk) {
		_passwordPolicyRel.setPrimaryKey(pk);
	}

	/**
	* Gets the password policy rel id of this password policy rel.
	*
	* @return the password policy rel id of this password policy rel
	*/
	public long getPasswordPolicyRelId() {
		return _passwordPolicyRel.getPasswordPolicyRelId();
	}

	/**
	* Sets the password policy rel id of this password policy rel.
	*
	* @param passwordPolicyRelId the password policy rel id of this password policy rel
	*/
	public void setPasswordPolicyRelId(long passwordPolicyRelId) {
		_passwordPolicyRel.setPasswordPolicyRelId(passwordPolicyRelId);
	}

	/**
	* Gets the password policy id of this password policy rel.
	*
	* @return the password policy id of this password policy rel
	*/
	public long getPasswordPolicyId() {
		return _passwordPolicyRel.getPasswordPolicyId();
	}

	/**
	* Sets the password policy id of this password policy rel.
	*
	* @param passwordPolicyId the password policy id of this password policy rel
	*/
	public void setPasswordPolicyId(long passwordPolicyId) {
		_passwordPolicyRel.setPasswordPolicyId(passwordPolicyId);
	}

	/**
	* Gets the class name of the model instance this password policy rel is polymorphically associated with.
	*
	* @return the class name of the model instance this password policy rel is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _passwordPolicyRel.getClassName();
	}

	/**
	* Gets the class name id of this password policy rel.
	*
	* @return the class name id of this password policy rel
	*/
	public long getClassNameId() {
		return _passwordPolicyRel.getClassNameId();
	}

	/**
	* Sets the class name id of this password policy rel.
	*
	* @param classNameId the class name id of this password policy rel
	*/
	public void setClassNameId(long classNameId) {
		_passwordPolicyRel.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this password policy rel.
	*
	* @return the class p k of this password policy rel
	*/
	public long getClassPK() {
		return _passwordPolicyRel.getClassPK();
	}

	/**
	* Sets the class p k of this password policy rel.
	*
	* @param classPK the class p k of this password policy rel
	*/
	public void setClassPK(long classPK) {
		_passwordPolicyRel.setClassPK(classPK);
	}

	public boolean isNew() {
		return _passwordPolicyRel.isNew();
	}

	public void setNew(boolean n) {
		_passwordPolicyRel.setNew(n);
	}

	public boolean isCachedModel() {
		return _passwordPolicyRel.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_passwordPolicyRel.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _passwordPolicyRel.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_passwordPolicyRel.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _passwordPolicyRel.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _passwordPolicyRel.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_passwordPolicyRel.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new PasswordPolicyRelWrapper((PasswordPolicyRel)_passwordPolicyRel.clone());
	}

	public int compareTo(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel) {
		return _passwordPolicyRel.compareTo(passwordPolicyRel);
	}

	public int hashCode() {
		return _passwordPolicyRel.hashCode();
	}

	public com.liferay.portal.model.PasswordPolicyRel toEscapedModel() {
		return new PasswordPolicyRelWrapper(_passwordPolicyRel.toEscapedModel());
	}

	public java.lang.String toString() {
		return _passwordPolicyRel.toString();
	}

	public java.lang.String toXmlString() {
		return _passwordPolicyRel.toXmlString();
	}

	public PasswordPolicyRel getWrappedPasswordPolicyRel() {
		return _passwordPolicyRel;
	}

	private PasswordPolicyRel _passwordPolicyRel;
}