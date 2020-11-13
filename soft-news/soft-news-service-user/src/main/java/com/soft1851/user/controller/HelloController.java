package com.soft1851.user.controller;

import com.soft185.api.controller.user.HelloControllerApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description HelloController
 * @Author wanghuanle
 * @Date 2020/11/13
 **/
@RestController
public class HelloController implements HelloControllerApi {


    @Override
    public Object hello() {
        return "hello";
    }
}
