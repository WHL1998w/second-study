package com.soft1851.admin.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wanghuanle
 */
@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.user.mapper")
@ComponentScan(basePackages = {"com.soft1851"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
