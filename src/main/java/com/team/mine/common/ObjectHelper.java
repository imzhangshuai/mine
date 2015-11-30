package com.team.mine.common;

public class ObjectHelper {

    @SuppressWarnings("unchecked")
    public static <T> T convert(final Object object, final Class<T> type) {
        if (object == null || type == null) {
            return null;
        }
        if (type.isAssignableFrom(object.getClass())) {
            return (T) object;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[]
            convertArray(final Object object, final Class<T> type) {
        if (object == null || type == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray() && type == objectClass.getComponentType()) {
            return (T[]) object;
        }
        return null;
    }

    public static int[] convertIntArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Integer.TYPE == objectClass.getComponentType()) {
            return (int[]) object;
        }
        return null;
    }

    public static float[] convertFloatArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Float.TYPE == objectClass.getComponentType()) {
            return (float[]) object;
        }
        return null;
    }

    public static double[] convertDoubleArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Double.TYPE == objectClass.getComponentType()) {
            return (double[]) object;
        }
        return null;
    }

    public static short[] convertShortArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Short.TYPE == objectClass.getComponentType()) {
            return (short[]) object;
        }
        return null;
    }

    public static long[] convertLongArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Long.TYPE == objectClass.getComponentType()) {
            return (long[]) object;
        }
        return null;
    }

    public static boolean[] convertBooleanArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Boolean.TYPE == objectClass.getComponentType()) {
            return (boolean[]) object;
        }
        return null;
    }

    public static byte[] convertByteArray(final Object object) {
        if (object == null) {
            return null;
        }
        final Class<?> objectClass = object.getClass();
        if (objectClass.isArray()
                && Byte.TYPE == objectClass.getComponentType()) {
            return (byte[]) object;
        }
        return null;
    }
}
