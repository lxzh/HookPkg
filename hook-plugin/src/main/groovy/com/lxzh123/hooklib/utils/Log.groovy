package com.lxzh123.hooklib.utils

import com.lxzh123.hooklib.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;

    private static final String V = "V";
    private static final String D = "D";
    private static final String I = "I";
    private static final String W = "W";
    private static final String E = "E";
    private static final String N = "N";

    private static int LEVEL = VERBOSE;
    private static final String DEFAULT_TAG = Constants.TAG;
    private static String TAG = DEFAULT_TAG;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private static boolean isEnable = false;

    public static void init(int level) {
        LEVEL = level;
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void fe(String msg) {
        fe(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            log(V, tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            log(D, tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            log(I, tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            log(W, tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR) {
            log(E, tag, msg);
        }
    }

    public static void fe(String tag, String msg) {
        log(E, tag, msg);
    }

    private static void log(String level, String tag, String msg) {
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        sb.append(sdf.format(date));
        sb.append(" >>> ");
        sb.append(tag);
        sb.append(" [");
        sb.append(level);
        sb.append("] ");
        sb.append(msg);
        System.out.println(sb.toString());
    }
}
