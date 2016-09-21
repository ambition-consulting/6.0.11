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

package com.liferay.taglib.ui;

import com.liferay.taglib.util.IncludeTag;

import java.text.Format;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class InputFieldTag extends IncludeTag {

	public void setBean(Object bean) {
		_bean = bean;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public void setDefaultValue(Object defaultValue) {
		_defaultValue = defaultValue;
	}

	public void setDisabled(boolean disabled) {
		_disabled = disabled;
	}

	public void setField(String field) {
		_field = field;
	}

	public void setFieldParam(String fieldParam) {
		_fieldParam = fieldParam;
	}

	public void setFormat(Format format) {
		_format = format;
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public void setModel(Class<?> model) {
		_model = model;
	}

	protected void cleanUp() {
		_bean = null;
		_cssClass = null;
		_defaultValue = null;
		_disabled = false;
		_field = null;
		_fieldParam = null;
		_format = null;
		_formName = "fm";
		_model = null;
	}

	protected String getPage() {
		return _PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("liferay-ui:input-field:bean", _bean);
		request.setAttribute("liferay-ui:input-field:cssClass", _cssClass);
		request.setAttribute(
			"liferay-ui:input-field:defaultValue", _defaultValue);
		request.setAttribute(
			"liferay-ui:input-field:disabled", String.valueOf(_disabled));
		request.setAttribute("liferay-ui:input-field:field", _field);
		request.setAttribute("liferay-ui:input-field:fieldParam", _fieldParam);
		request.setAttribute("liferay-ui:input-field:format", _format);
		request.setAttribute("liferay-ui:input-field:formName", _formName);
		request.setAttribute("liferay-ui:input-field:model", _model.getName());
	}

	private static final String _PAGE = "/html/taglib/ui/input_field/page.jsp";

	private Object _bean;
	private String _cssClass;
	private Object _defaultValue;
	private boolean _disabled;
	private String _field;
	private String _fieldParam;
	private Format _format;
	private String _formName = "fm";
	private Class<?> _model;

}