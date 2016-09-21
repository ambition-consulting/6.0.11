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

package com.liferay.portlet.bookmarks.model;

/**
 * The model interface for the BookmarksEntry service. Represents a row in the &quot;BookmarksEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.bookmarks.model.impl.BookmarksEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookmarksEntryModel
 * @see com.liferay.portlet.bookmarks.model.impl.BookmarksEntryImpl
 * @see com.liferay.portlet.bookmarks.model.impl.BookmarksEntryModelImpl
 * @generated
 */
public interface BookmarksEntry extends BookmarksEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a bookmarks entry model instance should use the {@link BookmarksEntry} interface instead.
	 */
	public com.liferay.portlet.bookmarks.model.BookmarksFolder getFolder();
}