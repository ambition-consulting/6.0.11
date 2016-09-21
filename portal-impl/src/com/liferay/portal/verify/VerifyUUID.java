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

package com.liferay.portal.verify;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalFeedLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageResourceLocalServiceUtil;

import java.lang.reflect.Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Brian Wing Shun Chan
 */
public class VerifyUUID extends VerifyProcess {

	public static void verifyModel(
			String serviceClassName, String modelName, String pkColumnName)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select " + pkColumnName + " from " + modelName +
					" where uuid_ is null or uuid_ = ''");

			rs = ps.executeQuery();

			while (rs.next()) {
				long pk = rs.getLong(pkColumnName);

				verifyModel(serviceClassName, modelName, pk);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	public static void verifyModel(
			String serviceClassName, String modelName, long pk)
		throws Exception {

		MethodKey getPKMethodKey = new MethodKey(
			serviceClassName, "get" + modelName, long.class);

		MethodHandler getPKMethodHandler = new MethodHandler(
			getPKMethodKey, pk);

		Object pkValue = getPKMethodHandler.invoke(true);

		Method getPKMethod = MethodCache.get(getPKMethodKey);

		MethodKey updateUuidMethodKey = new MethodKey(
			serviceClassName, "update" + modelName,
			getPKMethod.getReturnType());

		MethodHandler updateUuidMethodHandler = new MethodHandler(
			updateUuidMethodKey, pkValue);

		updateUuidMethodHandler.invoke(true);
	}

	protected void doVerify() throws Exception {
		for (String[] model : _MODELS) {
			verifyModel(model[0], model[1], model[2]);
		}
	}

	private static final String[][] _MODELS = new String[][] {
		new String[] {
			IGFolderLocalServiceUtil.class.getName(),
			"IGFolder",
			"folderId"
		},
		new String[] {
			IGImageLocalServiceUtil.class.getName(),
			"IGImage",
			"imageId"
		},
		new String[] {
			JournalArticleLocalServiceUtil.class.getName(),
			"JournalArticle",
			"id_"
		},
		new String[] {
			JournalArticleResourceLocalServiceUtil.class.getName(),
			"JournalArticleResource",
			"resourcePrimKey"
		},
		new String[] {
			JournalFeedLocalServiceUtil.class.getName(),
			"JournalFeed",
			"id_"
		},
		new String[] {
			JournalStructureLocalServiceUtil.class.getName(),
			"JournalStructure",
			"id_"
		},
		new String[] {
			JournalTemplateLocalServiceUtil.class.getName(),
			"JournalTemplate",
			"id_"
		},
		new String[] {
			LayoutLocalServiceUtil.class.getName(),
			"Layout",
			"plid"
		},
		new String[] {
			WikiPageResourceLocalServiceUtil.class.getName(),
			"WikiPageResource",
			"resourcePrimKey"
		}
	};

}