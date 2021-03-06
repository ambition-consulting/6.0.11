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

package com.liferay.portlet.translator.util;

import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portlet.translator.model.Translation;

/**
 * @author Brian Wing Shun Chan
 */
public class TranslatorUtil {

	public static Translation getTranslation(
		String translationId, String fromText) {

		WebCacheItem wci = new TranslationWebCacheItem(translationId, fromText);

		return (Translation)WebCachePoolUtil.get(
			"translator." + translationId + "|" +
				Base64.objectToString(fromText),
			wci);
	}

}