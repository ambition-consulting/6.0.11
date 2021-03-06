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

package com.liferay.portlet.social.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portlet.social.service.http.SocialEquityLogServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.social.service.http.SocialEquityLogServiceSoap
 * @generated
 */
public class SocialEquityLogSoap implements Serializable {
	public static SocialEquityLogSoap toSoapModel(SocialEquityLog model) {
		SocialEquityLogSoap soapModel = new SocialEquityLogSoap();

		soapModel.setEquityLogId(model.getEquityLogId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAssetEntryId(model.getAssetEntryId());
		soapModel.setActionId(model.getActionId());
		soapModel.setActionDate(model.getActionDate());
		soapModel.setActive(model.getActive());
		soapModel.setExpiration(model.getExpiration());
		soapModel.setType(model.getType());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static SocialEquityLogSoap[] toSoapModels(SocialEquityLog[] models) {
		SocialEquityLogSoap[] soapModels = new SocialEquityLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialEquityLogSoap[][] toSoapModels(
		SocialEquityLog[][] models) {
		SocialEquityLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialEquityLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialEquityLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialEquityLogSoap[] toSoapModels(
		List<SocialEquityLog> models) {
		List<SocialEquityLogSoap> soapModels = new ArrayList<SocialEquityLogSoap>(models.size());

		for (SocialEquityLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialEquityLogSoap[soapModels.size()]);
	}

	public SocialEquityLogSoap() {
	}

	public long getPrimaryKey() {
		return _equityLogId;
	}

	public void setPrimaryKey(long pk) {
		setEquityLogId(pk);
	}

	public long getEquityLogId() {
		return _equityLogId;
	}

	public void setEquityLogId(long equityLogId) {
		_equityLogId = equityLogId;
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

	public long getAssetEntryId() {
		return _assetEntryId;
	}

	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;
	}

	public String getActionId() {
		return _actionId;
	}

	public void setActionId(String actionId) {
		_actionId = actionId;
	}

	public int getActionDate() {
		return _actionDate;
	}

	public void setActionDate(int actionDate) {
		_actionDate = actionDate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public int getExpiration() {
		return _expiration;
	}

	public void setExpiration(int expiration) {
		_expiration = expiration;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	private long _equityLogId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _assetEntryId;
	private String _actionId;
	private int _actionDate;
	private boolean _active;
	private int _expiration;
	private int _type;
	private int _value;
}