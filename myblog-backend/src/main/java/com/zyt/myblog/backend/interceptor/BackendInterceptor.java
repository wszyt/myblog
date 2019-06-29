package com.zyt.myblog.backend.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackendInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String isLogin = (String) request.getSession ().getAttribute ("isLogin");

        if (isLogin == null) {
            response.sendRedirect ("/login");
            return false;
        }

        return true;
    }
}
