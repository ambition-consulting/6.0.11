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

package com.liferay.portal.kernel.dao.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ResultRow {

	public ResultRow(Object obj, long primaryKey, int pos) {
		this(obj, String.valueOf(primaryKey), pos);
	}

	public ResultRow(Object obj, long primaryKey, int pos, boolean bold) {
		this(obj, String.valueOf(primaryKey), pos, bold);
	}

	public ResultRow(Object obj, String primaryKey, int pos) {
		this(obj, primaryKey, pos, false);
	}

	public ResultRow(Object obj, String primaryKey, int pos, boolean bold) {
		_obj = obj;
		_primaryKey = primaryKey;
		_pos = pos;
		_bold = bold;
		_entries = new ArrayList<SearchEntry>();
	}

	public Object getObject() {
		return _obj;
	}

	public void setObject(Object obj) {
		_obj = obj;
	}

	public String getPrimaryKey() {
		return _primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		_primaryKey = primaryKey;
	}

	public int getPos() {
		return _pos;
	}

	public boolean isBold() {
		return _bold;
	}

	public void setBold(boolean bold) {
		_bold = bold;
	}

	public boolean isRestricted() {
		return _restricted;
	}

	public void setRestricted(boolean restricted) {
		_restricted = restricted;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public String getClassHoverName() {
		return _classHoverName;
	}

	public void setClassHoverName(String classHoverName) {
		_classHoverName = classHoverName;
	}

	public List<SearchEntry> getEntries() {
		return _entries;
	}

	public Object getParameter(String param) {
		if (_params == null) {
			_params = new HashMap<String, Object>();
		}

		return _params.get(param);
	}

	public void setParameter(String param, Object value) {
		if (_params == null) {
			_params = new HashMap<String, Object>();
		}

		_params.put(param, value);
	}

	// Text with name

	public void addText(String name) {
		addText(_entries.size(), name);
	}

	public void addText(int index, String name) {
		addText(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, name);
	}

	public void addText(String align, String valign, String name) {
		addText(
			_entries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN, name);
	}

	public void addText(
		String align, String valign, int colspan, String name) {

		addText(_entries.size(), align, valign, colspan, name);
	}

	public void addText(
		int index, String align, String valign, int colspan, String name) {

		_entries.add(
			index, new TextSearchEntry(align, valign, colspan, name));
	}

	// Text with name and href

	public void addText(String name, String href) {
		addText(_entries.size(), name, href);
	}

	public void addText(int index, String name, String href) {
		addText(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, name, href);
	}

	public void addText(String align, String valign, String name, String href) {
		addText(
			_entries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN, name,
			href);
	}

	public void addText(
		String align, String valign, int colspan, String name, String href) {

		addText(_entries.size(), align, valign, colspan, name, href);
	}

	public void addText(
		int index, String align, String valign, int colspan, String name,
		String href) {

		if (_restricted) {
			href = null;
		}

		_entries.add(
			index, new TextSearchEntry(align, valign, colspan, name, href));
	}

	// Text with name and portlet URL

	public void addText(String name, PortletURL portletURL) {
		if (portletURL == null) {
			addText(name);
		}
		else {
			addText(name, portletURL.toString());
		}
	}

	public void addText(int index, String name, PortletURL portletURL) {
		if (portletURL == null) {
			addText(index, name);
		}
		else {
			addText(index, name, portletURL.toString());
		}
	}

	public void addText(
		String align, String valign, String name, PortletURL portletURL) {

		addText(
			align, valign, SearchEntry.DEFAULT_COLSPAN, name, portletURL);
	}

	public void addText(
		String align, String valign, int colspan, String name,
		PortletURL portletURL) {

		if (portletURL == null) {
			addText(align, valign, colspan, name);
		}
		else {
			addText(align, valign, colspan, name, portletURL.toString());
		}
	}

	public void addText(
		int index, String align, String valign, int colspan, String name,
		PortletURL portletURL) {

		if (portletURL == null) {
			addText(index, align, valign, colspan, name);
		}
		else {
			addText(index, align, valign, colspan, name, portletURL.toString());
		}
	}

	// Text with search entry

	public void addText(TextSearchEntry searchEntry) {
		if (_restricted) {
			searchEntry.setHref(null);
		}

		_entries.add(_entries.size(), searchEntry);
	}

	public void addText(int index, TextSearchEntry searchEntry) {
		if (_restricted) {
			searchEntry.setHref(null);
		}

		_entries.add(index, searchEntry);
	}

	// Button with name and href

	public void addButton(String name, String href) {
		addButton(_entries.size(), name, href);
	}

	public void addButton(int index, String name, String href) {
		addButton(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, name, href);
	}

	public void addButton(
		String align, String valign, String name, String href) {

		addButton(
			_entries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN, name,
			href);
	}

	public void addButton(
		String align, String valign, int colspan, String name, String href) {

		addButton(_entries.size(), align, valign, colspan, name, href);
	}

	public void addButton(
		int index, String align, String valign, int colspan, String name,
		String href) {

		if (_restricted) {
			href = null;
		}

		_entries.add(
			index, new ButtonSearchEntry(align, valign, colspan, name, href));
	}

	// JSP

	public void addJSP(String path) {
		addJSP(_entries.size(), path);
	}

	public void addJSP(String align, String valign, String path) {
		addJSP(
			_entries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN, path);
	}

	public void addJSP(String align, String valign, int colspan, String path) {
		addJSP(_entries.size(), align, valign, colspan, path);
	}

	public void addJSP(int index, String path) {
		addJSP(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, path);
	}

	public void addJSP(
		int index, String align, String valign, int colspan, String path) {

		_entries.add(index, new JSPSearchEntry(align, valign, colspan, path));
	}

	// JSP with portlet context

	public void addJSP(
		String path, ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		addJSP(_entries.size(), path, servletContext, request, response);
	}

	public void addJSP(
		String align, String valign, String path, ServletContext servletContext,
		HttpServletRequest request, HttpServletResponse response) {

		addJSP(
			_entries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN, path,
			servletContext, request, response);
	}

	public void addJSP(
		String align, String valign, int colspan, String path,
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		addJSP(
			_entries.size(), align, valign, colspan, path, servletContext,
			request, response);
	}

	public void addJSP(
		int index, String path, ServletContext servletContext,
		HttpServletRequest request, HttpServletResponse response) {

		addJSP(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, path, servletContext, request,
			response);
	}

	public void addJSP(
		int index, String align, String valign, int colspan, String path,
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		_entries.add(
			index,
			new JSPSearchEntry(
				align, valign, colspan, path, servletContext, request,
				response));
	}

	// Score

	public void addScore(float score) {
		addScore(_entries.size(), score);
	}

	public void addScore(int index, float score) {
		_entries.add(index, new ScoreSearchEntry(score));
	}

	private Object _obj;
	private String _primaryKey;
	private int _pos;
	private boolean _bold;
	private boolean _restricted;
	private String _className;
	private String _classHoverName;
	private List<SearchEntry> _entries;
	private Map<String, Object> _params;

}