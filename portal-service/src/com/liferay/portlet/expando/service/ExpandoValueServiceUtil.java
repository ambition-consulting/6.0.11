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

package com.liferay.portlet.expando.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the expando value remote service. This utility wraps {@link com.liferay.portlet.expando.service.impl.ExpandoValueServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoValueService
 * @see com.liferay.portlet.expando.service.base.ExpandoValueServiceBaseImpl
 * @see com.liferay.portlet.expando.service.impl.ExpandoValueServiceImpl
 * @generated
 */
public class ExpandoValueServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.expando.service.impl.ExpandoValueServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.Object data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addValue(companyId, className, tableName, columnName,
			classPK, data);
	}

	public static com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addValue(companyId, className, tableName, columnName,
			classPK, data);
	}

	public static java.io.Serializable getData(long companyId,
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getData(companyId, className, tableName, columnName, classPK);
	}

	public static com.liferay.portal.kernel.json.JSONObject getJSONData(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJSONData(companyId, className, tableName, columnName,
			classPK);
	}

	public static ExpandoValueService getService() {
		if (_service == null) {
			_service = (ExpandoValueService)PortalBeanLocatorUtil.locate(ExpandoValueService.class.getName());

			ReferenceRegistry.registerReference(ExpandoValueServiceUtil.class,
				"_service");
			MethodCache.remove(ExpandoValueService.class);
		}

		return _service;
	}

	public void setService(ExpandoValueService service) {
		MethodCache.remove(ExpandoValueService.class);

		_service = service;

		ReferenceRegistry.registerReference(ExpandoValueServiceUtil.class,
			"_service");
		MethodCache.remove(ExpandoValueService.class);
	}

	private static ExpandoValueService _service;
}