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

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public interface LayoutTemplate
	extends Comparable<LayoutTemplate>, Plugin, Serializable {

	public String getLayoutTemplateId();

	public boolean getStandard();

	public boolean isStandard();

	public void setStandard(boolean standard);

	public String getThemeId();

	public void setThemeId(String themeId);

	public String getName();

	public void setName(String name);

	public String getTemplatePath();

	public void setTemplatePath(String templatePath);

	public String getWapTemplatePath();

	public void setWapTemplatePath(String wapWapTemplatePath);

	public String getThumbnailPath();

	public void setThumbnailPath(String thumbnailPath);

	public String getContent();

	public void setContent(String content);

	public boolean hasSetContent();

	public String getUncachedContent() throws IOException;

	public String getWapContent();

	public void setWapContent(String wapContent);

	public boolean hasSetWapContent();

	public String getUncachedWapContent() throws IOException;

	public List<String> getColumns();

	public void setColumns(List<String> columns);

	public void setServletContext(ServletContext servletContext);

	public String getServletContextName();

	public void setServletContextName(String servletContextName);

	public boolean getWARFile();

	public boolean isWARFile();

	public String getContextPath();

	public String getStaticResourcePath();

}