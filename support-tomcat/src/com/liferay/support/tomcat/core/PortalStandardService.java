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

package com.liferay.support.tomcat.core;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.support.tomcat.connector.PortalConnector;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardService;

/**
 * <p>
 * See http://issues.liferay.com/browse/LEP-4602.
 * </p>
 *
 * @author Minhchau Dang
 */
public class PortalStandardService extends StandardService {

	public void addConnector(Connector connector) {

		try {
			connector = new PortalConnector(connector);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		super.addConnector(connector);
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortalStandardService.class);

}