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

package com.liferay.portal.upgrade.v6_0_2;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.util.PortletKeys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Wesley Gong
 * @author Bijan Vakili
 * @author Douglas Wong
 * @author Brian Wing Shun Chan
 */
public class UpgradeNestedPortlets extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(_GET_LAYOUT);

			rs = ps.executeQuery();

			while (rs.next()) {
				long plid = rs.getLong("plid");
				String typeSettings = rs.getString("typeSettings");

				String newTypeSettings = typeSettings;

				Matcher matcher = _pattern.matcher(typeSettings);

				while (matcher.find()) {
					String nestedColumnIds = matcher.group();

					int underlineCount = StringUtil.count(
						nestedColumnIds, StringPool.UNDERLINE);

					if (underlineCount == _UNDERLINE_COUNT) {
						String newNestedColumnIds = nestedColumnIds.replaceAll(
							_pattern.pattern(), "_$1_$2");

						newTypeSettings = newTypeSettings.replaceAll(
							nestedColumnIds, newNestedColumnIds);
					}
				}

				if (!newTypeSettings.equals(typeSettings)) {
					updateTypeSettings(plid, newTypeSettings);
				}
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void updateTypeSettings(long plid, String typeSettings)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"update Layout set typeSettings = ? where plid = " + plid);

			ps.setString(1, typeSettings);

			ps.executeUpdate();
		}
		finally {
			DataAccess.cleanUp(con, ps);
		}
	}

	private static final String _GET_LAYOUT =
		"select plid, typeSettings from Layout where typeSettings like " +
			"'%nested-column-ids=" + PortletKeys.NESTED_PORTLETS +
				PortletConstants.INSTANCE_SEPARATOR + "%'";

	private static final int _UNDERLINE_COUNT = StringUtil.count(
		PortletConstants.INSTANCE_SEPARATOR, StringPool.UNDERLINE) + 1;

	private static Pattern _pattern = Pattern.compile(
		"(" + PortletKeys.NESTED_PORTLETS +
			PortletConstants.INSTANCE_SEPARATOR + "[^_,\\s=]+_)([^_,\\s=]+)");

}