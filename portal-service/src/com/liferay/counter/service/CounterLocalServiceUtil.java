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

package com.liferay.counter.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the counter local service. This utility wraps {@link com.liferay.counter.service.impl.CounterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CounterLocalService
 * @see com.liferay.counter.service.base.CounterLocalServiceBaseImpl
 * @see com.liferay.counter.service.impl.CounterLocalServiceImpl
 * @generated
 */
public class CounterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.counter.service.impl.CounterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the counter to the database. Also notifies the appropriate model listeners.
	*
	* @param counter the counter to add
	* @return the counter that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.counter.model.Counter addCounter(
		com.liferay.counter.model.Counter counter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCounter(counter);
	}

	/**
	* Creates a new counter with the primary key. Does not add the counter to the database.
	*
	* @param name the primary key for the new counter
	* @return the new counter
	*/
	public static com.liferay.counter.model.Counter createCounter(
		java.lang.String name) {
		return getService().createCounter(name);
	}

	/**
	* Deletes the counter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the counter to delete
	* @throws PortalException if a counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCounter(java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCounter(name);
	}

	/**
	* Deletes the counter from the database. Also notifies the appropriate model listeners.
	*
	* @param counter the counter to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCounter(com.liferay.counter.model.Counter counter)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCounter(counter);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the counter with the primary key.
	*
	* @param name the primary key of the counter to get
	* @return the counter
	* @throws PortalException if a counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.counter.model.Counter getCounter(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounter(name);
	}

	/**
	* Gets a range of all the counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of counters to return
	* @param end the upper bound of the range of counters to return (not inclusive)
	* @return the range of counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.counter.model.Counter> getCounters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounters(start, end);
	}

	/**
	* Gets the number of counters.
	*
	* @return the number of counters
	* @throws SystemException if a system exception occurred
	*/
	public static int getCountersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountersCount();
	}

	/**
	* Updates the counter in the database. Also notifies the appropriate model listeners.
	*
	* @param counter the counter to update
	* @return the counter that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.counter.model.Counter updateCounter(
		com.liferay.counter.model.Counter counter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCounter(counter);
	}

	/**
	* Updates the counter in the database. Also notifies the appropriate model listeners.
	*
	* @param counter the counter to update
	* @param merge whether to merge the counter with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the counter that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.counter.model.Counter updateCounter(
		com.liferay.counter.model.Counter counter, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCounter(counter, merge);
	}

	public static java.util.List<java.lang.String> getNames()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNames();
	}

	public static long increment()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().increment();
	}

	public static long increment(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().increment(name);
	}

	public static long increment(java.lang.String name, int size)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().increment(name, size);
	}

	public static void rename(java.lang.String oldName, java.lang.String newName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().rename(oldName, newName);
	}

	public static void reset(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().reset(name);
	}

	public static void reset(java.lang.String name, long size)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().reset(name, size);
	}

	public static CounterLocalService getService() {
		if (_service == null) {
			_service = (CounterLocalService)PortalBeanLocatorUtil.locate(CounterLocalService.class.getName());

			ReferenceRegistry.registerReference(CounterLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CounterLocalService.class);
		}

		return _service;
	}

	public void setService(CounterLocalService service) {
		MethodCache.remove(CounterLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CounterLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CounterLocalService.class);
	}

	private static CounterLocalService _service;
}