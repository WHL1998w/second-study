package com.soft1851.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author
 * @ClassName RegistLoginBO
 * @Description 注册登录 BO 类
 * @Date 2020/11/16
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistLoginBO {

    /**
     * @NotNull 只校验null值，@NoBlank会同时校验 Null 和 "" 串
     */
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @NotBlank(message = "短信验证码不能为空")
    private String smsCode;
}
