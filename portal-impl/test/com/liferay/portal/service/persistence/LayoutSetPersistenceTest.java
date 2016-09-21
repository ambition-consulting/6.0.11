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

import com.liferay.portal.NoSuchLayoutSetException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutSetPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (LayoutSetPersistence)PortalBeanLocatorUtil.locate(LayoutSetPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		LayoutSet layoutSet = _persistence.create(pk);

		assertNotNull(layoutSet);

		assertEquals(layoutSet.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		LayoutSet newLayoutSet = addLayoutSet();

		_persistence.remove(newLayoutSet);

		LayoutSet existingLayoutSet = _persistence.fetchByPrimaryKey(newLayoutSet.getPrimaryKey());

		assertNull(existingLayoutSet);
	}

	public void testUpdateNew() throws Exception {
		addLayoutSet();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		LayoutSet newLayoutSet = _persistence.create(pk);

		newLayoutSet.setGroupId(nextLong());
		newLayoutSet.setCompanyId(nextLong());
		newLayoutSet.setPrivateLayout(randomBoolean());
		newLayoutSet.setLogo(randomBoolean());
		newLayoutSet.setLogoId(nextLong());
		newLayoutSet.setThemeId(randomString());
		newLayoutSet.setColorSchemeId(randomString());
		newLayoutSet.setWapThemeId(randomString());
		newLayoutSet.setWapColorSchemeId(randomString());
		newLayoutSet.setCss(randomString());
		newLayoutSet.setPageCount(nextInt());
		newLayoutSet.setVirtualHost(randomString());
		newLayoutSet.setSettings(randomString());
		newLayoutSet.setLayoutSetPrototypeId(nextLong());

		_persistence.update(newLayoutSet, false);

		LayoutSet existingLayoutSet = _persistence.findByPrimaryKey(newLayoutSet.getPrimaryKey());

		assertEquals(existingLayoutSet.getLayoutSetId(),
			newLayoutSet.getLayoutSetId());
		assertEquals(existingLayoutSet.getGroupId(), newLayoutSet.getGroupId());
		assertEquals(existingLayoutSet.getCompanyId(),
			newLayoutSet.getCompanyId());
		assertEquals(existingLayoutSet.getPrivateLayout(),
			newLayoutSet.getPrivateLayout());
		assertEquals(existingLayoutSet.getLogo(), newLayoutSet.getLogo());
		assertEquals(existingLayoutSet.getLogoId(), newLayoutSet.getLogoId());
		assertEquals(existingLayoutSet.getThemeId(), newLayoutSet.getThemeId());
		assertEquals(existingLayoutSet.getColorSchemeId(),
			newLayoutSet.getColorSchemeId());
		assertEquals(existingLayoutSet.getWapThemeId(),
			newLayoutSet.getWapThemeId());
		assertEquals(existingLayoutSet.getWapColorSchemeId(),
			newLayoutSet.getWapColorSchemeId());
		assertEquals(existingLayoutSet.getCss(), newLayoutSet.getCss());
		assertEquals(existingLayoutSet.getPageCount(),
			newLayoutSet.getPageCount());
		assertEquals(existingLayoutSet.getVirtualHost(),
			newLayoutSet.getVirtualHost());
		assertEquals(existingLayoutSet.getSettings(), newLayoutSet.getSettings());
		assertEquals(existingLayoutSet.getLayoutSetPrototypeId(),
			newLayoutSet.getLayoutSetPrototypeId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		LayoutSet newLayoutSet = addLayoutSet();

		LayoutSet existingLayoutSet = _persistence.findByPrimaryKey(newLayoutSet.getPrimaryKey());

		assertEquals(existingLayoutSet, newLayoutSet);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchLayoutSetException");
		}
		catch (NoSuchLayoutSetException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		LayoutSet newLayoutSet = addLayoutSet();

		LayoutSet existingLayoutSet = _persistence.fetchByPrimaryKey(newLayoutSet.getPrimaryKey());

		assertEquals(existingLayoutSet, newLayoutSet);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		LayoutSet missingLayoutSet = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingLayoutSet);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		LayoutSet newLayoutSet = addLayoutSet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LayoutSet.class,
				LayoutSet.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("layoutSetId",
				newLayoutSet.getLayoutSetId()));

		List<LayoutSet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		LayoutSet existingLayoutSet = result.get(0);

		assertEquals(existingLayoutSet, newLayoutSet);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LayoutSet.class,
				LayoutSet.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("layoutSetId", nextLong()));

		List<LayoutSet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected LayoutSet addLayoutSet() throws Exception {
		long pk = nextLong();

		LayoutSet layoutSet = _persistence.create(pk);

		layoutSet.setGroupId(nextLong());
		layoutSet.setCompanyId(nextLong());
		layoutSet.setPrivateLayout(randomBoolean());
		layoutSet.setLogo(randomBoolean());
		layoutSet.setLogoId(nextLong());
		layoutSet.setThemeId(randomString());
		layoutSet.setColorSchemeId(randomString());
		layoutSet.setWapThemeId(randomString());
		layoutSet.setWapColorSchemeId(randomString());
		layoutSet.setCss(randomString());
		layoutSet.setPageCount(nextInt());
		layoutSet.setVirtualHost(randomString());
		layoutSet.setSettings(randomString());
		layoutSet.setLayoutSetPrototypeId(nextLong());

		_persistence.update(layoutSet, false);

		return layoutSet;
	}

	private LayoutSetPersistence _persistence;
}