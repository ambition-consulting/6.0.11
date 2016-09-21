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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

/**
 * The base implementation for all model classes. This class should never need
 * to be used directly.
 *
 * @author Brian Wing Shun Chan
 */
public abstract class BaseModelImpl<T> implements BaseModel<T> {

	public BaseModelImpl() {
	}

	public boolean isNew() {
		return _new;
	}

	public void setNew(boolean n) {
		_new = n;
	}

	public boolean isCachedModel() {
		return _cachedModel;
	}

	public void setCachedModel(boolean cachedModel) {
		_cachedModel = cachedModel;
	}

	public boolean isEscapedModel() {
		return _escapedModel;
	}

	public void setEscapedModel(boolean escapedModel) {
		_escapedModel = escapedModel;
	}

	public ExpandoBridge getExpandoBridge() {
		throw new UnsupportedOperationException();
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		throw new UnsupportedOperationException();
	}

	public abstract Object clone();

	public T toEscapedModel() {
		throw new UnsupportedOperationException();
	}

	private boolean _new;
	private boolean _cachedModel;
	private boolean _escapedModel;

}