package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimestampParser {

    protected static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    protected static final String DEFAULT_PATTERN_1 = "yyyy-MM-dd";

    protected static final String DEFAULT_PATTERN_2 = "yyyy-MM-dd HH";

    protected static final String DEFAULT_PATTERN_3 = "yyyy-MM-dd HH:mm";

    public static Timestamp parse(final String value) {
        return parse(value, DEFAULT_PATTERN);
    }

    public static Timestamp parse(final String value, String pattern) {
        if (StringHelper.isEmpty(value)) {
            return null;
        }
        if (StringHelper.isEmpty(pattern) || value.length() == 19) {
            pattern = DEFAULT_PATTERN;
        } else if (value.length() == 16) {
            pattern = DEFAULT_PATTERN_3;
        } else if (value.length() == 13) {
            pattern = DEFAULT_PATTERN_2;
        } else if (value.length() == 10) {
            pattern = DEFAULT_PATTERN_1;
        }
        final SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        try {
            return new Timestamp(fmt.parse(value).getTime());
        } catch (final ParseException e) {
            return null;
        }
    }

    public static Timestamp[] parseArray(final String[] values) {
        return parseArray(values, DEFAULT_PATTERN);
    }

    public static void main(String[] args) {
        String value = "yyyy-MM-dd HH:mm:ss";
        System.out.println(value.length());
    }

    public static Timestamp[] parseArray(final String[] values, String pattern) {
        if (values == null || values.length == 0) {
            return null;
        }
        if (StringHelper.isEmpty(pattern)) {
            pattern = DEFAULT_PATTERN;
        }
        final SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        final Timestamp[] dates = new Timestamp[values.length];
        for (int i = 0; i < values.length; i++) {
            if (StringHelper.isEmpty(values[i])) {
                continue;
            }
            try {
                dates[i] = new Timestamp(fmt.parse(values[i]).getTime());
            } catch (final ParseException e) {
                dates[i] = null;
            }
        }
        return dates;
    }

    public static String format(final Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    public static String format(final Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (StringHelper.isEmpty(pattern)) {
            pattern = DEFAULT_PATTERN;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.format(date);
        } catch (final IllegalArgumentException e) {
            return "";
        }
    }

}
