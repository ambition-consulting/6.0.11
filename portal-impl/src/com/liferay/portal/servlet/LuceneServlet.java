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

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngineUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.search.lucene.LuceneIndexer;
import com.liferay.portal.search.lucene.messaging.CleanUpMessageListener;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.PropsValues;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class LuceneServlet extends HttpServlet {

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);

		long[] companyIds = PortalInstances.getCompanyIds();

		for (int i = 0; i < companyIds.length; i++) {
			long companyId = companyIds[i];

			if (GetterUtil.getBoolean(
					PropsUtil.get(PropsKeys.INDEX_ON_STARTUP))) {

				if (_log.isInfoEnabled()) {
					_log.info("Indexing Lucene on startup");
				}

				LuceneIndexer indexer = new LuceneIndexer(companyId);
				Thread indexerThread = null;

				if (GetterUtil.getBoolean(
						PropsUtil.get(PropsKeys.INDEX_WITH_THREAD))) {

					indexerThread = new Thread(
						indexer, THREAD_NAME + "." + companyId);

					indexerThread.setPriority(THREAD_PRIORITY);

					indexerThread.start();
				}
				else {
					indexer.reindex();
				}

				_indexers.add(
					new ObjectValuePair<LuceneIndexer, Thread>(
						indexer, indexerThread));
			}

			if (PropsValues.LUCENE_STORE_JDBC_AUTO_CLEAN_UP_ENABLED) {
				_schedulerEntry = new SchedulerEntryImpl();

				_schedulerEntry.setEventListenerClass(
					CleanUpMessageListener.class.getName());
				_schedulerEntry.setTimeUnit(TimeUnit.MINUTE);
				_schedulerEntry.setTriggerType(TriggerType.SIMPLE);
				_schedulerEntry.setTriggerValue(
					PropsValues.LUCENE_STORE_JDBC_AUTO_CLEAN_UP_INTERVAL);

				try {
					SchedulerEngineUtil.schedule(
						_schedulerEntry,
						PortalClassLoaderUtil.getClassLoader());
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
		}
	}

	public void destroy() {
		try {
			if (_schedulerEntry != null) {
				SchedulerEngineUtil.unschedule(_schedulerEntry);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		// Wait for indexer to be gracefully interrupted

		for (int i = 0; i < _indexers.size(); i++) {
			ObjectValuePair<LuceneIndexer, Thread> ovp = _indexers.get(i);

			LuceneIndexer indexer = ovp.getKey();
			Thread indexerThread = ovp.getValue();

			if ((indexer != null) && (!indexer.isFinished()) &&
				(indexerThread != null)) {

				if (_log.isWarnEnabled()) {
					_log.warn("Waiting for Lucene indexer to shutdown");
				}

				indexer.halt();

				try {
					indexerThread.join(THREAD_TIMEOUT);
				}
				catch (InterruptedException e) {
					_log.error("Lucene indexer shutdown interrupted", e);
				}
			}
		}

		// Parent

		super.destroy();
	}

	private static final String THREAD_NAME = LuceneIndexer.class.getName();

	private static final int THREAD_PRIORITY = Thread.MIN_PRIORITY;

	private static final int THREAD_TIMEOUT = 60000;

	private static Log _log = LogFactoryUtil.getLog(LuceneServlet.class);

	private List<ObjectValuePair<LuceneIndexer, Thread>> _indexers =
		new ArrayList<ObjectValuePair<LuceneIndexer, Thread>>();
	private SchedulerEntry _schedulerEntry;

}