package com.lxzh123.hooklib

import com.lxzh123.hooklib.config.MethodItem
import com.lxzh123.hooklib.utils.TypeUtils
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

import com.lxzh123.hooklib.utils.Log
import com.lxzh123.hooklib.utils.TextUtils

/**
 * @author xc
 * @time 19-2-28.
 */
class HookAdviceAdapter extends AdviceAdapter {

    private MethodItem source
    private MethodItem target

    protected HookAdviceAdapter(int api, MethodVisitor mv, int access, String name, String desc,
                                MethodItem source, MethodItem target) {
        super(api, mv, access, name, desc)
        this.source = source
        this.target = target
        if (source == null || target == null) {
            throw new RuntimeException("invalid configuration source:" + source + ", target:" + target)
        }
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter()
    }

    @Override
    protected void onMethodExit(int i) {
        super.onMethodExit(i)
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        Log.i("HookAdviceAdapter->visitMethodInsn opcode=" + opcode + ", owner=" + owner + ", name=" + name + ", desc=" + descriptor + ", isInterface=" + isInterface)
        if (INVOKEVIRTUAL == opcode || INVOKESTATIC == opcode) {
            if (TextUtils.equals(WhiteLists.classPath(source.cls), owner) && TextUtils.equals(name, source.mth) && TextUtils.equals(descriptor, source.desc)) {
                String desc = null
                if (INVOKEVIRTUAL == opcode) {
                    String paramDesc = TypeUtils.classToSignature(owner)
                    desc = descriptor.replace("(", "(" + paramDesc)
                    if (!TextUtils.equals(desc, target.desc)) {
                        throwException("invalid method description configuration, expect:" + desc + ", actual:" + target.desc)
                    }
                } else {
                    desc = descriptor
                    if (!TextUtils.equals(descriptor, target.desc)) {
                        throwException("invalid method description configuration, expect:" + desc + ", actual:" + target.desc)
                    }
                }
                super.visitMethodInsn(INVOKESTATIC, WhiteLists.classPath(target.cls), target.mth, desc, isInterface)
                return
            }
        }
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface)
    }
}
