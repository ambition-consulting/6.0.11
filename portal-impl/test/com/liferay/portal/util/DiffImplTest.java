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

import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.Diff;
import com.liferay.portal.kernel.util.DiffResult;
import com.liferay.portal.kernel.util.DiffUtil;

import java.io.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Farache
 */
public class DiffImplTest extends BaseTestCase {

	public void testOne() {
		Reader reader1 = new UnsyncStringReader("liferay");
		Reader reader2 = new UnsyncStringReader("liferay");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testTwo() {
		Reader reader1 = new UnsyncStringReader("liferay");
		Reader reader2 = new UnsyncStringReader("LifeRay");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		List<String> changedLines = new ArrayList<String>();

		changedLines.add(
			Diff.OPEN_DEL + "l" + Diff.CLOSE_DEL + "ife" + Diff.OPEN_DEL + "r" +
				Diff.CLOSE_DEL + "ay");

		expectedSource.add(new DiffResult(0, changedLines));

		changedLines = new ArrayList<String>();

		changedLines.add(
			Diff.OPEN_INS + "L" + Diff.CLOSE_INS + "ife" + Diff.OPEN_INS + "R" +
				Diff.CLOSE_INS + "ay");

		expectedTarget.add(new DiffResult(0, changedLines));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testThree() {
		Reader reader1 = new UnsyncStringReader("aaa");
		Reader reader2 = new UnsyncStringReader("bbb");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(new DiffResult(0, Diff.CONTEXT_LINE));

		expectedTarget.add(
			new DiffResult(0, Diff.OPEN_INS + "bbb" + Diff.CLOSE_INS));

		expectedSource.add(
			new DiffResult(0, Diff.OPEN_DEL + "aaa" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(0, Diff.CONTEXT_LINE));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testFour() {
		Reader reader1 = new UnsyncStringReader("rahab");
		Reader reader2 = new UnsyncStringReader("boaz");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(new DiffResult(0, Diff.CONTEXT_LINE));

		expectedTarget.add(
			new DiffResult(0, Diff.OPEN_INS + "boaz" + Diff.CLOSE_INS));

		expectedSource.add(
			new DiffResult(0, Diff.OPEN_DEL + "rahab" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(0, Diff.CONTEXT_LINE));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testFive() {
		Reader reader1 = new UnsyncStringReader("aaa\nbbb");
		Reader reader2 = new UnsyncStringReader("ccc\naaa");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(new DiffResult(0, Diff.CONTEXT_LINE));

		expectedTarget.add(
			new DiffResult(0, Diff.OPEN_INS + "ccc" + Diff.CLOSE_INS));

		List<String> changedLines = new ArrayList<String>();

		changedLines.add("aaa");
		changedLines.add(Diff.OPEN_DEL + "bbb" + Diff.CLOSE_DEL);

		expectedSource.add(new DiffResult(1, changedLines));

		changedLines = new ArrayList<String>();

		changedLines.add("aaa");
		changedLines.add(Diff.CONTEXT_LINE);

		expectedTarget.add(new DiffResult(1, changedLines));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testSix() {
		Reader reader1 = new UnsyncStringReader("ccc\naaa");
		Reader reader2 = new UnsyncStringReader("aaa\nbbb");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(
			new DiffResult(0, Diff.OPEN_DEL + "ccc" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(0, Diff.CONTEXT_LINE));

		List<String> changedLines = new ArrayList<String>();

		changedLines.add("aaa");
		changedLines.add(Diff.CONTEXT_LINE);

		expectedSource.add(new DiffResult(1, changedLines));

		changedLines = new ArrayList<String>();

		changedLines.add("aaa");
		changedLines.add(Diff.OPEN_INS + "bbb" + Diff.CLOSE_INS);

		expectedTarget.add(new DiffResult(1, changedLines));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testSeven() {
		Reader reader1 = new UnsyncStringReader("ccc\naaa\nbbe");
		Reader reader2 = new UnsyncStringReader("aaa\nbbb");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		List<String> changedLines = new ArrayList<String>();

		expectedSource.add(
			new DiffResult(0, Diff.OPEN_DEL + "ccc" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(0, Diff.CONTEXT_LINE));

		changedLines = new ArrayList<String>();

		changedLines.add("bb" + Diff.OPEN_DEL + "e" + Diff.CLOSE_DEL);
		expectedSource.add(new DiffResult(2, changedLines));

		changedLines = new ArrayList<String>();

		changedLines.add("bb" + Diff.OPEN_INS + "b" + Diff.CLOSE_INS);
		expectedTarget.add(new DiffResult(1, changedLines));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testEight() {
		Reader reader1 = new UnsyncStringReader("add\nbbb\nccc");
		Reader reader2 = new UnsyncStringReader("bbb\nccc\naee");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(
			new DiffResult(0, Diff.OPEN_DEL + "add" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(0, Diff.CONTEXT_LINE));

		List<String> changedLines = new ArrayList<String>();

		changedLines.add("bbb");
		changedLines.add("ccc");
		changedLines.add(Diff.CONTEXT_LINE);
		expectedSource.add(new DiffResult(2, changedLines));

		changedLines = new ArrayList<String>();

		changedLines.add("bbb");
		changedLines.add("ccc");
		changedLines.add(Diff.OPEN_INS + "aee" + Diff.CLOSE_INS);
		expectedTarget.add(new DiffResult(2, changedLines));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testNine() {
		Reader reader1 = new UnsyncStringReader("abcd");
		Reader reader2 = new UnsyncStringReader("abcdee");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(new DiffResult(0, "abcd"));

		expectedTarget.add(
			new DiffResult(
				0, "abcd" + Diff.OPEN_INS + "ee" + Diff.CLOSE_INS));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testTen() {
		Reader reader1 = new UnsyncStringReader("abcd");
		Reader reader2 = new UnsyncStringReader("abcdeee");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(new DiffResult(0, Diff.CONTEXT_LINE));

		expectedTarget.add(
			new DiffResult(0, Diff.OPEN_INS + "abcdeee" + Diff.CLOSE_INS));

		expectedSource.add(
			new DiffResult(0, Diff.OPEN_DEL + "abcd" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(0, Diff.CONTEXT_LINE));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testEleven() {
		Reader reader1 = new UnsyncStringReader("aaa\nbbb\nfff");
		Reader reader2 = new UnsyncStringReader("ccc\nada\nbeb");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(new DiffResult(0, Diff.CONTEXT_LINE));

		expectedTarget.add(
			new DiffResult(0, Diff.OPEN_INS + "ccc" + Diff.CLOSE_INS));

		expectedSource.add(
			new DiffResult(
				0, "a" + Diff.OPEN_DEL + "a" + Diff.CLOSE_DEL + "a"));

		expectedTarget.add(
			new DiffResult(
				1, "a" + Diff.OPEN_INS + "d" + Diff.CLOSE_INS + "a"));

		expectedSource.add(
			new DiffResult(
				1, "b" + Diff.OPEN_DEL + "b" + Diff.CLOSE_DEL + "b"));

		expectedTarget.add(
			new DiffResult(
				2, "b" + Diff.OPEN_INS + "e" + Diff.CLOSE_INS + "b"));

		expectedSource.add(
			new DiffResult(2, Diff.OPEN_DEL + "fff" + Diff.CLOSE_DEL));

		expectedTarget.add(new DiffResult(2, Diff.CONTEXT_LINE));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

	public void testTwelve() {
		Reader reader1 = new UnsyncStringReader("ada");
		Reader reader2 = new UnsyncStringReader("aaa\nccc");

		List<DiffResult> expectedSource = new ArrayList<DiffResult>();
		List<DiffResult> expectedTarget = new ArrayList<DiffResult>();

		expectedSource.add(
			new DiffResult(
				0, "a" + Diff.OPEN_DEL + "d" + Diff.CLOSE_DEL + "a"));

		expectedTarget.add(
			new DiffResult(
				0, "a" + Diff.OPEN_INS + "a" + Diff.CLOSE_INS + "a"));

		expectedSource.add(new DiffResult(1, Diff.CONTEXT_LINE));

		expectedTarget.add(
			new DiffResult(1, Diff.OPEN_INS + "ccc" + Diff.CLOSE_INS));

		List<DiffResult>[] actual = DiffUtil.diff(reader1, reader2);

		assertEquals(expectedSource, actual[0]);
		assertEquals(expectedTarget, actual[1]);
	}

}