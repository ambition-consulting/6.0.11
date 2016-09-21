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

package com.liferay.portal.kernel.io.unsync;

import java.io.IOException;

import javax.servlet.ServletInputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class UnsyncByteArrayInputStreamWrapper extends ServletInputStream {

	public UnsyncByteArrayInputStreamWrapper(
		UnsyncByteArrayInputStream unsyncByteArrayInputStream) {

		_unsyncByteArrayInputStream = unsyncByteArrayInputStream;
	}

	public int available() {
		return _unsyncByteArrayInputStream.available();
	}

	public void close() throws IOException {
		_unsyncByteArrayInputStream.close();
	}

	public void mark(int readLimit) {
		_unsyncByteArrayInputStream.mark(readLimit);
	}

	public boolean markSupported() {
		return _unsyncByteArrayInputStream.markSupported();
	}

	public int read() {
		return _unsyncByteArrayInputStream.read();
	}

	public int read(byte[] bytes) {
		return _unsyncByteArrayInputStream.read(bytes);
	}

	public int read(byte[] bytes, int offset, int length) {
		return _unsyncByteArrayInputStream.read(bytes, offset, length);
	}

	public int readLine(byte[] bytes, int offset, int length) {
		return _unsyncByteArrayInputStream.read(bytes, offset, length);
	}

	public void reset() {
		_unsyncByteArrayInputStream.reset();
	}

	public long skip(long skip) {
		return _unsyncByteArrayInputStream.skip(skip);
	}

	private UnsyncByteArrayInputStream _unsyncByteArrayInputStream;

}