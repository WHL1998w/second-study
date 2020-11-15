package com.soft1851.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName
 * @Description HelloControllerApi接口
 * @Author wanghuanle
 * @Date 2020/11/13
 **/
public interface HelloControllerApi {

    /**
     * hello接口
     * @return Object
     */
    @GetMapping("/hello")
    Object hello();
}
