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

package com.liferay.portal.kernel.io;

import java.io.Writer;

/**
 * @author Shuyang Zhou
 */
public class DummyWriter extends Writer {

	public Writer append(char c) {
		return this;
	}

	public Writer append(CharSequence charSequence) {
		return this;
	}

	public Writer append(CharSequence charSequence, int start, int end) {
		return this;
	}

	public void close() {
	}

	public void flush() {
	}

	public void write(char[] chars) {
	}

	public void write(char[] chars, int offset, int length) {
	}

	public void write(int c) {
	}

	public void write(String string) {
	}

	public void write(String string, int offset, int length) {
	}

}