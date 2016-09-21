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

package com.liferay.portal.upgrade.v6_0_6;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.upgrade.BaseUpgradePortletPreferences;
import com.liferay.portlet.PortletPreferencesImpl;
import com.liferay.portlet.PortletPreferencesSerializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Raymond Augé
 */
public class UpgradeRSS extends BaseUpgradePortletPreferences {

	protected String[] getArticleValues(long resourcePrimKey) {
		long groupId = 0;
		String articleId = StringPool.BLANK;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select groupId, articleId from JournalArticle where " +
					"resourcePrimKey = ?");

			ps.setLong(1, resourcePrimKey);

			rs = ps.executeQuery();

			rs.next();

			groupId = rs.getLong("groupId");
			articleId = rs.getString("articleId");
		}
		catch (Exception e) {
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		return new String[] {String.valueOf(groupId), articleId};
	}

	protected String getUpdatePortletPreferencesWhereClause() {
		return "portletId like '39_INSTANCE_%'";
	}

	protected void upgradeFooterValues(PortletPreferencesImpl preferences)
		throws Exception {

		String[] footerArticleResouceValues = preferences.getValues(
			"footer-article-resource-values", new String[] {"0", ""});

		long footerArticleResourcePrimKey = GetterUtil.getLong(
			footerArticleResouceValues[0]);

		String[] values = getArticleValues(footerArticleResourcePrimKey);

		preferences.setValues("footer-article-values", values);
		preferences.reset("footer-article-resource-values");
	}

	protected void upgradeHeaderValues(PortletPreferencesImpl preferences)
		throws Exception {

		String[] headerArticleResouceValues = preferences.getValues(
			"header-article-resource-values", new String[] {"0", ""});

		long headerArticleResourcePrimKey = GetterUtil.getLong(
			headerArticleResouceValues[0]);

		String[] values = getArticleValues(headerArticleResourcePrimKey);

		preferences.setValues("header-article-values", values);
		preferences.reset("header-article-resource-values");
	}

	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferencesImpl preferences =
			PortletPreferencesSerializer.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		upgradeFooterValues(preferences);
		upgradeHeaderValues(preferences);

		return PortletPreferencesSerializer.toXML(preferences);
	}

}