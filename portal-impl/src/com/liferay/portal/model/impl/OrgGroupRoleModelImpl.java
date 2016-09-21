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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.OrgGroupRole;
import com.liferay.portal.model.OrgGroupRoleModel;
import com.liferay.portal.service.persistence.OrgGroupRolePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the OrgGroupRole service. Represents a row in the &quot;OrgGroupRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.OrgGroupRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrgGroupRoleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrgGroupRoleImpl
 * @see com.liferay.portal.model.OrgGroupRole
 * @see com.liferay.portal.model.OrgGroupRoleModel
 * @generated
 */
public class OrgGroupRoleModelImpl extends BaseModelImpl<OrgGroupRole>
	implements OrgGroupRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a org group role model instance should use the {@link com.liferay.portal.model.OrgGroupRole} interface instead.
	 */
	public static final String TABLE_NAME = "OrgGroupRole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "organizationId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "roleId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table OrgGroupRole (organizationId LONG not null,groupId LONG not null,roleId LONG not null,primary key (organizationId, groupId, roleId))";
	public static final String TABLE_SQL_DROP = "drop table OrgGroupRole";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.OrgGroupRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.OrgGroupRole"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.OrgGroupRole"));

	public OrgGroupRoleModelImpl() {
	}

	public OrgGroupRolePK getPrimaryKey() {
		return new OrgGroupRolePK(_organizationId, _groupId, _roleId);
	}

	public void setPrimaryKey(OrgGroupRolePK pk) {
		setOrganizationId(pk.organizationId);
		setGroupId(pk.groupId);
		setRoleId(pk.roleId);
	}

	public Serializable getPrimaryKeyObj() {
		return new OrgGroupRolePK(_organizationId, _groupId, _roleId);
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

	public OrgGroupRole toEscapedModel() {
		if (isEscapedModel()) {
			return (OrgGroupRole)this;
		}
		else {
			return (OrgGroupRole)Proxy.newProxyInstance(OrgGroupRole.class.getClassLoader(),
				new Class[] { OrgGroupRole.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		OrgGroupRoleImpl clone = new OrgGroupRoleImpl();

		clone.setOrganizationId(getOrganizationId());
		clone.setGroupId(getGroupId());
		clone.setRoleId(getRoleId());

		return clone;
	}

	public int compareTo(OrgGroupRole orgGroupRole) {
		OrgGroupRolePK pk = orgGroupRole.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgGroupRole orgGroupRole = null;

		try {
			orgGroupRole = (OrgGroupRole)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		OrgGroupRolePK pk = orgGroupRole.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{organizationId=");
		sb.append(getOrganizationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.OrgGroupRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _organizationId;
	private long _groupId;
	private long _roleId;
}