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

package com.liferay.portlet.amazonrankings.util;

import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portlet.amazonrankings.model.AmazonRankings;

/**
 * @author Brian Wing Shun Chan
 */
public class AmazonRankingsUtil {

	public static String getAmazonAccessKeyId() {
		return PropsUtil.get(PropsKeys.AMAZON_ACCESS_KEY_ID);
	}

	public static String getAmazonAssociateTag() {
		return PropsUtil.get(PropsKeys.AMAZON_ASSOCIATE_TAG);
	}

	public static AmazonRankings getAmazonRankings(String isbn) {
		if (!Validator.isDigit(isbn)) {
			return null;
		}

		WebCacheItem wci = new AmazonRankingsWebCacheItem(isbn);

		return (AmazonRankings)WebCachePoolUtil.get(
			AmazonRankingsUtil.class.getName() + StringPool.PERIOD + isbn, wci);
	}

}