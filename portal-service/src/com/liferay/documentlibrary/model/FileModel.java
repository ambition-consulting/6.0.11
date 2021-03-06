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

package com.liferay.documentlibrary.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class FileModel implements Serializable {

	public long[] getAssetCategoryIds() {
		return _assetCategoryIds;
	}

	public String[] getAssetCategoryNames() {
		return _assetCategoryNames;
	}

	public String[] getAssetTagNames() {
		return _assetTagNames;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public String getFileName() {
		return _fileName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String getProperties() {
		return _properties;
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setAssetCategoryIds(long[] assetCategoryIds) {
		_assetCategoryIds = assetCategoryIds;
	}

	public void setAssetCategoryNames(String[] assetCategoryNames) {
		_assetCategoryNames = assetCategoryNames;
	}

	public void setAssetTagNames(String[] assetTagNames) {
		_assetTagNames = assetTagNames;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setProperties(String properties) {
		_properties = properties;
	}
	
	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long[] _assetCategoryIds;
	private String[] _assetCategoryNames;
	private String[] _assetTagNames;
	private long _companyId;
	private long _fileEntryId;
	private String _fileName;
	private long _groupId;
	private Date _modifiedDate;
	private String _portletId;
	private String _properties;
	private long _repositoryId;
	private long _userId;

}