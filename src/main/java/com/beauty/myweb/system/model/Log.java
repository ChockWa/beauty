package com.beauty.myweb.system.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@TableName("sys_log")
public class Log implements Serializable {
    private Integer id;

    /**
     * 发生时间
     */
    private Date logTime;

    private String logType;

    private String logDec;

    private String logUser;

    private String logIpAddress;

    private String logUrl;

    /**
     * 操作状态
     */
    private String logStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogDec() {
        return logDec;
    }

    public void setLogDec(String logDec) {
        this.logDec = logDec;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getLogIpAddress() {
        return logIpAddress;
    }

    public void setLogIpAddress(String logIpAddress) {
        this.logIpAddress = logIpAddress;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }
}