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

package com.liferay.portlet.communities.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.struts.JSONAction;
import com.liferay.portal.util.PropsValues;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Eduardo Lundgren
 */
public class GetLayoutsAction extends JSONAction {

	public String getJSON(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		List<Layout> layouts = getLayouts(request);

		for (Layout layout : layouts) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("hasChildren", layout.hasChildren());
			jsonObject.put("layoutId", layout.getLayoutId());
			jsonObject.put("name", layout.getName());
			jsonObject.put("parentLayoutId", layout.getParentLayoutId());
			jsonObject.put("plid", layout.getPlid());
			jsonObject.put("priority", layout.getPriority());
			jsonObject.put("privateLayout", layout.getPrivateLayout());
			jsonObject.put("type", layout.getType());

			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}

	protected List<Layout> getLayouts(HttpServletRequest request)
		throws Exception {

		long groupId = ParamUtil.getLong(request, "groupId");
		boolean privateLayout = ParamUtil.getBoolean(request, "privateLayout");
		long parentLayoutId = ParamUtil.getLong(request, "parentLayoutId");
		int start = ParamUtil.getInteger(request, "start");
		int end = start + PropsValues.LAYOUT_MANAGE_PAGES_INITIAL_CHILDREN;

		return LayoutLocalServiceUtil.getLayouts(
			groupId, privateLayout, parentLayoutId, start, end);
	}

}