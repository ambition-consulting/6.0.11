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

package com.liferay.portal.upgrade.v4_3_5;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.PortletConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradePortletId extends UpgradeProcess {

	protected void doUpgrade() throws Exception {

		// This is only tested to work on instanceable portlets

		String[][] portletIdsArray = getPortletIdsArray();

		for (int i = 0; i < portletIdsArray.length; i++) {
			String[] portletIds = portletIdsArray[i];

			String oldRootPortletId = portletIds[0];
			String newRootPortletId = portletIds[1];

			updatePortlet(oldRootPortletId, newRootPortletId);
			updateResource(oldRootPortletId, newRootPortletId);
			updateResourceCode(oldRootPortletId, newRootPortletId);
		}
	}

	protected String[][] getPortletIdsArray() {
		return new String[][] {
			new String[] {
				"94",
				"1_WAR_googleadsenseportlet"
			},
			new String[] {
				"95",
				"1_WAR_googlegadgetportlet"
			},
			new String[] {
				"96",
				"1_WAR_googlemapsportlet"
			}
		};
	}

	protected void updateLayout(
			long plid, String oldPortletId, String newPortletId)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select typeSettings from Layout where plid = " + plid);

			rs = ps.executeQuery();

			while (rs.next()) {
				String typeSettings = rs.getString("typeSettings");

				String newTypeSettings = StringUtil.replace(
					typeSettings, oldPortletId, newPortletId);

				updateTypeSettings(plid, newTypeSettings);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void updatePortlet(
			String oldRootPortletId, String newRootPortletId)
		throws Exception {

		runSQL(
			"update Portlet set portletId = '" + newRootPortletId +
				"' where portletId = '" + oldRootPortletId + "'");
	}

	protected void updateResource(
			String oldRootPortletId, String newRootPortletId)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select primKey from Resource_ where primKey like ?");

			ps.setString(
				1,
				"%" + PortletConstants.LAYOUT_SEPARATOR + oldRootPortletId +
					"%");

			rs = ps.executeQuery();

			while (rs.next()) {
				String oldPrimKey = rs.getString("primKey");

				int pos = oldPrimKey.indexOf(PortletConstants.LAYOUT_SEPARATOR);

				long plid = GetterUtil.getLong(oldPrimKey.substring(0, pos));

				String portletId = oldPrimKey.substring(
					pos + PortletConstants.LAYOUT_SEPARATOR.length());

				String newPrimKey =
					plid + PortletConstants.LAYOUT_SEPARATOR +
						newRootPortletId;

				String oldPortletId = oldRootPortletId;
				String newPortletId = newRootPortletId ;

				pos = portletId.indexOf(PortletConstants.INSTANCE_SEPARATOR);

				if (pos != -1) {
					portletId = portletId.substring(0, pos);

					String instanceId = oldPrimKey.substring(
						pos + PortletConstants.INSTANCE_SEPARATOR.length());

					newPrimKey +=
						PortletConstants.INSTANCE_SEPARATOR + instanceId;

					oldPortletId +=
						PortletConstants.INSTANCE_SEPARATOR + instanceId;
					newPortletId +=
					 	PortletConstants.INSTANCE_SEPARATOR + instanceId;
				}

				if (!portletId.equals(oldRootPortletId)) {
					continue;
				}

				runSQL(
					"update Resource_ set primKey = '" + newPrimKey +
						"' where primKey = '" + oldPrimKey + "'");

				updateLayout(plid, oldPortletId, newPortletId);

				runSQL(
					"update PortletPreferences set portletId = '" +
						newPortletId + "' where portletId = '" + oldPortletId +
							"'");
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void updateResourceCode(
			String oldRootPortletId, String newRootPortletId)
		throws Exception {

		runSQL(
			"update ResourceCode set name = '" + newRootPortletId +
				"' where name = '" + oldRootPortletId + "'");
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

}