package com.lxzh123.hooklib

import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.CommonPlugin
import com.ss.android.ugc.bytex.common.IPlugin
import com.ss.android.ugc.bytex.common.TransformConfiguration
import com.ss.android.ugc.bytex.common.builder.ByteXBuildListener
import com.ss.android.ugc.bytex.common.flow.TransformFlow
import com.ss.android.ugc.bytex.common.flow.main.MainProcessHandler
import com.ss.android.ugc.bytex.common.visitor.ClassVisitorChain
import com.ss.android.ugc.bytex.transformer.TransformEngine

import com.lxzh123.hooklib.utils.Log

import org.gradle.api.Project
import org.jetbrains.annotations.NotNull

import javax.annotation.Nonnull
import javax.annotation.Nullable

public class HookPlugin extends CommonPlugin<HookExtension, HookContext> implements ByteXBuildListener {

    static {
        Log.i("HookPlugin->static")
    }

    @Override
    protected HookContext getContext(Project project, AppExtension android, HookExtension extension) {
        Log.i("HookPlugin->getContext extension=" + extension)
        super.extension = extension
//        ByteXBuildListenerManager.INSTANCE.registerByteXBuildListener(this)
        return new HookContext(project, android, extension)
    }

    @Override
    public void beforeTransform(@Nonnull @NotNull TransformEngine engine) {
        super.beforeTransform(engine)
        Log.i("HookPlugin->beforeTransform engine=" + engine)
    }

    @Override
    public boolean transform(@Nonnull String relativePath, @Nonnull ClassVisitorChain chain) {
//        Log.i("HookPlugin->transform relativePath=" + relativePath + ", extension=" + extension)
        chain.connect(new HookClassAdapter(extension))
        return super.transform(relativePath, chain)
    }

    @Nonnull
    @Override
    public TransformConfiguration transformConfiguration() {
        Log.i("HookPlugin->transformConfiguration")
        return new TransformConfiguration() {
            @Override
            public boolean isIncremental() {
                //插件默认是增量的，如果插件不支持增量，需要返回false
                //The plugin is incremental by default.It should return false if incremental is not supported by the plugin
                return true
            }
        };
    }

    @Override
    public void onByteXPluginApply(Project project, IPlugin plugin) {
        Log.i("HookPlugin->onByteXPluginApply")
    }

    @Override
    public void onByteXPluginApplied(IPlugin plugin) {
        Log.i("HookPlugin->onByteXPluginApplied")
    }

    @Override
    public void onProjectBuildStart(Project project) {
        Log.i("HookPlugin->onProjectBuildStart")
    }

    @Override
    public void onByteXPluginTransformStart(Transform transform, TransformInvocation transformInvocation) {
        Log.i("HookPlugin->onByteXPluginTransformStart")
    }

    @Override
    public void onByteXPluginStart(IPlugin plugin) {
        Log.i("HookPlugin->onByteXPluginStart")
    }

    @Override
    public void onByteXPluginFinished(IPlugin plugin) {
        Log.i("HookPlugin->onByteXPluginFinished")
    }

    @Override
    public void onByteXPluginTransformFinished(Transform transform, @Nullable Exception exception) {
        Log.i("HookPlugin->onByteXPluginTransformFinished")
    }

    @Override
    public void onProjectBuildFinished(Project project, @Nullable Throwable throwable) {
        Log.i("HookPlugin->onProjectBuildFinished")
    }

    @Override
    public void onAppendMainProcessHandler(TransformFlow transformFlow, MainProcessHandler handler) {

    }

    @Override
    public void startPrepare(@Nonnull TransformFlow transformFlow) {

    }

    @Override
    public void finishPrepare(@Nonnull TransformFlow transformFlow, @Nullable Exception exception) {

    }

    @Override
    public void startRunning(@Nonnull TransformFlow transformFlow, boolean isIncremental) {

    }

    @Override
    public void finishRunning(@Nonnull TransformFlow transformFlow, @Nullable Exception exception) {

    }
}