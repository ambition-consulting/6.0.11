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

package com.liferay.portlet.wiki.service;

/**
 * <p>
 * This class is a wrapper for {@link WikiNodeService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WikiNodeService
 * @generated
 */
public class WikiNodeServiceWrapper implements WikiNodeService {
	public WikiNodeServiceWrapper(WikiNodeService wikiNodeService) {
		_wikiNodeService = wikiNodeService;
	}

	public com.liferay.portlet.wiki.model.WikiNode addNode(
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiNodeService.addNode(name, description, serviceContext);
	}

	public void deleteNode(long nodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wikiNodeService.deleteNode(nodeId);
	}

	public com.liferay.portlet.wiki.model.WikiNode getNode(long nodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiNodeService.getNode(nodeId);
	}

	public com.liferay.portlet.wiki.model.WikiNode getNode(long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiNodeService.getNode(groupId, name);
	}

	public void importPages(long nodeId, java.lang.String importer,
		java.io.File[] files,
		java.util.Map<java.lang.String, java.lang.String[]> options)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wikiNodeService.importPages(nodeId, importer, files, options);
	}

	public void subscribeNode(long nodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wikiNodeService.subscribeNode(nodeId);
	}

	public void unsubscribeNode(long nodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wikiNodeService.unsubscribeNode(nodeId);
	}

	public com.liferay.portlet.wiki.model.WikiNode updateNode(long nodeId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiNodeService.updateNode(nodeId, name, description,
			serviceContext);
	}

	public WikiNodeService getWrappedWikiNodeService() {
		return _wikiNodeService;
	}

	public void setWrappedWikiNodeService(WikiNodeService wikiNodeService) {
		_wikiNodeService = wikiNodeService;
	}

	private WikiNodeService _wikiNodeService;
}