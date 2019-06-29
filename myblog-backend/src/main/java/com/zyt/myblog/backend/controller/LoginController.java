package com.zyt.myblog.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request) {
        if (("173982112").equals (username)) {
            if (("690914236").equals (password)) {
                request.getSession ().setAttribute ("isLogin", "logged");
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
