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
    public MethodList include
    public MethodList exclude
    public MethodItem source
    public MethodItem target

    HookConfig() {
        include = new MethodList()
        exclude = new MethodList()
        source = new MethodItem()
        target = new MethodItem()
    }
//
//    def methodMissing(String name, def args) {
//        Log.d("ReplaceConfig->methodMissing name=$name args=$args")
//        if (name.equals("include") || name.equals("exclude") || name.equals("source") || name.equals("target")) {
//            Log.d("ReplaceConfig->methodMissing name=$name value=${this.metaPropertyValues.get(name)}")
//            return this.metaPropertyValues.get(name)
//        }
//    }
//
//    def propertyMissing(String name, Object args){
//        Log.d("ReplaceConfig->propertyMissing name=$name args=$args")
//        if(args instanceof Closure) {
//            Closure c = (Closure)args;
//            ConcurrentHashMap map = new ConcurrentHashMap() {
//                Object get(Object key) {
//                    if (!containsKey(key)) {
//                        put(key, null)
//                    }
//                    return super.get(key)
//                }
//            }
//            c.resolveStrategy = Closure.DELEGATE_FIRST
//            c.delegate = map
//            c()
//
//            map.each { key, value ->
//                this.metaClass."${key}" = value
//            }
//        }
//    }

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
