package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class ShortParser {

	public static short parse(final String value) {
		if (StringHelper.isEmpty(value)) {
			return 0;
		}
		try {
			return Short.valueOf(StringHelper.trim(value).replaceAll(",", ""));
		} catch (final NumberFormatException e) {
			return 0;
		}
	}

	public static short[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final short[] fs = new short[values.length];
		for (int i = 0; i < values.length; i++) {
			try {
				fs[i] = Short.valueOf(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = 0;
			}
		}
		return fs;
	}

	public static Short parseObject(final String value) {
		return Short.valueOf(parse(value));

	}

	public static Short[] parseObjectArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final Short[] fs = new Short[values.length];
		for (int i = 0; i < values.length; i++) {
			try {
				fs[i] = Short.valueOf(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = Short.valueOf("0");
			}
		}
		return fs;
	}

}
