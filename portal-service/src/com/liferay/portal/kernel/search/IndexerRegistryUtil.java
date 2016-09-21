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

package com.liferay.portal.kernel.search;

import java.util.List;

/**
 * @author Raymond Augé
 */
public class IndexerRegistryUtil {

	public static Indexer getIndexer(Class<?> classObj) {
		return getIndexerRegistry().getIndexer(classObj.getName());
	}

	public static Indexer getIndexer(String className) {
		return getIndexerRegistry().getIndexer(className);
	}

	public static IndexerRegistry getIndexerRegistry() {
		return _indexerRegistry;
	}

	public static List<Indexer> getIndexers() {
		return getIndexerRegistry().getIndexers();
	}

	public static void register(Indexer indexer) {
		for (String className : indexer.getClassNames()) {
			register(className, indexer);
		}

		register(indexer.getClass().getName(), indexer);
	}

	public static void register(
		String className, Indexer indexer) {

		getIndexerRegistry().register(className, indexer);
	}

	public static void unregister(Indexer indexer) {
		for (String className : indexer.getClassNames()) {
			unregister(className);
		}

		unregister(indexer.getClass().getName());
	}

	public static void unregister(String className) {
		getIndexerRegistry().unregister(className);
	}

	public void setIndexerRegistry(IndexerRegistry indexerRegistry) {
		_indexerRegistry = indexerRegistry;
	}

	private static IndexerRegistry _indexerRegistry;

}