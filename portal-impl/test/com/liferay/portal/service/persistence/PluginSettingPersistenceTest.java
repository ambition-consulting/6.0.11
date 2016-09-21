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

import com.liferay.portal.NoSuchPluginSettingException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.PluginSetting;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PluginSettingPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (PluginSettingPersistence)PortalBeanLocatorUtil.locate(PluginSettingPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		PluginSetting pluginSetting = _persistence.create(pk);

		assertNotNull(pluginSetting);

		assertEquals(pluginSetting.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		PluginSetting newPluginSetting = addPluginSetting();

		_persistence.remove(newPluginSetting);

		PluginSetting existingPluginSetting = _persistence.fetchByPrimaryKey(newPluginSetting.getPrimaryKey());

		assertNull(existingPluginSetting);
	}

	public void testUpdateNew() throws Exception {
		addPluginSetting();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		PluginSetting newPluginSetting = _persistence.create(pk);

		newPluginSetting.setCompanyId(nextLong());
		newPluginSetting.setPluginId(randomString());
		newPluginSetting.setPluginType(randomString());
		newPluginSetting.setRoles(randomString());
		newPluginSetting.setActive(randomBoolean());

		_persistence.update(newPluginSetting, false);

		PluginSetting existingPluginSetting = _persistence.findByPrimaryKey(newPluginSetting.getPrimaryKey());

		assertEquals(existingPluginSetting.getPluginSettingId(),
			newPluginSetting.getPluginSettingId());
		assertEquals(existingPluginSetting.getCompanyId(),
			newPluginSetting.getCompanyId());
		assertEquals(existingPluginSetting.getPluginId(),
			newPluginSetting.getPluginId());
		assertEquals(existingPluginSetting.getPluginType(),
			newPluginSetting.getPluginType());
		assertEquals(existingPluginSetting.getRoles(),
			newPluginSetting.getRoles());
		assertEquals(existingPluginSetting.getActive(),
			newPluginSetting.getActive());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		PluginSetting newPluginSetting = addPluginSetting();

		PluginSetting existingPluginSetting = _persistence.findByPrimaryKey(newPluginSetting.getPrimaryKey());

		assertEquals(existingPluginSetting, newPluginSetting);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchPluginSettingException");
		}
		catch (NoSuchPluginSettingException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		PluginSetting newPluginSetting = addPluginSetting();

		PluginSetting existingPluginSetting = _persistence.fetchByPrimaryKey(newPluginSetting.getPrimaryKey());

		assertEquals(existingPluginSetting, newPluginSetting);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		PluginSetting missingPluginSetting = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingPluginSetting);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PluginSetting newPluginSetting = addPluginSetting();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PluginSetting.class,
				PluginSetting.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("pluginSettingId",
				newPluginSetting.getPluginSettingId()));

		List<PluginSetting> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		PluginSetting existingPluginSetting = result.get(0);

		assertEquals(existingPluginSetting, newPluginSetting);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PluginSetting.class,
				PluginSetting.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("pluginSettingId",
				nextLong()));

		List<PluginSetting> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected PluginSetting addPluginSetting() throws Exception {
		long pk = nextLong();

		PluginSetting pluginSetting = _persistence.create(pk);

		pluginSetting.setCompanyId(nextLong());
		pluginSetting.setPluginId(randomString());
		pluginSetting.setPluginType(randomString());
		pluginSetting.setRoles(randomString());
		pluginSetting.setActive(randomBoolean());

		_persistence.update(pluginSetting, false);

		return pluginSetting;
	}

	private PluginSettingPersistence _persistence;
}