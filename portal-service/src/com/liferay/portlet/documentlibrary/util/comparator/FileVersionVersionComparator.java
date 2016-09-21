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

package com.liferay.portlet.documentlibrary.util.comparator;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;

import java.util.Comparator;

/**
 * @author Bruno Farache
 */
public class FileVersionVersionComparator
	implements Comparator<DLFileVersion> {

	public FileVersionVersionComparator() {
		this(false);
	}

	public FileVersionVersionComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(DLFileVersion fileVersion1, DLFileVersion fileVersion2) {
		int value = 0;

		int[] versionParts1 = StringUtil.split(
			fileVersion1.getVersion(), StringPool.PERIOD, 0);
		int[] versionParts2 = StringUtil.split(
			fileVersion2.getVersion(), StringPool.PERIOD, 0);

		if ((versionParts1.length != 2) && (versionParts2.length != 2)) {
			value = 0;
		}
		else if ((versionParts1.length != 2)) {
			value = -1;
		}
		else if ((versionParts2.length != 2)) {
			value = 1;
		}
		else if (versionParts1[0] > versionParts2[0]) {
			value = 1;
		}
		else if (versionParts1[0] < versionParts2[0]) {
			value = -1;
		}
		else if (versionParts1[1] > versionParts2[1]) {
			value = 1;
		}
		else if (versionParts1[1] < versionParts2[1]) {
			value = -1;
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}