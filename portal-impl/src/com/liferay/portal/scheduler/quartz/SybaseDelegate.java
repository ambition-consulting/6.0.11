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

package com.liferay.portal.scheduler.quartz;

import java.io.ByteArrayOutputStream;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.quartz.impl.jdbcjobstore.MSSQLDelegate;

/**
 * <p>
 * See http://issues.liferay.com/browse/LPS-14611.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class SybaseDelegate extends MSSQLDelegate {

	public SybaseDelegate(
		org.apache.commons.logging.Log log, String tablePrefix,
		String instanceId) {

		super(log, tablePrefix, instanceId);
	}

	public SybaseDelegate(
		org.apache.commons.logging.Log log, String tablePrefix,
		String instanceId, Boolean useProperties) {

		super(log, tablePrefix, instanceId, useProperties);
	}

	protected void setBytes(
			PreparedStatement ps, int index, ByteArrayOutputStream baos)
		throws SQLException {

		if (baos == null) {
			ps.setBytes(index, null);
		}
		else {
			ps.setBytes(index, baos.toByteArray());
		}
	}

}