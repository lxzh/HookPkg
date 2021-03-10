package com.lxzh123.hooklib;

import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

import com.android.build.gradle.AppExtension;
import com.ss.android.ugc.bytex.common.CommonPlugin;
import com.ss.android.ugc.bytex.common.TransformConfiguration;
import com.ss.android.ugc.bytex.common.visitor.ClassVisitorChain;
import com.ss.android.ugc.bytex.transformer.TransformEngine;

import javax.annotation.Nonnull;

public class HookPlugin extends CommonPlugin<HookExtension, HookContext> {

    static {
        Log.i("HookPlugin->static");
    }

    @Override
    protected HookContext getContext(Project project, AppExtension android, HookExtension extension) {
        Log.i("HookPlugin->getContext extension=" + extension);
        super.extension = extension;
        return new HookContext(project, android, extension);
    }

    @Override
    public void beforeTransform(@Nonnull @NotNull TransformEngine engine) {
        super.beforeTransform(engine);
        Log.i("HookPlugin->beforeTransform engine=" + engine);
    }

    @Override
    public boolean transform(@Nonnull String relativePath, @Nonnull ClassVisitorChain chain) {
        Log.i("HookPlugin->transform relativePath=" + relativePath + ", extension=" + extension);
        chain.connect(new HookClassAdapter(extension));
        return super.transform(relativePath, chain);
    }

    @Nonnull
    @Override
    public TransformConfiguration transformConfiguration() {
        Log.i("HookPlugin->transformConfiguration");
        return new TransformConfiguration() {
            @Override
            public boolean isIncremental() {
                //插件默认是增量的，如果插件不支持增量，需要返回false
                //The plugin is incremental by default.It should return false if incremental is not supported by the plugin
                return true;
            }
        };
    }
}