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

package com.liferay.portal.dao.orm.jpa;

import com.liferay.portal.kernel.dao.orm.ORMException;

import java.sql.Connection;

import javax.persistence.EntityManager;

/**
 * @author Prashant Dighe
 * @author Brian Wing Shun Chan
 */
public class NewSessionImpl extends SessionImpl {

	public NewSessionImpl(EntityManager entityManager) {
		_entityManager = entityManager;

		_entityManager.getTransaction().begin();
	}

	public Connection close() throws ORMException {
		try {
			_entityManager.getTransaction().commit();

			_entityManager.close();

			return null;
		}
		catch (Exception e) {
			throw ExceptionTranslator.translate(e);
		}
	}

}