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

package com.liferay.portlet.wiki.util;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.wiki.PageContentException;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.model.WikiPageDisplay;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

import java.util.Map;

import javax.portlet.PortletURL;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Jorge Ferrer
 */
public class WikiCacheUtil {

	public static final String CACHE_NAME = WikiCacheUtil.class.getName();

	public static void clearCache(long nodeId) {
		_portalCache.removeAll();
	}

	public static void clearCache(long nodeId, String title) {
		clearCache(nodeId);
	}

	public static WikiPageDisplay getDisplay(
		long nodeId, String title, PortletURL viewPageURL,
		PortletURL editPageURL, String attachmentURLPrefix) {

		StopWatch stopWatch = null;

		if (_log.isDebugEnabled()) {
			stopWatch = new StopWatch();

			stopWatch.start();
		}

		String key = _encodeKey(nodeId, title, viewPageURL.toString());

		WikiPageDisplay pageDisplay = (WikiPageDisplay)_portalCache.get(key);

		if (pageDisplay == null) {
			pageDisplay = _getPageDisplay(
				nodeId, title, viewPageURL, editPageURL, attachmentURLPrefix);

			_portalCache.put(key, pageDisplay);
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				"getDisplay for {" + nodeId + ", " + title + ", " +
					viewPageURL + ", " + editPageURL + "} takes " +
						stopWatch.getTime() + " ms");
		}

		return pageDisplay;
	}

	public static Map<String, Boolean> getOutgoingLinks(WikiPage page)
		throws PageContentException {

		String key = _encodeKey(
			page.getNodeId(), page.getTitle(), _OUTGOING_LINKS);

		Map<String, Boolean> links = (Map<String, Boolean>)_portalCache.get(
			key);

		if (links == null) {
			links = WikiUtil.getLinks(page);

			_portalCache.put(key, links);
		}

		return links;
	}

	private static String _encodeKey(
		long nodeId, String title, String postfix) {

		StringBundler sb = new StringBundler(6);

		sb.append(CACHE_NAME);
		sb.append(StringPool.POUND);
		sb.append(StringUtil.toHexString(nodeId));
		sb.append(title);

		if (postfix != null) {
			sb.append(StringPool.POUND);
			sb.append(postfix);
		}

		return sb.toString();
	}

	private static WikiPageDisplay _getPageDisplay(
		long nodeId, String title, PortletURL viewPageURL,
		PortletURL editPageURL, String attachmentURLPrefix) {

		try {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Get page display for {" + nodeId + ", " + title + ", " +
						viewPageURL + ", " + editPageURL + "}");
			}

			return WikiPageLocalServiceUtil.getPageDisplay(
				nodeId, title, viewPageURL, editPageURL, attachmentURLPrefix);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get page display for {" + nodeId + ", " + title +
						", " + viewPageURL + ", " + editPageURL + "}");
			}

			return null;
		}
	}

	private static final String _OUTGOING_LINKS = "OUTGOING_LINKS";

	private static Log _log = LogFactoryUtil.getLog(WikiUtil.class);

	private static PortalCache _portalCache = MultiVMPoolUtil.getCache(
		CACHE_NAME);

}