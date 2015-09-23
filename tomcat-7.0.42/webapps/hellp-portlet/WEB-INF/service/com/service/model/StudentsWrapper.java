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
 * This class is a wrapper for {@link Students}.
 * </p>
 *
 * @author Tofu
 * @see Students
 * @generated
 */
public class StudentsWrapper implements Students, ModelWrapper<Students> {
	public StudentsWrapper(Students students) {
		_students = students;
	}

	@Override
	public Class<?> getModelClass() {
		return Students.class;
	}

	@Override
	public String getModelClassName() {
		return Students.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("examFee", getExamFee());
		attributes.put("gender", getGender());
		attributes.put("subjectsId", getSubjectsId());
		attributes.put("address", getAddress());
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Double examFee = (Double)attributes.get("examFee");

		if (examFee != null) {
			setExamFee(examFee);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer subjectsId = (Integer)attributes.get("subjectsId");

		if (subjectsId != null) {
			setSubjectsId(subjectsId);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
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
	* Returns the primary key of this students.
	*
	* @return the primary key of this students
	*/
	@Override
	public long getPrimaryKey() {
		return _students.getPrimaryKey();
	}

	/**
	* Sets the primary key of this students.
	*
	* @param primaryKey the primary key of this students
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_students.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this students.
	*
	* @return the ID of this students
	*/
	@Override
	public long getId() {
		return _students.getId();
	}

	/**
	* Sets the ID of this students.
	*
	* @param id the ID of this students
	*/
	@Override
	public void setId(long id) {
		_students.setId(id);
	}

	/**
	* Returns the first name of this students.
	*
	* @return the first name of this students
	*/
	@Override
	public java.lang.String getFirstName() {
		return _students.getFirstName();
	}

	/**
	* Sets the first name of this students.
	*
	* @param firstName the first name of this students
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_students.setFirstName(firstName);
	}

	/**
	* Returns the last name of this students.
	*
	* @return the last name of this students
	*/
	@Override
	public java.lang.String getLastName() {
		return _students.getLastName();
	}

	/**
	* Sets the last name of this students.
	*
	* @param lastName the last name of this students
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_students.setLastName(lastName);
	}

	/**
	* Returns the exam fee of this students.
	*
	* @return the exam fee of this students
	*/
	@Override
	public double getExamFee() {
		return _students.getExamFee();
	}

	/**
	* Sets the exam fee of this students.
	*
	* @param examFee the exam fee of this students
	*/
	@Override
	public void setExamFee(double examFee) {
		_students.setExamFee(examFee);
	}

	/**
	* Returns the gender of this students.
	*
	* @return the gender of this students
	*/
	@Override
	public int getGender() {
		return _students.getGender();
	}

	/**
	* Sets the gender of this students.
	*
	* @param gender the gender of this students
	*/
	@Override
	public void setGender(int gender) {
		_students.setGender(gender);
	}

	/**
	* Returns the subjects ID of this students.
	*
	* @return the subjects ID of this students
	*/
	@Override
	public int getSubjectsId() {
		return _students.getSubjectsId();
	}

	/**
	* Sets the subjects ID of this students.
	*
	* @param subjectsId the subjects ID of this students
	*/
	@Override
	public void setSubjectsId(int subjectsId) {
		_students.setSubjectsId(subjectsId);
	}

	/**
	* Returns the address of this students.
	*
	* @return the address of this students
	*/
	@Override
	public java.lang.String getAddress() {
		return _students.getAddress();
	}

	/**
	* Sets the address of this students.
	*
	* @param address the address of this students
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_students.setAddress(address);
	}

	/**
	* Returns the create date of this students.
	*
	* @return the create date of this students
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _students.getCreateDate();
	}

	/**
	* Sets the create date of this students.
	*
	* @param createDate the create date of this students
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_students.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this students.
	*
	* @return the modified date of this students
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _students.getModifiedDate();
	}

	/**
	* Sets the modified date of this students.
	*
	* @param modifiedDate the modified date of this students
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_students.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _students.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_students.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _students.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_students.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _students.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _students.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_students.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _students.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_students.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_students.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_students.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentsWrapper((Students)_students.clone());
	}

	@Override
	public int compareTo(com.service.model.Students students) {
		return _students.compareTo(students);
	}

	@Override
	public int hashCode() {
		return _students.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.service.model.Students> toCacheModel() {
		return _students.toCacheModel();
	}

	@Override
	public com.service.model.Students toEscapedModel() {
		return new StudentsWrapper(_students.toEscapedModel());
	}

	@Override
	public com.service.model.Students toUnescapedModel() {
		return new StudentsWrapper(_students.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _students.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _students.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_students.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentsWrapper)) {
			return false;
		}

		StudentsWrapper studentsWrapper = (StudentsWrapper)obj;

		if (Validator.equals(_students, studentsWrapper._students)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Students getWrappedStudents() {
		return _students;
	}

	@Override
	public Students getWrappedModel() {
		return _students;
	}

	@Override
	public void resetOriginalValues() {
		_students.resetOriginalValues();
	}

	private Students _students;
}