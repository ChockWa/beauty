package com.beauty.myweb.common.config;

import com.beauty.myweb.common.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public CommonInterceptor commonInterceptor(){
        return new CommonInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(commonInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
