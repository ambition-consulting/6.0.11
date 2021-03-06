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

package com.liferay.portal.sharepoint.methods;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.sharepoint.SharepointException;
import com.liferay.portal.sharepoint.SharepointRequest;
import com.liferay.portal.util.PropsUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Farache
 */
public class MethodFactory {

	public static Method create(SharepointRequest sharepointRequest)
		throws SharepointException {

		return _instance._create(sharepointRequest);
	}

	private MethodFactory() {
		_methods = new HashMap<String, Object>();

		Method method = (Method)InstancePool.get(
			_CREATE_URL_DIRECTORIES_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_GET_DOCS_META_INFO_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_GET_DOCUMENT_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_LIST_DOCUMENTS_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_MOVE_DOCUMENT_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_OPEN_SERVICE_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_PUT_DOCUMENT_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_REMOVE_DOCUMENTS_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_SERVER_VERSION_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_UNCHECKOUT_DOCUMENT_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);

		method = (Method)InstancePool.get(_URL_TO_WEB_URL_METHOD_IMPL);

		_methods.put(method.getMethodName(), method);
	}

	private Method _create(SharepointRequest sharepointRequest)
		throws SharepointException {

		String method = sharepointRequest.getParameterValue("method");

		method = method.split(StringPool.COLON)[0];

		if (_log.isDebugEnabled()) {
			_log.debug("Get method " + method);
		}

		Method methodImpl = (Method)_methods.get(method);

		if (methodImpl == null) {
			throw new SharepointException(
				"Method " + method + " is not implemented");
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Method " + method + " is mapped to " +
						methodImpl.getClass().getName());
			}
		}

		return methodImpl;
	}

	private static final String _CREATE_URL_DIRECTORIES_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(
				MethodFactory.class.getName() + ".CREATE_URL_DIRECTORIES"),
			CreateURLDirectoriesMethodImpl.class.getName());

	private static final String _GET_DOCS_META_INFO_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(
				MethodFactory.class.getName() + ".GET_DOCS_META_INFO"),
			GetDocsMetaInfoMethodImpl.class.getName());

	private static final String _GET_DOCUMENT_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".GET_DOCUMENT"),
			GetDocumentMethodImpl.class.getName());

	private static final String _LIST_DOCUMENTS_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".LIST_DOCUMENTS"),
			ListDocumentsMethodImpl.class.getName());

	private static final String _MOVE_DOCUMENT_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".MOVE_DOCUMENT"),
			MoveDocumentMethodImpl.class.getName());

	private static final String _OPEN_SERVICE_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".OPEN_SERVICE"),
			OpenServiceMethodImpl.class.getName());

	private static final String _PUT_DOCUMENT_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".PUT_DOCUMENT"),
			PutDocumentMethodImpl.class.getName());

	private static final String _REMOVE_DOCUMENTS_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".REMOVE_DOCUMENTS"),
			RemoveDocumentsMethodImpl.class.getName());

	private static final String _SERVER_VERSION_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".SERVER_VERSION"),
			ServerVersionMethodImpl.class.getName());

	private static final String _UNCHECKOUT_DOCUMENT_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(
				MethodFactory.class.getName() + ".UNCHECKOUT_DOCUMENT"),
			UncheckoutDocumentMethodImpl.class.getName());

	private static final String _URL_TO_WEB_URL_METHOD_IMPL =
		GetterUtil.getString(
			PropsUtil.get(MethodFactory.class.getName() + ".URL_TO_WEB_URL"),
			UrlToWebUrlMethodImpl.class.getName());

	private static Log _log = LogFactoryUtil.getLog(MethodFactory.class);

	private static MethodFactory _instance = new MethodFactory();

	private Map<String, Object> _methods;

}