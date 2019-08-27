package com.zyt.myblog.backend.interceptor;

import com.zyt.myblog.backend.service.RedisService;
import com.zyt.myblog.backend.utlis.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackendInterceptor implements HandlerInterceptor {

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String isLogin = (String) request.getSession().getAttribute("token");

        // 在当前会话用户已经登陆
        if (StringUtils.isNotBlank(isLogin)) {
            return true;
        }

        // 从redis查询用户是否已经登陆
        String cookieValue = CookieUtils.getCookieValue(request, "token");
        System.out.println("-------------------");
        if (StringUtils.isNotBlank(cookieValue)) {
            String username = redisService.getString(cookieValue);
            if (StringUtils.isNotBlank(username)) {
                String result = redisService.getString(username);
                //todo 此处时登陆时查询数据库是否存在该用户，存在时加入的缓存
                if (StringUtils.isNotBlank(result)) {
                    request.getSession ().setAttribute ("token", result);
                    return true;
                }
            }
        }

        response.sendRedirect("/login");
        return false;

        //        if (isLogin == null) {
//            response.sendRedirect ("/login");
//            return false;
//        }
//
//        return true;
    }
}
