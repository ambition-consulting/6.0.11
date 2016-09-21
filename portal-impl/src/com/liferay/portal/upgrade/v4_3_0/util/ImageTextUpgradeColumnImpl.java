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

package com.liferay.portal.upgrade.v4_3_0.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.ImageConstants;
import com.liferay.portal.service.ImageLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageTextUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public ImageTextUpgradeColumnImpl(UpgradeColumn imageIdColumn) {
		super("text_");

		_imageIdColumn = imageIdColumn;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		_type = null;
		_height = null;
		_width = null;
		_size = null;

		String text = (String)oldValue;

		byte[] bytes = (byte[])Base64.stringToObject(text);

		try {
			Image image = ImageLocalServiceUtil.getImage(bytes);

			_type = image.getType();
			_height = new Integer(image.getHeight());
			_width = new Integer(image.getWidth());
			_size = new Integer(image.getSize());
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				String imageId = (String)_imageIdColumn.getOldValue();

				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to get image data for " + imageId + ": " +
							e.getMessage());
				}
			}

			_type = ImageConstants.TYPE_NOT_AVAILABLE;
			_height = null;
			_width = null;
			_size = new Integer(bytes.length);
		}

		return oldValue;
	}

	public String getType() {
		return _type;
	}

	public Integer getHeight() {
		return _height;
	}

	public Integer getWidth() {
		return _width;
	}

	public Integer getSize() {
		return _size;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ImageTextUpgradeColumnImpl.class);

	private UpgradeColumn _imageIdColumn;
	private String _type;
	private Integer _height;
	private Integer _width;
	private Integer _size;

}