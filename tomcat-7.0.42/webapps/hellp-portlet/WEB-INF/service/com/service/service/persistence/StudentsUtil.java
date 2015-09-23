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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.service.model.Students;

import java.util.List;

/**
 * The persistence utility for the students service. This utility wraps {@link StudentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see StudentsPersistence
 * @see StudentsPersistenceImpl
 * @generated
 */
public class StudentsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Students students) {
		getPersistence().clearCache(students);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Students> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Students> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Students> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Students update(Students students) throws SystemException {
		return getPersistence().update(students);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Students update(Students students,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(students, serviceContext);
	}

	/**
	* Returns the students where lastName = &#63; or throws a {@link com.service.NoSuchStudentsException} if it could not be found.
	*
	* @param lastName the last name
	* @return the matching students
	* @throws com.service.NoSuchStudentsException if a matching students could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students findBylastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException {
		return getPersistence().findBylastName(lastName);
	}

	/**
	* Returns the students where lastName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lastName the last name
	* @return the matching students, or <code>null</code> if a matching students could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students fetchBylastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylastName(lastName);
	}

	/**
	* Returns the students where lastName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lastName the last name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching students, or <code>null</code> if a matching students could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students fetchBylastName(
		java.lang.String lastName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylastName(lastName, retrieveFromCache);
	}

	/**
	* Removes the students where lastName = &#63; from the database.
	*
	* @param lastName the last name
	* @return the students that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students removeBylastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException {
		return getPersistence().removeBylastName(lastName);
	}

	/**
	* Returns the number of studentses where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching studentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylastName(lastName);
	}

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public static void cacheResult(com.service.model.Students students) {
		getPersistence().cacheResult(students);
	}

	/**
	* Caches the studentses in the entity cache if it is enabled.
	*
	* @param studentses the studentses
	*/
	public static void cacheResult(
		java.util.List<com.service.model.Students> studentses) {
		getPersistence().cacheResult(studentses);
	}

	/**
	* Creates a new students with the primary key. Does not add the students to the database.
	*
	* @param id the primary key for the new students
	* @return the new students
	*/
	public static com.service.model.Students create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the students with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the students
	* @return the students that was removed
	* @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException {
		return getPersistence().remove(id);
	}

	public static com.service.model.Students updateImpl(
		com.service.model.Students students)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(students);
	}

	/**
	* Returns the students with the primary key or throws a {@link com.service.NoSuchStudentsException} if it could not be found.
	*
	* @param id the primary key of the students
	* @return the students
	* @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchStudentsException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the students with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the students
	* @return the students, or <code>null</code> if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Students fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the studentses.
	*
	* @return the studentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.model.Students> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.service.model.Students> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.service.model.Students> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the studentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of studentses.
	*
	* @return the number of studentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudentsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudentsPersistence)PortletBeanLocatorUtil.locate(com.service.service.ClpSerializer.getServletContextName(),
					StudentsPersistence.class.getName());

			ReferenceRegistry.registerReference(StudentsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StudentsPersistence persistence) {
	}

	private static StudentsPersistence _persistence;
}