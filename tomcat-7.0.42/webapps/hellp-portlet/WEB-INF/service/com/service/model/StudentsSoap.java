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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.service.service.http.StudentsServiceSoap}.
 *
 * @author Tofu
 * @see com.service.service.http.StudentsServiceSoap
 * @generated
 */
public class StudentsSoap implements Serializable {
	public static StudentsSoap toSoapModel(Students model) {
		StudentsSoap soapModel = new StudentsSoap();

		soapModel.setId(model.getId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setExamFee(model.getExamFee());
		soapModel.setGender(model.getGender());
		soapModel.setSubjectsId(model.getSubjectsId());
		soapModel.setAddress(model.getAddress());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static StudentsSoap[] toSoapModels(Students[] models) {
		StudentsSoap[] soapModels = new StudentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentsSoap[][] toSoapModels(Students[][] models) {
		StudentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentsSoap[] toSoapModels(List<Students> models) {
		List<StudentsSoap> soapModels = new ArrayList<StudentsSoap>(models.size());

		for (Students model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentsSoap[soapModels.size()]);
	}

	public StudentsSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public double getExamFee() {
		return _examFee;
	}

	public void setExamFee(double examFee) {
		_examFee = examFee;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public int getSubjectsId() {
		return _subjectsId;
	}

	public void setSubjectsId(int subjectsId) {
		_subjectsId = subjectsId;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _id;
	private String _firstName;
	private String _lastName;
	private double _examFee;
	private int _gender;
	private int _subjectsId;
	private String _address;
	private Date _createDate;
	private Date _modifiedDate;
}