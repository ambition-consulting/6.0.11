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

package com.liferay.portlet.asset.model;

/**
 * The model interface for the AssetVocabulary service. Represents a row in the &quot;AssetVocabulary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.asset.model.impl.AssetVocabularyImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetVocabularyModel
 * @see com.liferay.portlet.asset.model.impl.AssetVocabularyImpl
 * @see com.liferay.portlet.asset.model.impl.AssetVocabularyModelImpl
 * @generated
 */
public interface AssetVocabulary extends AssetVocabularyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a asset vocabulary model instance should use the {@link AssetVocabulary} interface instead.
	 */
	public java.lang.String getTitle(java.lang.String languageId);

	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault);
}