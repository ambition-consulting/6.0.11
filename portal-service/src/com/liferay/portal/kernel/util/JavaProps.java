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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.LogUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class JavaProps {

	public static final double JAVA_CLASS_VERSION_JDK_4 = 48.0;

	public static final double JAVA_CLASS_VERSION_JDK_5 = 49.0;

	public static final double JAVA_CLASS_VERSION_JDK_6 = 50.0;

	public static final double JAVA_CLASS_VERSION_JDK_7 = 51.0;

	public static String getJavaClassPath() {
		return _instance._javaClassPath;
	}

	public static double getJavaClassVersion() {
		return _instance._javaClassVersion;
	}

	public static String getJavaRuntimeVersion() {
		return _instance._javaRuntimeVersion;
	}

	public static double getJavaSpecificationVersion() {
		return _instance._javaSpecificationVersion;
	}

	public static String getJavaVendor() {
		return _instance._javaVendor;
	}

	public static String getJavaVersion() {
		return _instance._javaVersion;
	}

	public static String getJavaVmVersion() {
		return _instance._javaVmVersion;
	}

	public static boolean is64bit() {
		return _instance._64bit;
	}

	public static boolean isIBM() {
		return _instance._ibm;
	}

	public static boolean isJDK4() {
		if (JavaProps.getJavaClassVersion() >=
				JavaProps.JAVA_CLASS_VERSION_JDK_4) {

			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isJDK5() {
		if (JavaProps.getJavaClassVersion() >=
				JavaProps.JAVA_CLASS_VERSION_JDK_5) {

			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isJDK6() {
		if (JavaProps.getJavaClassVersion() >=
				JavaProps.JAVA_CLASS_VERSION_JDK_6) {

			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isJDK7() {
		if (JavaProps.getJavaClassVersion() >=
				JavaProps.JAVA_CLASS_VERSION_JDK_7) {

			return true;
		}
		else {
			return false;
		}
	}

	private JavaProps() {
		_javaClassPath = System.getProperty("java.class.path");
		_javaClassVersion = Double.parseDouble(System.getProperty(
			"java.class.version"));
		_javaRuntimeVersion = System.getProperty("java.runtime.version");
		_javaSpecificationVersion = Double.parseDouble(System.getProperty(
			"java.specification.version"));
		_javaVendor = System.getProperty("java.vendor");
		_javaVersion = System.getProperty("java.version");
		_javaVmVersion = System.getProperty("java.vm.version");

		_64bit = Validator.equals(
			"64", System.getProperty("sun.arch.data.model"));

		if (_javaVendor != null) {
			_ibm = _javaVendor.startsWith("IBM");
		}

		LogUtil.debug(_log, System.getProperties());
	}

	private static Log _log = LogFactoryUtil.getLog(JavaProps.class);

	private static JavaProps _instance = new JavaProps();

	private boolean _64bit;
	private boolean _ibm;
	private String _javaClassPath;
	private double _javaClassVersion;
	private String _javaRuntimeVersion;
	private double _javaSpecificationVersion;
	private String _javaVendor;
	private String _javaVersion;
	private String _javaVmVersion;

}