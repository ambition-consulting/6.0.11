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

package com.liferay.portal.model.impl;

import com.liferay.portal.image.HookFactory;
import com.liferay.portal.kernel.image.Hook;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.model.Image;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageImpl extends ImageModelImpl implements Image {

	public ImageImpl() {
	}

	public byte[] getTextObj() {
		if (_textObj == null) {
			try {
				Hook hook = HookFactory.getInstance();

				_textObj = hook.getImageAsBytes(this);
			}
			catch (Exception e) {
				_log.error("Error reading image " + getImageId(), e);
			}
		}

		return _textObj;
	}

	public void setTextObj(byte[] textObj) {
		_textObj = textObj;

		super.setText(Base64.objectToString(textObj));
	}

	private byte[] _textObj;

	private static Log _log = LogFactoryUtil.getLog(ImageImpl.class);

}