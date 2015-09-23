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
 * This class is used by SOAP remote services, specifically {@link com.service.service.http.SubjectServiceSoap}.
 *
 * @author Tofu
 * @see com.service.service.http.SubjectServiceSoap
 * @generated
 */
public class SubjectSoap implements Serializable {
	public static SubjectSoap toSoapModel(Subject model) {
		SubjectSoap soapModel = new SubjectSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SubjectSoap[] toSoapModels(Subject[] models) {
		SubjectSoap[] soapModels = new SubjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubjectSoap[][] toSoapModels(Subject[][] models) {
		SubjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubjectSoap[] toSoapModels(List<Subject> models) {
		List<SubjectSoap> soapModels = new ArrayList<SubjectSoap>(models.size());

		for (Subject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubjectSoap[soapModels.size()]);
	}

	public SubjectSoap() {
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