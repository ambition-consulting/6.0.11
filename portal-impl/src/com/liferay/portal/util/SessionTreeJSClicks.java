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

package com.liferay.portal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class SessionTreeJSClicks {

	public static final String CLASS_NAME = SessionTreeJSClicks.class.getName();

	public static void closeNode(
		HttpServletRequest request, String treeId, String nodeId) {

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			String openNodesString = preferences.getValue(CLASS_NAME, treeId);

			openNodesString = StringUtil.remove(openNodesString, nodeId);

			preferences.setValue(CLASS_NAME, treeId, openNodesString);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public static void closeNodes(HttpServletRequest request, String treeId) {
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			String openNodesString = StringPool.BLANK;

			preferences.setValue(CLASS_NAME, treeId, openNodesString);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public static String getOpenNodes(
		HttpServletRequest request, String treeId) {

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			return preferences.getValue(CLASS_NAME, treeId);
		}
		catch (Exception e) {
			_log.error(e, e);

			return null;
		}
	}

	public static void openNode(
		HttpServletRequest request, String treeId, String nodeId) {

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			String openNodesString = preferences.getValue(CLASS_NAME, treeId);

			openNodesString = StringUtil.add(openNodesString, nodeId);

			preferences.setValue(CLASS_NAME, treeId, openNodesString);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public static void openNodes(
		HttpServletRequest request, String treeId, String[] nodeIds) {

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(request);

			String openNodesString = preferences.getValue(CLASS_NAME, treeId);

			for (int i = 0; i < nodeIds.length; i++) {
				openNodesString = StringUtil.add(openNodesString, nodeIds[i]);
			}

			preferences.setValue(CLASS_NAME, treeId, openNodesString);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SessionTreeJSClicks.class);

}