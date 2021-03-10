package com.lxzh123.hooklib;

import com.ss.android.ugc.bytex.common.log.LevelLog;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

import java.util.Arrays;
import java.util.List;

/**
 * @author xc
 * @time 19-2-28.
 */
public class HookAdviceAdapter extends AdviceAdapter {

    private List<String> mReplaceMethod;

    protected HookAdviceAdapter(int api, MethodVisitor mv, int access, String name, String desc, List<String> replaceMethod) {
        super(api, mv, access, name, desc);
        this.mReplaceMethod = replaceMethod;
        if (mReplaceMethod == null || mReplaceMethod.size() != 3) {
            throw new RuntimeException("invalid method configuration:" + mReplaceMethod == null ? "null" : Arrays.toString(mReplaceMethod.toArray()));
        }
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
    }

    @Override
    protected void onMethodExit(int i) {
        super.onMethodExit(i);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {

        System.out.println("HookAdviceAdapter->visitMethodInsn opcode=" + opcode + ", owner=" + owner + ", name=" + name + ", desc=" + descriptor + ", isInterface=" + isInterface);
        if (INVOKEVIRTUAL == opcode) {
//            System.out.println("HookAdviceAdapter->visitMethodInsn owner=" + owner + ", name=" + name + ", desc=" + descriptor + ", isInterface=" + isInterface);
            super.visitMethodInsn(INVOKESTATIC, mReplaceMethod.get(0).replace(".", "/"), mReplaceMethod.get(1), mReplaceMethod.get(2), isInterface);
        } else {
            super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
        }
    }
}
