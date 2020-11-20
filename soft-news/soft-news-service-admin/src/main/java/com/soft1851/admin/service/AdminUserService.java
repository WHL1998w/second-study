package com.soft1851.admin.service;

import com.soft1851.pojo.AdminUser;

/**
 * @author ：wanghuanle
 * @date ：2020/11/20 15:47
 * @description：TODO
 */
public interface AdminUserService {


    /**
     * 获得管理员信息
     * @param username 用户名
     * @return AdminUser
     */

    AdminUser queryAdminByUsername(String username);
}