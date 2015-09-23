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
 * This class is used by SOAP remote services, specifically {@link com.service.service.http.SubjectsServiceSoap}.
 *
 * @author Tofu
 * @see com.service.service.http.SubjectsServiceSoap
 * @generated
 */
public class SubjectsSoap implements Serializable {
	public static SubjectsSoap toSoapModel(Subjects model) {
		SubjectsSoap soapModel = new SubjectsSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SubjectsSoap[] toSoapModels(Subjects[] models) {
		SubjectsSoap[] soapModels = new SubjectsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubjectsSoap[][] toSoapModels(Subjects[][] models) {
		SubjectsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubjectsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubjectsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubjectsSoap[] toSoapModels(List<Subjects> models) {
		List<SubjectsSoap> soapModels = new ArrayList<SubjectsSoap>(models.size());

		for (Subjects model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubjectsSoap[soapModels.size()]);
	}

	public SubjectsSoap() {
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