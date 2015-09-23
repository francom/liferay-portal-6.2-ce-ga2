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

import com.service.model.Subjects;

/**
 * The persistence interface for the subjects service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see SubjectsPersistenceImpl
 * @see SubjectsUtil
 * @generated
 */
public interface SubjectsPersistence extends BasePersistence<Subjects> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectsUtil} to access the subjects persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the subjects where name = &#63; or throws a {@link com.service.NoSuchSubjectsException} if it could not be found.
	*
	* @param name the name
	* @return the matching subjects
	* @throws com.service.NoSuchSubjectsException if a matching subjects could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects findByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectsException;

	/**
	* Returns the subjects where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching subjects, or <code>null</code> if a matching subjects could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects fetchByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subjects where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subjects, or <code>null</code> if a matching subjects could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects fetchByname(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the subjects where name = &#63; from the database.
	*
	* @param name the name
	* @return the subjects that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectsException;

	/**
	* Returns the number of subjectses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching subjectses
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public void cacheResult(com.service.model.Subjects subjects);

	/**
	* Caches the subjectses in the entity cache if it is enabled.
	*
	* @param subjectses the subjectses
	*/
	public void cacheResult(
		java.util.List<com.service.model.Subjects> subjectses);

	/**
	* Creates a new subjects with the primary key. Does not add the subjects to the database.
	*
	* @param id the primary key for the new subjects
	* @return the new subjects
	*/
	public com.service.model.Subjects create(long id);

	/**
	* Removes the subjects with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subjects
	* @return the subjects that was removed
	* @throws com.service.NoSuchSubjectsException if a subjects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectsException;

	public com.service.model.Subjects updateImpl(
		com.service.model.Subjects subjects)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subjects with the primary key or throws a {@link com.service.NoSuchSubjectsException} if it could not be found.
	*
	* @param id the primary key of the subjects
	* @return the subjects
	* @throws com.service.NoSuchSubjectsException if a subjects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.NoSuchSubjectsException;

	/**
	* Returns the subjects with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the subjects
	* @return the subjects, or <code>null</code> if a subjects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.model.Subjects fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subjectses.
	*
	* @return the subjectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Subjects> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subjectses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.SubjectsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjectses
	* @param end the upper bound of the range of subjectses (not inclusive)
	* @return the range of subjectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Subjects> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subjectses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.SubjectsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjectses
	* @param end the upper bound of the range of subjectses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subjectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.model.Subjects> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subjectses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subjectses.
	*
	* @return the number of subjectses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}