package com.soft1851.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.article.mapper")
@ComponentScan(basePackages = {"com.soft1851", "org.n3r.idworker"})
public class ArticleApplication {
    public static void main(String[] args) {
        try{
            SpringApplication.run(ArticleApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
