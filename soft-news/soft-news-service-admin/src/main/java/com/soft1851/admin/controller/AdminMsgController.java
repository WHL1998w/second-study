package com.soft1851.admin.controller;

import com.soft1851.admin.api.BaseController;
import com.soft1851.admin.api.controller.admin.AdminMsgControllerApi;
import com.soft1851.admin.exception.GraceException;
import com.soft1851.admin.result.GraceResult;
import com.soft1851.admin.result.ResponseStatusEnum;
import com.soft1851.admin.service.AdminUserService;

import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.AdminLoginBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
