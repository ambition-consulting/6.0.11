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

package com.liferay.portlet.asset.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.impl.AssetCategoryImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 * @author Jorge Ferrer
 */
public class AssetCategoryFinderImpl
	extends BasePersistenceImpl<AssetCategory> implements AssetCategoryFinder {

	public static String COUNT_BY_G_C_N =
		AssetCategoryFinder.class.getName() + ".countByG_C_N";

	public static String COUNT_BY_G_N_P =
		AssetCategoryFinder.class.getName() + ".countByG_N_P";

	public static String FIND_BY_ENTRY_ID =
		AssetCategoryFinder.class.getName() + ".findByEntryId";

	public static String FIND_BY_G_N =
		AssetCategoryFinder.class.getName() + ".findByG_N";

	public static String FIND_BY_C_C =
		AssetCategoryFinder.class.getName() + ".findByC_C";

	public static String FIND_BY_G_N_P =
		AssetCategoryFinder.class.getName() + ".findByG_N_P";

	public int countByG_C_N(long groupId, long classNameId, String name)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_G_C_N);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(classNameId);
			qPos.add(name);
			qPos.add(name);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByG_N_P(
			long groupId, String name, String[] categoryProperties)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_G_N_P);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			setJoin(qPos, categoryProperties);
			qPos.add(groupId);
			qPos.add(name);
			qPos.add(name);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<AssetCategory> findByEntryId(long entryId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ENTRY_ID);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("AssetCategory", AssetCategoryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(entryId);

			return (List<AssetCategory>) QueryUtil.list(
				q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public AssetCategory findByG_N(long groupId, String name)
		throws NoSuchCategoryException, SystemException {

		name = name.trim().toLowerCase();

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_G_N);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("AssetCategory", AssetCategoryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(name);

			List<AssetCategory> list = q.list();

			if (list.size() == 0) {
				StringBundler sb = new StringBundler(6);

				sb.append("No AssetCategory exists with the key ");
				sb.append("{groupId=");
				sb.append(groupId);
				sb.append(", name=");
				sb.append(name);
				sb.append("}");

				throw new NoSuchCategoryException(sb.toString());
			}
			else {
				return list.get(0);
			}
		}
		catch (NoSuchCategoryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<AssetCategory> findByC_C(long classNameId, long classPK)
		throws SystemException {

		Session session = null;

		try {
			AssetEntry entry = AssetEntryUtil.fetchByC_C(
				classNameId, classPK);

			if (entry == null) {
				return Collections.EMPTY_LIST;
			}

			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_C);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("AssetCategory", AssetCategoryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(entry.getEntryId());

			return (List<AssetCategory>)QueryUtil.list(
				q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<AssetCategory> findByG_N_P(
			long groupId, String name, String[] categoryProperties)
		throws SystemException {

		return findByG_N_P(
			groupId, name, categoryProperties, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<AssetCategory> findByG_N_P(
			long groupId, String name, String[] categoryProperties, int start,
			int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_G_N_P);

			sql = StringUtil.replace(
				sql, "[$JOIN$]", getJoin(categoryProperties));

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("AssetCategory", AssetCategoryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			setJoin(qPos, categoryProperties);
			qPos.add(groupId);
			qPos.add(name);
			qPos.add(name);

			return (List<AssetCategory>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected String getJoin(String[] categoryProperties) {
		if (categoryProperties.length == 0) {
			return StringPool.BLANK;
		}
		else {
			StringBundler sb = new StringBundler(
				categoryProperties.length * 3 + 2);

			sb.append(" INNER JOIN AssetCategoryProperty ON ");
			sb.append(" (AssetCategoryProperty.categoryId = ");
			sb.append(" AssetCategory.categoryId) AND ");

			for (int i = 0; i < categoryProperties.length; i++) {
				sb.append("(AssetCategoryProperty.key_ = ? AND ");
				sb.append("AssetCategoryProperty.value = ?) ");

				if ((i + 1) < categoryProperties.length) {
					sb.append(" AND ");
				}
			}

			return sb.toString();
		}
	}

	protected void setJoin(QueryPos qPos, String[] categoryProperties) {
		for (int i = 0; i < categoryProperties.length; i++) {
			String[] categoryProperty = StringUtil.split(
				categoryProperties[i], StringPool.COLON);

			String key = StringPool.BLANK;

			if (categoryProperty.length > 0) {
				key = GetterUtil.getString(categoryProperty[0]);
			}

			String value = StringPool.BLANK;

			if (categoryProperty.length > 1) {
				value = GetterUtil.getString(categoryProperty[1]);
			}

			qPos.add(key);
			qPos.add(value);
		}
	}

}