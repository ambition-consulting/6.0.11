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

package com.liferay.portlet.words.util;

import com.liferay.portlet.words.ScramblerException;
import com.liferay.portlet.words.util.comparator.WordComparator;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Brian Wing Shun Chan
 */
public class Scrambler {

	public Scrambler(String word) throws ScramblerException {
		if (word == null || word.length() < 3) {
			throw new ScramblerException();
		}

		_word = word;
		_words = new TreeSet<String>(new WordComparator());
	}

	public String[] scramble() {
		if (_word == null) {
			return new String[0];
		}

		_scramble(0, _word.length(), _word.toCharArray());

		return _words.toArray(new String[_words.size()]);
	}

	private void _rotate(char[] chars, int start) {
		char temp = chars[start];

		for (int i = chars.length - start -1; i > 0; i--) {
			chars[start] = chars[++start];
		}

		chars[start] = temp;
	}

	private void _scramble(int start, int length, char[] chars) {
		if (length == 0) {
			String word = new String(chars);

			for (int i = 3; i <= chars.length; i++) {
				_words.add(word.substring(0, i));
			}
		}
		else {
			for (int i = 0; i < length; i++) {
				_scramble(start + 1, length - 1, chars);
				_rotate(chars, start);
			}
		}
	}

	private String _word;
	private Set<String> _words;

}