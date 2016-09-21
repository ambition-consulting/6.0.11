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

import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class JournalTemplateXSLUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public JournalTemplateXSLUpgradeColumnImpl(UpgradeColumn templateIdColumn) {
		super("xsl");

		_templateIdColumn = templateIdColumn;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		String xsl = (String)oldValue;

		return formatXSL(xsl);
	}

	protected String formatXSL(String xsl) throws Exception {
		/*if (xsl.indexOf("\\n") != -1) {
			xsl = StringUtil.replace(
				xsl, new String[] {"\\n", "\\r"}, new String[] {"\n", "\r"});
		}*/

		String templateId = (String)_templateIdColumn.getOldValue();

		if (templateId.equals("BASIC-BANNER")) {

			// 4.3 defaults to XHTML 1.0 Transitional and requires stricter CSS

			xsl = StringUtil.replace(
				xsl,
				"background-repeat: no-repeat; width: 520; height: 175;",
				"background-repeat: no-repeat; width: 520px; height: 175px;");
		}

		return xsl;
	}

	private UpgradeColumn _templateIdColumn;

}