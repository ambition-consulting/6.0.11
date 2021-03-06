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
 * {@link com.liferay.portal.service.http.WebDAVPropsServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.WebDAVPropsServiceSoap
 * @generated
 */
public class WebDAVPropsSoap implements Serializable {
	public static WebDAVPropsSoap toSoapModel(WebDAVProps model) {
		WebDAVPropsSoap soapModel = new WebDAVPropsSoap();

		soapModel.setWebDavPropsId(model.getWebDavPropsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setProps(model.getProps());

		return soapModel;
	}

	public static WebDAVPropsSoap[] toSoapModels(WebDAVProps[] models) {
		WebDAVPropsSoap[] soapModels = new WebDAVPropsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebDAVPropsSoap[][] toSoapModels(WebDAVProps[][] models) {
		WebDAVPropsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebDAVPropsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebDAVPropsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebDAVPropsSoap[] toSoapModels(List<WebDAVProps> models) {
		List<WebDAVPropsSoap> soapModels = new ArrayList<WebDAVPropsSoap>(models.size());

		for (WebDAVProps model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebDAVPropsSoap[soapModels.size()]);
	}

	public WebDAVPropsSoap() {
	}

	public long getPrimaryKey() {
		return _webDavPropsId;
	}

	public void setPrimaryKey(long pk) {
		setWebDavPropsId(pk);
	}

	public long getWebDavPropsId() {
		return _webDavPropsId;
	}

	public void setWebDavPropsId(long webDavPropsId) {
		_webDavPropsId = webDavPropsId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getProps() {
		return _props;
	}

	public void setProps(String props) {
		_props = props;
	}

	private long _webDavPropsId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _props;
}