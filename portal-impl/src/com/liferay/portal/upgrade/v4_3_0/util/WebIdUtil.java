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

package com.liferay.portal.upgrade.v4_3_0.util;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class WebIdUtil {

	public static String[] getWebIds() throws Exception {
		if (_webIds != null) {
			return _webIds;
		}

		List<String> webIds = new ArrayList<String>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(_GET_WEB_IDS);

			rs = ps.executeQuery();

			while (rs.next()) {
				String companyId = rs.getString("companyId");

				webIds.add(companyId);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		_webIds = webIds.toArray(new String[webIds.size()]);

		return _webIds;
	}

	private static final String _GET_WEB_IDS = "select companyId from Company";

	private static String[] _webIds;

}