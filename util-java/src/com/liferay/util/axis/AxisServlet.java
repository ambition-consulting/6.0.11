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

package com.liferay.util.axis;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.StringServletResponse;
import com.liferay.portal.kernel.servlet.UncommittedServletResponse;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.util.servlet.ServletResponseUtil;

import java.io.IOException;

import java.lang.reflect.Field;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.cache.MethodCache;

/**
 * @author Brian Wing Shun Chan
 */
public class AxisServlet extends org.apache.axis.transport.http.AxisServlet {

	public void destroy() {
		if (ServerDetector.isWebLogic()) {
			doDestroy();
		}
		else {
			DestroyThread destroyThread = new DestroyThread();

			destroyThread.start();

			try {
				destroyThread.join();
			}
			catch (InterruptedException ie) {
				throw new RuntimeException(ie);
			}

			Exception e = destroyThread.getException();

			if (e != null) {
				if (e instanceof RuntimeException) {
					throw (RuntimeException)e;
				}
				else {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		_servletConfig = servletConfig;

		if (ServerDetector.isResin() || ServerDetector.isWebLogic()) {
			doInit();
		}
		else {
			InitThread initThread = new InitThread();

			initThread.start();

			try {
				initThread.join();
			}
			catch (InterruptedException ie) {
				throw new ServletException(ie);
			}

			Exception e = initThread.getException();

			if (e != null) {
				if (e instanceof ServletException) {
					throw (ServletException)e;
				}
				else {
					throw new ServletException(e);
				}
			}
		}
	}

	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		try {
			if (!_ready) {
				return;
			}

			StringServletResponse stringResponse = new StringServletResponse(
				response);

			super.service(request, stringResponse);

			String contentType = stringResponse.getContentType();

			response.setContentType(contentType);

			String content = stringResponse.getString();

			if (_fixContent) {
				if (contentType.contains(ContentTypes.TEXT_HTML)) {
					content = _HTML_TOP_WRAPPER.concat(content).concat(
						_HTML_BOTTOM_WRAPPER);
				}
				else if (contentType.contains(ContentTypes.TEXT_XML)) {
					content = fixXml(content);
				}
			}

			ServletResponseUtil.write(
				new UncommittedServletResponse(response),
				content.getBytes(StringPool.UTF8));
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (ServletException se) {
			throw se;
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
		finally {
			try {
				ThreadLocal<?> cache = (ThreadLocal<?>)_cacheField.get(null);

				if (cache != null) {
					cache.remove();
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
	}

	protected void doDestroy() {
		_ready = false;

		super.destroy();
	}

	protected void doInit() throws ServletException {
		super.init(_servletConfig);

		_fixContent = GetterUtil.getBoolean(
			_servletConfig.getInitParameter("fix-content"), true);

		_ready = true;
	}

	protected String fixXml(String xml) throws Exception {
		if (xml.indexOf("<wsdl:definitions") == -1) {
			return xml;
		}

		xml = StringUtil.replace(
			xml,
			new String[] {
				"\r\n",
				"\n",
				"  ",
				"> <",
				_INCORRECT_LONG_ARRAY,
				_INCORRECT_STRING_ARRAY
			},
			new String[] {
				StringPool.BLANK,
				StringPool.BLANK,
				StringPool.BLANK,
				"><",
				_CORRECT_LONG_ARRAY,
				_CORRECT_STRING_ARRAY
			});

		Document document = SAXReaderUtil.read(xml);

		return document.formattedString();
	}

	private static final String _CORRECT_LONG_ARRAY =
		"<complexType name=\"ArrayOf_xsd_long\"><complexContent>" +
			"<restriction base=\"soapenc:Array\"><attribute ref=\"soapenc:" +
				"arrayType\" wsdl:arrayType=\"soapenc:long[]\"/>" +
					"</restriction></complexContent></complexType>";

	private static final String _CORRECT_STRING_ARRAY =
		"<complexType name=\"ArrayOf_xsd_string\"><complexContent>" +
			"<restriction base=\"soapenc:Array\"><attribute ref=\"soapenc:" +
				"arrayType\" wsdl:arrayType=\"soapenc:string[]\"/>" +
					"</restriction></complexContent></complexType>";

	private static final String _HTML_BOTTOM_WRAPPER = "</body></html>";

	private static final String _HTML_TOP_WRAPPER = "<html><body>";

	private static final String _INCORRECT_LONG_ARRAY =
		"<complexType name=\"ArrayOf_xsd_long\"><simpleContent><extension/>" +
			"</simpleContent></complexType>";

	private static final String _INCORRECT_STRING_ARRAY =
		"<complexType name=\"ArrayOf_xsd_string\"><simpleContent><extension/>" +
			"</simpleContent></complexType>";

	private static Log _log = LogFactoryUtil.getLog(AxisServlet.class);

	private static Field _cacheField;

	private boolean _fixContent;
	private boolean _ready;
	private ServletConfig _servletConfig;

	private class DestroyThread extends Thread {

		public DestroyThread() {
			setDaemon(true);
		}

		public Exception getException() {
			return _exception;
		}

		public void run() {
			try {
				doDestroy();
			}
			catch (Exception e) {
				_exception = e;
			}
		}

		private Exception _exception;

	}

	private class InitThread extends Thread {

		public InitThread() {
			setDaemon(true);
		}

		public Exception getException() {
			return _exception;
		}

		public void run() {
			try {
				doInit();
			}
			catch (Exception e) {
				_exception = e;
			}
		}

		private Exception _exception;

	}

	static {
		try {
			_cacheField = ReflectionUtil.getDeclaredField(
				MethodCache.class, "cache");
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

}