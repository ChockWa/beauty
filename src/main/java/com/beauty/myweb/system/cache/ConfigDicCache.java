package com.beauty.myweb.system.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.beauty.myweb.core.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.beauty.myweb.system.model.ConfigDic;
import com.beauty.myweb.system.service.ConfigDicService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 字典缓存
 */
public class ConfigDicCache {

    private static final Logger logger = LoggerFactory.getLogger(ConfigDicCache.class);

    /**
     * 初始化列表类型的字典
     */
    private static LoadingCache<String,List<ConfigDic>> listConfigItemCache = CacheBuilder
            .newBuilder()
            .maximumSize(1024)
            .expireAfterWrite(1,TimeUnit.DAYS)
            .build(new CacheLoader<String, List<ConfigDic>>() {
                @Override
                public List<ConfigDic> load(String type) throws Exception {
                    ConfigDicService configDicService = SpringUtil.getBean(ConfigDicService.class);
                    return configDicService.getDicByType(type);
                }
            });

    /**
     * 初始化单个的字典
     */
    private static LoadingCache<String,ConfigDic> configItemCache = CacheBuilder
            .newBuilder()
            .maximumSize(1024)
            .expireAfterWrite(1,TimeUnit.DAYS)
            .build(new CacheLoader<String, ConfigDic>() {
                @Override
                public ConfigDic load(String code) throws Exception {
                    ConfigDicService configDicService = SpringUtil.getBean(ConfigDicService.class);
                    return configDicService.getDicByCode(code);
                }
            });

    /**
     * 获取列表类型的字典
     * @param type
     * @return
     */
    public static List<ConfigDic> getConfigDics(String type){

        if(StringUtils.isBlank(type)){
            return new ArrayList<>();
        }
        try {
            return listConfigItemCache.get(type);
        } catch (ExecutionException e) {
            logger.error("获取字典列表失败,type:{}",type,e);
        }
        return null;
    }

    /**
     * 获取单个类型的字典
     * @param code
     * @return
     */
    public static ConfigDic getConfigDic(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }

        try {
            return configItemCache.get(code);
        } catch (ExecutionException e) {
            logger.error("获取字典失败,code:{}",code,e);
        }
        return null;
    }

    public static void clearListDictCache(String type) {
        listConfigItemCache.invalidate(type);
    }

    public static void clearDictCache(String code) {
        configItemCache.invalidate(code);
    }
}
