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

package com.liferay.portal.upgrade.v6_0_3;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.upgrade.BaseUpgradePortletPreferences;
import com.liferay.portlet.PortletPreferencesImpl;
import com.liferay.portlet.PortletPreferencesSerializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Julio Camarero
 */
public class UpgradeAssetPublisher extends BaseUpgradePortletPreferences {

	protected String[] getAssetEntryXmls(String[] assetEntryXmls)
		throws Exception {

		String[] newAssetEntryXmls = new String[assetEntryXmls.length];

		for (int i = 0; i < assetEntryXmls.length; i++) {
			String assetEntryXml = assetEntryXmls[i];

			Document document = SAXReaderUtil.read(assetEntryXml);

			Element rootElement = document.getRootElement();

			Element assetEntryIdElement = rootElement.element(
				"asset-entry-id");

			long assetEntryId = GetterUtil.getLong(
				assetEntryIdElement.getText());

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				con = DataAccess.getConnection();

				ps = con.prepareStatement(
					"select classUuid from AssetEntry where entryId = ?");

				ps.setLong(1, assetEntryId);

				rs = ps.executeQuery();

				rs.next();

				String classUuid = rs.getString("classUuid");

				Element assetEntryUuidElement = rootElement.addElement(
					"asset-entry-uuid");

				assetEntryUuidElement.addText(classUuid);

				rootElement.remove(assetEntryIdElement);

				newAssetEntryXmls[i] = document.formattedString(
					StringPool.BLANK);
			}
			finally {
				DataAccess.cleanUp(con, ps, rs);
			}
		}

		return newAssetEntryXmls;
	}

	protected String getUpdatePortletPreferencesWhereClause() {
		return "portletId like '101_INSTANCE_%'";
	}

	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferencesImpl preferences =
			PortletPreferencesSerializer.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		String selectionStyle = preferences.getValue("selection-style", null);

		if (Validator.isNotNull(selectionStyle) &&
			!selectionStyle.equals("dynamic")) {

			String[] assetEntryXmls = preferences.getValues(
				"asset-entry-xml", new String[0]);

			String[] newAssetEntryXmls = getAssetEntryXmls(assetEntryXmls);

			preferences.setValues("asset-entry-xml", newAssetEntryXmls);
		}

		return PortletPreferencesSerializer.toXML(preferences);
	}

}