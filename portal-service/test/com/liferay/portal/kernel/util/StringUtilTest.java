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

import com.liferay.portal.kernel.test.TestCase;

/**
 * @author Alexander Chow
 */
public class StringUtilTest extends TestCase {

	public void testHighlight() throws Exception {
		String original = "Hello World Liferay";
		String expected =
			"<span class=\"highlight\">Hello</span> World " +
				"<span class=\"highlight\">Liferay</span>";

		String actual = StringUtil.highlight(
			original, new String[] {"Hello","Liferay"});

		assertEquals(expected, actual);
	}

	public void testReplaceChar() throws Exception {
		String original = "127.0.0.1";
		String expected = "127_0_0_1";

		String actual = StringUtil.replace(original, '.', '_');

		assertEquals(expected, actual);
	}

	public void testReplaceEmptyString() throws Exception {
		String original = "Hello World HELLO WORLD Hello World";
		String expected = "Hello World HELLO WORLD Hello World";

		String actual = StringUtil.replace(original, "", "Aloha");

		assertEquals(expected, actual);
	}

	public void testReplaceFirstChar() throws Exception {
		String original = "127.0.0.1";
		String expected = "127_0.0.1";

		String actual = StringUtil.replaceFirst(original, '.', '_');

		assertEquals(expected, actual);
	}

	public void testReplaceFirstString() throws Exception {
		String original = "Hello World HELLO WORLD Hello World";
		String expected = "Aloha World HELLO WORLD Hello World";

		String actual = StringUtil.replaceFirst(original, "Hello", "Aloha");

		assertEquals(expected, actual);
	}

	public void testReplaceFirstStringArray() throws Exception {
		String original = "Hello World HELLO WORLD Hello World HELLO WORLD";
		String expected = "Aloha World ALOHA WORLD Hello World HELLO WORLD";

		String actual = StringUtil.replaceFirst(
			original, new String[] {"Hello", "HELLO"},
			new String[] {"Aloha", "ALOHA"});

		assertEquals(expected, actual);
	}

	public void testReplaceLastChar() throws Exception {
		String original = "127.0.0.1";
		String expected = "127.0.0_1";

		String actual = StringUtil.replaceLast(original, '.', '_');

		assertEquals(expected, actual);
	}

	public void testReplaceLastString() throws Exception {
		String original = "Hello World HELLO WORLD Hello World";
		String expected = "Hello World HELLO WORLD Aloha World";

		String actual = StringUtil.replaceLast(original, "Hello", "Aloha");

		assertEquals(expected, actual);
	}

	public void testReplaceLastStringArray() throws Exception {
		String original = "Hello World HELLO WORLD Hello World HELLO WORLD";
		String expected = "Hello World HELLO WORLD Aloha World ALOHA WORLD";

		String actual = StringUtil.replaceLast(
			original, new String[] {"Hello", "HELLO"},
			new String[] {"Aloha", "ALOHA"});

		assertEquals(expected, actual);
	}

	public void testReplaceString() throws Exception {
		String original = "Hello World HELLO WORLD Hello World";
		String expected = "Aloha World HELLO WORLD Aloha World";

		String actual = StringUtil.replace(original, "Hello", "Aloha");

		assertEquals(expected, actual);
	}

	public void testReplaceStringArray() throws Exception {
		String original = "Hello World HELLO WORLD Hello World";
		String expected = "Aloha World ALOHA WORLD Aloha World";

		String actual = StringUtil.replace(
			original, new String[] {"Hello", "HELLO"},
			new String[] {"Aloha", "ALOHA"});

		assertEquals(expected, actual);
	}

	public void testStripChar() {
		String original = " a b  c   d";
		String expected = "abcd";

		String actual = StringUtil.strip(original, ' ');

		assertEquals(expected, actual);
	}

}