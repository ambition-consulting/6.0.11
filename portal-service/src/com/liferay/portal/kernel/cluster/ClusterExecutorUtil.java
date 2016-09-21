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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.List;

/**
 * @author Tina Tian
 */
public class ClusterExecutorUtil {

	public static void addClusterEventListener(
		ClusterEventListener clusterEventListener) {

		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return;
		}

		_clusterExecutor.addClusterEventListener(clusterEventListener);
	}

	public static void destroy() {
		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return;
		}

		_clusterExecutor.destroy();
	}

	public static FutureClusterResponses execute(ClusterRequest clusterRequest)
		throws SystemException {

		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return null;
		}

		return _clusterExecutor.execute(clusterRequest);
	}

	public static List<ClusterNode> getClusterNodes() {
		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return Collections.EMPTY_LIST;
		}

		return _clusterExecutor.getClusterNodes();
	}

	public static ClusterNode getLocalClusterNode() throws SystemException {
		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return null;
		}

		return _clusterExecutor.getLocalClusterNode();
	}

	public static void initialize() {
		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return;
		}

		_clusterExecutor.initialize();
	}

	public static boolean isClusterNodeAlive(String clusterNodeId) {
		if ((_clusterExecutor == null) || !_clusterExecutor .isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return false;
		}

		return _clusterExecutor.isClusterNodeAlive(clusterNodeId);
	}

	public static boolean isEnabled() {
		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return false;
		}

		return true;
	}

	public static void removeClusterEventListener(
		ClusterEventListener clusterEventListener) {

		if ((_clusterExecutor == null) || !_clusterExecutor.isEnabled()) {
			if (_log.isWarnEnabled()) {
				_log.warn("ClusterExecutorUtil has not been initialized");
			}

			return;
		}

		_clusterExecutor.removeClusterEventListener(clusterEventListener);
	}

	public void setClusterExecutor(ClusterExecutor clusterExecutor) {
		_clusterExecutor = clusterExecutor;
	}

	private static Log _log = LogFactoryUtil.getLog(ClusterExecutorUtil.class);

	private static ClusterExecutor _clusterExecutor;

}