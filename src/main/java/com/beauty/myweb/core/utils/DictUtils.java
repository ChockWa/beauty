package com.beauty.myweb.core.utils;

import org.apache.commons.lang3.StringUtils;
import com.beauty.myweb.system.cache.ConfigDicCache;
import com.beauty.myweb.system.model.ConfigDic;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典工具类
 */
public class DictUtils {

    /**
     * 根据字典类型获取字典列表
     * @param type
     * @return
     */
    public static List<ConfigDic> getDicList(String type){
        if (StringUtils.isBlank(type)) return new ArrayList<>();

        return ConfigDicCache.getConfigDics(type);
    }

    /**
     * 根据字典code获取字典
     * @param code
     * @return
     */
    public static ConfigDic getDic(String code){
        if (StringUtils.isBlank(code)) return null;

        return ConfigDicCache.getConfigDic(code);
    }
}
