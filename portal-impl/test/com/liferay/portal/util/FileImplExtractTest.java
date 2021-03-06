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

import com.liferay.portal.kernel.util.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Igor Spasic
 */
public class FileImplExtractTest extends BaseTestCase {

	public void testDocx() {
		String text = extractText("test-2007.docx");

		assertEquals("Extract test.", text);

		text = extractText("test-2010.docx");

		assertEquals("_GoBack\nExtract test.", text);
	}

	public void testHtml() {
		String text = extractText("test.html");

		assertEquals("Extract test.", text);
	}

	public void testJpg() {
		String text = extractText("test.jpg");

		assertEquals("", text);
	}

	public void testOdt() {
		String text = extractText("test.odt");

		assertEquals("Extract test.", text);
	}

	public void testPdf() {
		String text = extractText("test-2010.pdf");

		assertEquals("Extract test.", text);

		// PDFBOX-890

		//text = _extractText("test.pdf");

		//assertEquals("Extract test.", text);
	}

	public void testPpt() {
		String text = extractText("test-2010.pptx");

		assertEquals("Extract \ntest.", text);
	}

	public void testRtf() {
		String text = extractText("test.rtf");

		assertEquals("Extract  test.", text);
	}

	public void testTxt() {
		String text = extractText("test.txt");

		assertEquals("Extract test.", text);
	}

	public void testXlsx() {
		String text = extractText("test-2010.xlsx");

		assertEquals("Sheet1\n\tExtract test.", text);
	}

	public void testXml() {
		String text = extractText("test.xml");

		assertEquals("<test>Extract test.</test>", text);
	}

	protected String extractText(String fileName) {
		FileInputStream fileInputStream = null;

		try {
			fileInputStream = new FileInputStream(
				"portal-impl/test/com/liferay/portal/util/dependencies/" +
					fileName);
		}
		catch (FileNotFoundException fnfe) {
			return null;
		}

		String text = FileUtil.extractText(fileInputStream, fileName);

		return text.trim();
	}

}