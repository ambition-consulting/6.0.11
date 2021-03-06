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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the portlet item local service. This utility wraps {@link com.liferay.portal.service.impl.PortletItemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletItemLocalService
 * @see com.liferay.portal.service.base.PortletItemLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.PortletItemLocalServiceImpl
 * @generated
 */
public class PortletItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.PortletItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the portlet item to the database. Also notifies the appropriate model listeners.
	*
	* @param portletItem the portlet item to add
	* @return the portlet item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletItem addPortletItem(
		com.liferay.portal.model.PortletItem portletItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortletItem(portletItem);
	}

	/**
	* Creates a new portlet item with the primary key. Does not add the portlet item to the database.
	*
	* @param portletItemId the primary key for the new portlet item
	* @return the new portlet item
	*/
	public static com.liferay.portal.model.PortletItem createPortletItem(
		long portletItemId) {
		return getService().createPortletItem(portletItemId);
	}

	/**
	* Deletes the portlet item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletItemId the primary key of the portlet item to delete
	* @throws PortalException if a portlet item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePortletItem(long portletItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePortletItem(portletItemId);
	}

	/**
	* Deletes the portlet item from the database. Also notifies the appropriate model listeners.
	*
	* @param portletItem the portlet item to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePortletItem(
		com.liferay.portal.model.PortletItem portletItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePortletItem(portletItem);
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
	* Gets the portlet item with the primary key.
	*
	* @param portletItemId the primary key of the portlet item to get
	* @return the portlet item
	* @throws PortalException if a portlet item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletItem getPortletItem(
		long portletItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletItem(portletItemId);
	}

	/**
	* Gets a range of all the portlet items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet items to return
	* @param end the upper bound of the range of portlet items to return (not inclusive)
	* @return the range of portlet items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PortletItem> getPortletItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletItems(start, end);
	}

	/**
	* Gets the number of portlet items.
	*
	* @return the number of portlet items
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortletItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletItemsCount();
	}

	/**
	* Updates the portlet item in the database. Also notifies the appropriate model listeners.
	*
	* @param portletItem the portlet item to update
	* @return the portlet item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletItem updatePortletItem(
		com.liferay.portal.model.PortletItem portletItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortletItem(portletItem);
	}

	/**
	* Updates the portlet item in the database. Also notifies the appropriate model listeners.
	*
	* @param portletItem the portlet item to update
	* @param merge whether to merge the portlet item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PortletItem updatePortletItem(
		com.liferay.portal.model.PortletItem portletItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortletItem(portletItem, merge);
	}

	public static com.liferay.portal.model.PortletItem addPortletItem(
		long userId, long groupId, java.lang.String name,
		java.lang.String portletId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPortletItem(userId, groupId, name, portletId, className);
	}

	public static com.liferay.portal.model.PortletItem getPortletItem(
		long groupId, java.lang.String name, java.lang.String portletId,
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletItem(groupId, name, portletId, className);
	}

	public static java.util.List<com.liferay.portal.model.PortletItem> getPortletItems(
		long groupId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletItems(groupId, className);
	}

	public static java.util.List<com.liferay.portal.model.PortletItem> getPortletItems(
		long groupId, java.lang.String portletId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletItems(groupId, portletId, className);
	}

	public static com.liferay.portal.model.PortletItem updatePortletItem(
		long userId, long groupId, java.lang.String name,
		java.lang.String portletId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePortletItem(userId, groupId, name, portletId,
			className);
	}

	public static PortletItemLocalService getService() {
		if (_service == null) {
			_service = (PortletItemLocalService)PortalBeanLocatorUtil.locate(PortletItemLocalService.class.getName());

			ReferenceRegistry.registerReference(PortletItemLocalServiceUtil.class,
				"_service");
			MethodCache.remove(PortletItemLocalService.class);
		}

		return _service;
	}

	public void setService(PortletItemLocalService service) {
		MethodCache.remove(PortletItemLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(PortletItemLocalServiceUtil.class,
			"_service");
		MethodCache.remove(PortletItemLocalService.class);
	}

	private static PortletItemLocalService _service;
}