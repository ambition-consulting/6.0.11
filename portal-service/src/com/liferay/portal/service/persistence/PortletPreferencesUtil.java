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

package com.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the portlet preferences service. This utility wraps {@link PortletPreferencesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletPreferencesPersistence
 * @see PortletPreferencesPersistenceImpl
 * @generated
 */
public class PortletPreferencesUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PortletPreferences portletPreferences) {
		getPersistence().clearCache(portletPreferences);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PortletPreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletPreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletPreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static PortletPreferences remove(
		PortletPreferences portletPreferences) throws SystemException {
		return getPersistence().remove(portletPreferences);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PortletPreferences update(
		PortletPreferences portletPreferences, boolean merge)
		throws SystemException {
		return getPersistence().update(portletPreferences, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PortletPreferences update(
		PortletPreferences portletPreferences, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portletPreferences, merge, serviceContext);
	}

	/**
	* Caches the portlet preferences in the entity cache if it is enabled.
	*
	* @param portletPreferences the portlet preferences to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.PortletPreferences portletPreferences) {
		getPersistence().cacheResult(portletPreferences);
	}

	/**
	* Caches the portlet preferenceses in the entity cache if it is enabled.
	*
	* @param portletPreferenceses the portlet preferenceses to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.PortletPreferences> portletPreferenceses) {
		getPersistence().cacheResult(portletPreferenceses);
	}

	/**
	* Creates a new portlet preferences with the primary key. Does not add the portlet preferences to the database.
	*
	* @param portletPreferencesId the primary key for the new portlet preferences
	* @return the new portlet preferences
	*/
	public static com.liferay.portal.model.PortletPreferences create(
		long portletPreferencesId) {
		return getPersistence().create(portletPreferencesId);
	}

	/**
	* Removes the portlet preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletPreferencesId the primary key of the portlet preferences to remove
	* @return the portlet preferences that was removed
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences remove(
		long portletPreferencesId)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(portletPreferencesId);
	}

	public static com.liferay.portal.model.PortletPreferences updateImpl(
		com.liferay.portal.model.PortletPreferences portletPreferences,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portletPreferences, merge);
	}

	/**
	* Finds the portlet preferences with the primary key or throws a {@link com.liferay.portal.NoSuchPortletPreferencesException} if it could not be found.
	*
	* @param portletPreferencesId the primary key of the portlet preferences to find
	* @return the portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByPrimaryKey(
		long portletPreferencesId)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(portletPreferencesId);
	}

	/**
	* Finds the portlet preferences with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portletPreferencesId the primary key of the portlet preferences to find
	* @return the portlet preferences, or <code>null</code> if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences fetchByPrimaryKey(
		long portletPreferencesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(portletPreferencesId);
	}

	/**
	* Finds all the portlet preferenceses where plid = &#63;.
	*
	* @param plid the plid to search with
	* @return the matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByPlid(
		long plid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlid(plid);
	}

	/**
	* Finds a range of all the portlet preferenceses where plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @return the range of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByPlid(
		long plid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlid(plid, start, end);
	}

	/**
	* Finds an ordered range of all the portlet preferenceses where plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByPlid(
		long plid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlid(plid, start, end, orderByComparator);
	}

	/**
	* Finds the first portlet preferences in the ordered set where plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByPlid_First(
		long plid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlid_First(plid, orderByComparator);
	}

	/**
	* Finds the last portlet preferences in the ordered set where plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByPlid_Last(
		long plid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlid_Last(plid, orderByComparator);
	}

	/**
	* Finds the portlet preferenceses before and after the current portlet preferences in the ordered set where plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portletPreferencesId the primary key of the current portlet preferences
	* @param plid the plid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences[] findByPlid_PrevAndNext(
		long portletPreferencesId, long plid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlid_PrevAndNext(portletPreferencesId, plid,
			orderByComparator);
	}

	/**
	* Finds all the portlet preferenceses where plid = &#63; and portletId = &#63;.
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @return the matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByP_P(
		long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_P(plid, portletId);
	}

	/**
	* Finds a range of all the portlet preferenceses where plid = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @return the range of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByP_P(
		long plid, java.lang.String portletId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_P(plid, portletId, start, end);
	}

	/**
	* Finds an ordered range of all the portlet preferenceses where plid = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByP_P(
		long plid, java.lang.String portletId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P(plid, portletId, start, end, orderByComparator);
	}

	/**
	* Finds the first portlet preferences in the ordered set where plid = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByP_P_First(
		long plid, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P_First(plid, portletId, orderByComparator);
	}

	/**
	* Finds the last portlet preferences in the ordered set where plid = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByP_P_Last(
		long plid, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P_Last(plid, portletId, orderByComparator);
	}

	/**
	* Finds the portlet preferenceses before and after the current portlet preferences in the ordered set where plid = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portletPreferencesId the primary key of the current portlet preferences
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences[] findByP_P_PrevAndNext(
		long portletPreferencesId, long plid, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P_PrevAndNext(portletPreferencesId, plid,
			portletId, orderByComparator);
	}

	/**
	* Finds all the portlet preferenceses where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @return the matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByO_O_P(
		long ownerId, int ownerType, long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByO_O_P(ownerId, ownerType, plid);
	}

	/**
	* Finds a range of all the portlet preferenceses where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @return the range of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByO_O_P(
		long ownerId, int ownerType, long plid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByO_O_P(ownerId, ownerType, plid, start, end);
	}

	/**
	* Finds an ordered range of all the portlet preferenceses where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findByO_O_P(
		long ownerId, int ownerType, long plid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByO_O_P(ownerId, ownerType, plid, start, end,
			orderByComparator);
	}

	/**
	* Finds the first portlet preferences in the ordered set where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByO_O_P_First(
		long ownerId, int ownerType, long plid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByO_O_P_First(ownerId, ownerType, plid,
			orderByComparator);
	}

	/**
	* Finds the last portlet preferences in the ordered set where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByO_O_P_Last(
		long ownerId, int ownerType, long plid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByO_O_P_Last(ownerId, ownerType, plid, orderByComparator);
	}

	/**
	* Finds the portlet preferenceses before and after the current portlet preferences in the ordered set where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portletPreferencesId the primary key of the current portlet preferences
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences[] findByO_O_P_PrevAndNext(
		long portletPreferencesId, long ownerId, int ownerType, long plid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByO_O_P_PrevAndNext(portletPreferencesId, ownerId,
			ownerType, plid, orderByComparator);
	}

	/**
	* Finds the portlet preferences where ownerId = &#63; and ownerType = &#63; and plid = &#63; and portletId = &#63; or throws a {@link com.liferay.portal.NoSuchPortletPreferencesException} if it could not be found.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @return the matching portlet preferences
	* @throws com.liferay.portal.NoSuchPortletPreferencesException if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences findByO_O_P_P(
		long ownerId, int ownerType, long plid, java.lang.String portletId)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByO_O_P_P(ownerId, ownerType, plid, portletId);
	}

	/**
	* Finds the portlet preferences where ownerId = &#63; and ownerType = &#63; and plid = &#63; and portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @return the matching portlet preferences, or <code>null</code> if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences fetchByO_O_P_P(
		long ownerId, int ownerType, long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByO_O_P_P(ownerId, ownerType, plid, portletId);
	}

	/**
	* Finds the portlet preferences where ownerId = &#63; and ownerType = &#63; and plid = &#63; and portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @return the matching portlet preferences, or <code>null</code> if a matching portlet preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletPreferences fetchByO_O_P_P(
		long ownerId, int ownerType, long plid, java.lang.String portletId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByO_O_P_P(ownerId, ownerType, plid, portletId,
			retrieveFromCache);
	}

	/**
	* Finds all the portlet preferenceses.
	*
	* @return the portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the portlet preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @return the range of portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the portlet preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletPreferences> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portlet preferenceses where plid = &#63; from the database.
	*
	* @param plid the plid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPlid(long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPlid(plid);
	}

	/**
	* Removes all the portlet preferenceses where plid = &#63; and portletId = &#63; from the database.
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_P(long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_P(plid, portletId);
	}

	/**
	* Removes all the portlet preferenceses where ownerId = &#63; and ownerType = &#63; and plid = &#63; from the database.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByO_O_P(long ownerId, int ownerType, long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByO_O_P(ownerId, ownerType, plid);
	}

	/**
	* Removes the portlet preferences where ownerId = &#63; and ownerType = &#63; and plid = &#63; and portletId = &#63; from the database.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByO_O_P_P(long ownerId, int ownerType, long plid,
		java.lang.String portletId)
		throws com.liferay.portal.NoSuchPortletPreferencesException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByO_O_P_P(ownerId, ownerType, plid, portletId);
	}

	/**
	* Removes all the portlet preferenceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the portlet preferenceses where plid = &#63;.
	*
	* @param plid the plid to search with
	* @return the number of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPlid(long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPlid(plid);
	}

	/**
	* Counts all the portlet preferenceses where plid = &#63; and portletId = &#63;.
	*
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @return the number of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_P(long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_P(plid, portletId);
	}

	/**
	* Counts all the portlet preferenceses where ownerId = &#63; and ownerType = &#63; and plid = &#63;.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @return the number of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByO_O_P(long ownerId, int ownerType, long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByO_O_P(ownerId, ownerType, plid);
	}

	/**
	* Counts all the portlet preferenceses where ownerId = &#63; and ownerType = &#63; and plid = &#63; and portletId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @param ownerType the owner type to search with
	* @param plid the plid to search with
	* @param portletId the portlet id to search with
	* @return the number of matching portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByO_O_P_P(long ownerId, int ownerType, long plid,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByO_O_P_P(ownerId, ownerType, plid, portletId);
	}

	/**
	* Counts all the portlet preferenceses.
	*
	* @return the number of portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortletPreferencesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortletPreferencesPersistence)PortalBeanLocatorUtil.locate(PortletPreferencesPersistence.class.getName());

			ReferenceRegistry.registerReference(PortletPreferencesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(PortletPreferencesPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(PortletPreferencesUtil.class,
			"_persistence");
	}

	private static PortletPreferencesPersistence _persistence;
}