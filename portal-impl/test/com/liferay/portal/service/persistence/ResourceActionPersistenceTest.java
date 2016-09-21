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

import com.liferay.portal.NoSuchResourceActionException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceActionPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ResourceActionPersistence)PortalBeanLocatorUtil.locate(ResourceActionPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ResourceAction resourceAction = _persistence.create(pk);

		assertNotNull(resourceAction);

		assertEquals(resourceAction.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ResourceAction newResourceAction = addResourceAction();

		_persistence.remove(newResourceAction);

		ResourceAction existingResourceAction = _persistence.fetchByPrimaryKey(newResourceAction.getPrimaryKey());

		assertNull(existingResourceAction);
	}

	public void testUpdateNew() throws Exception {
		addResourceAction();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ResourceAction newResourceAction = _persistence.create(pk);

		newResourceAction.setName(randomString());
		newResourceAction.setActionId(randomString());
		newResourceAction.setBitwiseValue(nextLong());

		_persistence.update(newResourceAction, false);

		ResourceAction existingResourceAction = _persistence.findByPrimaryKey(newResourceAction.getPrimaryKey());

		assertEquals(existingResourceAction.getResourceActionId(),
			newResourceAction.getResourceActionId());
		assertEquals(existingResourceAction.getName(),
			newResourceAction.getName());
		assertEquals(existingResourceAction.getActionId(),
			newResourceAction.getActionId());
		assertEquals(existingResourceAction.getBitwiseValue(),
			newResourceAction.getBitwiseValue());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ResourceAction newResourceAction = addResourceAction();

		ResourceAction existingResourceAction = _persistence.findByPrimaryKey(newResourceAction.getPrimaryKey());

		assertEquals(existingResourceAction, newResourceAction);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchResourceActionException");
		}
		catch (NoSuchResourceActionException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ResourceAction newResourceAction = addResourceAction();

		ResourceAction existingResourceAction = _persistence.fetchByPrimaryKey(newResourceAction.getPrimaryKey());

		assertEquals(existingResourceAction, newResourceAction);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ResourceAction missingResourceAction = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingResourceAction);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ResourceAction newResourceAction = addResourceAction();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ResourceAction.class,
				ResourceAction.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourceActionId",
				newResourceAction.getResourceActionId()));

		List<ResourceAction> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ResourceAction existingResourceAction = result.get(0);

		assertEquals(existingResourceAction, newResourceAction);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ResourceAction.class,
				ResourceAction.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourceActionId",
				nextLong()));

		List<ResourceAction> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ResourceAction addResourceAction() throws Exception {
		long pk = nextLong();

		ResourceAction resourceAction = _persistence.create(pk);

		resourceAction.setName(randomString());
		resourceAction.setActionId(randomString());
		resourceAction.setBitwiseValue(nextLong());

		_persistence.update(resourceAction, false);

		return resourceAction;
	}

	private ResourceActionPersistence _persistence;
}