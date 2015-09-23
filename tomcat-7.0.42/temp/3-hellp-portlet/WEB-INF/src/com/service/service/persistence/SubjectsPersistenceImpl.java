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

import com.service.NoSuchSubjectsException;

import com.service.model.Subjects;
import com.service.model.impl.SubjectsImpl;
import com.service.model.impl.SubjectsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the subjects service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see SubjectsPersistence
 * @see SubjectsUtil
 * @generated
 */
public class SubjectsPersistenceImpl extends BasePersistenceImpl<Subjects>
	implements SubjectsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubjectsUtil} to access the subjects persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubjectsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsModelImpl.FINDER_CACHE_ENABLED, SubjectsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsModelImpl.FINDER_CACHE_ENABLED, SubjectsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsModelImpl.FINDER_CACHE_ENABLED, SubjectsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] { String.class.getName() },
			SubjectsModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns the subjects where name = &#63; or throws a {@link com.service.NoSuchSubjectsException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching subjects
	 * @throws com.service.NoSuchSubjectsException if a matching subjects could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects findByname(String name)
		throws NoSuchSubjectsException, SystemException {
		Subjects subjects = fetchByname(name);

		if (subjects == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSubjectsException(msg.toString());
		}

		return subjects;
	}

	/**
	 * Returns the subjects where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching subjects, or <code>null</code> if a matching subjects could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects fetchByname(String name) throws SystemException {
		return fetchByname(name, true);
	}

	/**
	 * Returns the subjects where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching subjects, or <code>null</code> if a matching subjects could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects fetchByname(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Subjects) {
			Subjects subjects = (Subjects)result;

			if (!Validator.equals(name, subjects.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SUBJECTS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Subjects> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					Subjects subjects = list.get(0);

					result = subjects;

					cacheResult(subjects);

					if ((subjects.getName() == null) ||
							!subjects.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, subjects);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (Subjects)result;
		}
	}

	/**
	 * Removes the subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the subjects that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects removeByname(String name)
		throws NoSuchSubjectsException, SystemException {
		Subjects subjects = findByname(name);

		return remove(subjects);
	}

	/**
	 * Returns the number of subjectses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching subjectses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByname(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBJECTS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "subjects.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "subjects.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(subjects.name IS NULL OR subjects.name = '')";

	public SubjectsPersistenceImpl() {
		setModelClass(Subjects.class);
	}

	/**
	 * Caches the subjects in the entity cache if it is enabled.
	 *
	 * @param subjects the subjects
	 */
	@Override
	public void cacheResult(Subjects subjects) {
		EntityCacheUtil.putResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsImpl.class, subjects.getPrimaryKey(), subjects);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { subjects.getName() }, subjects);

		subjects.resetOriginalValues();
	}

	/**
	 * Caches the subjectses in the entity cache if it is enabled.
	 *
	 * @param subjectses the subjectses
	 */
	@Override
	public void cacheResult(List<Subjects> subjectses) {
		for (Subjects subjects : subjectses) {
			if (EntityCacheUtil.getResult(
						SubjectsModelImpl.ENTITY_CACHE_ENABLED,
						SubjectsImpl.class, subjects.getPrimaryKey()) == null) {
				cacheResult(subjects);
			}
			else {
				subjects.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subjectses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubjectsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubjectsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subjects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subjects subjects) {
		EntityCacheUtil.removeResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsImpl.class, subjects.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(subjects);
	}

	@Override
	public void clearCache(List<Subjects> subjectses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subjects subjects : subjectses) {
			EntityCacheUtil.removeResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
				SubjectsImpl.class, subjects.getPrimaryKey());

			clearUniqueFindersCache(subjects);
		}
	}

	protected void cacheUniqueFindersCache(Subjects subjects) {
		if (subjects.isNew()) {
			Object[] args = new Object[] { subjects.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, subjects);
		}
		else {
			SubjectsModelImpl subjectsModelImpl = (SubjectsModelImpl)subjects;

			if ((subjectsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { subjects.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					subjects);
			}
		}
	}

	protected void clearUniqueFindersCache(Subjects subjects) {
		SubjectsModelImpl subjectsModelImpl = (SubjectsModelImpl)subjects;

		Object[] args = new Object[] { subjects.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((subjectsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { subjectsModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new subjects with the primary key. Does not add the subjects to the database.
	 *
	 * @param id the primary key for the new subjects
	 * @return the new subjects
	 */
	@Override
	public Subjects create(long id) {
		Subjects subjects = new SubjectsImpl();

		subjects.setNew(true);
		subjects.setPrimaryKey(id);

		return subjects;
	}

	/**
	 * Removes the subjects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the subjects
	 * @return the subjects that was removed
	 * @throws com.service.NoSuchSubjectsException if a subjects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects remove(long id)
		throws NoSuchSubjectsException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the subjects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subjects
	 * @return the subjects that was removed
	 * @throws com.service.NoSuchSubjectsException if a subjects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects remove(Serializable primaryKey)
		throws NoSuchSubjectsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Subjects subjects = (Subjects)session.get(SubjectsImpl.class,
					primaryKey);

			if (subjects == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subjects);
		}
		catch (NoSuchSubjectsException nsee) {
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
	protected Subjects removeImpl(Subjects subjects) throws SystemException {
		subjects = toUnwrappedModel(subjects);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subjects)) {
				subjects = (Subjects)session.get(SubjectsImpl.class,
						subjects.getPrimaryKeyObj());
			}

			if (subjects != null) {
				session.delete(subjects);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subjects != null) {
			clearCache(subjects);
		}

		return subjects;
	}

	@Override
	public Subjects updateImpl(com.service.model.Subjects subjects)
		throws SystemException {
		subjects = toUnwrappedModel(subjects);

		boolean isNew = subjects.isNew();

		Session session = null;

		try {
			session = openSession();

			if (subjects.isNew()) {
				session.save(subjects);

				subjects.setNew(false);
			}
			else {
				session.merge(subjects);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubjectsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
			SubjectsImpl.class, subjects.getPrimaryKey(), subjects);

		clearUniqueFindersCache(subjects);
		cacheUniqueFindersCache(subjects);

		return subjects;
	}

	protected Subjects toUnwrappedModel(Subjects subjects) {
		if (subjects instanceof SubjectsImpl) {
			return subjects;
		}

		SubjectsImpl subjectsImpl = new SubjectsImpl();

		subjectsImpl.setNew(subjects.isNew());
		subjectsImpl.setPrimaryKey(subjects.getPrimaryKey());

		subjectsImpl.setId(subjects.getId());
		subjectsImpl.setName(subjects.getName());
		subjectsImpl.setCreateDate(subjects.getCreateDate());
		subjectsImpl.setModifiedDate(subjects.getModifiedDate());

		return subjectsImpl;
	}

	/**
	 * Returns the subjects with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subjects
	 * @return the subjects
	 * @throws com.service.NoSuchSubjectsException if a subjects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectsException, SystemException {
		Subjects subjects = fetchByPrimaryKey(primaryKey);

		if (subjects == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subjects;
	}

	/**
	 * Returns the subjects with the primary key or throws a {@link com.service.NoSuchSubjectsException} if it could not be found.
	 *
	 * @param id the primary key of the subjects
	 * @return the subjects
	 * @throws com.service.NoSuchSubjectsException if a subjects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects findByPrimaryKey(long id)
		throws NoSuchSubjectsException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the subjects with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subjects
	 * @return the subjects, or <code>null</code> if a subjects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Subjects subjects = (Subjects)EntityCacheUtil.getResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
				SubjectsImpl.class, primaryKey);

		if (subjects == _nullSubjects) {
			return null;
		}

		if (subjects == null) {
			Session session = null;

			try {
				session = openSession();

				subjects = (Subjects)session.get(SubjectsImpl.class, primaryKey);

				if (subjects != null) {
					cacheResult(subjects);
				}
				else {
					EntityCacheUtil.putResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
						SubjectsImpl.class, primaryKey, _nullSubjects);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubjectsModelImpl.ENTITY_CACHE_ENABLED,
					SubjectsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subjects;
	}

	/**
	 * Returns the subjects with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the subjects
	 * @return the subjects, or <code>null</code> if a subjects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subjects fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the subjectses.
	 *
	 * @return the subjectses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subjects> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Subjects> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Subjects> findAll(int start, int end,
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

		List<Subjects> list = (List<Subjects>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBJECTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECTS;

				if (pagination) {
					sql = sql.concat(SubjectsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Subjects>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subjects>(list);
				}
				else {
					list = (List<Subjects>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subjectses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Subjects subjects : findAll()) {
			remove(subjects);
		}
	}

	/**
	 * Returns the number of subjectses.
	 *
	 * @return the number of subjectses
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

				Query q = session.createQuery(_SQL_COUNT_SUBJECTS);

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
	 * Initializes the subjects persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.service.model.Subjects")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Subjects>> listenersList = new ArrayList<ModelListener<Subjects>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Subjects>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubjectsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBJECTS = "SELECT subjects FROM Subjects subjects";
	private static final String _SQL_SELECT_SUBJECTS_WHERE = "SELECT subjects FROM Subjects subjects WHERE ";
	private static final String _SQL_COUNT_SUBJECTS = "SELECT COUNT(subjects) FROM Subjects subjects";
	private static final String _SQL_COUNT_SUBJECTS_WHERE = "SELECT COUNT(subjects) FROM Subjects subjects WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subjects.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subjects exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subjects exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubjectsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Subjects _nullSubjects = new SubjectsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Subjects> toCacheModel() {
				return _nullSubjectsCacheModel;
			}
		};

	private static CacheModel<Subjects> _nullSubjectsCacheModel = new CacheModel<Subjects>() {
			@Override
			public Subjects toEntityModel() {
				return _nullSubjects;
			}
		};
}