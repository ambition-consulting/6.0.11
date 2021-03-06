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

package com.liferay.portlet.journal.webdav;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.webdav.BaseResourceImpl;
import com.liferay.portal.kernel.webdav.BaseWebDAVStorageImpl;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.NoSuchStructureException;
import com.liferay.portlet.journal.NoSuchTemplateException;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateServiceUtil;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class JournalWebDAVStorageImpl extends BaseWebDAVStorageImpl {

	public int deleteResource(WebDAVRequest webDavRequest)
		throws WebDAVException {

		try {
			Resource resource = getResource(webDavRequest);

			if (resource == null) {
				return HttpServletResponse.SC_NOT_FOUND;
			}

			Object model = resource.getModel();

			if (model instanceof JournalStructure) {
				JournalStructure structure = (JournalStructure)model;

				JournalStructureServiceUtil.deleteStructure(
					structure.getGroupId(), structure.getStructureId());

				return HttpServletResponse.SC_NO_CONTENT;
			}
			else if (model instanceof JournalTemplate) {
				JournalTemplate template = (JournalTemplate)model;

				JournalTemplateServiceUtil.deleteTemplate(
					template.getGroupId(), template.getTemplateId());

				return HttpServletResponse.SC_NO_CONTENT;
			}
			else {
				return HttpServletResponse.SC_FORBIDDEN;
			}
		}
		catch (PortalException pe) {
			return HttpServletResponse.SC_FORBIDDEN;
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	public Resource getResource(WebDAVRequest webDavRequest)
		throws WebDAVException {

		try {
			String[] pathArray = webDavRequest.getPathArray();

			if (pathArray.length == 2) {
				String path = getRootPath() + webDavRequest.getPath();

				return new BaseResourceImpl(path, StringPool.BLANK, getToken());
			}
			else if (pathArray.length == 3) {
				String type = pathArray[2];

				return toResource(webDavRequest, type, false);
			}
			else if (pathArray.length == 4) {
				String type = pathArray[2];
				String journalTypeId = pathArray[3];

				if (type.equals(_TYPE_STRUCTURES)) {
					try {
						JournalStructure journalStructure =
							JournalStructureLocalServiceUtil.getStructure(
								webDavRequest.getGroupId(), journalTypeId);

						return toResource(
							webDavRequest, journalStructure, false);
					}
					catch (NoSuchStructureException nsse) {
						return null;
					}
				}
				else if (type.equals(_TYPE_TEMPLATES)) {
					try {
						JournalTemplate journalTemplate =
							JournalTemplateLocalServiceUtil.getTemplate(
								webDavRequest.getGroupId(), journalTypeId);

						return toResource(
							webDavRequest, journalTemplate, false);
					}
					catch (NoSuchTemplateException nste) {
						return null;
					}
				}
			}

			return null;
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	public List<Resource> getResources(WebDAVRequest webDavRequest)
		throws WebDAVException {

		try {
			String[] pathArray = webDavRequest.getPathArray();

			if (pathArray.length == 2) {
				return getFolders(webDavRequest);
			}
			else if (pathArray.length == 3) {
				String type = pathArray[2];

				if (type.equals(_TYPE_STRUCTURES)) {
					return getStructures(webDavRequest);
				}
				else if (type.equals(_TYPE_TEMPLATES)) {
					return getTemplates(webDavRequest);
				}
			}

			return new ArrayList<Resource>();
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	public int putResource(WebDAVRequest webDavRequest) throws WebDAVException {
		try {
			Resource resource = getResource(webDavRequest);

			if (resource == null) {
				return HttpServletResponse.SC_NOT_FOUND;
			}

			ServiceContext serviceContext = new ServiceContext();

			Object model = resource.getModel();

			if (model instanceof JournalStructure) {
				JournalStructure structure = (JournalStructure)model;

				HttpServletRequest request =
					webDavRequest.getHttpServletRequest();

				String xsd = StringUtil.read(request.getInputStream());

				JournalStructureServiceUtil.updateStructure(
					structure.getGroupId(), structure.getStructureId(),
					structure.getParentStructureId(), structure.getName(),
					structure.getDescription(), xsd, serviceContext);

				return HttpServletResponse.SC_CREATED;
			}
			else if (model instanceof JournalTemplate) {
				JournalTemplate template = (JournalTemplate)model;

				HttpServletRequest request =
					webDavRequest.getHttpServletRequest();

				String xsl = StringUtil.read(request.getInputStream());
				boolean formatXsl = true;
				File smallFile = null;

				JournalTemplateServiceUtil.updateTemplate(
					template.getGroupId(), template.getTemplateId(),
					template.getStructureId(), template.getName(),
					template.getDescription(), xsl, formatXsl,
					template.getLangType(), template.isCacheable(),
					template.isSmallImage(), template.getSmallImageURL(),
					smallFile, serviceContext);

				return HttpServletResponse.SC_CREATED;
			}
			else {
				return HttpServletResponse.SC_FORBIDDEN;
			}
		}
		catch (PortalException pe) {
			return HttpServletResponse.SC_FORBIDDEN;
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	protected List<Resource> getFolders(WebDAVRequest webDavRequest)
		throws Exception {

		List<Resource> folders = new ArrayList<Resource>();

		//folders.add(toResource(webDavRequest, _TYPE_ARTICLES, true));
		folders.add(toResource(webDavRequest, _TYPE_STRUCTURES, true));
		folders.add(toResource(webDavRequest, _TYPE_TEMPLATES, true));

		return folders;
	}

	protected List<Resource> getStructures(WebDAVRequest webDavRequest)
		throws Exception {

		List<Resource> resources = new ArrayList<Resource>();

		long groupId = webDavRequest.getGroupId();

		List<JournalStructure> structures =
			JournalStructureLocalServiceUtil.getStructures(groupId);

		for (JournalStructure structure : structures) {
			Resource resource = toResource(webDavRequest, structure, true);

			resources.add(resource);
		}

		return resources;
	}

	protected List<Resource> getTemplates(WebDAVRequest webDavRequest)
		throws Exception {

		List<Resource> resources = new ArrayList<Resource>();

		long groupId = webDavRequest.getGroupId();

		List<JournalTemplate> templates =
			JournalTemplateLocalServiceUtil.getTemplates(groupId);

		for (JournalTemplate template : templates) {
			Resource resource = toResource(webDavRequest, template, true);

			resources.add(resource);
		}

		return resources;
	}

	protected Resource toResource(
		WebDAVRequest webDavRequest, String type, boolean appendPath) {

		String parentPath = getRootPath() + webDavRequest.getPath();
		String name = StringPool.BLANK;

		if (appendPath) {
			name = type;
		}

		Resource resource = new BaseResourceImpl(parentPath, name, type);

		resource.setModel(type);

		return resource;
	}

	protected Resource toResource(
		WebDAVRequest webDavRequest, JournalStructure structure,
		boolean appendPath) {

		String parentPath = getRootPath() + webDavRequest.getPath();
		String name = StringPool.BLANK;

		if (appendPath) {
			name = structure.getStructureId();
		}

		return new JournalStructureResourceImpl(structure, parentPath, name);
	}

	protected Resource toResource(
		WebDAVRequest webDavRequest, JournalTemplate template,
		boolean appendPath) {

		String parentPath = getRootPath() + webDavRequest.getPath();
		String name = StringPool.BLANK;

		if (appendPath) {
			name = template.getTemplateId();
		}

		return new JournalTemplateResourceImpl(template, parentPath, name);
	}

	//private static final String _TYPE_ARTICLES = "Articles";

	private static final String _TYPE_STRUCTURES = "Structures";

	private static final String _TYPE_TEMPLATES = "Templates";

}