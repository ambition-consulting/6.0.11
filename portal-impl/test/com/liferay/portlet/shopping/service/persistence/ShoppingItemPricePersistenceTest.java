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

import com.liferay.portlet.shopping.NoSuchItemPriceException;
import com.liferay.portlet.shopping.model.ShoppingItemPrice;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemPricePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ShoppingItemPricePersistence)PortalBeanLocatorUtil.locate(ShoppingItemPricePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ShoppingItemPrice shoppingItemPrice = _persistence.create(pk);

		assertNotNull(shoppingItemPrice);

		assertEquals(shoppingItemPrice.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ShoppingItemPrice newShoppingItemPrice = addShoppingItemPrice();

		_persistence.remove(newShoppingItemPrice);

		ShoppingItemPrice existingShoppingItemPrice = _persistence.fetchByPrimaryKey(newShoppingItemPrice.getPrimaryKey());

		assertNull(existingShoppingItemPrice);
	}

	public void testUpdateNew() throws Exception {
		addShoppingItemPrice();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ShoppingItemPrice newShoppingItemPrice = _persistence.create(pk);

		newShoppingItemPrice.setItemId(nextLong());
		newShoppingItemPrice.setMinQuantity(nextInt());
		newShoppingItemPrice.setMaxQuantity(nextInt());
		newShoppingItemPrice.setPrice(nextDouble());
		newShoppingItemPrice.setDiscount(nextDouble());
		newShoppingItemPrice.setTaxable(randomBoolean());
		newShoppingItemPrice.setShipping(nextDouble());
		newShoppingItemPrice.setUseShippingFormula(randomBoolean());
		newShoppingItemPrice.setStatus(nextInt());

		_persistence.update(newShoppingItemPrice, false);

		ShoppingItemPrice existingShoppingItemPrice = _persistence.findByPrimaryKey(newShoppingItemPrice.getPrimaryKey());

		assertEquals(existingShoppingItemPrice.getItemPriceId(),
			newShoppingItemPrice.getItemPriceId());
		assertEquals(existingShoppingItemPrice.getItemId(),
			newShoppingItemPrice.getItemId());
		assertEquals(existingShoppingItemPrice.getMinQuantity(),
			newShoppingItemPrice.getMinQuantity());
		assertEquals(existingShoppingItemPrice.getMaxQuantity(),
			newShoppingItemPrice.getMaxQuantity());
		assertEquals(existingShoppingItemPrice.getPrice(),
			newShoppingItemPrice.getPrice());
		assertEquals(existingShoppingItemPrice.getDiscount(),
			newShoppingItemPrice.getDiscount());
		assertEquals(existingShoppingItemPrice.getTaxable(),
			newShoppingItemPrice.getTaxable());
		assertEquals(existingShoppingItemPrice.getShipping(),
			newShoppingItemPrice.getShipping());
		assertEquals(existingShoppingItemPrice.getUseShippingFormula(),
			newShoppingItemPrice.getUseShippingFormula());
		assertEquals(existingShoppingItemPrice.getStatus(),
			newShoppingItemPrice.getStatus());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ShoppingItemPrice newShoppingItemPrice = addShoppingItemPrice();

		ShoppingItemPrice existingShoppingItemPrice = _persistence.findByPrimaryKey(newShoppingItemPrice.getPrimaryKey());

		assertEquals(existingShoppingItemPrice, newShoppingItemPrice);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchItemPriceException");
		}
		catch (NoSuchItemPriceException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ShoppingItemPrice newShoppingItemPrice = addShoppingItemPrice();

		ShoppingItemPrice existingShoppingItemPrice = _persistence.fetchByPrimaryKey(newShoppingItemPrice.getPrimaryKey());

		assertEquals(existingShoppingItemPrice, newShoppingItemPrice);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ShoppingItemPrice missingShoppingItemPrice = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingShoppingItemPrice);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ShoppingItemPrice newShoppingItemPrice = addShoppingItemPrice();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ShoppingItemPrice.class,
				ShoppingItemPrice.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("itemPriceId",
				newShoppingItemPrice.getItemPriceId()));

		List<ShoppingItemPrice> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ShoppingItemPrice existingShoppingItemPrice = result.get(0);

		assertEquals(existingShoppingItemPrice, newShoppingItemPrice);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ShoppingItemPrice.class,
				ShoppingItemPrice.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("itemPriceId", nextLong()));

		List<ShoppingItemPrice> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ShoppingItemPrice addShoppingItemPrice()
		throws Exception {
		long pk = nextLong();

		ShoppingItemPrice shoppingItemPrice = _persistence.create(pk);

		shoppingItemPrice.setItemId(nextLong());
		shoppingItemPrice.setMinQuantity(nextInt());
		shoppingItemPrice.setMaxQuantity(nextInt());
		shoppingItemPrice.setPrice(nextDouble());
		shoppingItemPrice.setDiscount(nextDouble());
		shoppingItemPrice.setTaxable(randomBoolean());
		shoppingItemPrice.setShipping(nextDouble());
		shoppingItemPrice.setUseShippingFormula(randomBoolean());
		shoppingItemPrice.setStatus(nextInt());

		_persistence.update(shoppingItemPrice, false);

		return shoppingItemPrice;
	}

	private ShoppingItemPricePersistence _persistence;
}