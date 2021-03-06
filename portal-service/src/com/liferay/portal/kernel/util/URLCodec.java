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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.charset.CharsetDecoderUtil;
import com.liferay.portal.kernel.nio.charset.CharsetEncoderUtil;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import java.util.BitSet;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class URLCodec {

	public static String decodeURL(String encodedURLString) {
		return decodeURL(encodedURLString, StringPool.UTF8, false);
	}

	public static String decodeURL(
		String encodedURLString, boolean unescapeSpaces) {

		return decodeURL(encodedURLString, StringPool.UTF8, unescapeSpaces);
	}

	public static String decodeURL(
		String encodedURLString, String charsetName, boolean unescapeSpaces) {

		if (encodedURLString == null) {
			return null;
		}

		if (encodedURLString.length() == 0) {
			return StringPool.BLANK;
		}

		/*if (unescapeSpaces) {
			encodedURLString = StringUtil.replace(
				encodedURLString, "%20", StringPool.PLUS);
		}*/

		StringBuilder sb = new StringBuilder(encodedURLString.length());

		CharsetDecoder charsetDecoder = null;

		boolean modified = false;

		for (int i = 0; i < encodedURLString.length(); i++) {
			char c = encodedURLString.charAt(i);

			if (c == CharPool.PERCENT) {
				ByteBuffer byteBuffer = _getEncodedByteBuffer(
					encodedURLString, i);

				if (charsetDecoder == null) {
					charsetDecoder = CharsetDecoderUtil.getCharsetDecoder(
						charsetName);
				}

				CharBuffer charBuffer = null;

				try {
					charBuffer = charsetDecoder.decode(byteBuffer);
				}
				catch (CharacterCodingException cce) {
					_log.error(cce, cce);

					return StringPool.BLANK;
				}

				sb.append(charBuffer);

				i += byteBuffer.capacity() * 3 - 1;
			}
			else if (c == CharPool.PLUS) {
				sb.append(CharPool.SPACE);

				modified = true;
			}
			else {
				sb.append(c);
			}
		}

		if (!modified && (sb.length() == encodedURLString.length())) {
			return encodedURLString;
		}
		else {
			return sb.toString();
		}
	}

	public static String encodeURL(String rawURLString) {
		return encodeURL(rawURLString, StringPool.UTF8, false);
	}

	public static String encodeURL(String rawURLString, boolean escapeSpaces) {
		return encodeURL(rawURLString, StringPool.UTF8, escapeSpaces);
	}

	public static String encodeURL(
		String rawURLString, String charsetName, boolean escapeSpaces) {

		if (rawURLString == null) {
			return null;
		}

		if (rawURLString.length() == 0) {
			return StringPool.BLANK;
		}

		StringBuilder sb = new StringBuilder(rawURLString.length());

		CharsetEncoder charsetEncoder = null;

		char[] hexes = new char[2];

		boolean modified = false;

		for (int i = 0; i < rawURLString.length(); i++) {
			char c = rawURLString.charAt(i);

			if (_validChars.get(c)) {
				sb.append(c);
			}
			else if (c == CharPool.SPACE) {
				if (escapeSpaces) {
					sb.append("%20");
				}
				else {
					sb.append(CharPool.PLUS);
				}

				modified = true;
			}
			else {
				CharBuffer charBuffer = _getRawCharBuffer(rawURLString, i);

				if (charsetEncoder == null) {
					charsetEncoder = CharsetEncoderUtil.getCharsetEncoder(
						charsetName);
				}

				i += charBuffer.length() - 1;

				ByteBuffer byteBuffer = null;

				try {
					byteBuffer = charsetEncoder.encode(charBuffer);
				}
				catch (CharacterCodingException cce) {
					_log.error(cce, cce);

					return StringPool.BLANK;
				}

				for (int j = byteBuffer.position(); j < byteBuffer.limit();
						j++) {

					sb.append(CharPool.PERCENT);
					sb.append(
						UnicodeFormatter.byteToHex(byteBuffer.get(), hexes));
				}
			}
		}

		if (!modified && (sb.length() == rawURLString.length())) {
			return rawURLString;
		}
		else {
			return sb.toString();
		}
	}

	private static int _charToHex(char c) {
		if ((c >= CharPool.LOWER_CASE_A) && (c <= CharPool.LOWER_CASE_Z)) {
			return c - CharPool.LOWER_CASE_A + 10;
		}

		if ((c >= CharPool.UPPER_CASE_A) && (c <= CharPool.UPPER_CASE_Z)) {
			return c - CharPool.UPPER_CASE_A + 10;
		}

		if ((c >= CharPool.NUMBER_0) && (c <= CharPool.NUMBER_9)) {
			return c - CharPool.NUMBER_0;
		}

		throw new IllegalArgumentException(c + " is not a hex char");
	}

	private static ByteBuffer _getEncodedByteBuffer(
		String encodedString, int start) {

		int count = 1;

		for (int i = start + 3; i < encodedString.length(); i += 3) {
			if (encodedString.charAt(i) == CharPool.PERCENT) {
				count++;
			}
			else {
				break;
			}
		}

		ByteBuffer byteBuffer = ByteBuffer.allocate(count);

		for (int i = start; i < start + count * 3; i += 3) {
			int high = _charToHex(encodedString.charAt(i + 1));
			int low = _charToHex(encodedString.charAt(i + 2));

			byteBuffer.put((byte)((high << 4) + low));
		}

		byteBuffer.flip();

		return byteBuffer;
	}

	private static CharBuffer _getRawCharBuffer(String rawString, int start) {
		int count = 0;

		for (int i = start; i < rawString.length(); i++) {
			char rawChar = rawString.charAt(i);

			if (!_validChars.get(rawChar)) {
				count++;

				if (Character.isHighSurrogate(rawChar)) {
					if (((i + 1) < rawString.length()) &&
						Character.isLowSurrogate(rawString.charAt(i + 1))) {

						count++;
					}
				}
			}
			else {
				break;
			}
		}

		return CharBuffer.wrap(rawString, start, start + count);
	}

	private static Log _log = LogFactoryUtil.getLog(URLCodec.class);

	private static BitSet _validChars = new BitSet(256);

	static {
		for (int i = 'a'; i <= 'z'; i++) {
			_validChars.set(i);
		}

		for (int i = 'A'; i <= 'Z'; i++) {
			_validChars.set(i);
		}

		for (int i = '0'; i <= '9'; i++) {
			_validChars.set(i);
		}

		_validChars.set('-');
		_validChars.set('_');
		_validChars.set('.');
		_validChars.set('*');
	}

}