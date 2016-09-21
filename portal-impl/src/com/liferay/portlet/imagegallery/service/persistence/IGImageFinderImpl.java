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

package com.liferay.portlet.imagegallery.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.imagegallery.NoSuchImageException;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.model.impl.IGImageImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class IGImageFinderImpl
	extends BasePersistenceImpl<IGImage> implements IGImageFinder {

	public static String FIND_BY_ANY_IMAGE_ID =
		IGImageFinder.class.getName() + ".findByAnyImageId";

	public static String FIND_BY_NO_ASSETS =
		IGImageFinder.class.getName() + ".findByNoAssets";

	public IGImage fetchByAnyImageId(long imageId) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ANY_IMAGE_ID);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("IGImage", IGImageImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(imageId);
			qPos.add(imageId);
			qPos.add(imageId);
			qPos.add(imageId);

			List<IGImage> list = q.list();

			if (list.isEmpty()) {
				return null;
			}
			else {
				return list.get(0);
			}
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public IGImage findByAnyImageId(long imageId)
		throws NoSuchImageException, SystemException {

		IGImage image = fetchByAnyImageId(imageId);

		if (image == null) {
			throw new NoSuchImageException(
				"No IGImage exists with the imageId " + imageId);
		}
		else {
			return image;
		}
	}

	public List<IGImage> findByNoAssets() throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NO_ASSETS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("IGImage", IGImageImpl.class);

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