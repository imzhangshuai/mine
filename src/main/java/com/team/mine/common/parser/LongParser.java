package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class LongParser {

	public static long parse(final Object value) {
		return value == null ? 0 : parse(value.toString());
	}

	public static Long parseObject(final Object value) {
		return value == null ? Long.valueOf(0) : parse(value.toString());
	}

	public static long parse(final String value) {
		if (StringHelper.isEmpty(value)) {
			return 0;
		}
		try {
			return Long.parseLong(StringHelper.trim(value).replaceAll(",", ""));
		} catch (final NumberFormatException e) {
			return 0;
		}
	}

	public static long[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final long[] fs = new long[values.length];
		for (int i = 0; i < values.length; i++) {
			try {
				fs[i] = Long.parseLong(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = 0;
			}
		}
		return fs;
	}

	public static Long parseObject(final String value) {
		return Long.valueOf(parse(value));

	}

	public static Long[] parseObjectArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final Long[] fs = new Long[values.length];
		for (int i = 0; i < values.length; i++) {
			try {
				fs[i] = Long.valueOf(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = Long.valueOf(0);
			}
		}
		return fs;
	}

}
