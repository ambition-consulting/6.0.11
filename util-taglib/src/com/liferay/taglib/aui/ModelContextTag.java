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

package com.liferay.taglib.aui;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 */
public class ModelContextTag extends IncludeTag {

	public void setBean(Object bean) {
		_bean = bean;
	}

	public void setModel(Class<?> model) {
		_model = model;
	}

	protected void cleanUp() {
		_bean = null;
		_model = null;
	}

	protected void setAttributes(HttpServletRequest request) {
		if (_model != null) {
			pageContext.setAttribute("aui:model-context:bean", _bean);
			pageContext.setAttribute("aui:model-context:model", _model);
		}
		else {
			pageContext.removeAttribute("aui:model-context:bean");
			pageContext.removeAttribute("aui:model-context::model");
		}
	}

	private Object _bean;
	private Class<?> _model;

}