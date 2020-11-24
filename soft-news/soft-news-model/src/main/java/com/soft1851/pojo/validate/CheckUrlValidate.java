package com.soft1851.pojo.validate;

import com.soft1851.utils.UrlUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName CheckUrlValidate 校验连接注解
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/11/24
 **/
public class CheckUrlValidate implements ConstraintValidator<CheckUrl,String> {
    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        return UrlUtil.verifyUrl(url.trim());
    }
}