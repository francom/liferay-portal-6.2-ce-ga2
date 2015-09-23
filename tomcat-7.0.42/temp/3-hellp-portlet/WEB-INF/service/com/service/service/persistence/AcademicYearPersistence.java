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

package com.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.service.model.AcademicYear;

/**
 * The persistence interface for the academic year service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see AcademicYearPersistenceImpl
 * @see AcademicYearUtil
 * @generated
 */
public interface AcademicYearPersistence extends BasePersistence<AcademicYear> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AcademicYearUtil} to access the academic year persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the academic year where name = &#63; or throws a {@link com.service.NoSuchAcademicYearException} if it could not be found.
	*
	* @param name the name
	* @return the matching academic year
	* @throws com.service.NoSuchAcademicYearException if a matching academic year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear findByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchAcademicYearException;

	/**
	* Returns the academic year where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching academic year, or <code>null</code> if a matching academic year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear fetchByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the academic year where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching academic year, or <code>null</code> if a matching academic year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear fetchByname(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the academic year where name = &#63; from the database.
	*
	* @param name the name
	* @return the academic year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchAcademicYearException;

	/**
	* Returns the number of academic years where name = &#63;.
	*
	* @param name the name
	* @return the number of matching academic years
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the academic year in the entity cache if it is enabled.
	*
	* @param academicYear the academic year
	*/
	public void cacheResult(com.service.model.AcademicYear academicYear);

	/**
	* Caches the academic years in the entity cache if it is enabled.
	*
	* @param academicYears the academic years
	*/
	public void cacheResult(
		java.util.List<com.service.model.AcademicYear> academicYears);

	/**
	* Creates a new academic year with the primary key. Does not add the academic year to the database.
	*
	* @param id the primary key for the new academic year
	* @return the new academic year
	*/
	public com.service.model.AcademicYear create(long id);

	/**
	* Removes the academic year with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the academic year
	* @return the academic year that was removed
	* @throws com.service.NoSuchAcademicYearException if a academic year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchAcademicYearException;

	public com.service.model.AcademicYear updateImpl(
		com.service.model.AcademicYear academicYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the academic year with the primary key or throws a {@link com.service.NoSuchAcademicYearException} if it could not be found.
	*
	* @param id the primary key of the academic year
	* @return the academic year
	* @throws com.service.NoSuchAcademicYearException if a academic year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchAcademicYearException;

	/**
	* Returns the academic year with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the academic year
	* @return the academic year, or <code>null</code> if a academic year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.AcademicYear fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the academic years.
	*
	* @return the academic years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.AcademicYear> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the academic years.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.AcademicYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of academic years
	* @param end the upper bound of the range of academic years (not inclusive)
	* @return the range of academic years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.AcademicYear> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the academic years.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.AcademicYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of academic years
	* @param end the upper bound of the range of academic years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of academic years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.AcademicYear> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the academic years from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of academic years.
	*
	* @return the number of academic years
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}