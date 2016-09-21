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

package com.liferay.portal.kernel.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.NamedThreadFactory;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public abstract class BaseAsyncDestination extends BaseDestination {

	public BaseAsyncDestination() {
	}

	/**
	 * @deprecated
	 */
	public BaseAsyncDestination(String name) {
		this(name, _WORKERS_CORE_SIZE, _WORKERS_MAX_SIZE);
	}

	/**
	 * @deprecated
	 */
	public BaseAsyncDestination(
		String name, int workersCoreSize, int workersMaxSize) {

		this.name = name;
		_workersCoreSize = workersCoreSize;
		_workersMaxSize = workersMaxSize;

		open();
	}

	public void close(boolean force) {
		if (!_threadPoolExecutor.isShutdown()
			&& !_threadPoolExecutor.isTerminating()) {

			if (!force) {
				_threadPoolExecutor.shutdown();
			}
			else {
				List<Runnable> pendingTasks = _threadPoolExecutor.shutdownNow();

				if (_log.isInfoEnabled()) {
					_log.info(
						"The following " + pendingTasks.size() + " tasks " +
							"were not executed due to shutown: " +
								pendingTasks);
				}
			}
		}
	}

	public DestinationStatistics getDestinationStatistics() {
		DestinationStatistics destinationStatistics =
			new DestinationStatistics();

		destinationStatistics.setActiveThreadCount(
			_threadPoolExecutor.getActiveCount());
		destinationStatistics.setCurrentThreadCount(
			_threadPoolExecutor.getPoolSize());
		destinationStatistics.setLargestThreadCount(
			_threadPoolExecutor.getLargestPoolSize());
		destinationStatistics.setMaxThreadPoolSize(
			_threadPoolExecutor.getMaximumPoolSize());
		destinationStatistics.setMinThreadPoolSize(
			_threadPoolExecutor.getCorePoolSize());
		destinationStatistics.setPendingMessageCount(
			_threadPoolExecutor.getQueue().size());
		destinationStatistics.setSentMessageCount(
			_threadPoolExecutor.getCompletedTaskCount());

		return destinationStatistics;
	}

	public int getMaximumQueueSize() {
		return _maximumQueueSize;
	}

	public int getWorkersCoreSize() {
		return _workersCoreSize;
	}

	public int getWorkersMaxSize() {
		return _workersMaxSize;
	}

	public void open() {
		if ((_threadPoolExecutor == null) || _threadPoolExecutor.isShutdown()) {
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();

			_threadPoolExecutor = new ThreadPoolExecutor(
				_workersCoreSize, _workersMaxSize, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(_maximumQueueSize),
				new NamedThreadFactory(
					getName(), Thread.NORM_PRIORITY, classLoader));

			if (_rejectedExecutionHandler == null) {
				_rejectedExecutionHandler = createRejectionExecutionHandler();
			}

			_threadPoolExecutor.setRejectedExecutionHandler(
				_rejectedExecutionHandler);
		}
	}

	public void send(Message message) {
		if (messageListeners.isEmpty()) {
			if (_log.isDebugEnabled()) {
				_log.debug("No message listeners for destination " + getName());
			}

			return;
		}

		ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

		if (threadPoolExecutor.isShutdown()) {
			throw new IllegalStateException(
				"Destination " + getName() + " is shutdown and cannot " +
					"receive more messages");
		}

		dispatch(messageListeners, message);
	}

	public void setMaximumQueueSize(int maximumQueueSize) {
		_maximumQueueSize = maximumQueueSize;
	}

	public void setRejectedExecutionHandler(
		RejectedExecutionHandler rejectedExecutionHandler) {

		_rejectedExecutionHandler = rejectedExecutionHandler;
	}

	public void setWorkersCoreSize(int workersCoreSize) {
		_workersCoreSize = workersCoreSize;
	}

	public void setWorkersMaxSize(int workersMaxSize) {
		_workersMaxSize = workersMaxSize;
	}

	protected RejectedExecutionHandler createRejectionExecutionHandler() {
		return new RejectedExecutionHandler() {

			public void rejectedExecution(
				Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

				if (!_log.isWarnEnabled()) {
					return;
				}

				MessageRunnable messageRunnable = (MessageRunnable) runnable;

				_log.warn(
					"Discarding message " + messageRunnable.getMessage() +
						" because it exceeds the maximum queue size of " +
							_maximumQueueSize);
			}

		};
	}

	protected abstract void dispatch(
		Set<MessageListener> messageListeners, Message message);

	protected ThreadPoolExecutor getThreadPoolExecutor() {
		return _threadPoolExecutor;
	}

	private static final int _WORKERS_CORE_SIZE = 2;

	private static final int _WORKERS_MAX_SIZE = 5;

	private static Log _log = LogFactoryUtil.getLog(
		BaseAsyncDestination.class);

	private int _maximumQueueSize = Integer.MAX_VALUE;
	private RejectedExecutionHandler _rejectedExecutionHandler;
	private ThreadPoolExecutor _threadPoolExecutor;
	private int _workersCoreSize = _WORKERS_CORE_SIZE;
	private int _workersMaxSize = _WORKERS_MAX_SIZE;

}