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

package com.liferay.portlet.softwarecatalog.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.softwarecatalog.NoSuchLicenseException;
import com.liferay.portlet.softwarecatalog.model.SCLicense;
import com.liferay.portlet.softwarecatalog.model.impl.SCLicenseImpl;
import com.liferay.portlet.softwarecatalog.model.impl.SCLicenseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s c license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCLicensePersistence
 * @see SCLicenseUtil
 * @generated
 */
public class SCLicensePersistenceImpl extends BasePersistenceImpl<SCLicense>
	implements SCLicensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SCLicenseUtil} to access the s c license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SCLicenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByActive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByActive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_A_R = new FinderPath(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByA_R",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_A_R = new FinderPath(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByA_R",
			new String[] { Boolean.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the s c license in the entity cache if it is enabled.
	 *
	 * @param scLicense the s c license to cache
	 */
	public void cacheResult(SCLicense scLicense) {
		EntityCacheUtil.putResult(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseImpl.class, scLicense.getPrimaryKey(), scLicense);
	}

	/**
	 * Caches the s c licenses in the entity cache if it is enabled.
	 *
	 * @param scLicenses the s c licenses to cache
	 */
	public void cacheResult(List<SCLicense> scLicenses) {
		for (SCLicense scLicense : scLicenses) {
			if (EntityCacheUtil.getResult(
						SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
						SCLicenseImpl.class, scLicense.getPrimaryKey(), this) == null) {
				cacheResult(scLicense);
			}
		}
	}

	/**
	 * Clears the cache for all s c licenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SCLicenseImpl.class.getName());
		EntityCacheUtil.clearCache(SCLicenseImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the s c license.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(SCLicense scLicense) {
		EntityCacheUtil.removeResult(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseImpl.class, scLicense.getPrimaryKey());
	}

	/**
	 * Creates a new s c license with the primary key. Does not add the s c license to the database.
	 *
	 * @param licenseId the primary key for the new s c license
	 * @return the new s c license
	 */
	public SCLicense create(long licenseId) {
		SCLicense scLicense = new SCLicenseImpl();

		scLicense.setNew(true);
		scLicense.setPrimaryKey(licenseId);

		return scLicense;
	}

	/**
	 * Removes the s c license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s c license to remove
	 * @return the s c license that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the s c license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the s c license to remove
	 * @return the s c license that was removed
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense remove(long licenseId)
		throws NoSuchLicenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SCLicense scLicense = (SCLicense)session.get(SCLicenseImpl.class,
					new Long(licenseId));

			if (scLicense == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + licenseId);
				}

				throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					licenseId);
			}

			return remove(scLicense);
		}
		catch (NoSuchLicenseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SCLicense removeImpl(SCLicense scLicense)
		throws SystemException {
		scLicense = toUnwrappedModel(scLicense);

		try {
			clearSCProductEntries.clear(scLicense.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, scLicense);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseImpl.class, scLicense.getPrimaryKey());

		return scLicense;
	}

	public SCLicense updateImpl(
		com.liferay.portlet.softwarecatalog.model.SCLicense scLicense,
		boolean merge) throws SystemException {
		scLicense = toUnwrappedModel(scLicense);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, scLicense, merge);

			scLicense.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseImpl.class, scLicense.getPrimaryKey(), scLicense);

		return scLicense;
	}

	protected SCLicense toUnwrappedModel(SCLicense scLicense) {
		if (scLicense instanceof SCLicenseImpl) {
			return scLicense;
		}

		SCLicenseImpl scLicenseImpl = new SCLicenseImpl();

		scLicenseImpl.setNew(scLicense.isNew());
		scLicenseImpl.setPrimaryKey(scLicense.getPrimaryKey());

		scLicenseImpl.setLicenseId(scLicense.getLicenseId());
		scLicenseImpl.setName(scLicense.getName());
		scLicenseImpl.setUrl(scLicense.getUrl());
		scLicenseImpl.setOpenSource(scLicense.isOpenSource());
		scLicenseImpl.setActive(scLicense.isActive());
		scLicenseImpl.setRecommended(scLicense.isRecommended());

		return scLicenseImpl;
	}

	/**
	 * Finds the s c license with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s c license to find
	 * @return the s c license
	 * @throws com.liferay.portal.NoSuchModelException if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the s c license with the primary key or throws a {@link com.liferay.portlet.softwarecatalog.NoSuchLicenseException} if it could not be found.
	 *
	 * @param licenseId the primary key of the s c license to find
	 * @return the s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense findByPrimaryKey(long licenseId)
		throws NoSuchLicenseException, SystemException {
		SCLicense scLicense = fetchByPrimaryKey(licenseId);

		if (scLicense == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + licenseId);
			}

			throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				licenseId);
		}

		return scLicense;
	}

	/**
	 * Finds the s c license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s c license to find
	 * @return the s c license, or <code>null</code> if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the s c license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the s c license to find
	 * @return the s c license, or <code>null</code> if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense fetchByPrimaryKey(long licenseId)
		throws SystemException {
		SCLicense scLicense = (SCLicense)EntityCacheUtil.getResult(SCLicenseModelImpl.ENTITY_CACHE_ENABLED,
				SCLicenseImpl.class, licenseId, this);

		if (scLicense == null) {
			Session session = null;

			try {
				session = openSession();

				scLicense = (SCLicense)session.get(SCLicenseImpl.class,
						new Long(licenseId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (scLicense != null) {
					cacheResult(scLicense);
				}

				closeSession(session);
			}
		}

		return scLicense;
	}

	/**
	 * Finds all the s c licenses where active = &#63;.
	 *
	 * @param active the active to search with
	 * @return the matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findByActive(boolean active)
		throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the s c licenses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @return the range of matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

	/**
	 * Finds an ordered range of all the s c licenses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findByActive(boolean active, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				active,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SCLicense> list = (List<SCLicense>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
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

			query.append(_SQL_SELECT_SCLICENSE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SCLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				list = (List<SCLicense>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_ACTIVE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first s c license in the ordered set where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a matching s c license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		List<SCLicense> list = findByActive(active, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLicenseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last s c license in the ordered set where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a matching s c license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		int count = countByActive(active);

		List<SCLicense> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLicenseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the s c licenses before and after the current s c license in the ordered set where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param licenseId the primary key of the current s c license
	 * @param active the active to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense[] findByActive_PrevAndNext(long licenseId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		SCLicense scLicense = findByPrimaryKey(licenseId);

		Session session = null;

		try {
			session = openSession();

			SCLicense[] array = new SCLicenseImpl[3];

			array[0] = getByActive_PrevAndNext(session, scLicense, active,
					orderByComparator, true);

			array[1] = scLicense;

			array[2] = getByActive_PrevAndNext(session, scLicense, active,
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

	protected SCLicense getByActive_PrevAndNext(Session session,
		SCLicense scLicense, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCLICENSE_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			query.append(SCLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(scLicense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SCLicense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the s c licenses where active = &#63;.
	 *
	 * @param active the active to search with
	 * @return the matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> filterFindByActive(boolean active)
		throws SystemException {
		return filterFindByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the s c licenses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @return the range of matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> filterFindByActive(boolean active, int start, int end)
		throws SystemException {
		return filterFindByActive(active, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the s c licenses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> filterFindByActive(boolean active, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByActive(active, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_SCLICENSE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SCLICENSE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SCLICENSE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(SCLicenseModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SCLicenseModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SCLicense.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SCLicenseImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SCLicenseImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			return (List<SCLicense>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @return the matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findByA_R(boolean active, boolean recommended)
		throws SystemException {
		return findByA_R(active, recommended, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @return the range of matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findByA_R(boolean active, boolean recommended,
		int start, int end) throws SystemException {
		return findByA_R(active, recommended, start, end, null);
	}

	/**
	 * Finds an ordered range of all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findByA_R(boolean active, boolean recommended,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				active, recommended,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SCLicense> list = (List<SCLicense>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_A_R,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SCLICENSE_WHERE);

			query.append(_FINDER_COLUMN_A_R_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_R_RECOMMENDED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SCLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(recommended);

				list = (List<SCLicense>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_A_R,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_A_R,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first s c license in the ordered set where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a matching s c license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense findByA_R_First(boolean active, boolean recommended,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		List<SCLicense> list = findByA_R(active, recommended, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(", recommended=");
			msg.append(recommended);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLicenseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last s c license in the ordered set where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a matching s c license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense findByA_R_Last(boolean active, boolean recommended,
		OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		int count = countByA_R(active, recommended);

		List<SCLicense> list = findByA_R(active, recommended, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(", recommended=");
			msg.append(recommended);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLicenseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the s c licenses before and after the current s c license in the ordered set where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param licenseId the primary key of the current s c license
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next s c license
	 * @throws com.liferay.portlet.softwarecatalog.NoSuchLicenseException if a s c license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SCLicense[] findByA_R_PrevAndNext(long licenseId, boolean active,
		boolean recommended, OrderByComparator orderByComparator)
		throws NoSuchLicenseException, SystemException {
		SCLicense scLicense = findByPrimaryKey(licenseId);

		Session session = null;

		try {
			session = openSession();

			SCLicense[] array = new SCLicenseImpl[3];

			array[0] = getByA_R_PrevAndNext(session, scLicense, active,
					recommended, orderByComparator, true);

			array[1] = scLicense;

			array[2] = getByA_R_PrevAndNext(session, scLicense, active,
					recommended, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SCLicense getByA_R_PrevAndNext(Session session,
		SCLicense scLicense, boolean active, boolean recommended,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCLICENSE_WHERE);

		query.append(_FINDER_COLUMN_A_R_ACTIVE_2);

		query.append(_FINDER_COLUMN_A_R_RECOMMENDED_2);

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
			query.append(SCLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(recommended);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(scLicense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SCLicense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @return the matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> filterFindByA_R(boolean active, boolean recommended)
		throws SystemException {
		return filterFindByA_R(active, recommended, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @return the range of matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> filterFindByA_R(boolean active, boolean recommended,
		int start, int end) throws SystemException {
		return filterFindByA_R(active, recommended, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> filterFindByA_R(boolean active, boolean recommended,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByA_R(active, recommended, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SCLICENSE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SCLICENSE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_A_R_ACTIVE_2);

		query.append(_FINDER_COLUMN_A_R_RECOMMENDED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SCLICENSE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(SCLicenseModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SCLicenseModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SCLicense.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SCLicenseImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SCLicenseImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			qPos.add(recommended);

			return (List<SCLicense>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the s c licenses.
	 *
	 * @return the s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the s c licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @return the range of s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the s c licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public List<SCLicense> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SCLicense> list = (List<SCLicense>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCLICENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCLICENSE.concat(SCLicenseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SCLicense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SCLicense>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s c licenses where active = &#63; from the database.
	 *
	 * @param active the active to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByActive(boolean active) throws SystemException {
		for (SCLicense scLicense : findByActive(active)) {
			remove(scLicense);
		}
	}

	/**
	 * Removes all the s c licenses where active = &#63; and recommended = &#63; from the database.
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByA_R(boolean active, boolean recommended)
		throws SystemException {
		for (SCLicense scLicense : findByA_R(active, recommended)) {
			remove(scLicense);
		}
	}

	/**
	 * Removes all the s c licenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SCLicense scLicense : findAll()) {
			remove(scLicense);
		}
	}

	/**
	 * Counts all the s c licenses where active = &#63;.
	 *
	 * @param active the active to search with
	 * @return the number of matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByActive(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCLICENSE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the s c licenses where active = &#63;.
	 *
	 * @param active the active to search with
	 * @return the number of matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByActive(boolean active) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByActive(active);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_SCLICENSE_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SCLicense.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

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
	 * Counts all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @return the number of matching s c licenses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByA_R(boolean active, boolean recommended)
		throws SystemException {
		Object[] finderArgs = new Object[] { active, recommended };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A_R,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCLICENSE_WHERE);

			query.append(_FINDER_COLUMN_A_R_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_R_RECOMMENDED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(recommended);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the s c licenses where active = &#63; and recommended = &#63;.
	 *
	 * @param active the active to search with
	 * @param recommended the recommended to search with
	 * @return the number of matching s c licenses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByA_R(boolean active, boolean recommended)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByA_R(active, recommended);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_SCLICENSE_WHERE);

		query.append(_FINDER_COLUMN_A_R_ACTIVE_2);

		query.append(_FINDER_COLUMN_A_R_RECOMMENDED_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SCLicense.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			qPos.add(recommended);

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
	 * Counts all the s c licenses.
	 *
	 * @return the number of s c licenses
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

				Query q = session.createQuery(_SQL_COUNT_SCLICENSE);

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
	 * Gets all the s c product entries associated with the s c license.
	 *
	 * @param pk the primary key of the s c license to get the associated s c product entries for
	 * @return the s c product entries associated with the s c license
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> getSCProductEntries(
		long pk) throws SystemException {
		return getSCProductEntries(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Gets a range of all the s c product entries associated with the s c license.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the s c license to get the associated s c product entries for
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @return the range of s c product entries associated with the s c license
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> getSCProductEntries(
		long pk, int start, int end) throws SystemException {
		return getSCProductEntries(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_SCPRODUCTENTRIES = new FinderPath(com.liferay.portlet.softwarecatalog.model.impl.SCProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED_SCLICENSES_SCPRODUCTENTRIES,
			SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME,
			"getSCProductEntries",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Gets an ordered range of all the s c product entries associated with the s c license.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the s c license to get the associated s c product entries for
	 * @param start the lower bound of the range of s c licenses to return
	 * @param end the upper bound of the range of s c licenses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of s c product entries associated with the s c license
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> getSCProductEntries(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> list = (List<com.liferay.portlet.softwarecatalog.model.SCProductEntry>)FinderCacheUtil.getResult(FINDER_PATH_GET_SCPRODUCTENTRIES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETSCPRODUCTENTRIES.concat(ORDER_BY_CLAUSE)
												  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETSCPRODUCTENTRIES.concat(com.liferay.portlet.softwarecatalog.model.impl.SCProductEntryModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("SCProductEntry",
					com.liferay.portlet.softwarecatalog.model.impl.SCProductEntryImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.liferay.portlet.softwarecatalog.model.SCProductEntry>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_SCPRODUCTENTRIES,
						finderArgs);
				}
				else {
					scProductEntryPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_SCPRODUCTENTRIES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_SCPRODUCTENTRIES_SIZE = new FinderPath(com.liferay.portlet.softwarecatalog.model.impl.SCProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED_SCLICENSES_SCPRODUCTENTRIES,
			SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME,
			"getSCProductEntriesSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of s c product entries associated with the s c license.
	 *
	 * @param pk the primary key of the s c license to get the number of associated s c product entries for
	 * @return the number of s c product entries associated with the s c license
	 * @throws SystemException if a system exception occurred
	 */
	public int getSCProductEntriesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_SCPRODUCTENTRIES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETSCPRODUCTENTRIESSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_SCPRODUCTENTRIES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_SCPRODUCTENTRY = new FinderPath(com.liferay.portlet.softwarecatalog.model.impl.SCProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			SCLicenseModelImpl.FINDER_CACHE_ENABLED_SCLICENSES_SCPRODUCTENTRIES,
			SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME,
			"containsSCProductEntry",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the s c product entry is associated with the s c license.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntryPK the primary key of the s c product entry
	 * @return <code>true</code> if the s c product entry is associated with the s c license; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsSCProductEntry(long pk, long scProductEntryPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, scProductEntryPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_SCPRODUCTENTRY,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsSCProductEntry.contains(pk,
							scProductEntryPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_SCPRODUCTENTRY,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the s c license has any s c product entries associated with it.
	 *
	 * @param pk the primary key of the s c license to check for associations with s c product entries
	 * @return <code>true</code> if the s c license has any s c product entries associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsSCProductEntries(long pk) throws SystemException {
		if (getSCProductEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the s c license and the s c product entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntryPK the primary key of the s c product entry
	 * @throws SystemException if a system exception occurred
	 */
	public void addSCProductEntry(long pk, long scProductEntryPK)
		throws SystemException {
		try {
			addSCProductEntry.add(pk, scProductEntryPK);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Adds an association between the s c license and the s c product entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntry the s c product entry
	 * @throws SystemException if a system exception occurred
	 */
	public void addSCProductEntry(long pk,
		com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry)
		throws SystemException {
		try {
			addSCProductEntry.add(pk, scProductEntry.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Adds an association between the s c license and the s c product entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntryPKs the primary keys of the s c product entries
	 * @throws SystemException if a system exception occurred
	 */
	public void addSCProductEntries(long pk, long[] scProductEntryPKs)
		throws SystemException {
		try {
			for (long scProductEntryPK : scProductEntryPKs) {
				addSCProductEntry.add(pk, scProductEntryPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Adds an association between the s c license and the s c product entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntries the s c product entries
	 * @throws SystemException if a system exception occurred
	 */
	public void addSCProductEntries(long pk,
		List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> scProductEntries)
		throws SystemException {
		try {
			for (com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry : scProductEntries) {
				addSCProductEntry.add(pk, scProductEntry.getPrimaryKey());
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Clears all associations between the s c license and its s c product entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license to clear the associated s c product entries from
	 * @throws SystemException if a system exception occurred
	 */
	public void clearSCProductEntries(long pk) throws SystemException {
		try {
			clearSCProductEntries.clear(pk);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Removes the association between the s c license and the s c product entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntryPK the primary key of the s c product entry
	 * @throws SystemException if a system exception occurred
	 */
	public void removeSCProductEntry(long pk, long scProductEntryPK)
		throws SystemException {
		try {
			removeSCProductEntry.remove(pk, scProductEntryPK);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Removes the association between the s c license and the s c product entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntry the s c product entry
	 * @throws SystemException if a system exception occurred
	 */
	public void removeSCProductEntry(long pk,
		com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry)
		throws SystemException {
		try {
			removeSCProductEntry.remove(pk, scProductEntry.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Removes the association between the s c license and the s c product entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntryPKs the primary keys of the s c product entries
	 * @throws SystemException if a system exception occurred
	 */
	public void removeSCProductEntries(long pk, long[] scProductEntryPKs)
		throws SystemException {
		try {
			for (long scProductEntryPK : scProductEntryPKs) {
				removeSCProductEntry.remove(pk, scProductEntryPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Removes the association between the s c license and the s c product entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license
	 * @param scProductEntries the s c product entries
	 * @throws SystemException if a system exception occurred
	 */
	public void removeSCProductEntries(long pk,
		List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> scProductEntries)
		throws SystemException {
		try {
			for (com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry : scProductEntries) {
				removeSCProductEntry.remove(pk, scProductEntry.getPrimaryKey());
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Sets the s c product entries associated with the s c license, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license to set the associations for
	 * @param scProductEntryPKs the primary keys of the s c product entries to be associated with the s c license
	 * @throws SystemException if a system exception occurred
	 */
	public void setSCProductEntries(long pk, long[] scProductEntryPKs)
		throws SystemException {
		try {
			Set<Long> scProductEntryPKSet = SetUtil.fromArray(scProductEntryPKs);

			List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> scProductEntries =
				getSCProductEntries(pk);

			for (com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry : scProductEntries) {
				if (!scProductEntryPKSet.remove(scProductEntry.getPrimaryKey())) {
					removeSCProductEntry.remove(pk,
						scProductEntry.getPrimaryKey());
				}
			}

			for (Long scProductEntryPK : scProductEntryPKSet) {
				addSCProductEntry.add(pk, scProductEntryPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Sets the s c product entries associated with the s c license, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the s c license to set the associations for
	 * @param scProductEntries the s c product entries to be associated with the s c license
	 * @throws SystemException if a system exception occurred
	 */
	public void setSCProductEntries(long pk,
		List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> scProductEntries)
		throws SystemException {
		try {
			long[] scProductEntryPKs = new long[scProductEntries.size()];

			for (int i = 0; i < scProductEntries.size(); i++) {
				com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry =
					scProductEntries.get(i);

				scProductEntryPKs[i] = scProductEntry.getPrimaryKey();
			}

			setSCProductEntries(pk, scProductEntryPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SCLicenseModelImpl.MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME);
		}
	}

	/**
	 * Initializes the s c license persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.softwarecatalog.model.SCLicense")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SCLicense>> listenersList = new ArrayList<ModelListener<SCLicense>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SCLicense>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsSCProductEntry = new ContainsSCProductEntry(this);

		addSCProductEntry = new AddSCProductEntry(this);
		clearSCProductEntries = new ClearSCProductEntries(this);
		removeSCProductEntry = new RemoveSCProductEntry(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SCLicenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = SCLicensePersistence.class)
	protected SCLicensePersistence scLicensePersistence;
	@BeanReference(type = SCFrameworkVersionPersistence.class)
	protected SCFrameworkVersionPersistence scFrameworkVersionPersistence;
	@BeanReference(type = SCProductEntryPersistence.class)
	protected SCProductEntryPersistence scProductEntryPersistence;
	@BeanReference(type = SCProductScreenshotPersistence.class)
	protected SCProductScreenshotPersistence scProductScreenshotPersistence;
	@BeanReference(type = SCProductVersionPersistence.class)
	protected SCProductVersionPersistence scProductVersionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsSCProductEntry containsSCProductEntry;
	protected AddSCProductEntry addSCProductEntry;
	protected ClearSCProductEntries clearSCProductEntries;
	protected RemoveSCProductEntry removeSCProductEntry;

	protected class ContainsSCProductEntry {
		protected ContainsSCProductEntry(
			SCLicensePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSSCPRODUCTENTRY,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long licenseId, long productEntryId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(licenseId), new Long(productEntryId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	protected class AddSCProductEntry {
		protected AddSCProductEntry(SCLicensePersistenceImpl persistenceImpl) {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"INSERT INTO SCLicenses_SCProductEntries (licenseId, productEntryId) VALUES (?, ?)",
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
			_persistenceImpl = persistenceImpl;
		}

		protected void add(long licenseId, long productEntryId)
			throws SystemException {
			if (!_persistenceImpl.containsSCProductEntry.contains(licenseId,
						productEntryId)) {
				ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry>[] scProductEntryListeners =
					scProductEntryPersistence.getListeners();

				for (ModelListener<SCLicense> listener : listeners) {
					listener.onBeforeAddAssociation(licenseId,
						com.liferay.portlet.softwarecatalog.model.SCProductEntry.class.getName(),
						productEntryId);
				}

				for (ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry> listener : scProductEntryListeners) {
					listener.onBeforeAddAssociation(productEntryId,
						SCLicense.class.getName(), licenseId);
				}

				_sqlUpdate.update(new Object[] {
						new Long(licenseId), new Long(productEntryId)
					});

				for (ModelListener<SCLicense> listener : listeners) {
					listener.onAfterAddAssociation(licenseId,
						com.liferay.portlet.softwarecatalog.model.SCProductEntry.class.getName(),
						productEntryId);
				}

				for (ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry> listener : scProductEntryListeners) {
					listener.onAfterAddAssociation(productEntryId,
						SCLicense.class.getName(), licenseId);
				}
			}
		}

		private SqlUpdate _sqlUpdate;
		private SCLicensePersistenceImpl _persistenceImpl;
	}

	protected class ClearSCProductEntries {
		protected ClearSCProductEntries(
			SCLicensePersistenceImpl persistenceImpl) {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"DELETE FROM SCLicenses_SCProductEntries WHERE licenseId = ?",
					new int[] { java.sql.Types.BIGINT });
		}

		protected void clear(long licenseId) throws SystemException {
			ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry>[] scProductEntryListeners =
				scProductEntryPersistence.getListeners();

			List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> scProductEntries =
				null;

			if ((listeners.length > 0) || (scProductEntryListeners.length > 0)) {
				scProductEntries = getSCProductEntries(licenseId);

				for (com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry : scProductEntries) {
					for (ModelListener<SCLicense> listener : listeners) {
						listener.onBeforeRemoveAssociation(licenseId,
							com.liferay.portlet.softwarecatalog.model.SCProductEntry.class.getName(),
							scProductEntry.getPrimaryKey());
					}

					for (ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry> listener : scProductEntryListeners) {
						listener.onBeforeRemoveAssociation(scProductEntry.getPrimaryKey(),
							SCLicense.class.getName(), licenseId);
					}
				}
			}

			_sqlUpdate.update(new Object[] { new Long(licenseId) });

			if ((listeners.length > 0) || (scProductEntryListeners.length > 0)) {
				for (com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry : scProductEntries) {
					for (ModelListener<SCLicense> listener : listeners) {
						listener.onAfterRemoveAssociation(licenseId,
							com.liferay.portlet.softwarecatalog.model.SCProductEntry.class.getName(),
							scProductEntry.getPrimaryKey());
					}

					for (ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry> listener : scProductEntryListeners) {
						listener.onAfterRemoveAssociation(scProductEntry.getPrimaryKey(),
							SCLicense.class.getName(), licenseId);
					}
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	protected class RemoveSCProductEntry {
		protected RemoveSCProductEntry(SCLicensePersistenceImpl persistenceImpl) {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"DELETE FROM SCLicenses_SCProductEntries WHERE licenseId = ? AND productEntryId = ?",
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
			_persistenceImpl = persistenceImpl;
		}

		protected void remove(long licenseId, long productEntryId)
			throws SystemException {
			if (_persistenceImpl.containsSCProductEntry.contains(licenseId,
						productEntryId)) {
				ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry>[] scProductEntryListeners =
					scProductEntryPersistence.getListeners();

				for (ModelListener<SCLicense> listener : listeners) {
					listener.onBeforeRemoveAssociation(licenseId,
						com.liferay.portlet.softwarecatalog.model.SCProductEntry.class.getName(),
						productEntryId);
				}

				for (ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry> listener : scProductEntryListeners) {
					listener.onBeforeRemoveAssociation(productEntryId,
						SCLicense.class.getName(), licenseId);
				}

				_sqlUpdate.update(new Object[] {
						new Long(licenseId), new Long(productEntryId)
					});

				for (ModelListener<SCLicense> listener : listeners) {
					listener.onAfterRemoveAssociation(licenseId,
						com.liferay.portlet.softwarecatalog.model.SCProductEntry.class.getName(),
						productEntryId);
				}

				for (ModelListener<com.liferay.portlet.softwarecatalog.model.SCProductEntry> listener : scProductEntryListeners) {
					listener.onAfterRemoveAssociation(productEntryId,
						SCLicense.class.getName(), licenseId);
				}
			}
		}

		private SqlUpdate _sqlUpdate;
		private SCLicensePersistenceImpl _persistenceImpl;
	}

	private static final String _SQL_SELECT_SCLICENSE = "SELECT scLicense FROM SCLicense scLicense";
	private static final String _SQL_SELECT_SCLICENSE_WHERE = "SELECT scLicense FROM SCLicense scLicense WHERE ";
	private static final String _SQL_COUNT_SCLICENSE = "SELECT COUNT(scLicense) FROM SCLicense scLicense";
	private static final String _SQL_COUNT_SCLICENSE_WHERE = "SELECT COUNT(scLicense) FROM SCLicense scLicense WHERE ";
	private static final String _SQL_GETSCPRODUCTENTRIES = "SELECT {SCProductEntry.*} FROM SCProductEntry INNER JOIN SCLicenses_SCProductEntries ON (SCLicenses_SCProductEntries.productEntryId = SCProductEntry.productEntryId) WHERE (SCLicenses_SCProductEntries.licenseId = ?)";
	private static final String _SQL_GETSCPRODUCTENTRIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM SCLicenses_SCProductEntries WHERE licenseId = ?";
	private static final String _SQL_CONTAINSSCPRODUCTENTRY = "SELECT COUNT(*) AS COUNT_VALUE FROM SCLicenses_SCProductEntries WHERE licenseId = ? AND productEntryId = ?";
	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "scLicense.active = ?";
	private static final String _FINDER_COLUMN_A_R_ACTIVE_2 = "scLicense.active = ? AND ";
	private static final String _FINDER_COLUMN_A_R_RECOMMENDED_2 = "scLicense.recommended = ?";
	private static final String _FILTER_SQL_SELECT_SCLICENSE_WHERE = "SELECT DISTINCT {scLicense.*} FROM SCLicense scLicense WHERE ";
	private static final String _FILTER_SQL_SELECT_SCLICENSE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {SCLicense.*} FROM (SELECT DISTINCT scLicense.licenseId FROM SCLicense scLicense WHERE ";
	private static final String _FILTER_SQL_SELECT_SCLICENSE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN SCLicense ON TEMP_TABLE.licenseId = SCLicense.licenseId";
	private static final String _FILTER_SQL_COUNT_SCLICENSE_WHERE = "SELECT COUNT(DISTINCT scLicense.licenseId) AS COUNT_VALUE FROM SCLicense scLicense WHERE ";
	private static final String _FILTER_COLUMN_PK = "scLicense.licenseId";
	private static final String _FILTER_COLUMN_USERID = null;
	private static final String _FILTER_ENTITY_ALIAS = "scLicense";
	private static final String _FILTER_ENTITY_TABLE = "SCLicense";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scLicense.";
	private static final String _ORDER_BY_ENTITY_TABLE = "SCLicense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SCLicense exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SCLicense exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SCLicensePersistenceImpl.class);
}