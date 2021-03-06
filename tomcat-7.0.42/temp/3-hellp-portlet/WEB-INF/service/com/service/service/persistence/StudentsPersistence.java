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

import com.service.model.Students;

/**
 * The persistence interface for the students service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see StudentsPersistenceImpl
 * @see StudentsUtil
 * @generated
 */
public interface StudentsPersistence extends BasePersistence<Students> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentsUtil} to access the students persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the students where lastName = &#63; or throws a {@link com.service.NoSuchStudentsException} if it could not be found.
	*
	* @param lastName the last name
	* @return the matching students
	* @throws com.service.NoSuchStudentsException if a matching students could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students findBylastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException;

	/**
	* Returns the students where lastName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lastName the last name
	* @return the matching students, or <code>null</code> if a matching students could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students fetchBylastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students where lastName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lastName the last name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching students, or <code>null</code> if a matching students could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students fetchBylastName(
		java.lang.String lastName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the students where lastName = &#63; from the database.
	*
	* @param lastName the last name
	* @return the students that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students removeBylastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException;

	/**
	* Returns the number of studentses where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching studentses
	* @throws SystemException if a system exception occurred
	*/
	public int countBylastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public void cacheResult(com.service.model.Students students);

	/**
	* Caches the studentses in the entity cache if it is enabled.
	*
	* @param studentses the studentses
	*/
	public void cacheResult(
		java.util.List<com.service.model.Students> studentses);

	/**
	* Creates a new students with the primary key. Does not add the students to the database.
	*
	* @param id the primary key for the new students
	* @return the new students
	*/
	public com.service.model.Students create(long id);

	/**
	* Removes the students with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the students
	* @return the students that was removed
	* @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException;

	public com.service.model.Students updateImpl(
		com.service.model.Students students)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students with the primary key or throws a {@link com.service.NoSuchStudentsException} if it could not be found.
	*
	* @param id the primary key of the students
	* @return the students
	* @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException;

	/**
	* Returns the students with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the students
	* @return the students, or <code>null</code> if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Students fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the studentses.
	*
	* @return the studentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Students> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the studentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.StudentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of studentses
	* @param end the upper bound of the range of studentses (not inclusive)
	* @return the range of studentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Students> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the studentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.StudentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of studentses
	* @param end the upper bound of the range of studentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of studentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Students> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the studentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of studentses.
	*
	* @return the number of studentses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}