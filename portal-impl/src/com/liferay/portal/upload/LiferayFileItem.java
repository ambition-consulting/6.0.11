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

package com.liferay.portal.upload;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PropsUtil;

import java.io.File;

import org.apache.commons.fileupload.disk.DiskFileItem;

/**
 * @author Brian Wing Shun Chan
 * @author Zongliang Li
 * @author Harry Mark
 */
public class LiferayFileItem extends DiskFileItem {

	public static final int THRESHOLD_SIZE = GetterUtil.getInteger(
		PropsUtil.get(LiferayFileItem.class.getName() + ".threshold.size"));

	public LiferayFileItem(
		String fieldName, String contentType, boolean isFormField,
		String fileName, int sizeThreshold, File repository) {

		super(
			fieldName, contentType, isFormField, fileName, sizeThreshold,
			repository);

		_fileName = fileName;
		_repository = repository;
	}

	public String getFileName() {
		if (_fileName == null) {
			return null;
		}

		int pos = _fileName.lastIndexOf("/");

		if (pos == -1) {
			pos = _fileName.lastIndexOf("\\");
		}

		if (pos == -1) {
			return _fileName;
		}
		else {
			return _fileName.substring(pos + 1, _fileName.length());
		}
	}

	public String getFullFileName() {
		return _fileName;
	}

	public String getFileNameExtension() {
		return FileUtil.getExtension(_fileName);
	}

	public String getString() {

		// Prevent serialization of uploaded content

		if (getSize() > THRESHOLD_SIZE) {
			return StringPool.BLANK;
		}

		if (_encodedString == null) {
			return super.getString();
		}
		else {
			return _encodedString;
		}
	}

	public void setString(String encode) {
		try {
			_encodedString = getString(encode);
		}
		catch (Exception e) {
		}
	}

	protected File getTempFile() {
		String tempFileName = "upload_" + _getUniqueId();

		String extension = getFileNameExtension();

		if (extension != null) {
			tempFileName += "." + extension;
		}

		File tempFile = new File(_repository, tempFileName);

		tempFile.deleteOnExit();

		return tempFile;
	}

	private static String _getUniqueId() {
		int current;

		synchronized (LiferayFileItem.class) {
			current = _counter++;
		}

		String id = String.valueOf(current);

		if (current < 100000000) {
			id = ("00000000" + id).substring(id.length());
		}

		return id;
	}

	private static int _counter = 0;

	private String _fileName;
	private File _repository;
	private String _encodedString;

}