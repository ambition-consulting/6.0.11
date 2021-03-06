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
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.LayoutServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.LayoutServiceSoap
 * @generated
 */
public class LayoutSoap implements Serializable {
	public static LayoutSoap toSoapModel(Layout model) {
		LayoutSoap soapModel = new LayoutSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPlid(model.getPlid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPrivateLayout(model.getPrivateLayout());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setParentLayoutId(model.getParentLayoutId());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setTypeSettings(model.getTypeSettings());
		soapModel.setHidden(model.getHidden());
		soapModel.setFriendlyURL(model.getFriendlyURL());
		soapModel.setIconImage(model.getIconImage());
		soapModel.setIconImageId(model.getIconImageId());
		soapModel.setThemeId(model.getThemeId());
		soapModel.setColorSchemeId(model.getColorSchemeId());
		soapModel.setWapThemeId(model.getWapThemeId());
		soapModel.setWapColorSchemeId(model.getWapColorSchemeId());
		soapModel.setCss(model.getCss());
		soapModel.setPriority(model.getPriority());
		soapModel.setLayoutPrototypeId(model.getLayoutPrototypeId());
		soapModel.setDlFolderId(model.getDlFolderId());

		return soapModel;
	}

	public static LayoutSoap[] toSoapModels(Layout[] models) {
		LayoutSoap[] soapModels = new LayoutSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LayoutSoap[][] toSoapModels(Layout[][] models) {
		LayoutSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LayoutSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LayoutSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LayoutSoap[] toSoapModels(List<Layout> models) {
		List<LayoutSoap> soapModels = new ArrayList<LayoutSoap>(models.size());

		for (Layout model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LayoutSoap[soapModels.size()]);
	}

	public LayoutSoap() {
	}

	public long getPrimaryKey() {
		return _plid;
	}

	public void setPrimaryKey(long pk) {
		setPlid(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPlid() {
		return _plid;
	}

	public void setPlid(long plid) {
		_plid = plid;
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

	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		_privateLayout = privateLayout;
	}

	public long getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;
	}

	public long getParentLayoutId() {
		return _parentLayoutId;
	}

	public void setParentLayoutId(long parentLayoutId) {
		_parentLayoutId = parentLayoutId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	public boolean getHidden() {
		return _hidden;
	}

	public boolean isHidden() {
		return _hidden;
	}

	public void setHidden(boolean hidden) {
		_hidden = hidden;
	}

	public String getFriendlyURL() {
		return _friendlyURL;
	}

	public void setFriendlyURL(String friendlyURL) {
		_friendlyURL = friendlyURL;
	}

	public boolean getIconImage() {
		return _iconImage;
	}

	public boolean isIconImage() {
		return _iconImage;
	}

	public void setIconImage(boolean iconImage) {
		_iconImage = iconImage;
	}

	public long getIconImageId() {
		return _iconImageId;
	}

	public void setIconImageId(long iconImageId) {
		_iconImageId = iconImageId;
	}

	public String getThemeId() {
		return _themeId;
	}

	public void setThemeId(String themeId) {
		_themeId = themeId;
	}

	public String getColorSchemeId() {
		return _colorSchemeId;
	}

	public void setColorSchemeId(String colorSchemeId) {
		_colorSchemeId = colorSchemeId;
	}

	public String getWapThemeId() {
		return _wapThemeId;
	}

	public void setWapThemeId(String wapThemeId) {
		_wapThemeId = wapThemeId;
	}

	public String getWapColorSchemeId() {
		return _wapColorSchemeId;
	}

	public void setWapColorSchemeId(String wapColorSchemeId) {
		_wapColorSchemeId = wapColorSchemeId;
	}

	public String getCss() {
		return _css;
	}

	public void setCss(String css) {
		_css = css;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public long getLayoutPrototypeId() {
		return _layoutPrototypeId;
	}

	public void setLayoutPrototypeId(long layoutPrototypeId) {
		_layoutPrototypeId = layoutPrototypeId;
	}

	public long getDlFolderId() {
		return _dlFolderId;
	}

	public void setDlFolderId(long dlFolderId) {
		_dlFolderId = dlFolderId;
	}

	private String _uuid;
	private long _plid;
	private long _groupId;
	private long _companyId;
	private boolean _privateLayout;
	private long _layoutId;
	private long _parentLayoutId;
	private String _name;
	private String _title;
	private String _description;
	private String _type;
	private String _typeSettings;
	private boolean _hidden;
	private String _friendlyURL;
	private boolean _iconImage;
	private long _iconImageId;
	private String _themeId;
	private String _colorSchemeId;
	private String _wapThemeId;
	private String _wapColorSchemeId;
	private String _css;
	private int _priority;
	private long _layoutPrototypeId;
	private long _dlFolderId;
}