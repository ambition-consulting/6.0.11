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

import com.liferay.portal.service.persistence.UserGroupRolePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.UserGroupRoleServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.UserGroupRoleServiceSoap
 * @generated
 */
public class UserGroupRoleSoap implements Serializable {
	public static UserGroupRoleSoap toSoapModel(UserGroupRole model) {
		UserGroupRoleSoap soapModel = new UserGroupRoleSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRoleId(model.getRoleId());

		return soapModel;
	}

	public static UserGroupRoleSoap[] toSoapModels(UserGroupRole[] models) {
		UserGroupRoleSoap[] soapModels = new UserGroupRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserGroupRoleSoap[][] toSoapModels(UserGroupRole[][] models) {
		UserGroupRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserGroupRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserGroupRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserGroupRoleSoap[] toSoapModels(List<UserGroupRole> models) {
		List<UserGroupRoleSoap> soapModels = new ArrayList<UserGroupRoleSoap>(models.size());

		for (UserGroupRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserGroupRoleSoap[soapModels.size()]);
	}

	public UserGroupRoleSoap() {
	}

	public UserGroupRolePK getPrimaryKey() {
		return new UserGroupRolePK(_userId, _groupId, _roleId);
	}

	public void setPrimaryKey(UserGroupRolePK pk) {
		setUserId(pk.userId);
		setGroupId(pk.groupId);
		setRoleId(pk.roleId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	private long _userId;
	private long _groupId;
	private long _roleId;
}