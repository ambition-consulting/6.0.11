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

package com.liferay.portlet.wiki.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.SubscriptionPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.wiki.NoSuchNodeException;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.impl.WikiNodeImpl;
import com.liferay.portlet.wiki.model.impl.WikiNodeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the wiki node service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiNodePersistence
 * @see WikiNodeUtil
 * @generated
 */
public class WikiNodePersistenceImpl extends BasePersistenceImpl<WikiNode>
	implements WikiNodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WikiNodeUtil} to access the wiki node persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WikiNodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_N = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_N",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_G_N = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_N",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the wiki node in the entity cache if it is enabled.
	 *
	 * @param wikiNode the wiki node to cache
	 */
	public void cacheResult(WikiNode wikiNode) {
		EntityCacheUtil.putResult(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeImpl.class, wikiNode.getPrimaryKey(), wikiNode);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { wikiNode.getUuid(), new Long(wikiNode.getGroupId()) },
			wikiNode);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_N,
			new Object[] { new Long(wikiNode.getGroupId()), wikiNode.getName() },
			wikiNode);
	}

	/**
	 * Caches the wiki nodes in the entity cache if it is enabled.
	 *
	 * @param wikiNodes the wiki nodes to cache
	 */
	public void cacheResult(List<WikiNode> wikiNodes) {
		for (WikiNode wikiNode : wikiNodes) {
			if (EntityCacheUtil.getResult(
						WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
						WikiNodeImpl.class, wikiNode.getPrimaryKey(), this) == null) {
				cacheResult(wikiNode);
			}
		}
	}

	/**
	 * Clears the cache for all wiki nodes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(WikiNodeImpl.class.getName());
		EntityCacheUtil.clearCache(WikiNodeImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the wiki node.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(WikiNode wikiNode) {
		EntityCacheUtil.removeResult(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeImpl.class, wikiNode.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { wikiNode.getUuid(), new Long(wikiNode.getGroupId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_N,
			new Object[] { new Long(wikiNode.getGroupId()), wikiNode.getName() });
	}

	/**
	 * Creates a new wiki node with the primary key. Does not add the wiki node to the database.
	 *
	 * @param nodeId the primary key for the new wiki node
	 * @return the new wiki node
	 */
	public WikiNode create(long nodeId) {
		WikiNode wikiNode = new WikiNodeImpl();

		wikiNode.setNew(true);
		wikiNode.setPrimaryKey(nodeId);

		String uuid = PortalUUIDUtil.generate();

		wikiNode.setUuid(uuid);

		return wikiNode;
	}

	/**
	 * Removes the wiki node with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wiki node to remove
	 * @return the wiki node that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the wiki node with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nodeId the primary key of the wiki node to remove
	 * @return the wiki node that was removed
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode remove(long nodeId)
		throws NoSuchNodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WikiNode wikiNode = (WikiNode)session.get(WikiNodeImpl.class,
					new Long(nodeId));

			if (wikiNode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + nodeId);
				}

				throw new NoSuchNodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					nodeId);
			}

			return remove(wikiNode);
		}
		catch (NoSuchNodeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WikiNode removeImpl(WikiNode wikiNode) throws SystemException {
		wikiNode = toUnwrappedModel(wikiNode);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wikiNode);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		WikiNodeModelImpl wikiNodeModelImpl = (WikiNodeModelImpl)wikiNode;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				wikiNodeModelImpl.getOriginalUuid(),
				new Long(wikiNodeModelImpl.getOriginalGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_N,
			new Object[] {
				new Long(wikiNodeModelImpl.getOriginalGroupId()),
				
			wikiNodeModelImpl.getOriginalName()
			});

		EntityCacheUtil.removeResult(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeImpl.class, wikiNode.getPrimaryKey());

		return wikiNode;
	}

	public WikiNode updateImpl(
		com.liferay.portlet.wiki.model.WikiNode wikiNode, boolean merge)
		throws SystemException {
		wikiNode = toUnwrappedModel(wikiNode);

		boolean isNew = wikiNode.isNew();

		WikiNodeModelImpl wikiNodeModelImpl = (WikiNodeModelImpl)wikiNode;

		if (Validator.isNull(wikiNode.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			wikiNode.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wikiNode, merge);

			wikiNode.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
			WikiNodeImpl.class, wikiNode.getPrimaryKey(), wikiNode);

		if (!isNew &&
				(!Validator.equals(wikiNode.getUuid(),
					wikiNodeModelImpl.getOriginalUuid()) ||
				(wikiNode.getGroupId() != wikiNodeModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					wikiNodeModelImpl.getOriginalUuid(),
					new Long(wikiNodeModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(wikiNode.getUuid(),
					wikiNodeModelImpl.getOriginalUuid()) ||
				(wikiNode.getGroupId() != wikiNodeModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { wikiNode.getUuid(), new Long(
						wikiNode.getGroupId()) }, wikiNode);
		}

		if (!isNew &&
				((wikiNode.getGroupId() != wikiNodeModelImpl.getOriginalGroupId()) ||
				!Validator.equals(wikiNode.getName(),
					wikiNodeModelImpl.getOriginalName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_N,
				new Object[] {
					new Long(wikiNodeModelImpl.getOriginalGroupId()),
					
				wikiNodeModelImpl.getOriginalName()
				});
		}

		if (isNew ||
				((wikiNode.getGroupId() != wikiNodeModelImpl.getOriginalGroupId()) ||
				!Validator.equals(wikiNode.getName(),
					wikiNodeModelImpl.getOriginalName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_N,
				new Object[] { new Long(wikiNode.getGroupId()), wikiNode.getName() },
				wikiNode);
		}

		return wikiNode;
	}

	protected WikiNode toUnwrappedModel(WikiNode wikiNode) {
		if (wikiNode instanceof WikiNodeImpl) {
			return wikiNode;
		}

		WikiNodeImpl wikiNodeImpl = new WikiNodeImpl();

		wikiNodeImpl.setNew(wikiNode.isNew());
		wikiNodeImpl.setPrimaryKey(wikiNode.getPrimaryKey());

		wikiNodeImpl.setUuid(wikiNode.getUuid());
		wikiNodeImpl.setNodeId(wikiNode.getNodeId());
		wikiNodeImpl.setGroupId(wikiNode.getGroupId());
		wikiNodeImpl.setCompanyId(wikiNode.getCompanyId());
		wikiNodeImpl.setUserId(wikiNode.getUserId());
		wikiNodeImpl.setUserName(wikiNode.getUserName());
		wikiNodeImpl.setCreateDate(wikiNode.getCreateDate());
		wikiNodeImpl.setModifiedDate(wikiNode.getModifiedDate());
		wikiNodeImpl.setName(wikiNode.getName());
		wikiNodeImpl.setDescription(wikiNode.getDescription());
		wikiNodeImpl.setLastPostDate(wikiNode.getLastPostDate());

		return wikiNodeImpl;
	}

	/**
	 * Finds the wiki node with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wiki node to find
	 * @return the wiki node
	 * @throws com.liferay.portal.NoSuchModelException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the wiki node with the primary key or throws a {@link com.liferay.portlet.wiki.NoSuchNodeException} if it could not be found.
	 *
	 * @param nodeId the primary key of the wiki node to find
	 * @return the wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByPrimaryKey(long nodeId)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = fetchByPrimaryKey(nodeId);

		if (wikiNode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + nodeId);
			}

			throw new NoSuchNodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				nodeId);
		}

		return wikiNode;
	}

	/**
	 * Finds the wiki node with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wiki node to find
	 * @return the wiki node, or <code>null</code> if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the wiki node with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nodeId the primary key of the wiki node to find
	 * @return the wiki node, or <code>null</code> if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode fetchByPrimaryKey(long nodeId) throws SystemException {
		WikiNode wikiNode = (WikiNode)EntityCacheUtil.getResult(WikiNodeModelImpl.ENTITY_CACHE_ENABLED,
				WikiNodeImpl.class, nodeId, this);

		if (wikiNode == null) {
			Session session = null;

			try {
				session = openSession();

				wikiNode = (WikiNode)session.get(WikiNodeImpl.class,
						new Long(nodeId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (wikiNode != null) {
					cacheResult(wikiNode);
				}

				closeSession(session);
			}
		}

		return wikiNode;
	}

	/**
	 * Finds all the wiki nodes where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the wiki nodes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @return the range of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the wiki nodes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<WikiNode> list = (List<WikiNode>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WIKINODE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<WikiNode>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first wiki node in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		List<WikiNode> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNodeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last wiki node in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		int count = countByUuid(uuid);

		List<WikiNode> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNodeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the wiki nodes before and after the current wiki node in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nodeId the primary key of the current wiki node
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode[] findByUuid_PrevAndNext(long nodeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = findByPrimaryKey(nodeId);

		Session session = null;

		try {
			session = openSession();

			WikiNode[] array = new WikiNodeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, wikiNode, uuid,
					orderByComparator, true);

			array[1] = wikiNode;

			array[2] = getByUuid_PrevAndNext(session, wikiNode, uuid,
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

	protected WikiNode getByUuid_PrevAndNext(Session session,
		WikiNode wikiNode, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WIKINODE_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
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

		else {
			query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(wikiNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WikiNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the wiki node where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.wiki.NoSuchNodeException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByUUID_G(String uuid, long groupId)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = fetchByUUID_G(uuid, groupId);

		if (wikiNode == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNodeException(msg.toString());
		}

		return wikiNode;
	}

	/**
	 * Finds the wiki node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching wiki node, or <code>null</code> if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the wiki node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching wiki node, or <code>null</code> if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WIKINODE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(WikiNodeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<WikiNode> list = q.list();

				result = list;

				WikiNode wikiNode = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					wikiNode = list.get(0);

					cacheResult(wikiNode);

					if ((wikiNode.getUuid() == null) ||
							!wikiNode.getUuid().equals(uuid) ||
							(wikiNode.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, wikiNode);
					}
				}

				return wikiNode;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
				return (WikiNode)result;
			}
		}
	}

	/**
	 * Finds all the wiki nodes where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the wiki nodes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @return the range of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the wiki nodes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<WikiNode> list = (List<WikiNode>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WIKINODE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<WikiNode>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first wiki node in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		List<WikiNode> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNodeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last wiki node in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		int count = countByGroupId(groupId);

		List<WikiNode> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNodeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the wiki nodes before and after the current wiki node in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nodeId the primary key of the current wiki node
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode[] findByGroupId_PrevAndNext(long nodeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = findByPrimaryKey(nodeId);

		Session session = null;

		try {
			session = openSession();

			WikiNode[] array = new WikiNodeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, wikiNode, groupId,
					orderByComparator, true);

			array[1] = wikiNode;

			array[2] = getByGroupId_PrevAndNext(session, wikiNode, groupId,
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

	protected WikiNode getByGroupId_PrevAndNext(Session session,
		WikiNode wikiNode, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WIKINODE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

		else {
			query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(wikiNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WikiNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the wiki nodes where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching wiki nodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the wiki nodes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @return the range of matching wiki nodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the wiki nodes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching wiki nodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WIKINODE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WIKINODE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WIKINODE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WikiNodeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WikiNode.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WikiNodeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WikiNodeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<WikiNode>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the wiki nodes where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the wiki nodes where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @return the range of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the wiki nodes where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<WikiNode> list = (List<WikiNode>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WIKINODE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<WikiNode>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Finds the first wiki node in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		List<WikiNode> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNodeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last wiki node in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		int count = countByCompanyId(companyId);

		List<WikiNode> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNodeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the wiki nodes before and after the current wiki node in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nodeId the primary key of the current wiki node
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a wiki node with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode[] findByCompanyId_PrevAndNext(long nodeId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = findByPrimaryKey(nodeId);

		Session session = null;

		try {
			session = openSession();

			WikiNode[] array = new WikiNodeImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, wikiNode, companyId,
					orderByComparator, true);

			array[1] = wikiNode;

			array[2] = getByCompanyId_PrevAndNext(session, wikiNode, companyId,
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

	protected WikiNode getByCompanyId_PrevAndNext(Session session,
		WikiNode wikiNode, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WIKINODE_WHERE);

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

		else {
			query.append(WikiNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(wikiNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WikiNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the wiki node where groupId = &#63; and name = &#63; or throws a {@link com.liferay.portlet.wiki.NoSuchNodeException} if it could not be found.
	 *
	 * @param groupId the group id to search with
	 * @param name the name to search with
	 * @return the matching wiki node
	 * @throws com.liferay.portlet.wiki.NoSuchNodeException if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode findByG_N(long groupId, String name)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = fetchByG_N(groupId, name);

		if (wikiNode == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNodeException(msg.toString());
		}

		return wikiNode;
	}

	/**
	 * Finds the wiki node where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param name the name to search with
	 * @return the matching wiki node, or <code>null</code> if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode fetchByG_N(long groupId, String name)
		throws SystemException {
		return fetchByG_N(groupId, name, true);
	}

	/**
	 * Finds the wiki node where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param name the name to search with
	 * @return the matching wiki node, or <code>null</code> if a matching wiki node could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiNode fetchByG_N(long groupId, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_N,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WIKINODE_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			if (name == null) {
				query.append(_FINDER_COLUMN_G_N_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_NAME_2);
				}
			}

			query.append(WikiNodeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (name != null) {
					qPos.add(name);
				}

				List<WikiNode> list = q.list();

				result = list;

				WikiNode wikiNode = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_N,
						finderArgs, list);
				}
				else {
					wikiNode = list.get(0);

					cacheResult(wikiNode);

					if ((wikiNode.getGroupId() != groupId) ||
							(wikiNode.getName() == null) ||
							!wikiNode.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_N,
							finderArgs, wikiNode);
					}
				}

				return wikiNode;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_N,
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
				return (WikiNode)result;
			}
		}
	}

	/**
	 * Finds all the wiki nodes.
	 *
	 * @return the wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the wiki nodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @return the range of wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the wiki nodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of wiki nodes to return
	 * @param end the upper bound of the range of wiki nodes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiNode> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<WikiNode> list = (List<WikiNode>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WIKINODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WIKINODE.concat(WikiNodeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WikiNode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WikiNode>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the wiki nodes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (WikiNode wikiNode : findByUuid(uuid)) {
			remove(wikiNode);
		}
	}

	/**
	 * Removes the wiki node where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = findByUUID_G(uuid, groupId);

		remove(wikiNode);
	}

	/**
	 * Removes all the wiki nodes where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (WikiNode wikiNode : findByGroupId(groupId)) {
			remove(wikiNode);
		}
	}

	/**
	 * Removes all the wiki nodes where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (WikiNode wikiNode : findByCompanyId(companyId)) {
			remove(wikiNode);
		}
	}

	/**
	 * Removes the wiki node where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param name the name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_N(long groupId, String name)
		throws NoSuchNodeException, SystemException {
		WikiNode wikiNode = findByG_N(groupId, name);

		remove(wikiNode);
	}

	/**
	 * Removes all the wiki nodes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WikiNode wikiNode : findAll()) {
			remove(wikiNode);
		}
	}

	/**
	 * Counts all the wiki nodes where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WIKINODE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the wiki nodes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WIKINODE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the wiki nodes where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WIKINODE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the wiki nodes where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching wiki nodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_WIKINODE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WikiNode.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the wiki nodes where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WIKINODE_WHERE);

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
	 * Counts all the wiki nodes where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param name the name to search with
	 * @return the number of matching wiki nodes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_N(long groupId, String name) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_N,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WIKINODE_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			if (name == null) {
				query.append(_FINDER_COLUMN_G_N_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (name != null) {
					qPos.add(name);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_N, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the wiki nodes.
	 *
	 * @return the number of wiki nodes
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

				Query q = session.createQuery(_SQL_COUNT_WIKINODE);

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
	 * Initializes the wiki node persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.wiki.model.WikiNode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WikiNode>> listenersList = new ArrayList<ModelListener<WikiNode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WikiNode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WikiNodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = WikiNodePersistence.class)
	protected WikiNodePersistence wikiNodePersistence;
	@BeanReference(type = WikiPagePersistence.class)
	protected WikiPagePersistence wikiPagePersistence;
	@BeanReference(type = WikiPageResourcePersistence.class)
	protected WikiPageResourcePersistence wikiPageResourcePersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WIKINODE = "SELECT wikiNode FROM WikiNode wikiNode";
	private static final String _SQL_SELECT_WIKINODE_WHERE = "SELECT wikiNode FROM WikiNode wikiNode WHERE ";
	private static final String _SQL_COUNT_WIKINODE = "SELECT COUNT(wikiNode) FROM WikiNode wikiNode";
	private static final String _SQL_COUNT_WIKINODE_WHERE = "SELECT COUNT(wikiNode) FROM WikiNode wikiNode WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "wikiNode.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "wikiNode.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(wikiNode.uuid IS NULL OR wikiNode.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "wikiNode.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "wikiNode.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(wikiNode.uuid IS NULL OR wikiNode.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "wikiNode.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "wikiNode.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "wikiNode.companyId = ?";
	private static final String _FINDER_COLUMN_G_N_GROUPID_2 = "wikiNode.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_N_NAME_1 = "wikiNode.name IS NULL";
	private static final String _FINDER_COLUMN_G_N_NAME_2 = "wikiNode.name = ?";
	private static final String _FINDER_COLUMN_G_N_NAME_3 = "(wikiNode.name IS NULL OR wikiNode.name = ?)";
	private static final String _FILTER_SQL_SELECT_WIKINODE_WHERE = "SELECT DISTINCT {wikiNode.*} FROM WikiNode wikiNode WHERE ";
	private static final String _FILTER_SQL_SELECT_WIKINODE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {WikiNode.*} FROM (SELECT DISTINCT wikiNode.nodeId FROM WikiNode wikiNode WHERE ";
	private static final String _FILTER_SQL_SELECT_WIKINODE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN WikiNode ON TEMP_TABLE.nodeId = WikiNode.nodeId";
	private static final String _FILTER_SQL_COUNT_WIKINODE_WHERE = "SELECT COUNT(DISTINCT wikiNode.nodeId) AS COUNT_VALUE FROM WikiNode wikiNode WHERE ";
	private static final String _FILTER_COLUMN_PK = "wikiNode.nodeId";
	private static final String _FILTER_COLUMN_USERID = "wikiNode.userId";
	private static final String _FILTER_ENTITY_ALIAS = "wikiNode";
	private static final String _FILTER_ENTITY_TABLE = "WikiNode";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wikiNode.";
	private static final String _ORDER_BY_ENTITY_TABLE = "WikiNode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WikiNode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WikiNode exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(WikiNodePersistenceImpl.class);
}