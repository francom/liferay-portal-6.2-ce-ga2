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
 * Provides a wrapper for {@link SubjectsLocalService}.
 *
 * @author Tofu
 * @see SubjectsLocalService
 * @generated
 */
public class SubjectsLocalServiceWrapper implements SubjectsLocalService,
	ServiceWrapper<SubjectsLocalService> {
	public SubjectsLocalServiceWrapper(
		SubjectsLocalService subjectsLocalService) {
		_subjectsLocalService = subjectsLocalService;
	}

	/**
	* Adds the subjects to the database. Also notifies the appropriate model listeners.
	*
	* @param subjects the subjects
	* @return the subjects that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Subjects addSubjects(
		com.service.model.Subjects subjects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.addSubjects(subjects);
	}

	/**
	* Creates a new subjects with the primary key. Does not add the subjects to the database.
	*
	* @param id the primary key for the new subjects
	* @return the new subjects
	*/
	@Override
	public com.service.model.Subjects createSubjects(long id) {
		return _subjectsLocalService.createSubjects(id);
	}

	/**
	* Deletes the subjects with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subjects
	* @return the subjects that was removed
	* @throws PortalException if a subjects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Subjects deleteSubjects(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.deleteSubjects(id);
	}

	/**
	* Deletes the subjects from the database. Also notifies the appropriate model listeners.
	*
	* @param subjects the subjects
	* @return the subjects that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Subjects deleteSubjects(
		com.service.model.Subjects subjects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.deleteSubjects(subjects);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subjectsLocalService.dynamicQuery();
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
		return _subjectsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.SubjectsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _subjectsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.SubjectsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _subjectsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _subjectsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _subjectsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.service.model.Subjects fetchSubjects(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.fetchSubjects(id);
	}

	/**
	* Returns the subjects with the primary key.
	*
	* @param id the primary key of the subjects
	* @return the subjects
	* @throws PortalException if a subjects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Subjects getSubjects(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.getSubjects(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.service.model.Subjects> getSubjectses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.getSubjectses(start, end);
	}

	/**
	* Returns the number of subjectses.
	*
	* @return the number of subjectses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubjectsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.getSubjectsesCount();
	}

	/**
	* Updates the subjects in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subjects the subjects
	* @return the subjects that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.service.model.Subjects updateSubjects(
		com.service.model.Subjects subjects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectsLocalService.updateSubjects(subjects);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _subjectsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_subjectsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _subjectsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubjectsLocalService getWrappedSubjectsLocalService() {
		return _subjectsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubjectsLocalService(
		SubjectsLocalService subjectsLocalService) {
		_subjectsLocalService = subjectsLocalService;
	}

	@Override
	public SubjectsLocalService getWrappedService() {
		return _subjectsLocalService;
	}

	@Override
	public void setWrappedService(SubjectsLocalService subjectsLocalService) {
		_subjectsLocalService = subjectsLocalService;
	}

	private SubjectsLocalService _subjectsLocalService;
}