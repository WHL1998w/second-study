package com.soft1851.admin.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName
 * @Description 启动主类
 * @Author wanghuanle
 * @Date 2020/11/13
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.user.mapper")
@ComponentScan(basePackages = {"com.soft1851","org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}