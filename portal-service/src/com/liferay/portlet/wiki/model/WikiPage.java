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

package com.liferay.portlet.wiki.model;

/**
 * The model interface for the WikiPage service. Represents a row in the &quot;WikiPage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.wiki.model.impl.WikiPageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiPageModel
 * @see com.liferay.portlet.wiki.model.impl.WikiPageImpl
 * @see com.liferay.portlet.wiki.model.impl.WikiPageModelImpl
 * @generated
 */
public interface WikiPage extends WikiPageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a wiki page model instance should use the {@link WikiPage} interface instead.
	 */
	public java.lang.String getAttachmentsDir();

	public java.lang.String[] getAttachmentsFiles()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> getChildPages();

	public com.liferay.portlet.wiki.model.WikiNode getNode();

	public com.liferay.portlet.wiki.model.WikiPage getParentPage();

	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> getParentPages();

	public com.liferay.portlet.wiki.model.WikiPage getRedirectPage();

	public void setAttachmentsDir(java.lang.String attachmentsDir);
}