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

package com.liferay.portal.upgrade.v4_4_0;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeUUID extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		updateTable("BlogsEntry", "entryId");
		updateTable("BookmarksEntry", "entryId");
		updateTable("BookmarksFolder", "folderId");
		updateTable("DLFileEntry", "fileEntryId");
		updateTable("DLFileShortcut", "fileShortcutId");
		updateTable("DLFolder", "folderId");
		updateTable("CalEvent", "eventId");
		updateTable("IGFolder", "folderId");
		updateTable("IGImage", "imageId");
		updateTable("JournalArticle", "id_");
		updateTable("JournalStructure", "id_");
		updateTable("JournalTemplate", "id_");
		updateTable("MBCategory", "categoryId");
		updateTable("MBMessage", "messageId");
		updateTable("PollsChoice", "choiceId");
		updateTable("PollsQuestion", "questionId");
		updateTable("User_", "userId");
		updateTable("WikiNode", "nodeId");
		updateTable("WikiPage", "pageId");
	}

	protected void updateTable(String tableName, String pkColName)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select " + pkColName + " from " + tableName +
					" where uuid_ IS NULL or uuid_ = ''");

			rs = ps.executeQuery();

			while (rs.next()) {
				long pkColValue = rs.getLong(pkColName);

				String uuid = PortalUUIDUtil.generate();

				runSQL(
					"update " + tableName + " set uuid_ = '" + uuid +
						"' where " + pkColName + " = " + pkColValue);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

}