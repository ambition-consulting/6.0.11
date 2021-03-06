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
import java.io.Reader;

import java.nio.CharBuffer;

/**
 * @author Shuyang Zhou
 */
public class UnsyncCharArrayReader extends Reader {

	public UnsyncCharArrayReader(char[] chars) {
		buffer = chars;
		capacity = chars.length;
		index = 0;
	}

	public UnsyncCharArrayReader(char[] chars, int offset, int length) {
		buffer = chars;
		capacity = Math.min(chars.length, offset + length);
		index = offset;
		markIndex = offset;
	}

	public void close() {
		buffer = null;
	}

	public void mark(int readAheadLimit) throws IOException {
		if (buffer == null) {
			throw new IOException("Stream closed");
		}
		markIndex = index;
	}

	public boolean markSupported() {
		return true;
	}

	public int read() throws IOException {
		if (buffer == null) {
			throw new IOException("Stream closed");
		}

		if (index >= capacity) {
			return -1;
		}
		else {
			return buffer[index++];
		}
	}

	public int read(char[] chars) throws IOException {
		return read(chars, 0, chars.length);
	}

	public int read(char[] chars, int offset, int length)
		throws IOException {

		if (buffer == null) {
			throw new IOException("Stream closed");
		}

		if (length <= 0) {
			return 0;
		}

		if (index >= capacity) {
			return -1;
		}

		int read = length;

		if ((index + read) > capacity) {
			read = capacity - index;
		}

		System.arraycopy(buffer, index, chars, offset, read);

		index += read;

		return read;
	}

	public int read(CharBuffer charBuffer) throws IOException {
		if (buffer == null) {
			throw new IOException("Stream closed");
		}

		int length = charBuffer.remaining();

		if (length <= 0) {
			return 0;
		}

		if (index >= capacity) {
			return -1;
		}

		if ((index + length) > capacity) {
			length = capacity - index;
		}

		charBuffer.put(buffer, index, length);

		index += length;

		return length;
	}

	public boolean ready() throws IOException {
		if (buffer == null) {
			throw new IOException("Stream closed");
		}

		if (capacity > index) {
			return true;
		}
		else {
			return false;
		}
	}

	public void reset() throws IOException {
		if (buffer == null) {
			throw new IOException("Stream closed");
		}

		index = markIndex;
	}

	public long skip(long skip) throws IOException {
		if (buffer == null) {
			throw new IOException("Stream closed");
		}

		if (skip < 0) {
			return 0;
		}

		if (index + skip > capacity) {
			skip = capacity - index;
		}

		index += skip;

		return skip;
	}

	protected char[] buffer;
	protected int capacity;
	protected int index;
	protected int markIndex;

}