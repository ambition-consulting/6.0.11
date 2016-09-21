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

import com.liferay.portal.servlet.filters.cache.CacheUtil;

/**
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class LayoutListener extends BaseModelListener<Layout> {

	public void onAfterCreate(Layout layout) {
		clearCache(layout);
	}

	public void onAfterRemove(Layout layout) {
		clearCache(layout);
	}

	public void onAfterUpdate(Layout layout) {
		clearCache(layout);
	}

	protected void clearCache(Layout layout) {
		if (!layout.isPrivateLayout()) {
			CacheUtil.clearCache(layout.getCompanyId());
		}
	}

}