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
 * {@link com.liferay.portlet.documentlibrary.service.http.DLFileRankServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.documentlibrary.service.http.DLFileRankServiceSoap
 * @generated
 */
public class DLFileRankSoap implements Serializable {
	public static DLFileRankSoap toSoapModel(DLFileRank model) {
		DLFileRankSoap soapModel = new DLFileRankSoap();

		soapModel.setFileRankId(model.getFileRankId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static DLFileRankSoap[] toSoapModels(DLFileRank[] models) {
		DLFileRankSoap[] soapModels = new DLFileRankSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DLFileRankSoap[][] toSoapModels(DLFileRank[][] models) {
		DLFileRankSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DLFileRankSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DLFileRankSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DLFileRankSoap[] toSoapModels(List<DLFileRank> models) {
		List<DLFileRankSoap> soapModels = new ArrayList<DLFileRankSoap>(models.size());

		for (DLFileRank model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DLFileRankSoap[soapModels.size()]);
	}

	public DLFileRankSoap() {
	}

	public long getPrimaryKey() {
		return _fileRankId;
	}

	public void setPrimaryKey(long pk) {
		setFileRankId(pk);
	}

	public long getFileRankId() {
		return _fileRankId;
	}

	public void setFileRankId(long fileRankId) {
		_fileRankId = fileRankId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _fileRankId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private long _fileEntryId;
}