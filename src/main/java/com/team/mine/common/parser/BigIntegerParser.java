package com.team.mine.common.parser;

import java.math.BigInteger;

import com.team.mine.common.StringHelper;

public class BigIntegerParser {

	public static BigInteger parse(final String value) {
		if (StringHelper.isEmpty(value)) {
			return BigInteger.valueOf(0);
		}
		try {
			return new BigInteger(StringHelper.trim(value).replaceAll(",", ""));
		} catch (final NumberFormatException e) {
			return BigInteger.valueOf(0);
		}
	}

	public static BigInteger[] parseArray(final String[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		final BigInteger[] ds = new BigInteger[values.length];
		for (int i = 0; i < values.length; i++) {
			if (StringHelper.isEmpty(values[i])) {
				ds[i] = BigInteger.valueOf(0);
				continue;
			}
			try {
				ds[i] = new BigInteger(StringHelper.trim(values[i]).replaceAll(
						",", ""));
			} catch (final NumberFormatException e) {
				ds[i] = BigInteger.valueOf(0);
			}
		}
		return ds;
	}

}
