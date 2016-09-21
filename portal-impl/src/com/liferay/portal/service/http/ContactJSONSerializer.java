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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Contact;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ContactJSONSerializer {
	public static JSONObject toJSONObject(Contact model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("contactId", model.getContactId());
		jsonObject.put("companyId", model.getCompanyId());
		jsonObject.put("userId", model.getUserId());
		jsonObject.put("userName", model.getUserName());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObject.put("createDate", createDateJSON);

		Date modifiedDate = model.getModifiedDate();

		String modifiedDateJSON = StringPool.BLANK;

		if (modifiedDate != null) {
			modifiedDateJSON = String.valueOf(modifiedDate.getTime());
		}

		jsonObject.put("modifiedDate", modifiedDateJSON);
		jsonObject.put("accountId", model.getAccountId());
		jsonObject.put("parentContactId", model.getParentContactId());
		jsonObject.put("firstName", model.getFirstName());
		jsonObject.put("middleName", model.getMiddleName());
		jsonObject.put("lastName", model.getLastName());
		jsonObject.put("prefixId", model.getPrefixId());
		jsonObject.put("suffixId", model.getSuffixId());
		jsonObject.put("male", model.getMale());

		Date birthday = model.getBirthday();

		String birthdayJSON = StringPool.BLANK;

		if (birthday != null) {
			birthdayJSON = String.valueOf(birthday.getTime());
		}

		jsonObject.put("birthday", birthdayJSON);
		jsonObject.put("smsSn", model.getSmsSn());
		jsonObject.put("aimSn", model.getAimSn());
		jsonObject.put("facebookSn", model.getFacebookSn());
		jsonObject.put("icqSn", model.getIcqSn());
		jsonObject.put("jabberSn", model.getJabberSn());
		jsonObject.put("msnSn", model.getMsnSn());
		jsonObject.put("mySpaceSn", model.getMySpaceSn());
		jsonObject.put("skypeSn", model.getSkypeSn());
		jsonObject.put("twitterSn", model.getTwitterSn());
		jsonObject.put("ymSn", model.getYmSn());
		jsonObject.put("employeeStatusId", model.getEmployeeStatusId());
		jsonObject.put("employeeNumber", model.getEmployeeNumber());
		jsonObject.put("jobTitle", model.getJobTitle());
		jsonObject.put("jobClass", model.getJobClass());
		jsonObject.put("hoursOfOperation", model.getHoursOfOperation());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Contact[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Contact model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Contact[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Contact[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Contact> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Contact model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}