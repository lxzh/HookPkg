package com.lxzh123.hooklib.config

class MethodList implements Serializable{
    public List<String> pkg;
    public List<String> cls;
    public List<String> mth;

    MethodList() {
        pkg = new ArrayList<>()
        cls = new ArrayList<>()
        mth = new ArrayList<>()
    }
//    def methodMissing(String name, def args) {
//        Log.d("MethodList->methodMissing name=$name args=$args")
//    }
//
////    def propertyMissing(String name, Object args){
////        Log.d("MethodList->propertyMissing name=$name args=$args")
////    }
//
//    def propertyMissing(String name, Object args){
//        Log.d("MethodList->propertyMissing name=$name args=$args")
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
        return "MethodList{" +
                "pkg=" + (pkg == null ? null : Arrays.toString(pkg.toArray())) +
                ", cls=" + (cls == null ? null : Arrays.toString(cls.toArray())) +
                ", mth=" + (mth == null ? null : Arrays.toString(mth.toArray())) +
                '}'
    }
}
