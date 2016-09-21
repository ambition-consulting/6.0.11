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

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class ClusterNodeResponses implements Serializable {

	public static final ClusterNodeResponses EMPTY_CLUSTER_NODE_RESPONSES =
		new ClusterNodeResponses();

	public void addClusterResponse(ClusterNodeResponse clusterNodeResponse) {
		_clusterResponses.put(
			clusterNodeResponse.getClusterNode(), clusterNodeResponse);
	}

	public ClusterNodeResponse getClusterResponse(ClusterNode clusterNode) {
		return _clusterResponses.get(clusterNode);
	}

	public Map<ClusterNode, ClusterNodeResponse> getClusterResponses() {
		return Collections.unmodifiableMap(_clusterResponses);
	}

	public int size() {
		return _clusterResponses.size();
	}

	private Map<ClusterNode, ClusterNodeResponse> _clusterResponses =
		new HashMap<ClusterNode, ClusterNodeResponse>();

}