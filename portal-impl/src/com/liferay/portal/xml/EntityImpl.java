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

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.Entity;

/**
 * @author Brian Wing Shun Chan
 */
public class EntityImpl extends NodeImpl implements Entity {

	public EntityImpl(org.dom4j.Entity entity) {
		super(entity);

		_entity = entity;
	}

	public boolean equals(Object obj) {
		org.dom4j.Entity entity = ((EntityImpl)obj).getWrappedEntity();

		return _entity.equals(entity);
	}

	public org.dom4j.Entity getWrappedEntity() {
		return _entity;
	}

	public int hashCode() {
		return _entity.hashCode();
	}

	public String toString() {
		return _entity.toString();
	}

	private org.dom4j.Entity _entity;

}