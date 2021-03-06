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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AcademicYear service. Represents a row in the &quot;tbl_AcademicYear&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.service.model.impl.AcademicYearModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.service.model.impl.AcademicYearImpl}.
 * </p>
 *
 * @author Tofu
 * @see AcademicYear
 * @see com.service.model.impl.AcademicYearImpl
 * @see com.service.model.impl.AcademicYearModelImpl
 * @generated
 */
public interface AcademicYearModel extends BaseModel<AcademicYear> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a academic year model instance should use the {@link AcademicYear} interface instead.
	 */

	/**
	 * Returns the primary key of this academic year.
	 *
	 * @return the primary key of this academic year
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this academic year.
	 *
	 * @param primaryKey the primary key of this academic year
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this academic year.
	 *
	 * @return the ID of this academic year
	 */
	public long getId();

	/**
	 * Sets the ID of this academic year.
	 *
	 * @param id the ID of this academic year
	 */
	public void setId(long id);

	/**
	 * Returns the name of this academic year.
	 *
	 * @return the name of this academic year
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this academic year.
	 *
	 * @param name the name of this academic year
	 */
	public void setName(String name);

	/**
	 * Returns the create date of this academic year.
	 *
	 * @return the create date of this academic year
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this academic year.
	 *
	 * @param createDate the create date of this academic year
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this academic year.
	 *
	 * @return the modified date of this academic year
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this academic year.
	 *
	 * @param modifiedDate the modified date of this academic year
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(AcademicYear academicYear);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AcademicYear> toCacheModel();

	@Override
	public AcademicYear toEscapedModel();

	@Override
	public AcademicYear toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}