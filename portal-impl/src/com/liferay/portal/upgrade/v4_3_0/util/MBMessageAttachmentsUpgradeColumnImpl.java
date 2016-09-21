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

import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.model.CompanyConstants;

/**
 * @author Brian Wing Shun Chan
 */
public class MBMessageAttachmentsUpgradeColumnImpl
	extends BaseUpgradeColumnImpl {

	public MBMessageAttachmentsUpgradeColumnImpl(
		UpgradeColumn messageIdColumn, UpgradeColumn companyIdColumn,
		UpgradeColumn threadIdColumn) {

		super("attachments");

		_messageIdColumn = messageIdColumn;
		_companyIdColumn = companyIdColumn;
		_threadIdColumn = threadIdColumn;
	}

	public Object getNewValue(Object oldValue) throws Exception {
		Boolean attachments = (Boolean)oldValue;

		if (attachments.booleanValue()) {
			Long oldMessageId = (Long)_messageIdColumn.getOldValue();
			String oldCompanyId = (String)_companyIdColumn.getOldValue();
			Long oldThreadId = (Long)_threadIdColumn.getOldValue();

			Long newMessageId = (Long)_messageIdColumn.getNewValue();
			Long newCompanyId = (Long)_companyIdColumn.getNewValue();
			Long newThreadId = (Long)_threadIdColumn.getNewValue();

			try {
				DLLocalServiceUtil.addDirectory(
					newCompanyId.longValue(), CompanyConstants.SYSTEM,
					"messageboards/" + newThreadId);

				DLLocalServiceUtil.move(
					"/" + oldCompanyId +
						"/documentlibrary/system/messageboards/" + oldThreadId +
							"/" + oldMessageId,
					"/" + newCompanyId + "/documentlibrary/0/messageboards/" +
						newThreadId + "/" + newMessageId);
			}
			catch (Exception e) {
				_log.error(e.getMessage());
			}
		}

		return attachments;
	}

	private static Log _log = LogFactoryUtil.getLog(
		MBMessageAttachmentsUpgradeColumnImpl.class);

	private UpgradeColumn _messageIdColumn;
	private UpgradeColumn _companyIdColumn;
	private UpgradeColumn _threadIdColumn;

}