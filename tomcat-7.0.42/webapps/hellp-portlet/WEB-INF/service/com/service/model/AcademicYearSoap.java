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
 * This class is used by SOAP remote services, specifically {@link com.service.service.http.AcademicYearServiceSoap}.
 *
 * @author Tofu
 * @see com.service.service.http.AcademicYearServiceSoap
 * @generated
 */
public class AcademicYearSoap implements Serializable {
	public static AcademicYearSoap toSoapModel(AcademicYear model) {
		AcademicYearSoap soapModel = new AcademicYearSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AcademicYearSoap[] toSoapModels(AcademicYear[] models) {
		AcademicYearSoap[] soapModels = new AcademicYearSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AcademicYearSoap[][] toSoapModels(AcademicYear[][] models) {
		AcademicYearSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AcademicYearSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AcademicYearSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AcademicYearSoap[] toSoapModels(List<AcademicYear> models) {
		List<AcademicYearSoap> soapModels = new ArrayList<AcademicYearSoap>(models.size());

		for (AcademicYear model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AcademicYearSoap[soapModels.size()]);
	}

	public AcademicYearSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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
	private String _name;
	private Date _createDate;
	private Date _modifiedDate;
}