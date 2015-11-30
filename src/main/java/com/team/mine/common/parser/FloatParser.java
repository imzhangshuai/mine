package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class FloatParser {

	public static float parse(final String value) {
		if (StringHelper.isEmpty(value)) {
			return 0;
		}
		try {
			return Float.parseFloat(StringHelper.trim(value)
					.replaceAll(",", ""));
		} catch (final NumberFormatException e) {
			return 0;
		}
	}

	public static float[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final float[] fs = new float[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) {
				continue;
			}
			try {
				fs[i] = Float.parseFloat(StringHelper.trim(values[i])
						.replaceAll(",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = 0;
			}
		}
		return fs;
	}

	public static Float parseObject(final String value) {
		return Float.valueOf(parse(value));

	}

	public static Float[] parseObjectArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final Float[] fs = new Float[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) {
				continue;
			}
			try {
				fs[i] = Float.valueOf(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				fs[i] = Float.valueOf(0);
			}
		}
		return fs;
	}

}
