package com.lxzh123.hooklib;

import java.util.List;
import java.util.Map;

import com.ss.android.ugc.bytex.common.BaseExtension;

public class HookExtension extends BaseExtension {
    public Map<String, Map<String, List<String>>> hookPoint;

    @Override
    public String getName() {
        Log.i("HookExtension->getName");
        return "hookPlugin";
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
                '}';
    }
}