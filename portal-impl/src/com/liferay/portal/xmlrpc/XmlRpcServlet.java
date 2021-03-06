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

package com.liferay.portal.xmlrpc;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.xmlrpc.Method;
import com.liferay.portal.kernel.xmlrpc.Response;
import com.liferay.portal.kernel.xmlrpc.XmlRpcConstants;
import com.liferay.portal.kernel.xmlrpc.XmlRpcException;
import com.liferay.portal.kernel.xmlrpc.XmlRpcUtil;
import com.liferay.portal.util.PortalInstances;
import com.liferay.util.servlet.ServletResponseUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class XmlRpcServlet extends HttpServlet {

	public static void registerMethod(Method method) {
		if (method == null) {
			return;
		}

		String token = method.getToken();
		String methodName = method.getMethodName();

		Map<String, Method> tokenMethods = _methodRegistry.get(token);

		if (tokenMethods == null) {
			tokenMethods = new HashMap<String, Method>();

			_methodRegistry.put(token, tokenMethods);
		}

		Method registeredMethod = tokenMethods.get(methodName);

		if (registeredMethod != null) {
			_log.error(
				"There is already an XML-RPC method registered with name " +
					methodName + " at " + token);
		}
		else {
			tokenMethods.put(methodName, method);
		}
	}

	public static void unregisterMethod(Method method) {
		if (method == null) {
			return;
		}

		String token = method.getToken();
		String methodName = method.getMethodName();

		Map<String, Method> tokenMethods = _methodRegistry.get(token);

		if (tokenMethods == null) {
			return;
		}

		tokenMethods.remove(methodName);

		if (tokenMethods.isEmpty()) {
			_methodRegistry.remove(token);
		}
	}

	protected void doPost(
		HttpServletRequest request, HttpServletResponse response) {

		Response xmlRpcResponse = null;

		try {
			long companyId = PortalInstances.getCompanyId(request);

			String token = getToken(request);

			InputStream is = request.getInputStream();

			String xml = StringUtil.read(is);

			Tuple methodTuple = XmlRpcParser.parseMethod(xml);

			String methodName = (String)methodTuple.getObject(0);
			Object[] args = (Object[])methodTuple.getObject(1);

			xmlRpcResponse = invokeMethod(companyId, token, methodName, args);
		}
		catch (IOException ioe) {
			xmlRpcResponse = XmlRpcUtil.createFault(
				XmlRpcConstants.NOT_WELL_FORMED, "XML is not well formed");

			if (_log.isDebugEnabled()) {
				_log.debug(ioe, ioe);
			}
		}
		catch (XmlRpcException xmlrpce) {
			_log.error(xmlrpce, xmlrpce);
		}

		if (xmlRpcResponse == null) {
			xmlRpcResponse = XmlRpcUtil.createFault(
				XmlRpcConstants.SYSTEM_ERROR, "Unknown error occurred");
		}

		response.setCharacterEncoding(StringPool.UTF8);
		response.setContentType(ContentTypes.TEXT_XML);
		response.setStatus(HttpServletResponse.SC_OK);

		try {
			ServletResponseUtil.write(response, xmlRpcResponse.toXml());
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}

			response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
		}
	}

	protected Method getMethod(String token, String methodName) {
		Method method = null;

		Map<String, Method> tokenMethods = _methodRegistry.get(token);

		if (tokenMethods != null) {
			method = tokenMethods.get(methodName);
		}

		return method;
	}

	protected String getToken(HttpServletRequest request) {
		String token = request.getPathInfo();

		return HttpUtil.fixPath(token);
	}

	protected Response invokeMethod(
			long companyId, String token, String methodName, Object[] arguments)
		throws XmlRpcException {

		Method method = getMethod(token, methodName);

		if (method == null) {
			return XmlRpcUtil.createFault(
				XmlRpcConstants.REQUESTED_METHOD_NOT_FOUND,
				"Requested method not found");
		}

		if (!method.setArguments(arguments)) {
			return XmlRpcUtil.createFault(
				XmlRpcConstants.INVALID_METHOD_PARAMETERS,
				"Method arguments are invalid");
		}

		return method.execute(companyId);
	}

	private static Log _log = LogFactoryUtil.getLog(XmlRpcServlet.class);

	private static Map<String, Map<String, Method>> _methodRegistry =
		new HashMap<String, Map<String, Method>>();

}