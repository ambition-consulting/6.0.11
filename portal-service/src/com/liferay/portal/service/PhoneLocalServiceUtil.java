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
 * The utility for the phone local service. This utility wraps {@link com.liferay.portal.service.impl.PhoneLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhoneLocalService
 * @see com.liferay.portal.service.base.PhoneLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.PhoneLocalServiceImpl
 * @generated
 */
public class PhoneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.PhoneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the phone to the database. Also notifies the appropriate model listeners.
	*
	* @param phone the phone to add
	* @return the phone that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Phone addPhone(
		com.liferay.portal.model.Phone phone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPhone(phone);
	}

	/**
	* Creates a new phone with the primary key. Does not add the phone to the database.
	*
	* @param phoneId the primary key for the new phone
	* @return the new phone
	*/
	public static com.liferay.portal.model.Phone createPhone(long phoneId) {
		return getService().createPhone(phoneId);
	}

	/**
	* Deletes the phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param phoneId the primary key of the phone to delete
	* @throws PortalException if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePhone(long phoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePhone(phoneId);
	}

	/**
	* Deletes the phone from the database. Also notifies the appropriate model listeners.
	*
	* @param phone the phone to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePhone(com.liferay.portal.model.Phone phone)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePhone(phone);
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
	* Gets the phone with the primary key.
	*
	* @param phoneId the primary key of the phone to get
	* @return the phone
	* @throws PortalException if a phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Phone getPhone(long phoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhone(phoneId);
	}

	/**
	* Gets a range of all the phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of phones to return
	* @param end the upper bound of the range of phones to return (not inclusive)
	* @return the range of phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Phone> getPhones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhones(start, end);
	}

	/**
	* Gets the number of phones.
	*
	* @return the number of phones
	* @throws SystemException if a system exception occurred
	*/
	public static int getPhonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhonesCount();
	}

	/**
	* Updates the phone in the database. Also notifies the appropriate model listeners.
	*
	* @param phone the phone to update
	* @return the phone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Phone updatePhone(
		com.liferay.portal.model.Phone phone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePhone(phone);
	}

	/**
	* Updates the phone in the database. Also notifies the appropriate model listeners.
	*
	* @param phone the phone to update
	* @param merge whether to merge the phone with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the phone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Phone updatePhone(
		com.liferay.portal.model.Phone phone, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePhone(phone, merge);
	}

	public static com.liferay.portal.model.Phone addPhone(long userId,
		java.lang.String className, long classPK, java.lang.String number,
		java.lang.String extension, int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPhone(userId, className, classPK, number, extension,
			typeId, primary);
	}

	public static void deletePhones(long companyId, java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePhones(companyId, className, classPK);
	}

	public static java.util.List<com.liferay.portal.model.Phone> getPhones()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhones();
	}

	public static java.util.List<com.liferay.portal.model.Phone> getPhones(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhones(companyId, className, classPK);
	}

	public static com.liferay.portal.model.Phone updatePhone(long phoneId,
		java.lang.String number, java.lang.String extension, int typeId,
		boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePhone(phoneId, number, extension, typeId, primary);
	}

	public static PhoneLocalService getService() {
		if (_service == null) {
			_service = (PhoneLocalService)PortalBeanLocatorUtil.locate(PhoneLocalService.class.getName());

			ReferenceRegistry.registerReference(PhoneLocalServiceUtil.class,
				"_service");
			MethodCache.remove(PhoneLocalService.class);
		}

		return _service;
	}

	public void setService(PhoneLocalService service) {
		MethodCache.remove(PhoneLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(PhoneLocalServiceUtil.class,
			"_service");
		MethodCache.remove(PhoneLocalService.class);
	}

	private static PhoneLocalService _service;
}