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
import com.liferay.portal.kernel.dao.search.SearchEntry;
import com.liferay.portal.kernel.dao.search.TextSearchEntry;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;

/**
 * @author Raymond Augé
 */
public class SearchContainerColumnTextTag<R>
	extends SearchContainerColumnTag implements BodyTag {

	public int doEndTag() {
		try {
			SearchContainerRowTag<R> parentTag =
				(SearchContainerRowTag<R>)findAncestorWithClass(
					this, SearchContainerRowTag.class);

			ResultRow row = parentTag.getRow();

			if (Validator.isNotNull(_property)) {
				_value = String.valueOf(
					BeanPropertiesUtil.getObject(row.getObject(), _property));
			}
			else if (Validator.isNotNull(_buffer)) {
				_value = _sb.toString();
			}
			else if (_value == null) {
				BodyContent bodyContent = getBodyContent();

				if (bodyContent != null) {
					_value = bodyContent.getString();
				}
			}

			if (_translate) {
				_value = LanguageUtil.get(pageContext, _value);
			}

			if (index <= -1) {
				index = row.getEntries().size();
			}

			if (row.isRestricted()) {
				_href = null;
			}

			row.addText(
				index,
				new TextSearchEntry(
					getAlign(), getValign(), getColspan(), getValue(),
					(String)getHref(), getTarget(), getTitle()));

			return EVAL_PAGE;
		}
		finally {
			index = -1;
			_value = null;

			if (!ServerDetector.isResin()) {
				align = SearchEntry.DEFAULT_ALIGN;
				_buffer = null;
				colspan = SearchEntry.DEFAULT_COLSPAN;
				_href = null;
				name = null;
				_orderable = false;
				_orderableProperty = null;
				_property = null;
				_sb = null;
				_target = null;
				_title = null;
				_translate = false;
				valign = SearchEntry.DEFAULT_VALIGN;
			}
		}
	}

	public int doStartTag() throws JspException {
		if (_orderable && Validator.isNull(_orderableProperty)) {
			_orderableProperty = name;
		}

		SearchContainerRowTag<R> parentRowTag =
			(SearchContainerRowTag<R>)findAncestorWithClass(
				this, SearchContainerRowTag.class);

		if (parentRowTag == null) {
			throw new JspTagException(
				"Requires liferay-ui:search-container-row");
		}

		if (!parentRowTag.isHeaderNamesAssigned()) {
			List<String> headerNames = parentRowTag.getHeaderNames();

			String name = getName();

			if (Validator.isNull(name) && Validator.isNotNull(_property)) {
				name = _property;
			}

			headerNames.add(name);

			if (_orderable) {
				Map<String,String> orderableHeaders =
					parentRowTag.getOrderableHeaders();

				if (Validator.isNotNull(_orderableProperty)) {
					orderableHeaders.put(name, _orderableProperty);
				}
				else if (Validator.isNotNull(_property)) {
					orderableHeaders.put(name, _property);
				}
				else if (Validator.isNotNull(name)) {
					orderableHeaders.put(name, name);
				}
			}
		}

		if (Validator.isNotNull(_property)) {
			return SKIP_BODY;
		}
		else if (Validator.isNotNull(_buffer)) {
			_sb = new StringBuilder();

			pageContext.setAttribute(_buffer, _sb);

			return EVAL_BODY_INCLUDE;
		}
		else if (Validator.isNull(_value)) {
			return EVAL_BODY_BUFFERED;
		}
		else {
			return SKIP_BODY;
		}
	}

	public String getBuffer() {
		return _buffer;
	}

	public Object getHref() {
		if (Validator.isNotNull(_href) && (_href instanceof PortletURL)) {
			_href = _href.toString();
		}

		return _href;
	}

	public String getOrderableProperty() {
		return _orderableProperty;
	}

	public String getProperty() {
		return _property;
	}

	public String getTarget() {
		return _target;
	}

	public String getTitle() {
		return _title;
	}

	public String getValue() {
		return _value;
	}

	public boolean isOrderable() {
		return _orderable;
	}

	public void setBuffer(String buffer) {
		_buffer = buffer;
	}

	public void setHref(Object href) {
		_href = href;
	}

	public void setOrderable(boolean orderable) {
		_orderable = orderable;
	}

	public void setOrderableProperty(String orderableProperty) {
		_orderableProperty = orderableProperty;
	}

	public void setProperty(String property) {
		_property = property;
	}

	public void setTarget(String target) {
		_target = target;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setTranslate(boolean translate) {
		_translate = translate;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _buffer;
	private Object _href;
	private boolean _orderable;
	private String _orderableProperty;
	private String _property;
	private StringBuilder _sb;
	private String _target;
	private String _title;
	private boolean _translate;
	private String _value;

}