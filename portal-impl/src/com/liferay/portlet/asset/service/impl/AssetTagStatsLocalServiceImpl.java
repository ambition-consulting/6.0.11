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

package com.liferay.portlet.asset.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetTagStats;
import com.liferay.portlet.asset.service.base.AssetTagStatsLocalServiceBaseImpl;

/**
 * @author Jorge Ferrer
 */
public class AssetTagStatsLocalServiceImpl
	extends AssetTagStatsLocalServiceBaseImpl {

	public AssetTagStats addTagStats(long tagId, long classNameId)
		throws SystemException {

		long tagStatsId = counterLocalService.increment();

		AssetTagStats tagStats = assetTagStatsPersistence.create(tagStatsId);

		tagStats.setTagId(tagId);
		tagStats.setClassNameId(classNameId);

		try {
			assetTagStatsPersistence.update(tagStats, false);
		}
		catch (SystemException se) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Add failed, fetch {tagId=" + tagId + ", classNameId=" +
						classNameId + "}");
			}

			tagStats = assetTagStatsPersistence.fetchByT_C(
				tagId, classNameId, false);

			if (tagStats == null) {
				throw se;
			}
		}

		return tagStats;
	}

	public void deleteTagStatsByClassNameId(long classNameId)
		throws SystemException {

		assetTagStatsPersistence.removeByClassNameId(classNameId);
	}

	public void deleteTagStatsByTagId(long tagId)
		throws SystemException {

		assetTagStatsPersistence.removeByTagId(tagId);
	}

	public AssetTagStats getTagStats(long tagId, long classNameId)
		throws SystemException {

		AssetTagStats tagStats = assetTagStatsPersistence.fetchByT_C(
			tagId, classNameId);

		if (tagStats == null) {
			tagStats = assetTagStatsLocalService.addTagStats(
				tagId, classNameId);
		}

		return tagStats;
	}

	public AssetTagStats updateTagStats(long tagId, long classNameId)
		throws PortalException, SystemException {

		AssetTag tag = assetTagPersistence.findByPrimaryKey(tagId);

		int assetCount = assetTagFinder.countByG_C_N(
			tag.getGroupId(), classNameId, tag.getName());

		AssetTagStats tagStats = getTagStats(tagId, classNameId);

		tagStats.setAssetCount(assetCount);

		assetTagStatsPersistence.update(tagStats, false);

		return tagStats;
	}

	private static Log _log = LogFactoryUtil.getLog(
		AssetTagStatsLocalServiceImpl.class);

}