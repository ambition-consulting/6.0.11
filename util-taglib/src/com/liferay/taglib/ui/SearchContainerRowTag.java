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

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.taglib.util.ParamAndPropertyAncestorTagImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;

/**
 * @author Raymond Augé
 */
public class SearchContainerRowTag<R>
	extends ParamAndPropertyAncestorTagImpl implements BodyTag {

	public static final String DEFAULT_INDEX_VAR = "index";

	public static final String DEFAULT_MODEL_VAR = "model";

	public static final String DEFAULT_ROW_VAR = "row";

	public void addParam(String name, String value) {
		if (name.equals("className")) {
			_row.setClassName(value);
		}
		else if (name.equals("classHoverName")) {
			_row.setClassHoverName(value);
		}
		else if (name.equals("restricted")) {
			_row.setRestricted(GetterUtil.getBoolean(value, false));
		}
		else {
			Object obj = pageContext.getAttribute(value);

			if (obj == null) {
				obj = value;
			}

			_row.setParameter(name, obj);
		}
	}

	public int doAfterBody() {
		if (!_headerNamesAssigned) {
			SearchContainerTag<R> parentTag =
				(SearchContainerTag<R>)findAncestorWithClass(
					this, SearchContainerTag.class);

			SearchContainer<R> searchContainer = parentTag.getSearchContainer();

			searchContainer.setHeaderNames(_headerNames);
			searchContainer.setOrderableHeaders(_orderableHeaders);

			_headerNamesAssigned = true;
		}

		_resultRows.add(_row);

		_rowIndex++;

		if (_rowIndex < (_results.size())) {
			processRow();

			return EVAL_BODY_AGAIN;
		}
		else {
			return SKIP_BODY;
		}
	}

	public int doEndTag() {
		_headerNames = null;
		_headerNamesAssigned = false;
		_resultRows = null;
		_rowIndex = 0;
		_row = null;

		if (!ServerDetector.isResin()) {
			_bold = false;
			_className = null;
			_escapedModel = false;
			_indexVar = DEFAULT_INDEX_VAR;
			_keyProperty = null;
			_modelVar = DEFAULT_MODEL_VAR;
			_orderableHeaders = null;
			_rowVar = DEFAULT_ROW_VAR;
			_stringKey = false;
		}

		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		SearchContainerTag<R> parentTag =
			(SearchContainerTag<R>)findAncestorWithClass(
				this, SearchContainerTag.class);

		if (parentTag == null) {
			throw new JspException("Requires liferay-ui:search-container");
		}
		else if (!parentTag.isHasResults()) {
			throw new JspException(
				"Requires liferay-ui:search-container-results");
		}

		_resultRows = parentTag.getSearchContainer().getResultRows();
		_results = parentTag.getSearchContainer().getResults();

		if ((_results != null) && (!_results.isEmpty())) {
			processRow();

			return EVAL_BODY_INCLUDE;
		}
		else {
			return SKIP_BODY;
		}
	}

	public String getClassName() {
		return _className;
	}

	public List<String> getHeaderNames() {
		if (_headerNames == null) {
			_headerNames = new ArrayList<String>();
		}

		return _headerNames;
	}

	public String getIndexVar() {
		return _indexVar;
	}

	public String getKeyProperty() {
		return _keyProperty;
	}

	public String getModelVar() {
		return _modelVar;
	}

	public Map<String, String> getOrderableHeaders() {
		if (_orderableHeaders == null) {
			_orderableHeaders = new LinkedHashMap<String, String>();
		}

		return _orderableHeaders;
	}

	public ResultRow getRow() {
		return _row;
	}

	public String getRowVar() {
		return _rowVar;
	}

	public boolean isBold() {
		return _bold;
	}

	public boolean isEscapedModel() {
		return _escapedModel;
	}

	public boolean isHeaderNamesAssigned() {
		return _headerNamesAssigned;
	}

	public boolean isStringKey() {
		return _stringKey;
	}

	public void setBold(boolean bold) {
		_bold = bold;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setEscapedModel(boolean escapedModel) {
		_escapedModel = escapedModel;
	}

	public void setHeaderNames(List<String> headerNames) {
		_headerNames = headerNames;
	}

	public void setHeaderNamesAssigned(boolean headerNamesAssigned) {
		_headerNamesAssigned = headerNamesAssigned;
	}

	public void setIndexVar(String indexVar) {
		_indexVar = indexVar;
	}

	public void setKeyProperty(String keyProperty) {
		_keyProperty = keyProperty;
	}

	public void setModelVar(String var) {
		_modelVar = var;
	}

	public void setOrderableHeaders(Map<String, String> orderableHeaders) {
		_orderableHeaders = orderableHeaders;
	}

	public void setRow(ResultRow row) {
		_row = row;
	}

	public void setRowVar(String rowVar) {
		_rowVar = rowVar;
	}

	public void setServletContext(ServletContext servletContext) {
	}

	public void setStringKey(boolean stringKey) {
		_stringKey = stringKey;
	}

	protected void processRow() {
		Object model = _results.get(_rowIndex);

		if (isEscapedModel()) {
			BaseModel<?> baseModel = (BaseModel<?>)model;

			model = baseModel.toEscapedModel();
		}

		if (_log.isDebugEnabled()) {
			_log.debug(BeanPropertiesUtil.getBoolean(model, "escapedModel"));
		}

		if (Validator.isNull(_keyProperty)) {
			String primaryKey = String.valueOf(model);

			_row = new ResultRow(model, primaryKey, _rowIndex, _bold);
		}
		else if (isStringKey()) {
			String primaryKey = BeanPropertiesUtil.getString(
				model, _keyProperty);

			_row = new ResultRow(model, primaryKey, _rowIndex, _bold);
		}
		else {
			Object primaryKey = BeanPropertiesUtil.getObject(
				model, _keyProperty);

			_row = new ResultRow(
				model, String.valueOf(primaryKey), _rowIndex, _bold);
		}

		pageContext.setAttribute(_indexVar, _rowIndex);
		pageContext.setAttribute(_modelVar, model);
		pageContext.setAttribute(_rowVar, _row);
	}

	private static Log _log = LogFactoryUtil.getLog(
		SearchContainerRowTag.class);

	private boolean _bold;
	private String _className;
	private boolean _escapedModel;
	private List<String> _headerNames;
	private boolean _headerNamesAssigned;
	private String _indexVar = DEFAULT_INDEX_VAR;
	private String _keyProperty;
	private String _modelVar = DEFAULT_MODEL_VAR;
	private Map<String, String> _orderableHeaders;
	private List<R> _results;
	private List<ResultRow> _resultRows;
	private int _rowIndex;
	private String _rowVar = DEFAULT_ROW_VAR;
	private ResultRow _row;
	private boolean _stringKey = false;

}