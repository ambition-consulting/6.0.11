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
import com.liferay.portal.model.WebDAVProps;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the web d a v props service. This utility wraps {@link WebDAVPropsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebDAVPropsPersistence
 * @see WebDAVPropsPersistenceImpl
 * @generated
 */
public class WebDAVPropsUtil {
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
	public static void clearCache(WebDAVProps webDAVProps) {
		getPersistence().clearCache(webDAVProps);
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
	public static List<WebDAVProps> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebDAVProps> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebDAVProps> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static WebDAVProps remove(WebDAVProps webDAVProps)
		throws SystemException {
		return getPersistence().remove(webDAVProps);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WebDAVProps update(WebDAVProps webDAVProps, boolean merge)
		throws SystemException {
		return getPersistence().update(webDAVProps, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WebDAVProps update(WebDAVProps webDAVProps, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(webDAVProps, merge, serviceContext);
	}

	/**
	* Caches the web d a v props in the entity cache if it is enabled.
	*
	* @param webDAVProps the web d a v props to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.WebDAVProps webDAVProps) {
		getPersistence().cacheResult(webDAVProps);
	}

	/**
	* Caches the web d a v propses in the entity cache if it is enabled.
	*
	* @param webDAVPropses the web d a v propses to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.WebDAVProps> webDAVPropses) {
		getPersistence().cacheResult(webDAVPropses);
	}

	/**
	* Creates a new web d a v props with the primary key. Does not add the web d a v props to the database.
	*
	* @param webDavPropsId the primary key for the new web d a v props
	* @return the new web d a v props
	*/
	public static com.liferay.portal.model.WebDAVProps create(
		long webDavPropsId) {
		return getPersistence().create(webDavPropsId);
	}

	/**
	* Removes the web d a v props with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webDavPropsId the primary key of the web d a v props to remove
	* @return the web d a v props that was removed
	* @throws com.liferay.portal.NoSuchWebDAVPropsException if a web d a v props with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WebDAVProps remove(
		long webDavPropsId)
		throws com.liferay.portal.NoSuchWebDAVPropsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(webDavPropsId);
	}

	public static com.liferay.portal.model.WebDAVProps updateImpl(
		com.liferay.portal.model.WebDAVProps webDAVProps, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(webDAVProps, merge);
	}

	/**
	* Finds the web d a v props with the primary key or throws a {@link com.liferay.portal.NoSuchWebDAVPropsException} if it could not be found.
	*
	* @param webDavPropsId the primary key of the web d a v props to find
	* @return the web d a v props
	* @throws com.liferay.portal.NoSuchWebDAVPropsException if a web d a v props with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WebDAVProps findByPrimaryKey(
		long webDavPropsId)
		throws com.liferay.portal.NoSuchWebDAVPropsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(webDavPropsId);
	}

	/**
	* Finds the web d a v props with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webDavPropsId the primary key of the web d a v props to find
	* @return the web d a v props, or <code>null</code> if a web d a v props with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WebDAVProps fetchByPrimaryKey(
		long webDavPropsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(webDavPropsId);
	}

	/**
	* Finds the web d a v props where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portal.NoSuchWebDAVPropsException} if it could not be found.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching web d a v props
	* @throws com.liferay.portal.NoSuchWebDAVPropsException if a matching web d a v props could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WebDAVProps findByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.NoSuchWebDAVPropsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	* Finds the web d a v props where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching web d a v props, or <code>null</code> if a matching web d a v props could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WebDAVProps fetchByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	* Finds the web d a v props where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching web d a v props, or <code>null</code> if a matching web d a v props could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WebDAVProps fetchByC_C(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Finds all the web d a v propses.
	*
	* @return the web d a v propses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WebDAVProps> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the web d a v propses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of web d a v propses to return
	* @param end the upper bound of the range of web d a v propses to return (not inclusive)
	* @return the range of web d a v propses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WebDAVProps> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the web d a v propses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of web d a v propses to return
	* @param end the upper bound of the range of web d a v propses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of web d a v propses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WebDAVProps> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the web d a v props where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C(long classNameId, long classPK)
		throws com.liferay.portal.NoSuchWebDAVPropsException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	* Removes all the web d a v propses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the web d a v propses where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching web d a v propses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	* Counts all the web d a v propses.
	*
	* @return the number of web d a v propses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WebDAVPropsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WebDAVPropsPersistence)PortalBeanLocatorUtil.locate(WebDAVPropsPersistence.class.getName());

			ReferenceRegistry.registerReference(WebDAVPropsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WebDAVPropsPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WebDAVPropsUtil.class,
			"_persistence");
	}

	private static WebDAVPropsPersistence _persistence;
}