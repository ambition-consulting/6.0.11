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

package com.liferay.portal.kernel.image;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageProcessorUtil {

	public static BufferedImage convertImageType(
		BufferedImage sourceImage, int type) {

		return getImageProcessor().convertImageType(sourceImage, type);
	}

	public static void encodeGIF(RenderedImage renderedImage, OutputStream os)
		throws IOException {

		getImageProcessor().encodeGIF(renderedImage, os);
	}

	public static void encodeWBMP(RenderedImage renderedImage, OutputStream os)
		throws InterruptedException, IOException {

		getImageProcessor().encodeWBMP(renderedImage, os);
	}

	public static BufferedImage getBufferedImage(RenderedImage renderedImage) {
		return getImageProcessor().getBufferedImage(renderedImage);
	}

	public static byte[] getBytes(
			RenderedImage renderedImage, String contentType)
		throws IOException {

		return getImageProcessor().getBytes(renderedImage, contentType);
	}

	public static ImageProcessor getImageProcessor() {
		return _imageProcessor;
	}

	public static ImageBag read(File file) throws IOException {
		return getImageProcessor().read(file);
	}

	public static ImageBag read(byte[] bytes) throws IOException {
		return getImageProcessor().read(bytes);
	}

	public static RenderedImage scale(
		RenderedImage renderedImage, int maxHeight, int maxWidth) {

		return getImageProcessor().scale(renderedImage, maxHeight, maxWidth);
	}

	public void setImageProcessor(ImageProcessor imageProcessor) {
		_imageProcessor = imageProcessor;
	}

	private static ImageProcessor _imageProcessor;

}