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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.service.NoSuchStudentsException;

import com.service.model.Students;
import com.service.model.impl.StudentsImpl;
import com.service.model.impl.StudentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the students service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see StudentsPersistence
 * @see StudentsUtil
 * @generated
 */
public class StudentsPersistenceImpl extends BasePersistenceImpl<Students>
	implements StudentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentsUtil} to access the students persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsModelImpl.FINDER_CACHE_ENABLED, StudentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsModelImpl.FINDER_CACHE_ENABLED, StudentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LASTNAME = new FinderPath(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsModelImpl.FINDER_CACHE_ENABLED, StudentsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBylastName",
			new String[] { String.class.getName() },
			StudentsModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylastName",
			new String[] { String.class.getName() });

	/**
	 * Returns the students where lastName = &#63; or throws a {@link com.service.NoSuchStudentsException} if it could not be found.
	 *
	 * @param lastName the last name
	 * @return the matching students
	 * @throws com.service.NoSuchStudentsException if a matching students could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students findBylastName(String lastName)
		throws NoSuchStudentsException, SystemException {
		Students students = fetchBylastName(lastName);

		if (students == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("lastName=");
			msg.append(lastName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStudentsException(msg.toString());
		}

		return students;
	}

	/**
	 * Returns the students where lastName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lastName the last name
	 * @return the matching students, or <code>null</code> if a matching students could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students fetchBylastName(String lastName) throws SystemException {
		return fetchBylastName(lastName, true);
	}

	/**
	 * Returns the students where lastName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lastName the last name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching students, or <code>null</code> if a matching students could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students fetchBylastName(String lastName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { lastName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LASTNAME,
					finderArgs, this);
		}

		if (result instanceof Students) {
			Students students = (Students)result;

			if (!Validator.equals(lastName, students.getLastName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STUDENTS_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				List<Students> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTNAME,
						finderArgs, list);
				}
				else {
					Students students = list.get(0);

					result = students;

					cacheResult(students);

					if ((students.getLastName() == null) ||
							!students.getLastName().equals(lastName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTNAME,
							finderArgs, students);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Students)result;
		}
	}

	/**
	 * Removes the students where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 * @return the students that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students removeBylastName(String lastName)
		throws NoSuchStudentsException, SystemException {
		Students students = findBylastName(lastName);

		return remove(students);
	}

	/**
	 * Returns the number of studentses where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching studentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylastName(String lastName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTNAME;

		Object[] finderArgs = new Object[] { lastName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTS_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_1 = "students.lastName IS NULL";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 = "students.lastName = ?";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 = "(students.lastName IS NULL OR students.lastName = '')";

	public StudentsPersistenceImpl() {
		setModelClass(Students.class);
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	@Override
	public void cacheResult(Students students) {
		EntityCacheUtil.putResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsImpl.class, students.getPrimaryKey(), students);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTNAME,
			new Object[] { students.getLastName() }, students);

		students.resetOriginalValues();
	}

	/**
	 * Caches the studentses in the entity cache if it is enabled.
	 *
	 * @param studentses the studentses
	 */
	@Override
	public void cacheResult(List<Students> studentses) {
		for (Students students : studentses) {
			if (EntityCacheUtil.getResult(
						StudentsModelImpl.ENTITY_CACHE_ENABLED,
						StudentsImpl.class, students.getPrimaryKey()) == null) {
				cacheResult(students);
			}
			else {
				students.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all studentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Students students) {
		EntityCacheUtil.removeResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsImpl.class, students.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(students);
	}

	@Override
	public void clearCache(List<Students> studentses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Students students : studentses) {
			EntityCacheUtil.removeResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
				StudentsImpl.class, students.getPrimaryKey());

			clearUniqueFindersCache(students);
		}
	}

	protected void cacheUniqueFindersCache(Students students) {
		if (students.isNew()) {
			Object[] args = new Object[] { students.getLastName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTNAME, args,
				students);
		}
		else {
			StudentsModelImpl studentsModelImpl = (StudentsModelImpl)students;

			if ((studentsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { students.getLastName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTNAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTNAME, args,
					students);
			}
		}
	}

	protected void clearUniqueFindersCache(Students students) {
		StudentsModelImpl studentsModelImpl = (StudentsModelImpl)students;

		Object[] args = new Object[] { students.getLastName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTNAME, args);

		if ((studentsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LASTNAME.getColumnBitmask()) != 0) {
			args = new Object[] { studentsModelImpl.getOriginalLastName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTNAME, args);
		}
	}

	/**
	 * Creates a new students with the primary key. Does not add the students to the database.
	 *
	 * @param id the primary key for the new students
	 * @return the new students
	 */
	@Override
	public Students create(long id) {
		Students students = new StudentsImpl();

		students.setNew(true);
		students.setPrimaryKey(id);

		return students;
	}

	/**
	 * Removes the students with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the students
	 * @return the students that was removed
	 * @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students remove(long id)
		throws NoSuchStudentsException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the students with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the students
	 * @return the students that was removed
	 * @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students remove(Serializable primaryKey)
		throws NoSuchStudentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Students students = (Students)session.get(StudentsImpl.class,
					primaryKey);

			if (students == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(students);
		}
		catch (NoSuchStudentsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Students removeImpl(Students students) throws SystemException {
		students = toUnwrappedModel(students);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(students)) {
				students = (Students)session.get(StudentsImpl.class,
						students.getPrimaryKeyObj());
			}

			if (students != null) {
				session.delete(students);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (students != null) {
			clearCache(students);
		}

		return students;
	}

	@Override
	public Students updateImpl(com.service.model.Students students)
		throws SystemException {
		students = toUnwrappedModel(students);

		boolean isNew = students.isNew();

		Session session = null;

		try {
			session = openSession();

			if (students.isNew()) {
				session.save(students);

				students.setNew(false);
			}
			else {
				session.merge(students);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
			StudentsImpl.class, students.getPrimaryKey(), students);

		clearUniqueFindersCache(students);
		cacheUniqueFindersCache(students);

		return students;
	}

	protected Students toUnwrappedModel(Students students) {
		if (students instanceof StudentsImpl) {
			return students;
		}

		StudentsImpl studentsImpl = new StudentsImpl();

		studentsImpl.setNew(students.isNew());
		studentsImpl.setPrimaryKey(students.getPrimaryKey());

		studentsImpl.setId(students.getId());
		studentsImpl.setFirstName(students.getFirstName());
		studentsImpl.setLastName(students.getLastName());
		studentsImpl.setExamFee(students.getExamFee());
		studentsImpl.setGender(students.getGender());
		studentsImpl.setSubjectsId(students.getSubjectsId());
		studentsImpl.setAddress(students.getAddress());
		studentsImpl.setCreateDate(students.getCreateDate());
		studentsImpl.setModifiedDate(students.getModifiedDate());

		return studentsImpl;
	}

	/**
	 * Returns the students with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the students
	 * @return the students
	 * @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentsException, SystemException {
		Students students = fetchByPrimaryKey(primaryKey);

		if (students == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return students;
	}

	/**
	 * Returns the students with the primary key or throws a {@link com.service.NoSuchStudentsException} if it could not be found.
	 *
	 * @param id the primary key of the students
	 * @return the students
	 * @throws com.service.NoSuchStudentsException if a students with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students findByPrimaryKey(long id)
		throws NoSuchStudentsException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the students with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the students
	 * @return the students, or <code>null</code> if a students with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Students students = (Students)EntityCacheUtil.getResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
				StudentsImpl.class, primaryKey);

		if (students == _nullStudents) {
			return null;
		}

		if (students == null) {
			Session session = null;

			try {
				session = openSession();

				students = (Students)session.get(StudentsImpl.class, primaryKey);

				if (students != null) {
					cacheResult(students);
				}
				else {
					EntityCacheUtil.putResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
						StudentsImpl.class, primaryKey, _nullStudents);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudentsModelImpl.ENTITY_CACHE_ENABLED,
					StudentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return students;
	}

	/**
	 * Returns the students with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the students
	 * @return the students, or <code>null</code> if a students with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Students fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the studentses.
	 *
	 * @return the studentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Students> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Students> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Students> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Students> list = (List<Students>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTS;

				if (pagination) {
					sql = sql.concat(StudentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Students>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Students>(list);
				}
				else {
					list = (List<Students>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the studentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Students students : findAll()) {
			remove(students);
		}
	}

	/**
	 * Returns the number of studentses.
	 *
	 * @return the number of studentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the students persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.service.model.Students")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Students>> listenersList = new ArrayList<ModelListener<Students>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Students>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StudentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDENTS = "SELECT students FROM Students students";
	private static final String _SQL_SELECT_STUDENTS_WHERE = "SELECT students FROM Students students WHERE ";
	private static final String _SQL_COUNT_STUDENTS = "SELECT COUNT(students) FROM Students students";
	private static final String _SQL_COUNT_STUDENTS_WHERE = "SELECT COUNT(students) FROM Students students WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "students.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Students exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Students exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Students _nullStudents = new StudentsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Students> toCacheModel() {
				return _nullStudentsCacheModel;
			}
		};

	private static CacheModel<Students> _nullStudentsCacheModel = new CacheModel<Students>() {
			@Override
			public Students toEntityModel() {
				return _nullStudents;
			}
		};
}