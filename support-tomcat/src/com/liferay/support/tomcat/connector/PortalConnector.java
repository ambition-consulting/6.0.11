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

package com.liferay.support.tomcat.connector;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;

/**
 * @author Minhchau Dang
 */
public class PortalConnector extends Connector {

	public PortalConnector(Connector connector) throws Exception {
		super(connector.getProtocol());

		_copyConnector(connector);
	}

	public Request createRequest() {
		Request request = new PortalRequest();

		request.setConnector(this);

		return request;
	}

	private void _copyConnector(Connector connector) {
		protocolHandler = connector.getProtocolHandler();

		setAllowTrace(connector.getAllowTrace());
		setEmptySessionPath(connector.getEmptySessionPath());
		setEnableLookups(connector.getEnableLookups());
		setMaxPostSize(connector.getMaxPostSize());
		setMaxSavePostSize(connector.getMaxSavePostSize());
		setPort(connector.getPort());
		setProtocol(connector.getProtocol());
		setProxyName(connector.getProxyName());
		setProxyPort(connector.getProxyPort());
		setRedirectPort(connector.getRedirectPort());
		setScheme(connector.getScheme());
		setSecure(connector.getSecure());
		setURIEncoding(connector.getURIEncoding());
		setUseBodyEncodingForURI(connector.getUseBodyEncodingForURI());
		setUseIPVHosts(connector.getUseIPVHosts());
		setXpoweredBy(connector.getXpoweredBy());
	}

}