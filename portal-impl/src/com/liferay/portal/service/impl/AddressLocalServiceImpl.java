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

package com.liferay.portal.service.impl;

import com.liferay.portal.AddressCityException;
import com.liferay.portal.AddressStreetException;
import com.liferay.portal.AddressZipException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.base.AddressLocalServiceBaseImpl;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {

	public Address addAddress(
			long userId, String className, long classPK, String street1,
			String street2, String street3, String city, String zip,
			long regionId, long countryId, int typeId, boolean mailing,
			boolean primary)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		long classNameId = PortalUtil.getClassNameId(className);
		Date now = new Date();

		validate(
			0, user.getCompanyId(), classNameId, classPK, street1, city, zip,
			regionId, countryId, typeId, mailing, primary);

		long addressId = counterLocalService.increment();

		Address address = addressPersistence.create(addressId);

		address.setCompanyId(user.getCompanyId());
		address.setUserId(user.getUserId());
		address.setUserName(user.getFullName());
		address.setCreateDate(now);
		address.setModifiedDate(now);
		address.setClassNameId(classNameId);
		address.setClassPK(classPK);
		address.setStreet1(street1);
		address.setStreet2(street2);
		address.setStreet3(street3);
		address.setCity(city);
		address.setZip(zip);
		address.setRegionId(regionId);
		address.setCountryId(countryId);
		address.setTypeId(typeId);
		address.setMailing(mailing);
		address.setPrimary(primary);

		addressPersistence.update(address, false);

		return address;
	}

	public void deleteAddress(long addressId)
		throws PortalException, SystemException {

		addressPersistence.remove(addressId);
	}

	public void deleteAddresses(long companyId, String className, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		addressPersistence.removeByC_C_C(companyId, classNameId, classPK);
	}

	public Address getAddress(long addressId)
		throws PortalException, SystemException {

		return addressPersistence.findByPrimaryKey(addressId);
	}

	public List<Address> getAddresses() throws SystemException {
		return addressPersistence.findAll();
	}

	public List<Address> getAddresses(
			long companyId, String className, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return addressPersistence.findByC_C_C(companyId, classNameId, classPK);
	}

	public Address updateAddress(
			long addressId, String street1, String street2, String street3,
			String city, String zip, long regionId, long countryId, int typeId,
			boolean mailing, boolean primary)
		throws PortalException, SystemException {

		validate(
			addressId, 0, 0, 0, street1, city, zip, regionId, countryId, typeId,
			mailing, primary);

		Address address = addressPersistence.findByPrimaryKey(addressId);

		address.setModifiedDate(new Date());
		address.setStreet1(street1);
		address.setStreet2(street2);
		address.setStreet3(street3);
		address.setCity(city);
		address.setZip(zip);
		address.setRegionId(regionId);
		address.setCountryId(countryId);
		address.setTypeId(typeId);
		address.setMailing(mailing);
		address.setPrimary(primary);

		addressPersistence.update(address, false);

		return address;
	}

	protected void validate(
			long addressId, long companyId, long classNameId, long classPK,
			String street1, String city, String zip, long regionId,
			long countryId, int typeId, boolean mailing, boolean primary)
		throws PortalException, SystemException {

		if (Validator.isNull(street1)) {
			throw new AddressStreetException();
		}
		else if (Validator.isNull(city)) {
			throw new AddressCityException();
		}
		else if (Validator.isNull(zip)) {
			throw new AddressZipException();
		}

		if (addressId > 0) {
			Address address = addressPersistence.findByPrimaryKey(addressId);

			companyId = address.getCompanyId();
			classNameId = address.getClassNameId();
			classPK = address.getClassPK();
		}

		if ((classNameId == PortalUtil.getClassNameId(Account.class)) ||
			(classNameId == PortalUtil.getClassNameId(Contact.class)) ||
			(classNameId == PortalUtil.getClassNameId(Organization.class))) {

			listTypeService.validate(
				typeId, classNameId, ListTypeConstants.ADDRESS);
		}

		validate(addressId, companyId, classNameId, classPK, mailing, primary);
	}

	protected void validate(
			long addressId, long companyId, long classNameId, long classPK,
			boolean mailing, boolean primary)
		throws SystemException {

		// Check to make sure there isn't another address with the same company
		// id, class name, and class pk that also has mailing set to true

		if (mailing) {
			Iterator<Address> itr = addressPersistence.findByC_C_C_M(
				companyId, classNameId, classPK, mailing).iterator();

			while (itr.hasNext()) {
				Address address = itr.next();

				if ((addressId <= 0) ||
					(address.getAddressId() != addressId)) {

					address.setMailing(false);

					addressPersistence.update(address, false);
				}
			}
		}

		// Check to make sure there isn't another address with the same company
		// id, class name, and class pk that also has primary set to true

		if (primary) {
			Iterator<Address> itr = addressPersistence.findByC_C_C_P(
				companyId, classNameId, classPK, primary).iterator();

			while (itr.hasNext()) {
				Address address = itr.next();

				if ((addressId <= 0) ||
					(address.getAddressId() != addressId)) {

					address.setPrimary(false);

					addressPersistence.update(address, false);
				}
			}
		}
	}

}