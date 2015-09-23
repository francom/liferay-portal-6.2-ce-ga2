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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Tofu
 */
public class AcademicYearFinderUtil {
	public static java.util.List<com.service.model.AcademicYear> listAcademicYearById(
		int start, int end) {
		return getFinder().listAcademicYearById(start, end);
	}

	public static AcademicYearFinder getFinder() {
		if (_finder == null) {
			_finder = (AcademicYearFinder)PortletBeanLocatorUtil.locate(com.service.service.ClpSerializer.getServletContextName(),
					AcademicYearFinder.class.getName());

			ReferenceRegistry.registerReference(AcademicYearFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AcademicYearFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AcademicYearFinderUtil.class,
			"_finder");
	}

	private static AcademicYearFinder _finder;
}