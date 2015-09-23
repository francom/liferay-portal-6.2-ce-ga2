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

import com.service.NoSuchSubjectException;

import com.service.model.Subject;
import com.service.model.impl.SubjectImpl;
import com.service.model.impl.SubjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see SubjectPersistence
 * @see SubjectUtil
 * @generated
 */
public class SubjectPersistenceImpl extends BasePersistenceImpl<Subject>
	implements SubjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] { String.class.getName() },
			SubjectModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns the subject where name = &#63; or throws a {@link com.service.NoSuchSubjectException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching subject
	 * @throws com.service.NoSuchSubjectException if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findByname(String name)
		throws NoSuchSubjectException, SystemException {
		Subject subject = fetchByname(name);

		if (subject == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSubjectException(msg.toString());
		}

		return subject;
	}

	/**
	 * Returns the subject where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchByname(String name) throws SystemException {
		return fetchByname(name, true);
	}

	/**
	 * Returns the subject where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchByname(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Subject) {
			Subject subject = (Subject)result;

			if (!Validator.equals(name, subject.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SUBJECT_WHERE);

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

				List<Subject> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					Subject subject = list.get(0);

					result = subject;

					cacheResult(subject);

					if ((subject.getName() == null) ||
							!subject.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, subject);
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
			return (Subject)result;
		}
	}

	/**
	 * Removes the subject where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the subject that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject removeByname(String name)
		throws NoSuchSubjectException, SystemException {
		Subject subject = findByname(name);

		return remove(subject);
	}

	/**
	 * Returns the number of subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching subjects
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

			query.append(_SQL_COUNT_SUBJECT_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "subject.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "subject.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(subject.name IS NULL OR subject.name = '')";

	public SubjectPersistenceImpl() {
		setModelClass(Subject.class);
	}

	/**
	 * Caches the subject in the entity cache if it is enabled.
	 *
	 * @param subject the subject
	 */
	@Override
	public void cacheResult(Subject subject) {
		EntityCacheUtil.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey(), subject);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { subject.getName() }, subject);

		subject.resetOriginalValues();
	}

	/**
	 * Caches the subjects in the entity cache if it is enabled.
	 *
	 * @param subjects the subjects
	 */
	@Override
	public void cacheResult(List<Subject> subjects) {
		for (Subject subject : subjects) {
			if (EntityCacheUtil.getResult(
						SubjectModelImpl.ENTITY_CACHE_ENABLED,
						SubjectImpl.class, subject.getPrimaryKey()) == null) {
				cacheResult(subject);
			}
			else {
				subject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subjects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subject.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subject subject) {
		EntityCacheUtil.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(subject);
	}

	@Override
	public void clearCache(List<Subject> subjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subject subject : subjects) {
			EntityCacheUtil.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
				SubjectImpl.class, subject.getPrimaryKey());

			clearUniqueFindersCache(subject);
		}
	}

	protected void cacheUniqueFindersCache(Subject subject) {
		if (subject.isNew()) {
			Object[] args = new Object[] { subject.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, subject);
		}
		else {
			SubjectModelImpl subjectModelImpl = (SubjectModelImpl)subject;

			if ((subjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { subject.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					subject);
			}
		}
	}

	protected void clearUniqueFindersCache(Subject subject) {
		SubjectModelImpl subjectModelImpl = (SubjectModelImpl)subject;

		Object[] args = new Object[] { subject.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((subjectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { subjectModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new subject with the primary key. Does not add the subject to the database.
	 *
	 * @param id the primary key for the new subject
	 * @return the new subject
	 */
	@Override
	public Subject create(long id) {
		Subject subject = new SubjectImpl();

		subject.setNew(true);
		subject.setPrimaryKey(id);

		return subject;
	}

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the subject
	 * @return the subject that was removed
	 * @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject remove(long id)
		throws NoSuchSubjectException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject that was removed
	 * @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject remove(Serializable primaryKey)
		throws NoSuchSubjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Subject subject = (Subject)session.get(SubjectImpl.class, primaryKey);

			if (subject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subject);
		}
		catch (NoSuchSubjectException nsee) {
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
	protected Subject removeImpl(Subject subject) throws SystemException {
		subject = toUnwrappedModel(subject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subject)) {
				subject = (Subject)session.get(SubjectImpl.class,
						subject.getPrimaryKeyObj());
			}

			if (subject != null) {
				session.delete(subject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subject != null) {
			clearCache(subject);
		}

		return subject;
	}

	@Override
	public Subject updateImpl(com.service.model.Subject subject)
		throws SystemException {
		subject = toUnwrappedModel(subject);

		boolean isNew = subject.isNew();

		Session session = null;

		try {
			session = openSession();

			if (subject.isNew()) {
				session.save(subject);

				subject.setNew(false);
			}
			else {
				session.merge(subject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey(), subject);

		clearUniqueFindersCache(subject);
		cacheUniqueFindersCache(subject);

		return subject;
	}

	protected Subject toUnwrappedModel(Subject subject) {
		if (subject instanceof SubjectImpl) {
			return subject;
		}

		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setNew(subject.isNew());
		subjectImpl.setPrimaryKey(subject.getPrimaryKey());

		subjectImpl.setId(subject.getId());
		subjectImpl.setName(subject.getName());
		subjectImpl.setCreateDate(subject.getCreateDate());
		subjectImpl.setModifiedDate(subject.getModifiedDate());

		return subjectImpl;
	}

	/**
	 * Returns the subject with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject
	 * @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectException, SystemException {
		Subject subject = fetchByPrimaryKey(primaryKey);

		if (subject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subject;
	}

	/**
	 * Returns the subject with the primary key or throws a {@link com.service.NoSuchSubjectException} if it could not be found.
	 *
	 * @param id the primary key of the subject
	 * @return the subject
	 * @throws com.service.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findByPrimaryKey(long id)
		throws NoSuchSubjectException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Subject subject = (Subject)EntityCacheUtil.getResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
				SubjectImpl.class, primaryKey);

		if (subject == _nullSubject) {
			return null;
		}

		if (subject == null) {
			Session session = null;

			try {
				session = openSession();

				subject = (Subject)session.get(SubjectImpl.class, primaryKey);

				if (subject != null) {
					cacheResult(subject);
				}
				else {
					EntityCacheUtil.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
						SubjectImpl.class, primaryKey, _nullSubject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
					SubjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subject;
	}

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the subjects.
	 *
	 * @return the subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subject> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Subject> findAll(int start, int end,
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

		List<Subject> list = (List<Subject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECT;

				if (pagination) {
					sql = sql.concat(SubjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subject>(list);
				}
				else {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subjects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Subject subject : findAll()) {
			remove(subject);
		}
	}

	/**
	 * Returns the number of subjects.
	 *
	 * @return the number of subjects
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

				Query q = session.createQuery(_SQL_COUNT_SUBJECT);

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
	 * Initializes the subject persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.service.model.Subject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Subject>> listenersList = new ArrayList<ModelListener<Subject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Subject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBJECT = "SELECT subject FROM Subject subject";
	private static final String _SQL_SELECT_SUBJECT_WHERE = "SELECT subject FROM Subject subject WHERE ";
	private static final String _SQL_COUNT_SUBJECT = "SELECT COUNT(subject) FROM Subject subject";
	private static final String _SQL_COUNT_SUBJECT_WHERE = "SELECT COUNT(subject) FROM Subject subject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubjectPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Subject _nullSubject = new SubjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Subject> toCacheModel() {
				return _nullSubjectCacheModel;
			}
		};

	private static CacheModel<Subject> _nullSubjectCacheModel = new CacheModel<Subject>() {
			@Override
			public Subject toEntityModel() {
				return _nullSubject;
			}
		};
}