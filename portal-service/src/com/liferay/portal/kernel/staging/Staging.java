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

package com.liferay.portal.kernel.staging;

import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

/**
 * @author Raymond Augé
 */
public interface Staging {

	public void copyFromLive(PortletRequest PortletRequest) throws Exception;

	public void copyFromLive(PortletRequest PortletRequest, Portlet portlet)
		throws Exception;

	public void copyPortlet(
			PortletRequest PortletRequest, long sourceGroupId,
			long targetGroupId, long sourcePlid, long targetPlid,
			String portletId)
		throws Exception;

	public void copyRemoteLayouts(
			long sourceGroupId, boolean privateLayout,
			Map<Long, Boolean> layoutIdMap,
			Map<String, String[]> exportParameterMap, String remoteAddress,
			int remotePort, boolean secureConnection, long remoteGroupId,
			boolean remotePrivateLayout,
			Map<String, String[]> importParameterMap, Date startDate,
			Date endDate)
		throws Exception;

	public List<Layout> getMissingParentLayouts(Layout layout, long liveGroupId)
		throws Exception;

	public String getSchedulerGroupName(String destinationName, long groupId);

	public Map<String, String[]> getStagingParameters();

	public Map<String, String[]> getStagingParameters(
		PortletRequest PortletRequest);

	public void publishLayout(
			long plid, long liveGroupId, boolean includeChildren)
		throws Exception;

	public void publishLayouts(
			long sourceGroupId, long targetGroupId, boolean privateLayout,
			long[] layoutIds, Map<String, String[]> parameterMap,
			Date startDate, Date endDate)
		throws Exception;

	public void publishLayouts(
			long sourceGroupId, long targetGroupId, boolean privateLayout,
			Map<Long, Boolean> layoutIdMap, Map<String, String[]> parameterMap,
			Date startDate, Date endDate)
		throws Exception;

	public void publishLayouts(
			long sourceGroupId, long targetGroupId, boolean privateLayout,
			Map<String, String[]> parameterMap, Date startDate, Date endDate)
		throws Exception;

	public void publishToLive(PortletRequest PortletRequest) throws Exception;

	public void publishToLive(PortletRequest PortletRequest, Portlet portlet)
		throws Exception;

	public void publishToRemote(PortletRequest PortletRequest) throws Exception;

	public void scheduleCopyFromLive(PortletRequest PortletRequest)
		throws Exception;

	public void schedulePublishToLive(PortletRequest PortletRequest)
		throws Exception;

	public void schedulePublishToRemote(PortletRequest PortletRequest)
		throws Exception;

	public void unscheduleCopyFromLive(PortletRequest PortletRequest)
		throws Exception;

	public void unschedulePublishToLive(PortletRequest PortletRequest)
		throws Exception;

	public void unschedulePublishToRemote(PortletRequest PortletRequest)
		throws Exception;

	public void updateStaging(PortletRequest PortletRequest) throws Exception;

}