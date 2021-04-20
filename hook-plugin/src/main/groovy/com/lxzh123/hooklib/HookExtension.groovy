package com.lxzh123.hooklib

import com.google.gson.Gson
import com.lxzh123.hooklib.config.MethodItem
import com.lxzh123.hooklib.utils.Log
import com.lxzh123.hooklib.config.HookConfig
import com.ss.android.ugc.bytex.common.BaseExtension

class HookExtension extends BaseExtension {

    public Map<String, Map<String, List<String>>> hookPoint

    public HookConfig mHookConfig

    HookExtension() {
        Log.i("HookExtension->HookExtension")
    }

    void hookConfig(String config) {
        Log.i("HookExtension->hookConfig config=${config}")
        try {
            mHookConfig = new Gson().fromJson(config, HookConfig.class)
            Log.i("HookExtension->hookConfig:" + mHookConfig)
        } catch(Exception e) {
            Log.e("HookExtension->hookConfig e:" + e.toString())
            e.printStackTrace()
        }
        if (mHookConfig == null) {
            mHookConfig = new HookConfig()
        }
        if (mHookConfig.include == null) {
            mHookConfig.include = new HashMap<>()
        }
        if (mHookConfig.exclude == null) {
            mHookConfig.exclude = new HashMap()
        }
        if (mHookConfig.source == null) {
            mHookConfig.source = new MethodItem()
        }
        if (mHookConfig.target == null) {
            mHookConfig.target = new MethodItem()
        }
    }

    HookConfig hookConfig() {
        return mHookConfig
    }

    @Override
    public String getName() {
//        Log.i("HookExtension->getName")
        return "hookPlugin"
    }

    @Override
    public String toString() {
        return "HookExtension{" +
                "enable=" + isEnable() +
                ", enableInDebug=" + isEnableInDebug() +
                ", needPreVerify=" + isNeedPreVerify() +
                ", needVerify=" + isNeedVerify() +
                ", shouldSaveCache=" + isShouldSaveCache() +
                ", level=" + getLogLevel() +
                ", logDir=" + getLogDir() +
                ", logFile=" + getLogFile() +
                ", hookPoint=" + hookPoint +
                ", hookConfig=" + mHookConfig +
                '}'
    }
}