package com.lxzh123.hooklib.config

class MethodItem implements Serializable{
    public String cls;
    public String mth;
    public String desc;

//    def methodMissing(String name, def args) {
//        Log.d("MethodItem->methodMissing name=$name args=${Util.parseArgs(args)}")
//    }
//
////    def propertyMissing(String name, Object args){
////        Log.d("MethodItem->propertyMissing name=$name args=$args")
////    }
//
//    def propertyMissing(String name, Object args){
//        Log.d("MethodItem->propertyMissing name=$name args=${Util.parseArgs(args)}")
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
        return "MethodItem{" +
                "cls='" + cls + '\'' +
                ", mth='" + mth + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
