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

package com.liferay.portal.service.impl;

import com.liferay.portal.DuplicateLockException;
import com.liferay.portal.ExpiredLockException;
import com.liferay.portal.NoSuchLockException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Lock;
import com.liferay.portal.model.User;
import com.liferay.portal.service.base.LockLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class LockLocalServiceImpl extends LockLocalServiceBaseImpl {

	public void clear() throws SystemException {
		lockPersistence.removeByLtExpirationDate(new Date());
	}

	public Lock getLock(String className, long key)
		throws PortalException, SystemException {

		return getLock(className, String.valueOf(key));
	}

	public Lock getLock(String className, String key)
		throws PortalException, SystemException {

		Lock lock = lockPersistence.findByC_K(className, key);

		if (lock.isExpired()) {
			unlock(className, key);

			throw new ExpiredLockException();
		}

		return lock;
	}

	public boolean hasLock(long userId, String className, long key)
		throws PortalException, SystemException {

		return hasLock(userId, className, String.valueOf(key));
	}

	public boolean hasLock(long userId, String className, String key)
		throws PortalException, SystemException {

		try {
			Lock lock = getLock(className, key);

			if (lock.getUserId() == userId) {
				return true;
			}
		}
		catch (ExpiredLockException ele) {
		}
		catch (NoSuchLockException nsle) {
		}

		return false;
	}

	public boolean isLocked(String className, long key)
		throws PortalException, SystemException {

		return isLocked(className, String.valueOf(key));
	}

	public boolean isLocked(String className, String key)
		throws PortalException, SystemException {

		try {
			getLock(className, key);

			return true;
		}
		catch (ExpiredLockException ele) {
		}
		catch (NoSuchLockException nsle) {
		}

		return false;
	}

	public Lock lock(
			long userId, String className, long key, String owner,
			boolean inheritable, long expirationTime)
		throws PortalException, SystemException {

		return lock(
			userId, className, String.valueOf(key), owner, inheritable,
			expirationTime);
	}

	public Lock lock(
			long userId, String className, String key, String owner,
			boolean inheritable, long expirationTime)
		throws PortalException, SystemException {

		Date now = new Date();

		Lock lock = lockPersistence.fetchByC_K(className, key);

		if (lock != null) {
			if (lock.isExpired()) {
				unlock(className, key);

				lock = null;
			}
			else if (lock.getUserId() != userId) {
				throw new DuplicateLockException(lock);
			}
		}

		if (lock == null) {
			User user = userPersistence.findByPrimaryKey(userId);

			long lockId = counterLocalService.increment();

			lock = lockPersistence.create(lockId);

			lock.setCompanyId(user.getCompanyId());
			lock.setUserId(user.getUserId());
			lock.setUserName(user.getFullName());
			lock.setUserId(userId);
			lock.setClassName(className);
			lock.setKey(key);
			lock.setOwner(owner);
			lock.setInheritable(inheritable);
		}

		lock.setCreateDate(now);

		if (expirationTime == 0) {
			lock.setExpirationDate(null);
		}
		else {
			lock.setExpirationDate(new Date(now.getTime() + expirationTime));
		}

		lockPersistence.update(lock, false);

		return lock;
	}

	public Lock refresh(String uuid, long expirationTime)
		throws PortalException, SystemException {

		Date now = new Date();

		List<Lock> locks = lockPersistence.findByUuid(uuid);

		if (locks.isEmpty()) {
			throw new NoSuchLockException();
		}

		Lock lock = locks.get(0);

		lock.setCreateDate(now);

		if (expirationTime == 0) {
			lock.setExpirationDate(null);
		}
		else {
			lock.setExpirationDate(new Date(now.getTime() + expirationTime));
		}

		lockPersistence.update(lock, false);

		return lock;
	}

	public void unlock(String className, long key) throws SystemException {
		unlock(className, String.valueOf(key));
	}

	public void unlock(String className, String key) throws SystemException {
		try {
			lockPersistence.removeByC_K(className, key);
		}
		catch (NoSuchLockException nsle) {
		}
	}

}