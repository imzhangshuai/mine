package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class DoubleParser {

	public static double parse(final String value) {
		if (StringHelper.isEmpty(value)) {
			return 0.0;
		}
		try {
			return Double.parseDouble(StringHelper.trim(value).replaceAll(",",
					""));
		} catch (final NumberFormatException e) {
			return 0.0;
		}
	}

	public static double[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final double[] ds = new double[values.length];
		for (int i = 0; i < values.length; i++) {
			if (StringHelper.isEmpty(values[i])) {
				continue;
			}
			try {
				ds[i] = Double.parseDouble(StringHelper.trim(values[i])
						.replaceAll(",", ""));
			} catch (final NumberFormatException e) {
				ds[i] = 0.0;
			}
		}
		return ds;
	}

	public Double parseObject(final String value) {
		return Double.valueOf(parse(value));

	}

	public static Double[] parseObjectArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final Double[] ds = new Double[values.length];
		for (int i = 0; i < values.length; i++) {
			if (StringHelper.isEmpty(values[i])) {
				continue;
			}
			try {
				ds[i] = Double.valueOf(values[i].replaceAll(",", ""));
			} catch (final NumberFormatException e) {
				ds[i] = Double.valueOf(0.0);
			}
		}
		return ds;
	}

}
