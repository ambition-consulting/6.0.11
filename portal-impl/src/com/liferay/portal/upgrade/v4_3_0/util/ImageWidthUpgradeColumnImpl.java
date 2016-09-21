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

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageWidthUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public ImageWidthUpgradeColumnImpl(ImageTextUpgradeColumnImpl textColumn) {
		super("width");

		_textColumn = textColumn;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Integer width = _textColumn.getWidth();

		if (width != null) {
			return width;
		}
		else {
			return oldValue;
		}
	}

	private ImageTextUpgradeColumnImpl _textColumn;

}