package com.beauty.myweb.common.model;

import com.beauty.myweb.core.utils.ConvertUtil;

import java.util.LinkedHashMap;

public class CommonData extends LinkedHashMap<String,Object>{

    /** 默认值："" */
    public String getAsStr(String key) {
        return getAsStr(key, "");
    }

    public String getAsStr(String key,String defaultValue){
        Object value = this.get(key);
        if(value == null){
            return null;
        }
        String result = ConvertUtil.toStr(value);
        return result == null ? defaultValue : result;
    }
}
