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

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletInputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class ByteArrayInputStreamWrapper extends ServletInputStream {

	public ByteArrayInputStreamWrapper(
		ByteArrayInputStream byteArrayInputStream) {

		_byteArrayInputStream = byteArrayInputStream;
	}

	public int available() {
		return _byteArrayInputStream.available();
	}

	public void close() throws IOException {
		_byteArrayInputStream.close();
	}

	public void mark(int readLimit) {
		_byteArrayInputStream.mark(readLimit);
	}

	public boolean markSupported() {
		return _byteArrayInputStream.markSupported();
	}

	public int read() {
		return _byteArrayInputStream.read();
	}

	public int read(byte[] bytes) throws IOException {
		return _byteArrayInputStream.read(bytes);
	}

	public int read(byte[] bytes, int offset, int length) {
		return _byteArrayInputStream.read(bytes, offset, length);
	}

	public int readLine(byte[] bytes, int offset, int length) {
		return _byteArrayInputStream.read(bytes, offset, length);
	}

	public void reset() {
		_byteArrayInputStream.reset();
	}

	public long skip(long skip) {
		return _byteArrayInputStream.skip(skip);
	}

	private ByteArrayInputStream _byteArrayInputStream;

}