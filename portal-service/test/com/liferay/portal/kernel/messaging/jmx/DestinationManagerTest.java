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

package com.liferay.portal.kernel.messaging.jmx;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.test.TestCase;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

/**
 * @author Michael C. Han
 */
public class DestinationManagerTest extends TestCase {

	public void setUp() throws Exception {
		_mBeanServer = ManagementFactory.getPlatformMBeanServer();
		_mockery = new JUnit4Mockery();
	}

	public void testRegisterMBean() throws Exception {
		_mBeanServer.registerMBean(
			new DestinationManager(_mockery.mock(Destination.class)),
			DestinationManager.createObjectName("test"));

		assertTrue(
			_mBeanServer.isRegistered(
				DestinationManager.createObjectName("test")));
	}

	private MBeanServer _mBeanServer;
	private Mockery _mockery;

}