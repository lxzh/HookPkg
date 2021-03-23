package com.lxzh123.hooklib

import com.lxzh123.hooklib.config.HookConfig
import com.lxzh123.hooklib.config.MethodItem
import com.lxzh123.hooklib.utils.TextUtils
import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor

import com.lxzh123.hooklib.utils.Log

import org.objectweb.asm.MethodVisitor


/**
 * @author xc
 * @time 19-2-28.
 */
class HookClassAdapter extends BaseClassVisitor {
    private String mClassName
    private MethodItem source
    private MethodItem target

    private HookExtension extension
    private List<String> includeMethods
    private List<String> excludeMethods

    HookClassAdapter(HookExtension extension) {
        this.extension = extension
    }

    boolean checkInclude(HookConfig hookConfig, String pkg, String name) {
        if(hookConfig.include.size()==0) {
            return true
        }
        String key = WhiteLists.hasKeyStartWith(pkg, hookConfig.include)
        if (TextUtils.isEmpty(key)) {           // include 里不包含当前包名
            return false
        } else {                                // include 里包含当前包名
            Map<String, List<String>> classes = hookConfig.include.get(key)
            if (classes.size() == 0) {          // classes 为空，当前包下所有 class 通行
                return true
            } else {
                if (classes.containsKey(name)) {// include 指定 package 下包含指定 class
                    includeMethods = classes.get(name)
                    return true                 // 先通行，后续判断 method
                } else {                        // include 指定 package 下不包含指定 class
                    return false
                }
            }
        }
    }

    boolean checkExclude(HookConfig hookConfig, String pkg, String name) {
        if(hookConfig.exclude.size() == 0) {
            return false
        }
        String key = WhiteLists.hasKeyStartWith(pkg, hookConfig.exclude)
        if (TextUtils.isEmpty(key)) {           // exclude 里不包含当前包名
            return false
        } else {
            Map<String, List<String>> classes = hookConfig.exclude.get(key)
            if (classes.size() == 0) {          // exclude 指定 package 下不包含指定 class
                return false
            } else {
                if (classes.containsKey(name)) {// exclude 指定 package 下包含指定 class
                    excludeMethods = classes.get(name)
                    return true                 // 先通行，后续判断 method
                } else {                        // exclude 指定 package 下不包含指定 class
                    return false
                }
            }
        }
    }

    boolean checkClass(HookConfig hookConfig, String className) {
        int idx = className.indexOf("/")
        String pkg = idx >= 0 ? className.substring(0, idx) : ""
        String name = className.substring(idx >= 0 ? idx : 0)

        if (hookConfig.exclude.size() == 0) {
            return checkInclude(hookConfig, pkg, name)
        } else {
            if (hookConfig.include.size() == 0) {
                return checkExclude(hookConfig, pkg, name)
            } else {
                return checkInclude(hookConfig, pkg, name) && checkExclude(hookConfig, pkg, name);
            }
        }

//        if (hookConfig.includeFirst) {
//            if (hookConfig.include.size() == 0) {
//                if (hookConfig.exclude.size() == 0) {
//                    return true
//                } else {
//                    String key = WhiteLists.hasKeyStartWith(pkg, hookConfig.exclude)
//                    if (TextUtils.isEmpty(key)) { // exclude 里不包含当前包名
//                        return true
//                    } else {
//                        Map<String, List<String>> classes = hookConfig.exclude.get(key)
//                        if (classes.size() == 0) { // exclude 指定 package 下不包含指定 class
//                            return true
//                        } else {
//                            if (classes.containsKey(name)) { // exclude 指定 package 下包含指定 class
//                                excludeMethods = classes.get(name)
//                                return true    // 先通行，后续判断 method
//                            } else {                        // exclude 指定 package 下不包含指定 class
//                                return true
//                            }
//                        }
//                    }
//                }
//            } else {
//                String key = WhiteLists.hasKeyStartWith(pkg, hookConfig.include)
//                if (TextUtils.isEmpty(key)) {        // include 里包含当前包名
//                    Map<String, List<String>> classes = hookConfig.include.get(key)
//                    if (classes.size() == 0) {       // classes 为空，当前包下所有 class 通行
//                        return true
//                    } else {
//                        if (classes.containsKey(name)) { // include 指定 package 下包含指定 class
//                            includeMethods = classes.get(name)
//                            return true     // 先通行，后续判断 method
//                        } else {                         // include 指定 package 下不包含指定 class
//                            return false
//                        }
//                    }
//                }
//
//
//                if (hookConfig.exclude.size() == 0) {
//
//                } else {
//
//                }
//            }
//
//        } else {
//
//        }
    }

    @Override
    void visit(int version, int access, String className, String signature, String superName, String[] interfaces) {
        mClassName = className.replace("/", ".")
        if (checkClass(extension.hookConfig(), mClassName)) {
            source = extension.hookConfig().source
            target = extension.hookConfig().target
        }
        super.visit(version, access, className, signature, superName, interfaces)
        Log.i("HookClassAdapter->visit version=" + version + ", access=" + access + ", className=" + className + ", signature=" + signature + ", superName=" + superName);
    }

    @Override
    public MethodVisitor visitMethod(int access, String methodName, String desc, String signature, String[] exceptions) {
        if (includeMethods == null || includeMethods.contains(methodName)) {
            if(excludeMethods == null || !excludeMethods.contains(methodName)) {
                return new HookAdviceAdapter(Opcodes.ASM5,
                    super.visitMethod(access, methodName, desc, signature, exceptions), access, methodName, desc, source, target)
            }
        }
//        if (mMethodNames != null && mMethodNames.containsKey(methodName)) {
//            Log.i("HookClassAdapter->visitMethod extension=" + extension)
////            Log.i("HookClassAdapter->visitMethod mClassName=" + mClassName +", access=" + access + ", methodName=" + methodName + ", desc=" + desc+ ", signature=" + signature)
//            return new HookAdviceAdapter(Opcodes.ASM5,
//                    super.visitMethod(access, methodName, desc, signature, exceptions), access, methodName, desc, source, target)
//        }
        return super.visitMethod(access, methodName, desc, signature, exceptions)
    }
}