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

package com.liferay.portal.image;

import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageProcessor;
import com.liferay.portal.kernel.image.ImageProcessorUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.BaseTestCase;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RenderedImage;

import java.io.File;
import java.io.RandomAccessFile;

import java.util.Arrays;

import javax.imageio.ImageIO;

/**
 * @author Shuyang Zhou
 */
public class ImageProcessorImplTest extends BaseTestCase {

	public void testReadBMP() throws Exception {
		testRead("liferay.bmp");
	}

	public void testReadGIF() throws Exception {
		testRead("liferay.gif");
	}

	public void testReadJPEG() throws Exception {
		testRead("liferay.jpeg");
	}

	public void testReadJPG() throws Exception {
		testRead("liferay.jpg");
	}

	public void testReadPNG() throws Exception {
		testRead("liferay.png");
	}

	protected void testRead(String fileName) throws Exception {
		fileName =
			"portal-impl/test/com/liferay/portal/image/dependencies/" +
				fileName;

		File file = new File(fileName);

		BufferedImage expectedImage = ImageIO.read(file);

		assertNotNull(expectedImage);

		DataBufferByte expectedDataBufferByte =
			(DataBufferByte)expectedImage.getData().getDataBuffer();

		byte[][] expectedData = expectedDataBufferByte.getBankData();

		String expectedType = FileUtil.getExtension(fileName);

		if (expectedType.equals("jpeg")) {
			expectedType = ImageProcessor.TYPE_JPEG;
		}

		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

		byte[] bytes = new byte[(int)randomAccessFile.length()];

		randomAccessFile.readFully(bytes);

		ImageBag imageBag = ImageProcessorUtil.read(bytes);

		RenderedImage resultImage = imageBag.getRenderedImage();

		assertNotNull(resultImage);

		DataBufferByte resultDataBufferByte =
			(DataBufferByte)resultImage.getData().getDataBuffer();

		byte[][] resultData = resultDataBufferByte.getBankData();

		String resultType = imageBag.getType();

		assertTrue(expectedType.equalsIgnoreCase(resultType));
		assertTrue(Arrays.deepEquals(expectedData, resultData));
	}

}