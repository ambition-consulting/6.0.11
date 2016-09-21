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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.model.impl.PortletPreferencesImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletPreferencesFinderImpl
	extends BasePersistenceImpl<PortletPreferences>
	implements PortletPreferencesFinder {

	public static String FIND_BY_PORTLETID =
		PortletPreferencesFinder.class.getName() + ".findByPortletId";

	public List<PortletPreferences> findByPortletId(String portletId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_PORTLETID);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("PortletPreferences", PortletPreferencesImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(portletId);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}