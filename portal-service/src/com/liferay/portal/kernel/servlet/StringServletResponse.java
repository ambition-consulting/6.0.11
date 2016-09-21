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

package com.liferay.portal.kernel.servlet;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class StringServletResponse extends HeaderCacheServletResponse {

	public StringServletResponse(HttpServletResponse response) {
		super(response);
	}

	public int getBufferSize() {
		return _bufferSize;
	}

	public void flushBuffer() throws IOException {
		if (_servletOutputStream != null) {
			_unsyncByteArrayOutputStream.flush();
		}
		else if (_printWriter != null) {
			_unsyncStringWriter.flush();
		}
	}

	public ServletOutputStream getOutputStream() {
		if (_printWriter != null) {
			throw new IllegalStateException(
				"Cannot obtain OutputStream because Writer is already in use");
		}

		if (_servletOutputStream == null) {
			_unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
			_servletOutputStream = new PipingServletOutputStream(
				_unsyncByteArrayOutputStream);
		}

		return _servletOutputStream;
	}

	public String getString() {
		if (_string != null) {
			return _string;
		}

		if (_servletOutputStream != null) {
			try {
				_string = _unsyncByteArrayOutputStream.toString(
					StringPool.UTF8);
			}
			catch (UnsupportedEncodingException uee) {
				_log.error(uee, uee);

				_string = StringPool.BLANK;
			}
		}
		else if (_printWriter != null) {
			_string = _unsyncStringWriter.toString();
		}
		else {
			_string = StringPool.BLANK;
		}

		return _string;
	}

	public UnsyncByteArrayOutputStream getUnsyncByteArrayOutputStream() {
		return _unsyncByteArrayOutputStream;
	}

	public PrintWriter getWriter() {
		if (_servletOutputStream != null) {
			throw new IllegalStateException(
				"Cannot obtain Writer because OutputStream is already in use");
		}

		if (_printWriter == null) {
			_unsyncStringWriter = new UnsyncStringWriter();
			_printWriter = new UnsyncPrintWriter(_unsyncStringWriter);
		}

		return _printWriter;
	}

	public boolean isCalledGetOutputStream() {
		if (_servletOutputStream != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isCalledGetWriter() {
		if (_printWriter != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void recycle() {
		_string = null;

		setStatus(SC_OK);

		resetBuffer();
	}

	public void resetBuffer() {
		if (_servletOutputStream != null) {
			_unsyncByteArrayOutputStream.reset();
		}
		else if (_printWriter != null) {
			_unsyncStringWriter.reset();
		}
	}

	public void setBufferSize(int bufferSize) {
		_bufferSize = bufferSize;
	}

	public void setLocale(Locale locale) {
	}

	public void setString(String string) {
		_string = string;
	}

	private static Log _log = LogFactoryUtil.getLog(
		StringServletResponse.class);

	private int _bufferSize;
	private PrintWriter _printWriter;
	private ServletOutputStream _servletOutputStream;
	private String _string;
	private UnsyncByteArrayOutputStream _unsyncByteArrayOutputStream;
	private UnsyncStringWriter _unsyncStringWriter;

}