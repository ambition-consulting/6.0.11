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

package com.liferay.util.transport;

import java.io.IOException;

/**
 * @author Michael C. Han
 */
public interface Transport {

	public void connect() throws IOException;

	public void disconnect() throws IOException;

	public void sendMessage(String message) throws IOException;

	public boolean isConnected();

}