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
 * <p>
 * See http://issues.liferay.com/browse/LPS-6648.
 * </p>
 *
 * @author Shuyang Zhou
 */
public class UnsyncStringReader extends Reader {

	public UnsyncStringReader(String string) {
		this.string = string;
		stringLength = string.length();
	}

	public void close() {
		string = null;
	}

	public void mark(int readAheadLimit) throws IOException {
		if (string == null) {
			throw new IOException("String is null");
		}
		markIndex = index;
	}

	public boolean markSupported() {
		return true;
	}

	public int read() throws IOException {
		if (string == null) {
			throw new IOException("String is null");
		}

		if (index >= stringLength) {
			return -1;
		}

		return string.charAt(index++);
	}

	public int read(char[] chars) throws IOException {
		return read(chars, 0, chars.length);
	}

	public int read(char[] chars, int offset, int length)
		throws IOException {

		if (string == null) {
			throw new IOException("String is null");
		}

		if (length <= 0) {
			return 0;
		}

		if (index >= stringLength) {
			return -1;
		}

		int read = length;

		if ((index + read) > stringLength) {
			read = stringLength - index;
		}

		string.getChars(index, index + read, chars, offset);

		index += read;

		return read;
	}

	public int read(CharBuffer charBuffer) throws IOException {
		int remaining = charBuffer.remaining();

		char[] chars = new char[remaining];

		int read = read(chars, 0, remaining);

		if (read > 0) {
			charBuffer.put(chars, 0, read);
		}

		return read;
	}

	public boolean ready() throws IOException {
		if (string == null) {
			throw new IOException("String is null");
		}

		return true;
	}

	public void reset() throws IOException {
		if (string == null) {
			throw new IOException("String is null");
		}

		index = markIndex;
	}

	public long skip(long skip) {
		if (index >= stringLength) {
			return 0;
		}

		if ((skip + index) > stringLength) {
			skip = stringLength - index;
		}

		index += skip;

		return skip;
	}

	protected int index;
	protected int stringLength;
	protected int markIndex;
	protected String string;

}