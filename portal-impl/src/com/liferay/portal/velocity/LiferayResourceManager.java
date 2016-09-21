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

package com.liferay.portal.velocity;

import com.liferay.portal.deploy.sandbox.SandboxHandler;

import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.ResourceManagerImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayResourceManager extends ResourceManagerImpl {

	public String getLoaderNameForResource(String source) {

		// Velocity's default implementation makes its cache useless because
		// getResourceStream is called to test the availability of a template

		if (globalCache.get(source) != null) {
			return LiferayResourceLoader.class.getName();
		}
		else {
			return super.getLoaderNameForResource(source);
		}
	}

	public Resource getResource(
			String resourceName, int resourceType, String encoding)
		throws Exception {

		if (resourceName.contains(SandboxHandler.SANDBOX_MARKER)) {
			return loadResource(resourceName, resourceType, encoding);
		}
		else {
			return super.getResource(resourceName, resourceType, encoding);
		}
	}

}