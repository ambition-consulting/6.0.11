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
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.ContactServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.ContactServiceSoap
 * @generated
 */
public class ContactSoap implements Serializable {
	public static ContactSoap toSoapModel(Contact model) {
		ContactSoap soapModel = new ContactSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setParentContactId(model.getParentContactId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setPrefixId(model.getPrefixId());
		soapModel.setSuffixId(model.getSuffixId());
		soapModel.setMale(model.getMale());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setSmsSn(model.getSmsSn());
		soapModel.setAimSn(model.getAimSn());
		soapModel.setFacebookSn(model.getFacebookSn());
		soapModel.setIcqSn(model.getIcqSn());
		soapModel.setJabberSn(model.getJabberSn());
		soapModel.setMsnSn(model.getMsnSn());
		soapModel.setMySpaceSn(model.getMySpaceSn());
		soapModel.setSkypeSn(model.getSkypeSn());
		soapModel.setTwitterSn(model.getTwitterSn());
		soapModel.setYmSn(model.getYmSn());
		soapModel.setEmployeeStatusId(model.getEmployeeStatusId());
		soapModel.setEmployeeNumber(model.getEmployeeNumber());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setJobClass(model.getJobClass());
		soapModel.setHoursOfOperation(model.getHoursOfOperation());

		return soapModel;
	}

	public static ContactSoap[] toSoapModels(Contact[] models) {
		ContactSoap[] soapModels = new ContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactSoap[][] toSoapModels(Contact[][] models) {
		ContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactSoap[] toSoapModels(List<Contact> models) {
		List<ContactSoap> soapModels = new ArrayList<ContactSoap>(models.size());

		for (Contact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactSoap[soapModels.size()]);
	}

	public ContactSoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getParentContactId() {
		return _parentContactId;
	}

	public void setParentContactId(long parentContactId) {
		_parentContactId = parentContactId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public int getPrefixId() {
		return _prefixId;
	}

	public void setPrefixId(int prefixId) {
		_prefixId = prefixId;
	}

	public int getSuffixId() {
		return _suffixId;
	}

	public void setSuffixId(int suffixId) {
		_suffixId = suffixId;
	}

	public boolean getMale() {
		return _male;
	}

	public boolean isMale() {
		return _male;
	}

	public void setMale(boolean male) {
		_male = male;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getSmsSn() {
		return _smsSn;
	}

	public void setSmsSn(String smsSn) {
		_smsSn = smsSn;
	}

	public String getAimSn() {
		return _aimSn;
	}

	public void setAimSn(String aimSn) {
		_aimSn = aimSn;
	}

	public String getFacebookSn() {
		return _facebookSn;
	}

	public void setFacebookSn(String facebookSn) {
		_facebookSn = facebookSn;
	}

	public String getIcqSn() {
		return _icqSn;
	}

	public void setIcqSn(String icqSn) {
		_icqSn = icqSn;
	}

	public String getJabberSn() {
		return _jabberSn;
	}

	public void setJabberSn(String jabberSn) {
		_jabberSn = jabberSn;
	}

	public String getMsnSn() {
		return _msnSn;
	}

	public void setMsnSn(String msnSn) {
		_msnSn = msnSn;
	}

	public String getMySpaceSn() {
		return _mySpaceSn;
	}

	public void setMySpaceSn(String mySpaceSn) {
		_mySpaceSn = mySpaceSn;
	}

	public String getSkypeSn() {
		return _skypeSn;
	}

	public void setSkypeSn(String skypeSn) {
		_skypeSn = skypeSn;
	}

	public String getTwitterSn() {
		return _twitterSn;
	}

	public void setTwitterSn(String twitterSn) {
		_twitterSn = twitterSn;
	}

	public String getYmSn() {
		return _ymSn;
	}

	public void setYmSn(String ymSn) {
		_ymSn = ymSn;
	}

	public String getEmployeeStatusId() {
		return _employeeStatusId;
	}

	public void setEmployeeStatusId(String employeeStatusId) {
		_employeeStatusId = employeeStatusId;
	}

	public String getEmployeeNumber() {
		return _employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		_employeeNumber = employeeNumber;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getJobClass() {
		return _jobClass;
	}

	public void setJobClass(String jobClass) {
		_jobClass = jobClass;
	}

	public String getHoursOfOperation() {
		return _hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;
	}

	private long _contactId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _accountId;
	private long _parentContactId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private int _prefixId;
	private int _suffixId;
	private boolean _male;
	private Date _birthday;
	private String _smsSn;
	private String _aimSn;
	private String _facebookSn;
	private String _icqSn;
	private String _jabberSn;
	private String _msnSn;
	private String _mySpaceSn;
	private String _skypeSn;
	private String _twitterSn;
	private String _ymSn;
	private String _employeeStatusId;
	private String _employeeNumber;
	private String _jobTitle;
	private String _jobClass;
	private String _hoursOfOperation;
}