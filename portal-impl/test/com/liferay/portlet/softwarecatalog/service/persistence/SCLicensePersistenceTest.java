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

package com.liferay.portlet.softwarecatalog.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.softwarecatalog.NoSuchLicenseException;
import com.liferay.portlet.softwarecatalog.model.SCLicense;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SCLicensePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SCLicensePersistence)PortalBeanLocatorUtil.locate(SCLicensePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SCLicense scLicense = _persistence.create(pk);

		assertNotNull(scLicense);

		assertEquals(scLicense.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SCLicense newSCLicense = addSCLicense();

		_persistence.remove(newSCLicense);

		SCLicense existingSCLicense = _persistence.fetchByPrimaryKey(newSCLicense.getPrimaryKey());

		assertNull(existingSCLicense);
	}

	public void testUpdateNew() throws Exception {
		addSCLicense();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SCLicense newSCLicense = _persistence.create(pk);

		newSCLicense.setName(randomString());
		newSCLicense.setUrl(randomString());
		newSCLicense.setOpenSource(randomBoolean());
		newSCLicense.setActive(randomBoolean());
		newSCLicense.setRecommended(randomBoolean());

		_persistence.update(newSCLicense, false);

		SCLicense existingSCLicense = _persistence.findByPrimaryKey(newSCLicense.getPrimaryKey());

		assertEquals(existingSCLicense.getLicenseId(),
			newSCLicense.getLicenseId());
		assertEquals(existingSCLicense.getName(), newSCLicense.getName());
		assertEquals(existingSCLicense.getUrl(), newSCLicense.getUrl());
		assertEquals(existingSCLicense.getOpenSource(),
			newSCLicense.getOpenSource());
		assertEquals(existingSCLicense.getActive(), newSCLicense.getActive());
		assertEquals(existingSCLicense.getRecommended(),
			newSCLicense.getRecommended());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SCLicense newSCLicense = addSCLicense();

		SCLicense existingSCLicense = _persistence.findByPrimaryKey(newSCLicense.getPrimaryKey());

		assertEquals(existingSCLicense, newSCLicense);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchLicenseException");
		}
		catch (NoSuchLicenseException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SCLicense newSCLicense = addSCLicense();

		SCLicense existingSCLicense = _persistence.fetchByPrimaryKey(newSCLicense.getPrimaryKey());

		assertEquals(existingSCLicense, newSCLicense);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SCLicense missingSCLicense = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSCLicense);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SCLicense newSCLicense = addSCLicense();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SCLicense.class,
				SCLicense.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("licenseId",
				newSCLicense.getLicenseId()));

		List<SCLicense> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SCLicense existingSCLicense = result.get(0);

		assertEquals(existingSCLicense, newSCLicense);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SCLicense.class,
				SCLicense.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("licenseId", nextLong()));

		List<SCLicense> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SCLicense addSCLicense() throws Exception {
		long pk = nextLong();

		SCLicense scLicense = _persistence.create(pk);

		scLicense.setName(randomString());
		scLicense.setUrl(randomString());
		scLicense.setOpenSource(randomBoolean());
		scLicense.setActive(randomBoolean());
		scLicense.setRecommended(randomBoolean());

		_persistence.update(scLicense, false);

		return scLicense;
	}

	private SCLicensePersistence _persistence;
}