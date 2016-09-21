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

package com.liferay.portal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class DigesterImpl implements Digester {

	public String digest(String text) {
		return digest(Digester.DEFAULT_ALGORITHM, text);
	}

	public String digest(String algorithm, String... text) {

		if (_BASE_64) {
			byte[] bytes = digestRaw(algorithm, text);

			return Base64.encode(bytes);
		}
		else {
			return digestHex(algorithm, text);
		}
	}

	public String digestHex(String text) {
		return digestHex(Digester.DEFAULT_ALGORITHM, text);
	}

	public String digestHex(String algorithm, String... text) {
		byte[] bytes = digestRaw(algorithm, text);

		return Hex.encodeHexString(bytes);
	}

	public byte[] digestRaw(String text) {
		return digestRaw(Digester.DEFAULT_ALGORITHM, text);
	}

	public byte[] digestRaw(String algorithm, String... text) {
		MessageDigest messageDigest = null;

		try{
			messageDigest = MessageDigest.getInstance(algorithm);

			StringBundler sb = new StringBundler(text.length * 2 - 1);

			for (String t : text) {
				if (sb.length() > 0) {
					sb.append(StringPool.COLON);
				}

				sb.append(t);
			}

			String s = sb.toString();

			messageDigest.update(s.getBytes(Digester.ENCODING));
		}
		catch (NoSuchAlgorithmException nsae) {
			_log.error(nsae, nsae);
		}
		catch (UnsupportedEncodingException uee) {
			_log.error(uee, uee);
		}

		return messageDigest.digest();
	}

	private static final boolean _BASE_64 =
		PropsValues.PASSWORDS_DIGEST_ENCODING.equals("base64");

	private static Log _log = LogFactoryUtil.getLog(Digester.class);

}