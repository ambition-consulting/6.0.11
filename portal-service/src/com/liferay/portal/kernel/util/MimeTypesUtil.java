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

import java.io.File;
import java.io.InputStream;

/**
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class MimeTypesUtil {

	public static String getContentType(File file) {
		return getMimeTypes().getContentType(file);
	}

	/**
	 * Determine the content type from an input stream and file name.
	 *
	 * @param  fileName full name or extension of file (e.g., "Test.doc",
	 *		   ".doc")
	 * @return content type if it is a supported format or an empty string if it
	 *		   is an unsupported format
	 */
	public static String getContentType(
		InputStream inputStream, String fileName) {

		return getMimeTypes().getContentType(inputStream, fileName);
	}

	/**
	 * Determine the content type from a file name.
	 *
	 * @param  fileName full name or extension of file (e.g., "Test.doc",
	 *		   ".doc")
	 * @return content type if it is a supported format or an empty string if it
	 *		   is an unsupported format
	 */
	public static String getContentType(String fileName) {
		return getMimeTypes().getContentType(fileName);
	}

	public static MimeTypes getMimeTypes() {
		return _mimeTypes;
	}

	public void setMimeTypes(MimeTypes mimeTypes) {
		_mimeTypes = mimeTypes;
	}

	private static MimeTypes _mimeTypes;

}