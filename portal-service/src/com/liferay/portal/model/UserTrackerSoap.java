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
 * {@link com.liferay.portal.service.http.UserTrackerServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.UserTrackerServiceSoap
 * @generated
 */
public class UserTrackerSoap implements Serializable {
	public static UserTrackerSoap toSoapModel(UserTracker model) {
		UserTrackerSoap soapModel = new UserTrackerSoap();

		soapModel.setUserTrackerId(model.getUserTrackerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSessionId(model.getSessionId());
		soapModel.setRemoteAddr(model.getRemoteAddr());
		soapModel.setRemoteHost(model.getRemoteHost());
		soapModel.setUserAgent(model.getUserAgent());

		return soapModel;
	}

	public static UserTrackerSoap[] toSoapModels(UserTracker[] models) {
		UserTrackerSoap[] soapModels = new UserTrackerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserTrackerSoap[][] toSoapModels(UserTracker[][] models) {
		UserTrackerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserTrackerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserTrackerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserTrackerSoap[] toSoapModels(List<UserTracker> models) {
		List<UserTrackerSoap> soapModels = new ArrayList<UserTrackerSoap>(models.size());

		for (UserTracker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserTrackerSoap[soapModels.size()]);
	}

	public UserTrackerSoap() {
	}

	public long getPrimaryKey() {
		return _userTrackerId;
	}

	public void setPrimaryKey(long pk) {
		setUserTrackerId(pk);
	}

	public long getUserTrackerId() {
		return _userTrackerId;
	}

	public void setUserTrackerId(long userTrackerId) {
		_userTrackerId = userTrackerId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getSessionId() {
		return _sessionId;
	}

	public void setSessionId(String sessionId) {
		_sessionId = sessionId;
	}

	public String getRemoteAddr() {
		return _remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		_remoteAddr = remoteAddr;
	}

	public String getRemoteHost() {
		return _remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		_remoteHost = remoteHost;
	}

	public String getUserAgent() {
		return _userAgent;
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	private long _userTrackerId;
	private long _companyId;
	private long _userId;
	private Date _modifiedDate;
	private String _sessionId;
	private String _remoteAddr;
	private String _remoteHost;
	private String _userAgent;
}