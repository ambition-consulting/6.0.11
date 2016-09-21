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

package com.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.CountryServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.CountryServiceSoap
 * @generated
 */
public class CountrySoap implements Serializable {
	public static CountrySoap toSoapModel(Country model) {
		CountrySoap soapModel = new CountrySoap();

		soapModel.setCountryId(model.getCountryId());
		soapModel.setName(model.getName());
		soapModel.setA2(model.getA2());
		soapModel.setA3(model.getA3());
		soapModel.setNumber(model.getNumber());
		soapModel.setIdd(model.getIdd());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static CountrySoap[] toSoapModels(Country[] models) {
		CountrySoap[] soapModels = new CountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CountrySoap[][] toSoapModels(Country[][] models) {
		CountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CountrySoap[] toSoapModels(List<Country> models) {
		List<CountrySoap> soapModels = new ArrayList<CountrySoap>(models.size());

		for (Country model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CountrySoap[soapModels.size()]);
	}

	public CountrySoap() {
	}

	public long getPrimaryKey() {
		return _countryId;
	}

	public void setPrimaryKey(long pk) {
		setCountryId(pk);
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getA2() {
		return _a2;
	}

	public void setA2(String a2) {
		_a2 = a2;
	}

	public String getA3() {
		return _a3;
	}

	public void setA3(String a3) {
		_a3 = a3;
	}

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	public String getIdd() {
		return _idd;
	}

	public void setIdd(String idd) {
		_idd = idd;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _countryId;
	private String _name;
	private String _a2;
	private String _a3;
	private String _number;
	private String _idd;
	private boolean _active;
}