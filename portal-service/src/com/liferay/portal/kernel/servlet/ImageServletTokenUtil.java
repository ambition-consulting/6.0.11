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

package com.liferay.portal.kernel.servlet;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageServletTokenUtil {

	public static ImageServletToken getImageServletToken() {
		return _imageServletToken;
	}

	public static String getToken(long imageId) {
		return getImageServletToken().getToken(imageId);
	}

	public static void resetToken(long imageId) {
		getImageServletToken().resetToken(imageId);
	}

	public void setImageServletToken(ImageServletToken imageServletToken) {
		_imageServletToken = imageServletToken;
	}

	private static ImageServletToken _imageServletToken;

}