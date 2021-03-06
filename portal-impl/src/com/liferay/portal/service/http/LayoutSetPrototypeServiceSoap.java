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
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.portal.service.LayoutSetPrototypeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.portal.model.LayoutSetPrototypeSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.portal.model.LayoutSetPrototype}, that is translated to a
 * {@link com.liferay.portal.model.LayoutSetPrototypeSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <b>tunnel.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutSetPrototypeServiceHttp
 * @see       com.liferay.portal.model.LayoutSetPrototypeSoap
 * @see       com.liferay.portal.service.LayoutSetPrototypeServiceUtil
 * @generated
 */
public class LayoutSetPrototypeServiceSoap {
	public static void deleteLayoutSetPrototype(long layoutSetPrototypeId)
		throws RemoteException {
		try {
			LayoutSetPrototypeServiceUtil.deleteLayoutSetPrototype(layoutSetPrototypeId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.LayoutSetPrototypeSoap getLayoutSetPrototype(
		long layoutSetPrototypeId) throws RemoteException {
		try {
			com.liferay.portal.model.LayoutSetPrototype returnValue = LayoutSetPrototypeServiceUtil.getLayoutSetPrototype(layoutSetPrototypeId);

			return com.liferay.portal.model.LayoutSetPrototypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.LayoutSetPrototypeSoap[] search(
		long companyId, java.lang.Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.LayoutSetPrototype> returnValue =
				LayoutSetPrototypeServiceUtil.search(companyId, active, obc);

			return com.liferay.portal.model.LayoutSetPrototypeSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LayoutSetPrototypeServiceSoap.class);
}