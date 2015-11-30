package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class BooleanParser {

	public static boolean parse(String value) {
		if (StringHelper.isEmpty(value)) {
			return false;
		}
		value = value.trim();
		if ("Y".equalsIgnoreCase(value) || "1".equalsIgnoreCase(value)
				|| "true".equalsIgnoreCase(value)
				|| "yes".equalsIgnoreCase(value)) {
			return true;
		}
		return false;
	}

	public static boolean[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final boolean[] b = new boolean[values.length];
		for (int i = 0; i < values.length; i++) {
			b[i] = parse(values[i]);
		}
		return b;
	}

	public static Boolean parseObject(final String value) {
		if (StringHelper.isEmpty(value)) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(parse(value));
	}

	public static Boolean[] parseObjectArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final Boolean[] b = new Boolean[values.length];
		for (int i = 0; i < values.length; i++) {
			b[i] = Boolean.valueOf(parse(values[i]));
		}
		return b;
	}

}
