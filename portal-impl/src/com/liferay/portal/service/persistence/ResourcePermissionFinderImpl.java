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

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.impl.ResourcePermissionImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourcePermissionFinderImpl
	extends BasePersistenceImpl<ResourcePermission>
	implements ResourcePermissionFinder {

	public static String COUNT_BY_R_S =
		ResourcePermissionFinder.class.getName() + ".countByR_S";

	public static String FIND_BY_R_S =
		ResourcePermissionFinder.class.getName() + ".findByR_S";

	public int countByR_S(long roleId, int[] scopes) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_R_S);

			sql = StringUtil.replace(sql, "[$SCOPE$]", getScopes(scopes));

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);
			qPos.add(scopes);

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

	public List<ResourcePermission> findByR_S(
			long roleId, int[] scopes, int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_R_S);

			sql = StringUtil.replace(sql, "[$SCOPE$]", getScopes(scopes));

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("ResourcePermission", ResourcePermissionImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);
			qPos.add(scopes);

			return (List<ResourcePermission>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected String getScopes(int[] scopes) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < scopes.length; i++) {
			sb.append("scope = ? ");

			if ((i + 1) != scopes.length) {
				sb.append("OR ");
			}
		}

		return sb.toString();
	}

}