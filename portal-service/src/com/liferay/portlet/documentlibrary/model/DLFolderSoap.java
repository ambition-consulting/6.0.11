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

package com.liferay.portlet.documentlibrary.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portlet.documentlibrary.service.http.DLFolderServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.documentlibrary.service.http.DLFolderServiceSoap
 * @generated
 */
public class DLFolderSoap implements Serializable {
	public static DLFolderSoap toSoapModel(DLFolder model) {
		DLFolderSoap soapModel = new DLFolderSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setParentFolderId(model.getParentFolderId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLastPostDate(model.getLastPostDate());

		return soapModel;
	}

	public static DLFolderSoap[] toSoapModels(DLFolder[] models) {
		DLFolderSoap[] soapModels = new DLFolderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DLFolderSoap[][] toSoapModels(DLFolder[][] models) {
		DLFolderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DLFolderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DLFolderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DLFolderSoap[] toSoapModels(List<DLFolder> models) {
		List<DLFolderSoap> soapModels = new ArrayList<DLFolderSoap>(models.size());

		for (DLFolder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DLFolderSoap[soapModels.size()]);
	}

	public DLFolderSoap() {
	}

	public long getPrimaryKey() {
		return _folderId;
	}

	public void setPrimaryKey(long pk) {
		setFolderId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getParentFolderId() {
		return _parentFolderId;
	}

	public void setParentFolderId(long parentFolderId) {
		_parentFolderId = parentFolderId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getLastPostDate() {
		return _lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		_lastPostDate = lastPostDate;
	}

	private String _uuid;
	private long _folderId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _parentFolderId;
	private String _name;
	private String _description;
	private Date _lastPostDate;
}