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

package com.liferay.portlet.shopping.action;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portlet.shopping.CartMinQuantityException;
import com.liferay.portlet.shopping.CouponActiveException;
import com.liferay.portlet.shopping.CouponEndDateException;
import com.liferay.portlet.shopping.CouponStartDateException;
import com.liferay.portlet.shopping.NoSuchCouponException;
import com.liferay.portlet.shopping.NoSuchItemException;
import com.liferay.portlet.shopping.model.ShoppingCart;
import com.liferay.portlet.shopping.model.ShoppingItem;
import com.liferay.portlet.shopping.service.ShoppingCartLocalServiceUtil;
import com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil;
import com.liferay.portlet.shopping.util.ShoppingUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class CartAction extends PortletAction {

public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			updateCart(actionRequest, actionResponse);

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchItemException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.shopping.error");
			}
			else if (e instanceof CartMinQuantityException ||
					 e instanceof CouponActiveException ||
					 e instanceof CouponEndDateException ||
					 e instanceof CouponStartDateException ||
					 e instanceof NoSuchCouponException) {

				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		return mapping.findForward(
			getForward(renderRequest, "portlet.shopping.cart"));
	}

	protected void updateCart(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		ShoppingCart cart = ShoppingUtil.getCart(actionRequest);

		if (cmd.equals(Constants.ADD)) {
			long itemId = ParamUtil.getLong(actionRequest, "itemId");

			String fields = ParamUtil.getString(actionRequest, "fields");

			if (Validator.isNotNull(fields)) {
				fields = "|" + fields;
			}

			ShoppingItem item = ShoppingItemLocalServiceUtil.getItem(itemId);

			if (item.getMinQuantity() > 0) {
				for (int i = 0; i < item.getMinQuantity(); i++) {
					cart.addItemId(itemId, fields);
				}
			}
			else {
				cart.addItemId(itemId, fields);
			}
		}
		else {
			String itemIds = ParamUtil.getString(actionRequest, "itemIds");
			String couponCodes = ParamUtil.getString(
				actionRequest, "couponCodes");
			int altShipping = ParamUtil.getInteger(
				actionRequest, "altShipping");
			boolean insure = ParamUtil.getBoolean(actionRequest, "insure");

			cart.setItemIds(itemIds);
			cart.setCouponCodes(couponCodes);
			cart.setAltShipping(altShipping);
			cart.setInsure(insure);
		}

		ShoppingCartLocalServiceUtil.updateCart(
			cart.getUserId(), cart.getGroupId(), cart.getItemIds(),
			cart.getCouponCodes(), cart.getAltShipping(), cart.isInsure());

		if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
			addSuccessMessage(actionRequest, actionResponse);
		}
	}

}