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

package com.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.ReleaseServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.ReleaseServiceSoap
 * @generated
 */
public class ReleaseSoap implements Serializable {
	public static ReleaseSoap toSoapModel(Release model) {
		ReleaseSoap soapModel = new ReleaseSoap();

		soapModel.setReleaseId(model.getReleaseId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServletContextName(model.getServletContextName());
		soapModel.setBuildNumber(model.getBuildNumber());
		soapModel.setBuildDate(model.getBuildDate());
		soapModel.setVerified(model.getVerified());
		soapModel.setTestString(model.getTestString());

		return soapModel;
	}

	public static ReleaseSoap[] toSoapModels(Release[] models) {
		ReleaseSoap[] soapModels = new ReleaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReleaseSoap[][] toSoapModels(Release[][] models) {
		ReleaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReleaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReleaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReleaseSoap[] toSoapModels(List<Release> models) {
		List<ReleaseSoap> soapModels = new ArrayList<ReleaseSoap>(models.size());

		for (Release model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReleaseSoap[soapModels.size()]);
	}

	public ReleaseSoap() {
	}

	public long getPrimaryKey() {
		return _releaseId;
	}

	public void setPrimaryKey(long pk) {
		setReleaseId(pk);
	}

	public long getReleaseId() {
		return _releaseId;
	}

	public void setReleaseId(long releaseId) {
		_releaseId = releaseId;
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

	public String getServletContextName() {
		return _servletContextName;
	}

	public void setServletContextName(String servletContextName) {
		_servletContextName = servletContextName;
	}

	public int getBuildNumber() {
		return _buildNumber;
	}

	public void setBuildNumber(int buildNumber) {
		_buildNumber = buildNumber;
	}

	public Date getBuildDate() {
		return _buildDate;
	}

	public void setBuildDate(Date buildDate) {
		_buildDate = buildDate;
	}

	public boolean getVerified() {
		return _verified;
	}

	public boolean isVerified() {
		return _verified;
	}

	public void setVerified(boolean verified) {
		_verified = verified;
	}

	public String getTestString() {
		return _testString;
	}

	public void setTestString(String testString) {
		_testString = testString;
	}

	private long _releaseId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _servletContextName;
	private int _buildNumber;
	private Date _buildDate;
	private boolean _verified;
	private String _testString;
}