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

package com.liferay.portal.kernel.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shuyang Zhou
 */
public class LockRegistry {

	public static Lock allocateLock(String groupName, String key) {
		ConcurrentHashMap<String, Lock> lockGroup = _lockGroupMap.get(
			groupName);

		if (lockGroup == null) {
			lockGroup = new ConcurrentHashMap<String, Lock>();

			ConcurrentHashMap<String, Lock> oldLockGroup =
				_lockGroupMap.putIfAbsent(groupName, lockGroup);

			if (oldLockGroup != null) {
				lockGroup = oldLockGroup;
			}
		}

		Lock lock = lockGroup.get(key);

		if (lock == null) {
			lock = new ReentrantLock();

			Lock oldLock = lockGroup.putIfAbsent(key, lock);

			if (oldLock != null) {
				lock = oldLock;
			}
		}

		return lock;
	}

	public static void freeAllLock() {
		freeAllLock(false);
	}

	public static void freeAllLock(boolean unlock) {
		if (unlock == true) {
			for (Map<String, Lock> lockGroup : _lockGroupMap.values()) {
				for (Lock lock : lockGroup.values()) {
					lock.unlock();
				}
			}
		}

		_lockGroupMap.clear();
	}

	public static Map<String, Lock> freeLock(String groupName) {
		return freeLock(groupName, false);
	}

	public static Map<String, Lock> freeLock(String groupName, boolean unlock) {
		Map<String, Lock> lockGroup = _lockGroupMap.remove(groupName);

		if (lockGroup == null) {
			return null;
		}

		if (unlock == true) {
			for (Lock lock : lockGroup.values()) {
				lock.unlock();
			}
		}

		return lockGroup;
	}

	public static Lock freeLock(String groupName, String key) {
		return freeLock(groupName, key, false);
	}

	public static Lock freeLock(String groupName, String key, boolean unlock) {
		Map<String, Lock> lockGroup = _lockGroupMap.get(groupName);

		if (lockGroup == null) {
			return null;
		}

		Lock lock = lockGroup.remove(key);

		if (lock == null) {
			return null;
		}

		if (unlock) {
			lock.unlock();
		}

		return lock;
	}

	private static ConcurrentHashMap<String, ConcurrentHashMap<String, Lock>>
		_lockGroupMap =
			new ConcurrentHashMap<String, ConcurrentHashMap<String, Lock>>();

}