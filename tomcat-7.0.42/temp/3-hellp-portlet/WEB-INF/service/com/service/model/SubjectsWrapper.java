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
 * This class is a wrapper for {@link Subjects}.
 * </p>
 *
 * @author Tofu
 * @see Subjects
 * @generated
 */
public class SubjectsWrapper implements Subjects, ModelWrapper<Subjects> {
	public SubjectsWrapper(Subjects subjects) {
		_subjects = subjects;
	}

	@Override
	public Class<?> getModelClass() {
		return Subjects.class;
	}

	@Override
	public String getModelClassName() {
		return Subjects.class.getName();
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
	* Returns the primary key of this subjects.
	*
	* @return the primary key of this subjects
	*/
	@Override
	public long getPrimaryKey() {
		return _subjects.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subjects.
	*
	* @param primaryKey the primary key of this subjects
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subjects.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this subjects.
	*
	* @return the ID of this subjects
	*/
	@Override
	public long getId() {
		return _subjects.getId();
	}

	/**
	* Sets the ID of this subjects.
	*
	* @param id the ID of this subjects
	*/
	@Override
	public void setId(long id) {
		_subjects.setId(id);
	}

	/**
	* Returns the name of this subjects.
	*
	* @return the name of this subjects
	*/
	@Override
	public java.lang.String getName() {
		return _subjects.getName();
	}

	/**
	* Sets the name of this subjects.
	*
	* @param name the name of this subjects
	*/
	@Override
	public void setName(java.lang.String name) {
		_subjects.setName(name);
	}

	/**
	* Returns the create date of this subjects.
	*
	* @return the create date of this subjects
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _subjects.getCreateDate();
	}

	/**
	* Sets the create date of this subjects.
	*
	* @param createDate the create date of this subjects
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_subjects.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this subjects.
	*
	* @return the modified date of this subjects
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _subjects.getModifiedDate();
	}

	/**
	* Sets the modified date of this subjects.
	*
	* @param modifiedDate the modified date of this subjects
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_subjects.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _subjects.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subjects.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subjects.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subjects.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subjects.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subjects.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subjects.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subjects.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subjects.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subjects.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subjects.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubjectsWrapper((Subjects)_subjects.clone());
	}

	@Override
	public int compareTo(com.service.model.Subjects subjects) {
		return _subjects.compareTo(subjects);
	}

	@Override
	public int hashCode() {
		return _subjects.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.service.model.Subjects> toCacheModel() {
		return _subjects.toCacheModel();
	}

	@Override
	public com.service.model.Subjects toEscapedModel() {
		return new SubjectsWrapper(_subjects.toEscapedModel());
	}

	@Override
	public com.service.model.Subjects toUnescapedModel() {
		return new SubjectsWrapper(_subjects.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subjects.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subjects.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subjects.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubjectsWrapper)) {
			return false;
		}

		SubjectsWrapper subjectsWrapper = (SubjectsWrapper)obj;

		if (Validator.equals(_subjects, subjectsWrapper._subjects)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Subjects getWrappedSubjects() {
		return _subjects;
	}

	@Override
	public Subjects getWrappedModel() {
		return _subjects;
	}

	@Override
	public void resetOriginalValues() {
		_subjects.resetOriginalValues();
	}

	private Subjects _subjects;
}