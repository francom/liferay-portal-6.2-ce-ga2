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

import com.service.NoSuchAcademicYearException;

import com.service.model.AcademicYear;
import com.service.model.impl.AcademicYearImpl;
import com.service.model.impl.AcademicYearModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the academic year service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tofu
 * @see AcademicYearPersistence
 * @see AcademicYearUtil
 * @generated
 */
public class AcademicYearPersistenceImpl extends BasePersistenceImpl<AcademicYear>
	implements AcademicYearPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AcademicYearUtil} to access the academic year persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AcademicYearImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearModelImpl.FINDER_CACHE_ENABLED, AcademicYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearModelImpl.FINDER_CACHE_ENABLED, AcademicYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearModelImpl.FINDER_CACHE_ENABLED, AcademicYearImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] { String.class.getName() },
			AcademicYearModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns the academic year where name = &#63; or throws a {@link com.service.NoSuchAcademicYearException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching academic year
	 * @throws com.service.NoSuchAcademicYearException if a matching academic year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear findByname(String name)
		throws NoSuchAcademicYearException, SystemException {
		AcademicYear academicYear = fetchByname(name);

		if (academicYear == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAcademicYearException(msg.toString());
		}

		return academicYear;
	}

	/**
	 * Returns the academic year where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching academic year, or <code>null</code> if a matching academic year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear fetchByname(String name) throws SystemException {
		return fetchByname(name, true);
	}

	/**
	 * Returns the academic year where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching academic year, or <code>null</code> if a matching academic year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear fetchByname(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof AcademicYear) {
			AcademicYear academicYear = (AcademicYear)result;

			if (!Validator.equals(name, academicYear.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACADEMICYEAR_WHERE);

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

				List<AcademicYear> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					AcademicYear academicYear = list.get(0);

					result = academicYear;

					cacheResult(academicYear);

					if ((academicYear.getName() == null) ||
							!academicYear.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, academicYear);
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
			return (AcademicYear)result;
		}
	}

	/**
	 * Removes the academic year where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the academic year that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear removeByname(String name)
		throws NoSuchAcademicYearException, SystemException {
		AcademicYear academicYear = findByname(name);

		return remove(academicYear);
	}

	/**
	 * Returns the number of academic years where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching academic years
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

			query.append(_SQL_COUNT_ACADEMICYEAR_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "academicYear.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "academicYear.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(academicYear.name IS NULL OR academicYear.name = '')";

	public AcademicYearPersistenceImpl() {
		setModelClass(AcademicYear.class);
	}

	/**
	 * Caches the academic year in the entity cache if it is enabled.
	 *
	 * @param academicYear the academic year
	 */
	@Override
	public void cacheResult(AcademicYear academicYear) {
		EntityCacheUtil.putResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearImpl.class, academicYear.getPrimaryKey(), academicYear);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { academicYear.getName() }, academicYear);

		academicYear.resetOriginalValues();
	}

	/**
	 * Caches the academic years in the entity cache if it is enabled.
	 *
	 * @param academicYears the academic years
	 */
	@Override
	public void cacheResult(List<AcademicYear> academicYears) {
		for (AcademicYear academicYear : academicYears) {
			if (EntityCacheUtil.getResult(
						AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
						AcademicYearImpl.class, academicYear.getPrimaryKey()) == null) {
				cacheResult(academicYear);
			}
			else {
				academicYear.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all academic years.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AcademicYearImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AcademicYearImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the academic year.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AcademicYear academicYear) {
		EntityCacheUtil.removeResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearImpl.class, academicYear.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(academicYear);
	}

	@Override
	public void clearCache(List<AcademicYear> academicYears) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AcademicYear academicYear : academicYears) {
			EntityCacheUtil.removeResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
				AcademicYearImpl.class, academicYear.getPrimaryKey());

			clearUniqueFindersCache(academicYear);
		}
	}

	protected void cacheUniqueFindersCache(AcademicYear academicYear) {
		if (academicYear.isNew()) {
			Object[] args = new Object[] { academicYear.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				academicYear);
		}
		else {
			AcademicYearModelImpl academicYearModelImpl = (AcademicYearModelImpl)academicYear;

			if ((academicYearModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { academicYear.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					academicYear);
			}
		}
	}

	protected void clearUniqueFindersCache(AcademicYear academicYear) {
		AcademicYearModelImpl academicYearModelImpl = (AcademicYearModelImpl)academicYear;

		Object[] args = new Object[] { academicYear.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((academicYearModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { academicYearModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new academic year with the primary key. Does not add the academic year to the database.
	 *
	 * @param id the primary key for the new academic year
	 * @return the new academic year
	 */
	@Override
	public AcademicYear create(long id) {
		AcademicYear academicYear = new AcademicYearImpl();

		academicYear.setNew(true);
		academicYear.setPrimaryKey(id);

		return academicYear;
	}

	/**
	 * Removes the academic year with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the academic year
	 * @return the academic year that was removed
	 * @throws com.service.NoSuchAcademicYearException if a academic year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear remove(long id)
		throws NoSuchAcademicYearException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the academic year with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the academic year
	 * @return the academic year that was removed
	 * @throws com.service.NoSuchAcademicYearException if a academic year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear remove(Serializable primaryKey)
		throws NoSuchAcademicYearException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AcademicYear academicYear = (AcademicYear)session.get(AcademicYearImpl.class,
					primaryKey);

			if (academicYear == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAcademicYearException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(academicYear);
		}
		catch (NoSuchAcademicYearException nsee) {
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
	protected AcademicYear removeImpl(AcademicYear academicYear)
		throws SystemException {
		academicYear = toUnwrappedModel(academicYear);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(academicYear)) {
				academicYear = (AcademicYear)session.get(AcademicYearImpl.class,
						academicYear.getPrimaryKeyObj());
			}

			if (academicYear != null) {
				session.delete(academicYear);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (academicYear != null) {
			clearCache(academicYear);
		}

		return academicYear;
	}

	@Override
	public AcademicYear updateImpl(com.service.model.AcademicYear academicYear)
		throws SystemException {
		academicYear = toUnwrappedModel(academicYear);

		boolean isNew = academicYear.isNew();

		Session session = null;

		try {
			session = openSession();

			if (academicYear.isNew()) {
				session.save(academicYear);

				academicYear.setNew(false);
			}
			else {
				session.merge(academicYear);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AcademicYearModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
			AcademicYearImpl.class, academicYear.getPrimaryKey(), academicYear);

		clearUniqueFindersCache(academicYear);
		cacheUniqueFindersCache(academicYear);

		return academicYear;
	}

	protected AcademicYear toUnwrappedModel(AcademicYear academicYear) {
		if (academicYear instanceof AcademicYearImpl) {
			return academicYear;
		}

		AcademicYearImpl academicYearImpl = new AcademicYearImpl();

		academicYearImpl.setNew(academicYear.isNew());
		academicYearImpl.setPrimaryKey(academicYear.getPrimaryKey());

		academicYearImpl.setId(academicYear.getId());
		academicYearImpl.setName(academicYear.getName());
		academicYearImpl.setCreateDate(academicYear.getCreateDate());
		academicYearImpl.setModifiedDate(academicYear.getModifiedDate());

		return academicYearImpl;
	}

	/**
	 * Returns the academic year with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the academic year
	 * @return the academic year
	 * @throws com.service.NoSuchAcademicYearException if a academic year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAcademicYearException, SystemException {
		AcademicYear academicYear = fetchByPrimaryKey(primaryKey);

		if (academicYear == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAcademicYearException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return academicYear;
	}

	/**
	 * Returns the academic year with the primary key or throws a {@link com.service.NoSuchAcademicYearException} if it could not be found.
	 *
	 * @param id the primary key of the academic year
	 * @return the academic year
	 * @throws com.service.NoSuchAcademicYearException if a academic year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear findByPrimaryKey(long id)
		throws NoSuchAcademicYearException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the academic year with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the academic year
	 * @return the academic year, or <code>null</code> if a academic year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AcademicYear academicYear = (AcademicYear)EntityCacheUtil.getResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
				AcademicYearImpl.class, primaryKey);

		if (academicYear == _nullAcademicYear) {
			return null;
		}

		if (academicYear == null) {
			Session session = null;

			try {
				session = openSession();

				academicYear = (AcademicYear)session.get(AcademicYearImpl.class,
						primaryKey);

				if (academicYear != null) {
					cacheResult(academicYear);
				}
				else {
					EntityCacheUtil.putResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
						AcademicYearImpl.class, primaryKey, _nullAcademicYear);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AcademicYearModelImpl.ENTITY_CACHE_ENABLED,
					AcademicYearImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return academicYear;
	}

	/**
	 * Returns the academic year with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the academic year
	 * @return the academic year, or <code>null</code> if a academic year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademicYear fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the academic years.
	 *
	 * @return the academic years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademicYear> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academic years.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.AcademicYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of academic years
	 * @param end the upper bound of the range of academic years (not inclusive)
	 * @return the range of academic years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademicYear> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the academic years.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.model.impl.AcademicYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of academic years
	 * @param end the upper bound of the range of academic years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of academic years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademicYear> findAll(int start, int end,
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

		List<AcademicYear> list = (List<AcademicYear>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACADEMICYEAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACADEMICYEAR;

				if (pagination) {
					sql = sql.concat(AcademicYearModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AcademicYear>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademicYear>(list);
				}
				else {
					list = (List<AcademicYear>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the academic years from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AcademicYear academicYear : findAll()) {
			remove(academicYear);
		}
	}

	/**
	 * Returns the number of academic years.
	 *
	 * @return the number of academic years
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

				Query q = session.createQuery(_SQL_COUNT_ACADEMICYEAR);

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
	 * Initializes the academic year persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.service.model.AcademicYear")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AcademicYear>> listenersList = new ArrayList<ModelListener<AcademicYear>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AcademicYear>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AcademicYearImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACADEMICYEAR = "SELECT academicYear FROM AcademicYear academicYear";
	private static final String _SQL_SELECT_ACADEMICYEAR_WHERE = "SELECT academicYear FROM AcademicYear academicYear WHERE ";
	private static final String _SQL_COUNT_ACADEMICYEAR = "SELECT COUNT(academicYear) FROM AcademicYear academicYear";
	private static final String _SQL_COUNT_ACADEMICYEAR_WHERE = "SELECT COUNT(academicYear) FROM AcademicYear academicYear WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "academicYear.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AcademicYear exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AcademicYear exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AcademicYearPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static AcademicYear _nullAcademicYear = new AcademicYearImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AcademicYear> toCacheModel() {
				return _nullAcademicYearCacheModel;
			}
		};

	private static CacheModel<AcademicYear> _nullAcademicYearCacheModel = new CacheModel<AcademicYear>() {
			@Override
			public AcademicYear toEntityModel() {
				return _nullAcademicYear;
			}
		};
}