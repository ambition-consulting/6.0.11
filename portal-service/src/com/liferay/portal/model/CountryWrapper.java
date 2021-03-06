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
 * This class is a wrapper for {@link Country}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Country
 * @generated
 */
public class CountryWrapper implements Country {
	public CountryWrapper(Country country) {
		_country = country;
	}

	/**
	* Gets the primary key of this country.
	*
	* @return the primary key of this country
	*/
	public long getPrimaryKey() {
		return _country.getPrimaryKey();
	}

	/**
	* Sets the primary key of this country
	*
	* @param pk the primary key of this country
	*/
	public void setPrimaryKey(long pk) {
		_country.setPrimaryKey(pk);
	}

	/**
	* Gets the country id of this country.
	*
	* @return the country id of this country
	*/
	public long getCountryId() {
		return _country.getCountryId();
	}

	/**
	* Sets the country id of this country.
	*
	* @param countryId the country id of this country
	*/
	public void setCountryId(long countryId) {
		_country.setCountryId(countryId);
	}

	/**
	* Gets the name of this country.
	*
	* @return the name of this country
	*/
	public java.lang.String getName() {
		return _country.getName();
	}

	/**
	* Sets the name of this country.
	*
	* @param name the name of this country
	*/
	public void setName(java.lang.String name) {
		_country.setName(name);
	}

	/**
	* Gets the a2 of this country.
	*
	* @return the a2 of this country
	*/
	public java.lang.String getA2() {
		return _country.getA2();
	}

	/**
	* Sets the a2 of this country.
	*
	* @param a2 the a2 of this country
	*/
	public void setA2(java.lang.String a2) {
		_country.setA2(a2);
	}

	/**
	* Gets the a3 of this country.
	*
	* @return the a3 of this country
	*/
	public java.lang.String getA3() {
		return _country.getA3();
	}

	/**
	* Sets the a3 of this country.
	*
	* @param a3 the a3 of this country
	*/
	public void setA3(java.lang.String a3) {
		_country.setA3(a3);
	}

	/**
	* Gets the number of this country.
	*
	* @return the number of this country
	*/
	public java.lang.String getNumber() {
		return _country.getNumber();
	}

	/**
	* Sets the number of this country.
	*
	* @param number the number of this country
	*/
	public void setNumber(java.lang.String number) {
		_country.setNumber(number);
	}

	/**
	* Gets the idd of this country.
	*
	* @return the idd of this country
	*/
	public java.lang.String getIdd() {
		return _country.getIdd();
	}

	/**
	* Sets the idd of this country.
	*
	* @param idd the idd of this country
	*/
	public void setIdd(java.lang.String idd) {
		_country.setIdd(idd);
	}

	/**
	* Gets the active of this country.
	*
	* @return the active of this country
	*/
	public boolean getActive() {
		return _country.getActive();
	}

	/**
	* Determines if this country is active.
	*
	* @return <code>true</code> if this country is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _country.isActive();
	}

	/**
	* Sets whether this country is active.
	*
	* @param active the active of this country
	*/
	public void setActive(boolean active) {
		_country.setActive(active);
	}

	public boolean isNew() {
		return _country.isNew();
	}

	public void setNew(boolean n) {
		_country.setNew(n);
	}

	public boolean isCachedModel() {
		return _country.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_country.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _country.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_country.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _country.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _country.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_country.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new CountryWrapper((Country)_country.clone());
	}

	public int compareTo(com.liferay.portal.model.Country country) {
		return _country.compareTo(country);
	}

	public int hashCode() {
		return _country.hashCode();
	}

	public com.liferay.portal.model.Country toEscapedModel() {
		return new CountryWrapper(_country.toEscapedModel());
	}

	public java.lang.String toString() {
		return _country.toString();
	}

	public java.lang.String toXmlString() {
		return _country.toXmlString();
	}

	public Country getWrappedCountry() {
		return _country;
	}

	private Country _country;
}