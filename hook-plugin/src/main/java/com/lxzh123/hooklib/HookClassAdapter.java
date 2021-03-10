package com.lxzh123.hooklib;

import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

/**
 * @author xc
 * @time 19-2-28.
 */
class HookClassAdapter extends BaseClassVisitor {
    private String mClassName;
    private Map<String, List<String>> mMethodNames;

    private HookExtension extension;

    public HookClassAdapter(HookExtension extension) {
        this.extension = extension;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        mClassName = name.replace("/", ".");
        mMethodNames = extension.hookPoint.get(mClassName);
        super.visit(version, access, name, signature, superName, interfaces);
//        Log.i("HookClassAdapter->visit version=" + version + ", access=" + access + ", name=" + name + ", signature=" + signature + ", superName=" + superName);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (mMethodNames != null && mMethodNames.containsKey(name)) {
            Log.i("HookClassAdapter->visitMethod mClassName=" + mClassName +", access=" + access + ", name=" + name + ", desc=" + desc+ ", signature=" + signature);
            return new HookAdviceAdapter(Opcodes.ASM5,
                    super.visitMethod(access, name, desc, signature, exceptions), access, name, desc, mMethodNames.get(name));
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}