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

import com.liferay.portal.service.persistence.OrgGroupRolePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.OrgGroupRoleServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.OrgGroupRoleServiceSoap
 * @generated
 */
public class OrgGroupRoleSoap implements Serializable {
	public static OrgGroupRoleSoap toSoapModel(OrgGroupRole model) {
		OrgGroupRoleSoap soapModel = new OrgGroupRoleSoap();

		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRoleId(model.getRoleId());

		return soapModel;
	}

	public static OrgGroupRoleSoap[] toSoapModels(OrgGroupRole[] models) {
		OrgGroupRoleSoap[] soapModels = new OrgGroupRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgGroupRoleSoap[][] toSoapModels(OrgGroupRole[][] models) {
		OrgGroupRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgGroupRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgGroupRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgGroupRoleSoap[] toSoapModels(List<OrgGroupRole> models) {
		List<OrgGroupRoleSoap> soapModels = new ArrayList<OrgGroupRoleSoap>(models.size());

		for (OrgGroupRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgGroupRoleSoap[soapModels.size()]);
	}

	public OrgGroupRoleSoap() {
	}

	public OrgGroupRolePK getPrimaryKey() {
		return new OrgGroupRolePK(_organizationId, _groupId, _roleId);
	}

	public void setPrimaryKey(OrgGroupRolePK pk) {
		setOrganizationId(pk.organizationId);
		setGroupId(pk.groupId);
		setRoleId(pk.roleId);
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
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

	private long _organizationId;
	private long _groupId;
	private long _roleId;
}