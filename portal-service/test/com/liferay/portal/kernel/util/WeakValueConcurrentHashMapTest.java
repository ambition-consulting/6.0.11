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

import com.liferay.portal.kernel.memory.DummyFinalizeAction;
import com.liferay.portal.kernel.memory.FinalizeManager;
import com.liferay.portal.kernel.test.TestCase;

/**
 * @author Shuyang Zhou
 */
public class WeakValueConcurrentHashMapTest extends TestCase {

	public void testAutoRemove() throws Exception{
		Thread thread = Thread.currentThread();

		PortalClassLoaderUtil.setClassLoader(thread.getContextClassLoader());

		WeakValueConcurrentHashMap<String, Object> weakValueConcurrentHashMap =
			new WeakValueConcurrentHashMap<String, Object>();

		String testKey = "testKey";
		Object testValue = new Object();

		weakValueConcurrentHashMap.put(testKey, testValue);

		long startTime = System.currentTimeMillis();

		while ((System.currentTimeMillis() - startTime) < 100) {
			System.gc();

			Thread.sleep(1);

			assertTrue(weakValueConcurrentHashMap.containsKey(testKey));
		}

		// Release key for gc

		testValue = null;

		startTime = System.currentTimeMillis();

		while ((System.currentTimeMillis() - startTime) < 100) {
			System.gc();

			Thread.sleep(1);

			if (!FinalizeManager.THREAD_ENABLED) {
				// Manually trigger cleanup when FianlizeManager's thread is
				// diabled

				FinalizeManager.register(
					new Object(), new DummyFinalizeAction());
			}

			if (!weakValueConcurrentHashMap.containsKey(testKey)) {
				break;
			}
		}

		assertFalse(weakValueConcurrentHashMap.containsKey(testKey));

		PortalClassLoaderUtil.setClassLoader(null);
	}

}