package com.beauty.myweb.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author duhongg
 * @since 2018-03-02
 */

@Configuration
@MapperScan("com.hdh.redpacket.*.mapper*")
public class MybatisConfig {
}
