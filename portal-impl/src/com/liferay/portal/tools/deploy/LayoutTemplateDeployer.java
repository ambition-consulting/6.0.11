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

package com.liferay.portal.tools.deploy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.util.InitUtil;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutTemplateDeployer extends BaseDeployer {

	public static void main(String[] args) {
		InitUtil.initWithSpring();

		List<String> wars = new ArrayList<String>();
		List<String> jars = new ArrayList<String>();

		for (String arg : args) {
			if (arg.endsWith(".war")) {
				wars.add(arg);
			}
			else if (arg.endsWith(".jar")) {
				jars.add(arg);
			}
		}

		new LayoutTemplateDeployer(wars, jars);
	}

	public LayoutTemplateDeployer() {
	}

	public LayoutTemplateDeployer(List<String> wars, List<String> jars) {
		super(wars, jars);
	}

	public String getExtraContent(
			double webXmlVersion, File srcFile, String displayName)
		throws Exception {

		StringBundler sb = new StringBundler(7);

		String extraContent = super.getExtraContent(
			webXmlVersion, srcFile, displayName);

		sb.append(extraContent);

		sb.append("<listener>");
		sb.append("<listener-class>");
		sb.append("com.liferay.portal.kernel.servlet.");
		sb.append("LayoutTemplateContextListener");
		sb.append("</listener-class>");
		sb.append("</listener>");

		return sb.toString();
	}

}