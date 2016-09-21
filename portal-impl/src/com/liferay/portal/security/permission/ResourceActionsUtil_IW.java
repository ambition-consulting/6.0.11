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

package com.liferay.portal.security.permission;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceActionsUtil_IW {
	public static ResourceActionsUtil_IW getInstance() {
		return _instance;
	}

	public void checkAction(java.lang.String name, java.lang.String actionId)
		throws com.liferay.portal.NoSuchResourceActionException {
		ResourceActionsUtil.checkAction(name, actionId);
	}

	public java.lang.String getAction(java.util.Locale locale,
		java.lang.String action) {
		return ResourceActionsUtil.getAction(locale, action);
	}

	public java.lang.String getAction(
		javax.servlet.jsp.PageContext pageContext, java.lang.String action) {
		return ResourceActionsUtil.getAction(pageContext, action);
	}

	public java.util.List<java.lang.String> getActions(
		java.util.List<com.liferay.portal.model.Permission> permissions) {
		return ResourceActionsUtil.getActions(permissions);
	}

	public java.util.List<java.lang.String> getActionsNames(
		javax.servlet.jsp.PageContext pageContext,
		java.util.List<java.lang.String> actions) {
		return ResourceActionsUtil.getActionsNames(pageContext, actions);
	}

	public java.util.List<java.lang.String> getActionsNames(
		javax.servlet.jsp.PageContext pageContext, java.lang.String name,
		long actionIds) {
		return ResourceActionsUtil.getActionsNames(pageContext, name, actionIds);
	}

	public java.util.List<java.lang.String> getModelNames() {
		return ResourceActionsUtil.getModelNames();
	}

	public java.util.List<java.lang.String> getModelPortletResources(
		java.lang.String name) {
		return ResourceActionsUtil.getModelPortletResources(name);
	}

	public java.lang.String getModelResource(java.util.Locale locale,
		java.lang.String name) {
		return ResourceActionsUtil.getModelResource(locale, name);
	}

	public java.lang.String getModelResource(
		javax.servlet.jsp.PageContext pageContext, java.lang.String name) {
		return ResourceActionsUtil.getModelResource(pageContext, name);
	}

	public java.util.List<java.lang.String> getModelResourceActions(
		java.lang.String name) {
		return ResourceActionsUtil.getModelResourceActions(name);
	}

	public java.util.List<java.lang.String> getModelResourceCommunityDefaultActions(
		java.lang.String name) {
		return ResourceActionsUtil.getModelResourceCommunityDefaultActions(name);
	}

	public java.util.List<java.lang.String> getModelResourceGuestDefaultActions(
		java.lang.String name) {
		return ResourceActionsUtil.getModelResourceGuestDefaultActions(name);
	}

	public java.util.List<java.lang.String> getModelResourceGuestUnsupportedActions(
		java.lang.String name) {
		return ResourceActionsUtil.getModelResourceGuestUnsupportedActions(name);
	}

	public java.util.List<java.lang.String> getModelResourceOwnerDefaultActions(
		java.lang.String name) {
		return ResourceActionsUtil.getModelResourceOwnerDefaultActions(name);
	}

	public java.lang.String getPortletBaseResource(java.lang.String portletName) {
		return ResourceActionsUtil.getPortletBaseResource(portletName);
	}

	public java.util.List<java.lang.String> getPortletModelResources(
		java.lang.String portletName) {
		return ResourceActionsUtil.getPortletModelResources(portletName);
	}

	public java.util.List<java.lang.String> getPortletNames() {
		return ResourceActionsUtil.getPortletNames();
	}

	public java.util.List<java.lang.String> getPortletResourceActions(
		java.lang.String name) {
		return ResourceActionsUtil.getPortletResourceActions(name);
	}

	public java.util.List<java.lang.String> getPortletResourceCommunityDefaultActions(
		java.lang.String name) {
		return ResourceActionsUtil.getPortletResourceCommunityDefaultActions(name);
	}

	public java.util.List<java.lang.String> getPortletResourceGuestDefaultActions(
		java.lang.String name) {
		return ResourceActionsUtil.getPortletResourceGuestDefaultActions(name);
	}

	public java.util.List<java.lang.String> getPortletResourceGuestUnsupportedActions(
		java.lang.String name) {
		return ResourceActionsUtil.getPortletResourceGuestUnsupportedActions(name);
	}

	public java.util.List<java.lang.String> getPortletResourceLayoutManagerActions(
		java.lang.String name) {
		return ResourceActionsUtil.getPortletResourceLayoutManagerActions(name);
	}

	public java.util.List<java.lang.String> getResourceActions(
		java.lang.String name) {
		return ResourceActionsUtil.getResourceActions(name);
	}

	public java.util.List<java.lang.String> getResourceActions(
		java.lang.String portletResource, java.lang.String modelResource) {
		return ResourceActionsUtil.getResourceActions(portletResource,
			modelResource);
	}

	public java.util.List<java.lang.String> getResourceCommunityDefaultActions(
		java.lang.String name) {
		return ResourceActionsUtil.getResourceCommunityDefaultActions(name);
	}

	public java.util.List<java.lang.String> getResourceGuestUnsupportedActions(
		java.lang.String portletResource, java.lang.String modelResource) {
		return ResourceActionsUtil.getResourceGuestUnsupportedActions(portletResource,
			modelResource);
	}

	/**
	 * @deprecated
	 */
	public java.util.List<com.liferay.portal.model.Role> getRoles(
		long companyId, com.liferay.portal.model.Group group,
		java.lang.String modelResource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return ResourceActionsUtil.getRoles(companyId, group, modelResource);
	}

	public java.util.List<com.liferay.portal.model.Role> getRoles(
		long companyId, com.liferay.portal.model.Group group,
		java.lang.String modelResource, int[] roleTypes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return ResourceActionsUtil.getRoles(companyId, group, modelResource,
			roleTypes);
	}

	public com.liferay.portlet.social.model.SocialEquityActionMapping getSocialEquityActionMapping(
		java.lang.String name, java.lang.String actionId) {
		return ResourceActionsUtil.getSocialEquityActionMapping(name, actionId);
	}

	public java.util.List<com.liferay.portlet.social.model.SocialEquityActionMapping> getSocialEquityActionMappings(
		java.lang.String name) {
		return ResourceActionsUtil.getSocialEquityActionMappings(name);
	}

	public java.lang.String[] getSocialEquityClassNames() {
		return ResourceActionsUtil.getSocialEquityClassNames();
	}

	public boolean hasModelResourceActions(java.lang.String name) {
		return ResourceActionsUtil.hasModelResourceActions(name);
	}

	public void init() {
		ResourceActionsUtil.init();
	}

	public boolean isOrganizationModelResource(java.lang.String modelResource) {
		return ResourceActionsUtil.isOrganizationModelResource(modelResource);
	}

	public boolean isPortalModelResource(java.lang.String modelResource) {
		return ResourceActionsUtil.isPortalModelResource(modelResource);
	}

	public void read(java.lang.String servletContextName,
		java.lang.ClassLoader classLoader, java.lang.String source)
		throws java.lang.Exception {
		ResourceActionsUtil.read(servletContextName, classLoader, source);
	}

	public void read(java.lang.String servletContextName,
		java.io.InputStream inputStream) throws java.lang.Exception {
		ResourceActionsUtil.read(servletContextName, inputStream);
	}

	private ResourceActionsUtil_IW() {
	}

	private static ResourceActionsUtil_IW _instance = new ResourceActionsUtil_IW();
}