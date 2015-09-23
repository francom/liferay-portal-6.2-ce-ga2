/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AcademicYear}.
 * </p>
 *
 * @author Tofu
 * @see AcademicYear
 * @generated
 */
public class AcademicYearWrapper implements AcademicYear,
	ModelWrapper<AcademicYear> {
	public AcademicYearWrapper(AcademicYear academicYear) {
		_academicYear = academicYear;
	}

	@Override
	public Class<?> getModelClass() {
		return AcademicYear.class;
	}

	@Override
	public String getModelClassName() {
		return AcademicYear.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this academic year.
	*
	* @return the primary key of this academic year
	*/
	@Override
	public long getPrimaryKey() {
		return _academicYear.getPrimaryKey();
	}

	/**
	* Sets the primary key of this academic year.
	*
	* @param primaryKey the primary key of this academic year
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_academicYear.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this academic year.
	*
	* @return the ID of this academic year
	*/
	@Override
	public long getId() {
		return _academicYear.getId();
	}

	/**
	* Sets the ID of this academic year.
	*
	* @param id the ID of this academic year
	*/
	@Override
	public void setId(long id) {
		_academicYear.setId(id);
	}

	/**
	* Returns the name of this academic year.
	*
	* @return the name of this academic year
	*/
	@Override
	public java.lang.String getName() {
		return _academicYear.getName();
	}

	/**
	* Sets the name of this academic year.
	*
	* @param name the name of this academic year
	*/
	@Override
	public void setName(java.lang.String name) {
		_academicYear.setName(name);
	}

	/**
	* Returns the create date of this academic year.
	*
	* @return the create date of this academic year
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _academicYear.getCreateDate();
	}

	/**
	* Sets the create date of this academic year.
	*
	* @param createDate the create date of this academic year
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_academicYear.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this academic year.
	*
	* @return the modified date of this academic year
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _academicYear.getModifiedDate();
	}

	/**
	* Sets the modified date of this academic year.
	*
	* @param modifiedDate the modified date of this academic year
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_academicYear.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _academicYear.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_academicYear.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _academicYear.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_academicYear.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _academicYear.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _academicYear.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_academicYear.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _academicYear.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_academicYear.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_academicYear.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_academicYear.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AcademicYearWrapper((AcademicYear)_academicYear.clone());
	}

	@Override
	public int compareTo(com.service.model.AcademicYear academicYear) {
		return _academicYear.compareTo(academicYear);
	}

	@Override
	public int hashCode() {
		return _academicYear.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.service.model.AcademicYear> toCacheModel() {
		return _academicYear.toCacheModel();
	}

	@Override
	public com.service.model.AcademicYear toEscapedModel() {
		return new AcademicYearWrapper(_academicYear.toEscapedModel());
	}

	@Override
	public com.service.model.AcademicYear toUnescapedModel() {
		return new AcademicYearWrapper(_academicYear.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _academicYear.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _academicYear.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_academicYear.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AcademicYearWrapper)) {
			return false;
		}

		AcademicYearWrapper academicYearWrapper = (AcademicYearWrapper)obj;

		if (Validator.equals(_academicYear, academicYearWrapper._academicYear)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AcademicYear getWrappedAcademicYear() {
		return _academicYear;
	}

	@Override
	public AcademicYear getWrappedModel() {
		return _academicYear;
	}

	@Override
	public void resetOriginalValues() {
		_academicYear.resetOriginalValues();
	}

	private AcademicYear _academicYear;
}