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

package com.liferay.portal.jcr;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * @author Michael Young
 */
public class JCRFactoryUtil {

	public static JCRFactory getJCRFactory() {
		if (_jcrFactory == null) {
			_jcrFactory = (JCRFactory)PortalBeanLocatorUtil.locate(
				_JCR_FACTORY);
		}

		return _jcrFactory;
	}

	public static Session createSession(String workspaceName)
		throws RepositoryException {

		if (workspaceName == null) {
			workspaceName = JCRFactory.WORKSPACE_NAME;
		}

		return getJCRFactory().createSession(workspaceName);
	}

	public static Session createSession() throws RepositoryException {
		return createSession(null);
	}

	public static void initialize() throws RepositoryException {
		getJCRFactory().initialize();
	}

	public static void prepare() throws RepositoryException {
		getJCRFactory().prepare();
	}

	public static void shutdown() {
		getJCRFactory().shutdown();
	}

	private static final String _JCR_FACTORY = JCRFactory.class.getName();

	private static JCRFactory _jcrFactory;

}