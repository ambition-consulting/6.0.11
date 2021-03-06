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

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class MimeResponseImpl
	extends PortletResponseImpl implements MimeResponse {

	public boolean isCalledFlushBuffer() {
		return _calledFlushBuffer;
	}

	public void flushBuffer() throws IOException {
		_response.flushBuffer();

		_calledFlushBuffer = true;
	}

	public int getBufferSize() {
		return _response.getBufferSize();
	}

	public CacheControl getCacheControl() {
		return new CacheControlImpl(null, 0, false, false, this);
	}

	public String getCharacterEncoding() {
		return _response.getCharacterEncoding();
	}

	public String getContentType() {
		return _contentType;
	}

	public Locale getLocale() {
		return _portletRequestImpl.getLocale();
	}

	public OutputStream getPortletOutputStream() throws IOException {
		if (_calledGetWriter) {
			throw new IllegalStateException(
				"Cannot obtain OutputStream because Writer is already in use");
		}

		if (_contentType == null) {
			setContentType(_portletRequestImpl.getResponseContentType());
		}

		_calledGetPortletOutputStream = true;

		return _response.getOutputStream();
	}

	public PrintWriter getWriter() throws IOException {
		if (_calledGetPortletOutputStream) {
			throw new IllegalStateException(
				"Cannot obtain Writer because OutputStream is already in use");
		}

		if (_contentType == null) {
			setContentType(_portletRequestImpl.getResponseContentType());
		}

		_calledGetWriter = true;

		return _response.getWriter();
	}

	public boolean isCalledGetPortletOutputStream() {
		return _calledGetPortletOutputStream;
	}

	public boolean isCalledGetWriter() {
		return _calledGetWriter;
	}

	public boolean isCommitted() {
		return false;
	}

	public void reset() {
		if (_calledFlushBuffer) {
			throw new IllegalStateException(
				"Cannot reset a buffer that has been flushed");
		}
	}

	public void resetBuffer() {
		if (_calledFlushBuffer) {
			throw new IllegalStateException(
				"Cannot reset a buffer that has been flushed");
		}

		_response.resetBuffer();
	}

	public void setBufferSize(int bufferSize) {
		_response.setBufferSize(bufferSize);
	}

	public void setContentType(String contentType) {
		if (Validator.isNull(contentType)) {
			throw new IllegalArgumentException("Content type cannot be null");
		}

		Enumeration<String> enu = _portletRequestImpl.getResponseContentTypes();

		boolean valid = false;

		if (getLifecycle().equals(PortletRequest.RESOURCE_PHASE) ||
			_portletRequestImpl.getWindowState().equals(
				LiferayWindowState.EXCLUSIVE)) {

			valid = true;
		}
		else {
			while (enu.hasMoreElements()) {
				String resContentType = enu.nextElement();

				if (contentType.startsWith(resContentType)) {
					valid = true;

					break;
				}
			}
		}

		if (!valid) {
			throw new IllegalArgumentException(
				contentType + " is not a supported mime type");
		}

		_contentType = contentType;

		_response.setContentType(contentType);
	}

	protected void init(
		PortletRequestImpl portletRequestImpl, HttpServletResponse response,
		String portletName, long companyId, long plid) {

		super.init(portletRequestImpl, response, portletName, companyId, plid);

		_portletRequestImpl = portletRequestImpl;
		_response = response;
	}

	private PortletRequestImpl _portletRequestImpl;
	private HttpServletResponse _response;
	private String _contentType;
	private boolean _calledGetPortletOutputStream;
 	private boolean _calledGetWriter;
 	private boolean _calledFlushBuffer;

}