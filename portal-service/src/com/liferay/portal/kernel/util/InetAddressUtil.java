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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.exception.SystemException;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

import java.util.Enumeration;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public class InetAddressUtil {

	public static InetAddress getLocalInetAddress() throws Exception {
		Enumeration<NetworkInterface> enu1 =
			NetworkInterface.getNetworkInterfaces();

		while (enu1.hasMoreElements()) {
			NetworkInterface networkInterface = enu1.nextElement();

			Enumeration<InetAddress> enu2 =
				networkInterface.getInetAddresses();

			while (enu2.hasMoreElements()) {
				InetAddress inetAddress = enu2.nextElement();

				if (!inetAddress.isLoopbackAddress() &&
					(inetAddress instanceof Inet4Address)) {

					return inetAddress;
				}
			}
		}

		throw new SystemException("No local internet address");
	}

}