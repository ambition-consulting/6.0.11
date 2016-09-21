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

package com.liferay.portlet.messageboards.model;

/**
 * The model interface for the MBThread service. Represents a row in the &quot;MBThread&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.messageboards.model.impl.MBThreadImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBThreadModel
 * @see com.liferay.portlet.messageboards.model.impl.MBThreadImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBThreadModelImpl
 * @generated
 */
public interface MBThread extends MBThreadModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a message boards thread model instance should use the {@link MBThread} interface instead.
	 */
	public java.lang.String getAttachmentsDir();

	public com.liferay.portal.model.Lock getLock();

	public boolean hasLock(long userId);

	public boolean isLocked();
}