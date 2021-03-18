package com.lxzh123.hooklib

import com.lxzh123.hooklib.config.HookConfig
import com.lxzh123.hooklib.config.MethodItem
import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor

import com.lxzh123.hooklib.utils.Log

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes


/**
 * @author xc
 * @time 19-2-28.
 */
class HookClassAdapter extends BaseClassVisitor {
    private String mClassName
    private MethodItem source
    private MethodItem target

    private HookExtension extension

    HookClassAdapter(HookExtension extension) {
        this.extension = extension
    }

    boolean checkClass(HookConfig hookConfig, String className) {
        int idx = className.indexOf("/")
        String pkg = idx >= 0 ? className.substring(0, idx) : ""
        String name = className.substring(idx >= 0 ? idx : 0)
        if (hookConfig.includeFirst) {
            boolean inPkg = hookConfig.include.pkg.size() == 0
            if(inPkg) {
                if(hookConfig.exclude.pkg.size() != 0) {
                    if(hookConfig.exclude.pkg.contains(pkg)){
                        if(hookConfig.exclude.cls.size() == 0) {
                            return false
                        } else {
                            if(hookConfig.exclude.cls.contains(name)) {
                                return false
                            } else {
                                return true
                            }
                        }
                    } else {
                        return true
                    }
                } else {
                    // 无 exclude 配置
                }
            } else {

            }

        } else {

        }
    }

    @Override
    void visit(int version, int access, String className, String signature, String superName, String[] interfaces) {
        mClassName = className.replace("/", ".")

        source = extension.hookConfig().source
        target = extension.hookConfig().target
        super.visit(version, access, className, signature, superName, interfaces)
        Log.i("HookClassAdapter->visit version=" + version + ", access=" + access + ", className=" + className + ", signature=" + signature + ", superName=" + superName);
    }

    @Override
    public MethodVisitor visitMethod(int access, String methodName, String desc, String signature, String[] exceptions) {
//        if (mMethodNames != null && mMethodNames.containsKey(methodName)) {
//            Log.i("HookClassAdapter->visitMethod extension=" + extension)
////            Log.i("HookClassAdapter->visitMethod mClassName=" + mClassName +", access=" + access + ", methodName=" + methodName + ", desc=" + desc+ ", signature=" + signature)
//            return new HookAdviceAdapter(Opcodes.ASM5,
//                    super.visitMethod(access, methodName, desc, signature, exceptions), access, methodName, desc, source, target)
//        }
        return super.visitMethod(access, methodName, desc, signature, exceptions)
    }
}