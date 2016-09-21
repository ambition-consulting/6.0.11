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

package com.liferay.portal.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.struts.JSONAction;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.asset.model.AssetEntryDisplay;
import com.liferay.portlet.asset.model.AssetEntryType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 * @author Karthik Sudarshan
 * @author Julio Camarero
 * @author Eduardo Lundgren
 */
public class JSONServiceAction extends JSONAction {

	public JSONServiceAction() {
		_invalidClassNames.addAll(
			ListUtil.fromArray(PropsValues.JSON_SERVICE_INVALID_CLASS_NAMES));

		if (_log.isDebugEnabled()) {
			for (String invalidClassName : _invalidClassNames) {
				_log.debug("Invalid class name " + invalidClassName);
			}
		}
	}

	public String getJSON(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		String className = ParamUtil.getString(request, "serviceClassName");
		String methodName = ParamUtil.getString(request, "serviceMethodName");
		String[] serviceParameters = getStringArrayFromJSON(
			request, "serviceParameters");
		String[] serviceParameterTypes = getStringArrayFromJSON(
			request, "serviceParameterTypes");

		if (!isValidRequest(request)) {
			return null;
		}

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		Class<?> classObj = contextClassLoader.loadClass(className);

		Object[] methodAndParameterTypes = getMethodAndParameterTypes(
			classObj, methodName, serviceParameters, serviceParameterTypes);

		if (methodAndParameterTypes != null) {
			Method method = (Method)methodAndParameterTypes[0];
			Type[] parameterTypes = (Type[])methodAndParameterTypes[1];
			Object[] args = new Object[serviceParameters.length];

			for (int i = 0; i < serviceParameters.length; i++) {
				args[i] = getArgValue(
					request, classObj, methodName, serviceParameters[i],
					parameterTypes[i]);
			}

			try {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Invoking " + classObj + " on method " +
							method.getName() + " with args " +
								Arrays.toString(args));
				}

				Object returnObj = method.invoke(classObj, args);

				if (returnObj != null) {
					return getReturnValue(returnObj, method.getReturnType());
				}
				else {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

					return jsonObject.toString();
				}
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Invoked " + classObj + " on method " +
							method.getName() + " with args " +
								Arrays.toString(args),
						e);
				}

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				if (e instanceof InvocationTargetException) {
					jsonObject.put("exception", e.getCause().toString());
				}
				else {
					jsonObject.put("exception", e.getMessage());
				}

				return jsonObject.toString();
			}
		}

		return null;
	}

	protected Object getArgValue(
			HttpServletRequest request, Class<?> classObj, String methodName,
			String parameter, Type parameterType)
		throws Exception {

		String typeNameOrClassDescriptor = getTypeNameOrClassDescriptor(
			parameterType);

		String value = ParamUtil.getString(request, parameter);

		if (Validator.isNull(value) &&
			!typeNameOrClassDescriptor.equals("[Ljava.lang.String;")) {

			return null;
		}
		else if (typeNameOrClassDescriptor.equals("boolean") ||
				 typeNameOrClassDescriptor.equals(Boolean.class.getName())) {

			return Boolean.valueOf(ParamUtil.getBoolean(request, parameter));
		}
		else if (typeNameOrClassDescriptor.equals("double") ||
				 typeNameOrClassDescriptor.equals(Double.class.getName())) {

			return new Double(ParamUtil.getDouble(request, parameter));
		}
		else if (typeNameOrClassDescriptor.equals("int") ||
				 typeNameOrClassDescriptor.equals(Integer.class.getName())) {

			return new Integer(ParamUtil.getInteger(request, parameter));
		}
		else if (typeNameOrClassDescriptor.equals("long") ||
				 typeNameOrClassDescriptor.equals(Long.class.getName())) {

			return new Long(ParamUtil.getLong(request, parameter));
		}
		else if (typeNameOrClassDescriptor.equals("short") ||
				 typeNameOrClassDescriptor.equals(Short.class.getName())) {

			return new Short(ParamUtil.getShort(request, parameter));
		}
		else if (typeNameOrClassDescriptor.equals(Date.class.getName())) {
			return new Date(ParamUtil.getLong(request, parameter));
		}
		else if (typeNameOrClassDescriptor.equals(
					ServiceContext.class.getName())) {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(value);

			jsonObject.put("javaClass", ServiceContext.class.getName());

			return ServiceContextUtil.deserialize(jsonObject);
		}
		else if (typeNameOrClassDescriptor.equals(String.class.getName())) {
			return value;
		}
		else if (typeNameOrClassDescriptor.equals("[Z")) {
			return ParamUtil.getBooleanValues(request, parameter);
		}
		else if (typeNameOrClassDescriptor.equals("[D")) {
			return ParamUtil.getDoubleValues(request, parameter);
		}
		else if (typeNameOrClassDescriptor.equals("[F")) {
			return ParamUtil.getFloatValues(request, parameter);
		}
		else if (typeNameOrClassDescriptor.equals("[I")) {
			return ParamUtil.getIntegerValues(request, parameter);
		}
		else if (typeNameOrClassDescriptor.equals("[J")) {
			return ParamUtil.getLongValues(request, parameter);
		}
		else if (typeNameOrClassDescriptor.equals("[S")) {
			return ParamUtil.getShortValues(request, parameter);
		}
		else if (typeNameOrClassDescriptor.equals("[Ljava.lang.String;")) {
			return StringUtil.split(value);
		}
		else if (typeNameOrClassDescriptor.equals("[[Z")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				boolean[][] doubleArray =
					new boolean[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					String[] curValues = StringUtil.split(values[i]);

					for (int j = 0; j < curValues.length; j++) {
						doubleArray[i][j] = GetterUtil.getBoolean(curValues[j]);
					}
				}

				return doubleArray;
			}
			else {
				return new boolean[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals("[[D")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				double[][] doubleArray =
					new double[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					String[] curValues = StringUtil.split(values[i]);

					for (int j = 0; j < curValues.length; j++) {
						doubleArray[i][j] = GetterUtil.getDouble(curValues[j]);
					}
				}

				return doubleArray;
			}
			else {
				return new double[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals("[[F")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				float[][] doubleArray =
					new float[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					String[] curValues = StringUtil.split(values[i]);

					for (int j = 0; j < curValues.length; j++) {
						doubleArray[i][j] = GetterUtil.getFloat(curValues[j]);
					}
				}

				return doubleArray;
			}
			else {
				return new float[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals("[[I")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				int[][] doubleArray =
					new int[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					String[] curValues = StringUtil.split(values[i]);

					for (int j = 0; j < curValues.length; j++) {
						doubleArray[i][j] = GetterUtil.getInteger(curValues[j]);
					}
				}

				return doubleArray;
			}
			else {
				return new int[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals("[[J")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				long[][] doubleArray =
					new long[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					String[] curValues = StringUtil.split(values[i]);

					for (int j = 0; j < curValues.length; j++) {
						doubleArray[i][j] = GetterUtil.getLong(curValues[j]);
					}
				}

				return doubleArray;
			}
			else {
				return new long[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals("[[S")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				short[][] doubleArray =
					new short[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					String[] curValues = StringUtil.split(values[i]);

					for (int j = 0; j < curValues.length; j++) {
						doubleArray[i][j] = GetterUtil.getShort(curValues[j]);
					}
				}

				return doubleArray;
			}
			else {
				return new short[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals("[[Ljava.lang.String")) {
			String[] values = request.getParameterValues(parameter);

			if ((values != null) && (values.length > 0)) {
				String[] values0 = StringUtil.split(values[0]);

				String[][] doubleArray =
					new String[values.length][values0.length];

				for (int i = 0; i < values.length; i++) {
					doubleArray[i] = StringUtil.split(values[i]);
				}

				return doubleArray;
			}
			else {
				return new String[0][0];
			}
		}
		else if (typeNameOrClassDescriptor.equals(
			"java.util.Map<java.util.Locale, java.lang.String>")) {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(value);

			return LocalizationUtil.deserialize(jsonObject);
		}
		else {
			_log.error(
				"Unsupported parameter type for class " + classObj +
					", method " + methodName + ", parameter " + parameter +
						", and type " + typeNameOrClassDescriptor);

			return null;
		}
	}

	protected Object[] getMethodAndParameterTypes(
			Class<?> classObj, String methodName, String[] parameters,
			String[] parameterTypes)
		throws Exception {

		String parameterNames = StringUtil.merge(parameters);

		String key =
			classObj.getName() + "_METHOD_NAME_" + methodName +
				"_PARAMETERS_" + parameterNames;

		Object[] methodAndParameterTypes = _methodCache.get(key);

		if (methodAndParameterTypes != null) {
			return methodAndParameterTypes;
		}

		Method method = null;
		Type[] methodParameterTypes = null;

		Method[] methods = classObj.getMethods();

		for (Method curMethod : methods) {
			if (curMethod.getName().equals(methodName)) {
				Type[] curParameterTypes = curMethod.getGenericParameterTypes();

				if (curParameterTypes.length == parameters.length) {
					if ((parameterTypes.length > 0) &&
						(parameterTypes.length == curParameterTypes.length)) {

						boolean match = true;

						for (int j = 0; j < parameterTypes.length; j++) {
							String t1 = parameterTypes[j];
							String t2 = getTypeNameOrClassDescriptor(
								curParameterTypes[j]);

							if (!t1.equals(t2)) {
								match = false;
							}
						}

						if (match) {
							method = curMethod;
							methodParameterTypes = curParameterTypes;

							break;
						}
					}
					else if (method != null) {
						_log.error(
							"Obscure method name for class " + classObj +
								", method " + methodName + ", and parameters " +
									parameterNames);

						return null;
					}
					else {
						method = curMethod;
						methodParameterTypes = curParameterTypes;
					}
				}
			}
		}

		if (method != null) {
			methodAndParameterTypes = new Object[] {
				method, methodParameterTypes
			};

			_methodCache.put(key, methodAndParameterTypes);

			return methodAndParameterTypes;
		}
		else {
			_log.error(
				"No method found for class " + classObj + ", method " +
					methodName + ", and parameters " + parameterNames);

			return null;
		}
	}

	protected String getReturnValue(AssetEntryDisplay assetEntryDisplay)
		throws Exception {

		JSONObject jsonObject = toJSONObject(assetEntryDisplay);

		return jsonObject.toString();
	}

	protected String getReturnValue(AssetEntryDisplay[] assetEntryDisplays)
		throws Exception {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetEntryDisplay assetEntryDisplay : assetEntryDisplays) {
			jsonArray.put(toJSONObject(assetEntryDisplay));
		}

		return jsonArray.toString();
	}

	protected String getReturnValue(AssetEntryType assetEntryType)
		throws Exception {

		JSONObject jsonObject = toJSONObject(assetEntryType);

		return jsonObject.toString();
	}

	protected String getReturnValue(AssetEntryType[] assetEntryTypes)
		throws Exception {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetEntryType assetEntryType : assetEntryTypes) {
			jsonArray.put(toJSONObject(assetEntryType));
		}

		return jsonArray.toString();
	}

	protected String getReturnValue(Object returnObj, Class<?> returnType)
		throws Exception {

		if ((returnObj instanceof Boolean) || (returnObj instanceof Double) ||
			(returnObj instanceof Integer) || (returnObj instanceof Long) ||
			(returnObj instanceof Short) || (returnObj instanceof String)) {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("returnValue", returnObj.toString());

			return jsonObject.toString();
		}
		else if (returnObj instanceof BaseModel<?>) {
			String serlializerClassName = getSerializerClassName(returnObj);

			MethodKey methodKey = new MethodKey(
				serlializerClassName, "toJSONObject", returnType);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, returnObj);

			JSONObject jsonObject = (JSONObject)methodHandler.invoke(false);

			return jsonObject.toString();
		}
		else if (returnObj instanceof BaseModel<?>[]) {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			BaseModel<?>[] returnArray = (BaseModel[])returnObj;

			if (returnArray.length > 0) {
				BaseModel<?> returnItem0 = returnArray[0];

				String serializerClassName = getSerializerClassName(
					returnItem0);

				MethodKey methodKey = new MethodKey(
					serializerClassName, "toJSONArray", returnType);

				MethodHandler methodHandler = new MethodHandler(
					methodKey, returnObj);

				jsonArray = (JSONArray)methodHandler.invoke(false);
			}

			return jsonArray.toString();
		}
		else if (returnObj instanceof BaseModel<?>[][]) {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			BaseModel<?>[][] returnArray = (BaseModel<?>[][])returnObj;

			if ((returnArray.length > 0) &&
				(returnArray[0].length > 0)) {

				BaseModel<?> returnItem0 = returnArray[0][0];

				String serializerClassName = getSerializerClassName(
					returnItem0);

				MethodKey methodKey = new MethodKey(
					serializerClassName, "toJSONArray", returnType);

				MethodHandler methodHandler = new MethodHandler(
					methodKey, returnObj);

				jsonArray = (JSONArray)methodHandler.invoke(false);
			}

			return jsonArray.toString();
		}
		else if (returnObj instanceof List<?>) {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			List<Object> returnList = (List<Object>)returnObj;

			if (!returnList.isEmpty()) {
				Object returnItem0 = returnList.get(0);

				String serlializerClassName = getSerializerClassName(
					returnItem0);

				MethodKey methodKey = new MethodKey(
					serlializerClassName, "toJSONArray", returnType);

				MethodHandler methodHandler = new MethodHandler(
					methodKey, returnObj);

				jsonArray = (JSONArray)methodHandler.invoke(false);
			}

			return jsonArray.toString();
		}
		else if (returnObj instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray)returnObj;

			return jsonArray.toString();
		}
		else if (returnObj instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject)returnObj;

			return jsonObject.toString();
		}
		else if (returnObj instanceof AssetEntryDisplay) {
			return getReturnValue((AssetEntryDisplay)returnObj);
		}
		else if (returnObj instanceof AssetEntryDisplay[]) {
			return getReturnValue((AssetEntryDisplay[])returnObj);
		}
		else if (returnObj instanceof AssetEntryType) {
			return getReturnValue((AssetEntryType)returnObj);
		}
		else if (returnObj instanceof AssetEntryType[]) {
			return getReturnValue((AssetEntryType[])returnObj);
		}
		else {
			return JSONFactoryUtil.serialize(returnObj);
		}
	}

	protected String getSerializerClassName(Object obj) {
		String serlializerClassName = StringUtil.replace(
			obj.getClass().getName(),
			new String[] {".model.impl.", "Impl"},
			new String[] {".service.http.", "JSONSerializer"});

		return serlializerClassName;
	}

	protected String[] getStringArrayFromJSON(
			HttpServletRequest request, String param)
		throws JSONException {

		String json = ParamUtil.getString(request, param, "[]");

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(json);

		return ArrayUtil.toStringArray(jsonArray);
	}

	protected String getTypeNameOrClassDescriptor(Type type) {
		String typeName = type.toString();

		if (typeName.contains("class ")) {
			return typeName.substring(6);
		}

		Matcher matcher = _fieldDescriptorPattern.matcher(typeName);

		while (matcher.find()) {
			String dimensions = matcher.group(2);
			String fieldDescriptor = matcher.group(1);

			if (Validator.isNull(dimensions)) {
				return fieldDescriptor;
			}

			dimensions = dimensions.replace(
				StringPool.CLOSE_BRACKET, StringPool.BLANK);

			if (fieldDescriptor.equals("boolean")) {
				fieldDescriptor = "Z";
			}
			else if (fieldDescriptor.equals("byte")) {
				fieldDescriptor = "B";
			}
			else if (fieldDescriptor.equals("char")) {
				fieldDescriptor = "C";
			}
			else if (fieldDescriptor.equals("double")) {
				fieldDescriptor = "D";
			}
			else if (fieldDescriptor.equals("float")) {
				fieldDescriptor = "F";
			}
			else if (fieldDescriptor.equals("int")) {
				fieldDescriptor = "I";
			}
			else if (fieldDescriptor.equals("long")) {
				fieldDescriptor = "J";
			}
			else if (fieldDescriptor.equals("short")) {
				fieldDescriptor = "S";
			}
			else {
				fieldDescriptor = "L".concat(fieldDescriptor).concat(
					StringPool.SEMICOLON);
			}

			return dimensions.concat(fieldDescriptor);
		}

		throw new IllegalArgumentException(type.toString() + " is invalid");
	}

	protected boolean isValidRequest(HttpServletRequest request) {
		String className = ParamUtil.getString(request, "serviceClassName");

		if (className.contains(".service.") &&
			className.endsWith("ServiceUtil") &&
			!className.endsWith("LocalServiceUtil") &&
			!_invalidClassNames.contains(className)) {

			return true;
		}
		else {
			return false;
		}
	}

	protected JSONObject toJSONObject(AssetEntryDisplay assetEntryDisplay) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("entryId", assetEntryDisplay.getEntryId());
		jsonObject.put("companyId", assetEntryDisplay.getCompanyId());
		jsonObject.put("userId", assetEntryDisplay.getUserId());
		jsonObject.put("userName", assetEntryDisplay.getUserName());
		jsonObject.put("createDate", assetEntryDisplay.getCreateDate());
		jsonObject.put("modifiedDate", assetEntryDisplay.getModifiedDate());
		jsonObject.put("classNameId", assetEntryDisplay.getClassNameId());
		jsonObject.put("className", assetEntryDisplay.getClassName());
		jsonObject.put("classPK", assetEntryDisplay.getClassPK());
		jsonObject.put("portletId", assetEntryDisplay.getPortletId());
		jsonObject.put("portletTitle", assetEntryDisplay.getPortletTitle());
		jsonObject.put("startDate", assetEntryDisplay.getStartDate());
		jsonObject.put("endDate", assetEntryDisplay.getEndDate());
		jsonObject.put("publishDate", assetEntryDisplay.getPublishDate());
		jsonObject.put("expirationDate", assetEntryDisplay.getExpirationDate());
		jsonObject.put("mimeType", assetEntryDisplay.getMimeType());
		jsonObject.put("title", assetEntryDisplay.getTitle());
		jsonObject.put("description", assetEntryDisplay.getDescription());
		jsonObject.put("summary", assetEntryDisplay.getSummary());
		jsonObject.put("url", assetEntryDisplay.getUrl());
		jsonObject.put("height", assetEntryDisplay.getHeight());
		jsonObject.put("width", assetEntryDisplay.getWidth());
		jsonObject.put("priority", assetEntryDisplay.getPriority());
		jsonObject.put("viewCount", assetEntryDisplay.getViewCount());
		jsonObject.put(
			"assetCategoryIds",
			StringUtil.merge(assetEntryDisplay.getCategoryIds()));
		jsonObject.put("assetTagNames", assetEntryDisplay.getTagNames());

		return jsonObject;
	}

	protected JSONObject toJSONObject(AssetEntryType assetEntryType) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("classNameId", assetEntryType.getClassNameId());
		jsonObject.put("className", assetEntryType.getClassName());
		jsonObject.put("portletId", assetEntryType.getPortletId());
		jsonObject.put("portletTitle", assetEntryType.getPortletTitle());

		return jsonObject;
	}

	private static Log _log = LogFactoryUtil.getLog(JSONServiceAction.class);

	private static Pattern _fieldDescriptorPattern = Pattern.compile(
		"^(.*?)((\\[\\])*)$", Pattern.DOTALL);

	private Set<String> _invalidClassNames = new HashSet<String>();
	private Map<String, Object[]> _methodCache =
		new HashMap<String, Object[]>();

}