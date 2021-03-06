package com.beauty.myweb.system.service;

import com.beauty.myweb.core.utils.BeanUtils;
import com.beauty.myweb.core.utils.UuidUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beauty.myweb.system.dto.AccessTokenDto;
import com.beauty.myweb.system.exception.SafeException;
import com.beauty.myweb.system.mapper.AccessTokenMapper;
import com.beauty.myweb.system.model.AccessToken;

import java.util.Date;

@Service
public class AccessTokenService {

    public static final String DEFAULTE_TOKEN_NAME = "accessToken";

    private final static long TOKEN_EXPIRE_TIME = 1 * 24 * 60 * 60; // 会话失效时间(1天).

    @Autowired
    private AccessTokenMapper accessTokenMapper;

    /**
     * 查找accessToken
     * @param accessToken
     * @return
     */
    public AccessTokenDto getAccessToken(String accessToken){
        if(StringUtils.isBlank(accessToken)){
            return null;
        }

        return BeanUtils.copyToNewBean(accessTokenMapper.getByAccessToken(accessToken),AccessTokenDto.class);
    }

    /**
     * 生成token
     * @param userId
     * @return
     */
    public String generateToken(String userId){
        if(null == userId){
            throw SafeException.PARAMS_ERROR;
        }
        accessTokenMapper.deleteByUserId(userId);

        String tokenStr = RandomStringUtils.randomAlphabetic(64);

        AccessToken entity = new AccessToken();
        entity.setUserId(userId);
        entity.setAccessToken(tokenStr);
        entity.setCreateTime(new Date());
        entity.setExpireTime(getExpireTime());
        accessTokenMapper.insert(entity);

        return tokenStr;
    }

    /**
     * 生成token
     * @return
     */
    private String genToken(){
        return UuidUtil.shortUuid() + UuidUtil.shortUuid();
    }

    /**
     * 获取有效时间
     * @return
     */
    public Date getExpireTime() {
        return new Date(System.currentTimeMillis() + (TOKEN_EXPIRE_TIME * 1000));
    }

    /**
     * 通过token获取用户信息
     * @param accessToken
     * @return
     */
//    public User getUserByToken(String accessToken){
//        if(StringUtils.isBlank(accessToken)){
//            return null;
//        }
//
//        return accessTokenMapper.getUserByAccessToken(accessToken);
//    }
}
