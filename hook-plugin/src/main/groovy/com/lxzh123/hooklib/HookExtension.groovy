package com.lxzh123.hooklib

import com.google.gson.Gson
import com.lxzh123.hooklib.config.MethodItem
import com.lxzh123.hooklib.config.MethodList
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
            mHookConfig.include = new MethodList()
        }
        if (mHookConfig.exclude == null) {
            mHookConfig.exclude = new MethodList()
        }
        if (mHookConfig.source == null) {
            mHookConfig.source = new MethodItem()
        }
        if (mHookConfig.target == null) {
            mHookConfig.target = new MethodItem()
        }

        HookConfig1 config11 = new HookConfig1()
        config11.include = new HashMap<>()
        List<String> SignUtils = new ArrayList<>()
        SignUtils.add("getPkgName")
        SignUtils.add("getRawSignature")

        List<String> SignUtils1 = new ArrayList<>()
        SignUtils1.add("getPkgName1")
        SignUtils1.add("getRawSignature1")

        Map<String, List<String>> SignUtilsMap = new HashMap<>()
        SignUtilsMap.put("SignUtils", SignUtils)
        SignUtilsMap.put("SignUtils1", SignUtils1)

        Map<String, List<String>> SignUtilsMap1 = new HashMap<>()
        SignUtilsMap1.put("SignUtils1", SignUtils)
        SignUtilsMap1.put("SignUtils2", SignUtils1)

        config11.include.put("com.lxzh123.library", SignUtilsMap)
        config11.include.put("com.lxzh123.library1", SignUtilsMap1)
        Log.i("HookExtension->hookConfig:" + new Gson().toJson(config11))
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