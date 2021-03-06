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

package com.liferay.portal.kernel.zip;

import java.io.File;

/**
 * @author Raymond Augé
 */
public class ZipWriterFactoryUtil {

	public static ZipWriter getZipWriter() {
		return getZipWriterFactory().getZipWriter();
	}

	public static ZipWriter getZipWriter(File file) {
		return getZipWriterFactory().getZipWriter(file);
	}

	public static ZipWriterFactory getZipWriterFactory() {
		return _zipWriterFactory;
	}

	public void setZipWriterFactory(ZipWriterFactory zipWriterFactory) {
		_zipWriterFactory = zipWriterFactory;
	}

	private static ZipWriterFactory _zipWriterFactory;

}