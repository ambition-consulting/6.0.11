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

package com.liferay.util.servlet;

import java.io.IOException;

import javax.servlet.ServletInputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class ServletInputStreamWrapper extends ServletInputStream {

	public ServletInputStreamWrapper(ServletInputStream is) {
		_is = is;
	}

	public int available() throws IOException {
		return _is.available();
	}

	public void close() throws IOException {
		_is.close();
	}

	public void mark(int readlimit) {
		_is.mark(readlimit);
	}

	public boolean markSupported() {
		return _is.markSupported();
	}

	public int read() throws IOException {
		return _is.read();
	}

	public int read(byte[] b) throws IOException {
		return _is.read(b);
	}

	public int read(byte[] b, int off, int len) throws IOException {
		return _is.read(b, off, len);
	}

	public int readLine(byte[] b, int off, int len) throws IOException {
		return _is.readLine(b, off, len);
	}

	public void reset() throws IOException {
		_is.reset();
	}

	public long skip(long n) throws IOException {
		return _is.skip(n);
	}

	private ServletInputStream _is;

}