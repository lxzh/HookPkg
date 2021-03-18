package com.lxzh123.library;

import com.lxzh123.library.TargetClass.TargetSub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Target {
    public void test(TargetClass tar) {
        tar.getAAA();

        String ver = "";
        tar.getAAA(ver);

        int i = 100;
        tar.getAAA(ver, i);

        List<String> list = new ArrayList<>();
        tar.getAAA(ver, i, list);

        List<String[]> list1 = new ArrayList<>();
        tar.getAAA(ver, i, list, list1);

        String[] array = new String[0];
        tar.getAAA(ver, i, list, array);

        TargetSub sub = new TargetSub();
        tar.getAAA(ver, i, list, sub);

        TargetSub[] subs = new TargetSub[0];
        tar.getAAA(ver, i, list, subs);

        Map<TargetSub, String> map = new HashMap<>();
        tar.getAAA(ver, i, list, map);

        String ver1 =                   tar.getCCC();
        int i1 =                        tar.getCCC(ver);
        float f1 =                      tar.getCCC(ver, i);
        List<String> list11 =           tar.getCCC(ver, i, list);
        List<String[]> list22 =         tar.getCCC(ver, i, list, list1);
        String[] array11 =              tar.getCCC(ver, i, list, array);
        TargetSub sub1 =                tar.getCCC(ver, i, list, sub);
        TargetSub[] subs1 =             tar.getCCC(ver, i, list, subs);
        Map<TargetSub, String> map1 =   tar.getCCC(ver, i, list, map);

                                        TargetClass.getBBB();
                                        TargetClass.getBBB(ver);
                                        TargetClass.getBBB(ver, i);
                                        TargetClass.getBBB(ver, i, list);
                                        TargetClass.getBBB(ver, i, list, list1);
                                        TargetClass.getBBB(ver, i, list, array);
                                        TargetClass.getBBB(ver, i, list, sub);
                                        TargetClass.getBBB(ver, i, list, subs);
                                        TargetClass.getBBB(ver, i, list, map);


        String ver2 =                   TargetClass.getDDD();
        int i2 =                        TargetClass.getDDD(ver);
        float f2 =                      TargetClass.getDDD(ver, i);
        List<String> list12 =           TargetClass.getDDD(ver, i, list);
        List<String[]> list23 =         TargetClass.getDDD(ver, i, list, list1);
        String[] array12 =              TargetClass.getDDD(ver, i, list, array);
        TargetSub sub2 =                TargetClass.getDDD(ver, i, list, sub);
        TargetSub[] subs2 =             TargetClass.getDDD(ver, i, list, subs);
        Map<TargetSub, String> map2 =   TargetClass.getDDD(ver, i, list, map);
    }
}
