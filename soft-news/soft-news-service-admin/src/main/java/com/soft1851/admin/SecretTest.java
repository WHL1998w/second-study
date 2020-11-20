package com.soft1851.admin;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author ：zhengliang
 * @date ：2020/11/20 15:28
 * @description：admin账户密码加密
 */
public class SecretTest {
    public static void main(String[] args) {
        String pwd = BCrypt.hashpw("123123", BCrypt.gensalt());
        System.out.println(pwd);
    }
}
