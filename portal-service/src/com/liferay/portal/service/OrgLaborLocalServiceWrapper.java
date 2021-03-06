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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link OrgLaborLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OrgLaborLocalService
 * @generated
 */
public class OrgLaborLocalServiceWrapper implements OrgLaborLocalService {
	public OrgLaborLocalServiceWrapper(
		OrgLaborLocalService orgLaborLocalService) {
		_orgLaborLocalService = orgLaborLocalService;
	}

	/**
	* Adds the org labor to the database. Also notifies the appropriate model listeners.
	*
	* @param orgLabor the org labor to add
	* @return the org labor that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor addOrgLabor(
		com.liferay.portal.model.OrgLabor orgLabor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.addOrgLabor(orgLabor);
	}

	/**
	* Creates a new org labor with the primary key. Does not add the org labor to the database.
	*
	* @param orgLaborId the primary key for the new org labor
	* @return the new org labor
	*/
	public com.liferay.portal.model.OrgLabor createOrgLabor(long orgLaborId) {
		return _orgLaborLocalService.createOrgLabor(orgLaborId);
	}

	/**
	* Deletes the org labor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgLaborId the primary key of the org labor to delete
	* @throws PortalException if a org labor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteOrgLabor(long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_orgLaborLocalService.deleteOrgLabor(orgLaborId);
	}

	/**
	* Deletes the org labor from the database. Also notifies the appropriate model listeners.
	*
	* @param orgLabor the org labor to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteOrgLabor(com.liferay.portal.model.OrgLabor orgLabor)
		throws com.liferay.portal.kernel.exception.SystemException {
		_orgLaborLocalService.deleteOrgLabor(orgLabor);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the org labor with the primary key.
	*
	* @param orgLaborId the primary key of the org labor to get
	* @return the org labor
	* @throws PortalException if a org labor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor getOrgLabor(long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.getOrgLabor(orgLaborId);
	}

	/**
	* Gets a range of all the org labors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of org labors to return
	* @param end the upper bound of the range of org labors to return (not inclusive)
	* @return the range of org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> getOrgLabors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.getOrgLabors(start, end);
	}

	/**
	* Gets the number of org labors.
	*
	* @return the number of org labors
	* @throws SystemException if a system exception occurred
	*/
	public int getOrgLaborsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.getOrgLaborsCount();
	}

	/**
	* Updates the org labor in the database. Also notifies the appropriate model listeners.
	*
	* @param orgLabor the org labor to update
	* @return the org labor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor updateOrgLabor(
		com.liferay.portal.model.OrgLabor orgLabor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.updateOrgLabor(orgLabor);
	}

	/**
	* Updates the org labor in the database. Also notifies the appropriate model listeners.
	*
	* @param orgLabor the org labor to update
	* @param merge whether to merge the org labor with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the org labor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor updateOrgLabor(
		com.liferay.portal.model.OrgLabor orgLabor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.updateOrgLabor(orgLabor, merge);
	}

	public com.liferay.portal.model.OrgLabor addOrgLabor(long organizationId,
		int typeId, int sunOpen, int sunClose, int monOpen, int monClose,
		int tueOpen, int tueClose, int wedOpen, int wedClose, int thuOpen,
		int thuClose, int friOpen, int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.addOrgLabor(organizationId, typeId,
			sunOpen, sunClose, monOpen, monClose, tueOpen, tueClose, wedOpen,
			wedClose, thuOpen, thuClose, friOpen, friClose, satOpen, satClose);
	}

	public java.util.List<com.liferay.portal.model.OrgLabor> getOrgLabors(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.getOrgLabors(organizationId);
	}

	public com.liferay.portal.model.OrgLabor updateOrgLabor(long orgLaborId,
		int typeId, int sunOpen, int sunClose, int monOpen, int monClose,
		int tueOpen, int tueClose, int wedOpen, int wedClose, int thuOpen,
		int thuClose, int friOpen, int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborLocalService.updateOrgLabor(orgLaborId, typeId,
			sunOpen, sunClose, monOpen, monClose, tueOpen, tueClose, wedOpen,
			wedClose, thuOpen, thuClose, friOpen, friClose, satOpen, satClose);
	}

	public OrgLaborLocalService getWrappedOrgLaborLocalService() {
		return _orgLaborLocalService;
	}

	public void setWrappedOrgLaborLocalService(
		OrgLaborLocalService orgLaborLocalService) {
		_orgLaborLocalService = orgLaborLocalService;
	}

	private OrgLaborLocalService _orgLaborLocalService;
}