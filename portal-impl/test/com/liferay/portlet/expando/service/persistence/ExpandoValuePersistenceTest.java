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

package com.liferay.portlet.expando.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.expando.NoSuchValueException;
import com.liferay.portlet.expando.model.ExpandoValue;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpandoValuePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ExpandoValuePersistence)PortalBeanLocatorUtil.locate(ExpandoValuePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ExpandoValue expandoValue = _persistence.create(pk);

		assertNotNull(expandoValue);

		assertEquals(expandoValue.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ExpandoValue newExpandoValue = addExpandoValue();

		_persistence.remove(newExpandoValue);

		ExpandoValue existingExpandoValue = _persistence.fetchByPrimaryKey(newExpandoValue.getPrimaryKey());

		assertNull(existingExpandoValue);
	}

	public void testUpdateNew() throws Exception {
		addExpandoValue();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ExpandoValue newExpandoValue = _persistence.create(pk);

		newExpandoValue.setCompanyId(nextLong());
		newExpandoValue.setTableId(nextLong());
		newExpandoValue.setColumnId(nextLong());
		newExpandoValue.setRowId(nextLong());
		newExpandoValue.setClassNameId(nextLong());
		newExpandoValue.setClassPK(nextLong());
		newExpandoValue.setData(randomString());

		_persistence.update(newExpandoValue, false);

		ExpandoValue existingExpandoValue = _persistence.findByPrimaryKey(newExpandoValue.getPrimaryKey());

		assertEquals(existingExpandoValue.getValueId(),
			newExpandoValue.getValueId());
		assertEquals(existingExpandoValue.getCompanyId(),
			newExpandoValue.getCompanyId());
		assertEquals(existingExpandoValue.getTableId(),
			newExpandoValue.getTableId());
		assertEquals(existingExpandoValue.getColumnId(),
			newExpandoValue.getColumnId());
		assertEquals(existingExpandoValue.getRowId(), newExpandoValue.getRowId());
		assertEquals(existingExpandoValue.getClassNameId(),
			newExpandoValue.getClassNameId());
		assertEquals(existingExpandoValue.getClassPK(),
			newExpandoValue.getClassPK());
		assertEquals(existingExpandoValue.getData(), newExpandoValue.getData());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ExpandoValue newExpandoValue = addExpandoValue();

		ExpandoValue existingExpandoValue = _persistence.findByPrimaryKey(newExpandoValue.getPrimaryKey());

		assertEquals(existingExpandoValue, newExpandoValue);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchValueException");
		}
		catch (NoSuchValueException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ExpandoValue newExpandoValue = addExpandoValue();

		ExpandoValue existingExpandoValue = _persistence.fetchByPrimaryKey(newExpandoValue.getPrimaryKey());

		assertEquals(existingExpandoValue, newExpandoValue);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ExpandoValue missingExpandoValue = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingExpandoValue);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ExpandoValue newExpandoValue = addExpandoValue();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class,
				ExpandoValue.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("valueId",
				newExpandoValue.getValueId()));

		List<ExpandoValue> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ExpandoValue existingExpandoValue = result.get(0);

		assertEquals(existingExpandoValue, newExpandoValue);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class,
				ExpandoValue.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("valueId", nextLong()));

		List<ExpandoValue> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ExpandoValue addExpandoValue() throws Exception {
		long pk = nextLong();

		ExpandoValue expandoValue = _persistence.create(pk);

		expandoValue.setCompanyId(nextLong());
		expandoValue.setTableId(nextLong());
		expandoValue.setColumnId(nextLong());
		expandoValue.setRowId(nextLong());
		expandoValue.setClassNameId(nextLong());
		expandoValue.setClassPK(nextLong());
		expandoValue.setData(randomString());

		_persistence.update(expandoValue, false);

		return expandoValue;
	}

	private ExpandoValuePersistence _persistence;
}