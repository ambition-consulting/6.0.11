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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the JournalArticleResource service. Represents a row in the &quot;JournalArticleResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.journal.model.impl.JournalArticleResourceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.journal.model.impl.JournalArticleResourceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleResource
 * @see com.liferay.portlet.journal.model.impl.JournalArticleResourceImpl
 * @see com.liferay.portlet.journal.model.impl.JournalArticleResourceModelImpl
 * @generated
 */
public interface JournalArticleResourceModel extends BaseModel<JournalArticleResource> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a journal article resource model instance should use the {@link JournalArticleResource} interface instead.
	 */

	/**
	 * Gets the primary key of this journal article resource.
	 *
	 * @return the primary key of this journal article resource
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this journal article resource
	 *
	 * @param pk the primary key of this journal article resource
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this journal article resource.
	 *
	 * @return the uuid of this journal article resource
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this journal article resource.
	 *
	 * @param uuid the uuid of this journal article resource
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the resource prim key of this journal article resource.
	 *
	 * @return the resource prim key of this journal article resource
	 */
	public long getResourcePrimKey();

	/**
	 * Sets the resource prim key of this journal article resource.
	 *
	 * @param resourcePrimKey the resource prim key of this journal article resource
	 */
	public void setResourcePrimKey(long resourcePrimKey);

	/**
	 * Gets the group id of this journal article resource.
	 *
	 * @return the group id of this journal article resource
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this journal article resource.
	 *
	 * @param groupId the group id of this journal article resource
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the article id of this journal article resource.
	 *
	 * @return the article id of this journal article resource
	 */
	@AutoEscape
	public String getArticleId();

	/**
	 * Sets the article id of this journal article resource.
	 *
	 * @param articleId the article id of this journal article resource
	 */
	public void setArticleId(String articleId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(JournalArticleResource journalArticleResource);

	public int hashCode();

	public JournalArticleResource toEscapedModel();

	public String toString();

	public String toXmlString();
}