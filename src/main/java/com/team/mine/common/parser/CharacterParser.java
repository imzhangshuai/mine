package com.team.mine.common.parser;

import com.team.mine.common.StringHelper;


public class CharacterParser {
    public static char parse(final String value) {
        if (StringHelper.isEmpty(value)) {
            return '\000';
        }
        return value.charAt(0);
    }

    public static char[] parseArray(final String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        final char[] as = new char[values.length];
        for (int i = 0; i < values.length; i++) {
            if (StringHelper.isEmpty(values[i])) {
                continue;
            }
            as[i] = values[i].charAt(0);
        }
        return as;
    }

    public static Character parseObject(final String value) {
        if (StringHelper.isEmpty(value)) {
            return '\000';
        }
        return Character.valueOf(parse(value));
    }

    public static Character[] parseObjectArray(final String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        final Character[] as = new Character[values.length];
        for (int i = 0; i < values.length; i++) {
            as[i] = Character.valueOf(parse(values[i]));
        }
        return as;
    }

}
