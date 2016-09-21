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

import com.liferay.portal.NoSuchServiceComponentException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ServiceComponent;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ServiceComponentPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ServiceComponentPersistence)PortalBeanLocatorUtil.locate(ServiceComponentPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ServiceComponent serviceComponent = _persistence.create(pk);

		assertNotNull(serviceComponent);

		assertEquals(serviceComponent.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ServiceComponent newServiceComponent = addServiceComponent();

		_persistence.remove(newServiceComponent);

		ServiceComponent existingServiceComponent = _persistence.fetchByPrimaryKey(newServiceComponent.getPrimaryKey());

		assertNull(existingServiceComponent);
	}

	public void testUpdateNew() throws Exception {
		addServiceComponent();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ServiceComponent newServiceComponent = _persistence.create(pk);

		newServiceComponent.setBuildNamespace(randomString());
		newServiceComponent.setBuildNumber(nextLong());
		newServiceComponent.setBuildDate(nextLong());
		newServiceComponent.setData(randomString());

		_persistence.update(newServiceComponent, false);

		ServiceComponent existingServiceComponent = _persistence.findByPrimaryKey(newServiceComponent.getPrimaryKey());

		assertEquals(existingServiceComponent.getServiceComponentId(),
			newServiceComponent.getServiceComponentId());
		assertEquals(existingServiceComponent.getBuildNamespace(),
			newServiceComponent.getBuildNamespace());
		assertEquals(existingServiceComponent.getBuildNumber(),
			newServiceComponent.getBuildNumber());
		assertEquals(existingServiceComponent.getBuildDate(),
			newServiceComponent.getBuildDate());
		assertEquals(existingServiceComponent.getData(),
			newServiceComponent.getData());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ServiceComponent newServiceComponent = addServiceComponent();

		ServiceComponent existingServiceComponent = _persistence.findByPrimaryKey(newServiceComponent.getPrimaryKey());

		assertEquals(existingServiceComponent, newServiceComponent);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchServiceComponentException");
		}
		catch (NoSuchServiceComponentException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ServiceComponent newServiceComponent = addServiceComponent();

		ServiceComponent existingServiceComponent = _persistence.fetchByPrimaryKey(newServiceComponent.getPrimaryKey());

		assertEquals(existingServiceComponent, newServiceComponent);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ServiceComponent missingServiceComponent = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingServiceComponent);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ServiceComponent newServiceComponent = addServiceComponent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ServiceComponent.class,
				ServiceComponent.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("serviceComponentId",
				newServiceComponent.getServiceComponentId()));

		List<ServiceComponent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ServiceComponent existingServiceComponent = result.get(0);

		assertEquals(existingServiceComponent, newServiceComponent);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ServiceComponent.class,
				ServiceComponent.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("serviceComponentId",
				nextLong()));

		List<ServiceComponent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ServiceComponent addServiceComponent() throws Exception {
		long pk = nextLong();

		ServiceComponent serviceComponent = _persistence.create(pk);

		serviceComponent.setBuildNamespace(randomString());
		serviceComponent.setBuildNumber(nextLong());
		serviceComponent.setBuildDate(nextLong());
		serviceComponent.setData(randomString());

		_persistence.update(serviceComponent, false);

		return serviceComponent;
	}

	private ServiceComponentPersistence _persistence;
}