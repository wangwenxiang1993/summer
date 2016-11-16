package com.qunar.util;

/**
 * Created BY wangwenxiang on 16/5/25.
 */
public class Precondition {

    public static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static void checkAllNotNull(Object... objects) {
        for (Object o : objects) {
            checkNotNull(o);
        }
    }
}
