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

import com.liferay.portal.NoSuchClassNameException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassNamePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ClassNamePersistence)PortalBeanLocatorUtil.locate(ClassNamePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ClassName className = _persistence.create(pk);

		assertNotNull(className);

		assertEquals(className.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ClassName newClassName = addClassName();

		_persistence.remove(newClassName);

		ClassName existingClassName = _persistence.fetchByPrimaryKey(newClassName.getPrimaryKey());

		assertNull(existingClassName);
	}

	public void testUpdateNew() throws Exception {
		addClassName();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ClassName newClassName = _persistence.create(pk);

		newClassName.setValue(randomString());

		_persistence.update(newClassName, false);

		ClassName existingClassName = _persistence.findByPrimaryKey(newClassName.getPrimaryKey());

		assertEquals(existingClassName.getClassNameId(),
			newClassName.getClassNameId());
		assertEquals(existingClassName.getValue(), newClassName.getValue());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ClassName newClassName = addClassName();

		ClassName existingClassName = _persistence.findByPrimaryKey(newClassName.getPrimaryKey());

		assertEquals(existingClassName, newClassName);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchClassNameException");
		}
		catch (NoSuchClassNameException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ClassName newClassName = addClassName();

		ClassName existingClassName = _persistence.fetchByPrimaryKey(newClassName.getPrimaryKey());

		assertEquals(existingClassName, newClassName);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ClassName missingClassName = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingClassName);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ClassName newClassName = addClassName();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ClassName.class,
				ClassName.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId",
				newClassName.getClassNameId()));

		List<ClassName> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ClassName existingClassName = result.get(0);

		assertEquals(existingClassName, newClassName);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ClassName.class,
				ClassName.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId", nextLong()));

		List<ClassName> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ClassName addClassName() throws Exception {
		long pk = nextLong();

		ClassName className = _persistence.create(pk);

		className.setValue(randomString());

		_persistence.update(className, false);

		return className;
	}

	private ClassNamePersistence _persistence;
}