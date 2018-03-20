package com.beauty.myweb.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.beauty.myweb.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.beauty.myweb.system.model.AccessToken;

@Mapper
public interface AccessTokenMapper extends BaseMapper<AccessToken> {

    AccessToken getByAccessToken(@Param("accessToken") String accessToken);

    int deleteByUserId(String userId);

    User getUserByAccessToken(@Param("accessToken") String accessToken);
}
