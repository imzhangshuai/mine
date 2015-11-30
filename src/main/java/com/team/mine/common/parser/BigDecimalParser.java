package com.team.mine.common.parser;

import java.math.BigDecimal;

import com.team.mine.common.StringHelper;


public class BigDecimalParser {

	public static BigDecimal parse(final String value) {
		if (StringHelper.isEmpty(value)) {
			return BigDecimal.valueOf(0);
		}
		try {
			return new BigDecimal(StringHelper.trim(value).replaceAll(",", ""));
		} catch (final NumberFormatException e) {
			return BigDecimal.valueOf(0);
		}
	}

	public static BigDecimal[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final BigDecimal[] ds = new BigDecimal[values.length];
		for (int i = 0; i < values.length; i++) {
			if (StringHelper.isEmpty(values[i])) {
				ds[i] = BigDecimal.valueOf(0);
				continue;
			}
			try {
				ds[i] = new BigDecimal(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				ds[i] = BigDecimal.valueOf(0);
			}
		}
		return ds;
	}

}
