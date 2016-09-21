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

import com.liferay.portal.NoSuchListTypeException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ListType;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ListTypePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ListTypePersistence)PortalBeanLocatorUtil.locate(ListTypePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		int pk = nextInt();

		ListType listType = _persistence.create(pk);

		assertNotNull(listType);

		assertEquals(listType.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ListType newListType = addListType();

		_persistence.remove(newListType);

		ListType existingListType = _persistence.fetchByPrimaryKey(newListType.getPrimaryKey());

		assertNull(existingListType);
	}

	public void testUpdateNew() throws Exception {
		addListType();
	}

	public void testUpdateExisting() throws Exception {
		int pk = nextInt();

		ListType newListType = _persistence.create(pk);

		newListType.setName(randomString());
		newListType.setType(randomString());

		_persistence.update(newListType, false);

		ListType existingListType = _persistence.findByPrimaryKey(newListType.getPrimaryKey());

		assertEquals(existingListType.getListTypeId(),
			newListType.getListTypeId());
		assertEquals(existingListType.getName(), newListType.getName());
		assertEquals(existingListType.getType(), newListType.getType());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ListType newListType = addListType();

		ListType existingListType = _persistence.findByPrimaryKey(newListType.getPrimaryKey());

		assertEquals(existingListType, newListType);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		int pk = nextInt();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchListTypeException");
		}
		catch (NoSuchListTypeException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ListType newListType = addListType();

		ListType existingListType = _persistence.fetchByPrimaryKey(newListType.getPrimaryKey());

		assertEquals(existingListType, newListType);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		int pk = nextInt();

		ListType missingListType = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingListType);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ListType newListType = addListType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ListType.class,
				ListType.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("listTypeId",
				newListType.getListTypeId()));

		List<ListType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ListType existingListType = result.get(0);

		assertEquals(existingListType, newListType);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ListType.class,
				ListType.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("listTypeId", nextInt()));

		List<ListType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ListType addListType() throws Exception {
		int pk = nextInt();

		ListType listType = _persistence.create(pk);

		listType.setName(randomString());
		listType.setType(randomString());

		_persistence.update(listType, false);

		return listType;
	}

	private ListTypePersistence _persistence;
}