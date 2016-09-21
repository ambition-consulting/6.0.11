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
public interface ImageProcessor {

	public static final String TYPE_BMP = "bmp";

	public static final String TYPE_GIF = "gif";

	public static final String TYPE_JPEG = "jpg";

	public static final String TYPE_PNG = "png";

	public static final String TYPE_TIFF = "tiff";

	public static final String TYPE_NOT_AVAILABLE = "na";

	public BufferedImage convertImageType(
		BufferedImage sourceImage, int type);

	public void encodeGIF(RenderedImage renderedImage, OutputStream os)
		throws IOException;

	public void encodeWBMP(RenderedImage renderedImage, OutputStream os)
		throws InterruptedException, IOException;

	public BufferedImage getBufferedImage(RenderedImage renderedImage);

	public byte[] getBytes(RenderedImage renderedImage, String contentType)
		throws IOException;

	public ImageBag read(File file) throws IOException;

	public ImageBag read(byte[] bytes) throws IOException;

	public RenderedImage scale(
		RenderedImage renderedImage, int maxHeight, int maxWidth);

}