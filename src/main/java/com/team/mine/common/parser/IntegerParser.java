package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class IntegerParser {

	public static int parse(final Object value) {
		return value == null ? 0 : parse(value.toString(), 0);
	}

	public static Integer parseObject(final Object value) {
		return value == null ? Integer.valueOf(0) : parse(value.toString(), 0);
	}

	public static int parse(final String value) {
		return parse(value, 0);
	}

	public static int parse(final String value, final int defaultValue) {
		if (StringHelper.isEmpty(value)) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(StringHelper.trim(value)
					.replaceAll(",", ""));
		} catch (final NumberFormatException e) {
			return defaultValue;
		}
	}

	public static int[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final int[] fs = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			try {
				fs[i] = Integer.parseInt(StringHelper.trim(values[i])
						.replaceAll(",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = 0;
			}
		}
		return fs;
	}

	public static Integer parseObject(final String value) {
		return Integer.valueOf(parse(value));
	}

	public static Integer[] parseObjectArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final Integer[] fs = new Integer[values.length];
		for (int i = 0; i < values.length; i++) {
			try {
				fs[i] = Integer.valueOf(StringHelper.trim(values[i])
						.replaceAll(",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = Integer.valueOf(0);
			}
		}
		return fs;
	}

}
