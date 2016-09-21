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

<%@ include file="/html/taglib/ui/breadcrumb/init.jsp" %>

<%
StringBundler sb = new StringBundler();

if (showGuestGroup) {
	_buildGuestGroupBreadcrumb(themeDisplay, sb);
}

if (showParentGroups) {
	_buildParentGroupsBreadcrumb(selLayout.getLayoutSet(), portletURL, themeDisplay, sb);
}

if (showLayout) {
	_buildLayoutBreadcrumb(selLayout, selLayoutParam, portletURL, themeDisplay, true, sb);
}

if (showPortletBreadcrumb) {
	_buildPortletBreadcrumb(request, sb);
}

String breadcrumbString = sb.toString();

if (Validator.isNotNull(breadcrumbString)) {
	int pos = breadcrumbString.indexOf("<li");

	breadcrumbString = StringUtil.insert(breadcrumbString, " class=\"first\"", pos + 3);

	pos = breadcrumbString.lastIndexOf("<li");

	breadcrumbString = StringUtil.insert(breadcrumbString, " class=\"last\"", pos + 3);
}
%>

<ul class="breadcrumbs breadcrumbs-style-1 lfr-component">
	<%= breadcrumbString %>
</ul>

<%!
private void _buildLayoutBreadcrumb(Layout selLayout, String selLayoutParam, PortletURL portletURL, ThemeDisplay themeDisplay, boolean selectedLayout, StringBundler sb) throws Exception {
	String layoutURL = _getBreadcrumbLayoutURL(selLayout, selLayoutParam, portletURL, themeDisplay);
	String target = PortalUtil.getLayoutTarget(selLayout);

	StringBundler breadcrumbSB = new StringBundler(7);

	breadcrumbSB.append("<li><span><a href=\"");
	breadcrumbSB.append(layoutURL);
	breadcrumbSB.append("\" ");
	breadcrumbSB.append(target);
	breadcrumbSB.append(">");

	breadcrumbSB.append(HtmlUtil.escape(selLayout.getName(themeDisplay.getLocale())));

	breadcrumbSB.append("</a></span></li>");

	if (selLayout.getParentLayoutId() != LayoutConstants.DEFAULT_PARENT_LAYOUT_ID) {
		Layout layoutParent = LayoutLocalServiceUtil.getLayout(selLayout.getGroupId(), selLayout.isPrivateLayout(), selLayout.getParentLayoutId());

		_buildLayoutBreadcrumb(layoutParent, selLayoutParam, portletURL, themeDisplay, false, sb);

		sb.append(breadcrumbSB.toString());
	}
	else {
		sb.append(breadcrumbSB.toString());
	}
}

private String _getBreadcrumbLayoutURL(Layout selLayout, String selLayoutParam, PortletURL portletURL, ThemeDisplay themeDisplay) throws Exception {
	if (portletURL == null) {
		return PortalUtil.getLayoutURL(selLayout, themeDisplay);
	}
	else {
		portletURL.setParameter(selLayoutParam, String.valueOf(selLayout.getPlid()));

		if (selLayout.isTypeControlPanel()) {
			if (themeDisplay.getDoAsGroupId() > 0) {
				portletURL.setParameter("doAsGroupId", String.valueOf(themeDisplay.getDoAsGroupId()));
			}

			if (themeDisplay.getRefererPlid() != LayoutConstants.DEFAULT_PLID) {
				portletURL.setParameter("refererPlid", String.valueOf(themeDisplay.getRefererPlid()));
			}
		}

		return portletURL.toString();
	}
}
%>