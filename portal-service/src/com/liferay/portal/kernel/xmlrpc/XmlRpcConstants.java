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

package com.liferay.portal.kernel.xmlrpc;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public interface XmlRpcConstants {

	public static final int APPLICATION_ERROR = -32500;

	public static final int INTERNAL_XMLRPC_ERROR = -32603;

	public static final int INVALID_CHARACTER_FOR_ENCODING = -32702;

	public static final int INVALID_METHOD_PARAMETERS = -32602;

	public static final int INVALID_XMLRPC = -32600;

	public static final int NOT_WELL_FORMED = -32700;

	public static final int REQUESTED_METHOD_NOT_FOUND = -32601;

	public static final int SYSTEM_ERROR = -32400;

	public static final int TRANSPORT_ERROR = -32300;

	public static final int UNSUPPORTED_ENCODING = -32701;

}