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

import java.io.OutputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class DummyOutputStream extends OutputStream {

	public void close() {
	}

	public void flush() {
	}

	public void write(byte[] bytes) {
	}

	public void write(byte[] bytes, int offset, int length) {
	}

	public void write(int b) {
	}

}