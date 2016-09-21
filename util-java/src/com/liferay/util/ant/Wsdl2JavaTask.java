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

import java.io.File;

import org.apache.axis.tools.ant.wsdl.NamespaceMapping;
import org.apache.axis.tools.ant.wsdl.Wsdl2javaAntTask;

/**
 * @author Brian Wing Shun Chan
 */
public class Wsdl2JavaTask {

	public static void generateJava(String url, String output) {
		generateJava(url, output, null);
	}

	public static void generateJava(String url, String output, String mapping) {
		Wsdl2javaAntTask wsdl2Java = new Wsdl2javaAntTask();

		wsdl2Java.setProject(AntUtil.getProject());
		wsdl2Java.setURL(url);
		wsdl2Java.setOutput(new File(output));
		wsdl2Java.setServerSide(true);
		wsdl2Java.setTestCase(false);
		wsdl2Java.setVerbose(false);

		if (mapping != null) {
			NamespaceMapping namespaceMapping = new NamespaceMapping();

			namespaceMapping.setFile(new File(mapping));

			wsdl2Java.addMapping(namespaceMapping);
		}

		wsdl2Java.execute();
	}

}