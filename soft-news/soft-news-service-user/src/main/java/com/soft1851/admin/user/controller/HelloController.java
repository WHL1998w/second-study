package com.soft1851.admin.user.controller;

import com.soft1851.admin.api.controller.user.HelloControllerApi;
import com.soft1851.admin.result.GraceResult;
import com.soft1851.admin.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description HelloController
 * @Author wanghuanle
 * @Date 2020/11/13
 **/
@RestController
@Slf4j
public class HelloController implements HelloControllerApi {

    @Autowired
    private RedisOperator redis;
    @Override
    public Object hello() {
        log.info("info:hello");
        return GraceResult.ok("hello");

    }

    @GetMapping("/redis")
    public GraceResult redis(){
        redis.set("age","20");
        return GraceResult.ok(redis.get("age"));
    }
}
