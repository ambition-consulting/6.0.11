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

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * This abstract class should be extended for startup processes that verify the
 * integrity of the database. They can be added as part of
 * <code>com.liferay.portal.verify.VerifyProcessSuite</code> or be executed
 * independently by being set in the portal.properties file. Each of these
 * processes should not cause any problems if run multiple times.
 *
 * @author Alexander Chow
 */
public abstract class VerifyProcess {

	public static final int ALWAYS = -1;

	public static final int NEVER = 0;

	public static final int ONCE = 1;

	public void runSQL(String template) throws IOException, SQLException {
		DB db = DBFactoryUtil.getDB();

		db.runSQL(template);
	}

	public void runSQL(String[] templates) throws IOException, SQLException {
		DB db = DBFactoryUtil.getDB();

		db.runSQL(templates);
	}

	public void runSQLTemplate(String path)
		throws IOException, NamingException, SQLException {

		DB db = DBFactoryUtil.getDB();

		db.runSQLTemplate(path);
	}

	public void runSQLTemplate(String path, boolean failOnError)
		throws IOException, NamingException, SQLException {

		DB db = DBFactoryUtil.getDB();

		db.runSQLTemplate(path, failOnError);
	}

	public void verify() throws VerifyException {
		try {
			if (_log.isInfoEnabled()) {
				_log.info("Verifying " + getClass().getName());
			}

			doVerify();
		}
		catch (Exception e) {
			throw new VerifyException(e);
		}
	}

	public void verify(VerifyProcess verifyProcess)
		throws VerifyException {

		verifyProcess.verify();
	}

	protected void doVerify() throws Exception {
	}

	private static Log _log = LogFactoryUtil.getLog(VerifyProcess.class);

}