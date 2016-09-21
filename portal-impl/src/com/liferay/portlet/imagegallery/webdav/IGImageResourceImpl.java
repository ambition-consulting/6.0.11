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

package com.liferay.portlet.imagegallery.webdav;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.webdav.BaseResourceImpl;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portlet.imagegallery.model.IGImage;

import java.io.InputStream;

/**
 * @author Alexander Chow
 */
public class IGImageResourceImpl extends BaseResourceImpl {

	public IGImageResourceImpl(IGImage image, String parentPath, String name) {
		super(
			parentPath, name, image.getNameWithExtension(),
			image.getCreateDate(), image.getModifiedDate(),
			image.getImageSize());

		setModel(image);
		setClassName(IGImage.class.getName());
		setPrimaryKey(image.getPrimaryKey());

		_image = image;
	}

	public boolean isCollection() {
		return false;
	}

	public String getContentType() {
		String type = StringPool.BLANK;

		try {
			type = _image.getImageType();
		}
		catch (Exception e) {
		}

		return MimeTypesUtil.getContentType(type);
	}

	public InputStream getContentAsStream() throws WebDAVException {
		try {
			Image image = ImageLocalServiceUtil.getImage(
				_image.getLargeImageId());

			byte[] bytes = image.getTextObj();

			return new UnsyncByteArrayInputStream(bytes);
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	private IGImage _image;

}