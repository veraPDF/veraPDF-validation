/**
 * This file is part of veraPDF Metadata Fixer, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Metadata Fixer is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Metadata Fixer as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Metadata Fixer as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.metadata.fixer.gf.utils;

import org.verapdf.xmp.XMPDateTime;
import org.verapdf.xmp.XMPDateTimeFactory;
import org.verapdf.xmp.XMPException;
import org.verapdf.tools.TypeConverter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.verapdf.metadata.fixer.utils.MetadataFixerConstants.UTC_PATTERN;

/**
 * Utility class for converting dates to different formats
 *
 * @author Maksim Bezrukov
 */
public class DateConverter {

	/**
	 * Convert {@code Calendar} object to string representation in xmp date form
	 *
	 * @param calendar passed date
	 * @return string representation of passed date
	 */
	public static String toXMPDateFormat(Calendar calendar) {
		return calendar == null ? null : toXMPDateFormat(calendar.getTime());
	}

	/**
	 * Convert {@code Date} object to string representation in xmp date form
	 *
	 * @param time passed date
	 * @return string representation of passed date
	 */
	public static String toXMPDateFormat(Date time) {
		if (time == null) {
			return null;
		}

		return new SimpleDateFormat(UTC_PATTERN).format(time);
	}

	/**
	 * Convert string date representation to string representation in xmp date form.
	 *
	 * @param date passed date
	 * @return XMP representation of passed date
	 */
	public static String toXMPDateFormat(String date) {
		return toXMPDateFormat(toCalendar(date));
	}

	/**
	 * Convert string representation of date to {@code Calendar} object
	 *
	 * @param date passed string date
	 * @return {@code Calendar} date
	 */
	public static Calendar toCalendar(String date) {
		if (date == null) {
			return null;
		}

		return TypeConverter.parseDate(date);
	}

	/**
	 * Convert string representation of date to
	 * string representation of date in PDF format
	 *
	 * @param date passed date
	 * @return PDF string representation of passed date
	 */
	public static String toPDFDateFormat(String date) {
		try {
			XMPDateTime fromISO8601 = XMPDateTimeFactory.createFromISO8601(date);
			Calendar buffer = fromISO8601.getCalendar();
			return TypeConverter.getPDFDate(buffer);
		} catch (XMPException e) {
			// This exception should not be thrown because of logic of metadata fixer should use this method only
			// with arguments date obtained from DateConverter.toXMPDateFormat(Calendar) method
			throw new IllegalStateException("Problems with parsing utc date", e);
		}
	}

	/**
	 * Convert {@code Calendar} date to string representation of date in PDF format
	 *
	 * @param date passed date
	 * @return PDF string representation of date
	 */
	public static String toPDFDateFormat(Calendar date) {
		return TypeConverter.getPDFDate(date);
	}
}
