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

package com.liferay.portal.spring;

import com.liferay.portal.util.BaseTestCase;

import java.lang.reflect.Field;

import java.util.Map;

import org.springframework.aop.framework.AdvisedSupport;

/**
 * @author Shuyang Zhou
 */
public class SpringCompatibilityTest extends BaseTestCase {

	public void testAbstractAutowireCapableBeanFactory() {
		Class<?> AbstractAutowireCapableBeanFactoryClass = null;

		try {
			AbstractAutowireCapableBeanFactoryClass = Class.forName(
				"org.springframework.beans.factory.support."
				+ "AbstractAutowireCapableBeanFactory");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}

		Field filteredPropertyDescriptorsCacheField = null;

		try {
			filteredPropertyDescriptorsCacheField =
				AbstractAutowireCapableBeanFactoryClass.getDeclaredField(
					"filteredPropertyDescriptorsCache");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}

		Class<?> filteredPropertyDescriptorsCacheClass =
			filteredPropertyDescriptorsCacheField.getType();

		if (!Map.class.isAssignableFrom(
			filteredPropertyDescriptorsCacheClass)) {
			fail(
				filteredPropertyDescriptorsCacheClass.getClass().getName() +
				" is not " + Map.class.getName());
		}
	}

	public void testAspectJExpressionPointcut() {
		Class<?> aspectJExpressionPointcutClass = null;

		try {
			aspectJExpressionPointcutClass = Class.forName(
				"org.springframework.aop.aspectj.AspectJExpressionPointcut");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}

		Field shadowMatchCacheField = null;

		try {
			shadowMatchCacheField =
				aspectJExpressionPointcutClass.getDeclaredField(
					"shadowMatchCache");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}

		Class<?> shadowMatchCacheClass = shadowMatchCacheField.getType();

		if (!Map.class.isAssignableFrom(shadowMatchCacheClass)) {
			fail(
				shadowMatchCacheClass.getClass().getName() + " is not " +
					Map.class.getName());
		}
	}

	public void testJdkDynamicAopProxy() {
		Class<?> jdkDynamicAopProxyClass = null;

		try {
			jdkDynamicAopProxyClass = Class.forName(
				"org.springframework.aop.framework.JdkDynamicAopProxy");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}

		Field advisedField = null;

		try {
			advisedField = jdkDynamicAopProxyClass.getDeclaredField("advised");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}

		Class<?> advisedSupportClass = advisedField.getType();

		if (!advisedSupportClass.equals(AdvisedSupport.class)) {
			fail(
				advisedSupportClass.getClass().getName() + " is not " +
					AdvisedSupport.class.getName());
		}
	}

}