package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

public class ByteParser {

    public static byte parse(final String value) {
        if (StringHelper.isEmpty(value)) {
            return 0;
        }
        byte b = 0;
        try {
            b = Byte.parseByte(value);
        } catch (final NumberFormatException e) {
            return 0;
        }
        return b;
    }

    public static byte[] parseArray(final String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        final byte[] b = new byte[values.length];
        for (int i = 0; i < values.length; i++) {
            try {
                b[i] = Byte.parseByte(values[i]);
            } catch (final NumberFormatException e) {
                b[i] = 0;
            }
        }
        return b;
    }

    public static Byte parseObject(final String value) {
        if (StringHelper.isEmpty(value)) {
            return 0;
        }
        return Byte.valueOf(parse(value));
    }

    public static Byte[] parseObjectArray(final String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        final Byte[] b = new Byte[values.length];
        for (int i = 0; i < values.length; i++) {
            try {
                b[i] = Byte.valueOf(values[i]);
            } catch (final NumberFormatException e) {
                b[i] = 0;
            }
        }
        return b;
    }

}
