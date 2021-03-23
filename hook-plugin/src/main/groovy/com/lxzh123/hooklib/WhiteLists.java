/*
 * Copyright (C) 2017, Megatron King
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.lxzh123.hooklib;

import com.lxzh123.hooklib.utils.Log;
import com.lxzh123.hooklib.utils.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The white list contains some ignored levels. We defined some popular
 * library domains and classes which must be ignored when executing string fog.
 */

final class WhiteLists {

    private static final List<String> CLASS_WHITE_LIST = new ArrayList<>();

    static {
        // default classes short name in white list.
        CLASS_WHITE_LIST.add("BuildConfig");
        CLASS_WHITE_LIST.add("R");
        CLASS_WHITE_LIST.add("R2");
    }

    static boolean inWhiteList(String name) {
        return !TextUtils.isEmpty(name) && checkClass(shortClassName(name));
    }

    private WhiteLists() {
    }

    public static void addWhiteList(String name) {
        if (!CLASS_WHITE_LIST.contains(name)) {
            CLASS_WHITE_LIST.add(name);
        }
    }

    private static boolean checkClass(String name) {
        for (String className : CLASS_WHITE_LIST) {
            if (name.equals(className)) {
                return true;
            }
        }
        return false;
    }

    public static String hasKeyStartWith(String key, Map<String, Object> map) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (key.startsWith(entry.getKey())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String trueClassName(String className) {
        return TextUtils.isEmpty(className) ?
                className :
                className.replace('/', '.');
    }

    public static String classPath(String className) {
        return TextUtils.isEmpty(className) ?
                className :
                className.replace('.', '/');
    }

    public static String shortClassName(String className) {
        String[] spiltArrays = trueClassName(className).split("[.]");
        return spiltArrays[spiltArrays.length - 1];
    }

    public static void printWhiteList(String msg) {
        String[] whiteList = new String[CLASS_WHITE_LIST.size()];
        CLASS_WHITE_LIST.toArray(whiteList);
        Log.v(msg + "" + Arrays.toString(whiteList));
    }
}
