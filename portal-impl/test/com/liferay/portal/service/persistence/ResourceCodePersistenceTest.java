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

import com.liferay.portal.NoSuchResourceCodeException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ResourceCode;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceCodePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ResourceCodePersistence)PortalBeanLocatorUtil.locate(ResourceCodePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ResourceCode resourceCode = _persistence.create(pk);

		assertNotNull(resourceCode);

		assertEquals(resourceCode.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ResourceCode newResourceCode = addResourceCode();

		_persistence.remove(newResourceCode);

		ResourceCode existingResourceCode = _persistence.fetchByPrimaryKey(newResourceCode.getPrimaryKey());

		assertNull(existingResourceCode);
	}

	public void testUpdateNew() throws Exception {
		addResourceCode();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ResourceCode newResourceCode = _persistence.create(pk);

		newResourceCode.setCompanyId(nextLong());
		newResourceCode.setName(randomString());
		newResourceCode.setScope(nextInt());

		_persistence.update(newResourceCode, false);

		ResourceCode existingResourceCode = _persistence.findByPrimaryKey(newResourceCode.getPrimaryKey());

		assertEquals(existingResourceCode.getCodeId(),
			newResourceCode.getCodeId());
		assertEquals(existingResourceCode.getCompanyId(),
			newResourceCode.getCompanyId());
		assertEquals(existingResourceCode.getName(), newResourceCode.getName());
		assertEquals(existingResourceCode.getScope(), newResourceCode.getScope());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ResourceCode newResourceCode = addResourceCode();

		ResourceCode existingResourceCode = _persistence.findByPrimaryKey(newResourceCode.getPrimaryKey());

		assertEquals(existingResourceCode, newResourceCode);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchResourceCodeException");
		}
		catch (NoSuchResourceCodeException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ResourceCode newResourceCode = addResourceCode();

		ResourceCode existingResourceCode = _persistence.fetchByPrimaryKey(newResourceCode.getPrimaryKey());

		assertEquals(existingResourceCode, newResourceCode);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ResourceCode missingResourceCode = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingResourceCode);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ResourceCode newResourceCode = addResourceCode();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ResourceCode.class,
				ResourceCode.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("codeId",
				newResourceCode.getCodeId()));

		List<ResourceCode> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ResourceCode existingResourceCode = result.get(0);

		assertEquals(existingResourceCode, newResourceCode);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ResourceCode.class,
				ResourceCode.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("codeId", nextLong()));

		List<ResourceCode> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ResourceCode addResourceCode() throws Exception {
		long pk = nextLong();

		ResourceCode resourceCode = _persistence.create(pk);

		resourceCode.setCompanyId(nextLong());
		resourceCode.setName(randomString());
		resourceCode.setScope(nextInt());

		_persistence.update(resourceCode, false);

		return resourceCode;
	}

	private ResourceCodePersistence _persistence;
}