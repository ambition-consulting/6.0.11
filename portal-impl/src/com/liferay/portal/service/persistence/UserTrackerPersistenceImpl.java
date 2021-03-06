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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.NoSuchUserTrackerException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.UserTracker;
import com.liferay.portal.model.impl.UserTrackerImpl;
import com.liferay.portal.model.impl.UserTrackerModelImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerPersistence
 * @see UserTrackerUtil
 * @generated
 */
public class UserTrackerPersistenceImpl extends BasePersistenceImpl<UserTracker>
	implements UserTrackerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserTrackerUtil} to access the user tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserTrackerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUserId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SESSIONID = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBySessionId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SESSIONID = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySessionId", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the user tracker in the entity cache if it is enabled.
	 *
	 * @param userTracker the user tracker to cache
	 */
	public void cacheResult(UserTracker userTracker) {
		EntityCacheUtil.putResult(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerImpl.class, userTracker.getPrimaryKey(), userTracker);
	}

	/**
	 * Caches the user trackers in the entity cache if it is enabled.
	 *
	 * @param userTrackers the user trackers to cache
	 */
	public void cacheResult(List<UserTracker> userTrackers) {
		for (UserTracker userTracker : userTrackers) {
			if (EntityCacheUtil.getResult(
						UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
						UserTrackerImpl.class, userTracker.getPrimaryKey(), this) == null) {
				cacheResult(userTracker);
			}
		}
	}

	/**
	 * Clears the cache for all user trackers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(UserTrackerImpl.class.getName());
		EntityCacheUtil.clearCache(UserTrackerImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the user tracker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(UserTracker userTracker) {
		EntityCacheUtil.removeResult(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerImpl.class, userTracker.getPrimaryKey());
	}

	/**
	 * Creates a new user tracker with the primary key. Does not add the user tracker to the database.
	 *
	 * @param userTrackerId the primary key for the new user tracker
	 * @return the new user tracker
	 */
	public UserTracker create(long userTrackerId) {
		UserTracker userTracker = new UserTrackerImpl();

		userTracker.setNew(true);
		userTracker.setPrimaryKey(userTrackerId);

		return userTracker;
	}

	/**
	 * Removes the user tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user tracker to remove
	 * @return the user tracker that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the user tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userTrackerId the primary key of the user tracker to remove
	 * @return the user tracker that was removed
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker remove(long userTrackerId)
		throws NoSuchUserTrackerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserTracker userTracker = (UserTracker)session.get(UserTrackerImpl.class,
					new Long(userTrackerId));

			if (userTracker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userTrackerId);
				}

				throw new NoSuchUserTrackerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					userTrackerId);
			}

			return remove(userTracker);
		}
		catch (NoSuchUserTrackerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTracker removeImpl(UserTracker userTracker)
		throws SystemException {
		userTracker = toUnwrappedModel(userTracker);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userTracker);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerImpl.class, userTracker.getPrimaryKey());

		return userTracker;
	}

	public UserTracker updateImpl(
		com.liferay.portal.model.UserTracker userTracker, boolean merge)
		throws SystemException {
		userTracker = toUnwrappedModel(userTracker);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userTracker, merge);

			userTracker.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
			UserTrackerImpl.class, userTracker.getPrimaryKey(), userTracker);

		return userTracker;
	}

	protected UserTracker toUnwrappedModel(UserTracker userTracker) {
		if (userTracker instanceof UserTrackerImpl) {
			return userTracker;
		}

		UserTrackerImpl userTrackerImpl = new UserTrackerImpl();

		userTrackerImpl.setNew(userTracker.isNew());
		userTrackerImpl.setPrimaryKey(userTracker.getPrimaryKey());

		userTrackerImpl.setUserTrackerId(userTracker.getUserTrackerId());
		userTrackerImpl.setCompanyId(userTracker.getCompanyId());
		userTrackerImpl.setUserId(userTracker.getUserId());
		userTrackerImpl.setModifiedDate(userTracker.getModifiedDate());
		userTrackerImpl.setSessionId(userTracker.getSessionId());
		userTrackerImpl.setRemoteAddr(userTracker.getRemoteAddr());
		userTrackerImpl.setRemoteHost(userTracker.getRemoteHost());
		userTrackerImpl.setUserAgent(userTracker.getUserAgent());

		return userTrackerImpl;
	}

	/**
	 * Finds the user tracker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user tracker to find
	 * @return the user tracker
	 * @throws com.liferay.portal.NoSuchModelException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the user tracker with the primary key or throws a {@link com.liferay.portal.NoSuchUserTrackerException} if it could not be found.
	 *
	 * @param userTrackerId the primary key of the user tracker to find
	 * @return the user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findByPrimaryKey(long userTrackerId)
		throws NoSuchUserTrackerException, SystemException {
		UserTracker userTracker = fetchByPrimaryKey(userTrackerId);

		if (userTracker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userTrackerId);
			}

			throw new NoSuchUserTrackerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userTrackerId);
		}

		return userTracker;
	}

	/**
	 * Finds the user tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user tracker to find
	 * @return the user tracker, or <code>null</code> if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the user tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userTrackerId the primary key of the user tracker to find
	 * @return the user tracker, or <code>null</code> if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker fetchByPrimaryKey(long userTrackerId)
		throws SystemException {
		UserTracker userTracker = (UserTracker)EntityCacheUtil.getResult(UserTrackerModelImpl.ENTITY_CACHE_ENABLED,
				UserTrackerImpl.class, userTrackerId, this);

		if (userTracker == null) {
			Session session = null;

			try {
				session = openSession();

				userTracker = (UserTracker)session.get(UserTrackerImpl.class,
						new Long(userTrackerId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (userTracker != null) {
					cacheResult(userTracker);
				}

				closeSession(session);
			}
		}

		return userTracker;
	}

	/**
	 * Finds all the user trackers where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the user trackers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @return the range of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user trackers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserTracker> list = (List<UserTracker>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_USERTRACKER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<UserTracker>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user tracker in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		List<UserTracker> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserTrackerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user tracker in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		int count = countByCompanyId(companyId);

		List<UserTracker> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserTrackerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user trackers before and after the current user tracker in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userTrackerId the primary key of the current user tracker
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker[] findByCompanyId_PrevAndNext(long userTrackerId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		UserTracker userTracker = findByPrimaryKey(userTrackerId);

		Session session = null;

		try {
			session = openSession();

			UserTracker[] array = new UserTrackerImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, userTracker,
					companyId, orderByComparator, true);

			array[1] = userTracker;

			array[2] = getByCompanyId_PrevAndNext(session, userTracker,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTracker getByCompanyId_PrevAndNext(Session session,
		UserTracker userTracker, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERTRACKER_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userTracker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserTracker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user trackers where userId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @return the matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the user trackers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @return the range of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user trackers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserTracker> list = (List<UserTracker>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_USERTRACKER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<UserTracker>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_USERID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user tracker in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		List<UserTracker> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserTrackerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user tracker in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		int count = countByUserId(userId);

		List<UserTracker> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserTrackerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user trackers before and after the current user tracker in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userTrackerId the primary key of the current user tracker
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker[] findByUserId_PrevAndNext(long userTrackerId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		UserTracker userTracker = findByPrimaryKey(userTrackerId);

		Session session = null;

		try {
			session = openSession();

			UserTracker[] array = new UserTrackerImpl[3];

			array[0] = getByUserId_PrevAndNext(session, userTracker, userId,
					orderByComparator, true);

			array[1] = userTracker;

			array[2] = getByUserId_PrevAndNext(session, userTracker, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTracker getByUserId_PrevAndNext(Session session,
		UserTracker userTracker, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERTRACKER_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userTracker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserTracker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user trackers where sessionId = &#63;.
	 *
	 * @param sessionId the session id to search with
	 * @return the matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findBySessionId(String sessionId)
		throws SystemException {
		return findBySessionId(sessionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the user trackers where sessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sessionId the session id to search with
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @return the range of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findBySessionId(String sessionId, int start,
		int end) throws SystemException {
		return findBySessionId(sessionId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user trackers where sessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sessionId the session id to search with
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findBySessionId(String sessionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				sessionId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserTracker> list = (List<UserTracker>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SESSIONID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_USERTRACKER_WHERE);

			if (sessionId == null) {
				query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_1);
			}
			else {
				if (sessionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sessionId != null) {
					qPos.add(sessionId);
				}

				list = (List<UserTracker>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SESSIONID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SESSIONID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user tracker in the ordered set where sessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sessionId the session id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findBySessionId_First(String sessionId,
		OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		List<UserTracker> list = findBySessionId(sessionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sessionId=");
			msg.append(sessionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserTrackerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user tracker in the ordered set where sessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sessionId the session id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker findBySessionId_Last(String sessionId,
		OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		int count = countBySessionId(sessionId);

		List<UserTracker> list = findBySessionId(sessionId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sessionId=");
			msg.append(sessionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserTrackerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user trackers before and after the current user tracker in the ordered set where sessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userTrackerId the primary key of the current user tracker
	 * @param sessionId the session id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user tracker
	 * @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserTracker[] findBySessionId_PrevAndNext(long userTrackerId,
		String sessionId, OrderByComparator orderByComparator)
		throws NoSuchUserTrackerException, SystemException {
		UserTracker userTracker = findByPrimaryKey(userTrackerId);

		Session session = null;

		try {
			session = openSession();

			UserTracker[] array = new UserTrackerImpl[3];

			array[0] = getBySessionId_PrevAndNext(session, userTracker,
					sessionId, orderByComparator, true);

			array[1] = userTracker;

			array[2] = getBySessionId_PrevAndNext(session, userTracker,
					sessionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTracker getBySessionId_PrevAndNext(Session session,
		UserTracker userTracker, String sessionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERTRACKER_WHERE);

		if (sessionId == null) {
			query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_1);
		}
		else {
			if (sessionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (sessionId != null) {
			qPos.add(sessionId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userTracker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserTracker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user trackers.
	 *
	 * @return the user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the user trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @return the range of user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the user trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user trackers to return
	 * @param end the upper bound of the range of user trackers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserTracker> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserTracker> list = (List<UserTracker>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERTRACKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERTRACKER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserTracker>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserTracker>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user trackers where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (UserTracker userTracker : findByCompanyId(companyId)) {
			remove(userTracker);
		}
	}

	/**
	 * Removes all the user trackers where userId = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (UserTracker userTracker : findByUserId(userId)) {
			remove(userTracker);
		}
	}

	/**
	 * Removes all the user trackers where sessionId = &#63; from the database.
	 *
	 * @param sessionId the session id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySessionId(String sessionId) throws SystemException {
		for (UserTracker userTracker : findBySessionId(sessionId)) {
			remove(userTracker);
		}
	}

	/**
	 * Removes all the user trackers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserTracker userTracker : findAll()) {
			remove(userTracker);
		}
	}

	/**
	 * Counts all the user trackers where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERTRACKER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user trackers where userId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @return the number of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERTRACKER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user trackers where sessionId = &#63;.
	 *
	 * @param sessionId the session id to search with
	 * @return the number of matching user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySessionId(String sessionId) throws SystemException {
		Object[] finderArgs = new Object[] { sessionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SESSIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERTRACKER_WHERE);

			if (sessionId == null) {
				query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_1);
			}
			else {
				if (sessionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_SESSIONID_SESSIONID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sessionId != null) {
					qPos.add(sessionId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SESSIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user trackers.
	 *
	 * @return the number of user trackers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERTRACKER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the user tracker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.UserTracker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserTracker>> listenersList = new ArrayList<ModelListener<UserTracker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserTracker>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UserTrackerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = AccountPersistence.class)
	protected AccountPersistence accountPersistence;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = BrowserTrackerPersistence.class)
	protected BrowserTrackerPersistence browserTrackerPersistence;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = ClusterGroupPersistence.class)
	protected ClusterGroupPersistence clusterGroupPersistence;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@BeanReference(type = EmailAddressPersistence.class)
	protected EmailAddressPersistence emailAddressPersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = LayoutPersistence.class)
	protected LayoutPersistence layoutPersistence;
	@BeanReference(type = LayoutPrototypePersistence.class)
	protected LayoutPrototypePersistence layoutPrototypePersistence;
	@BeanReference(type = LayoutSetPersistence.class)
	protected LayoutSetPersistence layoutSetPersistence;
	@BeanReference(type = LayoutSetPrototypePersistence.class)
	protected LayoutSetPrototypePersistence layoutSetPrototypePersistence;
	@BeanReference(type = ListTypePersistence.class)
	protected ListTypePersistence listTypePersistence;
	@BeanReference(type = LockPersistence.class)
	protected LockPersistence lockPersistence;
	@BeanReference(type = MembershipRequestPersistence.class)
	protected MembershipRequestPersistence membershipRequestPersistence;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = OrgGroupPermissionPersistence.class)
	protected OrgGroupPermissionPersistence orgGroupPermissionPersistence;
	@BeanReference(type = OrgGroupRolePersistence.class)
	protected OrgGroupRolePersistence orgGroupRolePersistence;
	@BeanReference(type = OrgLaborPersistence.class)
	protected OrgLaborPersistence orgLaborPersistence;
	@BeanReference(type = PasswordPolicyPersistence.class)
	protected PasswordPolicyPersistence passwordPolicyPersistence;
	@BeanReference(type = PasswordPolicyRelPersistence.class)
	protected PasswordPolicyRelPersistence passwordPolicyRelPersistence;
	@BeanReference(type = PasswordTrackerPersistence.class)
	protected PasswordTrackerPersistence passwordTrackerPersistence;
	@BeanReference(type = PermissionPersistence.class)
	protected PermissionPersistence permissionPersistence;
	@BeanReference(type = PhonePersistence.class)
	protected PhonePersistence phonePersistence;
	@BeanReference(type = PluginSettingPersistence.class)
	protected PluginSettingPersistence pluginSettingPersistence;
	@BeanReference(type = PortletPersistence.class)
	protected PortletPersistence portletPersistence;
	@BeanReference(type = PortletItemPersistence.class)
	protected PortletItemPersistence portletItemPersistence;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = RegionPersistence.class)
	protected RegionPersistence regionPersistence;
	@BeanReference(type = ReleasePersistence.class)
	protected ReleasePersistence releasePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceActionPersistence.class)
	protected ResourceActionPersistence resourceActionPersistence;
	@BeanReference(type = ResourceCodePersistence.class)
	protected ResourceCodePersistence resourceCodePersistence;
	@BeanReference(type = ResourcePermissionPersistence.class)
	protected ResourcePermissionPersistence resourcePermissionPersistence;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = ServiceComponentPersistence.class)
	protected ServiceComponentPersistence serviceComponentPersistence;
	@BeanReference(type = ShardPersistence.class)
	protected ShardPersistence shardPersistence;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = TicketPersistence.class)
	protected TicketPersistence ticketPersistence;
	@BeanReference(type = TeamPersistence.class)
	protected TeamPersistence teamPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserGroupPersistence.class)
	protected UserGroupPersistence userGroupPersistence;
	@BeanReference(type = UserGroupGroupRolePersistence.class)
	protected UserGroupGroupRolePersistence userGroupGroupRolePersistence;
	@BeanReference(type = UserGroupRolePersistence.class)
	protected UserGroupRolePersistence userGroupRolePersistence;
	@BeanReference(type = UserIdMapperPersistence.class)
	protected UserIdMapperPersistence userIdMapperPersistence;
	@BeanReference(type = UserTrackerPersistence.class)
	protected UserTrackerPersistence userTrackerPersistence;
	@BeanReference(type = UserTrackerPathPersistence.class)
	protected UserTrackerPathPersistence userTrackerPathPersistence;
	@BeanReference(type = WebDAVPropsPersistence.class)
	protected WebDAVPropsPersistence webDAVPropsPersistence;
	@BeanReference(type = WebsitePersistence.class)
	protected WebsitePersistence websitePersistence;
	@BeanReference(type = WorkflowDefinitionLinkPersistence.class)
	protected WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	private static final String _SQL_SELECT_USERTRACKER = "SELECT userTracker FROM UserTracker userTracker";
	private static final String _SQL_SELECT_USERTRACKER_WHERE = "SELECT userTracker FROM UserTracker userTracker WHERE ";
	private static final String _SQL_COUNT_USERTRACKER = "SELECT COUNT(userTracker) FROM UserTracker userTracker";
	private static final String _SQL_COUNT_USERTRACKER_WHERE = "SELECT COUNT(userTracker) FROM UserTracker userTracker WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "userTracker.companyId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userTracker.userId = ?";
	private static final String _FINDER_COLUMN_SESSIONID_SESSIONID_1 = "userTracker.sessionId IS NULL";
	private static final String _FINDER_COLUMN_SESSIONID_SESSIONID_2 = "userTracker.sessionId = ?";
	private static final String _FINDER_COLUMN_SESSIONID_SESSIONID_3 = "(userTracker.sessionId IS NULL OR userTracker.sessionId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userTracker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserTracker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserTracker exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(UserTrackerPersistenceImpl.class);
}