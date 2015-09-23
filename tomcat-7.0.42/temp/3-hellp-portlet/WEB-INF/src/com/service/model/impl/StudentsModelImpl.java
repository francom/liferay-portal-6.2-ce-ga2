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

package com.service.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.service.model.Students;
import com.service.model.StudentsModel;
import com.service.model.StudentsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Students service. Represents a row in the &quot;test_Students&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.service.model.StudentsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentsImpl}.
 * </p>
 *
 * @author Tofu
 * @see StudentsImpl
 * @see com.service.model.Students
 * @see com.service.model.StudentsModel
 * @generated
 */
@JSON(strict = true)
public class StudentsModelImpl extends BaseModelImpl<Students>
	implements StudentsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a students model instance should use the {@link com.service.model.Students} interface instead.
	 */
	public static final String TABLE_NAME = "test_Students";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "examFee", Types.DOUBLE },
			{ "gender", Types.INTEGER },
			{ "subjectsId", Types.INTEGER },
			{ "address", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table test_Students (id_ LONG not null primary key,firstName VARCHAR(75) null,lastName VARCHAR(75) null,examFee DOUBLE,gender INTEGER,subjectsId INTEGER,address VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table test_Students";
	public static final String ORDER_BY_JPQL = " ORDER BY students.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY test_Students.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.service.model.Students"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.service.model.Students"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.service.model.Students"),
			true);
	public static long LASTNAME_COLUMN_BITMASK = 1L;
	public static long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Students toModel(StudentsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Students model = new StudentsImpl();

		model.setId(soapModel.getId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setExamFee(soapModel.getExamFee());
		model.setGender(soapModel.getGender());
		model.setSubjectsId(soapModel.getSubjectsId());
		model.setAddress(soapModel.getAddress());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Students> toModels(StudentsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Students> models = new ArrayList<Students>(soapModels.length);

		for (StudentsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.service.model.Students"));

	public StudentsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_columnBitmask |= LASTNAME_COLUMN_BITMASK;

		if (_originalLastName == null) {
			_originalLastName = _lastName;
		}

		_lastName = lastName;
	}

	public String getOriginalLastName() {
		return GetterUtil.getString(_originalLastName);
	}

	@JSON
	@Override
	public double getExamFee() {
		return _examFee;
	}

	@Override
	public void setExamFee(double examFee) {
		_examFee = examFee;
	}

	@JSON
	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;
	}

	@JSON
	@Override
	public int getSubjectsId() {
		return _subjectsId;
	}

	@Override
	public void setSubjectsId(int subjectsId) {
		_subjectsId = subjectsId;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Students.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Students toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Students)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StudentsImpl studentsImpl = new StudentsImpl();

		studentsImpl.setId(getId());
		studentsImpl.setFirstName(getFirstName());
		studentsImpl.setLastName(getLastName());
		studentsImpl.setExamFee(getExamFee());
		studentsImpl.setGender(getGender());
		studentsImpl.setSubjectsId(getSubjectsId());
		studentsImpl.setAddress(getAddress());
		studentsImpl.setCreateDate(getCreateDate());
		studentsImpl.setModifiedDate(getModifiedDate());

		studentsImpl.resetOriginalValues();

		return studentsImpl;
	}

	@Override
	public int compareTo(Students students) {
		int value = 0;

		if (getId() < students.getId()) {
			value = -1;
		}
		else if (getId() > students.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Students)) {
			return false;
		}

		Students students = (Students)obj;

		long primaryKey = students.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		StudentsModelImpl studentsModelImpl = this;

		studentsModelImpl._originalLastName = studentsModelImpl._lastName;

		studentsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Students> toCacheModel() {
		StudentsCacheModel studentsCacheModel = new StudentsCacheModel();

		studentsCacheModel.id = getId();

		studentsCacheModel.firstName = getFirstName();

		String firstName = studentsCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			studentsCacheModel.firstName = null;
		}

		studentsCacheModel.lastName = getLastName();

		String lastName = studentsCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			studentsCacheModel.lastName = null;
		}

		studentsCacheModel.examFee = getExamFee();

		studentsCacheModel.gender = getGender();

		studentsCacheModel.subjectsId = getSubjectsId();

		studentsCacheModel.address = getAddress();

		String address = studentsCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			studentsCacheModel.address = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			studentsCacheModel.createDate = createDate.getTime();
		}
		else {
			studentsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			studentsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			studentsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return studentsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", examFee=");
		sb.append(getExamFee());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", subjectsId=");
		sb.append(getSubjectsId());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.service.model.Students");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>examFee</column-name><column-value><![CDATA[");
		sb.append(getExamFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectsId</column-name><column-value><![CDATA[");
		sb.append(getSubjectsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Students.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Students.class
		};
	private long _id;
	private String _firstName;
	private String _lastName;
	private String _originalLastName;
	private double _examFee;
	private int _gender;
	private int _subjectsId;
	private String _address;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private Students _escapedModel;
}