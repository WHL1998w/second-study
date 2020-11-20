package com.soft1851.admin.controller;

import com.soft1851.admin.api.BaseController;
import com.soft1851.admin.api.controller.admin.AdminMsgControllerApi;
import com.soft1851.admin.exception.GraceException;
import com.soft1851.admin.result.GraceResult;
import com.soft1851.admin.result.ResponseStatusEnum;
import com.soft1851.admin.service.AdminUserService;

import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.AdminLoginBO;

import com.soft1851.pojo.bo.NewAdminBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author ：wanghuanle
 * @date ：2020/11/20 17:02
 * @description：TODO
 */
@RestController
public class AdminMsgController extends BaseController implements
        AdminMsgControllerApi {
    @Autowired
    private AdminUserService adminUserService;

    @Override
    public GraceResult adminLogin(AdminLoginBO adminLoginBO, HttpServletRequest request, HttpServletResponse response) {
        AdminUser admin = adminUserService.queryAdminByUsername(adminLoginBO.getUsername());
        if (admin == null) {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_NOT_EXIT_ERROR);
        }
//        判断密码是否匹配
        boolean isPwdMatch = BCrypt.checkpw(adminLoginBO.getPassword(), admin.getPassword());
        if (isPwdMatch) {
            doLoginSettings(admin, request, response);
            return GraceResult.ok();
        } else {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_NOT_EXIT_ERROR);
        }

    }

    @Override
    public GraceResult adminIsExist(String username) {
        checkAdminExist(username);
        return GraceResult.ok();
    }

    @Override
    public GraceResult addNewAdmin(HttpServletRequest request, HttpServletResponse response, NewAdminBO newAdminBO) {
        //        base64不为空，则代表人脸入库，否则需要用户输入密码和确认
        if (StringUtils.isBlank(newAdminBO.getImg64())){
            if (StringUtils.isBlank(newAdminBO.getPassword()) ||
                    StringUtils.isBlank(newAdminBO.getConfirmPassword())){
                return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_PASSWORD_NULL_ERROR);
            }
        }
//        密码不为空，则必须判断两次输入一致
        if (StringUtils.isNotBlank(newAdminBO.getPassword())){
            if (!newAdminBO.getPassword()
                    .equalsIgnoreCase(newAdminBO.getConfirmPassword())){
                return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_PASSWORD_ERROR);
            }
        }
//        校验用户名唯一
        checkAdminExist(newAdminBO.getUsername());
//        调用service存入admin信息
        adminUserService.createAdminUser(newAdminBO);
        return GraceResult.ok();
    }

    /**
     * 验证管理员账号唯一
     * @param username
     */
    private void  checkAdminExist(String username){
        AdminUser admin = adminUserService.queryAdminByUsername(username);

        if (admin != null){
            GraceException.display(ResponseStatusEnum.ADMIN_USERNAME_EXIST_ERROR);
        }
    }

    /**
     * 用于admin用户登录过后的基本信息设置
     * @param admin
     * @param request
     * @param response
     */
    private void doLoginSettings(AdminUser admin,HttpServletRequest request,HttpServletResponse response){
//        保留token放到redis
        String token = UUID.randomUUID().toString();
        redis.set(REDIS_ADMIN_TOKEN + ":" + admin.getId(),token);
//        保存admin登录基本token信息到cookie中
        setCookie(request,response,"aToken",token,COOKIE_MONTH);
        setCookie(request,response,"aId",admin.getId(),COOKIE_MONTH);
        setCookie(request,response,"aName",admin.getAdminName(),COOKIE_MONTH);
    }
}
