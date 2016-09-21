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

package com.liferay.portal.upgrade.v4_3_0.util;

import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.ValueMapper;
import com.liferay.portal.kernel.upgrade.util.ValueMapperFactoryUtil;
import com.liferay.portal.upgrade.util.PKUpgradeColumnImpl;
import com.liferay.portlet.wiki.service.WikiPageResourceLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageIdUpgradeColumnImpl extends PKUpgradeColumnImpl {

	public WikiPageIdUpgradeColumnImpl(
		UpgradeColumn nodeIdColumn, UpgradeColumn titleColumn) {

		super("pageId", false);

		_nodeIdColumn = nodeIdColumn;
		_titleColumn = titleColumn;
		_wikiPageIdMapper = ValueMapperFactoryUtil.getValueMapper();
	}

	public Object getNewValue(Object oldValue) throws Exception {
		_resourcePrimKey = null;

		Object newValue = super.getNewValue(oldValue);

		Long oldNodeId = (Long)_nodeIdColumn.getOldValue();
		Long newNodeId = (Long)_nodeIdColumn.getNewValue();
		String title = (String)_titleColumn.getOldValue();

		String oldPageIdValue =
			"{nodeId=" + oldNodeId + ", title=" + title + ", version=1.0}";

		_resourcePrimKey = new Long(WikiPageResourceLocalServiceUtil.
			getPageResourcePrimKey(newNodeId.longValue(), title));

		_wikiPageIdMapper.mapValue(oldPageIdValue, _resourcePrimKey);

		return newValue;
	}

	public ValueMapper getValueMapper() {
		return _wikiPageIdMapper;
	}

	public Long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	private UpgradeColumn _nodeIdColumn;
	private UpgradeColumn _titleColumn;
	private ValueMapper _wikiPageIdMapper;
	private Long _resourcePrimKey;

}