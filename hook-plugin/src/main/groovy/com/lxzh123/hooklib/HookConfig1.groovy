package com.lxzh123.hooklib

import com.lxzh123.hooklib.config.MethodItem

class HookConfig1 implements Serializable {
    public Map<String, Map<String, List<String>>> include
    public Map<String, Map<String, List<String>>> exclude
    public MethodItem source
    public MethodItem target


}