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

package com.liferay.portal.monitoring.statistics.service;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.monitoring.MonitoringProcessor;
import com.liferay.portal.kernel.monitoring.RequestStatus;
import com.liferay.portal.kernel.monitoring.statistics.DataSampleThreadLocal;
import com.liferay.portal.kernel.util.AutoResetThreadLocal;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.spring.aop.ChainableMethodAdvice;

import java.lang.reflect.Method;

import java.util.HashSet;
import java.util.Set;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Michael C. Han
 */
public class ServiceMonitorAdvice extends ChainableMethodAdvice {

	/**
	 * @deprecated
	 */
	public static ServiceMonitorAdvice getInstance() {
		return new ServiceMonitorAdvice();
	}

	public void addMonitoredClass(String className) {
		_monitoredClasses.add(className);
	}

	public void addMonitoredMethod(
			String className, String methodName, String[] parameterTypes)
		throws SystemException {

		try {
			MethodKey methodKey = new MethodKey(
				className, methodName, parameterTypes);

			_monitoredMethods.add(methodKey);
		}
		catch (ClassNotFoundException cnfe) {
			throw new SystemException("Unable to add method", cnfe);
		}
	}

	public void afterReturning(MethodInvocation methodInvocation, Object result)
		throws Throwable {

		ServiceRequestDataSample serviceRequestDataSample =
			_serviceRequestDataSampleThreadLocal.get();

		if (serviceRequestDataSample != null) {
			serviceRequestDataSample.capture(RequestStatus.SUCCESS);
		}
	}

	public void afterThrowing(
			MethodInvocation methodInvocation, Throwable throwable)
		throws Throwable {

		ServiceRequestDataSample serviceRequestDataSample =
			_serviceRequestDataSampleThreadLocal.get();

		if (serviceRequestDataSample != null) {
			serviceRequestDataSample.capture(RequestStatus.ERROR);
		}
	}

	public Object before(MethodInvocation methodInvocation) throws Throwable {
		if (!_active) {
			return null;
		}

		Class<?> classObj = methodInvocation.getThis().getClass();

		Class<?>[] interfaces = classObj.getInterfaces();

		for (int i = 0; i < interfaces.length; i++) {
			if (interfaces[i].isAssignableFrom(MonitoringProcessor.class)) {
				return null;
			}
		}

		if (!_permissiveMode && !isMonitored(methodInvocation)) {
			return null;
		}

		ServiceRequestDataSample serviceRequestDataSample =
			new ServiceRequestDataSample(methodInvocation);

		serviceRequestDataSample.prepare();

		_serviceRequestDataSampleThreadLocal.set(serviceRequestDataSample);

		return null;
	}

	public void duringFinally(MethodInvocation methodInvocation) {
		ServiceRequestDataSample serviceRequestDataSample =
			_serviceRequestDataSampleThreadLocal.get();

		if (serviceRequestDataSample != null) {
			_serviceRequestDataSampleThreadLocal.remove();

			DataSampleThreadLocal.addDataSample(serviceRequestDataSample);

			MessageBusUtil.sendMessage(
				_monitoringDestinationName, serviceRequestDataSample);
		}
	}

	public Set<String> getMonitoredClasses() {
		return _monitoredClasses;
	}

	public Set<MethodKey> getMonitoredMethods() {
		return _monitoredMethods;
	}

	public String getMonitoringDestinationName() {
		return _monitoringDestinationName;
	}

	public boolean isActive() {
		return _active;
	}

	public boolean isPermissiveMode() {
		return _permissiveMode;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public void setMonitoredClasses(Set<String> monitoredClasses) {
		_monitoredClasses = monitoredClasses;
	}

	public void setMonitoredMethods(Set<MethodKey> monitoredMethods) {
		_monitoredMethods = monitoredMethods;
	}

	public void setMonitoringDestinationName(String monitoringDestinationName) {
		_monitoringDestinationName = monitoringDestinationName;
	}

	public void setPermissiveMode(boolean permissiveMode) {
		_permissiveMode = permissiveMode;
	}

	protected boolean isMonitored(MethodInvocation methodInvocation) {
		Method method = methodInvocation.getMethod();

		Class<?> declaringClass = method.getDeclaringClass();

		String className = declaringClass.getName();

		if (_monitoredClasses.contains(className)) {
			return true;
		}

		String methodName = method.getName();
		Class<?>[] parameterTypes = method.getParameterTypes();

		MethodKey methodKey = new MethodKey(
			className, methodName, parameterTypes);

		if (_monitoredMethods.contains(methodKey)) {
			return true;
		}

		return false;
	}

	private static ThreadLocal<ServiceRequestDataSample>
		_serviceRequestDataSampleThreadLocal =
			new AutoResetThreadLocal<ServiceRequestDataSample>(
				ServiceRequestDataSample.class +
					"._serviceRequestDataSampleThreadLocal");

	private static boolean _active;
	private static Set<String> _monitoredClasses = new HashSet<String>();
	private static Set<MethodKey> _monitoredMethods = new HashSet<MethodKey>();
	private static String _monitoringDestinationName;
	private static boolean _permissiveMode;

}