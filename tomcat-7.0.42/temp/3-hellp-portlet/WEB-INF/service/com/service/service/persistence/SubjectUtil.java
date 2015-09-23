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

import com.service.model.Subject;

import java.util.List;

/**
 * The persistence utility for the subject service. This utility wraps {@link SubjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see SubjectPersistence
 * @see SubjectPersistenceImpl
 * @generated
 */
public class SubjectUtil {
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
	public static void clearCache(Subject subject) {
		getPersistence().clearCache(subject);
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
	public static List<Subject> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Subject update(Subject subject) throws SystemException {
		return getPersistence().update(subject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Subject update(Subject subject, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(subject, serviceContext);
	}

	/**
	* Returns the subject where name = &#63; or throws a {@link com.service.NoSuchSubjectException} if it could not be found.
	*
	* @param name the name
	* @return the matching subject
	* @throws com.service.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject findByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException {
		return getPersistence().findByname(name);
	}

	/**
	* Returns the subject where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject fetchByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname(name);
	}

	/**
	* Returns the subject where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject fetchByname(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname(name, retrieveFromCache);
	}

	/**
	* Removes the subject where name = &#63; from the database.
	*
	* @param name the name
	* @return the subject that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException {
		return getPersistence().removeByname(name);
	}

	/**
	* Returns the number of subjects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByname(name);
	}

	/**
	* Caches the subject in the entity cache if it is enabled.
	*
	* @param subject the subject
	*/
	public static void cacheResult(com.service.model.Subject subject) {
		getPersistence().cacheResult(subject);
	}

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public static void cacheResult(
		java.util.List<com.service.model.Subject> subjects) {
		getPersistence().cacheResult(subjects);
	}

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param id the primary key for the new subject
	* @return the new subject
	*/
	public static com.service.model.Subject create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subject
	* @return the subject that was removed
	* @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException {
		return getPersistence().remove(id);
	}

	public static com.service.model.Subject updateImpl(
		com.service.model.Subject subject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subject);
	}

	/**
	* Returns the subject with the primary key or throws a {@link com.service.NoSuchSubjectException} if it could not be found.
	*
	* @param id the primary key of the subject
	* @return the subject
	* @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the subject
	* @return the subject, or <code>null</code> if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.model.Subject fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the subjects.
	*
	* @return the subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.model.Subject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @return the range of subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.model.Subject> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.model.Subject> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubjectPersistence)PortletBeanLocatorUtil.locate(com.service.service.ClpSerializer.getServletContextName(),
					SubjectPersistence.class.getName());

			ReferenceRegistry.registerReference(SubjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubjectPersistence persistence) {
	}

	private static SubjectPersistence _persistence;
}