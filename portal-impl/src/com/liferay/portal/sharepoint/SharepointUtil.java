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

package com.liferay.portal.sharepoint;

import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Farache
 */
public class SharepointUtil {

	public static final String VEERMER_URLENCODED =
		"application/x-vermeer-urlencoded";

	public static final String VERSION = "6.0.2.8117";

	public static void addBottom(StringBuilder sb) {
		sb.append("</body>");
		sb.append(StringPool.NEW_LINE);
		sb.append("</html>");
	}

	public static void addTop(StringBuilder sb, String methodName) {
		sb.append("<html><head><title>vermeer RPC packet</title></head>");
		sb.append(StringPool.NEW_LINE);
		sb.append("<body>");
		sb.append(StringPool.NEW_LINE);

		Property method = new Property("method", methodName + ":" + VERSION);

		sb.append(method.parse());
	}

	public static long getGroupId(String path) {
		long groupId = 0;

		String[] pathArray = getPathArray(path);

		String groupFolderName = pathArray[0];

		if (groupFolderName != null) {
			int pos = groupFolderName.lastIndexOf(CharPool.OPEN_BRACKET);

			if (pos != -1) {
				 groupId = GetterUtil.getLong(
					groupFolderName.substring(
						pos, groupFolderName.length() - 1));
			}

		}

		return groupId;
	}

	public static String[] getPathArray(String path) {
		return StringUtil.split(path, StringPool.SLASH);
	}

	public static SharepointStorage getStorage(String path) {
		String storageClass = null;

		if (path == null) {
			return null;
		}

		String[] pathArray = getPathArray(path);

		if (pathArray.length == 0) {
			storageClass = CompanySharepointStorageImpl.class.getName();
		}
		else if (pathArray.length == 1) {
			storageClass = GroupSharepointStorageImpl.class.getName();
		}
		else if (pathArray.length >= 2) {
			storageClass = getStorageClass(pathArray[1]);
		}

		return (SharepointStorage)InstancePool.get(storageClass);
	}

	public static String getStorageClass(String token) {
		return _instance._getStorageClass(token);
	}

	public static String getStorageToken(String className) {
		return _instance._getStorageToken(className);
	}

	public static Collection<String> getStorageTokens() {
		return _instance._getStorageTokens();
	}

	public static String replaceBackSlashes(String value) {
		return value.replaceAll("\\\\", StringPool.BLANK);
	}

	private SharepointUtil() {
		_storageMap = new HashMap<String, String>();

		String[] tokens = PropsUtil.getArray(
			PropsKeys.SHAREPOINT_STORAGE_TOKENS);

		for (String token: tokens) {
			Filter filter = new Filter(token);

			String className = PropsUtil.get(
				PropsKeys.SHAREPOINT_STORAGE_CLASS, filter);

			if (Validator.isNotNull(className)) {
				_storageMap.put(className, token);
			}
		}
	}

	private String _getStorageClass(String token) {
		for (Map.Entry<String, String> entry : _storageMap.entrySet()) {
			String value = entry.getValue();

			if (value.equals(token)) {
				return entry.getKey();
			}
		}

		return null;
	}

	private String _getStorageToken(String className) {
		return _storageMap.get(className);
	}

	private Collection<String> _getStorageTokens() {
		return _storageMap.values();
	}

	private static SharepointUtil _instance = new SharepointUtil();

	private final Map<String, String> _storageMap;

}