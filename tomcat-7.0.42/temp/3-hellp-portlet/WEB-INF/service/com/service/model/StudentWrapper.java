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
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Tofu
 * @see Student
 * @generated
 */
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
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
		attributes.put("academicYearId", getAcademicYearId());
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

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer subjectsId = (Integer)attributes.get("subjectsId");

		if (subjectsId != null) {
			setSubjectsId(subjectsId);
		}

		Long academicYearId = (Long)attributes.get("academicYearId");

		if (academicYearId != null) {
			setAcademicYearId(academicYearId);
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
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	@Override
	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this student.
	*
	* @return the ID of this student
	*/
	@Override
	public long getId() {
		return _student.getId();
	}

	/**
	* Sets the ID of this student.
	*
	* @param id the ID of this student
	*/
	@Override
	public void setId(long id) {
		_student.setId(id);
	}

	/**
	* Returns the first name of this student.
	*
	* @return the first name of this student
	*/
	@Override
	public java.lang.String getFirstName() {
		return _student.getFirstName();
	}

	/**
	* Sets the first name of this student.
	*
	* @param firstName the first name of this student
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_student.setFirstName(firstName);
	}

	/**
	* Returns the last name of this student.
	*
	* @return the last name of this student
	*/
	@Override
	public java.lang.String getLastName() {
		return _student.getLastName();
	}

	/**
	* Sets the last name of this student.
	*
	* @param lastName the last name of this student
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_student.setLastName(lastName);
	}

	/**
	* Returns the exam fee of this student.
	*
	* @return the exam fee of this student
	*/
	@Override
	public double getExamFee() {
		return _student.getExamFee();
	}

	/**
	* Sets the exam fee of this student.
	*
	* @param examFee the exam fee of this student
	*/
	@Override
	public void setExamFee(double examFee) {
		_student.setExamFee(examFee);
	}

	/**
	* Returns the gender of this student.
	*
	* @return the gender of this student
	*/
	@Override
	public java.lang.String getGender() {
		return _student.getGender();
	}

	/**
	* Sets the gender of this student.
	*
	* @param gender the gender of this student
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_student.setGender(gender);
	}

	/**
	* Returns the subjects ID of this student.
	*
	* @return the subjects ID of this student
	*/
	@Override
	public int getSubjectsId() {
		return _student.getSubjectsId();
	}

	/**
	* Sets the subjects ID of this student.
	*
	* @param subjectsId the subjects ID of this student
	*/
	@Override
	public void setSubjectsId(int subjectsId) {
		_student.setSubjectsId(subjectsId);
	}

	/**
	* Returns the academic year ID of this student.
	*
	* @return the academic year ID of this student
	*/
	@Override
	public long getAcademicYearId() {
		return _student.getAcademicYearId();
	}

	/**
	* Sets the academic year ID of this student.
	*
	* @param academicYearId the academic year ID of this student
	*/
	@Override
	public void setAcademicYearId(long academicYearId) {
		_student.setAcademicYearId(academicYearId);
	}

	/**
	* Returns the address of this student.
	*
	* @return the address of this student
	*/
	@Override
	public java.lang.String getAddress() {
		return _student.getAddress();
	}

	/**
	* Sets the address of this student.
	*
	* @param address the address of this student
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_student.setAddress(address);
	}

	/**
	* Returns the create date of this student.
	*
	* @return the create date of this student
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _student.getCreateDate();
	}

	/**
	* Sets the create date of this student.
	*
	* @param createDate the create date of this student
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_student.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this student.
	*
	* @return the modified date of this student
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _student.getModifiedDate();
	}

	/**
	* Sets the modified date of this student.
	*
	* @param modifiedDate the modified date of this student
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_student.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _student.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_student.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_student.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_student.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	@Override
	public int compareTo(com.service.model.Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.service.model.Student> toCacheModel() {
		return _student.toCacheModel();
	}

	@Override
	public com.service.model.Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public com.service.model.Student toUnescapedModel() {
		return new StudentWrapper(_student.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_student.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentWrapper)) {
			return false;
		}

		StudentWrapper studentWrapper = (StudentWrapper)obj;

		if (Validator.equals(_student, studentWrapper._student)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Student getWrappedStudent() {
		return _student;
	}

	@Override
	public Student getWrappedModel() {
		return _student;
	}

	@Override
	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private Student _student;
}