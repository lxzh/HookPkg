package com.lxzh123.hooklib

import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.BaseContext

import org.gradle.api.Project

public class HookContext extends BaseContext<HookExtension> {
    public HookContext(Project project, AppExtension android, HookExtension extension) {
        super(project, android, extension)
        com.lxzh123.hooklib.utils.Log.i("HookContext->HookContext")
    }
}
