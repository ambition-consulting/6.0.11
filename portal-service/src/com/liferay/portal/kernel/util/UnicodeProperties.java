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

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This is a rewrite of java.util.Properties that is not synchronized and
 * natively supports non-ASCII encodings. It can also be configured to be
 * "safe", allowing the values to have new line characters. When stored to a
 * given BufferedWriter, "safe" properties will replace all new line characters
 * with a _SAFE_NEWLINE_CHARACTER_.
 * </p>
 *
 * <p>
 * In its current form, this is not intended to replace java.util.Properties for
 * reading properties flat files. This class is not thread-safe.
 * </p>
 *
 * @author Alexander Chow
 */
public class UnicodeProperties extends HashMap<String, String> {

	public UnicodeProperties() {
		super();
	}

	public UnicodeProperties(boolean safe) {
		super();

		_safe = safe;
	}

	public void fastLoad(String props) {
		if (Validator.isNull(props)) {
			return;
		}

		int x = props.indexOf(CharPool.NEW_LINE);
		int y = 0;

		while (x != -1) {
			put(props.substring(y, x));

			y = x;

			x = props.indexOf(CharPool.NEW_LINE, y + 1);
		}

		put(props.substring(y));
	}

	public String getProperty(String key) {
		return get(key);
	}

	public String getProperty(String key, String defaultValue) {
		String value = getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else {
			return value;
		}
	}

	public boolean isSafe() {
		return _safe;
	}

	public void load(String props) throws IOException {
		if (Validator.isNull(props)) {
			return;
		}

		UnsyncBufferedReader unsyncBufferedReader = null;

		try {
			unsyncBufferedReader = new UnsyncBufferedReader(
				new UnsyncStringReader(props));

			String line = unsyncBufferedReader.readLine();

			while (line != null) {
				put(line);
				line = unsyncBufferedReader.readLine();
			}
		}
		finally {
			if (unsyncBufferedReader != null) {
				try {
					unsyncBufferedReader.close();
				}
				catch (Exception e) {
				}
			}
		}
	}

	private void put(String line) {
		line = line.trim();

		if (!_isComment(line)) {
			int pos = line.indexOf(CharPool.EQUAL);

			if (pos != -1) {
				String key = line.substring(0, pos).trim();
				String value = line.substring(pos + 1).trim();

				if (_safe) {
					value = _decode(value);
				}

				setProperty(key, value);
			}
			else {
				_log.error("Invalid property on line " + line);
			}
		}
	}

	public String put(String key, String value) {
		if (key == null) {
			return null;
		}
		else {
			if (value == null) {
				return remove(key);
			}
			else {
				_length += key.length() + value.length() + 2;

				return super.put(key, value);
			}
		}
	}

	public String remove(Object key) {
		if ((key == null) || !containsKey(key)) {
			return null;
		}
		else {
			String keyString = (String)key;

			String value = super.remove(key);

			_length -= keyString.length() + value.length() + 2;

			return value;
		}
	}

	public String setProperty(String key, String value) {
		return put(key, value);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(_length);

		for (Map.Entry<String, String> entry : entrySet()) {
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				if (_safe) {
					value = _encode(value);
				}

				sb.append(entry.getKey());
				sb.append(StringPool.EQUAL);
				sb.append(value);
				sb.append(StringPool.NEW_LINE);
			}
		}

		return sb.toString();
	}

	protected int getToStringLength() {
		return _length;
	}

	private static String _decode(String value) {
		return StringUtil.replace(
			value, _SAFE_NEWLINE_CHARACTER, StringPool.NEW_LINE);
	}

	private static String _encode(String value) {
		return StringUtil.replace(
			value,
			new String[] {
				StringPool.RETURN_NEW_LINE, StringPool.NEW_LINE,
				StringPool.RETURN
			},
			new String[] {
				_SAFE_NEWLINE_CHARACTER, _SAFE_NEWLINE_CHARACTER,
				_SAFE_NEWLINE_CHARACTER
			});
	}

	private boolean _isComment(String line) {
		return line.length() == 0 || line.startsWith(StringPool.POUND);
	}

	private static final String _SAFE_NEWLINE_CHARACTER =
		"_SAFE_NEWLINE_CHARACTER_";

	private static Log _log = LogFactoryUtil.getLog(UnicodeProperties.class);

	private boolean _safe = false;
	private int _length;

}