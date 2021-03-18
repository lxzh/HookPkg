package com.lxzh123.library;

import com.lxzh123.hookpkg.TargetHook;
import com.lxzh123.library.TargetClass.TargetSub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Replace {
    public void test(TargetClass tar) {
        TargetHook.getAAA(tar);

        String ver = "";
        TargetHook.getAAA(tar, ver);

        int i = 100;
        TargetHook.getAAA(tar, ver, i);

        List<String> list = new ArrayList<>();
        TargetHook.getAAA(tar, ver, i, list);

        List<String[]> list1 = new ArrayList<>();
        TargetHook.getAAA(tar, ver, i, list, list1);

        String[] array = new String[0];
        TargetHook.getAAA(tar, ver, i, list, array);

        TargetSub sub = new TargetSub();
        TargetHook.getAAA(tar, ver, i, list, sub);

        TargetSub[] subs = new TargetSub[0];
        TargetHook.getAAA(tar, ver, i, list, subs);

        Map<TargetSub, String> map = new HashMap<>();
        TargetHook.getAAA(tar, ver, i, list, map);

        String ver1 =                   TargetHook.getCCC(tar);
        int i1 =                        TargetHook.getCCC(tar, ver);
        float f1 =                      TargetHook.getCCC(tar, ver, i);
        List<String> list11 =           TargetHook.getCCC(tar, ver, i, list);
        List<String[]> list22 =         TargetHook.getCCC(tar, ver, i, list, list1);
        String[] array11 =              TargetHook.getCCC(tar, ver, i, list, array);
        TargetSub sub1 =                TargetHook.getCCC(tar, ver, i, list, sub);
        TargetSub[] subs1 =             TargetHook.getCCC(tar, ver, i, list, subs);
        Map<TargetSub, String> map1 =   TargetHook.getCCC(tar, ver, i, list, map);

                                        TargetHook.getBBB();
                                        TargetHook.getBBB(ver);
                                        TargetHook.getBBB(ver, i);
                                        TargetHook.getBBB(ver, i, list);
                                        TargetHook.getBBB(ver, i, list, list1);
                                        TargetHook.getBBB(ver, i, list, array);
                                        TargetHook.getBBB(ver, i, list, sub);
                                        TargetHook.getBBB(ver, i, list, subs);
                                        TargetHook.getBBB(ver, i, list, map);


        String ver2 =                   TargetHook.getDDD();
        int i2 =                        TargetHook.getDDD(ver);
        float f2 =                      TargetHook.getDDD(ver, i);
        List<String> list12 =           TargetHook.getDDD(ver, i, list);
        List<String[]> list23 =         TargetHook.getDDD(ver, i, list, list1);
        String[] array12 =              TargetHook.getDDD(ver, i, list, array);
        TargetSub sub2 =                TargetHook.getDDD(ver, i, list, sub);
        TargetSub[] subs2 =             TargetHook.getDDD(ver, i, list, subs);
        Map<TargetSub, String> map2 =   TargetHook.getDDD(ver, i, list, map);
    }
}
