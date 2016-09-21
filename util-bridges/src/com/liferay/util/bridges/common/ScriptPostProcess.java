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

package com.liferay.util.bridges.common;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletURL;

/**
 * @author Gavin Wan
 * @author Brian Wing Shun Chan
 * @see	   org.apache.portals.bridges.common.ScriptPostProcess
 */
public class ScriptPostProcess {

	public String getFinalizedPage() {
		if (_sb != null) {
			return _sb.toString();
		}

		return StringPool.BLANK;
	}

	public void postProcessPage(
		PortletURL actionURL, String actionParameterName) {

		processPage(
			"<a", StringPool.GREATER_THAN, "href=", actionURL,
			actionParameterName);
		processPage(
			"<A", StringPool.GREATER_THAN, "HREF=", actionURL,
			actionParameterName);
		processPage(
			"<area", StringPool.GREATER_THAN, "href=", actionURL,
			actionParameterName);
		processPage(
			"<AREA", StringPool.GREATER_THAN, "HREF=", actionURL,
			actionParameterName);
		processPage(
			"<FORM", StringPool.GREATER_THAN, "ACTION=", actionURL,
			actionParameterName);
		processPage(
			"<form", StringPool.GREATER_THAN, "action=", actionURL,
			actionParameterName);
	}

	public void processPage(
		String startTag, String endTag, String ref, PortletURL actionURL,
		String actionParameterName) {

		try {
			doProcessPage(
			startTag, endTag, ref, actionURL, actionParameterName);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public void setInitalPage(StringBundler initialPage) {
		_sb = initialPage;
	}

	protected void doProcessPage(
		String startTag, String endTag, String ref, PortletURL actionURL,
		String actionParameterName) {

		StringBundler sb = new StringBundler();

		String content = _sb.toString();

		int startTagPos = content.indexOf(startTag);
		int endTagPos = 0;

		int startRefPos = 0;
		int endRefPos = 0;

		while (startTagPos != -1) {
			sb.append(content.substring(0, startTagPos));

			content = content.substring(startTagPos);

			endTagPos = content.indexOf(endTag);
			startRefPos = content.indexOf(ref);

			if ((startRefPos == -1) || (startRefPos > endTagPos)) {
				sb.append(content.substring(0, endTagPos));

				content = content.substring(endTagPos);
			}
			else {
				startRefPos = startRefPos + ref.length();

				sb.append(content.substring(0, startRefPos));

				content = content.substring(startRefPos);

				String quote = StringPool.BLANK;

				if (content.startsWith(StringPool.APOSTROPHE)) {
					quote = StringPool.APOSTROPHE;
				}
				else if (content.startsWith(StringPool.QUOTE)) {
					quote = StringPool.QUOTE;
				}

				String url = StringPool.BLANK;

				if (quote.length() > 0) {
					sb.append(quote);

					content = content.substring(1);

					endRefPos = content.indexOf(quote);

					url = content.substring(0, endRefPos);
				}
				else {
					endTagPos = content.indexOf(endTag);

					endRefPos = 0;

					StringBundler unquotedURL = new StringBundler();

					while (true) {
						char c = content.charAt(endRefPos);

						if (!Character.isSpaceChar(c) &&
							(endRefPos < endTagPos)) {

							endRefPos++;

							unquotedURL.append(c);
						}
						else {
							endRefPos--;

							break;
						}
					}

					url = unquotedURL.toString();
				}

				if ((url.charAt(0) == CharPool.POUND) ||
					url.startsWith("http")) {

					sb.append(url);
					sb.append(quote);
				}
				else {
					actionURL.setParameter(actionParameterName, url);

					sb.append(actionURL.toString());
					sb.append(quote);
				}

				content = content.substring(endRefPos + 1);
			}

			startTagPos = content.indexOf(startTag);
		}

		sb.append(content);

		_sb = sb;
	}

	private static Log _log = LogFactoryUtil.getLog(ScriptPostProcess.class);

	private StringBundler _sb;

}