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

package com.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentsLocalService}.
 *
 * @author Tofu
 * @see StudentsLocalService
 * @generated
 */
public class StudentsLocalServiceWrapper implements StudentsLocalService,
	ServiceWrapper<StudentsLocalService> {
	public StudentsLocalServiceWrapper(
		StudentsLocalService studentsLocalService) {
		_studentsLocalService = studentsLocalService;
	}

	/**
	* Adds the students to the database. Also notifies the appropriate model listeners.
	*
	* @param students the students
	* @return the students that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Students addStudents(
		com.service.model.Students students)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.addStudents(students);
	}

	/**
	* Creates a new students with the primary key. Does not add the students to the database.
	*
	* @param id the primary key for the new students
	* @return the new students
	*/
	@Override
	public com.service.model.Students createStudents(long id) {
		return _studentsLocalService.createStudents(id);
	}

	/**
	* Deletes the students with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the students
	* @return the students that was removed
	* @throws PortalException if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Students deleteStudents(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.deleteStudents(id);
	}

	/**
	* Deletes the students from the database. Also notifies the appropriate model listeners.
	*
	* @param students the students
	* @return the students that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Students deleteStudents(
		com.service.model.Students students)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.deleteStudents(students);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.StudentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.StudentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.service.model.Students fetchStudents(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.fetchStudents(id);
	}

	/**
	* Returns the students with the primary key.
	*
	* @param id the primary key of the students
	* @return the students
	* @throws PortalException if a students with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Students getStudents(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.getStudents(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.service.model.Students> getStudentses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.getStudentses(start, end);
	}

	/**
	* Returns the number of studentses.
	*
	* @return the number of studentses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStudentsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.getStudentsesCount();
	}

	/**
	* Updates the students in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param students the students
	* @return the students that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Students updateStudents(
		com.service.model.Students students)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentsLocalService.updateStudents(students);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _studentsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_studentsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _studentsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StudentsLocalService getWrappedStudentsLocalService() {
		return _studentsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStudentsLocalService(
		StudentsLocalService studentsLocalService) {
		_studentsLocalService = studentsLocalService;
	}

	@Override
	public StudentsLocalService getWrappedService() {
		return _studentsLocalService;
	}

	@Override
	public void setWrappedService(StudentsLocalService studentsLocalService) {
		_studentsLocalService = studentsLocalService;
	}

	private StudentsLocalService _studentsLocalService;
}