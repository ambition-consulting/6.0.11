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

import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.servlet.filters.cache.CacheUtil;
import com.liferay.portal.velocity.LiferayResourceCacheUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Jon Steer
 * @author Raymond Augé
 */
public class JournalTemplateListener
	extends BaseModelListener<JournalTemplate> {

	public void onAfterRemove(JournalTemplate template) {
		clearCache(template);
	}

	public void onAfterUpdate(JournalTemplate template) {
		clearCache(template);
	}

	protected void clearCache(JournalTemplate template) {

		// Journal content

		JournalContentUtil.clearCache();

		// Layout cache

		CacheUtil.clearCache(template.getCompanyId());

		// Velocity cache

		LiferayResourceCacheUtil.remove(
			template.getCompanyId() + template.getGroupId() +
				template.getTemplateId());
	}

}