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

package com.liferay.portal.upgrade.v5_2_9_to_6_0_11;

import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.upgrade.v5_2_8_to_6_0_5.util.DLFileEntryTable;
import com.liferay.portal.upgrade.v5_2_8_to_6_0_5.util.DLFileVersionTable;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryNameUpgradeColumnImpl;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryTitleUpgradeColumnImpl;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileEntryVersionUpgradeColumnImpl;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileRankTable;
import com.liferay.portal.upgrade.v6_0_0.util.DLFileShortcutTable;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jorge Ferrer
 * @author Alexander Chow
 * @author Douglas Wong
 */
public class UpgradeDocumentLibrary extends UpgradeProcess {

	protected void doUpgrade() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement("select * from DLFileEntry");

			rs = ps.executeQuery();

			while (rs.next()) {
				long companyId = rs.getLong("companyId");
				long groupId = rs.getLong("groupId");
				long folderId = rs.getLong("folderId");
				String name = rs.getString("name");

				String portletId = PortletKeys.DOCUMENT_LIBRARY;
				long repositoryId = folderId;

				if (repositoryId ==
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

					repositoryId = groupId;
				}

				String newName = DLFileEntryNameUpgradeColumnImpl.getNewName(
					name);

				if (!newName.equals(name)) {
					DLLocalServiceUtil.updateFile(
						companyId, portletId, groupId, repositoryId, name,
						newName, false);
				}
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		// DLFileEntry

		UpgradeColumn nameColumn = new DLFileEntryNameUpgradeColumnImpl("name");
		UpgradeColumn titleColumn = new DLFileEntryTitleUpgradeColumnImpl(
			nameColumn, "title");
		UpgradeColumn versionColumn = new DLFileEntryVersionUpgradeColumnImpl(
			"version");

		UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileEntryTable.TABLE_NAME, DLFileEntryTable.TABLE_COLUMNS,
			nameColumn, titleColumn, versionColumn);

		upgradeTable.setCreateSQL(DLFileEntryTable.TABLE_SQL_CREATE);
		upgradeTable.setIndexesSQL(DLFileEntryTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// DLFileRank

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileRankTable.TABLE_NAME, DLFileRankTable.TABLE_COLUMNS,
			nameColumn);

		upgradeTable.setCreateSQL(
			StringUtil.replace(
				DLFileRankTable.TABLE_SQL_CREATE,
				",createDate DATE null",
				",createDate DATE null,fileEntryId LONG"));
		upgradeTable.setIndexesSQL(DLFileRankTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// DLFileShortcut

		UpgradeColumn toNameColumn = new DLFileEntryNameUpgradeColumnImpl(
			"toName");

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileShortcutTable.TABLE_NAME, DLFileShortcutTable.TABLE_COLUMNS,
			toNameColumn);

		upgradeTable.setCreateSQL(
			StringUtil.replace(
				DLFileShortcutTable.TABLE_SQL_CREATE,
				",folderId LONG",
				",folderId LONG,toFileEntryId LONG"));
		upgradeTable.setIndexesSQL(DLFileShortcutTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// DLFileVersion

		upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
			DLFileVersionTable.TABLE_NAME, DLFileVersionTable.TABLE_COLUMNS,
			nameColumn, versionColumn);

		upgradeTable.setCreateSQL(
			StringUtil.replace(
				DLFileVersionTable.TABLE_SQL_CREATE,
				",title VARCHAR(75) null",
				",title VARCHAR(255) null,fileEntryId LONG"));
		upgradeTable.setIndexesSQL(DLFileVersionTable.TABLE_SQL_ADD_INDEXES);

		upgradeTable.updateTable();

		// File entries

		updateFileEntries();

		// File versions

		updateFileVersions();

		runSQL("drop index IX_CE705D48 on DLFileRank");
		runSQL("drop index IX_40B56512 on DLFileRank");

		runSQL("drop index IX_55C736AC on DLFileShortcut");
		runSQL("drop index IX_346A0992 on DLFileShortcut");

		runSQL("drop index IX_B413F1EC on DLFileVersion");
		runSQL("drop index IX_94E784D2 on DLFileVersion");
		runSQL("drop index IX_2F8FED9C on DLFileVersion");
	}

	protected long getLatestFileVersionId(long folderId, String name)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		long fileVersionId = 0;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select fileVersionId from DLFileVersion where folderId = ? " +
					"and name = ? order by version desc");

			ps.setLong(1, folderId);
			ps.setString(2, name);

			rs = ps.executeQuery();

			if (rs.next()) {
				fileVersionId = rs.getLong("fileVersionId");
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		return fileVersionId;
	}

	protected void updateFileEntries() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select uuid_, fileEntryId, groupId, folderId, name, title " +
					"from DLFileEntry");

			rs = ps.executeQuery();

			while (rs.next()) {
				String uuid_ = rs.getString("uuid_");
				long fileEntryId = rs.getLong("fileEntryId");
				long groupId = rs.getLong("groupId");
				long folderId = rs.getLong("folderId");
				String name = rs.getString("name");
				String title = rs.getString("title");

				String extension = FileUtil.getExtension(title);

				runSQL(
					"update DLFileEntry set extension = '" + extension +
						"' where uuid_ = '" + uuid_ + "' and groupId = " +
							groupId);

				long fileVersionId = getLatestFileVersionId(folderId, name);

				runSQL(
					"update ExpandoRow set classPK = " + fileVersionId +
						 " where classPK = " + fileEntryId);

				runSQL(
					"update ExpandoValue set classPK = " + fileVersionId +
						 " where classPK = " + fileEntryId);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void updateFileVersion(
			long fileVersionId, String extension, String title, String
			description, String extraSettings)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"update DLFileVersion set extension = ?, title = ?, " +
					"description = ?,  extraSettings = ? where fileVersionId " +
						"= ?");

			ps.setString(1, extension);
			ps.setString(2, title);
			ps.setString(3, description);
			ps.setString(4, extraSettings);
			ps.setLong(5, fileVersionId);

			ps.executeUpdate();
		}
		finally {
			DataAccess.cleanUp(con, ps);
		}
	}

	protected void updateFileVersions() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select folderId, name, extension, title, description, " +
					"extraSettings from DLFileEntry");

			rs = ps.executeQuery();

			while (rs.next()) {
				long folderId = rs.getLong("folderId");
				String name = rs.getString("name");
				String extension = rs.getString("extension");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String extraSettings = rs.getString("extraSettings");

				long fileVersionId = getLatestFileVersionId(folderId, name);

				updateFileVersion(
					fileVersionId, extension, title, description,
					extraSettings);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

}