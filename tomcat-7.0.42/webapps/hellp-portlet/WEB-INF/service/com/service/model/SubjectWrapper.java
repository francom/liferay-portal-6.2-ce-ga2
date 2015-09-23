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
 * This class is a wrapper for {@link Subject}.
 * </p>
 *
 * @author Tofu
 * @see Subject
 * @generated
 */
public class SubjectWrapper implements Subject, ModelWrapper<Subject> {
	public SubjectWrapper(Subject subject) {
		_subject = subject;
	}

	@Override
	public Class<?> getModelClass() {
		return Subject.class;
	}

	@Override
	public String getModelClassName() {
		return Subject.class.getName();
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
	* Returns the primary key of this subject.
	*
	* @return the primary key of this subject
	*/
	@Override
	public long getPrimaryKey() {
		return _subject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subject.
	*
	* @param primaryKey the primary key of this subject
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this subject.
	*
	* @return the ID of this subject
	*/
	@Override
	public long getId() {
		return _subject.getId();
	}

	/**
	* Sets the ID of this subject.
	*
	* @param id the ID of this subject
	*/
	@Override
	public void setId(long id) {
		_subject.setId(id);
	}

	/**
	* Returns the name of this subject.
	*
	* @return the name of this subject
	*/
	@Override
	public java.lang.String getName() {
		return _subject.getName();
	}

	/**
	* Sets the name of this subject.
	*
	* @param name the name of this subject
	*/
	@Override
	public void setName(java.lang.String name) {
		_subject.setName(name);
	}

	/**
	* Returns the create date of this subject.
	*
	* @return the create date of this subject
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _subject.getCreateDate();
	}

	/**
	* Sets the create date of this subject.
	*
	* @param createDate the create date of this subject
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_subject.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this subject.
	*
	* @return the modified date of this subject
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _subject.getModifiedDate();
	}

	/**
	* Sets the modified date of this subject.
	*
	* @param modifiedDate the modified date of this subject
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_subject.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _subject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubjectWrapper((Subject)_subject.clone());
	}

	@Override
	public int compareTo(com.service.model.Subject subject) {
		return _subject.compareTo(subject);
	}

	@Override
	public int hashCode() {
		return _subject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.service.model.Subject> toCacheModel() {
		return _subject.toCacheModel();
	}

	@Override
	public com.service.model.Subject toEscapedModel() {
		return new SubjectWrapper(_subject.toEscapedModel());
	}

	@Override
	public com.service.model.Subject toUnescapedModel() {
		return new SubjectWrapper(_subject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubjectWrapper)) {
			return false;
		}

		SubjectWrapper subjectWrapper = (SubjectWrapper)obj;

		if (Validator.equals(_subject, subjectWrapper._subject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Subject getWrappedSubject() {
		return _subject;
	}

	@Override
	public Subject getWrappedModel() {
		return _subject;
	}

	@Override
	public void resetOriginalValues() {
		_subject.resetOriginalValues();
	}

	private Subject _subject;
}