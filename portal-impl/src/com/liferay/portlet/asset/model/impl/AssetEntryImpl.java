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

package com.liferay.portlet.asset.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.social.model.SocialEquityAssetEntry;
import com.liferay.portlet.social.model.SocialEquityValue;
import com.liferay.portlet.social.service.persistence.SocialEquityAssetEntryUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetEntryImpl extends AssetEntryModelImpl implements AssetEntry {

	public AssetEntryImpl() {
	}

	public List<AssetCategory> getCategories() throws SystemException {
		return AssetCategoryLocalServiceUtil.getEntryCategories(getEntryId());
	}

	public long[] getCategoryIds() throws SystemException {
		return StringUtil.split(
			ListUtil.toString(getCategories(), "categoryId"), 0L);
	}

	public double getSocialInformationEquity() {
		if (_socialInformationEquity == null) {
			try {
				SocialEquityAssetEntry equityAssetEntry =
					SocialEquityAssetEntryUtil.findByAssetEntryId(
						getEntryId());

				SocialEquityValue socialEquityValue = new SocialEquityValue(
					equityAssetEntry.getInformationK(),
					equityAssetEntry.getInformationB());

				_socialInformationEquity = new AtomicReference<Double>(
					socialEquityValue.getValue());
			}
			catch (PortalException pe) {
				return 0;
			}
			catch (SystemException se) {
				return 0;
			}
		}

		return _socialInformationEquity.get();
	}

	public String[] getTagNames() throws SystemException {
		return StringUtil.split(ListUtil.toString(getTags(), "name"));
	}

	public List<AssetTag> getTags() throws SystemException {
		return AssetTagLocalServiceUtil.getEntryTags(getEntryId());
	}

	public void updateSocialInformationEquity(double value) {
		if (_socialInformationEquity != null) {
			double currentValue = 0;
			double newValue = 0;

			do {
				currentValue = _socialInformationEquity.get();

				newValue = currentValue + value;

			}
			while (!_socialInformationEquity.compareAndSet(
						currentValue, newValue));
		}
	}

	private AtomicReference<Double> _socialInformationEquity = null;

}