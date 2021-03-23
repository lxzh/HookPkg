package com.lxzh123.hooklib.config

class HookConfig implements Serializable{
    public boolean includeFirst = true
    /**
     * hook 类型
     * replace  :方法替换
     * insert   :代码插入
     * wrapper  :实例包装
     * other    :不支持
     */
    public String type = "replace"
    public Map<String, Map<String, List<String>>> include
    public Map<String, Map<String, List<String>>> exclude
    public MethodItem source
    public MethodItem target

    HookConfig() {
        include = new HashMap<>()
        exclude = new HashMap()
        source = new MethodItem()
        target = new MethodItem()
    }

    @Override
    String toString() {
//        return "toString"
        return "ReplaceConfig{" +
                "includeFirst=" + includeFirst +
                ", include=" + include +
                ", exclude=" + exclude +
                ", source=" + source +
                ", target=" + target +
                '}'
    }
}
