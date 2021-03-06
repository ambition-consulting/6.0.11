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

package com.liferay.portal.tools.servicebuilder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.TextFormatter;

/**
 * @author Brian Wing Shun Chan
 * @author Charles May
 */
public class EntityColumn implements Cloneable {

	public EntityColumn(String name) {
		this(
			name, null, null, false, false, null, null, null, true, true, null,
			null, null, null, true, false);
	}

	public EntityColumn(
		String name, String dbName, String type, boolean primary,
		boolean filterPrimary, String ejbName, String mappingKey,
		String mappingTable, boolean caseSensitive, boolean orderByAscending,
		String comparator, String arrayableOperator, String idType,
		String idParam, boolean convertNull, boolean localized) {

		_name = name;
		_dbName = dbName;
		_type = type;
		_primary = primary;
		_filterPrimary = filterPrimary;
		_humanName = TextFormatter.format(name, TextFormatter.H);
		_methodName = TextFormatter.format(name, TextFormatter.G);
		_ejbName = ejbName;
		_mappingKey = mappingKey;
		_mappingTable = mappingTable;
		_caseSensitive = caseSensitive;
		_orderByAscending = orderByAscending;
		_comparator = comparator;
		_arrayableOperator = arrayableOperator;
		_idType = idType;
		_idParam = idParam;
		_convertNull = convertNull;
		_localized = localized;
	}

	public EntityColumn(
		String name, String dbName, String type, boolean primary,
		boolean filterPrimary, String ejbName, String mappingKey,
		String mappingTable, String idType, String idParam, boolean convertNull,
		boolean localized) {

		this(
			name, dbName, type, primary, filterPrimary, ejbName, mappingKey,
			mappingTable, true, true, null, null, idType, idParam, convertNull,
			localized);
	}

	public Object clone() {
		return new EntityColumn(
			getName(), getDBName(), getType(), isPrimary(), isFilterPrimary(),
			getEJBName(), getMappingKey(), getMappingTable(), isCaseSensitive(),
			isOrderByAscending(), getComparator(), getArrayableOperator(),
			getIdType(), getIdParam(), isConvertNull(), isLocalized());
	}

	public boolean equals(Object obj) {
		EntityColumn col = (EntityColumn)obj;

		String name = col.getName();

		if (_name.equals(name)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getArrayableOperator() {
		return _arrayableOperator;
	}

	public String getComparator() {
		return _comparator;
	}

	public String getDBName() {
		return _dbName;
	}

	public String getHumanCondition(boolean arrayable) {
		StringBundler sb = new StringBundler();

		sb.append(_name);
		sb.append(" ");
		sb.append(convertComparatorToHtml(_comparator));
		sb.append(" ");

		if (arrayable && hasArrayableOperator()) {
			if (isArrayableAndOperator()) {
				sb.append("all ");
			}
			else {
				sb.append("any ");
			}
		}

		sb.append("&#63;");

		return sb.toString();
	}

	public String getHumanName() {
		return _humanName;
	}

	public String getHumanNames() {
		return TextFormatter.formatPlural(getHumanName());
	}

	public String getEJBName() {
		return _ejbName;
	}

	public String getIdParam() {
		return _idParam;
	}

	public String getIdType() {
		return _idType;
	}

	public String getMappingKey() {
		return _mappingKey;
	}

	public String getMappingTable() {
		return _mappingTable;
	}

	public String getMethodName() {
		return _methodName;
	}

	public String getMethodNames() {
		return TextFormatter.formatPlural(_methodName);
	}

	public String getMethodUserUuidName() {
		return _methodName.substring(0, _methodName.length() - 2) + "Uuid";
	}

	public String getName() {
		return _name;
	}

	public String getNames() {
		return TextFormatter.formatPlural(_name);
	}

	public String getType() {
		return _type;
	}

	public String getUserUuidHumanName() {
		return TextFormatter.format(getUserUuidName(), TextFormatter.H);
	}

	public String getUserUuidName() {
		return _name.substring(0, _name.length() - 2) + "Uuid";
	}

	public boolean hasArrayableOperator() {
		if (Validator.isNotNull(_arrayableOperator)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return _name.hashCode();
	}

	public boolean isArrayableAndOperator() {
		if (_arrayableOperator.equals("AND")) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isCaseSensitive() {
		return _caseSensitive;
	}

	public boolean isCollection() {
		if (_type.equals("Collection")) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isConvertNull() {
		return _convertNull;
	}

	public boolean isFetchFinderPath() {
		return _fetchFinderPath;
	}

	public boolean isFilterPrimary() {
		return _filterPrimary;
	}

	public boolean isLocalized() {
		return _localized;
	}

	public boolean isMappingManyToMany() {
		return Validator.isNotNull(_mappingTable);
	}

	public boolean isMappingOneToMany() {
		return Validator.isNotNull(_mappingKey);
	}

	public boolean isOrderByAscending() {
		return _orderByAscending;
	}

	public boolean isPrimary() {
		return _primary;
	}

	public boolean isPrimitiveType() {
		return isPrimitiveType(true);
	}

	public boolean isPrimitiveType(boolean includeWrappers) {
		if (Character.isLowerCase(_type.charAt(0))) {
			return true;
		}

		if (!includeWrappers) {
			return false;
		}

		if (_type.equals("Boolean")) {
			return true;
		}
		else if (_type.equals("Double")) {
			return true;
		}
		else if (_type.equals("Float")) {
			return true;
		}
		else if (_type.equals("Integer")) {
			return true;
		}
		else if (_type.equals("Long")) {
			return true;
		}
		else if (_type.equals("Short")) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isUserUuid() {
		if (_type.equals("long") && _methodName.endsWith("UserId")) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setArrayableOperator(String arrayableOperator) {
		_arrayableOperator = arrayableOperator.toUpperCase();
	}

	public void setCaseSensitive(boolean caseSensitive) {
		_caseSensitive = caseSensitive;
	}

	public void setComparator(String comparator) {
		_comparator = comparator;
	}

	public void setConvertNull(boolean convertNull) {
		_convertNull = convertNull;
	}

	public void setDBName(String dbName) {
		_dbName = dbName;
	}

	public void setFetchFinderPath(boolean fetchFinderPath) {
		_fetchFinderPath = fetchFinderPath;
	}

	public void setIdParam(String idParam) {
		_idParam = idParam;
	}

	public void setIdType(String idType) {
		_idType = idType;
	}

	public void setLocalized(boolean localized) {
		_localized = localized;
	}

	public void setOrderByAscending(boolean orderByAscending) {
		_orderByAscending = orderByAscending;
	}

	protected String convertComparatorToHtml(String comparator) {
		if (comparator.equals(">")) {
			return "&gt;";
		}

		if (comparator.equals("<")) {
			return "&lt;";
		}

		if (comparator.equals(">=")) {
			return "&ge;";
		}

		if (comparator.equals("<=")) {
			return "&le;";
		}

		if (comparator.equals("!=")) {
			return "&ne;";
		}

		return comparator;
	}

	private String _arrayableOperator;
	private boolean _caseSensitive;
	private String _comparator;
	private boolean _convertNull;
	private String _dbName;
	private String _ejbName;
	private boolean _fetchFinderPath;
	private boolean _filterPrimary;
	private String _humanName;
	private String _idParam;
	private String _idType;
	private boolean _localized;
	private String _mappingKey;
	private String _mappingTable;
	private String _methodName;
	private String _name;
	private boolean _orderByAscending;
	private boolean _primary;
	private String _type;

}