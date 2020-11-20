package com.soft1851.admin.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ClassName
 * @Description 跨域配置类
 * @Author wanghuanle
 * @Date
 **/
@Configuration
public class CoresConfig {

    public CoresConfig(){
    }

    @Bean
    public CorsFilter CorsFilter(){
        //1.添加cors配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        //设置是否发送cookie信息
        configuration.setAllowCredentials(true);
        //设置允许请求的方式
        configuration.addAllowedMethod("*");
        //设置允许请求的头
        configuration.addAllowedHeader("*");
        //2.为url添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",configuration);
        //3.返回重新定义好的corsConfigurationSource
        return new CorsFilter(corsConfigurationSource);
    }
}
