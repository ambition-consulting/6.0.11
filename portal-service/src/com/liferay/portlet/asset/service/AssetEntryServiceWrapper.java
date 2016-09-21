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

package com.liferay.portlet.asset.service;

/**
 * <p>
 * This class is a wrapper for {@link AssetEntryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetEntryService
 * @generated
 */
public class AssetEntryServiceWrapper implements AssetEntryService {
	public AssetEntryServiceWrapper(AssetEntryService assetEntryService) {
		_assetEntryService = assetEntryService;
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetEntry> getCompanyEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getCompanyEntries(companyId, start, end);
	}

	public int getCompanyEntriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getCompanyEntriesCount(companyId);
	}

	public java.lang.String getCompanyEntriesRSS(long companyId, int max,
		java.lang.String type, double version, java.lang.String displayStyle,
		java.lang.String feedURL, java.lang.String tagURL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getCompanyEntriesRSS(companyId, max, type,
			version, displayStyle, feedURL, tagURL);
	}

	public com.liferay.portlet.asset.model.AssetEntryDisplay[] getCompanyEntryDisplays(
		long companyId, int start, int end, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getCompanyEntryDisplays(companyId, start,
			end, languageId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetEntry> getEntries(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntries(entryQuery);
	}

	public int getEntriesCount(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntriesCount(entryQuery);
	}

	public java.lang.String getEntriesRSS(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery,
		java.lang.String name, java.lang.String type, double version,
		java.lang.String displayStyle, java.lang.String feedURL,
		java.lang.String tagURL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntriesRSS(entryQuery, name, type,
			version, displayStyle, feedURL, tagURL);
	}

	public com.liferay.portlet.asset.model.AssetEntry getEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.getEntry(entryId);
	}

	public void incrementViewCounter(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetEntryService.incrementViewCounter(className, classPK);
	}

	public com.liferay.portlet.asset.model.AssetEntryDisplay[] searchEntryDisplays(
		long companyId, long[] groupIds, java.lang.String portletId,
		java.lang.String keywords, java.lang.String languageId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.searchEntryDisplays(companyId, groupIds,
			portletId, keywords, languageId, start, end);
	}

	/**
	* @deprecated {@link #searchEntryDisplays(long, long[], String, String,
	String)}
	*/
	public com.liferay.portlet.asset.model.AssetEntryDisplay[] searchEntryDisplays(
		long companyId, java.lang.String portletId, java.lang.String keywords,
		java.lang.String languageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.searchEntryDisplays(companyId, portletId,
			keywords, languageId, start, end);
	}

	public int searchEntryDisplaysCount(long companyId, long[] groupIds,
		java.lang.String portletId, java.lang.String keywords,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.searchEntryDisplaysCount(companyId, groupIds,
			portletId, keywords, languageId);
	}

	/**
	* @deprecated {@link #searchEntryDisplaysCount(long, long[], String,
	String, String)}
	*/
	public int searchEntryDisplaysCount(long companyId,
		java.lang.String portletId, java.lang.String keywords,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.searchEntryDisplaysCount(companyId,
			portletId, keywords, languageId);
	}

	public com.liferay.portlet.asset.model.AssetEntry updateEntry(
		long groupId, java.lang.String className, long classPK,
		java.lang.String classUuid, long[] categoryIds,
		java.lang.String[] tagNames, boolean visible, java.util.Date startDate,
		java.util.Date endDate, java.util.Date publishDate,
		java.util.Date expirationDate, java.lang.String mimeType,
		java.lang.String title, java.lang.String description,
		java.lang.String summary, java.lang.String url, int height, int width,
		java.lang.Integer priority, boolean sync)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetEntryService.updateEntry(groupId, className, classPK,
			classUuid, categoryIds, tagNames, visible, startDate, endDate,
			publishDate, expirationDate, mimeType, title, description, summary,
			url, height, width, priority, sync);
	}

	public AssetEntryService getWrappedAssetEntryService() {
		return _assetEntryService;
	}

	public void setWrappedAssetEntryService(AssetEntryService assetEntryService) {
		_assetEntryService = assetEntryService;
	}

	private AssetEntryService _assetEntryService;
}