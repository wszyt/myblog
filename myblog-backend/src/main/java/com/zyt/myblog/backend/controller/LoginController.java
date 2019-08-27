package com.zyt.myblog.backend.controller;

import com.zyt.myblog.backend.service.RedisService;
import com.zyt.myblog.backend.utlis.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        if (("173982112").equals (username)) {
            if (("690914236").equals (password)) {
                String token = UUID.randomUUID().toString();
                //todo 后期Redis会使用单独服务进行插入操作时会有返回值以此判断数据是否成功存入数据库
                redisService.setString(username, "ZheGeJiaHuoYiJinDengLuLe", 60 * 60 * 24 * 3L);
                redisService.setString(token, username, 60 * 60 * 24 * 3L);
                request.getSession().setAttribute("token", token);
                //todo 此处时登陆时查询数据库是否存在该用户，存在时加入的缓存，由于为使用数据库暂时现在这里加入
                CookieUtils.setCookie(request,response, "token", token, 60 * 60 * 24 * 3);
                return "redirect:/list";
            }
        }
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession ().invalidate ();
        return "redirect:/login";
    }

}
