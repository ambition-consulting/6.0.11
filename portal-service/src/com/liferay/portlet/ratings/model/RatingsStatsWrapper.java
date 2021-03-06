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

package com.liferay.portlet.ratings.model;

/**
 * <p>
 * This class is a wrapper for {@link RatingsStats}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RatingsStats
 * @generated
 */
public class RatingsStatsWrapper implements RatingsStats {
	public RatingsStatsWrapper(RatingsStats ratingsStats) {
		_ratingsStats = ratingsStats;
	}

	/**
	* Gets the primary key of this ratings stats.
	*
	* @return the primary key of this ratings stats
	*/
	public long getPrimaryKey() {
		return _ratingsStats.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ratings stats
	*
	* @param pk the primary key of this ratings stats
	*/
	public void setPrimaryKey(long pk) {
		_ratingsStats.setPrimaryKey(pk);
	}

	/**
	* Gets the stats id of this ratings stats.
	*
	* @return the stats id of this ratings stats
	*/
	public long getStatsId() {
		return _ratingsStats.getStatsId();
	}

	/**
	* Sets the stats id of this ratings stats.
	*
	* @param statsId the stats id of this ratings stats
	*/
	public void setStatsId(long statsId) {
		_ratingsStats.setStatsId(statsId);
	}

	/**
	* Gets the class name of the model instance this ratings stats is polymorphically associated with.
	*
	* @return the class name of the model instance this ratings stats is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _ratingsStats.getClassName();
	}

	/**
	* Gets the class name id of this ratings stats.
	*
	* @return the class name id of this ratings stats
	*/
	public long getClassNameId() {
		return _ratingsStats.getClassNameId();
	}

	/**
	* Sets the class name id of this ratings stats.
	*
	* @param classNameId the class name id of this ratings stats
	*/
	public void setClassNameId(long classNameId) {
		_ratingsStats.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this ratings stats.
	*
	* @return the class p k of this ratings stats
	*/
	public long getClassPK() {
		return _ratingsStats.getClassPK();
	}

	/**
	* Sets the class p k of this ratings stats.
	*
	* @param classPK the class p k of this ratings stats
	*/
	public void setClassPK(long classPK) {
		_ratingsStats.setClassPK(classPK);
	}

	/**
	* Gets the total entries of this ratings stats.
	*
	* @return the total entries of this ratings stats
	*/
	public int getTotalEntries() {
		return _ratingsStats.getTotalEntries();
	}

	/**
	* Sets the total entries of this ratings stats.
	*
	* @param totalEntries the total entries of this ratings stats
	*/
	public void setTotalEntries(int totalEntries) {
		_ratingsStats.setTotalEntries(totalEntries);
	}

	/**
	* Gets the total score of this ratings stats.
	*
	* @return the total score of this ratings stats
	*/
	public double getTotalScore() {
		return _ratingsStats.getTotalScore();
	}

	/**
	* Sets the total score of this ratings stats.
	*
	* @param totalScore the total score of this ratings stats
	*/
	public void setTotalScore(double totalScore) {
		_ratingsStats.setTotalScore(totalScore);
	}

	/**
	* Gets the average score of this ratings stats.
	*
	* @return the average score of this ratings stats
	*/
	public double getAverageScore() {
		return _ratingsStats.getAverageScore();
	}

	/**
	* Sets the average score of this ratings stats.
	*
	* @param averageScore the average score of this ratings stats
	*/
	public void setAverageScore(double averageScore) {
		_ratingsStats.setAverageScore(averageScore);
	}

	public boolean isNew() {
		return _ratingsStats.isNew();
	}

	public void setNew(boolean n) {
		_ratingsStats.setNew(n);
	}

	public boolean isCachedModel() {
		return _ratingsStats.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ratingsStats.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ratingsStats.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_ratingsStats.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ratingsStats.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ratingsStats.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ratingsStats.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new RatingsStatsWrapper((RatingsStats)_ratingsStats.clone());
	}

	public int compareTo(
		com.liferay.portlet.ratings.model.RatingsStats ratingsStats) {
		return _ratingsStats.compareTo(ratingsStats);
	}

	public int hashCode() {
		return _ratingsStats.hashCode();
	}

	public com.liferay.portlet.ratings.model.RatingsStats toEscapedModel() {
		return new RatingsStatsWrapper(_ratingsStats.toEscapedModel());
	}

	public java.lang.String toString() {
		return _ratingsStats.toString();
	}

	public java.lang.String toXmlString() {
		return _ratingsStats.toXmlString();
	}

	public RatingsStats getWrappedRatingsStats() {
		return _ratingsStats;
	}

	private RatingsStats _ratingsStats;
}