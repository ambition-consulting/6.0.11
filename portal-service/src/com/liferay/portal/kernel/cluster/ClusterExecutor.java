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

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * @author Shuyang Zhou
 */
public interface ClusterExecutor {

	public void addClusterEventListener(
		ClusterEventListener clusterEventListener);

	public void destroy();

	public FutureClusterResponses execute(ClusterRequest clusterRequest)
		throws SystemException;

	public List<ClusterEventListener> getClusterEventListeners();

	public List<ClusterNode> getClusterNodes();

	public ClusterNode getLocalClusterNode() throws SystemException;

	public void initialize();

	public boolean isClusterNodeAlive(String clusterNodeId);

	public boolean isEnabled();

	public void removeClusterEventListener(
		ClusterEventListener clusterEventListener);

}