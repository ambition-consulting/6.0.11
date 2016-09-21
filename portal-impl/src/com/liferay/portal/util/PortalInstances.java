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

package com.liferay.portal.util;

import com.liferay.portal.NoSuchCompanyException;
import com.liferay.portal.events.EventsProcessorUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.PortletCategory;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.ldap.LDAPSettingsUtil;
import com.liferay.portal.security.ldap.PortalLDAPImporterUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Jose Oliver
 * @author Atul Patel
 * @author Mika Koivisto
 */
public class PortalInstances {

	public static void addCompanyId(long companyId) {
		_instance._addCompanyId(companyId);
	}

	public static long getCompanyId(HttpServletRequest request) {
		return _instance._getCompanyId(request);
	}

	public static long[] getCompanyIds() {
		return _instance._getCompanyIds();
	}

	public static long[] getCompanyIdsBySQL() throws SQLException {
		return _instance._getCompanyIdsBySQL();
	}

	public static long getDefaultCompanyId() {
		return _instance._getDefaultCompanyId();
	}

	public static String[] getWebIds() {
		return _instance._getWebIds();
	}

	public static long initCompany(
		ServletContext servletContext, String webId) {

		return _instance._initCompany(servletContext, webId);
	}

	public static boolean isAutoLoginIgnoreHost(String host) {
		return _instance._isAutoLoginIgnoreHost(host);
	}

	public static boolean isAutoLoginIgnorePath(String path) {
		return _instance._isAutoLoginIgnorePath(path);
	}

	public static boolean isVirtualHostsIgnoreHost(String host) {
		return _instance._isVirtualHostsIgnoreHost(host);
	}

	public static boolean isVirtualHostsIgnorePath(String path) {
		return _instance._isVirtualHostsIgnorePath(path);
	}

	private PortalInstances() {
		_companyIds = new long[0];
		_autoLoginIgnoreHosts = SetUtil.fromArray(PropsUtil.getArray(
			PropsKeys.AUTO_LOGIN_IGNORE_HOSTS));
		_autoLoginIgnorePaths = SetUtil.fromArray(PropsUtil.getArray(
			PropsKeys.AUTO_LOGIN_IGNORE_PATHS));
		_virtualHostsIgnoreHosts = SetUtil.fromArray(PropsUtil.getArray(
			PropsKeys.VIRTUAL_HOSTS_IGNORE_HOSTS));
		_virtualHostsIgnorePaths = SetUtil.fromArray(PropsUtil.getArray(
			PropsKeys.VIRTUAL_HOSTS_IGNORE_PATHS));
	}

	private void _addCompanyId(long companyId) {
		if (ArrayUtil.contains(_companyIds, companyId)) {
			return;
		}

		long[] companyIds = new long[_companyIds.length + 1];

		System.arraycopy(
			_companyIds, 0, companyIds, 0, _companyIds.length);

		companyIds[_companyIds.length] = companyId;

		_companyIds = companyIds;
	}

