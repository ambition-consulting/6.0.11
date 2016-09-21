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

package com.liferay.portlet.journal.model;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public interface JournalArticleDisplay extends Serializable {

	public long getCompanyId();

	public long getId();

	public long getResourcePrimKey();

	public long getGroupId();

	public long getUserId();

	public String getArticleId();

	public double getVersion();

	public String getTitle();

	public String getUrlTitle();

	public String getDescription();

	public String[] getAvailableLocales();

	public String getContent();

	public void setContent(String content);

	public String getType();

	public String getStructureId();

	public void setStructureId(String structureId);

	public String getTemplateId();

	public void setTemplateId(String templateId);

	public boolean isSmallImage();

	public void setSmallImage(boolean smallImage);

	public long getSmallImageId();

	public void setSmallImageId(long smallImageId);

	public String getSmallImageURL();

	public void setSmallImageURL(String smallImageURL);

	public int getNumberOfPages();

	public void setNumberOfPages(int numberOfPages);

	public int getCurrentPage();

	public void setCurrentPage(int currentPage);

	public boolean isPaginate();

	public void setPaginate(boolean paginate);

	public boolean isCacheable();

	public void setCacheable(boolean cacheable);

}