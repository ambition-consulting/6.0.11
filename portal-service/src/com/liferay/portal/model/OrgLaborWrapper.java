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
 * This class is a wrapper for {@link OrgLabor}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OrgLabor
 * @generated
 */
public class OrgLaborWrapper implements OrgLabor {
	public OrgLaborWrapper(OrgLabor orgLabor) {
		_orgLabor = orgLabor;
	}

	/**
	* Gets the primary key of this org labor.
	*
	* @return the primary key of this org labor
	*/
	public long getPrimaryKey() {
		return _orgLabor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this org labor
	*
	* @param pk the primary key of this org labor
	*/
	public void setPrimaryKey(long pk) {
		_orgLabor.setPrimaryKey(pk);
	}

	/**
	* Gets the org labor id of this org labor.
	*
	* @return the org labor id of this org labor
	*/
	public long getOrgLaborId() {
		return _orgLabor.getOrgLaborId();
	}

	/**
	* Sets the org labor id of this org labor.
	*
	* @param orgLaborId the org labor id of this org labor
	*/
	public void setOrgLaborId(long orgLaborId) {
		_orgLabor.setOrgLaborId(orgLaborId);
	}

	/**
	* Gets the organization id of this org labor.
	*
	* @return the organization id of this org labor
	*/
	public long getOrganizationId() {
		return _orgLabor.getOrganizationId();
	}

	/**
	* Sets the organization id of this org labor.
	*
	* @param organizationId the organization id of this org labor
	*/
	public void setOrganizationId(long organizationId) {
		_orgLabor.setOrganizationId(organizationId);
	}

	/**
	* Gets the type id of this org labor.
	*
	* @return the type id of this org labor
	*/
	public int getTypeId() {
		return _orgLabor.getTypeId();
	}

	/**
	* Sets the type id of this org labor.
	*
	* @param typeId the type id of this org labor
	*/
	public void setTypeId(int typeId) {
		_orgLabor.setTypeId(typeId);
	}

	/**
	* Gets the sun open of this org labor.
	*
	* @return the sun open of this org labor
	*/
	public int getSunOpen() {
		return _orgLabor.getSunOpen();
	}

	/**
	* Sets the sun open of this org labor.
	*
	* @param sunOpen the sun open of this org labor
	*/
	public void setSunOpen(int sunOpen) {
		_orgLabor.setSunOpen(sunOpen);
	}

	/**
	* Gets the sun close of this org labor.
	*
	* @return the sun close of this org labor
	*/
	public int getSunClose() {
		return _orgLabor.getSunClose();
	}

	/**
	* Sets the sun close of this org labor.
	*
	* @param sunClose the sun close of this org labor
	*/
	public void setSunClose(int sunClose) {
		_orgLabor.setSunClose(sunClose);
	}

	/**
	* Gets the mon open of this org labor.
	*
	* @return the mon open of this org labor
	*/
	public int getMonOpen() {
		return _orgLabor.getMonOpen();
	}

	/**
	* Sets the mon open of this org labor.
	*
	* @param monOpen the mon open of this org labor
	*/
	public void setMonOpen(int monOpen) {
		_orgLabor.setMonOpen(monOpen);
	}

	/**
	* Gets the mon close of this org labor.
	*
	* @return the mon close of this org labor
	*/
	public int getMonClose() {
		return _orgLabor.getMonClose();
	}

	/**
	* Sets the mon close of this org labor.
	*
	* @param monClose the mon close of this org labor
	*/
	public void setMonClose(int monClose) {
		_orgLabor.setMonClose(monClose);
	}

	/**
	* Gets the tue open of this org labor.
	*
	* @return the tue open of this org labor
	*/
	public int getTueOpen() {
		return _orgLabor.getTueOpen();
	}

	/**
	* Sets the tue open of this org labor.
	*
	* @param tueOpen the tue open of this org labor
	*/
	public void setTueOpen(int tueOpen) {
		_orgLabor.setTueOpen(tueOpen);
	}

	/**
	* Gets the tue close of this org labor.
	*
	* @return the tue close of this org labor
	*/
	public int getTueClose() {
		return _orgLabor.getTueClose();
	}

	/**
	* Sets the tue close of this org labor.
	*
	* @param tueClose the tue close of this org labor
	*/
	public void setTueClose(int tueClose) {
		_orgLabor.setTueClose(tueClose);
	}

	/**
	* Gets the wed open of this org labor.
	*
	* @return the wed open of this org labor
	*/
	public int getWedOpen() {
		return _orgLabor.getWedOpen();
	}

	/**
	* Sets the wed open of this org labor.
	*
	* @param wedOpen the wed open of this org labor
	*/
	public void setWedOpen(int wedOpen) {
		_orgLabor.setWedOpen(wedOpen);
	}

	/**
	* Gets the wed close of this org labor.
	*
	* @return the wed close of this org labor
	*/
	public int getWedClose() {
		return _orgLabor.getWedClose();
	}

	/**
	* Sets the wed close of this org labor.
	*
	* @param wedClose the wed close of this org labor
	*/
	public void setWedClose(int wedClose) {
		_orgLabor.setWedClose(wedClose);
	}

	/**
	* Gets the thu open of this org labor.
	*
	* @return the thu open of this org labor
	*/
	public int getThuOpen() {
		return _orgLabor.getThuOpen();
	}

	/**
	* Sets the thu open of this org labor.
	*
	* @param thuOpen the thu open of this org labor
	*/
	public void setThuOpen(int thuOpen) {
		_orgLabor.setThuOpen(thuOpen);
	}

	/**
	* Gets the thu close of this org labor.
	*
	* @return the thu close of this org labor
	*/
	public int getThuClose() {
		return _orgLabor.getThuClose();
	}

	/**
	* Sets the thu close of this org labor.
	*
	* @param thuClose the thu close of this org labor
	*/
	public void setThuClose(int thuClose) {
		_orgLabor.setThuClose(thuClose);
	}

	/**
	* Gets the fri open of this org labor.
	*
	* @return the fri open of this org labor
	*/
	public int getFriOpen() {
		return _orgLabor.getFriOpen();
	}

	/**
	* Sets the fri open of this org labor.
	*
	* @param friOpen the fri open of this org labor
	*/
	public void setFriOpen(int friOpen) {
		_orgLabor.setFriOpen(friOpen);
	}

	/**
	* Gets the fri close of this org labor.
	*
	* @return the fri close of this org labor
	*/
	public int getFriClose() {
		return _orgLabor.getFriClose();
	}

	/**
	* Sets the fri close of this org labor.
	*
	* @param friClose the fri close of this org labor
	*/
	public void setFriClose(int friClose) {
		_orgLabor.setFriClose(friClose);
	}

	/**
	* Gets the sat open of this org labor.
	*
	* @return the sat open of this org labor
	*/
	public int getSatOpen() {
		return _orgLabor.getSatOpen();
	}

	/**
	* Sets the sat open of this org labor.
	*
	* @param satOpen the sat open of this org labor
	*/
	public void setSatOpen(int satOpen) {
		_orgLabor.setSatOpen(satOpen);
	}

	/**
	* Gets the sat close of this org labor.
	*
	* @return the sat close of this org labor
	*/
	public int getSatClose() {
		return _orgLabor.getSatClose();
	}

	/**
	* Sets the sat close of this org labor.
	*
	* @param satClose the sat close of this org labor
	*/
	public void setSatClose(int satClose) {
		_orgLabor.setSatClose(satClose);
	}

	public boolean isNew() {
		return _orgLabor.isNew();
	}

	public void setNew(boolean n) {
		_orgLabor.setNew(n);
	}

	public boolean isCachedModel() {
		return _orgLabor.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_orgLabor.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _orgLabor.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_orgLabor.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _orgLabor.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orgLabor.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orgLabor.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new OrgLaborWrapper((OrgLabor)_orgLabor.clone());
	}

	public int compareTo(com.liferay.portal.model.OrgLabor orgLabor) {
		return _orgLabor.compareTo(orgLabor);
	}

	public int hashCode() {
		return _orgLabor.hashCode();
	}

	public com.liferay.portal.model.OrgLabor toEscapedModel() {
		return new OrgLaborWrapper(_orgLabor.toEscapedModel());
	}

	public java.lang.String toString() {
		return _orgLabor.toString();
	}

	public java.lang.String toXmlString() {
		return _orgLabor.toXmlString();
	}

	public com.liferay.portal.model.ListType getType()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLabor.getType();
	}

	public OrgLabor getWrappedOrgLabor() {
		return _orgLabor;
	}

	private OrgLabor _orgLabor;
}