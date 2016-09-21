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

package com.liferay.util.ant;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.util.xml.XMLFormatter;

import java.io.File;
import java.io.IOException;

import org.apache.axis.tools.ant.wsdl.Java2WsdlAntTask;
import org.apache.axis.tools.ant.wsdl.NamespaceMapping;
import org.apache.axis.tools.ant.wsdl.Wsdl2javaAntTask;
import org.apache.tools.ant.Project;

import org.dom4j.DocumentException;

/**
 * @author Brian Wing Shun Chan
 */
public class Java2WsddTask {

	public static String[] generateWsdd(String className, String serviceName)
		throws IOException {

		// Create temp directory

		File tempDir = new File(Time.getTimestamp());

		tempDir.mkdir();

		// axis-java2wsdl

		String wsdlFileName = tempDir + "/service.wsdl";

		int pos = className.lastIndexOf(".");

		String packagePath = className.substring(0, pos);

		String[] packagePaths = StringUtil.split(packagePath, ".");

		String namespace = "urn:";

		for (int i = packagePaths.length - 1; i >= 0; i--) {
			namespace += packagePaths[i];

			if (i > 0) {
				namespace += ".";
			}
		}

		String location = "http://localhost/services/" + serviceName;

		String mappingPackage = packagePath.substring(
			0, packagePath.lastIndexOf(".")) + ".ws";

		Project project = AntUtil.getProject();

		Java2WsdlAntTask java2Wsdl = new Java2WsdlAntTask();

		NamespaceMapping mapping = new NamespaceMapping();

		mapping.setNamespace(namespace);
		mapping.setPackage(mappingPackage);

		java2Wsdl.setProject(project);
		java2Wsdl.setClassName(className);
		java2Wsdl.setOutput(new File(wsdlFileName));
		java2Wsdl.setLocation(location);
		java2Wsdl.setNamespace(namespace);
		java2Wsdl.addMapping(mapping);

		java2Wsdl.execute();

		// axis-wsdl2java

		Wsdl2javaAntTask wsdl2Java = new Wsdl2javaAntTask();

		wsdl2Java.setProject(project);
		wsdl2Java.setURL(wsdlFileName);
		wsdl2Java.setOutput(tempDir);
		wsdl2Java.setServerSide(true);
		wsdl2Java.setTestCase(false);
		wsdl2Java.setVerbose(false);

		wsdl2Java.execute();

		// Get content

		String deployContent = FileUtil.read(
			tempDir + "/" + StringUtil.replace(packagePath, ".", "/") +
				"/deploy.wsdd");

		deployContent = StringUtil.replace(
			deployContent, packagePath + "." + serviceName + "SoapBindingImpl",
			className);

		deployContent = _format(deployContent);

		String undeployContent = FileUtil.read(
			tempDir + "/" + StringUtil.replace(packagePath, ".", "/") +
				"/undeploy.wsdd");

		undeployContent = _format(undeployContent);

		// Delete temp directory

		DeleteTask.deleteDirectory(tempDir);

		return new String[] {deployContent, undeployContent};
	}

	private static String _format(String content) throws IOException {
		content = HtmlUtil.stripComments(content);

		try {
			content = XMLFormatter.toString(content);
		}
		catch (DocumentException de) {
			de.printStackTrace();
		}

		content = StringUtil.replace(content, "\"/>", "\" />");

		return content;
	}

}