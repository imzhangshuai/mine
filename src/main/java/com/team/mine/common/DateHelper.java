package com.team.mine.common;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	/**
	 * 一秒的毫秒数
	 */
	public static final long SECODE_IN_MILLISECONDS = 1000;

	/**
	 * 一分钟的毫秒数
	 */
	public static final long MINUTE_IN_MILLISECONDS = 60 * DateHelper.SECODE_IN_MILLISECONDS;

	/**
	 * 一小时的毫秒数
	 */
	public static final long HOUR_IN_MILLISECONDS = 60 * DateHelper.MINUTE_IN_MILLISECONDS;

	/**
	 * 一天的毫秒数
	 */
	public static final long DAY_IN_MILLISECONDS = 24 * DateHelper.HOUR_IN_MILLISECONDS;

	/**
	 * 一周的毫秒数
	 */
	public static final long WEEK_IN_MILLISECONDS = 7 * DateHelper.DAY_IN_MILLISECONDS;

	/**
	 * 每月天数
	 */
	private static final int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };

	/**
	 * 判断日期1是否在日期2之前。若其中一个为null，则返回false。
	 * 
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return boolean
	 */
	public static final boolean beforeDate(final Date date1, final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return false;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getDate(calendar, date1);
		final long time2 = DateHelper.getDate(calendar, date2);
		return time1 < time2;
	}

	/**
	 * 判断日期1是否在日期2之前。若其中一个为null，则返回false。
	 * 
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return boolean
	 */
	public static final boolean beforeOrMatchDate(final Date date1,
			final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return false;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getDate(calendar, date1);
		final long time2 = DateHelper.getDate(calendar, date2);
		return time1 <= time2;
	}

	/**
	 * 判断日期时间1是否在日期时间2之前。若其中一个为null，则返回false。
	 * 
	 * @param date1
	 *            日期时间1
	 * @param date2
	 *            日期时间2
	 * @return boolean
	 */
	public static final boolean beforeDateTime(final Date date1,
			final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return false;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getDateTime(calendar, date1);
		final long time2 = DateHelper.getDateTime(calendar, date2);
		return time1 < time2;
	}

	/**
	 * 判断时间1是否在时间2之前。若其中一个为null，则返回false。
	 * 
	 * @param date1
	 *            时间1
	 * @param date2
	 *            时间2
	 * @return boolean
	 */
	public static final boolean beforeTime(final Date date1, final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return false;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getTime(calendar, date1);
		final long time2 = DateHelper.getTime(calendar, date2);
		return time1 < time2;
	}

	private static final long getDate(final Calendar calendar, final Date date) {
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

	private static final long getDateTime(final Calendar calendar,
			final Date date) {
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

	/**
	 * 根据给定日期获取其当月总天数。
	 * 
	 * @param date
	 *            不能为null
	 * @return 当月总天数
	 */
	public static final int getDaysOfMonth(final Date date) {
		assert (date != null);
		final Calendar calendar = Calendar.getInstance();
		final int month = calendar.get(Calendar.MONTH);
		if ((month == 1) && DateHelper.isLeepYear(calendar.get(Calendar.YEAR))) {
			return 29;
		}
		return DateHelper.days[month];
	}

	/**
	 * 获取给定年份某月总天数
	 * 
	 * @param year
	 *            年份，大于零
	 * @param month
	 *            月份，值在1-12之间。
	 * @return 当月总天数
	 */
	public static final int getDaysOfMonth(final int year, final int month) {
		if (year <= 0) {
			throw new IllegalArgumentException();
		}
		if ((month < 1) || (month > 12)) {
			throw new IllegalArgumentException();
		}
		if ((month == 1) && DateHelper.isLeepYear(year)) {
			return 29;
		}
		return DateHelper.days[month - 1];
	}

	/**
	 * 返回指定某年某月1号在一星期中的天数.
	 * 
	 * @param date
	 *            不能为null
	 * @return 1-7
	 * @see Calendar#SUNDAY
	 * @see Calendar#MONDAY
	 * @see Calendar#TUESDAY
	 * @see Calendar#WEDNESDAY
	 * @see Calendar#THURSDAY
	 * @see Calendar#FRIDAY
	 * @see Calendar#SATURDAY
	 */
	public static final int getFirstDayOfMonth(final Date date) {
		assert (date != null);
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 返回指定某年某月1号在一星期中的天数.
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return 0-6
	 * @see Calendar#SUNDAY
	 * @see Calendar#MONDAY
	 * @see Calendar#TUESDAY
	 * @see Calendar#WEDNESDAY
	 * @see Calendar#THURSDAY
	 * @see Calendar#FRIDAY
	 * @see Calendar#SATURDAY
	 */
	public static final int getFirstDayOfMonth(final int year, final int month) {
		if (year <= 0) {
			throw new IllegalArgumentException();
		}
		if ((month < 1) || (month > 12)) {
			throw new IllegalArgumentException();
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	private static final long getTime(final Calendar calendar, final Date date) {
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

	/**
	 * 获取指定日期在一年中的周次。
	 * 
	 * @param calendar
	 *            日历
	 * @param millis
	 * @param isSundayFirstDay
	 *            星期天是否为一周最后一天
	 * @return int
	 */
	public static final int getWeeksOfYear(final Calendar calendar,
			final long millis, final boolean isSundayFirstDay) {
		calendar.setTimeInMillis(millis);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		final int weekEnd = isSundayFirstDay ? Calendar.SUNDAY
				: Calendar.SATURDAY;
		while (dayOfWeek != weekEnd) {
			calendar.roll(Calendar.DAY_OF_MONTH, true);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		}
		final long start = calendar.getTimeInMillis();
		int week = 1;
		if (millis > start) {
			final long weekMills = DateHelper.WEEK_IN_MILLISECONDS;
			final long dayMills = millis - start;
			week += (int) (dayMills / weekMills);
			if ((dayMills % weekMills) != 0) {
				week++;
			}
		}
		return week;
	}

	/**
	 * 获取指定日期在一年中的周次，星期天为一周最后一天。
	 * 
	 * @param date
	 * @return int
	 */
	public static final int getWeeksOfYear(final Date date) {
		return DateHelper.getWeeksOfYear(Calendar.getInstance(),
				date.getTime(), false);
	}

	/**
	 * 获取指定日期在一年中的周次。
	 * 
	 * @param date
	 * @param isSundayFirstDay
	 *            星期天是否为一周最后一天
	 * @return int
	 */
	public static final int getWeeksOfYear(final Date date,
			final boolean isSundayFirstDay) {
		return DateHelper.getWeeksOfYear(Calendar.getInstance(),
				date.getTime(), isSundayFirstDay);
	}

	/**
	 * 获取指定日期在一年中的周次，星期天为一周最后一天。
	 * 
	 * @param millis
	 * @return int
	 */
	public static final int getWeeksOfYear(final long millis) {
		return DateHelper.getWeeksOfYear(Calendar.getInstance(), millis, false);
	}

	/**
	 * 获取指定日期在一年中的周次。
	 * 
	 * @param millis
	 * @param isSundayFirstDay
	 *            星期天是否为一周最后一天
	 * @return int
	 */
	public static final int getWeeksOfYear(final long millis,
			final boolean isSundayFirstDay) {
		return DateHelper.getWeeksOfYear(Calendar.getInstance(), millis,
				isSundayFirstDay);
	}

	/**
	 * 判断给定年份是否是闰年。
	 * 
	 * @param year
	 *            年份，大于零
	 * @return 闰年为true
	 */
	public static final boolean isLeepYear(final int year) {
		if (year <= 0) {
			throw new IllegalArgumentException();
		}
		return (((year & 3) == 0) && ((year % 100) != 0))
				|| ((year % 400) == 0);
	}

	/**
	 * 匹配两日期对象是否一致。<br>
	 * 若其中任意一个为java.sql.Timestamp对象，则返回matchDateTime值；<br>
	 * 若其中任意一个为java.sql.Time对象，则返回matchTime值；<br>
	 * 否则，返回matchDate值。<br>
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static final boolean match(final Date date1, final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return date1 == date2;
		}
		if ((date1 instanceof java.sql.Timestamp)
				|| (date2 instanceof java.sql.Timestamp)) {
			return DateHelper.matchDateTime(date1, date2);
		}
		if ((date1 instanceof java.sql.Time)
				|| (date2 instanceof java.sql.Time)) {
			return DateHelper.matchTime(date1, date2);
		}
		return DateHelper.matchDate(date1, date2);
	}

	/**
	 * 判断两个日期是否匹配。仅匹配年、月、日。
	 * 
	 * @param date1
	 * @param date2
	 * @return true 匹配 false 不匹配
	 */
	public static final boolean matchDate(final Date date1, final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return date1 == date2;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getDate(calendar, date1);
		final long time2 = DateHelper.getDate(calendar, date2);
		return time1 == time2;
	}

	public static final boolean matchDateTime(final Date date1, final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return date1 == date2;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getDateTime(calendar, date1);
		final long time2 = DateHelper.getDateTime(calendar, date2);
		return time1 == time2;
	}

	/**
	 * 判断两个时间是否匹配。仅匹配时、分、秒。
	 * 
	 * @param date1
	 * @param date2
	 * @return true 匹配 false 不匹配
	 */
	public static final boolean matchTime(final Date date1, final Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return date1 == date2;
		}
		final Calendar calendar = Calendar.getInstance();
		final long time1 = DateHelper.getTime(calendar, date1);
		final long time2 = DateHelper.getTime(calendar, date2);
		return time1 == time2;
	}

	/**
	 * 滚动月份.
	 * 
	 * @param date
	 *            日期
	 * @param monthes
	 *            月份数
	 * @return {@code long}
	 */
	public static final long rollMonth(final long date, final int monthes) {
		if (monthes == 0) {
			return date;
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		if (monthes > 0) {
			int month = calendar.get(Calendar.MONTH);
			for (int i = 0; i < monthes; i++) {
				if (month == Calendar.DECEMBER) {
					calendar.roll(Calendar.YEAR, 1);
					month = -1;
				}
				month++;
			}
			calendar.roll(Calendar.MONTH, monthes);
			return calendar.getTimeInMillis();
		} else {
			for (int i = monthes; i < 0; i++) {
				if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
					calendar.roll(Calendar.YEAR, -1);
				}
				calendar.roll(Calendar.MONTH, 1);
			}
			return calendar.getTimeInMillis();
		}
	}
	
	/**
	 * 滚动年份.
	 * 
	 * @param date
	 *            日期
	 * @param years
	 *            年份数,正数表示加,负表示减.
	 * @return {@code long}
	 */
	public static final long rollYear(final long date, final int years) {
		if (years == 0) {
			return date;
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.roll(Calendar.YEAR, years);
		return calendar.getTimeInMillis();
	}
}