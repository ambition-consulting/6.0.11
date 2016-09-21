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

package com.liferay.portal.kernel.velocity;

import java.io.Writer;

/**
 * @author Raymond Augé
 */
public class VelocityEngineUtil {

	public static void flushTemplate(String resource) {
		getVelocityEngine().flushTemplate(resource);
	}

	public static VelocityContext getEmptyContext() {
		return getVelocityEngine().getEmptyContext();
	}

	public static VelocityContext getRestrictedToolsContext() {
		return getVelocityEngine().getRestrictedToolsContext();
	}

	public static VelocityContext getStandardToolsContext() {
		return getVelocityEngine().getStandardToolsContext();
	}

	public static VelocityEngine getVelocityEngine() {
		return _velocityEngine;
	}

	public static VelocityContext getWrappedRestrictedToolsContext() {
		return getVelocityEngine().getWrappedRestrictedToolsContext();
	}

	public static VelocityContext getWrappedStandardToolsContext() {
		return getVelocityEngine().getWrappedStandardToolsContext();
	}

	public static void init() throws Exception {
		getVelocityEngine().init();
	}

	public static boolean mergeTemplate(
			String velocityTemplateId, String velocityTemplateContent,
			VelocityContext velocityContext, Writer writer)
		throws Exception {

		return getVelocityEngine().mergeTemplate(
			velocityTemplateId, velocityTemplateContent, velocityContext,
			writer);
	}

	public static boolean mergeTemplate(
			String velocityTemplateId, VelocityContext velocityContext,
			Writer writer)
		throws Exception {

		return getVelocityEngine().mergeTemplate(
			velocityTemplateId, velocityContext, writer);
	}

	public static boolean resourceExists(String resource) {
		return getVelocityEngine().resourceExists(resource);
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		_velocityEngine = velocityEngine;
	}

	private static VelocityEngine _velocityEngine;

}