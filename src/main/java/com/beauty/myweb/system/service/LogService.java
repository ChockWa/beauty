package com.beauty.myweb.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beauty.myweb.system.mapper.LogMapper;
import com.beauty.myweb.system.model.Log;

@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 记录请求日志
     * @param log
     */
    public void addRequestLog(Log log){
        if(log == null){
            return;
        }

        logMapper.insert(log);
    }

}
