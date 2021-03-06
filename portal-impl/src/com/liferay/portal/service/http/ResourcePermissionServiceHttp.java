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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.ResourcePermissionServiceUtil;

/**
 * <p>
 * This class provides a HTTP utility for the
 * {@link com.liferay.portal.service.ResourcePermissionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link com.liferay.portal.security.auth.HttpPrincipal} parameter.
 * </p>
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ResourcePermissionServiceSoap
 * @see       com.liferay.portal.security.auth.HttpPrincipal
 * @see       com.liferay.portal.service.ResourcePermissionServiceUtil
 * @generated
 */
public class ResourcePermissionServiceHttp {
	public static void addResourcePermission(HttpPrincipal httpPrincipal,
		long groupId, long companyId, java.lang.String name, int scope,
		java.lang.String primKey, long roleId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ResourcePermissionServiceUtil.class.getName(),
					"addResourcePermission",
					_addResourcePermissionParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					companyId, name, scope, primKey, roleId, actionId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void setIndividualResourcePermissions(
		HttpPrincipal httpPrincipal, long groupId, long companyId,
		java.lang.String name, java.lang.String primKey, long roleId,
		java.lang.String[] actionIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ResourcePermissionServiceUtil.class.getName(),
					"setIndividualResourcePermissions",
					_setIndividualResourcePermissionsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					companyId, name, primKey, roleId, actionIds);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void removeResourcePermission(HttpPrincipal httpPrincipal,
		long groupId, long companyId, java.lang.String name, int scope,
		java.lang.String primKey, long roleId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ResourcePermissionServiceUtil.class.getName(),
					"removeResourcePermission",
					_removeResourcePermissionParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					companyId, name, scope, primKey, roleId, actionId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void removeResourcePermissions(HttpPrincipal httpPrincipal,
		long groupId, long companyId, java.lang.String name, int scope,
		long roleId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ResourcePermissionServiceUtil.class.getName(),
					"removeResourcePermissions",
					_removeResourcePermissionsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					companyId, name, scope, roleId, actionId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ResourcePermissionServiceHttp.class);
	private static final Class<?>[] _addResourcePermissionParameterTypes0 = new Class[] {
			long.class, long.class, java.lang.String.class, int.class,
			java.lang.String.class, long.class, java.lang.String.class
		};
	private static final Class<?>[] _setIndividualResourcePermissionsParameterTypes1 =
		new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, long.class, java.lang.String[].class
		};
	private static final Class<?>[] _removeResourcePermissionParameterTypes2 = new Class[] {
			long.class, long.class, java.lang.String.class, int.class,
			java.lang.String.class, long.class, java.lang.String.class
		};
	private static final Class<?>[] _removeResourcePermissionsParameterTypes3 = new Class[] {
			long.class, long.class, java.lang.String.class, int.class,
			long.class, java.lang.String.class
		};
}