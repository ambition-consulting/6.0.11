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

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portlet.translator.model.Translation;

import java.net.URL;

/**
 * @author Brian Wing Shun Chan
 */
public class TranslationWebCacheItem implements WebCacheItem {

	public TranslationWebCacheItem(String translationId, String fromText) {
		_translationId = translationId;
		_fromText = fromText;
	}

	public Object convert(String key) throws WebCacheException {
		Translation translation = new Translation(_translationId, _fromText);

		try {
			StringBundler sb = new StringBundler(6);

			sb.append("http://babelfish.yahoo.com/translate_txt?");
			sb.append("ei=UTF-8&doit=done&fr=bf-res&intl=1&tt=urltext");
			sb.append("&trtext=");
			sb.append(HttpUtil.encodeURL(_fromText));
			sb.append("&lp=");
			sb.append(_translationId);

			String text = HttpUtil.URLtoString(new URL(sb.toString()));

			int x = text.indexOf("<div id=\"result\">");

			x = text.indexOf(">", x) + 1;
			x = text.indexOf(">", x) + 1;

			int y = text.indexOf("</div>", x);

			String toText = text.substring(x, y).trim();

			toText = StringUtil.replace(
				toText, CharPool.NEW_LINE, CharPool.SPACE);

			translation.setToText(toText);
		}
		catch (Exception e) {
			throw new WebCacheException(e);
		}

		return translation;
	}

	public long getRefreshTime() {
		return _REFRESH_TIME;
	}

	private static final long _REFRESH_TIME = Time.DAY * 90;

	private String _translationId;
	private String _fromText;

}