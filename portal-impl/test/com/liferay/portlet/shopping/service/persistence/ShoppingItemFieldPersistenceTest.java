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

package com.liferay.portlet.shopping.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.shopping.NoSuchItemFieldException;
import com.liferay.portlet.shopping.model.ShoppingItemField;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemFieldPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ShoppingItemFieldPersistence)PortalBeanLocatorUtil.locate(ShoppingItemFieldPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ShoppingItemField shoppingItemField = _persistence.create(pk);

		assertNotNull(shoppingItemField);

		assertEquals(shoppingItemField.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ShoppingItemField newShoppingItemField = addShoppingItemField();

		_persistence.remove(newShoppingItemField);

		ShoppingItemField existingShoppingItemField = _persistence.fetchByPrimaryKey(newShoppingItemField.getPrimaryKey());

		assertNull(existingShoppingItemField);
	}

	public void testUpdateNew() throws Exception {
		addShoppingItemField();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ShoppingItemField newShoppingItemField = _persistence.create(pk);

		newShoppingItemField.setItemId(nextLong());
		newShoppingItemField.setName(randomString());
		newShoppingItemField.setValues(randomString());
		newShoppingItemField.setDescription(randomString());

		_persistence.update(newShoppingItemField, false);

		ShoppingItemField existingShoppingItemField = _persistence.findByPrimaryKey(newShoppingItemField.getPrimaryKey());

		assertEquals(existingShoppingItemField.getItemFieldId(),
			newShoppingItemField.getItemFieldId());
		assertEquals(existingShoppingItemField.getItemId(),
			newShoppingItemField.getItemId());
		assertEquals(existingShoppingItemField.getName(),
			newShoppingItemField.getName());
		assertEquals(existingShoppingItemField.getValues(),
			newShoppingItemField.getValues());
		assertEquals(existingShoppingItemField.getDescription(),
			newShoppingItemField.getDescription());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ShoppingItemField newShoppingItemField = addShoppingItemField();

		ShoppingItemField existingShoppingItemField = _persistence.findByPrimaryKey(newShoppingItemField.getPrimaryKey());

		assertEquals(existingShoppingItemField, newShoppingItemField);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchItemFieldException");
		}
		catch (NoSuchItemFieldException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ShoppingItemField newShoppingItemField = addShoppingItemField();

		ShoppingItemField existingShoppingItemField = _persistence.fetchByPrimaryKey(newShoppingItemField.getPrimaryKey());

		assertEquals(existingShoppingItemField, newShoppingItemField);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ShoppingItemField missingShoppingItemField = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingShoppingItemField);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ShoppingItemField newShoppingItemField = addShoppingItemField();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ShoppingItemField.class,
				ShoppingItemField.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("itemFieldId",
				newShoppingItemField.getItemFieldId()));

		List<ShoppingItemField> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ShoppingItemField existingShoppingItemField = result.get(0);

		assertEquals(existingShoppingItemField, newShoppingItemField);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ShoppingItemField.class,
				ShoppingItemField.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("itemFieldId", nextLong()));

		List<ShoppingItemField> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ShoppingItemField addShoppingItemField()
		throws Exception {
		long pk = nextLong();

		ShoppingItemField shoppingItemField = _persistence.create(pk);

		shoppingItemField.setItemId(nextLong());
		shoppingItemField.setName(randomString());
		shoppingItemField.setValues(randomString());
		shoppingItemField.setDescription(randomString());

		_persistence.update(shoppingItemField, false);

		return shoppingItemField;
	}

	private ShoppingItemFieldPersistence _persistence;
}