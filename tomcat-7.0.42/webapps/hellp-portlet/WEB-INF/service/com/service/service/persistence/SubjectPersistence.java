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

import com.service.model.Subject;

/**
 * The persistence interface for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see SubjectPersistenceImpl
 * @see SubjectUtil
 * @generated
 */
public interface SubjectPersistence extends BasePersistence<Subject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the subject where name = &#63; or throws a {@link com.service.NoSuchSubjectException} if it could not be found.
	*
	* @param name the name
	* @return the matching subject
	* @throws com.service.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject findByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException;

	/**
	* Returns the subject where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject fetchByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject fetchByname(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the subject where name = &#63; from the database.
	*
	* @param name the name
	* @return the subject that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException;

	/**
	* Returns the number of subjects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subject in the entity cache if it is enabled.
	*
	* @param subject the subject
	*/
	public void cacheResult(com.service.model.Subject subject);

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public void cacheResult(java.util.List<com.service.model.Subject> subjects);

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param id the primary key for the new subject
	* @return the new subject
	*/
	public com.service.model.Subject create(long id);

	/**
	* Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subject
	* @return the subject that was removed
	* @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException;

	public com.service.model.Subject updateImpl(
		com.service.model.Subject subject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject with the primary key or throws a {@link com.service.NoSuchSubjectException} if it could not be found.
	*
	* @param id the primary key of the subject
	* @return the subject
	* @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectException;

	/**
	* Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the subject
	* @return the subject, or <code>null</code> if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subject fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subjects.
	*
	* @return the subjects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Subject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.service.model.Subject> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.service.model.Subject> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}