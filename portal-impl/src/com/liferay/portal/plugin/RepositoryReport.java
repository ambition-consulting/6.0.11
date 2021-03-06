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

package com.liferay.portal.plugin;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Jorge Ferrer
 */
public class RepositoryReport {

	public static final String SUCCESS = "success";

	public void addSuccess(String repositoryURL) {
		_reportMap.put(repositoryURL, SUCCESS);
	}

	public void addError(String repositoryURL, PluginPackageException ppe) {
		StringBundler sb = new StringBundler(3);

		if (Validator.isNotNull(ppe.getMessage())) {
			sb.append(ppe.getMessage());
		}

		if ((ppe.getCause() != null) &&
			Validator.isNull(ppe.getCause().getMessage())) {

			sb.append(ppe.getCause().getMessage());
		}

		if (sb.length() == 0) {
			sb.append(ppe.toString());
		}

		_reportMap.put(repositoryURL, sb.toString());
	}

	public Set<String> getRepositoryURLs() {
		return _reportMap.keySet();
	}

	public String getState(String repositoryURL) {
		return _reportMap.get(repositoryURL);
	}

	public String toString() {
		Iterator<String> itr = getRepositoryURLs().iterator();

		if (getRepositoryURLs().isEmpty()) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(getRepositoryURLs().size() * 3);

		while (itr.hasNext()) {
			String repositoryURL = itr.next();

			sb.append(repositoryURL);
			sb.append(": ");
			sb.append(_reportMap.get(repositoryURL));
		}

		return sb.toString();
	}

	private Map<String, String> _reportMap = new TreeMap<String, String>();

}