	private long _getCompanyId(HttpServletRequest request) {
		if (_log.isDebugEnabled()) {
			_log.debug("Get company id");
		}

		Long companyIdObj = (Long)request.getAttribute(WebKeys.COMPANY_ID);

		if (_log.isDebugEnabled()) {
			_log.debug("Company id from request " + companyIdObj);
		}

		if (companyIdObj != null) {
			return companyIdObj.longValue();
		}

		String host = PortalUtil.getHost(request);

		if (_log.isDebugEnabled()) {
			_log.debug("Host " + host);
		}

		long companyId = _getCompanyIdByVirtualHosts(host);

		if (_log.isDebugEnabled()) {
			_log.debug("Company id from host " + companyId);
		}

		if (companyId <= 0) {
			LayoutSet layoutSet = _getLayoutSetByVirtualHosts(host);

			if (layoutSet != null) {
				companyId = layoutSet.getCompanyId();

				if (_log.isDebugEnabled()) {
					_log.debug(
						"Company id " + companyId + " is associated with " +
							"layout set " + layoutSet.getLayoutSetId());
				}

				request.setAttribute(
					WebKeys.VIRTUAL_HOST_LAYOUT_SET, layoutSet);
			}
		}

		if (companyId <= 0) {
			companyId = GetterUtil.getLong(
				CookieKeys.getCookie(request, CookieKeys.COMPANY_ID));

			if (_log.isDebugEnabled()) {
				_log.debug("Company id from cookie " + companyId);
			}
		}

		if (companyId <= 0) {
			companyId = _getDefaultCompanyId();

			if (_log.isDebugEnabled()) {
				_log.debug("Default company id " + companyId);
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Set company id " + companyId);
		}

		request.setAttribute(WebKeys.COMPANY_ID, new Long(companyId));

		CompanyThreadLocal.setCompanyId(companyId);

		if (Validator.isNotNull(
				PropsValues.VIRTUAL_HOSTS_DEFAULT_COMMUNITY_NAME) &&
			(request.getAttribute(WebKeys.VIRTUAL_HOST_LAYOUT_SET) == null)) {

			try {
				Group group = GroupLocalServiceUtil.getGroup(
					companyId,
					PropsValues.VIRTUAL_HOSTS_DEFAULT_COMMUNITY_NAME);

				LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
					group.getGroupId(), false);

				if (Validator.isNull(layoutSet.getVirtualHost())) {
					request.setAttribute(
						WebKeys.VIRTUAL_HOST_LAYOUT_SET, layoutSet);
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}

		return companyId;
	}

	private long _getCompanyIdByVirtualHosts(String host) {
		if (Validator.isNull(host)) {
			return 0;
		}

		try {
			Company company = CompanyLocalServiceUtil.getCompanyByVirtualHost(
				host);

			return company.getCompanyId();
		}
		catch (NoSuchCompanyException nsce) {
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return 0;
	}

	private long[] _getCompanyIds() {
		return _companyIds;
	}

	private long[] _getCompanyIdsBySQL() throws SQLException {
		List<Long> companyIds = new ArrayList<Long>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(_GET_COMPANY_IDS);

			rs = ps.executeQuery();

			while (rs.next()) {
				long companyId = rs.getLong("companyId");

				companyIds.add(companyId);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		return ArrayUtil.toArray(
			companyIds.toArray(new Long[companyIds.size()]));
	}

	private long _getDefaultCompanyId() {
		return _companyIds[0];
	}

	private LayoutSet _getLayoutSetByVirtualHosts(String host) {
		if (Validator.isNull(host)) {
			return null;
		}

		if (_isVirtualHostsIgnoreHost(host)) {
			return null;
		}

		try {
			return LayoutSetLocalServiceUtil.getLayoutSet(host);
		}
		catch (Exception e) {
			return null;
		}
	}

	private String[] _getWebIds() {
		if (_webIds != null) {
			return _webIds;
		}

		if (Validator.isNull(PropsValues.COMPANY_DEFAULT_WEB_ID)) {
			throw new RuntimeException("Default web id must not be null");
		}

		try {
			List<Company> companies = CompanyLocalServiceUtil.getCompanies(
				false);

			List<String> webIdsList = new ArrayList<String>(companies.size());

			for (Company company : companies) {
				String webId = company.getWebId();

				if (webId.equals(PropsValues.COMPANY_DEFAULT_WEB_ID)) {
					webIdsList.add(0, webId);
				}
				else {
					webIdsList.add(webId);
				}
			}

			_webIds = webIdsList.toArray(new String[webIdsList.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		if ((_webIds == null) || (_webIds.length == 0)) {
			_webIds = new String[] {PropsValues.COMPANY_DEFAULT_WEB_ID};
		}

		return _webIds;
	}

	private long _initCompany(ServletContext servletContext, String webId) {

		// Begin initializing company

		if (_log.isDebugEnabled()) {
			_log.debug("Begin initializing company with web id " + webId);
		}

		long companyId = 0;

		try {
			Company company = CompanyLocalServiceUtil.checkCompany(webId);

			companyId = company.getCompanyId();
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		CompanyThreadLocal.setCompanyId(companyId);

		// Initialize display

		if (_log.isDebugEnabled()) {
			_log.debug("Initialize display");
		}

		try {
			String xml = HttpUtil.URLtoString(servletContext.getResource(
				"/WEB-INF/liferay-display.xml"));

			PortletCategory portletCategory =
				(PortletCategory)WebAppPool.get(
					String.valueOf(companyId), WebKeys.PORTLET_CATEGORY);

			if (portletCategory == null) {
				portletCategory = new PortletCategory();
			}

			PortletCategory newPortletCategory =
				PortletLocalServiceUtil.getEARDisplay(xml);

			portletCategory.merge(newPortletCategory);

			for (int i = 0; i < _companyIds.length; i++) {
				long currentCompanyId = _companyIds[i];

				PortletCategory currentPortletCategory =
					(PortletCategory)WebAppPool.get(
						String.valueOf(currentCompanyId),
						WebKeys.PORTLET_CATEGORY);

				if (portletCategory != null) {
					portletCategory.merge(currentPortletCategory);
				}
			}

			WebAppPool.put(
				String.valueOf(companyId), WebKeys.PORTLET_CATEGORY,
				portletCategory);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		// Check journal content search

		if (_log.isDebugEnabled()) {
			_log.debug("Check journal content search");
		}

		if (GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.JOURNAL_SYNC_CONTENT_SEARCH_ON_STARTUP))) {

			try {
				JournalContentSearchLocalServiceUtil.checkContentSearches(
					companyId);
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}

		// LDAP Import

		try {
			if (LDAPSettingsUtil.isImportOnStartup(companyId)) {
				PortalLDAPImporterUtil.importFromLDAP(companyId);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		// Process application startup events

		if (_log.isDebugEnabled()) {
			_log.debug("Process application startup events");
		}

		try {
			EventsProcessorUtil.process(
				PropsKeys.APPLICATION_STARTUP_EVENTS,
				PropsValues.APPLICATION_STARTUP_EVENTS,
				new String[] {String.valueOf(companyId)});
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		// End initializing company

		if (_log.isDebugEnabled()) {
			_log.debug(
				"End initializing company with web id " + webId +
					" and company id " + companyId);
		}

		addCompanyId(companyId);

		return companyId;
	}

	private boolean _isAutoLoginIgnoreHost(String host) {
		return _autoLoginIgnoreHosts.contains(host);
	}

	private boolean _isAutoLoginIgnorePath(String path) {
		return _autoLoginIgnorePaths.contains(path);
	}

	private boolean _isVirtualHostsIgnoreHost(String host) {
		return _virtualHostsIgnoreHosts.contains(host);
	}

	private boolean _isVirtualHostsIgnorePath(String path) {
		return _virtualHostsIgnorePaths.contains(path);
	}

	private static final String _GET_COMPANY_IDS =
		"select companyId from Company";

	private static Log _log = LogFactoryUtil.getLog(PortalInstances.class);

	private static PortalInstances _instance = new PortalInstances();

	private long[] _companyIds;
	private String[] _webIds;
	private Set<String> _autoLoginIgnoreHosts;
	private Set<String> _autoLoginIgnorePaths;
	private Set<String> _virtualHostsIgnoreHosts;
	private Set<String> _virtualHostsIgnorePaths;

}