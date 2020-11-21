package com.soft1851.user.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @ClassName FansController
 * @Description TODO
 * @Date 2020/11/17
 * @Version 1.0
 **/
@RestController
@RequestMapping("fans")
public class FansController {

    @PostMapping("/follow")
    public String fans() {
        return "fans";
    }
}
