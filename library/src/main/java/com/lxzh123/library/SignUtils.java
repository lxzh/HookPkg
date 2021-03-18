package com.lxzh123.library;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.List;

public class SignUtils {

    public static String getPkgName(Context context) {
        return context.getPackageName();
//        return HookUtils.getPkgName1(context);
    }

    public static String getPkgName(Context context, String param1) {
        return context.getPackageName();
//        return HookUtils.getPkgName1(context);
    }

    public static String getSign(Context context) {
        Signature[] signs = getRawSignature(context);
        if (signs == null || signs.length == 0) {
            return "";
        }
        for (Signature sign : signs) {
            return Md5Utils.md5(sign.toByteArray());
        }
        return "";
    }

    private static Signature[] getRawSignature(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            if (info != null) {
                return info.signatures;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return null;
    }
}
