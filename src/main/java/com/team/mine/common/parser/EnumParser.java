package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;

import java.lang.reflect.Array;


public class EnumParser {

    public static <E extends Enum<E>> E parse(final Class<E> enumClass,
            final String value) {
        if (StringHelper.isEmpty(value)) {
            return null;
        }
        try {
            return Enum.valueOf(enumClass, value);
        } catch (final IllegalArgumentException localIllegalArgumentException) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <E extends Enum<E>> E[] parseArray(final Class<E> enumClass,
            final String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        final Enum<E>[] es =
                (Enum[]) Array.newInstance(enumClass, values.length);// ����Ƿ���ʵ�ֵ���
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                continue;
            }
            try {
                es[i] = Enum.valueOf(enumClass, values[i]);
                // es[i] = parse(enumClass, values[i]);
            } catch (final IllegalArgumentException e) {
                es[i] = null;
            }
        }
        return (E[]) es;
    }

}
