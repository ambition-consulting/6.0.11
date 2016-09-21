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
import com.liferay.portal.service.OrgLaborServiceUtil;

/**
 * <p>
 * This class provides a HTTP utility for the
 * {@link com.liferay.portal.service.OrgLaborServiceUtil} service utility. The
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
 * @see       OrgLaborServiceSoap
 * @see       com.liferay.portal.security.auth.HttpPrincipal
 * @see       com.liferay.portal.service.OrgLaborServiceUtil
 * @generated
 */
public class OrgLaborServiceHttp {
	public static com.liferay.portal.model.OrgLabor addOrgLabor(
		HttpPrincipal httpPrincipal, long organizationId, int typeId,
		int sunOpen, int sunClose, int monOpen, int monClose, int tueOpen,
		int tueClose, int wedOpen, int wedClose, int thuOpen, int thuClose,
		int friOpen, int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(OrgLaborServiceUtil.class.getName(),
					"addOrgLabor", _addOrgLaborParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					organizationId, typeId, sunOpen, sunClose, monOpen,
					monClose, tueOpen, tueClose, wedOpen, wedClose, thuOpen,
					thuClose, friOpen, friClose, satOpen, satClose);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
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

			return (com.liferay.portal.model.OrgLabor)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteOrgLabor(HttpPrincipal httpPrincipal,
		long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(OrgLaborServiceUtil.class.getName(),
					"deleteOrgLabor", _deleteOrgLaborParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					orgLaborId);

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

	public static com.liferay.portal.model.OrgLabor getOrgLabor(
		HttpPrincipal httpPrincipal, long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(OrgLaborServiceUtil.class.getName(),
					"getOrgLabor", _getOrgLaborParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					orgLaborId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
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

			return (com.liferay.portal.model.OrgLabor)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.portal.model.OrgLabor> getOrgLabors(
		HttpPrincipal httpPrincipal, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(OrgLaborServiceUtil.class.getName(),
					"getOrgLabors", _getOrgLaborsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
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

			return (java.util.List<com.liferay.portal.model.OrgLabor>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.model.OrgLabor updateOrgLabor(
		HttpPrincipal httpPrincipal, long orgLaborId, int typeId, int sunOpen,
		int sunClose, int monOpen, int monClose, int tueOpen, int tueClose,
		int wedOpen, int wedClose, int thuOpen, int thuClose, int friOpen,
		int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(OrgLaborServiceUtil.class.getName(),
					"updateOrgLabor", _updateOrgLaborParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					orgLaborId, typeId, sunOpen, sunClose, monOpen, monClose,
					tueOpen, tueClose, wedOpen, wedClose, thuOpen, thuClose,
					friOpen, friClose, satOpen, satClose);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
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

			return (com.liferay.portal.model.OrgLabor)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OrgLaborServiceHttp.class);
	private static final Class<?>[] _addOrgLaborParameterTypes0 = new Class[] {
			long.class, int.class, int.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class
		};
	private static final Class<?>[] _deleteOrgLaborParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getOrgLaborParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getOrgLaborsParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateOrgLaborParameterTypes4 = new Class[] {
			long.class, int.class, int.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class
		};
}