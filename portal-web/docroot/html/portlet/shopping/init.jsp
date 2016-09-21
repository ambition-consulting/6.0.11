<%--
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
--%>

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portlet.shopping.BillingCityException" %>
<%@ page import="com.liferay.portlet.shopping.BillingCountryException" %>
<%@ page import="com.liferay.portlet.shopping.BillingEmailAddressException" %>
<%@ page import="com.liferay.portlet.shopping.BillingFirstNameException" %>
<%@ page import="com.liferay.portlet.shopping.BillingLastNameException" %>
<%@ page import="com.liferay.portlet.shopping.BillingPhoneException" %>
<%@ page import="com.liferay.portlet.shopping.BillingStateException" %>
<%@ page import="com.liferay.portlet.shopping.BillingStreetException" %>
<%@ page import="com.liferay.portlet.shopping.BillingZipException" %>
<%@ page import="com.liferay.portlet.shopping.CartMinQuantityException" %>
<%@ page import="com.liferay.portlet.shopping.CategoryNameException" %>
<%@ page import="com.liferay.portlet.shopping.CCExpirationException" %>
<%@ page import="com.liferay.portlet.shopping.CCNameException" %>
<%@ page import="com.liferay.portlet.shopping.CCNumberException" %>
<%@ page import="com.liferay.portlet.shopping.CCTypeException" %>
<%@ page import="com.liferay.portlet.shopping.CouponActiveException" %>
<%@ page import="com.liferay.portlet.shopping.CouponCodeException" %>
<%@ page import="com.liferay.portlet.shopping.CouponDateException" %>
<%@ page import="com.liferay.portlet.shopping.CouponDescriptionException" %>
<%@ page import="com.liferay.portlet.shopping.CouponDiscountException" %>
<%@ page import="com.liferay.portlet.shopping.CouponEndDateException" %>
<%@ page import="com.liferay.portlet.shopping.CouponLimitCategoriesException" %>
<%@ page import="com.liferay.portlet.shopping.CouponLimitSKUsException" %>
<%@ page import="com.liferay.portlet.shopping.CouponMinimumOrderException" %>
<%@ page import="com.liferay.portlet.shopping.CouponNameException" %>
<%@ page import="com.liferay.portlet.shopping.CouponStartDateException" %>
<%@ page import="com.liferay.portlet.shopping.DuplicateCouponCodeException" %>
<%@ page import="com.liferay.portlet.shopping.DuplicateItemSKUException" %>
<%@ page import="com.liferay.portlet.shopping.ItemLargeImageNameException" %>
<%@ page import="com.liferay.portlet.shopping.ItemLargeImageSizeException" %>
<%@ page import="com.liferay.portlet.shopping.ItemMediumImageNameException" %>
<%@ page import="com.liferay.portlet.shopping.ItemMediumImageSizeException" %>
<%@ page import="com.liferay.portlet.shopping.ItemNameException" %>
<%@ page import="com.liferay.portlet.shopping.ItemSKUException" %>
<%@ page import="com.liferay.portlet.shopping.ItemSmallImageNameException" %>
<%@ page import="com.liferay.portlet.shopping.ItemSmallImageSizeException" %>
<%@ page import="com.liferay.portlet.shopping.NoSuchCategoryException" %>
<%@ page import="com.liferay.portlet.shopping.NoSuchCouponException" %>
<%@ page import="com.liferay.portlet.shopping.NoSuchItemException" %>
<%@ page import="com.liferay.portlet.shopping.NoSuchOrderException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingCityException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingCountryException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingEmailAddressException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingFirstNameException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingLastNameException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingPhoneException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingStateException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingStreetException" %>
<%@ page import="com.liferay.portlet.shopping.ShippingZipException" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingCart" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingCartItem" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingCategory" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingCategoryConstants" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingCoupon" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingCouponConstants" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingItem" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingItemField" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingItemPrice" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingItemPriceConstants" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingOrder" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingOrderConstants" %>
<%@ page import="com.liferay.portlet.shopping.model.ShoppingOrderItem" %>
<%@ page import="com.liferay.portlet.shopping.search.CouponDisplayTerms" %>
<%@ page import="com.liferay.portlet.shopping.search.CouponSearch" %>
<%@ page import="com.liferay.portlet.shopping.search.CouponSearchTerms" %>
<%@ page import="com.liferay.portlet.shopping.search.OrderDisplayTerms" %>
<%@ page import="com.liferay.portlet.shopping.search.OrderSearch" %>
<%@ page import="com.liferay.portlet.shopping.search.OrderSearchTerms" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingCartLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingCategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingCouponLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingCouponServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingItemFieldLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingItemPriceLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingOrderItemLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.ShoppingOrderLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.shopping.service.permission.ShoppingCategoryPermission" %>
<%@ page import="com.liferay.portlet.shopping.service.permission.ShoppingItemPermission" %>
<%@ page import="com.liferay.portlet.shopping.service.permission.ShoppingOrderPermission" %>
<%@ page import="com.liferay.portlet.shopping.service.permission.ShoppingPermission" %>
<%@ page import="com.liferay.portlet.shopping.util.ShoppingPreferences" %>
<%@ page import="com.liferay.portlet.shopping.util.ShoppingUtil" %>

<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

ShoppingPreferences shoppingPrefs = ShoppingPreferences.getInstance(company.getCompanyId(), scopeGroupId);

Currency currency = Currency.getInstance(shoppingPrefs.getCurrencyId());

NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

currencyFormat.setCurrency(currency);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

NumberFormat doubleFormat = NumberFormat.getNumberInstance(locale);

doubleFormat.setMaximumFractionDigits(2);
doubleFormat.setMinimumFractionDigits(2);

NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);

NumberFormat taxFormat = NumberFormat.getPercentInstance(locale);

taxFormat.setMinimumFractionDigits(3);
%>