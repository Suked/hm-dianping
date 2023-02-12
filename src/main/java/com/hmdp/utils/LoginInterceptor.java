package com.hmdp.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /** 获取ThreadLocal对象，如果不为空则说明有用户登录，直接放行，否则拦截 */
        if (UserHolder.getUser() == null) {
            response.setStatus(401);
            return false;
        }

        return true;
    }

}
