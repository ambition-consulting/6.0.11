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
 * {@link com.liferay.portlet.social.service.http.SocialEquitySettingServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.social.service.http.SocialEquitySettingServiceSoap
 * @generated
 */
public class SocialEquitySettingSoap implements Serializable {
	public static SocialEquitySettingSoap toSoapModel(SocialEquitySetting model) {
		SocialEquitySettingSoap soapModel = new SocialEquitySettingSoap();

		soapModel.setEquitySettingId(model.getEquitySettingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setActionId(model.getActionId());
		soapModel.setDailyLimit(model.getDailyLimit());
		soapModel.setLifespan(model.getLifespan());
		soapModel.setType(model.getType());
		soapModel.setUniqueEntry(model.getUniqueEntry());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static SocialEquitySettingSoap[] toSoapModels(
		SocialEquitySetting[] models) {
		SocialEquitySettingSoap[] soapModels = new SocialEquitySettingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialEquitySettingSoap[][] toSoapModels(
		SocialEquitySetting[][] models) {
		SocialEquitySettingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialEquitySettingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialEquitySettingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialEquitySettingSoap[] toSoapModels(
		List<SocialEquitySetting> models) {
		List<SocialEquitySettingSoap> soapModels = new ArrayList<SocialEquitySettingSoap>(models.size());

		for (SocialEquitySetting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialEquitySettingSoap[soapModels.size()]);
	}

	public SocialEquitySettingSoap() {
	}

	public long getPrimaryKey() {
		return _equitySettingId;
	}

	public void setPrimaryKey(long pk) {
		setEquitySettingId(pk);
	}

	public long getEquitySettingId() {
		return _equitySettingId;
	}

	public void setEquitySettingId(long equitySettingId) {
		_equitySettingId = equitySettingId;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public String getActionId() {
		return _actionId;
	}

	public void setActionId(String actionId) {
		_actionId = actionId;
	}

	public int getDailyLimit() {
		return _dailyLimit;
	}

	public void setDailyLimit(int dailyLimit) {
		_dailyLimit = dailyLimit;
	}

	public int getLifespan() {
		return _lifespan;
	}

	public void setLifespan(int lifespan) {
		_lifespan = lifespan;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public boolean getUniqueEntry() {
		return _uniqueEntry;
	}

	public boolean isUniqueEntry() {
		return _uniqueEntry;
	}

	public void setUniqueEntry(boolean uniqueEntry) {
		_uniqueEntry = uniqueEntry;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	private long _equitySettingId;
	private long _groupId;
	private long _companyId;
	private long _classNameId;
	private String _actionId;
	private int _dailyLimit;
	private int _lifespan;
	private int _type;
	private boolean _uniqueEntry;
	private int _value;
}