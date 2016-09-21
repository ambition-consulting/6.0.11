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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutSetPrototypeImpl
	extends LayoutSetPrototypeModelImpl implements LayoutSetPrototype {

	public LayoutSetPrototypeImpl() {
	}

	public Group getGroup() throws PortalException, SystemException {
		return GroupLocalServiceUtil.getLayoutSetPrototypeGroup(
			getCompanyId(), getLayoutSetPrototypeId());
	}

	public LayoutSet getLayoutSet() throws PortalException, SystemException {
		return LayoutSetLocalServiceUtil.getLayoutSet(
			getGroup().getGroupId(), true);
	}

}