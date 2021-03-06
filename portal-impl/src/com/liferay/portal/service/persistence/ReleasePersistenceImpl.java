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
import com.liferay.portal.NoSuchReleaseException;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.Release;
import com.liferay.portal.model.impl.ReleaseImpl;
import com.liferay.portal.model.impl.ReleaseModelImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the release service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReleasePersistence
 * @see ReleaseUtil
 * @generated
 */
public class ReleasePersistenceImpl extends BasePersistenceImpl<Release>
	implements ReleasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReleaseUtil} to access the release persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReleaseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME = new FinderPath(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByServletContextName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVLETCONTEXTNAME = new FinderPath(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByServletContextName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the release in the entity cache if it is enabled.
	 *
	 * @param release the release to cache
	 */
	public void cacheResult(Release release) {
		EntityCacheUtil.putResult(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseImpl.class, release.getPrimaryKey(), release);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
			new Object[] { release.getServletContextName() }, release);
	}

	/**
	 * Caches the releases in the entity cache if it is enabled.
	 *
	 * @param releases the releases to cache
	 */
	public void cacheResult(List<Release> releases) {
		for (Release release : releases) {
			if (EntityCacheUtil.getResult(
						ReleaseModelImpl.ENTITY_CACHE_ENABLED,
						ReleaseImpl.class, release.getPrimaryKey(), this) == null) {
				cacheResult(release);
			}
		}
	}

	/**
	 * Clears the cache for all releases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ReleaseImpl.class.getName());
		EntityCacheUtil.clearCache(ReleaseImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the release.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Release release) {
		EntityCacheUtil.removeResult(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseImpl.class, release.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
			new Object[] { release.getServletContextName() });
	}

	/**
	 * Creates a new release with the primary key. Does not add the release to the database.
	 *
	 * @param releaseId the primary key for the new release
	 * @return the new release
	 */
	public Release create(long releaseId) {
		Release release = new ReleaseImpl();

		release.setNew(true);
		release.setPrimaryKey(releaseId);

		return release;
	}

	/**
	 * Removes the release with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the release to remove
	 * @return the release that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a release with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the release with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param releaseId the primary key of the release to remove
	 * @return the release that was removed
	 * @throws com.liferay.portal.NoSuchReleaseException if a release with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release remove(long releaseId)
		throws NoSuchReleaseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Release release = (Release)session.get(ReleaseImpl.class,
					new Long(releaseId));

			if (release == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + releaseId);
				}

				throw new NoSuchReleaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					releaseId);
			}

			return remove(release);
		}
		catch (NoSuchReleaseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Release removeImpl(Release release) throws SystemException {
		release = toUnwrappedModel(release);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, release);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		ReleaseModelImpl releaseModelImpl = (ReleaseModelImpl)release;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
			new Object[] { releaseModelImpl.getOriginalServletContextName() });

		EntityCacheUtil.removeResult(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseImpl.class, release.getPrimaryKey());

		return release;
	}

	public Release updateImpl(com.liferay.portal.model.Release release,
		boolean merge) throws SystemException {
		release = toUnwrappedModel(release);

		boolean isNew = release.isNew();

		ReleaseModelImpl releaseModelImpl = (ReleaseModelImpl)release;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, release, merge);

			release.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
			ReleaseImpl.class, release.getPrimaryKey(), release);

		if (!isNew &&
				(!Validator.equals(release.getServletContextName(),
					releaseModelImpl.getOriginalServletContextName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
				new Object[] { releaseModelImpl.getOriginalServletContextName() });
		}

		if (isNew ||
				(!Validator.equals(release.getServletContextName(),
					releaseModelImpl.getOriginalServletContextName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
				new Object[] { release.getServletContextName() }, release);
		}

		return release;
	}

	protected Release toUnwrappedModel(Release release) {
		if (release instanceof ReleaseImpl) {
			return release;
		}

		ReleaseImpl releaseImpl = new ReleaseImpl();

		releaseImpl.setNew(release.isNew());
		releaseImpl.setPrimaryKey(release.getPrimaryKey());

		releaseImpl.setReleaseId(release.getReleaseId());
		releaseImpl.setCreateDate(release.getCreateDate());
		releaseImpl.setModifiedDate(release.getModifiedDate());
		releaseImpl.setServletContextName(release.getServletContextName());
		releaseImpl.setBuildNumber(release.getBuildNumber());
		releaseImpl.setBuildDate(release.getBuildDate());
		releaseImpl.setVerified(release.isVerified());
		releaseImpl.setTestString(release.getTestString());

		return releaseImpl;
	}

	/**
	 * Finds the release with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the release to find
	 * @return the release
	 * @throws com.liferay.portal.NoSuchModelException if a release with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the release with the primary key or throws a {@link com.liferay.portal.NoSuchReleaseException} if it could not be found.
	 *
	 * @param releaseId the primary key of the release to find
	 * @return the release
	 * @throws com.liferay.portal.NoSuchReleaseException if a release with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release findByPrimaryKey(long releaseId)
		throws NoSuchReleaseException, SystemException {
		Release release = fetchByPrimaryKey(releaseId);

		if (release == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + releaseId);
			}

			throw new NoSuchReleaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				releaseId);
		}

		return release;
	}

	/**
	 * Finds the release with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the release to find
	 * @return the release, or <code>null</code> if a release with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the release with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param releaseId the primary key of the release to find
	 * @return the release, or <code>null</code> if a release with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release fetchByPrimaryKey(long releaseId) throws SystemException {
		Release release = (Release)EntityCacheUtil.getResult(ReleaseModelImpl.ENTITY_CACHE_ENABLED,
				ReleaseImpl.class, releaseId, this);

		if (release == null) {
			Session session = null;

			try {
				session = openSession();

				release = (Release)session.get(ReleaseImpl.class,
						new Long(releaseId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (release != null) {
					cacheResult(release);
				}

				closeSession(session);
			}
		}

		return release;
	}

	/**
	 * Finds the release where servletContextName = &#63; or throws a {@link com.liferay.portal.NoSuchReleaseException} if it could not be found.
	 *
	 * @param servletContextName the servlet context name to search with
	 * @return the matching release
	 * @throws com.liferay.portal.NoSuchReleaseException if a matching release could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release findByServletContextName(String servletContextName)
		throws NoSuchReleaseException, SystemException {
		Release release = fetchByServletContextName(servletContextName);

		if (release == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("servletContextName=");
			msg.append(servletContextName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchReleaseException(msg.toString());
		}

		return release;
	}

	/**
	 * Finds the release where servletContextName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param servletContextName the servlet context name to search with
	 * @return the matching release, or <code>null</code> if a matching release could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release fetchByServletContextName(String servletContextName)
		throws SystemException {
		return fetchByServletContextName(servletContextName, true);
	}

	/**
	 * Finds the release where servletContextName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param servletContextName the servlet context name to search with
	 * @return the matching release, or <code>null</code> if a matching release could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Release fetchByServletContextName(String servletContextName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { servletContextName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_RELEASE_WHERE);

			if (servletContextName == null) {
				query.append(_FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_1);
			}
			else {
				if (servletContextName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (servletContextName != null) {
					qPos.add(servletContextName);
				}

				List<Release> list = q.list();

				result = list;

				Release release = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
						finderArgs, list);
				}
				else {
					release = list.get(0);

					cacheResult(release);

					if ((release.getServletContextName() == null) ||
							!release.getServletContextName()
										.equals(servletContextName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
							finderArgs, release);
					}
				}

				return release;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVLETCONTEXTNAME,
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
				return (Release)result;
			}
		}
	}

	/**
	 * Finds all the releases.
	 *
	 * @return the releases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Release> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the releases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of releases to return
	 * @param end the upper bound of the range of releases to return (not inclusive)
	 * @return the range of releases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Release> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the releases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of releases to return
	 * @param end the upper bound of the range of releases to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of releases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Release> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Release> list = (List<Release>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RELEASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RELEASE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Release>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Release>)QueryUtil.list(q, getDialect(),
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
	 * Removes the release where servletContextName = &#63; from the database.
	 *
	 * @param servletContextName the servlet context name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByServletContextName(String servletContextName)
		throws NoSuchReleaseException, SystemException {
		Release release = findByServletContextName(servletContextName);

		remove(release);
	}

	/**
	 * Removes all the releases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Release release : findAll()) {
			remove(release);
		}
	}

	/**
	 * Counts all the releases where servletContextName = &#63;.
	 *
	 * @param servletContextName the servlet context name to search with
	 * @return the number of matching releases
	 * @throws SystemException if a system exception occurred
	 */
	public int countByServletContextName(String servletContextName)
		throws SystemException {
		Object[] finderArgs = new Object[] { servletContextName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVLETCONTEXTNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RELEASE_WHERE);

			if (servletContextName == null) {
				query.append(_FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_1);
			}
			else {
				if (servletContextName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (servletContextName != null) {
					qPos.add(servletContextName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVLETCONTEXTNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the releases.
	 *
	 * @return the number of releases
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

				Query q = session.createQuery(_SQL_COUNT_RELEASE);

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
	 * Initializes the release persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.Release")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Release>> listenersList = new ArrayList<ModelListener<Release>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Release>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReleaseImpl.class.getName());
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
	private static final String _SQL_SELECT_RELEASE = "SELECT release FROM Release release";
	private static final String _SQL_SELECT_RELEASE_WHERE = "SELECT release FROM Release release WHERE ";
	private static final String _SQL_COUNT_RELEASE = "SELECT COUNT(release) FROM Release release";
	private static final String _SQL_COUNT_RELEASE_WHERE = "SELECT COUNT(release) FROM Release release WHERE ";
	private static final String _FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_1 =
		"release.servletContextName IS NULL";
	private static final String _FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_2 =
		"release.servletContextName = ?";
	private static final String _FINDER_COLUMN_SERVLETCONTEXTNAME_SERVLETCONTEXTNAME_3 =
		"(release.servletContextName IS NULL OR release.servletContextName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "release.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Release exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Release exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ReleasePersistenceImpl.class);
}