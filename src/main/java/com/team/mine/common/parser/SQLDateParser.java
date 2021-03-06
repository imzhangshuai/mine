package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class SQLDateParser {

	protected static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	public static Date parse(final String value) {
		return parse(value, DEFAULT_PATTERN);
	}

	public static Date parse(final String value, String pattern) {

		if (StringHelper.isEmpty(value)) {
			return null;
		}
		if (StringHelper.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		final SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		try {
			return new Date(fmt.parse(value).getTime());
		} catch (final ParseException e) {
			return null;
		}
	}

	public static Date[] parseArray(final String[] values) {
		return parseArray(values, DEFAULT_PATTERN);
	}

	public static Date[] parseArray(final String[] values, String pattern) {
		if (values == null || values.length == 0) {
			return null;
		}
		if (StringHelper.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		final SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		final Date[] dates = new Date[values.length];
		for (int i = 0; i < values.length; i++) {
			if (StringHelper.isEmpty(values[i])) {
				continue;
			}
			try {
				dates[i] = new Date(fmt.parse(values[i]).getTime());
			} catch (final ParseException e) {
			}
		}
		return dates;
	}

	public static String format(final Date date) {
		return format(date, DEFAULT_PATTERN);
	}

	public static String format(final Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (StringHelper.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.format(date);
		} catch (final IllegalArgumentException e) {
			return "";
		}
	}

}
