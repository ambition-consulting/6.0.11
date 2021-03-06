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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long groupId = ParamUtil.getLong(request, "groupId");
String oldArticleId = ParamUtil.getString(request, "oldArticleId");
String newArticleId = ParamUtil.getString(request, "newArticleId");
double version = ParamUtil.getDouble(request, "version");
%>

<portlet:actionURL var="copyArticleURL">
	<portlet:param name="struts_action" value="/journal/copy_article" />
</portlet:actionURL>

<aui:form action="<%= copyArticleURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.COPY %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
	<aui:input name="oldArticleId" type="hidden" value="<%= oldArticleId %>" />
	<aui:input name="version" type="hidden" value="<%= version %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="web-content"
	/>

	<liferay-ui:error exception="<%= DuplicateArticleIdException.class %>" message="please-enter-a-unique-id" />
	<liferay-ui:error exception="<%= ArticleIdException.class %>" message="please-enter-a-valid-id" />

	<aui:fieldset>
		<aui:field-wrapper label="id">
			<%= oldArticleId %>
		</aui:field-wrapper>

		<aui:field-wrapper label="new-id">
			<c:choose>
				<c:when test="<%= PropsValues.JOURNAL_ARTICLE_FORCE_AUTOGENERATE_ID %>">
					<liferay-ui:message key="autogenerate-id" />

					<aui:input name="newArticleId" type="hidden" />
					<aui:input name="autoArticleId" type="hidden" value="<%= true %>" />
				</c:when>
				<c:otherwise>
					<aui:input bean="<%= null %>" cssClass="lfr-input-text-container" label="" field="articleId" fieldParam="newArticleId" model="<%= JournalArticle.class %>" name="newArticleId" value="<%= newArticleId %>" />
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="copy" />

		<aui:button onClick="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />newArticleId);
	</aui:script>
</c:if>