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

package com.liferay.portlet.imagegallery.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class IGImageImpl extends IGImageModelImpl implements IGImage {

	public static String getNameWithExtension(String name, String type) {
		if (Validator.isNotNull(type)) {
			name += StringPool.PERIOD + type;
		}

		return name;
	}

	public IGImageImpl() {
	}

	public IGFolder getFolder() {
		IGFolder folder = null;

		if (getFolderId() > 0) {
			try {
				folder = IGFolderLocalServiceUtil.getFolder(getFolderId());
			}
			catch (Exception e) {
				folder = new IGFolderImpl();

				_log.error(e);
			}
		}
		else {
			folder = new IGFolderImpl();
		}

		return folder;
	}

	public int getImageSize() {
		if (_imageSize == null) {
			try {
				Image largeImage = ImageLocalServiceUtil.getImage(
					getLargeImageId());

				_imageSize = new Integer(largeImage.getSize());
			}
			catch (Exception e) {
				_imageSize = new Integer(0);

				_log.error(e);
			}
		}

		return _imageSize.intValue();
	}

	public String getImageType() {
		if (_imageType == null) {
			try {
				Image largeImage = ImageLocalServiceUtil.getImage(
					getLargeImageId());

				_imageType = largeImage.getType();
			}
			catch (Exception e) {
				_imageType = StringPool.BLANK;

				_log.error(e);
			}
		}

		return _imageType;
	}

	public String getNameWithExtension() {
		String nameWithExtension = getName();

		if (Validator.isNull(nameWithExtension)) {
			nameWithExtension = String.valueOf(getImageId());
		}

		String type = getImageType();

		return getNameWithExtension(nameWithExtension, type);
	}

	public void setImageType(String imageType) {
		_imageType = imageType;
	}

	private static Log _log = LogFactoryUtil.getLog(IGImageImpl.class);

	private Integer _imageSize;
	private String _imageType;

}