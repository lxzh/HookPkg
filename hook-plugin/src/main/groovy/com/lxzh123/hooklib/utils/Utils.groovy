package com.lxzh123.hooklib.utils

import java.util.concurrent.ConcurrentHashMap

class Utils {
    static void hiddenMembers(Closure c, MetaClass metaClass) {
        ConcurrentHashMap map = new HashMap() {
            Object get(Object key) {
                if (!containsKey(key)) {
                    put(key, null)
                }
                return super.get(key)
            }
        }
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c.delegate = map
        c()

        map.each { key, value ->
            metaClass."${key}" = value
        }
    }

    static String parseArgs(def args) {
        StringBuffer buffer = new StringBuffer()
        try {
            for (def arg : args) {
                buffer.append(arg + " ")
            }
        } catch (Throwable t) {}
        return buffer.toString()
    }
}