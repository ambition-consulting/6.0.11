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

package com.liferay.portlet.asset.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetTagFinderUtil {
	public static int countByG_C_N(long groupId, long classNameId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByG_C_N(groupId, classNameId, name);
	}

	public static int countByG_N_P(long groupId, java.lang.String name,
		java.lang.String[] tagProperties)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByG_N_P(groupId, name, tagProperties);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTag> findByEntryId(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByEntryId(entryId);
	}

	public static com.liferay.portlet.asset.model.AssetTag findByG_N(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagException {
		return getFinder().findByG_N(groupId, name);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTag> findByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByC_C(classNameId, classPK);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTag> findByG_C_N(
		long groupId, long classNameId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_C_N(groupId, classNameId, name);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTag> findByG_C_N(
		long groupId, long classNameId, java.lang.String name, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_C_N(groupId, classNameId, name, start, end);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTag> findByG_N_P(
		long groupId, java.lang.String name, java.lang.String[] tagProperties)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_N_P(groupId, name, tagProperties);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTag> findByG_N_P(
		long groupId, java.lang.String name, java.lang.String[] tagProperties,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_N_P(groupId, name, tagProperties, start, end);
	}

	public static AssetTagFinder getFinder() {
		if (_finder == null) {
			_finder = (AssetTagFinder)PortalBeanLocatorUtil.locate(AssetTagFinder.class.getName());

			ReferenceRegistry.registerReference(AssetTagFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AssetTagFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AssetTagFinderUtil.class, "_finder");
	}

	private static AssetTagFinder _finder;
}