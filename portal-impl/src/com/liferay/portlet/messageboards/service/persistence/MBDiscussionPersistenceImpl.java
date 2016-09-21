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

package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.NoSuchModelException;
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
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.messageboards.NoSuchDiscussionException;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.impl.MBDiscussionImpl;
import com.liferay.portlet.messageboards.model.impl.MBDiscussionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the message boards discussion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBDiscussionPersistence
 * @see MBDiscussionUtil
 * @generated
 */
public class MBDiscussionPersistenceImpl extends BasePersistenceImpl<MBDiscussion>
	implements MBDiscussionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MBDiscussionUtil} to access the message boards discussion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MBDiscussionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_CLASSNAMEID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByClassNameId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByClassNameId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_THREADID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByThreadId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_THREADID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByThreadId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the message boards discussion in the entity cache if it is enabled.
	 *
	 * @param mbDiscussion the message boards discussion to cache
	 */
	public void cacheResult(MBDiscussion mbDiscussion) {
		EntityCacheUtil.putResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionImpl.class, mbDiscussion.getPrimaryKey(), mbDiscussion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
			new Object[] { new Long(mbDiscussion.getThreadId()) }, mbDiscussion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
			new Object[] {
				new Long(mbDiscussion.getClassNameId()),
				new Long(mbDiscussion.getClassPK())
			}, mbDiscussion);
	}

	/**
	 * Caches the message boards discussions in the entity cache if it is enabled.
	 *
	 * @param mbDiscussions the message boards discussions to cache
	 */
	public void cacheResult(List<MBDiscussion> mbDiscussions) {
		for (MBDiscussion mbDiscussion : mbDiscussions) {
			if (EntityCacheUtil.getResult(
						MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
						MBDiscussionImpl.class, mbDiscussion.getPrimaryKey(),
						this) == null) {
				cacheResult(mbDiscussion);
			}
		}
	}

	/**
	 * Clears the cache for all message boards discussions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(MBDiscussionImpl.class.getName());
		EntityCacheUtil.clearCache(MBDiscussionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the message boards discussion.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(MBDiscussion mbDiscussion) {
		EntityCacheUtil.removeResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionImpl.class, mbDiscussion.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THREADID,
			new Object[] { new Long(mbDiscussion.getThreadId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
			new Object[] {
				new Long(mbDiscussion.getClassNameId()),
				new Long(mbDiscussion.getClassPK())
			});
	}

	/**
	 * Creates a new message boards discussion with the primary key. Does not add the message boards discussion to the database.
	 *
	 * @param discussionId the primary key for the new message boards discussion
	 * @return the new message boards discussion
	 */
	public MBDiscussion create(long discussionId) {
		MBDiscussion mbDiscussion = new MBDiscussionImpl();

		mbDiscussion.setNew(true);
		mbDiscussion.setPrimaryKey(discussionId);

		return mbDiscussion;
	}

	/**
	 * Removes the message boards discussion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the message boards discussion to remove
	 * @return the message boards discussion that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the message boards discussion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param discussionId the primary key of the message boards discussion to remove
	 * @return the message boards discussion that was removed
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion remove(long discussionId)
		throws NoSuchDiscussionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MBDiscussion mbDiscussion = (MBDiscussion)session.get(MBDiscussionImpl.class,
					new Long(discussionId));

			if (mbDiscussion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + discussionId);
				}

				throw new NoSuchDiscussionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					discussionId);
			}

			return remove(mbDiscussion);
		}
		catch (NoSuchDiscussionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MBDiscussion removeImpl(MBDiscussion mbDiscussion)
		throws SystemException {
		mbDiscussion = toUnwrappedModel(mbDiscussion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, mbDiscussion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		MBDiscussionModelImpl mbDiscussionModelImpl = (MBDiscussionModelImpl)mbDiscussion;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THREADID,
			new Object[] { new Long(mbDiscussionModelImpl.getOriginalThreadId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
			new Object[] {
				new Long(mbDiscussionModelImpl.getOriginalClassNameId()),
				new Long(mbDiscussionModelImpl.getOriginalClassPK())
			});

		EntityCacheUtil.removeResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionImpl.class, mbDiscussion.getPrimaryKey());

		return mbDiscussion;
	}

	public MBDiscussion updateImpl(
		com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion,
		boolean merge) throws SystemException {
		mbDiscussion = toUnwrappedModel(mbDiscussion);

		boolean isNew = mbDiscussion.isNew();

		MBDiscussionModelImpl mbDiscussionModelImpl = (MBDiscussionModelImpl)mbDiscussion;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, mbDiscussion, merge);

			mbDiscussion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			MBDiscussionImpl.class, mbDiscussion.getPrimaryKey(), mbDiscussion);

		if (!isNew &&
				(mbDiscussion.getThreadId() != mbDiscussionModelImpl.getOriginalThreadId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THREADID,
				new Object[] {
					new Long(mbDiscussionModelImpl.getOriginalThreadId())
				});
		}

		if (isNew ||
				(mbDiscussion.getThreadId() != mbDiscussionModelImpl.getOriginalThreadId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
				new Object[] { new Long(mbDiscussion.getThreadId()) },
				mbDiscussion);
		}

		if (!isNew &&
				((mbDiscussion.getClassNameId() != mbDiscussionModelImpl.getOriginalClassNameId()) ||
				(mbDiscussion.getClassPK() != mbDiscussionModelImpl.getOriginalClassPK()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
				new Object[] {
					new Long(mbDiscussionModelImpl.getOriginalClassNameId()),
					new Long(mbDiscussionModelImpl.getOriginalClassPK())
				});
		}

		if (isNew ||
				((mbDiscussion.getClassNameId() != mbDiscussionModelImpl.getOriginalClassNameId()) ||
				(mbDiscussion.getClassPK() != mbDiscussionModelImpl.getOriginalClassPK()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
				new Object[] {
					new Long(mbDiscussion.getClassNameId()),
					new Long(mbDiscussion.getClassPK())
				}, mbDiscussion);
		}

		return mbDiscussion;
	}

	protected MBDiscussion toUnwrappedModel(MBDiscussion mbDiscussion) {
		if (mbDiscussion instanceof MBDiscussionImpl) {
			return mbDiscussion;
		}

		MBDiscussionImpl mbDiscussionImpl = new MBDiscussionImpl();

		mbDiscussionImpl.setNew(mbDiscussion.isNew());
		mbDiscussionImpl.setPrimaryKey(mbDiscussion.getPrimaryKey());

		mbDiscussionImpl.setDiscussionId(mbDiscussion.getDiscussionId());
		mbDiscussionImpl.setClassNameId(mbDiscussion.getClassNameId());
		mbDiscussionImpl.setClassPK(mbDiscussion.getClassPK());
		mbDiscussionImpl.setThreadId(mbDiscussion.getThreadId());

		return mbDiscussionImpl;
	}

	/**
	 * Finds the message boards discussion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the message boards discussion to find
	 * @return the message boards discussion
	 * @throws com.liferay.portal.NoSuchModelException if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the message boards discussion with the primary key or throws a {@link com.liferay.portlet.messageboards.NoSuchDiscussionException} if it could not be found.
	 *
	 * @param discussionId the primary key of the message boards discussion to find
	 * @return the message boards discussion
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion findByPrimaryKey(long discussionId)
		throws NoSuchDiscussionException, SystemException {
		MBDiscussion mbDiscussion = fetchByPrimaryKey(discussionId);

		if (mbDiscussion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + discussionId);
			}

			throw new NoSuchDiscussionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				discussionId);
		}

		return mbDiscussion;
	}

	/**
	 * Finds the message boards discussion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the message boards discussion to find
	 * @return the message boards discussion, or <code>null</code> if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the message boards discussion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param discussionId the primary key of the message boards discussion to find
	 * @return the message boards discussion, or <code>null</code> if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion fetchByPrimaryKey(long discussionId)
		throws SystemException {
		MBDiscussion mbDiscussion = (MBDiscussion)EntityCacheUtil.getResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
				MBDiscussionImpl.class, discussionId, this);

		if (mbDiscussion == null) {
			Session session = null;

			try {
				session = openSession();

				mbDiscussion = (MBDiscussion)session.get(MBDiscussionImpl.class,
						new Long(discussionId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (mbDiscussion != null) {
					cacheResult(mbDiscussion);
				}

				closeSession(session);
			}
		}

		return mbDiscussion;
	}

	/**
	 * Finds all the message boards discussions where classNameId = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @return the matching message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public List<MBDiscussion> findByClassNameId(long classNameId)
		throws SystemException {
		return findByClassNameId(classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the message boards discussions where classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param start the lower bound of the range of message boards discussions to return
	 * @param end the upper bound of the range of message boards discussions to return (not inclusive)
	 * @return the range of matching message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public List<MBDiscussion> findByClassNameId(long classNameId, int start,
		int end) throws SystemException {
		return findByClassNameId(classNameId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the message boards discussions where classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param start the lower bound of the range of message boards discussions to return
	 * @param end the upper bound of the range of message boards discussions to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public List<MBDiscussion> findByClassNameId(long classNameId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				classNameId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<MBDiscussion> list = (List<MBDiscussion>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CLASSNAMEID,
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

			query.append(_SQL_SELECT_MBDISCUSSION_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSNAMEID_2);

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

				qPos.add(classNameId);

				list = (List<MBDiscussion>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CLASSNAMEID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CLASSNAMEID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first message boards discussion in the ordered set where classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching message boards discussion
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion findByClassNameId_First(long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchDiscussionException, SystemException {
		List<MBDiscussion> list = findByClassNameId(classNameId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDiscussionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last message boards discussion in the ordered set where classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching message boards discussion
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion findByClassNameId_Last(long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchDiscussionException, SystemException {
		int count = countByClassNameId(classNameId);

		List<MBDiscussion> list = findByClassNameId(classNameId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDiscussionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the message boards discussions before and after the current message boards discussion in the ordered set where classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param discussionId the primary key of the current message boards discussion
	 * @param classNameId the class name id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next message boards discussion
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a message boards discussion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion[] findByClassNameId_PrevAndNext(long discussionId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchDiscussionException, SystemException {
		MBDiscussion mbDiscussion = findByPrimaryKey(discussionId);

		Session session = null;

		try {
			session = openSession();

			MBDiscussion[] array = new MBDiscussionImpl[3];

			array[0] = getByClassNameId_PrevAndNext(session, mbDiscussion,
					classNameId, orderByComparator, true);

			array[1] = mbDiscussion;

			array[2] = getByClassNameId_PrevAndNext(session, mbDiscussion,
					classNameId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MBDiscussion getByClassNameId_PrevAndNext(Session session,
		MBDiscussion mbDiscussion, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MBDISCUSSION_WHERE);

		query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSNAMEID_2);

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

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(mbDiscussion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MBDiscussion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the message boards discussion where threadId = &#63; or throws a {@link com.liferay.portlet.messageboards.NoSuchDiscussionException} if it could not be found.
	 *
	 * @param threadId the thread id to search with
	 * @return the matching message boards discussion
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion findByThreadId(long threadId)
		throws NoSuchDiscussionException, SystemException {
		MBDiscussion mbDiscussion = fetchByThreadId(threadId);

		if (mbDiscussion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("threadId=");
			msg.append(threadId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDiscussionException(msg.toString());
		}

		return mbDiscussion;
	}

	/**
	 * Finds the message boards discussion where threadId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param threadId the thread id to search with
	 * @return the matching message boards discussion, or <code>null</code> if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion fetchByThreadId(long threadId)
		throws SystemException {
		return fetchByThreadId(threadId, true);
	}

	/**
	 * Finds the message boards discussion where threadId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param threadId the thread id to search with
	 * @return the matching message boards discussion, or <code>null</code> if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion fetchByThreadId(long threadId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { threadId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_THREADID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_MBDISCUSSION_WHERE);

			query.append(_FINDER_COLUMN_THREADID_THREADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

				List<MBDiscussion> list = q.list();

				result = list;

				MBDiscussion mbDiscussion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
						finderArgs, list);
				}
				else {
					mbDiscussion = list.get(0);

					cacheResult(mbDiscussion);

					if ((mbDiscussion.getThreadId() != threadId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
							finderArgs, mbDiscussion);
					}
				}

				return mbDiscussion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THREADID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (MBDiscussion)result;
			}
		}
	}

	/**
	 * Finds the message boards discussion where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portlet.messageboards.NoSuchDiscussionException} if it could not be found.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the matching message boards discussion
	 * @throws com.liferay.portlet.messageboards.NoSuchDiscussionException if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion findByC_C(long classNameId, long classPK)
		throws NoSuchDiscussionException, SystemException {
		MBDiscussion mbDiscussion = fetchByC_C(classNameId, classPK);

		if (mbDiscussion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDiscussionException(msg.toString());
		}

		return mbDiscussion;
	}

	/**
	 * Finds the message boards discussion where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the matching message boards discussion, or <code>null</code> if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion fetchByC_C(long classNameId, long classPK)
		throws SystemException {
		return fetchByC_C(classNameId, classPK, true);
	}

	/**
	 * Finds the message boards discussion where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the matching message boards discussion, or <code>null</code> if a matching message boards discussion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MBDiscussion fetchByC_C(long classNameId, long classPK,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MBDISCUSSION_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<MBDiscussion> list = q.list();

				result = list;

				MBDiscussion mbDiscussion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
						finderArgs, list);
				}
				else {
					mbDiscussion = list.get(0);

					cacheResult(mbDiscussion);

					if ((mbDiscussion.getClassNameId() != classNameId) ||
							(mbDiscussion.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
							finderArgs, mbDiscussion);
					}
				}

				return mbDiscussion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (MBDiscussion)result;
			}
		}
	}

	/**
	 * Finds all the message boards discussions.
	 *
	 * @return the message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public List<MBDiscussion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the message boards discussions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards discussions to return
	 * @param end the upper bound of the range of message boards discussions to return (not inclusive)
	 * @return the range of message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public List<MBDiscussion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the message boards discussions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards discussions to return
	 * @param end the upper bound of the range of message boards discussions to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public List<MBDiscussion> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<MBDiscussion> list = (List<MBDiscussion>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MBDISCUSSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MBDISCUSSION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MBDiscussion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MBDiscussion>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the message boards discussions where classNameId = &#63; from the database.
	 *
	 * @param classNameId the class name id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByClassNameId(long classNameId) throws SystemException {
		for (MBDiscussion mbDiscussion : findByClassNameId(classNameId)) {
			remove(mbDiscussion);
		}
	}

	/**
	 * Removes the message boards discussion where threadId = &#63; from the database.
	 *
	 * @param threadId the thread id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThreadId(long threadId)
		throws NoSuchDiscussionException, SystemException {
		MBDiscussion mbDiscussion = findByThreadId(threadId);

		remove(mbDiscussion);
	}

	/**
	 * Removes the message boards discussion where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_C(long classNameId, long classPK)
		throws NoSuchDiscussionException, SystemException {
		MBDiscussion mbDiscussion = findByC_C(classNameId, classPK);

		remove(mbDiscussion);
	}

	/**
	 * Removes all the message boards discussions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MBDiscussion mbDiscussion : findAll()) {
			remove(mbDiscussion);
		}
	}

	/**
	 * Counts all the message boards discussions where classNameId = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @return the number of matching message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByClassNameId(long classNameId) throws SystemException {
		Object[] finderArgs = new Object[] { classNameId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CLASSNAMEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MBDISCUSSION_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the message boards discussions where threadId = &#63;.
	 *
	 * @param threadId the thread id to search with
	 * @return the number of matching message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThreadId(long threadId) throws SystemException {
		Object[] finderArgs = new Object[] { threadId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREADID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MBDISCUSSION_WHERE);

			query.append(_FINDER_COLUMN_THREADID_THREADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREADID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the message boards discussions where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the number of matching message boards discussions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_C(long classNameId, long classPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MBDISCUSSION_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the message boards discussions.
	 *
	 * @return the number of message boards discussions
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

				Query q = session.createQuery(_SQL_COUNT_MBDISCUSSION);

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
	 * Initializes the message boards discussion persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.messageboards.model.MBDiscussion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MBDiscussion>> listenersList = new ArrayList<ModelListener<MBDiscussion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MBDiscussion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MBDiscussionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = MBBanPersistence.class)
	protected MBBanPersistence mbBanPersistence;
	@BeanReference(type = MBCategoryPersistence.class)
	protected MBCategoryPersistence mbCategoryPersistence;
	@BeanReference(type = MBDiscussionPersistence.class)
	protected MBDiscussionPersistence mbDiscussionPersistence;
	@BeanReference(type = MBMailingListPersistence.class)
	protected MBMailingListPersistence mbMailingListPersistence;
	@BeanReference(type = MBMessagePersistence.class)
	protected MBMessagePersistence mbMessagePersistence;
	@BeanReference(type = MBMessageFlagPersistence.class)
	protected MBMessageFlagPersistence mbMessageFlagPersistence;
	@BeanReference(type = MBStatsUserPersistence.class)
	protected MBStatsUserPersistence mbStatsUserPersistence;
	@BeanReference(type = MBThreadPersistence.class)
	protected MBThreadPersistence mbThreadPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MBDISCUSSION = "SELECT mbDiscussion FROM MBDiscussion mbDiscussion";
	private static final String _SQL_SELECT_MBDISCUSSION_WHERE = "SELECT mbDiscussion FROM MBDiscussion mbDiscussion WHERE ";
	private static final String _SQL_COUNT_MBDISCUSSION = "SELECT COUNT(mbDiscussion) FROM MBDiscussion mbDiscussion";
	private static final String _SQL_COUNT_MBDISCUSSION_WHERE = "SELECT COUNT(mbDiscussion) FROM MBDiscussion mbDiscussion WHERE ";
	private static final String _FINDER_COLUMN_CLASSNAMEID_CLASSNAMEID_2 = "mbDiscussion.classNameId = ?";
	private static final String _FINDER_COLUMN_THREADID_THREADID_2 = "mbDiscussion.threadId = ?";
	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "mbDiscussion.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 = "mbDiscussion.classPK = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mbDiscussion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MBDiscussion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MBDiscussion exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(MBDiscussionPersistenceImpl.class);
}