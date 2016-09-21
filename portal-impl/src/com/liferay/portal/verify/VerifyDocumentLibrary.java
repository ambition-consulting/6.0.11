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

package com.liferay.portal.verify;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import java.util.List;

/**
 * @author Raymond Augé
 */
public class VerifyDocumentLibrary extends VerifyProcess {

	protected void doVerify() throws Exception {
		List<DLFileEntry> fileEntries =
			DLFileEntryLocalServiceUtil.getNoAssetFileEntries();

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Processing " + fileEntries.size() +
					" file entries with no asset");
		}

		for (DLFileEntry fileEntry : fileEntries) {
			try {
				DLFileEntryLocalServiceUtil.updateAsset(
					fileEntry.getUserId(), fileEntry, null, null, null);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to update asset for file entry " +
							fileEntry.getFileEntryId() + ": " + e.getMessage());
				}
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Assets verified for file entries");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		VerifyDocumentLibrary.class);

}