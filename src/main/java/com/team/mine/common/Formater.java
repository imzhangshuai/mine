package com.team.mine.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formater {

	protected static final DecimalFormat RATE_FORMAT = new DecimalFormat("#0.0");
	protected static final DecimalFormat RATE_PERCENT_FORMAT = new DecimalFormat(
			"#0.0%");
	protected static final DecimalFormat PROESS_FORMAT = new DecimalFormat(
			"#0%");
	protected static final DecimalFormat AMOUNT_SPLIT_FORMAT = new DecimalFormat(
			"#,##,##0.00");
	protected static final DecimalFormat AMOUNT_FORMAT = new DecimalFormat(
			"#####0.00");

	protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");
	protected static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(
			"HH:mm:ss");
	protected static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 格式化日期.
	 * 
	 * @param date
	 *            日期
	 * @return {@link String}
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return StringHelper.EMPTY_STRING;
		}
		return DATE_FORMAT.format(date);
	}

	/**
	 * 格式化时间.
	 * 
	 * @param date
	 *            日期
	 * @return {@link String}
	 */
	public static String formatTime(Date date) {
		if (date == null) {
			return StringHelper.EMPTY_STRING;
		}
		return TIME_FORMAT.format(date);
	}

	/**
	 * 格式化日期时间.
	 * 
	 * @param date
	 *            日期
	 * @return {@link String}
	 */
	public static String formatDateTime(Date date) {
		if (date == null) {
			return StringHelper.EMPTY_STRING;
		}
		return DATETIME_FORMAT.format(date);
	}

	/**
	 * 百分比，带百分号，精确到3位小数.
	 * 
	 * @param number
	 * @return {@link String}
	 */
	public static String formatRate(float number) {
		return RATE_PERCENT_FORMAT.format(number);
	}

	/**
	 * 百分比，带百分号，精确到3位小数.
	 * 
	 * @param number
	 * @return {@link String}
	 */
	public static String formatRate(double number) {
		return RATE_PERCENT_FORMAT.format(number);
	}

	/**
	 * 百分比，带百分号，精确到3位小数.
	 * 
	 * @param number
	 * @return {@link String}
	 */
	public static String formatRate(BigDecimal number) {
		return RATE_PERCENT_FORMAT.format(number);
	}

	/**
	 * 百分比，带百分号，精确到3位小数.
	 * 
	 * @param number
	 * @param includePercent
	 *            是否包含百分号
	 * @return {@link String}
	 */
	public static String formatRate(float number, boolean includePercent) {
		return includePercent ? RATE_PERCENT_FORMAT.format(number)
				: RATE_FORMAT.format(number * 100);
	}

	/**
	 * 百分比，带百分号，精确到3位小数.
	 * 
	 * @param number
	 * @param includePercent
	 *            是否包含百分号
	 * @return {@link String}
	 */
	public static String formatRate(double number, boolean includePercent) {
		return includePercent ? RATE_PERCENT_FORMAT.format(number)
				: RATE_FORMAT.format(number * 100);
	}

	/**
	 * 百分比，带百分号，精确到3位小数.
	 * 
	 * @param number
	 * @param includePercent
	 *            是否包含百分号
	 * @return {@link String}
	 */
	public static String formatRate(BigDecimal number, boolean includePercent) {
		return includePercent ? RATE_PERCENT_FORMAT.format(number)
				: RATE_FORMAT.format(number.multiply(new BigDecimal(100)));
	}

	/**
	 * 计算进度
	 * 
	 * @param number
	 * @return {@code int}
	 */
	public static int roundProgress(double number) {
		double v = number * 100;
		if (v <= 0) {
			return 0;
		}
		if (v <= 1) {
			return 1;
		}
		return (int) (Math.floor(number * 100) / 100);
	}

	/**
	 * 计算进度
	 * 
	 * @param number
	 * @return {@code int}
	 */
	public static int roundProgress(float number) {
		double v = number * 100;
		if (v <= 0) {
			return 0;
		}
		if (v <= 1) {
			return 1;
		}
		return (int) (Math.floor(number * 100) / 100);
	}

	/**
	 * 计算进度
	 * 
	 * @param number
	 * @return {@link String}
	 */
	public static String formatProgress(double number) {
		double v = number * 100;
		if (v <= 0) {
			return "0%";
		}
		if (v <= 1) {
			return "1%";
		}
		return PROESS_FORMAT.format(Math.floor(number * 100) / 100);
	}

	/**
	 * 计算进度
	 * 
	 * @param number
	 * @return
	 */
	public static String formatProgress(float number) {
		double v = number * 100;
		if (v <= 0) {
			return "0%";
		}
		if (v <= 1) {
			return "1%";
		}
		return PROESS_FORMAT.format(Math.floor(number * 100) / 100);
	}

	/**
	 * 金额格式化,千分位格式化
	 * 
	 * @param number
	 *            金额
	 * @return String
	 */
	public static String formatAmount(int number) {
		return AMOUNT_SPLIT_FORMAT.format(number);
	}

	/**
	 * 金额格式化,千分位格式化
	 * 
	 * @param number
	 *            金额
	 * @return String
	 */
	public static String formatAmount(long number) {
		return AMOUNT_SPLIT_FORMAT.format(number);
	}

	/**
	 * 金额格式化,千分位格式化
	 * 
	 * @param number
	 *            金额
	 * @return String
	 */
	public static String formatAmount(float number) {
		return AMOUNT_SPLIT_FORMAT.format(number);
	}

	/**
	 * 金额格式化,千分位格式化
	 * 
	 * @param number
	 *            金额
	 * @return String
	 */
	public static String formatAmount(double number) {
		return AMOUNT_SPLIT_FORMAT.format(number);
	}

	/**
	 * 金额格式化,千分位格式化
	 * 
	 * @param number
	 *            金额
	 * @return String
	 */
	public static String formatAmount(BigDecimal number) {
		if (number == null) {
			return StringHelper.EMPTY_STRING;
		}
		return AMOUNT_SPLIT_FORMAT.format(number);
	}

	/**
	 * 金额格式化,千分位格式化
	 * 
	 * @param number
	 *            金额
	 * @return String
	 */
	public static String formatAmount(BigInteger number) {
		if (number == null) {
			return StringHelper.EMPTY_STRING;
		}
		return AMOUNT_SPLIT_FORMAT.format(number);
	}

	/**
	 * 金额格式化
	 * 
	 * @param number
	 *            金额
	 * @param split
	 *            是否千分位格式化
	 * @return {@link String}
	 */
	public static String formatAmount(int number, boolean split) {
		return split ? AMOUNT_SPLIT_FORMAT.format(number) : AMOUNT_FORMAT
				.format(number);
	}

	/**
	 * 金额格式化
	 * 
	 * @param number
	 *            金额
	 * @param split
	 *            是否千分位格式化
	 * @return {@link String}
	 */
	public static String formatAmount(long number, boolean split) {
		return split ? AMOUNT_SPLIT_FORMAT.format(number) : AMOUNT_FORMAT
				.format(number);
	}

	/**
	 * 金额格式化
	 * 
	 * @param number
	 *            金额
	 * @param split
	 *            是否千分位格式化
	 * @return {@link String}
	 */
	public static String formatAmount(float number, boolean split) {
		return split ? AMOUNT_SPLIT_FORMAT.format(number) : AMOUNT_FORMAT
				.format(number);
	}

	/**
	 * 金额格式化
	 * 
	 * @param number
	 *            金额
	 * @param split
	 *            是否千分位格式化
	 * @return {@link String}
	 */
	public static String formatAmount(double number, boolean split) {
		return split ? AMOUNT_SPLIT_FORMAT.format(number) : AMOUNT_FORMAT
				.format(number);
	}

	/**
	 * 金额格式化
	 * 
	 * @param number
	 *            金额
	 * @param split
	 *            是否千分位格式化
	 * @return {@link String}
	 */
	public static String formatAmount(BigDecimal number, boolean split) {
		if (number == null) {
			return StringHelper.EMPTY_STRING;
		}
		return split ? AMOUNT_SPLIT_FORMAT.format(number) : AMOUNT_FORMAT
				.format(number);
	}

	/**
	 * 金额格式化
	 * 
	 * @param number
	 *            金额
	 * @param split
	 *            是否千分位格式化
	 * @return {@link String}
	 */
	public static String formatAmount(BigInteger number, boolean split) {
		if (number == null) {
			return StringHelper.EMPTY_STRING;
		}
		return split ? AMOUNT_SPLIT_FORMAT.format(number) : AMOUNT_FORMAT
				.format(number);
	}
}
