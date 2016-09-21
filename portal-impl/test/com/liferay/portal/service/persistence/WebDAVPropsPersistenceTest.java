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

import com.liferay.portal.NoSuchWebDAVPropsException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.WebDAVProps;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class WebDAVPropsPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (WebDAVPropsPersistence)PortalBeanLocatorUtil.locate(WebDAVPropsPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		WebDAVProps webDAVProps = _persistence.create(pk);

		assertNotNull(webDAVProps);

		assertEquals(webDAVProps.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		WebDAVProps newWebDAVProps = addWebDAVProps();

		_persistence.remove(newWebDAVProps);

		WebDAVProps existingWebDAVProps = _persistence.fetchByPrimaryKey(newWebDAVProps.getPrimaryKey());

		assertNull(existingWebDAVProps);
	}

	public void testUpdateNew() throws Exception {
		addWebDAVProps();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		WebDAVProps newWebDAVProps = _persistence.create(pk);

		newWebDAVProps.setCompanyId(nextLong());
		newWebDAVProps.setCreateDate(nextDate());
		newWebDAVProps.setModifiedDate(nextDate());
		newWebDAVProps.setClassNameId(nextLong());
		newWebDAVProps.setClassPK(nextLong());
		newWebDAVProps.setProps(randomString());

		_persistence.update(newWebDAVProps, false);

		WebDAVProps existingWebDAVProps = _persistence.findByPrimaryKey(newWebDAVProps.getPrimaryKey());

		assertEquals(existingWebDAVProps.getWebDavPropsId(),
			newWebDAVProps.getWebDavPropsId());
		assertEquals(existingWebDAVProps.getCompanyId(),
			newWebDAVProps.getCompanyId());
		assertEquals(Time.getShortTimestamp(existingWebDAVProps.getCreateDate()),
			Time.getShortTimestamp(newWebDAVProps.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingWebDAVProps.getModifiedDate()),
			Time.getShortTimestamp(newWebDAVProps.getModifiedDate()));
		assertEquals(existingWebDAVProps.getClassNameId(),
			newWebDAVProps.getClassNameId());
		assertEquals(existingWebDAVProps.getClassPK(),
			newWebDAVProps.getClassPK());
		assertEquals(existingWebDAVProps.getProps(), newWebDAVProps.getProps());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		WebDAVProps newWebDAVProps = addWebDAVProps();

		WebDAVProps existingWebDAVProps = _persistence.findByPrimaryKey(newWebDAVProps.getPrimaryKey());

		assertEquals(existingWebDAVProps, newWebDAVProps);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchWebDAVPropsException");
		}
		catch (NoSuchWebDAVPropsException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		WebDAVProps newWebDAVProps = addWebDAVProps();

		WebDAVProps existingWebDAVProps = _persistence.fetchByPrimaryKey(newWebDAVProps.getPrimaryKey());

		assertEquals(existingWebDAVProps, newWebDAVProps);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		WebDAVProps missingWebDAVProps = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingWebDAVProps);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		WebDAVProps newWebDAVProps = addWebDAVProps();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WebDAVProps.class,
				WebDAVProps.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("webDavPropsId",
				newWebDAVProps.getWebDavPropsId()));

		List<WebDAVProps> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		WebDAVProps existingWebDAVProps = result.get(0);

		assertEquals(existingWebDAVProps, newWebDAVProps);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WebDAVProps.class,
				WebDAVProps.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("webDavPropsId", nextLong()));

		List<WebDAVProps> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected WebDAVProps addWebDAVProps() throws Exception {
		long pk = nextLong();

		WebDAVProps webDAVProps = _persistence.create(pk);

		webDAVProps.setCompanyId(nextLong());
		webDAVProps.setCreateDate(nextDate());
		webDAVProps.setModifiedDate(nextDate());
		webDAVProps.setClassNameId(nextLong());
		webDAVProps.setClassPK(nextLong());
		webDAVProps.setProps(randomString());

		_persistence.update(webDAVProps, false);

		return webDAVProps;
	}

	private WebDAVPropsPersistence _persistence;
}