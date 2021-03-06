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

import com.liferay.portal.NoSuchLayoutException;
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
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.impl.LayoutImpl;
import com.liferay.portal.model.impl.LayoutModelImpl;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistence;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;
import com.liferay.portlet.journal.service.persistence.JournalContentSearchPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;
import com.liferay.portlet.tasks.service.persistence.TasksProposalPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the layout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPersistence
 * @see LayoutUtil
 * @generated
 */
public class LayoutPersistenceImpl extends BasePersistenceImpl<Layout>
	implements LayoutPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LayoutUtil} to access the layout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LayoutImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_DLFOLDERID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByDLFolderId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_DLFOLDERID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByDLFolderId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_ICONIMAGEID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByIconImageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_ICONIMAGEID = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByIconImageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_P = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_P",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_P_L = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_P_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P_L = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_P_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_G_P_P = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_P_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P_P = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_P_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_G_P_F = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_P_F",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P_F = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_P_F",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_G_P_T = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_P_T",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P_T = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_P_T",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the layout in the entity cache if it is enabled.
	 *
	 * @param layout the layout to cache
	 */
	public void cacheResult(Layout layout) {
		EntityCacheUtil.putResult(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutImpl.class, layout.getPrimaryKey(), layout);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { layout.getUuid(), new Long(layout.getGroupId()) },
			layout);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
			new Object[] { new Long(layout.getDlFolderId()) }, layout);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
			new Object[] { new Long(layout.getIconImageId()) }, layout);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_L,
			new Object[] {
				new Long(layout.getGroupId()),
				Boolean.valueOf(layout.getPrivateLayout()),
				new Long(layout.getLayoutId())
			}, layout);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_F,
			new Object[] {
				new Long(layout.getGroupId()),
				Boolean.valueOf(layout.getPrivateLayout()),
				
			layout.getFriendlyURL()
			}, layout);
	}

	/**
	 * Caches the layouts in the entity cache if it is enabled.
	 *
	 * @param layouts the layouts to cache
	 */
	public void cacheResult(List<Layout> layouts) {
		for (Layout layout : layouts) {
			if (EntityCacheUtil.getResult(
						LayoutModelImpl.ENTITY_CACHE_ENABLED, LayoutImpl.class,
						layout.getPrimaryKey(), this) == null) {
				cacheResult(layout);
			}
		}
	}

	/**
	 * Clears the cache for all layouts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(LayoutImpl.class.getName());
		EntityCacheUtil.clearCache(LayoutImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the layout.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Layout layout) {
		EntityCacheUtil.removeResult(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutImpl.class, layout.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { layout.getUuid(), new Long(layout.getGroupId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
			new Object[] { new Long(layout.getDlFolderId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
			new Object[] { new Long(layout.getIconImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_L,
			new Object[] {
				new Long(layout.getGroupId()),
				Boolean.valueOf(layout.getPrivateLayout()),
				new Long(layout.getLayoutId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_F,
			new Object[] {
				new Long(layout.getGroupId()),
				Boolean.valueOf(layout.getPrivateLayout()),
				
			layout.getFriendlyURL()
			});
	}

	/**
	 * Creates a new layout with the primary key. Does not add the layout to the database.
	 *
	 * @param plid the primary key for the new layout
	 * @return the new layout
	 */
	public Layout create(long plid) {
		Layout layout = new LayoutImpl();

		layout.setNew(true);
		layout.setPrimaryKey(plid);

		String uuid = PortalUUIDUtil.generate();

		layout.setUuid(uuid);

		return layout;
	}

	/**
	 * Removes the layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the layout to remove
	 * @return the layout that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param plid the primary key of the layout to remove
	 * @return the layout that was removed
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout remove(long plid)
		throws NoSuchLayoutException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Layout layout = (Layout)session.get(LayoutImpl.class, new Long(plid));

			if (layout == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + plid);
				}

				throw new NoSuchLayoutException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					plid);
			}

			return remove(layout);
		}
		catch (NoSuchLayoutException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Layout removeImpl(Layout layout) throws SystemException {
		layout = toUnwrappedModel(layout);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, layout);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		LayoutModelImpl layoutModelImpl = (LayoutModelImpl)layout;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				layoutModelImpl.getOriginalUuid(),
				new Long(layoutModelImpl.getOriginalGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
			new Object[] { new Long(layoutModelImpl.getOriginalDlFolderId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
			new Object[] { new Long(layoutModelImpl.getOriginalIconImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_L,
			new Object[] {
				new Long(layoutModelImpl.getOriginalGroupId()),
				Boolean.valueOf(layoutModelImpl.getOriginalPrivateLayout()),
				new Long(layoutModelImpl.getOriginalLayoutId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_F,
			new Object[] {
				new Long(layoutModelImpl.getOriginalGroupId()),
				Boolean.valueOf(layoutModelImpl.getOriginalPrivateLayout()),
				
			layoutModelImpl.getOriginalFriendlyURL()
			});

		EntityCacheUtil.removeResult(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutImpl.class, layout.getPrimaryKey());

		return layout;
	}

	public Layout updateImpl(com.liferay.portal.model.Layout layout,
		boolean merge) throws SystemException {
		layout = toUnwrappedModel(layout);

		boolean isNew = layout.isNew();

		LayoutModelImpl layoutModelImpl = (LayoutModelImpl)layout;

		if (Validator.isNull(layout.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			layout.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, layout, merge);

			layout.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LayoutModelImpl.ENTITY_CACHE_ENABLED,
			LayoutImpl.class, layout.getPrimaryKey(), layout);

		if (!isNew &&
				(!Validator.equals(layout.getUuid(),
					layoutModelImpl.getOriginalUuid()) ||
				(layout.getGroupId() != layoutModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					layoutModelImpl.getOriginalUuid(),
					new Long(layoutModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(layout.getUuid(),
					layoutModelImpl.getOriginalUuid()) ||
				(layout.getGroupId() != layoutModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { layout.getUuid(), new Long(layout.getGroupId()) },
				layout);
		}

		if (!isNew &&
				(layout.getDlFolderId() != layoutModelImpl.getOriginalDlFolderId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
				new Object[] { new Long(layoutModelImpl.getOriginalDlFolderId()) });
		}

		if (isNew ||
				(layout.getDlFolderId() != layoutModelImpl.getOriginalDlFolderId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
				new Object[] { new Long(layout.getDlFolderId()) }, layout);
		}

		if (!isNew &&
				(layout.getIconImageId() != layoutModelImpl.getOriginalIconImageId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
				new Object[] { new Long(layoutModelImpl.getOriginalIconImageId()) });
		}

		if (isNew ||
				(layout.getIconImageId() != layoutModelImpl.getOriginalIconImageId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
				new Object[] { new Long(layout.getIconImageId()) }, layout);
		}

		if (!isNew &&
				((layout.getGroupId() != layoutModelImpl.getOriginalGroupId()) ||
				(layout.getPrivateLayout() != layoutModelImpl.getOriginalPrivateLayout()) ||
				(layout.getLayoutId() != layoutModelImpl.getOriginalLayoutId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_L,
				new Object[] {
					new Long(layoutModelImpl.getOriginalGroupId()),
					Boolean.valueOf(layoutModelImpl.getOriginalPrivateLayout()),
					new Long(layoutModelImpl.getOriginalLayoutId())
				});
		}

		if (isNew ||
				((layout.getGroupId() != layoutModelImpl.getOriginalGroupId()) ||
				(layout.getPrivateLayout() != layoutModelImpl.getOriginalPrivateLayout()) ||
				(layout.getLayoutId() != layoutModelImpl.getOriginalLayoutId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_L,
				new Object[] {
					new Long(layout.getGroupId()),
					Boolean.valueOf(layout.getPrivateLayout()),
					new Long(layout.getLayoutId())
				}, layout);
		}

		if (!isNew &&
				((layout.getGroupId() != layoutModelImpl.getOriginalGroupId()) ||
				(layout.getPrivateLayout() != layoutModelImpl.getOriginalPrivateLayout()) ||
				!Validator.equals(layout.getFriendlyURL(),
					layoutModelImpl.getOriginalFriendlyURL()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_F,
				new Object[] {
					new Long(layoutModelImpl.getOriginalGroupId()),
					Boolean.valueOf(layoutModelImpl.getOriginalPrivateLayout()),
					
				layoutModelImpl.getOriginalFriendlyURL()
				});
		}

		if (isNew ||
				((layout.getGroupId() != layoutModelImpl.getOriginalGroupId()) ||
				(layout.getPrivateLayout() != layoutModelImpl.getOriginalPrivateLayout()) ||
				!Validator.equals(layout.getFriendlyURL(),
					layoutModelImpl.getOriginalFriendlyURL()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_F,
				new Object[] {
					new Long(layout.getGroupId()),
					Boolean.valueOf(layout.getPrivateLayout()),
					
				layout.getFriendlyURL()
				}, layout);
		}

		return layout;
	}

	protected Layout toUnwrappedModel(Layout layout) {
		if (layout instanceof LayoutImpl) {
			return layout;
		}

		LayoutImpl layoutImpl = new LayoutImpl();

		layoutImpl.setNew(layout.isNew());
		layoutImpl.setPrimaryKey(layout.getPrimaryKey());

		layoutImpl.setUuid(layout.getUuid());
		layoutImpl.setPlid(layout.getPlid());
		layoutImpl.setGroupId(layout.getGroupId());
		layoutImpl.setCompanyId(layout.getCompanyId());
		layoutImpl.setPrivateLayout(layout.isPrivateLayout());
		layoutImpl.setLayoutId(layout.getLayoutId());
		layoutImpl.setParentLayoutId(layout.getParentLayoutId());
		layoutImpl.setName(layout.getName());
		layoutImpl.setTitle(layout.getTitle());
		layoutImpl.setDescription(layout.getDescription());
		layoutImpl.setType(layout.getType());
		layoutImpl.setTypeSettings(layout.getTypeSettings());
		layoutImpl.setHidden(layout.isHidden());
		layoutImpl.setFriendlyURL(layout.getFriendlyURL());
		layoutImpl.setIconImage(layout.isIconImage());
		layoutImpl.setIconImageId(layout.getIconImageId());
		layoutImpl.setThemeId(layout.getThemeId());
		layoutImpl.setColorSchemeId(layout.getColorSchemeId());
		layoutImpl.setWapThemeId(layout.getWapThemeId());
		layoutImpl.setWapColorSchemeId(layout.getWapColorSchemeId());
		layoutImpl.setCss(layout.getCss());
		layoutImpl.setPriority(layout.getPriority());
		layoutImpl.setLayoutPrototypeId(layout.getLayoutPrototypeId());
		layoutImpl.setDlFolderId(layout.getDlFolderId());

		return layoutImpl;
	}

	/**
	 * Finds the layout with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the layout to find
	 * @return the layout
	 * @throws com.liferay.portal.NoSuchModelException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the layout with the primary key or throws a {@link com.liferay.portal.NoSuchLayoutException} if it could not be found.
	 *
	 * @param plid the primary key of the layout to find
	 * @return the layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByPrimaryKey(long plid)
		throws NoSuchLayoutException, SystemException {
		Layout layout = fetchByPrimaryKey(plid);

		if (layout == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + plid);
			}

			throw new NoSuchLayoutException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				plid);
		}

		return layout;
	}

	/**
	 * Finds the layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the layout to find
	 * @return the layout, or <code>null</code> if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param plid the primary key of the layout to find
	 * @return the layout, or <code>null</code> if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByPrimaryKey(long plid) throws SystemException {
		Layout layout = (Layout)EntityCacheUtil.getResult(LayoutModelImpl.ENTITY_CACHE_ENABLED,
				LayoutImpl.class, plid, this);

		if (layout == null) {
			Session session = null;

			try {
				session = openSession();

				layout = (Layout)session.get(LayoutImpl.class, new Long(plid));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (layout != null) {
					cacheResult(layout);
				}

				closeSession(session);
			}
		}

		return layout;
	}

	/**
	 * Finds all the layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
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

			query.append(_SQL_SELECT_LAYOUT_WHERE);

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
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
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

				list = (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Finds the first layout in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		List<Layout> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last layout in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		int count = countByUuid(uuid);

		List<Layout> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the layouts before and after the current layout in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param plid the primary key of the current layout
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout[] findByUuid_PrevAndNext(long plid, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByPrimaryKey(plid);

		Session session = null;

		try {
			session = openSession();

			Layout[] array = new LayoutImpl[3];

			array[0] = getByUuid_PrevAndNext(session, layout, uuid,
					orderByComparator, true);

			array[1] = layout;

			array[2] = getByUuid_PrevAndNext(session, layout, uuid,
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

	protected Layout getByUuid_PrevAndNext(Session session, Layout layout,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYOUT_WHERE);

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
			query.append(LayoutModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(layout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the layout where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portal.NoSuchLayoutException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByUUID_G(String uuid, long groupId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = fetchByUUID_G(uuid, groupId);

		if (layout == null) {
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

			throw new NoSuchLayoutException(msg.toString());
		}

		return layout;
	}

	/**
	 * Finds the layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LAYOUT_WHERE);

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

			query.append(LayoutModelImpl.ORDER_BY_JPQL);

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

				List<Layout> list = q.list();

				result = list;

				Layout layout = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					layout = list.get(0);

					cacheResult(layout);

					if ((layout.getUuid() == null) ||
							!layout.getUuid().equals(uuid) ||
							(layout.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, layout);
					}
				}

				return layout;
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
				return (Layout)result;
			}
		}
	}

	/**
	 * Finds all the layouts where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the layouts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the layouts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Finds the first layout in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		List<Layout> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last layout in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		int count = countByGroupId(groupId);

		List<Layout> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the layouts before and after the current layout in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param plid the primary key of the current layout
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout[] findByGroupId_PrevAndNext(long plid, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByPrimaryKey(plid);

		Session session = null;

		try {
			session = openSession();

			Layout[] array = new LayoutImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, layout, groupId,
					orderByComparator, true);

			array[1] = layout;

			array[2] = getByGroupId_PrevAndNext(session, layout, groupId,
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

	protected Layout getByGroupId_PrevAndNext(Session session, Layout layout,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYOUT_WHERE);

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
			query.append(LayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(layout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the layouts where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the layouts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the layouts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByGroupId(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_LAYOUT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LayoutModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LayoutImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LayoutImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the layouts where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the layouts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the layouts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
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

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Finds the first layout in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		List<Layout> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last layout in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		int count = countByCompanyId(companyId);

		List<Layout> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the layouts before and after the current layout in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param plid the primary key of the current layout
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout[] findByCompanyId_PrevAndNext(long plid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByPrimaryKey(plid);

		Session session = null;

		try {
			session = openSession();

			Layout[] array = new LayoutImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, layout, companyId,
					orderByComparator, true);

			array[1] = layout;

			array[2] = getByCompanyId_PrevAndNext(session, layout, companyId,
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

	protected Layout getByCompanyId_PrevAndNext(Session session, Layout layout,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYOUT_WHERE);

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
			query.append(LayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(layout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the layout where dlFolderId = &#63; or throws a {@link com.liferay.portal.NoSuchLayoutException} if it could not be found.
	 *
	 * @param dlFolderId the dl folder id to search with
	 * @return the matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByDLFolderId(long dlFolderId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = fetchByDLFolderId(dlFolderId);

		if (layout == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dlFolderId=");
			msg.append(dlFolderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLayoutException(msg.toString());
		}

		return layout;
	}

	/**
	 * Finds the layout where dlFolderId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlFolderId the dl folder id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByDLFolderId(long dlFolderId) throws SystemException {
		return fetchByDLFolderId(dlFolderId, true);
	}

	/**
	 * Finds the layout where dlFolderId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlFolderId the dl folder id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByDLFolderId(long dlFolderId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { dlFolderId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DLFOLDERID_DLFOLDERID_2);

			query.append(LayoutModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dlFolderId);

				List<Layout> list = q.list();

				result = list;

				Layout layout = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
						finderArgs, list);
				}
				else {
					layout = list.get(0);

					cacheResult(layout);

					if ((layout.getDlFolderId() != dlFolderId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
							finderArgs, layout);
					}
				}

				return layout;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DLFOLDERID,
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
				return (Layout)result;
			}
		}
	}

	/**
	 * Finds the layout where iconImageId = &#63; or throws a {@link com.liferay.portal.NoSuchLayoutException} if it could not be found.
	 *
	 * @param iconImageId the icon image id to search with
	 * @return the matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByIconImageId(long iconImageId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = fetchByIconImageId(iconImageId);

		if (layout == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("iconImageId=");
			msg.append(iconImageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLayoutException(msg.toString());
		}

		return layout;
	}

	/**
	 * Finds the layout where iconImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param iconImageId the icon image id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByIconImageId(long iconImageId)
		throws SystemException {
		return fetchByIconImageId(iconImageId, true);
	}

	/**
	 * Finds the layout where iconImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param iconImageId the icon image id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByIconImageId(long iconImageId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { iconImageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_ICONIMAGEID_ICONIMAGEID_2);

			query.append(LayoutModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(iconImageId);

				List<Layout> list = q.list();

				result = list;

				Layout layout = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
						finderArgs, list);
				}
				else {
					layout = list.get(0);

					cacheResult(layout);

					if ((layout.getIconImageId() != iconImageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
							finderArgs, layout);
					}
				}

				return layout;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONIMAGEID,
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
				return (Layout)result;
			}
		}
	}

	/**
	 * Finds all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @return the matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P(long groupId, boolean privateLayout)
		throws SystemException {
		return findByG_P(groupId, privateLayout, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P(long groupId, boolean privateLayout,
		int start, int end) throws SystemException {
		return findByG_P(groupId, privateLayout, start, end, null);
	}

	/**
	 * Finds an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P(long groupId, boolean privateLayout,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, privateLayout,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_P,
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

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PRIVATELAYOUT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				list = (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_P,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_P,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_First(long groupId, boolean privateLayout,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		List<Layout> list = findByG_P(groupId, privateLayout, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_Last(long groupId, boolean privateLayout,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		int count = countByG_P(groupId, privateLayout);

		List<Layout> list = findByG_P(groupId, privateLayout, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param plid the primary key of the current layout
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout[] findByG_P_PrevAndNext(long plid, long groupId,
		boolean privateLayout, OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByPrimaryKey(plid);

		Session session = null;

		try {
			session = openSession();

			Layout[] array = new LayoutImpl[3];

			array[0] = getByG_P_PrevAndNext(session, layout, groupId,
					privateLayout, orderByComparator, true);

			array[1] = layout;

			array[2] = getByG_P_PrevAndNext(session, layout, groupId,
					privateLayout, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Layout getByG_P_PrevAndNext(Session session, Layout layout,
		long groupId, boolean privateLayout,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PRIVATELAYOUT_2);

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
			query.append(LayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(privateLayout);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(layout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @return the matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P(long groupId, boolean privateLayout)
		throws SystemException {
		return filterFindByG_P(groupId, privateLayout, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P(long groupId, boolean privateLayout,
		int start, int end) throws SystemException {
		return filterFindByG_P(groupId, privateLayout, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P(long groupId, boolean privateLayout,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P(groupId, privateLayout, start, end,
				orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_LAYOUT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PRIVATELAYOUT_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LayoutModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LayoutImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LayoutImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(privateLayout);

			return (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; or throws a {@link com.liferay.portal.NoSuchLayoutException} if it could not be found.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param layoutId the layout id to search with
	 * @return the matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_L(long groupId, boolean privateLayout, long layoutId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = fetchByG_P_L(groupId, privateLayout, layoutId);

		if (layout == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLayoutException(msg.toString());
		}

		return layout;
	}

	/**
	 * Finds the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param layoutId the layout id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByG_P_L(long groupId, boolean privateLayout,
		long layoutId) throws SystemException {
		return fetchByG_P_L(groupId, privateLayout, layoutId, true);
	}

	/**
	 * Finds the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param layoutId the layout id to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByG_P_L(long groupId, boolean privateLayout,
		long layoutId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, privateLayout, layoutId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_P_L,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_L_PRIVATELAYOUT_2);

			query.append(_FINDER_COLUMN_G_P_L_LAYOUTID_2);

			query.append(LayoutModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				qPos.add(layoutId);

				List<Layout> list = q.list();

				result = list;

				Layout layout = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_L,
						finderArgs, list);
				}
				else {
					layout = list.get(0);

					cacheResult(layout);

					if ((layout.getGroupId() != groupId) ||
							(layout.getPrivateLayout() != privateLayout) ||
							(layout.getLayoutId() != layoutId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_L,
							finderArgs, layout);
					}
				}

				return layout;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_L,
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
				return (Layout)result;
			}
		}
	}

	/**
	 * Finds all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @return the matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId) throws SystemException {
		return findByG_P_P(groupId, privateLayout, parentLayoutId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId, int start, int end) throws SystemException {
		return findByG_P_P(groupId, privateLayout, parentLayoutId, start, end,
			null);
	}

	/**
	 * Finds an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, privateLayout, parentLayoutId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_P_P,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_P_PRIVATELAYOUT_2);

			query.append(_FINDER_COLUMN_G_P_P_PARENTLAYOUTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				qPos.add(parentLayoutId);

				list = (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_P_P,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_P_P,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_P_First(long groupId, boolean privateLayout,
		long parentLayoutId, OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		List<Layout> list = findByG_P_P(groupId, privateLayout, parentLayoutId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(", parentLayoutId=");
			msg.append(parentLayoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_P_Last(long groupId, boolean privateLayout,
		long parentLayoutId, OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		int count = countByG_P_P(groupId, privateLayout, parentLayoutId);

		List<Layout> list = findByG_P_P(groupId, privateLayout, parentLayoutId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(", parentLayoutId=");
			msg.append(parentLayoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param plid the primary key of the current layout
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout[] findByG_P_P_PrevAndNext(long plid, long groupId,
		boolean privateLayout, long parentLayoutId,
		OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByPrimaryKey(plid);

		Session session = null;

		try {
			session = openSession();

			Layout[] array = new LayoutImpl[3];

			array[0] = getByG_P_P_PrevAndNext(session, layout, groupId,
					privateLayout, parentLayoutId, orderByComparator, true);

			array[1] = layout;

			array[2] = getByG_P_P_PrevAndNext(session, layout, groupId,
					privateLayout, parentLayoutId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Layout getByG_P_P_PrevAndNext(Session session, Layout layout,
		long groupId, boolean privateLayout, long parentLayoutId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_G_P_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_P_PRIVATELAYOUT_2);

		query.append(_FINDER_COLUMN_G_P_P_PARENTLAYOUTID_2);

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
			query.append(LayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(privateLayout);

		qPos.add(parentLayoutId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(layout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @return the matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId) throws SystemException {
		return filterFindByG_P_P(groupId, privateLayout, parentLayoutId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId, int start, int end) throws SystemException {
		return filterFindByG_P_P(groupId, privateLayout, parentLayoutId, start,
			end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P_P(groupId, privateLayout, parentLayoutId, start,
				end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LAYOUT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_P_PRIVATELAYOUT_2);

		query.append(_FINDER_COLUMN_G_P_P_PARENTLAYOUTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LayoutModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LayoutImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LayoutImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(privateLayout);

			qPos.add(parentLayoutId);

			return (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; or throws a {@link com.liferay.portal.NoSuchLayoutException} if it could not be found.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param friendlyURL the friendly u r l to search with
	 * @return the matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL) throws NoSuchLayoutException, SystemException {
		Layout layout = fetchByG_P_F(groupId, privateLayout, friendlyURL);

		if (layout == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(", friendlyURL=");
			msg.append(friendlyURL);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLayoutException(msg.toString());
		}

		return layout;
	}

	/**
	 * Finds the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param friendlyURL the friendly u r l to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL) throws SystemException {
		return fetchByG_P_F(groupId, privateLayout, friendlyURL, true);
	}

	/**
	 * Finds the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param friendlyURL the friendly u r l to search with
	 * @return the matching layout, or <code>null</code> if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout fetchByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, privateLayout, friendlyURL };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_P_F,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_F_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_F_PRIVATELAYOUT_2);

			if (friendlyURL == null) {
				query.append(_FINDER_COLUMN_G_P_F_FRIENDLYURL_1);
			}
			else {
				if (friendlyURL.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_P_F_FRIENDLYURL_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_P_F_FRIENDLYURL_2);
				}
			}

			query.append(LayoutModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				if (friendlyURL != null) {
					qPos.add(friendlyURL);
				}

				List<Layout> list = q.list();

				result = list;

				Layout layout = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_F,
						finderArgs, list);
				}
				else {
					layout = list.get(0);

					cacheResult(layout);

					if ((layout.getGroupId() != groupId) ||
							(layout.getPrivateLayout() != privateLayout) ||
							(layout.getFriendlyURL() == null) ||
							!layout.getFriendlyURL().equals(friendlyURL)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_P_F,
							finderArgs, layout);
					}
				}

				return layout;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_P_F,
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
				return (Layout)result;
			}
		}
	}

	/**
	 * Finds all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @return the matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P_T(long groupId, boolean privateLayout,
		String type) throws SystemException {
		return findByG_P_T(groupId, privateLayout, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P_T(long groupId, boolean privateLayout,
		String type, int start, int end) throws SystemException {
		return findByG_P_T(groupId, privateLayout, type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findByG_P_T(long groupId, boolean privateLayout,
		String type, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, privateLayout, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_P_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_T_PRIVATELAYOUT_2);

			if (type == null) {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_P_T_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_P_T_TYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				if (type != null) {
					qPos.add(type);
				}

				list = (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_P_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_P_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_T_First(long groupId, boolean privateLayout,
		String type, OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		List<Layout> list = findByG_P_T(groupId, privateLayout, type, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a matching layout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout findByG_P_T_Last(long groupId, boolean privateLayout,
		String type, OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		int count = countByG_P_T(groupId, privateLayout, type);

		List<Layout> list = findByG_P_T(groupId, privateLayout, type,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", privateLayout=");
			msg.append(privateLayout);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLayoutException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param plid the primary key of the current layout
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next layout
	 * @throws com.liferay.portal.NoSuchLayoutException if a layout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Layout[] findByG_P_T_PrevAndNext(long plid, long groupId,
		boolean privateLayout, String type, OrderByComparator orderByComparator)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByPrimaryKey(plid);

		Session session = null;

		try {
			session = openSession();

			Layout[] array = new LayoutImpl[3];

			array[0] = getByG_P_T_PrevAndNext(session, layout, groupId,
					privateLayout, type, orderByComparator, true);

			array[1] = layout;

			array[2] = getByG_P_T_PrevAndNext(session, layout, groupId,
					privateLayout, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Layout getByG_P_T_PrevAndNext(Session session, Layout layout,
		long groupId, boolean privateLayout, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_G_P_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_T_PRIVATELAYOUT_2);

		if (type == null) {
			query.append(_FINDER_COLUMN_G_P_T_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_2);
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
			query.append(LayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(privateLayout);

		if (type != null) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(layout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @return the matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P_T(long groupId, boolean privateLayout,
		String type) throws SystemException {
		return filterFindByG_P_T(groupId, privateLayout, type,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P_T(long groupId, boolean privateLayout,
		String type, int start, int end) throws SystemException {
		return filterFindByG_P_T(groupId, privateLayout, type, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> filterFindByG_P_T(long groupId, boolean privateLayout,
		String type, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P_T(groupId, privateLayout, type, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LAYOUT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_T_PRIVATELAYOUT_2);

		if (type == null) {
			query.append(_FINDER_COLUMN_G_P_T_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LayoutModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LayoutModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LayoutImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LayoutImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(privateLayout);

			if (type != null) {
				qPos.add(type);
			}

			return (List<Layout>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the layouts.
	 *
	 * @return the layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @return the range of layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of layouts to return
	 * @param end the upper bound of the range of layouts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of layouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Layout> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Layout> list = (List<Layout>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LAYOUT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LAYOUT.concat(LayoutModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Layout>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Layout>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the layouts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Layout layout : findByUuid(uuid)) {
			remove(layout);
		}
	}

	/**
	 * Removes the layout where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByUUID_G(uuid, groupId);

		remove(layout);
	}

	/**
	 * Removes all the layouts where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Layout layout : findByGroupId(groupId)) {
			remove(layout);
		}
	}

	/**
	 * Removes all the layouts where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Layout layout : findByCompanyId(companyId)) {
			remove(layout);
		}
	}

	/**
	 * Removes the layout where dlFolderId = &#63; from the database.
	 *
	 * @param dlFolderId the dl folder id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDLFolderId(long dlFolderId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByDLFolderId(dlFolderId);

		remove(layout);
	}

	/**
	 * Removes the layout where iconImageId = &#63; from the database.
	 *
	 * @param iconImageId the icon image id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIconImageId(long iconImageId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByIconImageId(iconImageId);

		remove(layout);
	}

	/**
	 * Removes all the layouts where groupId = &#63; and privateLayout = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P(long groupId, boolean privateLayout)
		throws SystemException {
		for (Layout layout : findByG_P(groupId, privateLayout)) {
			remove(layout);
		}
	}

	/**
	 * Removes the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param layoutId the layout id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P_L(long groupId, boolean privateLayout, long layoutId)
		throws NoSuchLayoutException, SystemException {
		Layout layout = findByG_P_L(groupId, privateLayout, layoutId);

		remove(layout);
	}

	/**
	 * Removes all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId) throws SystemException {
		for (Layout layout : findByG_P_P(groupId, privateLayout, parentLayoutId)) {
			remove(layout);
		}
	}

	/**
	 * Removes the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param friendlyURL the friendly u r l to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL) throws NoSuchLayoutException, SystemException {
		Layout layout = findByG_P_F(groupId, privateLayout, friendlyURL);

		remove(layout);
	}

	/**
	 * Removes all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P_T(long groupId, boolean privateLayout, String type)
		throws SystemException {
		for (Layout layout : findByG_P_T(groupId, privateLayout, type)) {
			remove(layout);
		}
	}

	/**
	 * Removes all the layouts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Layout layout : findAll()) {
			remove(layout);
		}
	}

	/**
	 * Counts all the layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

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
	 * Counts all the layouts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

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
	 * Counts all the layouts where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

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
	 * Filters by the user's permissions and counts all the layouts where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
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
	 * Counts all the layouts where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

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
	 * Counts all the layouts where dlFolderId = &#63;.
	 *
	 * @param dlFolderId the dl folder id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDLFolderId(long dlFolderId) throws SystemException {
		Object[] finderArgs = new Object[] { dlFolderId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DLFOLDERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DLFOLDERID_DLFOLDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dlFolderId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DLFOLDERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the layouts where iconImageId = &#63;.
	 *
	 * @param iconImageId the icon image id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIconImageId(long iconImageId) throws SystemException {
		Object[] finderArgs = new Object[] { iconImageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ICONIMAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_ICONIMAGEID_ICONIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(iconImageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ICONIMAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P(long groupId, boolean privateLayout)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, privateLayout };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PRIVATELAYOUT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the layouts where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @return the number of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_P(long groupId, boolean privateLayout)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_P(groupId, privateLayout);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PRIVATELAYOUT_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(privateLayout);

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
	 * Counts all the layouts where groupId = &#63; and privateLayout = &#63; and layoutId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param layoutId the layout id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P_L(long groupId, boolean privateLayout, long layoutId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, privateLayout, layoutId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_L_PRIVATELAYOUT_2);

			query.append(_FINDER_COLUMN_G_P_L_LAYOUTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				qPos.add(layoutId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P_L,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, privateLayout, parentLayoutId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_P_PRIVATELAYOUT_2);

			query.append(_FINDER_COLUMN_G_P_P_PARENTLAYOUTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				qPos.add(parentLayoutId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param parentLayoutId the parent layout id to search with
	 * @return the number of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_P_P(groupId, privateLayout, parentLayoutId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_G_P_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_P_PRIVATELAYOUT_2);

		query.append(_FINDER_COLUMN_G_P_P_PARENTLAYOUTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(privateLayout);

			qPos.add(parentLayoutId);

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
	 * Counts all the layouts where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param friendlyURL the friendly u r l to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, privateLayout, friendlyURL };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P_F,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_F_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_F_PRIVATELAYOUT_2);

			if (friendlyURL == null) {
				query.append(_FINDER_COLUMN_G_P_F_FRIENDLYURL_1);
			}
			else {
				if (friendlyURL.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_P_F_FRIENDLYURL_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_P_F_FRIENDLYURL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				if (friendlyURL != null) {
					qPos.add(friendlyURL);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P_F,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @return the number of matching layouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P_T(long groupId, boolean privateLayout, String type)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, privateLayout, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LAYOUT_WHERE);

			query.append(_FINDER_COLUMN_G_P_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_T_PRIVATELAYOUT_2);

			if (type == null) {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_P_T_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_P_T_TYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(privateLayout);

				if (type != null) {
					qPos.add(type);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param privateLayout the private layout to search with
	 * @param type the type to search with
	 * @return the number of matching layouts that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_P_T(long groupId, boolean privateLayout,
		String type) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_P_T(groupId, privateLayout, type);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_LAYOUT_WHERE);

		query.append(_FINDER_COLUMN_G_P_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_T_PRIVATELAYOUT_2);

		if (type == null) {
			query.append(_FINDER_COLUMN_G_P_T_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_P_T_TYPE_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Layout.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(privateLayout);

			if (type != null) {
				qPos.add(type);
			}

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
	 * Counts all the layouts.
	 *
	 * @return the number of layouts
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

				Query q = session.createQuery(_SQL_COUNT_LAYOUT);

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
	 * Initializes the layout persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.Layout")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Layout>> listenersList = new ArrayList<ModelListener<Layout>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Layout>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LayoutImpl.class.getName());
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
	@BeanReference(type = DLFolderPersistence.class)
	protected DLFolderPersistence dlFolderPersistence;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
	@BeanReference(type = JournalContentSearchPersistence.class)
	protected JournalContentSearchPersistence journalContentSearchPersistence;
	@BeanReference(type = MBMessagePersistence.class)
	protected MBMessagePersistence mbMessagePersistence;
	@BeanReference(type = RatingsStatsPersistence.class)
	protected RatingsStatsPersistence ratingsStatsPersistence;
	@BeanReference(type = TasksProposalPersistence.class)
	protected TasksProposalPersistence tasksProposalPersistence;
	private static final String _SQL_SELECT_LAYOUT = "SELECT layout FROM Layout layout";
	private static final String _SQL_SELECT_LAYOUT_WHERE = "SELECT layout FROM Layout layout WHERE ";
	private static final String _SQL_COUNT_LAYOUT = "SELECT COUNT(layout) FROM Layout layout";
	private static final String _SQL_COUNT_LAYOUT_WHERE = "SELECT COUNT(layout) FROM Layout layout WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "layout.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "layout.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(layout.uuid IS NULL OR layout.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "layout.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "layout.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(layout.uuid IS NULL OR layout.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "layout.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "layout.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "layout.companyId = ?";
	private static final String _FINDER_COLUMN_DLFOLDERID_DLFOLDERID_2 = "layout.dlFolderId = ?";
	private static final String _FINDER_COLUMN_ICONIMAGEID_ICONIMAGEID_2 = "layout.iconImageId = ?";
	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "layout.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_PRIVATELAYOUT_2 = "layout.privateLayout = ?";
	private static final String _FINDER_COLUMN_G_P_L_GROUPID_2 = "layout.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_L_PRIVATELAYOUT_2 = "layout.privateLayout = ? AND ";
	private static final String _FINDER_COLUMN_G_P_L_LAYOUTID_2 = "layout.layoutId = ?";
	private static final String _FINDER_COLUMN_G_P_P_GROUPID_2 = "layout.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_P_PRIVATELAYOUT_2 = "layout.privateLayout = ? AND ";
	private static final String _FINDER_COLUMN_G_P_P_PARENTLAYOUTID_2 = "layout.parentLayoutId = ?";
	private static final String _FINDER_COLUMN_G_P_F_GROUPID_2 = "layout.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_F_PRIVATELAYOUT_2 = "layout.privateLayout = ? AND ";
	private static final String _FINDER_COLUMN_G_P_F_FRIENDLYURL_1 = "layout.friendlyURL IS NULL";
	private static final String _FINDER_COLUMN_G_P_F_FRIENDLYURL_2 = "layout.friendlyURL = ?";
	private static final String _FINDER_COLUMN_G_P_F_FRIENDLYURL_3 = "(layout.friendlyURL IS NULL OR layout.friendlyURL = ?)";
	private static final String _FINDER_COLUMN_G_P_T_GROUPID_2 = "layout.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_T_PRIVATELAYOUT_2 = "layout.privateLayout = ? AND ";
	private static final String _FINDER_COLUMN_G_P_T_TYPE_1 = "layout.type IS NULL";
	private static final String _FINDER_COLUMN_G_P_T_TYPE_2 = "layout.type = ?";
	private static final String _FINDER_COLUMN_G_P_T_TYPE_3 = "(layout.type IS NULL OR layout.type = ?)";
	private static final String _FILTER_SQL_SELECT_LAYOUT_WHERE = "SELECT DISTINCT {layout.*} FROM Layout layout WHERE ";
	private static final String _FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Layout.*} FROM (SELECT DISTINCT layout.plid FROM Layout layout WHERE ";
	private static final String _FILTER_SQL_SELECT_LAYOUT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Layout ON TEMP_TABLE.plid = Layout.plid";
	private static final String _FILTER_SQL_COUNT_LAYOUT_WHERE = "SELECT COUNT(DISTINCT layout.plid) AS COUNT_VALUE FROM Layout layout WHERE ";
	private static final String _FILTER_COLUMN_PK = "layout.plid";
	private static final String _FILTER_COLUMN_USERID = null;
	private static final String _FILTER_ENTITY_ALIAS = "layout";
	private static final String _FILTER_ENTITY_TABLE = "Layout";
	private static final String _ORDER_BY_ENTITY_ALIAS = "layout.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Layout.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Layout exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Layout exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(LayoutPersistenceImpl.class);
}