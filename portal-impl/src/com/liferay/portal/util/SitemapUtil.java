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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.List;

/**
 * @author Jorge Ferrer
 */
public class SitemapUtil {

	public static String getSitemap(
			long groupId, boolean privateLayout, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		Document doc = SAXReaderUtil.createDocument();

		doc.setXMLEncoding(StringPool.UTF8);

		Element root = doc.addElement(
			"urlset", "http://www.google.com/schemas/sitemap/0.84");

		List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(
			groupId, privateLayout, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

		_visitLayouts(root, layouts, themeDisplay);

		return doc.asXML();
	}

	public static String encodeXML(String input) {
		return StringUtil.replace(
			input,
			new String[] {"&", "<", ">", "'", "\""},
			new String[] {"&amp;", "&lt;", "&gt;", "&apos;", "&quot;"});
	}

	private static void _visitLayouts(
			Element element, List<Layout> layouts, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		for (Layout layout : layouts) {
			UnicodeProperties typeSettingsProperties =
				layout.getTypeSettingsProperties();

			if (PortalUtil.isLayoutSitemapable(layout) && !layout.isHidden() &&
				GetterUtil.getBoolean(
					typeSettingsProperties.getProperty("sitemap-include"),
					true)) {

				Element url = element.addElement("url");

				String layoutFullURL = PortalUtil.getLayoutFullURL(
					layout, themeDisplay);

				url.addElement("loc").addText(encodeXML(layoutFullURL));

				String changefreq = typeSettingsProperties.getProperty(
					"sitemap-changefreq");

				if (Validator.isNotNull(changefreq)) {
					url.addElement("changefreq").addText(changefreq);
				}

				String priority = typeSettingsProperties.getProperty(
					"sitemap-priority");

				if (Validator.isNotNull(priority)) {
					url.addElement("priority").addText(priority);
				}

				List<Layout> children = layout.getChildren();

				_visitLayouts(element, children, themeDisplay);
			}
		}
	}

}