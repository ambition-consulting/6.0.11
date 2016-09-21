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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Alexander Chow
 */
public class SerializableUtil {

	public static Object deserialize(byte[] bytes)
		throws ClassNotFoundException, IOException {

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new UnsyncByteArrayInputStream(bytes));

			Object obj = ois.readObject();

			ois.close();

			ois = null;

			return obj;
		}
		finally {
			if (ois != null) {
				ois.close();
			}
		}
	}

	public static byte[] serialize(Object obj) throws IOException {
		ObjectOutputStream oos = null;

		try {
			UnsyncByteArrayOutputStream ubaos =
				new UnsyncByteArrayOutputStream();

			oos = new ObjectOutputStream(ubaos);

			oos.writeObject(obj);

			oos.close();

			oos = null;

			return ubaos.toByteArray();
		}
		finally {
			if (oos != null) {
				oos.close();
			}
		}
	}

}