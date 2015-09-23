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
 * The base model interface for the Subjects service. Represents a row in the &quot;test_Subjects&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.service.model.impl.SubjectsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.service.model.impl.SubjectsImpl}.
 * </p>
 *
 * @author Tofu
 * @see Subjects
 * @see com.service.model.impl.SubjectsImpl
 * @see com.service.model.impl.SubjectsModelImpl
 * @generated
 */
public interface SubjectsModel extends BaseModel<Subjects> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a subjects model instance should use the {@link Subjects} interface instead.
	 */

	/**
	 * Returns the primary key of this subjects.
	 *
	 * @return the primary key of this subjects
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this subjects.
	 *
	 * @param primaryKey the primary key of this subjects
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this subjects.
	 *
	 * @return the ID of this subjects
	 */
	public long getId();

	/**
	 * Sets the ID of this subjects.
	 *
	 * @param id the ID of this subjects
	 */
	public void setId(long id);

	/**
	 * Returns the name of this subjects.
	 *
	 * @return the name of this subjects
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this subjects.
	 *
	 * @param name the name of this subjects
	 */
	public void setName(String name);

	/**
	 * Returns the create date of this subjects.
	 *
	 * @return the create date of this subjects
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this subjects.
	 *
	 * @param createDate the create date of this subjects
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this subjects.
	 *
	 * @return the modified date of this subjects
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this subjects.
	 *
	 * @param modifiedDate the modified date of this subjects
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
	public int compareTo(Subjects subjects);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Subjects> toCacheModel();

	@Override
	public Subjects toEscapedModel();

	@Override
	public Subjects toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}