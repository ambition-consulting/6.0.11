<%--
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
--%>

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portal.AccountNameException" %>
<%@ page import="com.liferay.portal.CompanyMxException" %>
<%@ page import="com.liferay.portal.CompanyVirtualHostException" %>
<%@ page import="com.liferay.portal.CompanyWebIdException" %>
<%@ page import="com.liferay.portal.captcha.recaptcha.ReCaptchaImpl" %>
<%@ page import="com.liferay.portal.convert.ConvertProcess" %>
<%@ page import="com.liferay.portal.dao.shard.ManualShardSelector" %>
<%@ page import="com.liferay.portal.kernel.plugin.PluginPackage" %>
<%@ page import="com.liferay.portal.kernel.scripting.ScriptingUtil" %>
<%@ page import="com.liferay.portal.kernel.util.InstancePool" %>
<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.Element" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@ page import="com.liferay.portal.security.permission.ResourceActionsUtil" %>
<%@ page import="com.liferay.portal.servlet.PortalSessionContext" %>

<%@ page import="java.awt.BasicStroke" %>
<%@ page import="java.awt.Color" %>
<%@ page import="java.awt.Font" %>

<%@ page import="java.lang.reflect.Method" %>

<%@ page import="org.apache.commons.collections.map.MultiValueMap" %>
<%@ page import="org.apache.log4j.Level" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="org.apache.log4j.LogManager" %>

<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.DialShape" %>
<%@ page import="org.jfree.chart.plot.MeterInterval" %>
<%@ page import="org.jfree.chart.plot.MeterPlot" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.data.Range" %>
<%@ page import="org.jfree.data.general.DefaultValueDataset" %>

<%
boolean showShardSelector = false;

if (PropsValues.SHARD_SELECTOR.equals(ManualShardSelector.class.getName()) && PropsValues.SHARD_AVAILABLE_NAMES.length > 1) {
	showShardSelector = true;
}
%>