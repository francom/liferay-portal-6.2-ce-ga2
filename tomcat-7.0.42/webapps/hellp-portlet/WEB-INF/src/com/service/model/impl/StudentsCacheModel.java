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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.service.model.Students;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Students in entity cache.
 *
 * @author Tofu
 * @see Students
 * @generated
 */
public class StudentsCacheModel implements CacheModel<Students>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", examFee=");
		sb.append(examFee);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", subjectsId=");
		sb.append(subjectsId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Students toEntityModel() {
		StudentsImpl studentsImpl = new StudentsImpl();

		studentsImpl.setId(id);

		if (firstName == null) {
			studentsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			studentsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			studentsImpl.setLastName(StringPool.BLANK);
		}
		else {
			studentsImpl.setLastName(lastName);
		}

		studentsImpl.setExamFee(examFee);
		studentsImpl.setGender(gender);
		studentsImpl.setSubjectsId(subjectsId);

		if (address == null) {
			studentsImpl.setAddress(StringPool.BLANK);
		}
		else {
			studentsImpl.setAddress(address);
		}

		if (createDate == Long.MIN_VALUE) {
			studentsImpl.setCreateDate(null);
		}
		else {
			studentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentsImpl.setModifiedDate(null);
		}
		else {
			studentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentsImpl.resetOriginalValues();

		return studentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		examFee = objectInput.readDouble();
		gender = objectInput.readInt();
		subjectsId = objectInput.readInt();
		address = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeDouble(examFee);
		objectOutput.writeInt(gender);
		objectOutput.writeInt(subjectsId);

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public String firstName;
	public String lastName;
	public double examFee;
	public int gender;
	public int subjectsId;
	public String address;
	public long createDate;
	public long modifiedDate;
}