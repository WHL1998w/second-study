package com.soft1851.api.interceptors;

import com.soft1851.exception.GraceException;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.utils.IpUtil;
import com.soft1851.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName
 * @Description 通行证接口拦截器
 * @Author wanghuanle
 * @Date
 **/
public class PassportInterceptor implements HandlerInterceptor {
    @Autowired
    public RedisOperator redis;

    public static final String MOBILE_SMSCODE = "mobile:smscode";

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户ip
        String userIp = IpUtil.getRequestIp(request);
        //检查redis是否存在这个ip
        boolean keyIsExist = redis.keyIsExist(MOBILE_SMSCODE + ":" + userIp);
        if (keyIsExist){
            GraceException.display(ResponseStatusEnum.SMS_NEED_WAIT_ERROR);
            //请求被拦截
            return false;
        }
        //true:请求通过验证。执行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
