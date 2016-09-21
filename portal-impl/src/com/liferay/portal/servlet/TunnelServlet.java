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

package com.liferay.portal.servlet;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodInvoker;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalInstances;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michael Weisser
 * @author Brian Wing Shun Chan
 */
@SuppressWarnings("deprecation")
public class TunnelServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		ObjectInputStream ois = new ObjectInputStream(
			request.getInputStream());

		Object returnObj = null;

		try {
			ObjectValuePair<HttpPrincipal, Object> ovp =
				(ObjectValuePair<HttpPrincipal, Object>)ois.readObject();

			HttpPrincipal httpPrincipal = ovp.getKey();
			Object ovpValue = ovp.getValue();

			MethodHandler methodHandler = null;
			MethodWrapper methodWrapper = null;

			if (ovpValue instanceof MethodHandler) {
				methodHandler = (MethodHandler)ovpValue;
			}
			else {
				methodWrapper = (MethodWrapper)ovpValue;
			}

			if (methodHandler != null) {
				if (!isValidRequest(methodHandler.getClassName())) {
					return;
				}
			}
			else {
				if (!isValidRequest(methodWrapper.getClassName())) {
					return;
				}
			}

			long companyId = PortalInstances.getCompanyId(request);

			if (Validator.isNotNull(httpPrincipal.getLogin())) {
				User user = null;

				try {
					user = UserLocalServiceUtil.getUserByEmailAddress(
						companyId, httpPrincipal.getLogin());
				}
				catch (NoSuchUserException nsue) {
				}

				if (user == null) {
					try {
						user = UserLocalServiceUtil.getUserByScreenName(
							companyId, httpPrincipal.getLogin());
					}
					catch (NoSuchUserException nsue) {
					}
				}

				if (user == null) {
					try {
						user = UserLocalServiceUtil.getUserById(
							GetterUtil.getLong(httpPrincipal.getLogin()));
					}
					catch (NoSuchUserException nsue) {
					}
				}

				if (user != null) {
					PrincipalThreadLocal.setName(user.getUserId());

					PermissionChecker permissionChecker =
						PermissionCheckerFactoryUtil.create(user, true);

					PermissionThreadLocal.setPermissionChecker(
						permissionChecker);
				}
			}

			if (returnObj == null) {
				if (methodHandler != null) {
					returnObj = methodHandler.invoke(true);
				}
				else {
					returnObj = MethodInvoker.invoke(methodWrapper);
				}
			}
		}
		catch (InvocationTargetException ite) {
			returnObj = ite.getCause();

			if (!(returnObj instanceof PortalException)) {
				ite.printStackTrace();

				returnObj = new SystemException();
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		if (returnObj != null) {
			ObjectOutputStream oos = new ObjectOutputStream(
				response.getOutputStream());

			oos.writeObject(returnObj);

			oos.flush();
			oos.close();
		}
	}

	protected boolean isValidRequest(String className) {
		if (className.contains(".service.") &&
			className.endsWith("ServiceUtil") &&
			!className.endsWith("LocalServiceUtil")) {

			return true;
		}
		else {
			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TunnelServlet.class);

}