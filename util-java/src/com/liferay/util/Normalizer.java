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

package com.liferay.util;

import com.liferay.ibm.icu.text.Transliterator;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class Normalizer {

	public static String normalizeToAscii(String s) {
		String normalizedText = _transliterator.transform(s);

		return StringUtil.replace(
			normalizedText, _UNICODE_TEXT, _NORMALIZED_TEXT);
	}

	private static final String[] _NORMALIZED_TEXT = {"l"};

	private static final String[] _UNICODE_TEXT = {"\u0142"};

	private static Transliterator _transliterator =
		Transliterator.getInstance("NFD; [:Nonspacing Mark:] Remove; NFC");

}